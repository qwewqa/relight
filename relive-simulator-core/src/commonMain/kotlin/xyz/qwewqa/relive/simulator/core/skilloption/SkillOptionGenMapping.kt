package xyz.qwewqa.relive.simulator.core.skilloption

import xyz.qwewqa.relive.simulator.core.gen.GenSkillOption
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenSkillOption
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkillType
import xyz.qwewqa.relive.simulator.core.stage.common.DescriptionUnit

data class SkillOptionData(
    val id: Int,
    val description: String,
    val extraDescription: String,
    val iconId: Int,
    val params: List<Int>,
    val timeOverride: Int?,
    val timeUnit: DescriptionUnit,
    val valueOverride: Int?,
    val valueUnit: DescriptionUnit,
    val type: Int?,
) {
  inline fun makeSkillOption(
      activeType: AutoSkillType = AutoSkillType.TurnStartB,
      crossinline action: TargetContext.(value: Int) -> Unit
  ) = makeSkillOption(activeType) { value, _, _ -> action(value) }
  inline fun makeSkillOption(
      activeType: AutoSkillType = AutoSkillType.TurnStartB,
      crossinline action: TargetContext.(value: Int, time: Int) -> Unit
  ) = makeSkillOption(activeType) { value, time, _ -> action(value, time) }
  inline fun makeSkillOption(
      activeType: AutoSkillType = AutoSkillType.TurnStartB,
      crossinline action: TargetContext.(value: Int, time: Int, chance: Int) -> Unit
  ) =
      object : ActiveSkillOption {
        override val id: Int = this@SkillOptionData.id
        override val description = this@SkillOptionData.description
        override val extraDescription = this@SkillOptionData.extraDescription
        override val iconId = this@SkillOptionData.iconId
        override val params = this@SkillOptionData.params
        override val timeOverride = this@SkillOptionData.timeOverride
        override val timeUnit = this@SkillOptionData.timeUnit
        override val valueOverride = this@SkillOptionData.valueOverride
        override val valueUnit = this@SkillOptionData.valueUnit
        override val type = this@SkillOptionData.type
        override val activeType = activeType

        override fun actActive(
            context: TargetContext,
            value: Int,
            time: Int,
            chance: Int,
        ) {
          context.action(value, time, chance)
        }
      }

  inline fun makePassiveSkillOption(crossinline action: TargetContext.(value: Int) -> Unit) =
      object : PassiveSkillOption {
        override val id = this@SkillOptionData.id
        override val description = this@SkillOptionData.description
        override val extraDescription = this@SkillOptionData.extraDescription
        override val iconId = this@SkillOptionData.iconId
        override val params = this@SkillOptionData.params
        override val timeOverride = this@SkillOptionData.timeOverride
        override val timeUnit = this@SkillOptionData.timeUnit
        override val valueOverride = this@SkillOptionData.valueOverride
        override val valueUnit = this@SkillOptionData.valueUnit
        override val type = this@SkillOptionData.type

        override fun actPassive(context: TargetContext, value: Int) {
          context.action(value)
        }
      }

  inline fun makeDualSkillOption(
      activeType: AutoSkillType = AutoSkillType.TurnStartB,
      crossinline activeAction: TargetContext.(value: Int, time: Int, chance: Int) -> Unit,
      crossinline passiveAction: TargetContext.(value: Int) -> Unit,
  ) =
      object : DualSkillOption {
        override val id = this@SkillOptionData.id
        override val description = this@SkillOptionData.description
        override val extraDescription = this@SkillOptionData.extraDescription
        override val iconId = this@SkillOptionData.iconId
        override val params = this@SkillOptionData.params
        override val timeOverride = this@SkillOptionData.timeOverride
        override val timeUnit = this@SkillOptionData.timeUnit
        override val valueOverride = this@SkillOptionData.valueOverride
        override val valueUnit = this@SkillOptionData.valueUnit
        override val type = this@SkillOptionData.type
        override val activeType = activeType

        override fun actActive(
            context: TargetContext,
            value: Int,
            time: Int,
            chance: Int,
        ) {
          context.activeAction(value, time, chance)
        }

        override fun actPassive(context: TargetContext, value: Int) {
          context.passiveAction(value)
        }
      }
}

fun GenSkillOption.toSkillOptionData() =
    SkillOptionData(
        id = _id_,
        description = effect_description.getLocalizedString(),
        extraDescription = extra_description.getLocalizedString(),
        iconId = icon_id,
        params = listOf(param1),
        timeOverride = time_override,
        timeUnit = DescriptionUnit.fromId(time_unit),
        valueOverride = value_override,
        valueUnit = DescriptionUnit.fromId(value_unit),
        type = type,
    )

val skillOptionData = valuesGenSkillOption.mapValues { it.value.toSkillOptionData() }

fun skillOptionData(id: Int) = skillOptionData[id] ?: error("No skill option data for $id")

fun skillOptionDataOrNull(id: Int) = skillOptionData[id]
