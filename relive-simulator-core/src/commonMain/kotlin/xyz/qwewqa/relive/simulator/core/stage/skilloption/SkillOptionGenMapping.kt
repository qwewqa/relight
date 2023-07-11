package xyz.qwewqa.relive.simulator.core.stage.skilloption

import xyz.qwewqa.relive.simulator.core.gen.GenSkillOption
import xyz.qwewqa.relive.simulator.core.gen.valuesGenSkillOption
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkillType
import xyz.qwewqa.relive.simulator.core.stage.common.DescriptionUnit

data class SkillOptionData(
    val id: Int,
    val descriptions: Map<String, String>,
    val extraDescriptions: Map<String, String>,
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
  ) = makeSkillOption(activeType) { value, _, _, _ -> action(value) }
  inline fun makeSkillOption(
      activeType: AutoSkillType = AutoSkillType.TurnStartB,
      crossinline action: TargetContext.(value: Int, time: Int) -> Unit
  ) = makeSkillOption(activeType) { value, time, _, _ -> action(value, time) }
  inline fun makeSkillOption(
      activeType: AutoSkillType = AutoSkillType.TurnStartB,
      crossinline action: TargetContext.(value: Int, time: Int, chance: Int) -> Unit
  ) = makeSkillOption(activeType) { value, time, chance, _ -> action(value, time, chance) }
  inline fun makeSkillOption(
      activeType: AutoSkillType = AutoSkillType.TurnStartB,
      crossinline action:
          TargetContext.(value: Int, time: Int, chance: Int, attribute: Attribute) -> Unit
  ) =
      object : ActiveSkillOption {
        override val id: Int = this@SkillOptionData.id
        override val descriptions = this@SkillOptionData.descriptions
        override val extraDescriptions = this@SkillOptionData.extraDescriptions
        override val iconId = this@SkillOptionData.iconId
        override val params = this@SkillOptionData.params
        override val timeOverride = this@SkillOptionData.timeOverride
        override val timeUnit = this@SkillOptionData.timeUnit
        override val valueOverride = this@SkillOptionData.valueOverride
        override val valueUnit = this@SkillOptionData.valueUnit
        override val type = this@SkillOptionData.type
        override val activeType = activeType

        override fun executeActive(
            context: TargetContext,
            value: Int,
            time: Int,
            chance: Int,
            attribute: Attribute,
        ) {
          context.action(value, time, chance, attribute)
        }
      }

  inline fun makePassiveSkillOption(crossinline action: TargetContext.(value: Int) -> Unit) =
      object : PassiveSkillOption {
        override val id = this@SkillOptionData.id
        override val descriptions = this@SkillOptionData.descriptions
        override val extraDescriptions = this@SkillOptionData.extraDescriptions
        override val iconId = this@SkillOptionData.iconId
        override val params = this@SkillOptionData.params
        override val timeOverride = this@SkillOptionData.timeOverride
        override val timeUnit = this@SkillOptionData.timeUnit
        override val valueOverride = this@SkillOptionData.valueOverride
        override val valueUnit = this@SkillOptionData.valueUnit
        override val type = this@SkillOptionData.type

        override fun executePassive(context: TargetContext, value: Int) {
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
        override val descriptions = this@SkillOptionData.descriptions
        override val extraDescriptions = this@SkillOptionData.extraDescriptions
        override val iconId = this@SkillOptionData.iconId
        override val params = this@SkillOptionData.params
        override val timeOverride = this@SkillOptionData.timeOverride
        override val timeUnit = this@SkillOptionData.timeUnit
        override val valueOverride = this@SkillOptionData.valueOverride
        override val valueUnit = this@SkillOptionData.valueUnit
        override val type = this@SkillOptionData.type
        override val activeType = activeType

        override fun executeActive(
            context: TargetContext,
            value: Int,
            time: Int,
            chance: Int,
            attribute: Attribute,
        ) {
          context.activeAction(value, time, chance)
        }

        override fun executePassive(context: TargetContext, value: Int) {
          context.passiveAction(value)
        }
      }

  inline fun makeDualReversibleSkillOption(
    activeType: AutoSkillType = AutoSkillType.TurnStartB,
    crossinline activeAction: TargetContext.(value: Int, time: Int, chance: Int) -> Unit,
    crossinline forwardAction: TargetContext.(value: Int) -> Unit,
    crossinline passiveAction: TargetContext.(value: Int) -> Unit,
    crossinline reverseAction: TargetContext.(value: Int) -> Unit,
  ) =
      object : DualReversibleSkillOption {
        override val id = this@SkillOptionData.id
        override val descriptions = this@SkillOptionData.descriptions
        override val extraDescriptions = this@SkillOptionData.extraDescriptions
        override val iconId = this@SkillOptionData.iconId
        override val params = this@SkillOptionData.params
        override val timeOverride = this@SkillOptionData.timeOverride
        override val timeUnit = this@SkillOptionData.timeUnit
        override val valueOverride = this@SkillOptionData.valueOverride
        override val valueUnit = this@SkillOptionData.valueUnit
        override val type = this@SkillOptionData.type
        override val activeType = activeType

        override fun executeActive(
            context: TargetContext,
            value: Int,
            time: Int,
            chance: Int,
            attribute: Attribute,
        ) {
          context.activeAction(value, time, chance)
        }

        override fun executePassive(context: TargetContext, value: Int) {
          context.passiveAction(value)
        }

        override fun executeForward(context: TargetContext, value: Int) {
          context.forwardAction(value)
        }

        override fun executeReverse(context: TargetContext, value: Int) {
          context.reverseAction(value)
        }
      }
}

fun GenSkillOption.toSkillOptionData() =
    SkillOptionData(
        id = _id_,
        descriptions = effect_description,
        extraDescriptions = extra_description,
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
