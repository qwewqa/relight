package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr25

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

val tr25SuirenYuyuko =
    ActorLoadout(
        "TR25 Suiren Yuyuko",
        Dress(
            name = "Suiren Yuyuko",
            character = Character.Yuyuko,
            attribute = Attribute.Snow,
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
                    ActType.Act1("Violent Strike", 2) {
                      targetBack().act {
                        attack(
                            modifier = 100,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Triple Sharpshooting", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act3("Violent Triple Sharpshooting", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act5("Perfect Aim Flurry", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act6("Inspiring Gust", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.NormalDefenseUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.SpecialDefenseUpBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act7("Bewitching Dance", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                        applyContinuousBuff(
                            effect = Buffs.ConfusionBuff,
                            turns = 2,
                        )
                      }
                    },
                    ActType.ClimaxAct("Moonlight Rain NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 200,
                            hitCount = 4,
                        )
                        applyContinuousBuff(
                            effect = Buffs.ConfusionBuff,
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
                    trEventBonusPassive(1020024),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr25SuirenYuyukoStrategy = FixedStrategy {
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
    else -> {
      error("Unsupported.")
    }
  }
}

val tr25SuirenYuyukoDiff4 =
    ActorLoadout(
        "TR25 Suiren Yuyuko Difficulty 4",
        Dress(
            name = "Suiren Yuyuko",
            character = Character.Yuyuko,
            attribute = Attribute.Snow,
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
                    ActType.Act1("Violent Strike", 2) {
                      targetBack().act {
                        attack(
                            modifier = 100,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Triple Sharpshooting", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act3("Violent Triple Sharpshooting", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Counter Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act5("Perfect Aim Flurry", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act6("Inspiring Gust", 2) {
                      targetSelf().act {
                        applyContinuousBuff(
                            effect = Buffs.ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.NormalDefenseUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyContinuousBuff(
                            effect = Buffs.SpecialDefenseUpBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act7("Bewitching Dance", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                        applyContinuousBuff(
                            effect = Buffs.ConfusionBuff,
                            turns = 2,
                        )
                      }
                    },
                    ActType.ClimaxAct("Moonlight Rain NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 4,
                            mode = HitMode.FIXED,
                        )
                        applyContinuousBuff(
                            effect = Buffs.ConfusionBuff,
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
                    trEventBonusPassive(1020024),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr25SuirenYuyukoDiff4Strategy = FixedStrategy {
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
