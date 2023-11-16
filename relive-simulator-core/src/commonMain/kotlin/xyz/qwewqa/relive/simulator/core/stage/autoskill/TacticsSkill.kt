package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.gen.valuesGenTacticsSkill
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.skilloption.ActiveSkillOption
import xyz.qwewqa.relive.simulator.core.stage.skilloption.SkillOptions
import xyz.qwewqa.relive.simulator.core.stage.skilloption.executeActiveSkillOption
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

class TacticsSkillGroup(override val id: Int?, override val skills: List<TacticsSkill>) :
    AutoSkillGroup, FeatureImplementation

class TacticsSkill(
  val option: ActiveSkillOption,
  val target: SkillTarget,
  val value: Int,
  val time: Int,
  val chance: Int,
) : AutoSkill {
  override val iconId = option.iconId
  override val descriptions = option.descriptions
  override val type = AutoSkillType.Tactics

  override fun execute(context: ActionContext) {
    context.executeActiveSkillOption(
        option = option,
        attribute = context.self.dress.attribute,
        target = target,
        value = value,
        time = time,
        chance = chance)
  }
}

object TacticsSkillGroups : ImplementationRegistry<TacticsSkillGroup>() {
  init {
    for ((id, skill) in valuesGenTacticsSkill) {
      +TacticsSkillGroup(
          id = id,
          skills =
          listOfNotNull(
              if (skill.skill_option1_id != 0)
                TacticsSkill(
                    option = SkillOptions[skill.skill_option1_id] as? ActiveSkillOption
                      ?: continue,
                    target = SkillTargets[skill.skill_option1_target_id] ?: continue,
                    value = skill.skill_option1_value,
                    time = skill.skill_option1_time,
                    chance = skill.skill_option1_hit_rate,
                )
              else null,
              if (skill.skill_option2_id != 0)
                TacticsSkill(
                    option = SkillOptions[skill.skill_option2_id] as? ActiveSkillOption
                      ?: continue,
                    target = SkillTargets[skill.skill_option2_target_id] ?: continue,
                    value = skill.skill_option2_value,
                    time = skill.skill_option2_time,
                    chance = skill.skill_option2_hit_rate,
                )
              else null,
              if (skill.skill_option3_id != 0)
                TacticsSkill(
                    option = SkillOptions[skill.skill_option3_id] as? ActiveSkillOption
                      ?: continue,
                    target = SkillTargets[skill.skill_option3_target_id] ?: continue,
                    value = skill.skill_option3_value,
                    time = skill.skill_option3_time,
                    chance = skill.skill_option3_hit_rate,
                )
              else null,
              if (skill.skill_option4_id != 0)
                TacticsSkill(
                    option = SkillOptions[skill.skill_option4_id] as? ActiveSkillOption
                      ?: continue,
                    target = SkillTargets[skill.skill_option4_target_id] ?: continue,
                    value = skill.skill_option4_value,
                    time = skill.skill_option4_time,
                    chance = skill.skill_option4_hit_rate,
                )
              else null,
              if (skill.skill_option5_id != 0)
                TacticsSkill(
                    option = SkillOptions[skill.skill_option5_id] as? ActiveSkillOption
                      ?: continue,
                    target = SkillTargets[skill.skill_option5_target_id] ?: continue,
                    value = skill.skill_option5_value,
                    time = skill.skill_option5_time,
                    chance = skill.skill_option5_hit_rate,
                )
              else null,
          ),
      )
    }
  }
}
