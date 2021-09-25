package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.DeathTamao
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlRui
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlRui95

val playerDresses = listOf(
    StageGirlRui,
    StageGirlRui95,
    DeathTamao,
).associateBy { it.name }