package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenRemakeSkill: Map<Int, GenRemakeSkill> by lazy {
  loadMasterData<GenRemakeSkill>(dataGenRemakeSkill)
}
