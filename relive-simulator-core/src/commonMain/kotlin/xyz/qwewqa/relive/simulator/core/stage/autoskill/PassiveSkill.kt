package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.gen.valuesGenPartySkill
import xyz.qwewqa.relive.simulator.core.gen.valuesGenPassiveSkill
import xyz.qwewqa.relive.simulator.core.stage.skilloption.PassiveSkillOption
import xyz.qwewqa.relive.simulator.core.stage.skilloption.SkillOptions
import xyz.qwewqa.relive.simulator.core.stage.skilloption.executePassiveSkillOption
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

class PassiveSkill(
    val option: PassiveSkillOption,
    val target: SkillTarget,
    val value: Int,
) : AutoSkill {
  override val iconId
    get() = option.iconId
  override val descriptions: Map<String, String>
    get() = option.descriptions
  override val type = AutoSkillType.Passive

  override fun execute(context: ActionContext) {
    context.executePassiveSkillOption(option = option, target = target, value = value)
  }
}

class PassiveSkillBlueprint(
    val option: PassiveSkillOption,
    val target: SkillTarget,
    val values: List<Int>,
) {
  fun create(level: Int) =
      PassiveSkill(
          option,
          target,
          values[level - 1],
      )
}

class PassiveSkillGroup(
    override val skills: List<PassiveSkill>,
) : AutoSkillGroup

class PassiveSkillGroupBlueprint(
    override val id: Int,
    val skills: List<PassiveSkillBlueprint>,
) : AutoSkillGroupBlueprint, FeatureImplementation {
  override fun create(level: Int) = PassiveSkillGroup(skills.map { it.create(level) })
}

class UnitSkillBlueprint(
    override val id: Int,
    val skills: List<PassiveSkillBlueprint>,
) : UnitAutoSkillGroupBlueprint, FeatureImplementation {
  override fun create(level: Int) = PassiveSkillGroup(skills.map { it.create(level) })
}

private fun getPassiveSkillBlueprint(
    optionId: Int,
    targetId: Int,
    values: List<Int>,
): PassiveSkillBlueprint? {
  return PassiveSkillBlueprint(
      option = SkillOptions[optionId] as? PassiveSkillOption ?: return null,
      target = SkillTargets[targetId] ?: return null,
      values = values,
  )
}

object PassiveSkillGroups : ImplementationRegistry<PassiveSkillGroupBlueprint>() {
  init {
    for ((id, skill) in valuesGenPassiveSkill) {
      +PassiveSkillGroupBlueprint(
          id = id,
          skills =
              listOfNotNull(
                  if (skill.skill_option1_id != 0)
                      PassiveSkillBlueprint(
                          option = SkillOptions[skill.skill_option1_id] as? PassiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option1_target_id] ?: continue,
                          values = skill.skill_option1_values,
                      )
                  else null,
                  if (skill.skill_option2_id != 0)
                      PassiveSkillBlueprint(
                          option = SkillOptions[skill.skill_option2_id] as? PassiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option2_target_id] ?: continue,
                          values = skill.skill_option2_values,
                      )
                  else null,
                  if (skill.skill_option3_id != 0)
                      PassiveSkillBlueprint(
                          option = SkillOptions[skill.skill_option3_id] as? PassiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option3_target_id] ?: continue,
                          values = skill.skill_option3_values,
                      )
                  else null,
                  if (skill.skill_option4_id != 0)
                      PassiveSkillBlueprint(
                          option = SkillOptions[skill.skill_option4_id] as? PassiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option4_target_id] ?: continue,
                          values = skill.skill_option4_values,
                      )
                  else null,
                  if (skill.skill_option5_id != 0)
                      PassiveSkillBlueprint(
                          option = SkillOptions[skill.skill_option5_id] as? PassiveSkillOption
                                  ?: continue,
                          target = SkillTargets[skill.skill_option5_target_id] ?: continue,
                          values = skill.skill_option5_values,
                      )
                  else null,
              ),
      )
    }
  }
}

object UnitSkills : ImplementationRegistry<UnitSkillBlueprint>() {
  // TODO: Conditional skills like only if 2 back row are on the team (always active for now)

  init {
    for ((id, skill) in valuesGenPartySkill) {
      +UnitSkillBlueprint(
          id = id,
          skills =
              listOfNotNull(
                  if (skill.skill_option1_id != 0)
                      getPassiveSkillBlueprint(
                          skill.skill_option1_id,
                          skill.skill_option1_target_id,
                          skill.skill_option1_values,
                      )
                  else null,
                  if (skill.skill_option2_id != 0)
                      getPassiveSkillBlueprint(
                          skill.skill_option2_id,
                          skill.skill_option2_target_id,
                          skill.skill_option2_values,
                      )
                  else null,
                  if (skill.skill_option3_id != 0)
                      getPassiveSkillBlueprint(
                          skill.skill_option3_id,
                          skill.skill_option3_target_id,
                          skill.skill_option3_values,
                      )
                  else null,
                  if (skill.skill_option4_id != 0)
                      getPassiveSkillBlueprint(
                          skill.skill_option4_id,
                          skill.skill_option4_target_id,
                          skill.skill_option4_values,
                      )
                  else null,
                  if (skill.skill_option5_id != 0)
                      getPassiveSkillBlueprint(
                          skill.skill_option5_id,
                          skill.skill_option5_target_id,
                          skill.skill_option5_values,
                      )
                  else null,
              ))
    }
  }
}
