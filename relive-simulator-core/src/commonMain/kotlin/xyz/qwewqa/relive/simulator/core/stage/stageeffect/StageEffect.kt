package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.team.Team

enum class StageEffectTargetUpdateMode {
    /**
     * The target is only updated if the team changes, such as when a member exits or enters.
     */
    Static,

    // Holding off on this, since it may never be needed.
    // Comes at a performance cost as well.
//    /**
//     * The target may change at any time.
//     */
//    Dynamic,
}

data class StageEffectTarget(
    val updateMode: StageEffectTargetUpdateMode,
    val getTargets: (Team) -> List<Actor>,
)

fun stageEffectTargetAoe() = StageEffectTarget(
    StageEffectTargetUpdateMode.Static,
) { team -> team.actors.values.toList() }

fun stageEffectTargetAoe(
    updateMode: StageEffectTargetUpdateMode = StageEffectTargetUpdateMode.Static,
    condition: Condition,
) = StageEffectTarget(
    updateMode,
) { team -> team.actors.values.filter { condition.evaluate(it) } }

fun stageEffectTargetFront(
    count: Int,
    updateMode: StageEffectTargetUpdateMode = StageEffectTargetUpdateMode.Static,
    condition: Condition,
) = StageEffectTarget(
    updateMode,
) { team -> team.actors.values.take(count).filter { condition.evaluate(it) } }

fun stageEffectTargetBack(
    count: Int,
    updateMode: StageEffectTargetUpdateMode = StageEffectTargetUpdateMode.Static,
    condition: Condition,
) = StageEffectTarget(
    updateMode,
) { team -> team.actors.values.toList().takeLast(count).filter { condition.evaluate(it) } }

data class StageEffectBuff(
    val effect: TimedBuffEffect,
    val values: List<Int>,
    val target: StageEffectTarget,
)

data class StageEffect(
    val name: String,
    val iconId: Int,
    val buffs: List<StageEffectBuff>,
)
