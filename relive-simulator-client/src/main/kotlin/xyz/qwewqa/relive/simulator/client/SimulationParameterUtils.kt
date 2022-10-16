package xyz.qwewqa.relive.simulator.client

import xyz.qwewqa.relive.simulator.common.SimulationParameters

fun SimulationParameters.inferSupports(): SimulationParameters {
    if (team.any { it.isSupport }) return this
    val seenDresses = mutableSetOf<String>()
    return this.copy(
        team = team.map { actor ->
            actor.copy(
                isSupport = !seenDresses.add(actor.dress),
            )
        }
    )
}
