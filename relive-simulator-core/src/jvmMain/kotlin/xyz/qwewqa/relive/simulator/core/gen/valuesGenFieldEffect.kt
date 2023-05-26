package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenFieldEffect: Map<Int, GenFieldEffect> by lazy {
  loadMasterData<GenFieldEffect>(dataGenFieldEffect)
}
