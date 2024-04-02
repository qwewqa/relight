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

val tr41SuirenYuyuko =
    ActorLoadout(
        "TR41 Suiren Yuyuko",
        Dress(
            name = "Suiren Yuyuko",
            character = Character.Yuyuko,
            attribute = Attribute.Wind,
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
                trEventBonusPassive2023V2(1040035),
                SuperBossPassiveTR37Diff3.new(),
            ),
        ),
    )

val tr41SuirenYuyukoStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act2]
      +boss[ActType.Act6]
    }
    2 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act3]
      +boss[ActType.Act6]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act5]
      +boss[ActType.Act4]
    }
    4 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    5 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act5]
      +boss[ActType.Act4]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

val tr41SuirenYuyukoDiff4 =
    ActorLoadout(
        "TR41 Suiren Yuyuko Difficulty 4",
        Dress(
            name = "Suiren Yuyuko",
            character = Character.Yuyuko,
            attribute = Attribute.Wind,
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
                trEventBonusPassive2023V2(1040035),
                SuperBossPassiveTR38Diff4.new(),
            ),
        ),
    )

val tr41SuirenYuyukoDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act2]
      +boss[ActType.Act6]
    }
    2 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act3]
      +boss[ActType.Act6]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act5]
      +boss[ActType.Act4]
    }
    4 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    5 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act5]
      +boss[ActType.Act4]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
