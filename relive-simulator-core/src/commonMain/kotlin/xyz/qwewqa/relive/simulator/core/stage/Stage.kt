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
    var random: Random = Random.Default,
) {
    val logger = StageLogger()

    var turn = 0
        private set
    var tile = 0
        private set
    var move = 0
        private set

    var tags: List<String> = emptyList()

    var cutinTarget: Actor? = null

    private suspend inline fun executeAct(block: () -> Unit) {
        move++
        player.stageEffects.activate()
        enemy.stageEffects.activate()
        block()
        player.stageEffects.deactivate()
        enemy.stageEffects.deactivate()
        player.strategy.afterAct(this, player, enemy)
    }

    suspend fun play(maxTurns: Int = 6): StageResult {
        try {
            try {
                log("Stage") { "Begin" }

                log("AutoEffect") { "Begin" }

                arrayOf(player, enemy).forEach { team ->
                    if (team.song.passive != null) {
                        team.active.forEach {
                            it.context.log("Song") { "Apply passive ${team.song.passive.name}" }
                            team.song.passive.start(it.context)
                        }
                    }
                }

                // for consistent results with earlier versions which performed two rounds of shuffling
                repeat(player.actors.size + enemy.actors.size - 1) {
                    random.nextInt()
                }

                val allActors = player.actors.values + enemy.actors.values + listOfNotNull(player.guest, enemy.guest)

                allActors
                    .map { it to it.dress.unitSkill }
                    .forEach { (actor, us) ->
                        us.forEach {
                            log("AutoEffect") { "[${actor.name}] unit skill [${it.name}] activate" }
                            it.activate(actor.context)
                        }
                    }

                allActors
                    .forEach { sg ->
                        sg.passives.filter { it.effect.category == PassiveEffectCategory.Passive }.forEach {
                            sg.context.log("AutoEffect") { "Passive auto effect [${it.name}] activate" }
                            it.activate(sg.context)
                        }
                    }

                val autoEffectPriority = (player.actors.values + enemy.actors.values)
                    .shuffled(random)
                    .sortedByDescending { it.agility }

                PassiveEffectCategory
                    .values()
                    .drop(1) // skip passive
                    .forEach { category ->
                        autoEffectPriority.forEach { sg ->
                            sg.passives.filter { it.effect.category == category }.forEach {
                                sg.context.log("AutoEffect") { "${category.name} auto effect [${it.name}] activate" }
                                it.activate(sg.context)
                            }
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
                    if (player.cxTurns > 0) {
                        playerQueue.tiles.filterIsInstance<ActionTile>().forEach {
                            if (it.actData.type == ActType.ClimaxAct) it.actor.enterCX()
                        }
                    }
                    if (enemy.cxTurns > 0) {
                        enemyQueue.tiles.filterIsInstance<ActionTile>().forEach {
                            if (it.actData.type == ActType.ClimaxAct) it.actor.enterCX()
                        }
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

                    // Can handle enemy cutins properly later
                    if (enemyQueue.cutins.isNotEmpty()) error("Enemy cutins not supported")
                    val cutins = (playerQueue.cutins + enemyQueue.cutins).groupBy { it.data.target }
                    cutins[CutinTarget.TurnStart]?.forEach { cutin ->
                        cutin.execute()
                        checkEnded()?.let { return it }
                    }

                    var playerActIndex = 0
                    var enemyActIndex = 0
                    playerTiles.zip(enemyTiles).forEach { (playerTile, enemyTile) ->
                        tile++
                        move = 0
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
                        tileCutins.forEach { (cutin, target) ->
                            cutinTarget = target
                            executeAct {
                                cutin.execute()
                            }
                            checkEnded()?.let { return it }
                        }
                        cutinTarget = null
                        if (first is ActionTile) executeAct {
                            first.execute()
                        }
                        checkEnded()?.let { return it }
                        if (second is ActionTile) executeAct {
                            second.execute()
                        }
                        checkEnded()?.let { return it }
                    }
                    executeAct {  // dots
                        log("Effect") { "Turn end tick." }
                        player.endTurn()
                        enemy.endTurn()
                    }
                    log("Turn") { "End strategy turns." }
                    player.strategy.endTurn(this, player, enemy, playerQueue, enemyQueue)
                    enemy.strategy.endTurn(this, enemy, player, enemyQueue, playerQueue)
                    log("Turn") { "Turn $turn end." }
                    checkEnded()?.let { return it }
                }
                player.strategy.finalize(this, player, enemy)
                enemy.strategy.finalize(this, enemy, player)
                return OutOfTurns(enemy.active.sumOf { it.hp }, tags)
            } catch (e: IgnoreRunException) {
                log("Stage") { "Early run end." }
                player.strategy.finalize(this, player, enemy)
                enemy.strategy.finalize(this, enemy, player)
                return ExcludedRun(tags)
            } catch (e: Exception) {
                log("Error") { e.stackTraceToString() }
                player.strategy.finalize(this, player, enemy)
                enemy.strategy.finalize(this, enemy, player)
                return PlayError(e, tags)
            } finally {
                log("Stage") { "End" }
            }
        } catch (e: IgnoreRunException) {
            log("Stage") { "Run ignored in finalizer." }
            return ExcludedRun(tags)
        } catch (e: Exception) {
            log("Finalizer Error") { e.stackTraceToString() }
            return PlayError(e, tags)
        } finally {
            log("Stage") { "End" }
        }
    }

    private suspend fun checkEnded(): StageResult? {
        if (player.active.isEmpty()) {
            player.strategy.finalize(this, player, enemy)
            enemy.strategy.finalize(this, enemy, player)
            return TeamWipe(enemy.active.sumOf { it.hp }, turn, tile, tags)
        }
        if (enemy.active.isEmpty()) {
            player.strategy.finalize(this, player, enemy)
            enemy.strategy.finalize(this, enemy, player)
            return Victory(turn, tile, tags)
        }
        return null
    }

    init {
        player.actors.values.forEach {
            it.context = ActionContext(it, this, player, enemy)
        }
        player.guest?.let { it.context = ActionContext(it, this, player, enemy) }
        enemy.actors.values.forEach {
            it.context = ActionContext(it, this, enemy, player)
        }
        enemy.guest?.let { it.context = ActionContext(it, this, enemy, player) }
    }
}

expect class IgnoreRunException : Exception

expect fun ignoreRun(): Nothing

sealed class StageResult {
    abstract val tags: List<String>
}

sealed class MarginStageResult : StageResult() {
    abstract val margin: Int
}

data class TeamWipe(override val margin: Int, val turn: Int, val tile: Int, override val tags: List<String>) :
    MarginStageResult()

data class OutOfTurns(override val margin: Int, override val tags: List<String>) : MarginStageResult()
data class Victory(val turn: Int, val tile: Int, override val tags: List<String>) : StageResult()
data class PlayError(val exception: Exception, override val tags: List<String>) : StageResult()
data class ExcludedRun(override val tags: List<String>) : StageResult()

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(vararg tags: String, value: LogContentsBuilder.() -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(turn, tile, move, *tags, contents = LogContentsBuilder().run { build(value()) })
    }
}
