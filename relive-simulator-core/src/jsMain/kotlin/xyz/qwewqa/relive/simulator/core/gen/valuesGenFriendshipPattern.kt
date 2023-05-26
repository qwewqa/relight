package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenFriendshipPattern: Map<Int, List<FriendshipPanel>> by lazy {
  loadJsMasterData(dataGenFriendshipPattern) { id, data ->
    (data as Array<dynamic>).map { entry ->
      FriendshipPanel(
          effect_arg1 = entry.effect_arg1.unsafeCast<Int>(),
          effect_type = entry.effect_type.unsafeCast<Int>(),
          res_category = entry.res_category.unsafeCast<Int>(),
          res_item_id = entry.res_item_id.unsafeCast<Int>(),
          res_parameter = stringMapFromDynamic(entry.res_parameter),
          res_quantity = entry.res_quantity.unsafeCast<Int>(),
      )
    }
  }
}
