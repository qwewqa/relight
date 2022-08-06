package xyz.qwewqa.relive.simulator.client

import kotlinx.serialization.Serializable
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters


@Serializable
data class UserSettings(
    val timestamp: Long = 0,
    val presets: MutableMap<String, PlayerLoadoutParameters> = mutableMapOf(),
)
