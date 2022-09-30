package xyz.qwewqa.relive.simulator.core.stage

data class StageConfiguration(
    var logging: Boolean = false,
    var skipLogging: Int = 0,
    val debug: Boolean = false,
)
