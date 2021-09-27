package xyz.qwewqa.relive.simulator.client

interface Simulator {
    suspend fun simulate(parameters: SimulationParameters): Simulation
    suspend fun getOptions(): SimulationOptionNames
    suspend fun shutdown()
}

interface Simulation {
    suspend fun pollResult(): SimulationResult
    suspend fun cancel()
}
