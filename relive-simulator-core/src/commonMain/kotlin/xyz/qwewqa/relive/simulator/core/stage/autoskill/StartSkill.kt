package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.gen.valuesGenStartSkill
import xyz.qwewqa.relive.simulator.core.skilloption.ActiveSkillOption
import xyz.qwewqa.relive.simulator.core.skilloption.SkillOptions
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SkillFieldEffect
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

class StageEffectStartSkill(val effect: SkillFieldEffect) : AutoSkill {
  override val type = AutoSkillType.StageEffect

  override fun execute(context: ActionContext) {
    effect.execute(context)
  }
}

class StartSkill(
    val option: ActiveSkillOption,
    val target: SkillTarget,
    val value: Int,
    val time: Int,
    val chance: Int,
) : AutoSkill {
  override val type: AutoSkillType
    get() = option.activeType

  override fun execute(context: ActionContext) {
    option.actActive(context.resolveTarget(target), value, time, chance)
  }
}

class StartSkillBlueprint(
    val option: ActiveSkillOption,
    val target: SkillTarget,
    val values: List<Int>,
    val times: List<Int>,
    val chance: Int,
) {
  fun create(level: Int) =
      StartSkill(
          option,
          target,
          option.valueOverride.takeIf { it != 0 } ?: values[level - 1],
          option.timeOverride.takeIf { it != 0 } ?: times[level - 1],
          chance,
      )
}

class StartSkillGroup(
    override val skills: List<StartSkill>,
) : AutoSkillGroup

class StartSkillGroupBlueprint(
    override val id: Int,
    val skills: List<StartSkillBlueprint>,
) : AutoSkillGroupBlueprint, FeatureImplementation {
  override fun create(level: Int) = StartSkillGroup(skills.map { it.create(level) })
}

private fun getStartSkillBlueprint(
    optionId: Int,
    targetId: Int,
    values: List<Int>,
    times: List<Int>,
    chance: Int,
): StartSkillBlueprint? {
  val option = SkillOptions[optionId] as? ActiveSkillOption ?: return null
  val target = SkillTargets[targetId] ?: return null
  return StartSkillBlueprint(
      option = option,
      target = target,
      values = values,
      times = times,
      chance = chance,
  )
}

object StartSkillGroups : ImplementationRegistry<StartSkillGroupBlueprint>() {
  init {
    for ((id, skill) in valuesGenStartSkill) {
      +StartSkillGroupBlueprint(
          id = id,
          skills =
              listOfNotNull(
                  if (skill.skill_option1_id != 0)
                      StartSkillBlueprint(
                          option = SkillOptions[skill.skill_option1_id] as? ActiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option1_target_id] ?: continue,
                          values = skill.skill_option1_values,
                          times = skill.skill_option1_times,
                          chance = skill.skill_option1_hit_rate,
                      )
                  else null,
                  if (skill.skill_option2_id != 0)
                      StartSkillBlueprint(
                          option = SkillOptions[skill.skill_option2_id] as? ActiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option2_target_id] ?: continue,
                          values = skill.skill_option2_values,
                          times = skill.skill_option2_times,
                          chance = skill.skill_option2_hit_rate,
                      )
                  else null,
                  if (skill.skill_option3_id != 0)
                      StartSkillBlueprint(
                          option = SkillOptions[skill.skill_option3_id] as? ActiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option3_target_id] ?: continue,
                          values = skill.skill_option3_values,
                          times = skill.skill_option3_times,
                          chance = skill.skill_option3_hit_rate,
                      )
                  else null,
                  if (skill.skill_option4_id != 0)
                      StartSkillBlueprint(
                          option = SkillOptions[skill.skill_option4_id] as? ActiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option4_target_id] ?: continue,
                          values = skill.skill_option4_values,
                          times = skill.skill_option4_times,
                          chance = skill.skill_option4_hit_rate,
                      )
                  else null,
                  if (skill.skill_option5_id != 0)
                      StartSkillBlueprint(
                          option = SkillOptions[skill.skill_option5_id] as? ActiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option5_target_id] ?: continue,
                          values = skill.skill_option5_values,
                          times = skill.skill_option5_times,
                          chance = skill.skill_option5_hit_rate,
                      )
                  else null,
              ),
      )
    }
  }
}
