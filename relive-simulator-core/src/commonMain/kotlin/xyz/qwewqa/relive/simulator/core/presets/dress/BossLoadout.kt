package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr10.tr10FaithMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr10.tr10FaithMisoraStrategy
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr10.tr10VampireShiori
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr10.tr10VampireShioriStrategy
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9FaithMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9FaithMisoraStrategy
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.Strategy

data class BossLoadout(val loadout: ActorLoadout, val strategy: Strategy)

val bossLoadouts = listOf(
    BossLoadout(tr9FaithMisora, tr9FaithMisoraStrategy),
    BossLoadout(tr10VampireShiori, tr10VampireShioriStrategy),
    BossLoadout(tr10FaithMisora, tr10FaithMisoraStrategy),
).associateBy { it.loadout.name }
