package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenGrowthPanel: Map<Int, GenGrowthPanel> by lazy {
  loadMasterData<GenGrowthPanel>(dataGenGrowthPanel)
}
