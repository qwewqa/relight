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
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.MitsuhideKaren
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlNana
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.DevilKaoruko
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.NewYorkCombatRevueGemie
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon.ParisCombatRevueFlowerDivisionErika
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.space.WheelOfFortuneKaren
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.CatalinaKaoruko
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.HondaFutaba
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.TowerHikari

val playerDresses = listOf(
    AceMisora,
    CatalinaKaoruko,
    DeathTamao,
    DevilKaoruko,
    FoolYachiyo,
    FuMeiFan,
    HondaFutaba,
    ImperialCombatRevueFlowerDivisionSakura,
    IzanagiNana,
    JudgementShizuha,
    JusticeNana,
    MitsuhideKaren,
    NewYorkCombatRevueGemie,
    ParisCombatRevueFlowerDivisionErika,
    SanadaMahiru,
    StageGirlClaudine,
    StageGirlHikari,
    StageGirlJunna,
    StageGirlMeiFan,
    StageGirlMisora,
    StageGirlNana,
    StageGirlRui,
    StageGirlYachiyo,
    TowerHikari,
    WheelOfFortuneKaren,
    WorldMaya,
).associateBy { it.name }
