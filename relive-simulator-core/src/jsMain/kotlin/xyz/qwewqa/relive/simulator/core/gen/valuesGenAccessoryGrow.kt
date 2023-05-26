package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenAccessoryGrow: Map<Int, List<Int>> by lazy {
  loadJsMasterData(dataGenAccessoryGrow) { id, data -> listFromDynamic(data) }
}
