package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.DeathTamao
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlRui
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlRui95
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FoolYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.TowerHikari

val playerDresses = listOf(
    StageGirlRui,
    StageGirlRui95,
    DeathTamao,
    TowerHikari,
    FoolYachiyo,
).associateBy { it.name }