package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenAccessory: Map<Int, GenAccessory> by lazy {
  loadMasterData<GenAccessory>(dataGenAccessory)
}
