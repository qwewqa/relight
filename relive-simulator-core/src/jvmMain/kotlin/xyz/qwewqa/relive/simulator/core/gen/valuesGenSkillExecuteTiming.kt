package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillExecuteTiming: Map<Int, GenSkillExecuteTiming> by lazy {
  loadMasterData<GenSkillExecuteTiming>(dataGenSkillExecuteTiming)
}
