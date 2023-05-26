package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillTarget: Map<Int, GenSkillTarget> by lazy {
  loadMasterData<GenSkillTarget>(dataGenSkillTarget)
}
