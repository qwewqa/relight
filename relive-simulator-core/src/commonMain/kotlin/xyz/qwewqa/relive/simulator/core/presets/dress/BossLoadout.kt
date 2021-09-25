package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9FaithMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9FaithMisoraStrategy
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.Strategy

val bossLoadouts = listOf(
    BossLoadout(tr9FaithMisora, tr9FaithMisoraStrategy)
).associateBy { it.loadout.name }

data class BossLoadout(val loadout: ActorLoadout, val strategy: Strategy)
