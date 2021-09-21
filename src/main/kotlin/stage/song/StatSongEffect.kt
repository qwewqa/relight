package xyz.qwewqa.relive.simulator.stage.song

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.condition.Condition

object CriticalUpSongEffect : SongEffect {
    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.valueCritical += value
    }
    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.valueCritical -= value
    }
}
