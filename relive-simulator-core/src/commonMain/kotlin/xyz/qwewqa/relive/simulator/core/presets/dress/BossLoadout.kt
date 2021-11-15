package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen.sakuraTaisenStageGirlKarenBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.seesawStrategy
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr10.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr11.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr12.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr9.tr9FaithMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr9.tr9FaithMisoraStrategy
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.Strategy

data class BossLoadout(val loadout: ActorLoadout, val strategy: Strategy)

val bossLoadouts = listOf(
    BossLoadout(tr9FaithMisora, tr9FaithMisoraStrategy),
    BossLoadout(tr10DraculaClaudine, tr10DraculaClaudineStrategy),
    BossLoadout(tr10VampireShiori, tr10VampireShioriStrategy),
    BossLoadout(tr10HellsingMichiru, tr10HellsingMichiruStrategy),
    BossLoadout(tr10FaithMisora, tr10FaithMisoraStrategy),
    BossLoadout(tr11CheerAkira, tr11CheerAkiraStrategy),
    BossLoadout(tr11CheerTsukasa, tr11CheerTsukasaStrategy),
    BossLoadout(tr11CheerYachiyo, tr11CheerYachiyoStrategy),
    BossLoadout(tr11FaithMisora, tr11FaithMisoraStrategy),
    BossLoadout(tr12Boss2, tr12Boss2Strategy),
    BossLoadout(tr12Boss2Seisho, tr12Boss2SeishoStrategy),
    BossLoadout(tr12TowerHikari, tr12TowerHikariStrategy),
    BossLoadout(sakuraTaisenStageGirlKarenBoss, seesawStrategy),
).associateBy { it.loadout.name }
