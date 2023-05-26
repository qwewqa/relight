package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenEquipActiveSkill: Map<Int, GenEquipActiveSkill> by lazy {
  loadMasterData<GenEquipActiveSkill>(dataGenEquipActiveSkill)
}
