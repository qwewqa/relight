package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.passive.Targeting
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.team.Team

data class StageEffectBuff(
    val effect: TimedBuffEffect<Unit>,
    val values: List<Int>,
    val target: SkillTarget,
)

data class StageEffect(
    override val id: Int?,
    val name: String,
    val iconId: Int,
    val buffs: List<StageEffectBuff>,
) : FeatureImplementation
