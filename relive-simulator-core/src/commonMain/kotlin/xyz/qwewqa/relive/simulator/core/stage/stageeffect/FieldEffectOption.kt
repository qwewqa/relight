package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.gen.GenFieldEffectOption
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenFieldEffectOption
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.common.DescriptionUnit
import xyz.qwewqa.relive.simulator.core.stage.common.substitute
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.team.Team

interface FieldEffectOption : FeatureImplementation {
  val iconId: Int
  val descriptions: Map<String, String>
  val extraDescriptions: Map<String, String>?
  val param1: Int
  val param1Unit: DescriptionUnit
  val valueUnit: DescriptionUnit
  val timeUnit: DescriptionUnit
  val type: Int

  val description: String
    get() = descriptions.getLocalizedString()

  val extraDescription: String?
    get() = extraDescriptions?.getLocalizedString()

  fun execute(target: Team, value: Int, time: Int)
}

fun ActionContext.executeFieldEffectOption(
    option: FieldEffectOption,
    target: SkillFieldEffectTarget,
    value: Int,
    time: Int,
) {
  val team =
      when (target) {
        SkillFieldEffectTarget.Allies -> team
        SkillFieldEffectTarget.Enemies -> enemy
      }
  if (stage.configuration.logging) {
    val substitutions =
        listOf(
            "value" to "$value",
            "param1" to "${option.param1}",
        )
    val primaryDescription = option.description.substitute(substitutions)
    val extraDescription =
        " (${option.extraDescription?.substitute(substitutions)})".takeIf {
          option.extraDescription?.isNotBlank() ?: false
        }
            ?: ""
    val targetDescription = " -> ${target.name}"
    val timeDescription =
        when (option.type) {
          1 -> " ${time}t"
          else -> ""
        }
    val levelDescription =
        when (option.type) {
          1 -> " lv${value}"
          else -> ""
        }
    val description =
        "$primaryDescription$extraDescription$timeDescription$levelDescription$targetDescription"
    log("Action") { "Begin stage effect action [$description]" }
    option.execute(team, value, time)
    log("Action") { "End stage effect action [$description]" }
  } else {
    option.execute(team, value, time)
  }
}

inline fun makeFieldEffectOption(
    option: GenFieldEffectOption,
    crossinline action: (target: Team, value: Int, time: Int) -> Unit,
) =
    object : FieldEffectOption {
      override val id = option._id_
      override val iconId = option.icon_id
      override val descriptions = option.effect_description
      override val extraDescriptions =
          option.extra_description.takeIf { desc -> desc.values.any { it.isNotBlank() } }
      override val param1 = option.param1
      override val param1Unit = DescriptionUnit.fromId(option.param1_unit)
      override val valueUnit = DescriptionUnit.fromId(option.value_unit)
      override val timeUnit = DescriptionUnit.fromId(option.time_unit)
      override val type = option.type

      override fun execute(target: Team, value: Int, time: Int) = action(target, value, time)
    }

@Suppress("UNCHECKED_CAST")
object FieldEffectOptions : ImplementationRegistry<FieldEffectOption>() {
  init {
    for ((id, option) in valuesGenFieldEffectOption) {
      +when (option.type) {
        1 -> {
          val effect = StageEffects[option.param1] ?: continue
          makeFieldEffectOption(option) { target, value, time ->
            target.stageEffects.add(
                effect = effect,
                level = value,
                turns = time,
            )
          }
        }
        2 -> {
          makeFieldEffectOption(option) { target, value, time ->
            require(time == 1) { "Time must be 1 for field effect level adjustment effects." }
            target.stageEffects.adjustLevels(
                category = BuffCategory.Negative,
                count = option.param1,
                delta = -value,
            )
          }
        }
        3 -> {
          makeFieldEffectOption(option) { target, value, time ->
            require(time == 1) { "Time must be 1 for field level adjustment effects." }
            target.stageEffects.adjustLevels(
                category = BuffCategory.Positive,
                count = option.param1,
                delta = -value,
            )
          }
        }
        4 -> {
          makeFieldEffectOption(option) { target, value, time ->
            require(time == 1) { "Time must be 1 for field effect level adjustment effects." }
            target.stageEffects.adjustLevels(
                category = BuffCategory.Negative,
                count = option.param1,
                delta = value,
            )
          }
        }
        5 -> {
          makeFieldEffectOption(option) { target, value, time ->
            require(time == 1) { "Time must be 1 for field level adjustment effects." }
            target.stageEffects.adjustLevels(
                category = BuffCategory.Positive,
                count = option.param1,
                delta = value,
            )
          }
        }
        else -> null
      }
    }
  }
}
