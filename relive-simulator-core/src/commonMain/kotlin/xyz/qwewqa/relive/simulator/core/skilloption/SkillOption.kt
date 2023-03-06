package xyz.qwewqa.relive.simulator.core.skilloption

import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkillType
import xyz.qwewqa.relive.simulator.core.stage.common.DescriptionUnit
import xyz.qwewqa.relive.simulator.core.stage.common.substitute
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget

interface SkillOption : FeatureImplementation {
  val descriptions: Map<String, String>
  val extraDescriptions: Map<String, String>
  val iconId: Int
  val params: List<Int>
  val timeOverride: Int?
  val timeUnit: DescriptionUnit
  val valueOverride: Int?
  val valueUnit: DescriptionUnit
  val type: Int?

  val description: String
    get() = descriptions.getLocalizedString()
  val extraDescription: String
    get() = extraDescriptions.getLocalizedString()
}

interface ActiveSkillOption : SkillOption {
  val activeType: AutoSkillType
  fun executeActive(
      context: TargetContext,
      value: Int,
      time: Int,
      chance: Int,
      attribute: Attribute
  )
}

interface PassiveSkillOption : SkillOption {
  fun executePassive(context: TargetContext, value: Int)
}

interface DualSkillOption : ActiveSkillOption, PassiveSkillOption

fun ActionContext.executeActiveSkillOption(
    option: ActiveSkillOption,
    attribute: Attribute?,
    target: SkillTarget,
    value: Int,
    time: Int,
    chance: Int
) {
  val actualAttribute = attribute ?: self.dress.attribute
  if (stage.configuration.logging) {
    val substitutions =
        listOf(
            "value" to "$value",
            "attr" to actualAttribute.name,
        )
    val primaryDescription = option.description.substitute(substitutions)
    val extraDescription =
        " (${option.extraDescription.substitute(substitutions)})".takeIf {
          option.extraDescription.isNotBlank()
        }
            ?: ""
    val timeDescription = " $time".takeIf { time > 0 } ?: ""
    val chanceDescription = " @${chance}%".takeIf { chance < 100 } ?: ""
    val targetDescription = " -> ${target.description}"
    val description =
        "$primaryDescription$extraDescription$timeDescription$chanceDescription$targetDescription"
    log("Action") { "Begin action [$description]" }
    option.executeActive(resolveTarget(target), value, time, chance, actualAttribute)
    log("Action") { "End action [$description]" }
  } else {
    option.executeActive(resolveTarget(target), value, time, chance, actualAttribute)
  }
}

fun ActionContext.executePassiveSkillOption(
    option: PassiveSkillOption,
    target: SkillTarget,
    value: Int
) {
  if (stage.configuration.logging) {
    val substitutions =
        listOf(
            "value" to "$value",
        )
    val primaryDescription = option.description.substitute(substitutions)
    val extraDescription =
        " (${option.extraDescription.substitute(substitutions)})".takeIf {
          option.extraDescription.isNotBlank()
        }
            ?: ""
    val targetDescription = " -> ${target.description}"
    val description = "$primaryDescription$extraDescription$targetDescription"
    log("Action") { "Begin action [$description]" }
    option.executePassive(resolveTarget(target), value)
    log("Action") { "End action [$description]" }
  } else {
    option.executePassive(resolveTarget(target), value)
  }
}
