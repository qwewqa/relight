package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenFieldEffectOption: Map<Int, GenFieldEffectOption> by lazy {
  loadJsMasterData(dataGenFieldEffectOption) { id, data ->
    GenFieldEffectOption(
        effect_description = stringMapFromDynamic(data.effect_description),
        effect_name = data.effect_name.unsafeCast<String>(),
        extra_description = stringMapFromDynamic(data.extra_description),
        icon_id = data.icon_id.unsafeCast<Int>(),
        param1 = data.param1.unsafeCast<Int>(),
        param1_unit = data.param1_unit.unsafeCast<Int>(),
        time_unit = data.time_unit.unsafeCast<Int>(),
        type = data.type.unsafeCast<Int>(),
        value_unit = data.value_unit.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
