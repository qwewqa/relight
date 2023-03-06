package xyz.qwewqa.relive.simulator.core.stage.actor

import kotlin.jvm.JvmName
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenSkill
import xyz.qwewqa.relive.simulator.core.skilloption.ActiveSkillOption
import xyz.qwewqa.relive.simulator.core.skilloption.SkillOptions
import xyz.qwewqa.relive.simulator.core.skilloption.executeActiveSkillOption
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.attributeFromId
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SkillFieldEffect
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SkillFieldEffects
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

class SkillPart(
    val option: ActiveSkillOption,
    val attribute: Attribute?,
    val target: SkillTarget,
    val value: Int,
    val time: Int,
    val chance: Int,
) {
  fun execute(context: ActionContext) {
    context.executeActiveSkillOption(
        option = option,
        attribute = attribute,
        target = target,
        value = value,
        time = time,
        chance = chance)
  }
}

class SkillPartBlueprint(
    val option: ActiveSkillOption,
    val attribute: Attribute?,
    val target: SkillTarget,
    val values: List<Int>,
    val times: List<Int>,
    val chance: Int,
) {
  fun create(level: Int) =
      SkillPart(
          option = option,
          attribute = attribute,
          target = target,
          value = option.valueOverride.takeIf { it != 0 } ?: values[level - 1],
          time = option.timeOverride.takeIf { it != 0 } ?: times[level - 1],
          chance = chance,
      )
}

class Skill(
    val parts: List<SkillPart>,
    val stageEffect: SkillFieldEffect?,
) : Act {
  val iconIds =
      parts.map { it.option.iconId } +
          (stageEffect?.options?.map { it.option.iconId } ?: emptyList())

  @JvmName("exec")
  fun execute(context: ActionContext) {
    parts.forEach { it.execute(context) }
    stageEffect?.execute(context)
  }

  override fun ActionContext.execute() {
    execute(this)
  }
}

class SkillBlueprint(
    override val id: Int,
    val name: String,
    val cost: Int,
    val iconId: Int,
    val isMultipleCa: Boolean,
    val parts: List<SkillPartBlueprint>,
    val stageEffect: SkillFieldEffect?,
) : FeatureImplementation {
  fun create(level: Int) = Skill(parts.map { it.create(level) }, stageEffect)

  fun asActBlueprint(type: ActType) =
      ActBlueprint(
          name = name, apCost = cost, icon = iconId, type = type, value = { create(level) })
}

object Skills : ImplementationRegistry<SkillBlueprint>() {
  init {
    for ((id, skill) in valuesGenSkill) {
      val attribute =
          attributeFromId(skill.attribute_id)
              ?: error("Invalid attribute id ${skill.attribute_id} for skill $id")
      +SkillBlueprint(
          id = id,
          name = skill.name.getLocalizedString(),
          cost = skill.cost,
          iconId = skill.icon_id,
          isMultipleCa = skill.is_multiple_command_unique_skill != 0,
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
              ),
          stageEffect =
              if (skill.skill_field_effect_id != 0) {
                SkillFieldEffects[skill.skill_field_effect_id] ?: continue
              } else null,
      )
    }
  }
}
