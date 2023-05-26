package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenGrowthBoard: Map<Int, GenGrowthBoard> by lazy {
  loadJsMasterData(dataGenGrowthBoard) { id, data ->
    GenGrowthBoard(
        panel1_id = data.panel1_id.unsafeCast<Int>(),
        panel2_id = data.panel2_id.unsafeCast<Int>(),
        panel3_id = data.panel3_id.unsafeCast<Int>(),
        panel4_id = data.panel4_id.unsafeCast<Int>(),
        panel5_id = data.panel5_id.unsafeCast<Int>(),
        panel6_id = data.panel6_id.unsafeCast<Int>(),
        panel7_id = data.panel7_id.unsafeCast<Int>(),
        panel8_id = data.panel8_id.unsafeCast<Int>(),
        _id_ = id,
    )
  }
}
