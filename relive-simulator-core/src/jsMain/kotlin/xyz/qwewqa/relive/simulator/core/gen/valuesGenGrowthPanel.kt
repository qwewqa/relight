package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenGrowthPanel: Map<Int, GenGrowthPanel> by lazy {
  loadJsMasterData(dataGenGrowthPanel) { id, data ->
    GenGrowthPanel(
        coin = data.coin.unsafeCast<Int>(),
        growth_item1_id = data.growth_item1_id.unsafeCast<Int>(),
        growth_item1_quantity = data.growth_item1_quantity.unsafeCast<Int>(),
        growth_item2_id = data.growth_item2_id.unsafeCast<Int>(),
        growth_item2_quantity = data.growth_item2_quantity.unsafeCast<Int>(),
        growth_item3_id = data.growth_item3_id.unsafeCast<Int>(),
        growth_item3_quantity = data.growth_item3_quantity.unsafeCast<Int>(),
        growth_item4_id = data.growth_item4_id.unsafeCast<Int>(),
        growth_item4_quantity = data.growth_item4_quantity.unsafeCast<Int>(),
        growth_item5_id = data.growth_item5_id.unsafeCast<Int>(),
        growth_item5_quantity = data.growth_item5_quantity.unsafeCast<Int>(),
        growth_item6_id = data.growth_item6_id.unsafeCast<Int>(),
        growth_item6_quantity = data.growth_item6_quantity.unsafeCast<Int>(),
        label = stringMapFromDynamic(data.label),
        type = data.type.unsafeCast<Int>(),
        value = data.value.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
