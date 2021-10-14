package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.strategy.ActionTile
import xyz.qwewqa.relive.simulator.core.stage.strategy.BoundCutin
import xyz.qwewqa.relive.simulator.core.stage.strategy.IdleTile
import xyz.qwewqa.relive.simulator.core.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.random.Random

class Stage(
    val player: Team,
    val enemy: Team,
    val damageCalculator: DamageCalculator = RandomDamageCalculator(),
    val configuration: StageConfiguration = StageConfiguration(),
    val random: Random = Random.Default,
) {
    val logger = StageLogger()

    var turn = 0
        private set
    var tile = 0
        private set

    var tags: List<String> = emptyList()

    var cutinTarget: Actor? = null

    private inline fun withStageEffects(block: () -> Unit) {
        player.stageEffects.activate()
        enemy.stageEffects.activate()
        block()
        player.stageEffects.deactivate()
        enemy.stageEffects.deactivate()
    }

    fun play(maxTurns: Int = 6): StageResult {
        try {
            log("Stage") { "Begin" }

            log("AutoEffect") { "Begin" }

            listOf(player, enemy).forEach { team ->
                if (team.song.passive != null) {
                    team.active.forEach {
                        it.context.log("Song") { "Apply passive ${team.song.passive.name}" }
                        team.song.passive.start(it.context)
                    }
                }
            }

            var autoEffectPriority = (player.actors.values + enemy.actors.values)
                .shuffled(random)
                .sortedByDescending { it.agility }

            (autoEffectPriority + listOfNotNull(player.guest, enemy.guest))
                .map { it to it.dress.unitSkill }.forEach { (actor, us) ->
                    us?.forLevel(actor.unitSkillLevel)?.forEach {
                        log("AutoEffect") { "[${actor.name}] unit skill [${it.name}] activate" }
                        it.activate(actor.context)
                    }
                }

            PassiveEffectCategory.values().forEach { category ->
                autoEffectPriority.forEach { sg ->
                    sg.passives.filter { it.effect.category == category }.forEach {
                        sg.context.log("AutoEffect") { "${category.name} auto effect [${it.name}] activate" }
                        it.activate(sg.context)
                    }
                }
                if (category == PassiveEffectCategory.Passive) {
                    autoEffectPriority = autoEffectPriority
                        .shuffled(random)
                        .sortedByDescending { it.agility }
                }
            }

            log("AutoEffect") { "End" }

            player.finalizeTurnZero()
            enemy.finalizeTurnZero()
            player.strategy.initialize(this, player, enemy)
            enemy.strategy.initialize(this, enemy, player)
            while (turn < maxTurns) {
                turn++
                tile = 0
                log("Turn") { "Turn $turn begin" }
                val playerQueue = player.strategy.nextQueue(this, player, enemy)
                val enemyQueue = enemy.strategy.nextQueue(this, enemy, player)
                if (playerQueue.climax) {
                    log("Climax") { "Player Climax" }
                    player.enterCX()
                }
                if (enemyQueue.climax) {
                    log("Climax") { "enemy Climax" }
                    enemy.enterCX()
                }
                playerQueue.tiles.filterIsInstance<ActionTile>().forEach {
                    if (it.actData.type == ActType.ClimaxAct) it.actor.enterCX()
                }
                enemyQueue.tiles.filterIsInstance<ActionTile>().forEach {
                    if (it.actData.type == ActType.ClimaxAct) it.actor.enterCX()
                }
                val playerTiles = playerQueue.tiles + List(6 - playerQueue.tiles.size) { IdleTile }
                val enemyTiles = enemyQueue.tiles + List(6 - enemyQueue.tiles.size) { IdleTile }
                log("Queue") {
                    val player = listOf("Player") + playerTiles.map {
                        if (it is ActionTile) {
                            "[${it.actor.dress.name} (${it.actor.name})]:[${it.actData.name}]"
                        } else {
                            "..."
                        }
                    }
                    val padLength = player.maxOf { it.length } + 2
                    val enemy = listOf("enemy") + enemyTiles.map {
                        if (it is ActionTile) {
                            "[${it.actor.dress.name} (${it.actor.name})]:[${it.actData.name}]"
                        } else {
                            "..."
                        }
                    }
                    player.zip(enemy).mapIndexed { i, (p, o) ->
                        if (i > 0) {
                            "$turn.$i " + p.padEnd(padLength) + o
                        } else {
                            "    " + p.padEnd(padLength) + o
                        }
                    }.joinToString("\n")
                }
                val cutins = (playerQueue.cutins + enemyQueue.cutins).groupBy { it.data.target }
                cutins[CutinTarget.TurnStart]?.shuffled(random)?.sortedByDescending { it.agility }?.forEach { cutin ->
                    cutin.execute()
                    checkEnded()?.let { return it }
                }
                var playerActIndex = 0
                var enemyActIndex = 0
                playerTiles.zip(enemyTiles).forEach { (playerTile, enemyTile) ->
                    tile++
                    val (first, second) = when {
                        playerTile.agility > enemyTile.agility -> {
                            playerTile to enemyTile
                        }
                        enemyTile.agility > playerTile.agility -> {
                            enemyTile to playerTile
                        }
                        else -> {
                            if (random.nextDouble() > 0.5) {
                                playerTile to enemyTile
                            } else {
                                enemyTile to playerTile
                            }
                        }
                    }
                    val tileCutins = mutableListOf<Pair<BoundCutin, Actor>>()
                    if (playerTile is ActionTile) {
                        playerActIndex++
                        tileCutins += cutins[CutinTarget.BeforeAllyAct(playerActIndex)]?.map { it to playerTile.actor }
                            ?: emptyList()
                    }
                    if (enemyTile is ActionTile) {
                        enemyActIndex++
                        tileCutins += cutins[CutinTarget.BeforeEnemyAct(enemyActIndex)]?.map { it to enemyTile.actor }
                            ?: emptyList()
                    }
                    withStageEffects {
                        tileCutins.shuffled(random).sortedByDescending { (cutin, _) -> cutin.agility }
                            .forEach { (cutin, target) ->
                                cutinTarget = target
                                cutin.execute()
                                checkEnded()?.let { return it }
                            }
                    }
                    cutinTarget = null
                    if (first is ActionTile) withStageEffects {
                        first.execute()
                    }
                    checkEnded()?.let { return it }
                    if (second is ActionTile) withStageEffects {
                        second.execute()
                    }
                    checkEnded()?.let { return it }
                }
                log("Effect") { "Turn end tick" }
                withStageEffects {  // dots
                    player.endTurn()
                    enemy.endTurn()
                }
                log("Turn") { "Turn $turn end" }
                checkEnded()?.let { return it }
            }
            return OutOfTurns(enemy.active.sumOf { it.hp }, tags)
        } catch (e: IgnoreRunException) {
            log("Stage") { "Early run end." }
            return ExcludedRun(tags)
        } catch (e: Exception) {
            log("Error") { e.stackTraceToString() }
            return PlayError(e, tags)
        } finally {
            log("Stage") { "End" }
        }
    }

    private fun checkEnded(): StageResult? {
        if (player.active.isEmpty()) {
            return TeamWipe(turn, tile, tags)
        }
        if (enemy.active.isEmpty()) {
            return Victory(turn, tile, tags)
        }
        return null
    }

    init {
        player.actors.values.forEach {
            it.context = ActionContext(it, this, player, enemy)
        }
        enemy.actors.values.forEach {
            it.context = ActionContext(it, this, enemy, player)
        }
    }
}

expect class IgnoreRunException : Exception

expect fun ignoreRun(): Nothing

sealed class StageResult {
    abstract val tags: List<String>
}

data class TeamWipe(val turn: Int, val tile: Int, override val tags: List<String>) : StageResult()
data class OutOfTurns(val margin: Int, override val tags: List<String>) : StageResult()
data class Victory(val turn: Int, val tile: Int, override val tags: List<String>) : StageResult()
data class PlayError(val exception: Exception, override val tags: List<String>) : StageResult()
data class ExcludedRun(override val tags: List<String>) : StageResult()

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(tag: String = "?", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(turn, tile, tag, value())
    }
}
