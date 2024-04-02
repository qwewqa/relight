package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr41

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR37Diff3
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassiveTR38Diff4
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive2023V2
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

val tr41SetsunaIchie =
    ActorLoadout(
        "TR41 Setsuna Ichie",
        Dress(
            name = "Setsuna Ichie",
            character = Character.Ichie,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 300_000_000,
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
                trEventBonusPassive2023V2(1040035),
                SuperBossPassiveTR37Diff3.new(),
            ),
        ),
    )

val tr41SetsunaIchieStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    2 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    else -> error("Not supported.")
  }
}

val tr41SetsunaIchieDiff4 =
    ActorLoadout(
        "TR41 Setsuna Ichie Difficulty 4",
        Dress(
            name = "Setsuna Ichie",
            character = Character.Ichie,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_200_000_000,
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
                trEventBonusPassive2023V2(1040035),
                SuperBossPassiveTR38Diff4.new(),
            ),
        ),
    )

val tr41SetsunaIchieDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    2 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    else -> error("Not supported.")
  }
}
