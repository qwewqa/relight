package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenPassiveSkill: Map<Int, GenPassiveSkill> by lazy {
  loadMasterData<GenPassiveSkill>(dataGenPassiveSkill)
}
