package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillExecuteTiming: Map<Int, GenSkillExecuteTiming> by lazy {
  loadJsMasterData(dataGenSkillExecuteTiming) { id, data ->
    GenSkillExecuteTiming(
        description = stringMapFromDynamic(data.description),
        _id_ = id
    )
  }
}
