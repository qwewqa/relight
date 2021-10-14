package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.AceMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.AceMisora95
import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.JudgementShizuha
import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.StageGirlClaudine
import xyz.qwewqa.relive.simulator.core.presets.dress.back.flower.StageGirlMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.back.flower.StageGirlMeiFan95
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.FuMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.FuMeiFan95
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.WorldMaya
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.StageGirlHikariBaby
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.*
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.IzanagiNana
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.JusticeNana
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FoolYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.SanadaMahiru
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.MitsuhideKaren
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlNana
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlNanaBaby
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.DevilKaoruko
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.space.WheelOfFortuneKaren
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.TowerHikari
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.HondaFutaba
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.HondaFutaba95
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind.CatalinaKaoruko

val playerDresses = listOf(
    StageGirlRui,
    StageGirlRui95,
    DeathTamao,
    TowerHikari,
    FoolYachiyo,
    HondaFutaba,
    HondaFutaba95,
    CatalinaKaoruko,
    SanadaMahiru,
    DevilKaoruko,
    StageGirlMeiFan,
    StageGirlMeiFan95,
    JudgementShizuha,
    MitsuhideKaren,
    FuMeiFan,
    FuMeiFan95,
    WorldMaya,
    StageGirlNana,
    StageGirlNanaBaby,
    StageGirlJunna,
    IzanagiNana,
    JusticeNana,
    WheelOfFortuneKaren,
    StageGirlYachiyo,
    AceMisora,
    AceMisora95,
    StageGirlClaudine,
    StageGirlMisora,
    StageGirlHikariBaby,
).associateBy { it.name }
