package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr10.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr12.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9FaithMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9FaithMisoraStrategy
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.Strategy

data class BossLoadout(val loadout: ActorLoadout, val strategy: Strategy)

val bossLoadouts = listOf(
    BossLoadout(tr9FaithMisora, tr9FaithMisoraStrategy),
    BossLoadout(tr10VampireShiori, tr10VampireShioriStrategy),
    BossLoadout(tr10HellsingMichiru, tr10HellsingMichiruStrategy),
    BossLoadout(tr10FaithMisora, tr10FaithMisoraStrategy),
    BossLoadout(tr12Boss2, tr12Boss2Strategy),
    BossLoadout(tr12Boss2Seisho, tr12Boss2SeishoStrategy),
    BossLoadout(tr12TowerHikari, tr12TowerHikariStrategy),
).associateBy { it.loadout.name }
