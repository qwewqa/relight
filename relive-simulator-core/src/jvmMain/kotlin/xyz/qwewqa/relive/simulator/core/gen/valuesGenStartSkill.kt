package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenStartSkill: Map<Int, GenStartSkill> by lazy {
  loadMasterData<GenStartSkill>(dataGenStartSkill)
}
