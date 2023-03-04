package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr17

import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.HuntingRevueJunna
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.core.stage.passive.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val tr17VampireShiori =
    ActorLoadout(
        "TR17 Vampire Shiori",
        Dress(
            name = "Vampire Shiori",
            character = Character.Shiori,
            attribute = Attribute.Flower,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 3_500_000,
                    actPower = 2100,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Violent Slash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act3("Violent Triple Thrust", 2) {
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
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act5("Pursuit Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act6("Perfect Aim Concerto", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act7("Purifying Dance", 2) {
                      targetSelf().act { dispelTimed(BuffCategory.Negative) }
                      targetAoe().act { dispelTimed(BuffCategory.Positive) }
                    },
                    ActType.Act8("Ironclad Dance", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = NormalBarrierBuff,
                            value = 10000,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = SpecialBarrierBuff,
                            value = 10000,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act9("Fierce Dance", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 3,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
                            value = 7000,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Bloody Full Moon NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 200,
                            hitCount = 3,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
                            value = 7000,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ConfusionAct("Thrust", 2) {
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
                    trEventBonusPassive(HuntingRevueJunna),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr17VampireShioriStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act1]
      +boss[ActType.Act2]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    else -> error("Not supported.")
  }
}

val tr17VampireShioriDiff4 =
    ActorLoadout(
        "TR17 Vampire Shiori Difficulty 4",
        Dress(
            name = "Vampire Shiori",
            character = Character.Shiori,
            attribute = Attribute.Flower,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 150_000_000,
                    actPower = 10000,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Violent Slash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act3("Violent Triple Thrust", 2) {
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
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act5("Pursuit Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                      }
                    },
                    ActType.Act6("Perfect Aim Concerto", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            PerfectAimBuff,
                            turns = 1,
                        )
                      }
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act7("Purifying Dance", 2) {
                      targetSelf().act { dispelTimed(BuffCategory.Negative) }
                      targetAoe().act { dispelTimed(BuffCategory.Positive) }
                    },
                    ActType.Act8("Ironclad Dance", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = NormalBarrierBuff,
                            value = 10000,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = SpecialBarrierBuff,
                            value = 10000,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act9("Fierce Dance", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 3,
                            mode = HitMode.FIXED,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
                            value = 99999,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Bloody Full Moon NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 3,
                            mode = HitMode.FIXED,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
                            value = 99999,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ConfusionAct("Thrust", 2) {
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
                    trEventBonusPassive(HuntingRevueJunna),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr17VampireShioriDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act1]
      +boss[ActType.Act2]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act1]
      +boss[ActType.Act3]
    }
    5 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act6]
      +boss[ActType.Act4]
    }
    else -> error("Not supported.")
  }
}
