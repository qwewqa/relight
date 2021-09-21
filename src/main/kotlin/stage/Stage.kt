package xyz.qwewqa.relive.simulator.stage

import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.stage.strategy.ActionTile
import xyz.qwewqa.relive.simulator.stage.strategy.IdleTile
import xyz.qwewqa.relive.simulator.stage.team.Team
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
    val logger = Logger()

    var turn = 0
        private set
    var tile = 0
        private set


    fun play(maxTurns: Int = 6): StageResult {
        log("Stage") { "Begin" }

        log("AutoEffect") { "Begin" }

        listOf(player, enemy).forEach { team ->
            if (team.song.passive != null) {
                team.active.forEach {
                    team.song.passive.start(it.context)
                }
            }
        }

        var autoEffectPriority = (player.actors.values + enemy.actors.values)
            .shuffled(random)
            .sortedByDescending { it.agility }

        (autoEffectPriority + listOf(player.guest, enemy.guest).filterNotNull())
            .map { it to it.dress.unitSkill }.forEach { (sg, us) ->
                us.forEach {
                    log("AutoEffect") { "[${sg.name}] unit skill [${it.name}] activate" }
                    it.activate(sg.context)
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

        try {
            while (turn < maxTurns) {
                turn++
                tile = 0
                log("Turn") { "Turn $turn begin" }
                val playerQueue = player.strategy.getQueue(this, player, enemy)
                val enemyQueue = enemy.strategy.getQueue(this, enemy, player)
                if (playerQueue.climax) {
                    log("Climax") { "Player Climax" }
                    player.enterCX()
                }
                if (enemyQueue.climax) {
                    log("Climax") { "enemy Climax" }
                    enemy.enterCX()
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
                playerTiles.zip(enemyTiles).forEach { (a, b) ->
                    tile++
                    val (first, second) = when {
                        a.agility > b.agility -> {
                            a to b
                        }
                        b.agility > a.agility -> {
                            b to a
                        }
                        else -> {
                            if (random.nextDouble() > 0.5) {
                                a to b
                            } else {
                                b to a
                            }
                        }
                    }
                    first.execute()
                    checkEnded()?.let { return it }
                    second.execute()
                    checkEnded()?.let { return it }
                }
                listOf(player.active, enemy.active).flatten().apply {
                    log("Effect") { "Turn end tick" }
                    forEach { sg -> sg.tick() }
                }
                player.endTurn()
                enemy.endTurn()
                log("Turn") { "Turn $turn end" }
                checkEnded()?.let { return it }
            }
            return OutOfTurns(enemy.active.sumOf { it.hp })
        } catch (e: IgnoreRunException) {
            log("Stage") { "Early run end." }
            return ExcludedRun
        } catch (e: Exception) {
            log("Error") { e.stackTraceToString() }
            return PlayError(e)
        } finally {
            log("Stage") { "End" }
            if (configuration.logging) println(logger)
        }
    }

    private fun checkEnded(): StageResult? {
        if (player.active.isEmpty()) {
            return TeamWipe(turn)
        }
        if (enemy.active.isEmpty()) {
            return Victory(turn)
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

class IgnoreRunException : Exception("Run ignored.", null, true, false)

fun ignoreRun(): Nothing = throw IgnoreRunException()

sealed class StageResult
data class TeamWipe(val turn: Int) : StageResult()
data class OutOfTurns(val margin: Int) : StageResult()
data class Victory(val turn: Int) : StageResult()
data class PlayError(val exception: Exception) : StageResult()
object ExcludedRun : StageResult()

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(tag: String = "?", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(turn, tile, tag, value())
    }
}
