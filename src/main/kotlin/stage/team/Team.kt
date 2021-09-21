package xyz.qwewqa.relive.simulator.stage.team

import xyz.qwewqa.relive.simulator.stage.actor.Actor
import xyz.qwewqa.relive.simulator.stage.song.Song
import xyz.qwewqa.relive.simulator.stage.strategy.Strategy

class Team(
    val actors: LinkedHashMap<String, Actor>,
    val guest: Actor? = null,
    val song: Song,
    val strategy: Strategy,
) {
    var cxTurns: Int = 0
        private set

    val active get() = actors.values.filter { it.isAlive }
    val anyAlive get() = active.isNotEmpty()

    fun finalizeTurnZero() {
        actors.values.forEach {
            it.initializeTurnZero()
        }
        guest?.initializeTurnZero()
    }

    fun enterCX() {
        if (cxTurns > 0) return
        cxTurns = 2
        active.filter { it.brilliance == 100 }.forEach { it.enterCX() }
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
}
