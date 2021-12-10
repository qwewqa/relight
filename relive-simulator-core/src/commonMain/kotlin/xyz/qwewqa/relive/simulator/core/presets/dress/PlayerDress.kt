package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.AceMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.JudgementShizuha
import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.StageGirlClaudine
import xyz.qwewqa.relive.simulator.core.presets.dress.back.flower.StageGirlMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.FuMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.StageGirlHikari
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.WorldMaya
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.*
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.IzanagiNana
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.JusticeNana
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.SanadaMahiru
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FoolYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.ImperialCombatRevueFlowerDivisionSakura
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.SakuraShingujiHikari
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.MitsuhideKaren
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlNana
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.*
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow.HopeLalafin
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon.*
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.space.WheelOfFortuneKaren
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.CatalinaKaoruko
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.HondaFutaba
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.TowerHikari

val playerDresses = listOf(
    AceMisora,
    AnastasiaJunna,
    CatalinaKaoruko,
    DeathTamao,
    DevilKaoruko,
    FoolYachiyo,
    FuMeiFan,
    HondaFutaba,
    HopeLalafin,
    ImperialCombatRevueFlowerDivisionSakura,
    IzanagiNana,
    JudgementShizuha,
    JusticeNana,
    MitsuhideKaren,
    MoonAruru,
    NewYorkCombatRevueGemie,
    ParisCombatRevueFlowerDivisionErika,
    SakuraShingujiHikari,
    SanadaMahiru,
    StageGirlClaudine,
    StageGirlHikari,
    StageGirlJunna,
    StageGirlMeiFan,
    StageGirlMichiru,
    StageGirlMisora,
    StageGirlNana,
    StageGirlRui,
    StageGirlYachiyo,
    SunIchie,
    TowerHikari,
    WheelOfFortuneKaren,
    WorldMaya,
).associateBy { it.name }
