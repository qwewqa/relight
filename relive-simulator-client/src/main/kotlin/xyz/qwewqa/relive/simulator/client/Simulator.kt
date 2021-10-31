package xyz.qwewqa.relive.simulator.client

import xyz.qwewqa.relive.simulator.common.*

interface Simulator {
    suspend fun simulate(parameters: SimulationParameters): Simulation
    suspend fun version(): SimulatorVersion
    suspend fun options(): SimulationOptions
    suspend fun shutdown()
    suspend fun features(): SimulatorFeatures
}

interface Simulation {
    suspend fun pollResult(): SimulationResult
    suspend fun cancel()
}
