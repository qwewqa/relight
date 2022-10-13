package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.stage.actor.ActiveBuff
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition

class StageEffect(
    val name: String,
    val buffs: List<List<StageBuff>>,
    val target: StageEffectTarget,
    val condition: Condition? = null,
) {
    operator fun get(level: Int) = buffs[(level - 1).coerceAtMost(buffs.size - 1)]
}

sealed class StageEffectTarget {
    object All : StageEffectTarget()
    data class Front(val count: Int) : StageEffectTarget()
    data class Back(val count: Int) : StageEffectTarget()
}

data class StageBuff(val effect: TimedBuffEffect, val value: Int) {
    fun activate(actor: Actor): ActiveBuff {
        return actor.buffs.addEphemeral(null, effect, value)
    }
}
