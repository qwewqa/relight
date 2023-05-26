package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenPartySkill: Map<Int, GenPartySkill> by lazy {
  loadMasterData<GenPartySkill>(dataGenPartySkill)
}
