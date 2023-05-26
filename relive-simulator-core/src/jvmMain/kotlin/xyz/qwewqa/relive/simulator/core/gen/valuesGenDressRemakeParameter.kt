package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenDressRemakeParameter: Map<Int, List<DressRemakeParameter>> by lazy {
  loadMasterData<ListGenDressRemakeParameter>(dataGenDressRemakeParameter)
}
