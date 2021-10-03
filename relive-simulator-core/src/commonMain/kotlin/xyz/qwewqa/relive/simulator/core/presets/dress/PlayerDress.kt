package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.DeathTamao
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlRui
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlRui95
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FoolYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.SanadaMahiru
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.TowerHikari
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.HondaFutaba
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.CatalinaKaoruko

val playerDresses = listOf(
    StageGirlRui,
    StageGirlRui95,
    DeathTamao,
    TowerHikari,
    FoolYachiyo,
    HondaFutaba,
    CatalinaKaoruko,
    SanadaMahiru
).associateBy { it.name }