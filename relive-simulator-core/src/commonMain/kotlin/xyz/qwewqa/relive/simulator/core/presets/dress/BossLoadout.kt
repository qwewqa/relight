package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen.sakuraTaisenStageGirlHikariBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen.sakuraTaisenStageGirlKarenBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen.sakuraTaisenStageGirlMahiruBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.seesawStrategy
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr10.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr11.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr12.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr13.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr14.*
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
    BossLoadout(tr12VampireShiori, tr12VampireShioriStrategy),
    BossLoadout(tr12TowerHikari, tr12TowerHikariStrategy),
    BossLoadout(tr13SetsunaIchie, tr13SetsunaIchieStrategy),
    BossLoadout(tr13SetsunaIchieDiff4, tr13SetsunaIchieDiff4Strategy),
    BossLoadout(tr13SuirenYuyuko, tr13SuirenYuyukoStrategy),
    BossLoadout(tr13SuirenYuyukoDiff4, tr13SuirenYuyukoDiff4Strategy),
    BossLoadout(tr13KomachiTamao, tr13KomachiTamaoStrategy),
    BossLoadout(tr13KomachiTamaoDiff4, tr13KomachiTamaoDiff4Strategy),
    BossLoadout(tr13EmperorAkira, tr13EmperorAkiraStrategy),
    BossLoadout(tr13EmperorAkiraDiff4, tr13EmperorAkiraStrategy),
    BossLoadout(tr14MusketeerKaren, tr14MusketeerKarenStrategy),
    BossLoadout(tr14MusketeerKarenDiff4, tr14MusketeerKarenDiff4Strategy),
    BossLoadout(tr14MusketeerHikari, tr14MusketeerHikariStrategy),
    BossLoadout(tr14MusketeerHikariDiff4, tr14MusketeerHikariDiff4Strategy),
    BossLoadout(tr14MusketeerMahiru, tr14MusketeerMahiruStrategy),
    BossLoadout(tr14MusketeerMahiruDiff4, tr14MusketeerMahiruDiff4Strategy),
    BossLoadout(tr14EmperorAkira, tr14EmperorAkiraStrategy),
    BossLoadout(tr14EmperorAkiraDiff4, tr14EmperorAkiraDiff4Strategy),
    BossLoadout(sakuraTaisenStageGirlKarenBoss, seesawStrategy),
    BossLoadout(sakuraTaisenStageGirlHikariBoss, seesawStrategy),
    BossLoadout(sakuraTaisenStageGirlMahiruBoss, seesawStrategy),
).associateBy { it.loadout.name }
