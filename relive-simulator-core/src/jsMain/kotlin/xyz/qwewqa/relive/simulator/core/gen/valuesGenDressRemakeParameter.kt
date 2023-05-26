package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenDressRemakeParameter: Map<Int, ListGenDressRemakeParameter> by lazy {
  loadJsMasterData(dataGenDressRemakeParameter) { _, data ->
    (data as Array<dynamic>).map { entry ->
      DressRemakeParameter(
          hp = entry.hp.unsafeCast<Int>(),
          atk = entry.atk.unsafeCast<Int>(),
          pdef = entry.pdef.unsafeCast<Int>(),
          mdef = entry.mdef.unsafeCast<Int>(),
          agi = entry.agi.unsafeCast<Int>())
    }
  }
}
