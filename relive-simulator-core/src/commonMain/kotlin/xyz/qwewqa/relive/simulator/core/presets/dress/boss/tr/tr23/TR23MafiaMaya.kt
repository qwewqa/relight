package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr23

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
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

val tr23MafiaMaya =
    ActorLoadout(
        "TR23 Mafia Maya",
        Dress(
            name = "Mafia Maya",
            character = Character.Maya,
            attribute = Attribute.Flower,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 8_750_000,
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
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Triple Slash", 2) {
                      targetFront(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Violent Triple Slash", 2) {
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
                    ActType.Act6("Pursuit Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act7("Helpless Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.DexterityDownBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.CriticalDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act8("Perfect Aim Flurry", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.ClimaxAct("Maid's Etiquette NEO", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(
                            modifier = 200,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.ConfusionAct("Strike", 2) {
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
                    trEventBonusPassive(1030024),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr23MafiaMayaStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.ClimaxAct]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act4]
      +boss[ActType.Act6]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act8]
      +boss[ActType.Act6]
    }
    else -> error("Not supported.")
  }
}

val tr23MafiaMayaDiff4 =
    ActorLoadout(
        "TR23 Mafia Maya Difficulty 4",
        Dress(
            name = "Mafia Maya",
            character = Character.Maya,
            attribute = Attribute.Flower,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 450_000_000,
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
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Triple Slash", 2) {
                      targetFront(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Violent Triple Slash", 2) {
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
                    ActType.Act6("Pursuit Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act7("Helpless Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.DexterityDownBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.CriticalDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act8("Perfect Aim Flurry", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act9("Perfect Aim Flurry", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(modifier = 99999, hitCount = 4, mode = HitMode.FIXED)
                      }
                    },
                    ActType.ClimaxAct("Maid's Etiquette NEO", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(modifier = 99999, hitCount = 4, mode = HitMode.FIXED)
                      }
                    },
                    ActType.ConfusionAct("Strike", 2) {
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
                    trEventBonusPassive(1030024),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr23MafiaMayaDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    3 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.ClimaxAct]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act4]
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
