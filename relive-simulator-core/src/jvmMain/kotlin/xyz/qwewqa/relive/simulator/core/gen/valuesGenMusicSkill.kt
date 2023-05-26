package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenMusicSkill: Map<Int, GenMusicSkill> by lazy {
  loadMasterData<GenMusicSkill>(dataGenMusicSkill)
}
