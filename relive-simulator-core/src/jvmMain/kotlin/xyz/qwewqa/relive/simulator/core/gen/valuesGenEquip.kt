package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenEquip: Map<Int, GenEquip> by lazy {
  loadMasterData<GenEquip>(dataGenEquip)
}
