package xyz.qwewqa.relive.simulator.core.skilloption

import xyz.qwewqa.relive.simulator.core.gen.GenSkillOption
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenSkillOption
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect
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
    inline fun makeSkillOption(crossinline action: TargetContext.(value: Int) -> Unit) =
        makeSkillOption { value, time, chance, params -> action(value) }
    inline fun makeSkillOption(crossinline action: TargetContext.(value: Int, time: Int) -> Unit) =
        makeSkillOption { value, time, chance, params -> action(value, time) }
    inline fun makeSkillOption(crossinline action: TargetContext.(value: Int, time: Int, chance: Int) -> Unit) =
        makeSkillOption { value, time, chance, params -> action(value, time, chance) }
    inline fun makeSkillOption(crossinline action: TargetContext.(value: Int, time: Int, chance: Int, params: List<Int>) -> Unit) =
        object : ActiveSkillOption {
            override val id: Int get() = this@SkillOptionData.id
            override val description get() = this@SkillOptionData.description
            override val extraDescription get() = this@SkillOptionData.extraDescription
            override val iconId get() = this@SkillOptionData.iconId
            override val params get() = this@SkillOptionData.params
            override val timeOverride get() = this@SkillOptionData.timeOverride
            override val timeUnit get() = this@SkillOptionData.timeUnit
            override val valueOverride get() = this@SkillOptionData.valueOverride
            override val valueUnit get() = this@SkillOptionData.valueUnit
            override val type get() = this@SkillOptionData.type

            override fun actActive(context: TargetContext, value: Int, time: Int, chance: Int, params: List<Int>) {
                context.action(value, time, chance, params)
            }
        }

    inline fun makePassiveSkillOption(crossinline action: TargetContext.(value: Int) -> Unit) =
        makePassiveSkillOption { value, params -> action(value) }
    inline fun makePassiveSkillOption(crossinline action: TargetContext.(value: Int, params: List<Int>) -> Unit) =
        object : PassiveSkillOption {
            override val id: Int get() = this@SkillOptionData.id
            override val description get() = this@SkillOptionData.description
            override val extraDescription get() = this@SkillOptionData.extraDescription
            override val iconId get() = this@SkillOptionData.iconId
            override val params get() = this@SkillOptionData.params
            override val timeOverride get() = this@SkillOptionData.timeOverride
            override val timeUnit get() = this@SkillOptionData.timeUnit
            override val valueOverride get() = this@SkillOptionData.valueOverride
            override val valueUnit get() = this@SkillOptionData.valueUnit
            override val type get() = this@SkillOptionData.type

            override fun actPassive(context: TargetContext, value: Int, params: List<Int>) {
                context.action(value, params)
            }
        }

    inline fun makeDualSkillOption(
        crossinline activeAction: TargetContext.(value: Int, time: Int, chance: Int, params: List<Int>) -> Unit,
        crossinline passiveAction: TargetContext.(value: Int, params: List<Int>) -> Unit,
    ) = object : DualSkillOption {
        override val id: Int get() = this@SkillOptionData.id
        override val description get() = this@SkillOptionData.description
        override val extraDescription get() = this@SkillOptionData.extraDescription
        override val iconId get() = this@SkillOptionData.iconId
        override val params get() = this@SkillOptionData.params
        override val timeOverride get() = this@SkillOptionData.timeOverride
        override val timeUnit get() = this@SkillOptionData.timeUnit
        override val valueOverride get() = this@SkillOptionData.valueOverride
        override val valueUnit get() = this@SkillOptionData.valueUnit
        override val type get() = this@SkillOptionData.type

        override fun actActive(context: TargetContext, value: Int, time: Int, chance: Int, params: List<Int>) {
            context.activeAction(value, time, chance, params)
        }

        override fun actPassive(context: TargetContext, value: Int, params: List<Int>) {
            context.passiveAction(value, params)
        }
    }
}

fun GenSkillOption.toSkillOptionData() = SkillOptionData(
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
