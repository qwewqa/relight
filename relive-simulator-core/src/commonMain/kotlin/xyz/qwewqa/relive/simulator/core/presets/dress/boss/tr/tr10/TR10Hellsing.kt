package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr10

import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FoolYachiyo
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val tr10HellsingMichiru =
    ActorLoadout(
        "TR10 Hellsing Michiru",
        Dress(
            name = "TR10 Hellsing Michiru",
            character = Character.Michiru,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 4_500_000,
                    actPower = 2100,
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
                    ActType.Act2("Strong Slash", 2) {
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
                    ActType.Act4("Strong Triple Slash", 2) {
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
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act6("Flurry Dance", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 5,
                        )
                      }
                    },
                    ActType.Act7("Weakening Concerto", 2) {
                      targetAoe().act {
                        applyTimedBuff(
                            effect = ActPowerDownBuff,
                            value = 50,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act8("Helpless Concerto", 2) {
                      targetAoe().act {
                        applyTimedBuff(
                            effect = DexterityDownBuff,
                            value = 30,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = CriticalDownBuff,
                            value = 30,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act9("Perfect Aim Flurry", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyTimedBuff(
                            PerfectAimBuff,
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
                    ActType.ClimaxAct("Cross of Retribution NEO", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = ActPowerUpBuff,
                            value = 50,
                            turns = 3,
                        )
                        applyTimedBuff(
                            PerfectAimBuff,
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
                    trEventBonusPassive(FoolYachiyo),
                    AbnormalGuardPassive.new(),
                ),
        ),
    )

val tr10HellsingMichiruStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act3]
      +boss[ActType.Act7]
    }
    2 -> {
      +boss[ActType.Act4]
      +boss[ActType.Act5]
      +boss[ActType.Act8]
    }
    3 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.ClimaxAct]
    }
    else -> error("Not supported.")
  }
}
