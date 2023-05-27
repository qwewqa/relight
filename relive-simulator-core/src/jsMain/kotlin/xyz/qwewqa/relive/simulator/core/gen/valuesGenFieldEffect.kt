package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenFieldEffect: Map<Int, GenFieldEffect> by lazy {
  loadJsMasterData(dataGenFieldEffect) { id, data ->
    GenFieldEffect(
        buff_type1 = data.buff_type1.unsafeCast<Int>(),
        buff_type1_target_id = data.buff_type1_target_id.unsafeCast<Int>(),
        buff_type1_value_list = arrayFromDynamic(data.buff_type1_value_list),
        buff_type2 = data.buff_type2.unsafeCast<Int>(),
        buff_type2_target_id = data.buff_type2_target_id.unsafeCast<Int>(),
        buff_type2_value_list = arrayFromDynamic(data.buff_type2_value_list),
        buff_type3 = data.buff_type3.unsafeCast<Int>(),
        buff_type3_target_id = data.buff_type3_target_id.unsafeCast<Int>(),
        buff_type3_value_list = arrayFromDynamic(data.buff_type3_value_list),
        buff_type4 = data.buff_type4.unsafeCast<Int>(),
        buff_type4_target_id = data.buff_type4_target_id.unsafeCast<Int>(),
        buff_type4_value_list = arrayFromDynamic(data.buff_type4_value_list),
        buff_type5 = data.buff_type5.unsafeCast<Int>(),
        buff_type5_target_id = data.buff_type5_target_id.unsafeCast<Int>(),
        buff_type5_value_list = arrayFromDynamic(data.buff_type5_value_list),
        description = stringMapFromDynamic(data.description),
        effect_name = data.effect_name.unsafeCast<String>(),
        icon_id = data.icon_id.unsafeCast<Int>(),
        name = stringMapFromDynamic(data.name),
        _id_ = id
    )
  }
}
