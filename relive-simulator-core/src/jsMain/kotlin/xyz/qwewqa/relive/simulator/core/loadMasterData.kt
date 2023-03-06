package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromDynamic

@OptIn(ExperimentalSerializationApi::class)
actual inline fun <reified T> loadMasterData(data: String): Map<Int, T> =
    Json.decodeFromDynamic(JSON.parse(data))
