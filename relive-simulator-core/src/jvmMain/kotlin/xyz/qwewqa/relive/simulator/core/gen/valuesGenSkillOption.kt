package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillOption: Map<Int, GenSkillOption> by lazy {
  loadMasterData<GenSkillOption>(dataGenSkillOption)
}
