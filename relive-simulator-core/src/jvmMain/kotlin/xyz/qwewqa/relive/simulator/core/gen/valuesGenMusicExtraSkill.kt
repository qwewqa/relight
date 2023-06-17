package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenMusicExtraSkillBase: Map<Int, GenMusicExtraSkill> by lazy {
  loadMasterData<GenMusicExtraSkill>(dataGenMusicExtraSkill)
}
