package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.gen.GenFieldEffect
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenFieldEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect

data class StageEffectData(
    val name: String,
    val iconId: Int,
    val buffsValues: List<List<Int>>,
) {
    fun makeStageEffect(buffs: List<StageEffectBuffType>) = StageEffect(
        name,
        iconId,
        buffs.zip(buffsValues).map { (buff, values) ->
            StageEffectBuff(buff.effect, values, buff.target)
        }
    )
}

data class StageEffectBuffType(
    val effect: TimedBuffEffect<Unit>,
    val target: StageEffectTarget,
)

fun List<TimedBuffEffect<Unit>>.targeting(target: StageEffectTarget) = map { StageEffectBuffType(it, target) }

private fun ensureBuffValues(values: List<Int>) = if (values.isEmpty()) listOf(0) else values

fun GenFieldEffect.toStageEffectData() = StageEffectData(
    name.getLocalizedString(),
    icon_id,
    listOf(
        ensureBuffValues(buff_type1_value_list),
        ensureBuffValues(buff_type2_value_list),
        ensureBuffValues(buff_type3_value_list),
        ensureBuffValues(buff_type4_value_list),
        ensureBuffValues(buff_type5_value_list),
    ),
)

val stageEffectData = valuesGenFieldEffect.mapValues { it.value.toStageEffectData() }

fun stageEffectData(id: Int) = stageEffectData[id] ?: error("No stage effect data for $id")
fun stageEffectDataOrNull(id: Int) = stageEffectData[id]