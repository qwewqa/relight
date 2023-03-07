package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr15

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position

val tr15CheerYachiyo =
    ActorLoadout(
        "TR15 Cheer Yachiyo",
        Dress(
            name = "Cheer Yachiyo",
            character = Character.Yachiyo,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 4_500_000,
                    actPower = 2300,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Slash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 100,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Violent Slash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 200,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 100,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act4("Violent Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 150,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act5("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 80,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act6("Violent Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 120,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act7("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 100,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act8("Deterrence Slash", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.StunBuff,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act9("Weakening Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Beautiful Pose♪ NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 200,
                            hitCount = 4,
                        )
                        applyContinuousBuff(
                            effect = Buffs.StunBuff,
                            turns = 2,
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
                    trEventBonusPassive(1030021),
                    AbnormalGuardPassive.new(),
                ),
        ),
    )

val tr15CheerYachiyoStrategy = FixedStrategy {
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
      +boss[ActType.Act9]
      +boss[ActType.Act6]
      +boss[ActType.ClimaxAct]
    }
    4 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act8]
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

val tr15CheerYachiyoDiff4 =
    ActorLoadout(
        "TR15 Cheer Yachiyo Difficulty 4",
        Dress(
            name = "Cheer Yachiyo",
            character = Character.Yachiyo,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 180_000_000,
                    actPower = 10000,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Slash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 100,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Violent Slash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 200,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 100,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act4("Violent Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 150,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act5("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 80,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act6("Violent Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 120,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act7("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 100,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act8("Deterrence Slash", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 3,
                            mode = HitMode.FIXED,
                        )
                        applyContinuousBuff(
                            effect = Buffs.StunBuff,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act9("Weakening Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Beautiful Pose♪ NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 4,
                            mode = HitMode.FIXED,
                        )
                        applyContinuousBuff(
                            effect = Buffs.StunBuff,
                            turns = 2,
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
                    trEventBonusPassive(1030021),
                    AbnormalGuardPassive.new(),
                ),
        ),
    )

val tr15CheerYachiyoDiff4Strategy = FixedStrategy {
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
      +boss[ActType.Act9]
      +boss[ActType.Act6]
      +boss[ActType.ClimaxAct]
    }
    4 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act8]
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
