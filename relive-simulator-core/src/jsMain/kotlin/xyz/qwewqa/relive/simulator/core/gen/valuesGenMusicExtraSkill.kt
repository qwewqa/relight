package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenMusicExtraSkill: Map<Int, GenMusicExtraSkill> by lazy {
  loadJsMasterData(dataGenMusicExtraSkill) { id, data ->
    GenMusicExtraSkill(
        description = stringMapFromDynamic(data.description),
        name = stringMapFromDynamic(data.name),
        skill_option1_id = data.skill_option1_id.unsafeCast<Int>(),
        skill_option1_target_id = data.skill_option1_target_id.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
