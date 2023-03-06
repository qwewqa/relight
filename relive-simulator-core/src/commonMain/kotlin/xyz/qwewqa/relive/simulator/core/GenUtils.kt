@file:Suppress("PackageDirectoryMismatch")

package xyz.qwewqa.relive.simulator.core.gen

expect inline fun <reified T> loadMasterData(data: String): Map<Int, T>

fun Map<String, String>.getLocalizedString(lang: String = "en") =
    this[lang] ?: this["en"] ?: this["ja"] ?: "Unknown"
