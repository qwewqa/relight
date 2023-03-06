package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr15

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position

val tr15TowerHikari =
    ActorLoadout(
        "TR15 Tower Hikari",
        Dress(
            name = "Tower Hikari",
            character = Character.Hikari,
            attribute = Attribute.Wind,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 5_000_000,
                    actPower = 2300,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Counter Solo", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 3,
                        )
                      }
                      targetSelf().act {
                        applyTimedBuff(
                            effect = Buffs.NormalReflectBuff,
                            value = 30,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act2("Violent Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 80,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act4("Violent Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act5("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act6("Violent Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act7("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act8("Inspiring Gust", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = Buffs.DexterityUpBuff,
                            value = 30,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = Buffs.CriticalUpBuff,
                            value = 30,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act9("Restraint Firedance", 2) {
                      targetAoe().act {
                        applyTimedBuff(
                            effect = Buffs.BurnBuff,
                            value = 7000,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = Buffs.StunBuff,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act10("Weakening Concerto", 2) {
                      targetAoe().act {
                        applyTimedBuff(
                            effect = Buffs.ActPowerDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Tower's Conviction NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 200,
                            hitCount = 3,
                        )
                      }
                      targetSelf().act {
                        applyTimedBuff(
                            effect = Buffs.NormalReflectBuff,
                            value = 30,
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
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr15TowerHikariStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act4]
      +boss[ActType.Act6]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act9]
    }
    4 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act7]
      +boss[ActType.Act8]
    }
    6 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

val tr15TowerHikariDiff4 =
    ActorLoadout(
        "TR15 Tower Hikari Difficulty 4",
        Dress(
            name = "Tower Hikari",
            character = Character.Hikari,
            attribute = Attribute.Wind,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 200_000_000,
                    actPower = 10000,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Counter Solo", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 3,
                        )
                      }
                      targetSelf().act {
                        applyTimedBuff(
                            effect = Buffs.NormalReflectBuff,
                            value = 30,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act2("Violent Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 80,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act4("Violent Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act5("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act6("Violent Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act7("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act8("Inspiring Gust", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = Buffs.DexterityUpBuff,
                            value = 30,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = Buffs.CriticalUpBuff,
                            value = 30,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act9("Restraint Firedance", 2) {
                      targetAoe().act {
                        applyTimedBuff(
                            effect = Buffs.BurnBuff,
                            value = 99999,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = Buffs.StunBuff,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act10("Weakening Concerto", 2) {
                      targetAoe().act {
                        applyTimedBuff(
                            effect = Buffs.ActPowerDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Tower's Conviction NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 3,
                            mode = HitMode.FIXED,
                        )
                      }
                      targetSelf().act {
                        applyTimedBuff(
                            effect = Buffs.NormalReflectBuff,
                            value = 30,
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
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr15TowerHikariDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act10]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act4]
      +boss[ActType.Act6]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act9]
    }
    4 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act7]
      +boss[ActType.Act8]
    }
    6 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act6]
      +boss[ActType.Act7]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
