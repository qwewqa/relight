package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenMusicSkill: Map<Int, GenMusicSkill> by lazy {
  loadJsMasterData(dataGenMusicSkill) { id, data ->
    GenMusicSkill(
        description = stringMapFromDynamic(data.description),
        name = stringMapFromDynamic(data.name),
        published_at = data.published_at.unsafeCast<Int>(),
        skill_option1_id = data.skill_option1_id.unsafeCast<Int>(),
        skill_option1_target_id = data.skill_option1_target_id.unsafeCast<Int>(),
        skill_option1_value = data.skill_option1_value.unsafeCast<Int>(),
        skill_option1_values = listFromDynamic(data.skill_option1_values),
        _id_ = id,
    )
  }
}
