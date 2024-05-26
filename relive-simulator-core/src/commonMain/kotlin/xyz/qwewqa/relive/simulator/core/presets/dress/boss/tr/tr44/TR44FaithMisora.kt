package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr44

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassive2
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR37Diff3
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
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr44FaithMisora =
    ActorLoadout(
        "TR44 Faith Misora",
        Dress(
            name = "Faith Misora",
            character = Character.Misora,
            attribute = Attribute.Snow,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 500_000_000,
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
                trEventBonusPassive2024(2010033, 1070031),
                SuperBossPassiveTR37Diff3.new(),
            ),
        ),
    )

val tr44FaithMisoraStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act2]
      +boss[ActType.Act9]
    }
    2 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act5]
      +boss[ActType.Act10]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act9]
      +boss[ActType.Act7]
    }
    4 -> {
      +boss[ActType.Act3]
      +boss[ActType.Act6]
      +boss[ActType.Act10]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act6]
      +boss[ActType.Act9]
    }
    6 -> {
      +boss[ActType.Act5]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

val tr44FaithMisoraDiff4 =
    ActorLoadout(
        "TR44 Faith Misora Difficulty 4",
        Dress(
            name = "Faith Misora",
            character = Character.Misora,
            attribute = Attribute.Snow,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 2_000_000_000,
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
                trEventBonusPassive2024(2010033, 1070031),
                SuperBossPassiveTR42Diff4.new(),
            ),
        ),
    )

val tr44FaithMisoraDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act2]
      +boss[ActType.Act9]
    }
    2 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act5]
      +boss[ActType.Act10]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act9]
      +boss[ActType.Act7]
    }
    4 -> {
      +boss[ActType.Act3]
      +boss[ActType.Act6]
      +boss[ActType.Act10]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act6]
      +boss[ActType.Act9]
    }
    6 -> {
      +boss[ActType.Act5]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
