package xyz.qwewqa.relivesim.stage.team

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.strategy.Strategy

class Team(
    val stageGirls: Map<String, StageGirl>,
    val friend: StageGirl?,
    val song: ClimaxSong,
    val eventBonus: Percent = 0.percent,
    val strategy: Strategy,
) {
    lateinit var stage: Stage

    var cxTurns: Int = 0
        private set

    val orderedStageGirls = stageGirls.values.sortedBy { it.loadout.data.positionValue }
    val active get() = stageGirls.values.filter { it.isAlive }
    val anyAlive get() = active.isNotEmpty()

    fun finalizeTurnZero() {
        stageGirls.values.forEach {
            it.currentHP = it.maxHp.value
        }

        // No clue how it actually works but this will prevent friends from dying for now
        friend?.let { it.currentHP = 999999 }
    }

    fun enterCX() {
        if (cxTurns > 0) return
        cxTurns = 2
        active.filter { it.currentBrilliance == 100 }.forEach { it.enterCX() }
    }

    fun endTurn() {
        if (cxTurns > 0) {
            cxTurns--
            if (active.none { it.inCX }) cxTurns = 0
            if (cxTurns == 0) {
                active.forEach { it.exitCX() }
            }
        }
    }

    init {
        stageGirls.values.forEach {
            it.team = this
            it.eventBonus += eventBonus
        }
        friend?.let { it.team = this }
    }
}
