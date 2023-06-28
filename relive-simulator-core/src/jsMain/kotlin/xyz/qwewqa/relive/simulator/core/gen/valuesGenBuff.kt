package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenBuff: Map<Int, GenBuff> by lazy {
  loadJsMasterData(dataGenBuff) { id, data ->
    GenBuff(
        base_point = data.base_point.unsafeCast<Int>(),
        card_abnormal_priority = data.card_abnormal_priority.unsafeCast<Int>(),
        card_abnormal_type = data.card_abnormal_type.unsafeCast<Int>(),
        category = data.category.unsafeCast<Int>(),
        chara_add_color = arrayFromDynamic(data.chara_add_color),
        chara_color = arrayFromDynamic(data.chara_color),
        chara_gray_scale = data.chara_gray_scale.unsafeCast<Int>(),
        icon_id = data.icon_id.unsafeCast<Int>(),
        is_motion_stop = data.is_motion_stop.unsafeCast<Int>(),
        loop = data.loop.unsafeCast<Int>(),
        loop_filename = data.loop_filename.unsafeCast<String>(),
        max_value = data.max_value.unsafeCast<Int>(),
        name = stringMapFromDynamic(data.name),
        priority = data.priority.unsafeCast<Int>(),
        value_unit = data.value_unit.unsafeCast<Int>(),
        group = data.group.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
