package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenMusic: Map<Int, GenMusic> by lazy {
  loadMasterData<GenMusic>(dataGenMusic)
}
