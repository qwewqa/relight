package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr19

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position

val tr19SetsunaIchie =
    ActorLoadout(
        "TR19 Setsuna Ichie",
        Dress(
            name = "Setsuna Ichie",
            character = Character.Ichie,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 3_000_000,
                    actPower = 2300,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Strong Flash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Violent Twin Flash", 2) {
                      targetFront(2).act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act3("Triple Flash", 2) {
                      targetFront(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Violent Triple Flash", 2) {
                      targetFront(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act5("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act6("Weakening Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act7("Purifying Dance", 2) {
                      targetSelf().act { removeContinuous(BuffCategory.Negative) }
                      targetAoe().act { removeContinuous(BuffCategory.Positive) }
                    },
                    ActType.Act8("Noxious Flower Dance", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PoisonBuff,
                            value = 10000,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Flower Festival Type 3 NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 200,
                            hitCount = 4,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PoisonBuff,
                            value = 10000,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ConfusionAct("Slash", 2) {
                      targetAllyRandom().act {
                        attack(
                            modifier = 105,
                            hitCount = 1,
                        )
                      }
                    },
                ),
            autoSkills =
                listOf(
                    trEventBonusPassive(1040024),
                    AbnormalGuardPassive.new(),
                ),
        ),
    )

val tr19SetsunaIchieStrategy = FixedStrategy {
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

val tr19SetsunaIchieDiff4 =
    ActorLoadout(
        "TR19 Setsuna Ichie Difficulty 4",
        Dress(
            name = "Setsuna Ichie",
            character = Character.Ichie,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 120_000_000,
                    actPower = 10000,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Strong Flash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Violent Twin Flash", 2) {
                      targetFront(2).act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act3("Triple Flash", 2) {
                      targetFront(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Violent Triple Flash", 2) {
                      targetFront(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act5("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act6("Weakening Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act7("Purifying Dance", 2) {
                      targetSelf().act { removeContinuous(BuffCategory.Negative) }
                      targetAoe().act { removeContinuous(BuffCategory.Positive) }
                    },
                    ActType.Act8("Noxious Flower Dance", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PoisonBuff,
                            value = 99999,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Flower Festival Type 3 NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 4,
                            mode = HitMode.FIXED,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PoisonBuff,
                            value = 99999,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ConfusionAct("Slash", 2) {
                      targetAllyRandom().act {
                        attack(
                            modifier = 105,
                            hitCount = 1,
                        )
                      }
                    },
                ),
            autoSkills =
                listOf(
                    trEventBonusPassive(1040024),
                    AbnormalGuardPassive.new(),
                ),
        ),
    )

val tr19SetsunaIchieDiff4Strategy = FixedStrategy {
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
