package xyz.qwewqa.relive.simulator.core.stage.memoir

import xyz.qwewqa.relive.simulator.core.gen.valuesGenEquipActiveSkill
import xyz.qwewqa.relive.simulator.core.skilloption.ActiveSkillOption
import xyz.qwewqa.relive.simulator.core.skilloption.SkillOptions
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Skill
import xyz.qwewqa.relive.simulator.core.stage.actor.SkillPartBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.attributeFromId
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

class CutinSkillBlueprint(
    override val id: Int,
    val costs: List<Int>,
    val startCooldowns: List<Int>,
    val cooldowns: List<Int>,
    val usageLimits: List<Int>,
    val target: CutinTarget,
    val parts: List<SkillPartBlueprint>
) : FeatureImplementation {
  fun asCutinBlueprint() =
      CutinBlueprint(
          costs = costs,
          startCooldowns = startCooldowns,
          cooldowns = cooldowns,
          usageLimits = usageLimits,
          parameters = emptyList(),
          target = target,
          act = { Skill(parts.map { it.create(level) }, null) })
}

object CutinSkills : ImplementationRegistry<CutinSkillBlueprint>() {
  init {
    for ((id, skill) in valuesGenEquipActiveSkill) {
      val attribute =
          when (skill.attribute_id) {
            99 -> null
            else -> attributeFromId(skill.attribute_id)
                    ?: error("Invalid attribute id ${skill.attribute_id} for skill $id")
          }
      +CutinSkillBlueprint(
          id = id,
          costs = skill.skill_cost_values,
          startCooldowns = skill.first_executable_turns,
          cooldowns = skill.recast_turns,
          usageLimits = skill.execute_limit_counts,
          target = CutinTargets[skill.skill_execute_timing_id]!!.target,
          parts =
              listOfNotNull(
                  if (skill.skill_option1_id != 0) {
                    SkillPartBlueprint(
                        option = SkillOptions[skill.skill_option1_id] as? ActiveSkillOption
                                ?: continue,
                        attribute = attribute,
                        target = SkillTargets[skill.skill_option1_target_id] ?: continue,
                        values = skill.skill_option1_values,
                        times = skill.skill_option1_times,
                        chance = skill.skill_option1_hit_rate,
                    )
                  } else null,
                  if (skill.skill_option2_id != 0) {
                    SkillPartBlueprint(
                        option = SkillOptions[skill.skill_option2_id] as? ActiveSkillOption
                                ?: continue,
                        attribute = attribute,
                        target = SkillTargets[skill.skill_option2_target_id] ?: continue,
                        values = skill.skill_option2_values,
                        times = skill.skill_option2_times,
                        chance = skill.skill_option2_hit_rate,
                    )
                  } else null,
                  if (skill.skill_option3_id != 0) {
                    SkillPartBlueprint(
                        option = SkillOptions[skill.skill_option3_id] as? ActiveSkillOption
                                ?: continue,
                        attribute = attribute,
                        target = SkillTargets[skill.skill_option3_target_id] ?: continue,
                        values = skill.skill_option3_values,
                        times = skill.skill_option3_times,
                        chance = skill.skill_option3_hit_rate,
                    )
                  } else null,
                  if (skill.skill_option4_id != 0) {
                    SkillPartBlueprint(
                        option = SkillOptions[skill.skill_option4_id] as? ActiveSkillOption
                                ?: continue,
                        attribute = attribute,
                        target = SkillTargets[skill.skill_option4_target_id] ?: continue,
                        values = skill.skill_option4_values,
                        times = skill.skill_option4_times,
                        chance = skill.skill_option4_hit_rate,
                    )
                  } else null,
                  if (skill.skill_option5_id != 0) {
                    SkillPartBlueprint(
                        option = SkillOptions[skill.skill_option5_id] as? ActiveSkillOption
                                ?: continue,
                        attribute = attribute,
                        target = SkillTargets[skill.skill_option5_target_id] ?: continue,
                        values = skill.skill_option5_values,
                        times = skill.skill_option5_times,
                        chance = skill.skill_option5_hit_rate,
                    )
                  } else null,
              ))
    }
  }
}
