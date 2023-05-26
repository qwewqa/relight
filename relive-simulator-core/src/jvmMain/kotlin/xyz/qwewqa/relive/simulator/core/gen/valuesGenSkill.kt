package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkill: Map<Int, GenSkill> by lazy {
  loadMasterData<GenSkill>(dataGenSkill)
}
