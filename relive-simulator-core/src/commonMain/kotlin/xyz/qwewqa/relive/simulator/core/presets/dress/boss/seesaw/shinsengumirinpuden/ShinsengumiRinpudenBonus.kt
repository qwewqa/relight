package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.shinsengumirinpuden

import xyz.qwewqa.relive.simulator.core.presets.dress.back.flower.KondoIsamiIchie
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon.HijikataToshizoTamao
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow.NagakuraShinpachiFumi
import xyz.qwewqa.relive.simulator.core.stage.passive.EventBonusPassive
import xyz.qwewqa.relive.simulator.stage.character.Character

val shinsengumiRinpudenBonusPassive = EventBonusPassive(
    dresses = mapOf(
        HijikataToshizoTamao.id to 500,
        KondoIsamiIchie.id to 500,
        NagakuraShinpachiFumi.id to 500,
    ),
    characters = mapOf(
        Character.Tamao to 50,
        Character.Rui to 50,
        Character.Yuyuko to 50,
        Character.Ichie to 50,
        Character.Fumi to 50,
    )
)