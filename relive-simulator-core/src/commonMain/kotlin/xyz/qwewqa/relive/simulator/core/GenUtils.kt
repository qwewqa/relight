@file:Suppress("PackageDirectoryMismatch")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

inline fun <reified T> loadMasterData(data: String): Map<Int, T> = Json.decodeFromString(data)

fun Map<String, String>.getLocalizedString(lang: String = "en") =
    this[lang] ?: this["en"] ?: this["ja"] ?: "Unknown"
