package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillOption: Map<Int, GenSkillOption> by lazy {
  loadJsMasterData(dataGenSkillOption) { id, data ->
    GenSkillOption(
        effect_description = stringMapFromDynamic(data.effect_description),
        extra_description = stringMapFromDynamic(data.extra_description),
        icon_id = data.icon_id.unsafeCast<Int>(),
        param1 = data.param1.unsafeCast<Int>(),
        skill_option_filter_id = data.skill_option_filter_id.unsafeCast<Int>(),
        skill_option_filter_id2 = data.skill_option_filter_id2.unsafeCast<Int>(),
        time_override = data.time_override.unsafeCast<Int>(),
        time_unit = data.time_unit.unsafeCast<Int>(),
        type = data.type.unsafeCast<Int>(),
        value_override = data.value_override.unsafeCast<Int>(),
        value_unit = data.value_unit.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
