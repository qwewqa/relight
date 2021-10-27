package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr

import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.JudgementShizuha
import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.StageGirlClaudine
import xyz.qwewqa.relive.simulator.core.presets.dress.back.flower.StageGirlMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.StageGirlHikari
import xyz.qwewqa.relive.simulator.core.presets.dress.back.moon.WorldMaya
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.DeathTamao
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlJunna
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlRui
import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.StageGirlYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.JusticeNana
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FoolYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud.StageGirlNana
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.DevilKaoruko
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.space.WheelOfFortuneKaren
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.dress.DressBlueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.EventBonusPassive

private val trArcanaDresses = listOf(
    DeathTamao,
    DevilKaoruko,
    FoolYachiyo,
    JudgementShizuha,
    JusticeNana,
    WheelOfFortuneKaren,
    WorldMaya,
)

private val stageGirlDresses = listOf(
    StageGirlClaudine,
    StageGirlHikari,
    StageGirlJunna,
    StageGirlMeiFan,
    StageGirlMisora,
    StageGirlNana,
    StageGirlRui,
    StageGirlYachiyo,
)

fun trEventBonusPassive(dress: DressBlueprint) = EventBonusPassive(
    trArcanaDresses.associateWith { 10 } + stageGirlDresses.associateWith { 40 } + mapOf(dress to 100),
).new()
