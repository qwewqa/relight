package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.dsl.stage
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.AutoEffect
import xyz.qwewqa.relivesim.stage.effect.AutoEffectOrder
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.strategy.ActionTile
import xyz.qwewqa.relivesim.stage.strategy.IdleTile
import xyz.qwewqa.relivesim.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.random.Random

data class Stage(
    val player: Team,
    val opponent: Team,
    val damageCalculator: DamageCalculator = LoggingDamageCalculator(),
    val configuration: StageConfiguration = StageConfiguration(),
    val random: Random = Random.Default,
) {
    val logger = Logger()

    init {
        player.stage = this
        opponent.stage = this
        player.stageGirls.values.forEach {
            it.context = ActionContext(it, this, player, opponent)
        }
        player.friend?.let { it.context = ActionContext(it, this, player, opponent) }
        opponent.stageGirls.values.forEach {
            it.context = ActionContext(it, this, opponent, player)
        }
        opponent.friend?.let { it.context = ActionContext(it, this, opponent, player) }
    }

    var turn = 0
        private set
    var tile = 0
        private set

    private class EffectAgent(val stageGirl: StageGirl, val effects: List<AutoEffect>) : Comparable<EffectAgent> {
        fun execute(cls: EffectClass) {
            effects.filter { it.effectClass == cls }.forEach { it.activate(stageGirl.context) }
        }

        override operator fun compareTo(other: EffectAgent): Int {
            return other.stageGirl.agility.value - stageGirl.agility.value  // sort lower agility after higher
        }
    }

    fun play(maxTurns: Int = 6): StageResult {
        log("Stage") { "Begin" }

        log("AutoEffect") { "Begin" }

        listOf(player, opponent).forEach { team ->
            if (team.song.passive != null) {
                team.active.forEach {
                    team.song.passive.start(it.context)
                }
            }
        }

        var autoEffectPriority = (player.stageGirls.values + opponent.stageGirls.values)
            .shuffled(random)
            .sortedByDescending { it.agility.value }

        (autoEffectPriority + listOf(player.friend, opponent.friend).filterNotNull())
            .map { it to it.data.unitSkill }.forEach { (sg, us) ->
                log("AutoEffect") { "[${sg}] unit skill [${us}] activate" }
                us.activate(sg.context)
            }

        AutoEffectOrder.values().forEach { order ->
            autoEffectPriority.forEach { sg ->
                sg.data.autoSkills.filter { it.autoEffectOrder == order }.forEach {
                    log("AutoEffect") { "[${sg}] @${order.name} auto effect [${it}] activate" }
                    it.activate(sg.context)
                }
                sg.loadout.memoir?.autoEffects?.filter { it.autoEffectOrder == order }?.forEach {
                    log("AutoEffect") { "[${sg}] @${order.name} auto effect [${it}] activate" }
                    it.activate(sg.context)
                }
            }
            if (order == AutoEffectOrder.PASSIVE) {
                autoEffectPriority = autoEffectPriority
                    .shuffled(random)
                    .sortedByDescending { it.agility.value }
            }
        }

        log("AutoEffect") { "End" }

        player.finalizeTurnZero()
        opponent.finalizeTurnZero()
        try {
            while (turn < maxTurns) {
                turn++
                tile = 0
                log("Turn") { "Turn $turn begin" }
                val playerQueue = player.strategy.getQueue(this, player, opponent)
                val opponentQueue = opponent.strategy.getQueue(this, opponent, player)
                if (playerQueue.climax) {
                    log("Climax") { "Player Climax" }
                    player.enterCX()
                }
                if (opponentQueue.climax) {
                    log("Climax") { "Opponent Climax" }
                    opponent.enterCX()
                }
                val playerTiles = playerQueue.tiles + List(6 - playerQueue.tiles.size) { IdleTile }
                val opponentTiles = opponentQueue.tiles + List(6 - opponentQueue.tiles.size) { IdleTile }
                log("Queue") {
                    val player = listOf("Player") + playerTiles.map {
                        if (it is ActionTile) {
                            "[${it.stageGirl.loadout.data.displayName} (${it.stageGirl.loadout.name})]:[${it.actData.name}]"
                        } else {
                            "..."
                        }
                    }
                    val padLength = player.maxOf { it.length } + 2
                    val opponent = listOf("Opponent") + opponentTiles.map {
                        if (it is ActionTile) {
                            "[${it.stageGirl.loadout.data.displayName} (${it.stageGirl.loadout.name})]:[${it.actData.name}]"
                        } else {
                            "..."
                        }
                    }
                    player.zip(opponent).mapIndexed { i, (p, o) ->
                        if (i > 0) {
                            "$turn.$i " + p.padEnd(padLength) + o
                        } else {
                            "    " + p.padEnd(padLength) + o
                        }
                    }.joinToString("\n")
                }
                playerTiles.zip(opponentTiles).forEach { (a, b) ->
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
                listOf(player.active, opponent.active).flatten().apply {
                    log("Effect") { "Turn end tick" }
                    forEach { sg -> sg.tick() }
                }
                player.endTurn()
                opponent.endTurn()
                log("Turn") { "Turn $turn end" }
                checkEnded()?.let { return it }
            }
            return OutOfTurns(opponent.active.sumOf { it.currentHP })
        } finally {
            log("Stage") { "End" }
            if (configuration.logging) println(logger)
        }
    }

    private fun checkEnded(): StageResult? {
        if (player.active.isEmpty()) {
            return TeamWipe(turn)
        }
        if (opponent.active.isEmpty()) {
            return Victory(turn)
        }
        return null
    }
}

sealed class StageResult
data class TeamWipe(val turn: Int) : StageResult()
data class OutOfTurns(val margin: Int) : StageResult()
data class Victory(val turn: Int) : StageResult()

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(tag: String = "", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(turn, tile, tag, value())
    }
}
