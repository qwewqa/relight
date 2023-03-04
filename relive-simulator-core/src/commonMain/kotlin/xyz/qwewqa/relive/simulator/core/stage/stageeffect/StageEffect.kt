package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenFieldEffect
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

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
) : FeatureImplementation {
  // Hopefully this continues to work
  val category = buffs.first().effect.category
}

object StageEffects : ImplementationRegistry<StageEffect>() {
  @Suppress("UNCHECKED_CAST")
  private fun getStageEffectBuff(type: Int, target: Int, values: List<Int>): StageEffectBuff? {
    if (type == 0) return null
    val effect = (Buffs[type] as? TimedBuffEffect<Unit>) ?: return null
    val targeting = SkillTargets[target] ?: return null
    return StageEffectBuff(effect, values, targeting)
  }

  init {
    for ((id, effect) in valuesGenFieldEffect) {
      +StageEffect(
          id = id,
          name = effect.name.getLocalizedString(),
          iconId = effect.icon_id,
          buffs =
              listOfNotNull(
                      getStageEffectBuff(
                          effect.buff_type1,
                          effect.buff_type1_target_id,
                          effect.buff_type1_value_list),
                      getStageEffectBuff(
                          effect.buff_type2,
                          effect.buff_type2_target_id,
                          effect.buff_type2_value_list),
                      getStageEffectBuff(
                          effect.buff_type3,
                          effect.buff_type3_target_id,
                          effect.buff_type3_value_list),
                      getStageEffectBuff(
                          effect.buff_type4,
                          effect.buff_type4_target_id,
                          effect.buff_type4_value_list),
                      getStageEffectBuff(
                          effect.buff_type5,
                          effect.buff_type5_target_id,
                          effect.buff_type5_value_list),
                  )
                  .takeIf { it.isNotEmpty() }
                  ?: continue)
    }
  }
}
