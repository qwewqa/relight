package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenRemakeSkill: Map<Int, GenRemakeSkill> by lazy {
  loadJsMasterData(dataGenRemakeSkill) { id, data ->
    GenRemakeSkill(
        auto_skill_type = data.auto_skill_type.unsafeCast<Int>(),
        description = stringMapFromDynamic(data.description),
        icon_id = data.icon_id.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
