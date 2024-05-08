package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr42

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.FullNegativeEffectResistancePassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR37Diff3
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR38Diff4
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR42Diff4
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.TrDamageReductionPassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive2023V2
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive2024
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr42MusketeerHikari =
    ActorLoadout(
        "TR42 Musketeer Hikari",
        Dress(
            name = "Musketeer Hikari",
            character = Character.Hikari,
            attribute = Attribute.Space,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 375_000_000,
                actPower = 2100,
                normalDefense = 650,
                specialDefense = 650,
                agility = 100000,
            ),
            acts =
            actsOf(
            ),
            autoSkills =
            listOf(
                trEventBonusPassive2024(1010034),
                SuperBossPassiveTR37Diff3.new(),
            ),
        ),
    )

val tr42MusketeerHikariStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act3]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act8]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act3]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act1]
      +boss[ActType.Act6]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act8]
      +boss[ActType.Act6]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

val tr42MusketeerHikariDiff4 =
    ActorLoadout(
        "TR42 Musketeer Hikari Difficulty 4",
        Dress(
            name = "Musketeer Hikari",
            character = Character.Hikari,
            attribute = Attribute.Space,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_500_000_000,
                actPower = 10000,
                normalDefense = 10000,
                specialDefense = 10000,
                agility = 100000,
            ),
            acts =
            actsOf(
            ),
            autoSkills =
            listOf(
                trEventBonusPassive2024(1010034),
                SuperBossPassiveTR42Diff4.new(),
            ),
        ),
    )

val tr42MusketeerHikariDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act3]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act8]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act3]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act1]
      +boss[ActType.Act6]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act8]
      +boss[ActType.Act6]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
