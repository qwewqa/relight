package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenGrowthBoard: Map<Int, GenGrowthBoard> by lazy {
  loadMasterData<GenGrowthBoard>(dataGenGrowthBoard)
}
