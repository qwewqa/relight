package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr46

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.BossDmgTakenDown90
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR37Diff3
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR42Diff4
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive2024
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr46TowerHikari =
    ActorLoadout(
        "TR46 Tower Hikari",
        Dress(
            name = "Tower Hikari",
            character = Character.Hikari,
            attribute = Attribute.Moon,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 50_000_000,
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
                trEventBonusPassive2024(4050028, 1060031),
                SuperBossPassiveTR37Diff3.new(),
                BossDmgTakenDown90.new(),
            ),
        ),
    )

val tr46TowerHikariStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act2]
      +boss[ActType.Act3]
    }
    2 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act3]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act5]
      +boss[ActType.Act8]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act3]
      +boss[ActType.Act6]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    6 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act5]
      +boss[ActType.Act6]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

val tr46TowerHikariDiff4 =
    ActorLoadout(
        "TR46 Tower Hikari Difficulty 4",
        Dress(
            name = "Tower Hikari",
            character = Character.Hikari,
            attribute = Attribute.Moon,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 200_000_000,
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
                trEventBonusPassive2024(4050028, 1060031),
                SuperBossPassiveTR42Diff4.new(),
                BossDmgTakenDown90.new(),
            ),
        ),
    )

val tr46TowerHikariDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act2]
      +boss[ActType.Act3]
    }
    2 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act3]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act5]
      +boss[ActType.Act8]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act3]
      +boss[ActType.Act6]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    6 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act5]
      +boss[ActType.Act6]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

