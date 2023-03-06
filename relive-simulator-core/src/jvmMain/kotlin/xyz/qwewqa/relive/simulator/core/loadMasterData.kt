package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

actual inline fun <reified T> loadMasterData(data: String): Map<Int, T> = Json.decodeFromString(data)
