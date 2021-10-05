package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.JudgementShizuha
import xyz.qwewqa.relive.simulator.core.presets.dress.back.flower.StageGirlMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.FuMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.WorldMaya
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.*
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.IzanagiNana
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.JusticeNana
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FoolYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.SanadaMahiru
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.MitsuhideKaren
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlNana
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.DevilKaoruko
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.space.WheelOfFortuneKaren
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
    SanadaMahiru,
    DevilKaoruko,
    StageGirlMeiFan,
    JudgementShizuha,
    MitsuhideKaren,
    FuMeiFan,
    WorldMaya,
    StageGirlNana,
    StageGirlJunna,
    IzanagiNana,
    JusticeNana,
    WheelOfFortuneKaren,
    StageGirlYachiyo
).associateBy { it.name }