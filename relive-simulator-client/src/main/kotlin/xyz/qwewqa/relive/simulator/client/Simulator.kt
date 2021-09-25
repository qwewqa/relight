package xyz.qwewqa.relive.simulator.client

interface Simulator {
    suspend fun simulate(parameters: SimulationParameters): Simulation
    suspend fun getOptions(): SimulationOptionNames
}

interface Simulation {
    suspend fun pollResult(): SimulationResult
    suspend fun cancel()
}
