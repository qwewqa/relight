package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr39

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.FullNegativeEffectResistancePassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassive1
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR37Diff3
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR38Diff4
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
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr39CheerYachiyo =
    ActorLoadout(
        "TR39 Cheer Yachiyo",
        Dress(
            name = "Cheer Yachiyo",
            character = Character.Yachiyo,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 450_000_000,
                actPower = 2300,
                normalDefense = 650,
                specialDefense = 650,
                agility = 100000,
            ),
            acts =
            actsOf(
            ),
            autoSkills =
            listOf(
                trEventBonusPassive2024(1030031),
                SuperBossPassiveTR37Diff3.new(),
            ),
        ),
    )

val tr39CheerYachiyoStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act5]
      +boss[ActType.Act9]
    }
    2 -> {
      +boss[ActType.Act4]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act9]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act9]
      +boss[ActType.Act7]
    }
    6 -> {
      +boss[ActType.Act4]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    else -> error("Not supported.")
  }
}

val tr39CheerYachiyoDiff4 =
    ActorLoadout(
        "TR39 Cheer Yachiyo Difficulty 4",
        Dress(
            name = "Cheer Yachiyo",
            character = Character.Yachiyo,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_800_000_000,
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
                trEventBonusPassive2024(1030031),
                SuperBossPassiveTR38Diff4.new(),
            ),
        ),
    )

val tr39CheerYachiyoDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act5]
      +boss[ActType.Act9]
    }
    2 -> {
      +boss[ActType.Act4]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act9]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act9]
      +boss[ActType.Act7]
    }
    6 -> {
      +boss[ActType.Act4]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
