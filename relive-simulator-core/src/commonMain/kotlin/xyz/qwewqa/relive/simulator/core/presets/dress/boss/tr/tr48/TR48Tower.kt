package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr48

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR46Diff3
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR46Diff4
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

val tr48TowerHikari =
  ActorLoadout(
    "TR48 Tower Hikari",
    Dress(
      name = "Tower Hikari",
      character = Character.Hikari,
      attribute = Attribute.Wind,
      damageType = DamageType.Normal,
      position = Position.Front,
      stats =
      defaultDressStats.copy(
        hp = 75_000_000,
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
        trEventBonusPassive2024(1010037),
        SuperBossPassiveTR46Diff3.new()
      ),
    ),
  )

val tr48TowerHikariStrategy = FixedStrategy {
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

val tr48TowerHikariDiff4 =
  ActorLoadout(
    "TR48 Tower Hikari Difficulty 4",
    Dress(
      name = "Tower Hikari",
      character = Character.Hikari,
      attribute = Attribute.Wind,
      damageType = DamageType.Normal,
      position = Position.Front,
      stats =
      defaultDressStats.copy(
        hp = 400_000_000,
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
        trEventBonusPassive2024(1010037),
        SuperBossPassiveTR46Diff4.new()
      ),
    ),
  )

val tr48TowerHikariDiff4Strategy = FixedStrategy {
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

