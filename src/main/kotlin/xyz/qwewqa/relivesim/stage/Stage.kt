package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.AutoEffect
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

    private class BoundAutoSkill(val stageGirl: StageGirl, val autoSkill: AutoEffect) : Comparable<BoundAutoSkill> {
        fun execute() {
            autoSkill.activate(stageGirl.context)
        }

        val effectClass = autoSkill.effectClass

        override operator fun compareTo(other: BoundAutoSkill): Int {
            var ret = effectClass.ordinal - other.effectClass.ordinal // sort negatives after positives
            if (ret != 0) return ret
            ret = other.stageGirl.agility.value - stageGirl.agility.value  // sort lower agility after higher
            return ret
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

        val autoEffects = listOf(player.stageGirls.values, opponent.stageGirls.values).flatten().flatMap { sg ->
            sg.loadout.autoEffects.map { BoundAutoSkill(sg, it) }
        } + listOfNotNull(player.friend, opponent.friend).map { sg ->
            BoundAutoSkill(sg, sg.data.unitSkill)
        }

        val (positiveAutoEffects, negativeAutoEffects) = autoEffects.partition { it.effectClass == EffectClass.Positive }
        positiveAutoEffects.shuffled(random).sorted().forEach {
            log("AutoEffect") { "[${it.stageGirl}] positive auto effect [${it.autoSkill}] activate" }
            it.execute()
        }
        negativeAutoEffects.shuffled(random).sorted().forEach {
            log("AutoEffect") { "[${it.stageGirl}] negative auto effect [${it.autoSkill}] activate" }
            it.execute()
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
                if (playerQueue.climax) player.enterCX()
                if (opponentQueue.climax) opponent.enterCX()
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
class TeamWipe(val turn: Int) : StageResult()
class OutOfTurns(val margin: Int) : StageResult()
class Victory(val turn: Int) : StageResult()

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(tag: String = "", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(turn, tile, tag, value())
    }
}
