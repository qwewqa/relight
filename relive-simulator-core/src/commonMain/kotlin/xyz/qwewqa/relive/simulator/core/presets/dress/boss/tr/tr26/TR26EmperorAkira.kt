package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr26

import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.SagittariusJunna
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassiveV2
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val tr26EmperorAkira =
    ActorLoadout(
        "TR26 Emperor Akira",
        Dress(
            name = "Emperor Akira",
            character = Character.Akira,
            attribute = Attribute.Moon,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 12_500_000,
                    actPower = 2300,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Violent Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Violent Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act3("Violent Triple Slash", 2) {
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
                    ActType.Act5("Defense Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 4,
                        )
                      }
                      targetSelf().act {
                        applyTimedBuff(
                            effect = DamageReceivedDownBuff,
                            value = 30,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act6("Confusing Fire Moon", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 4,
                        )
                        applyTimedBuff(
                            effect = ConfusionBuff,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
                            value = 5000,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act7("Inspiring Gust", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = ActPowerUpBuff,
                            value = 30,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = DexterityUpBuff,
                            value = 20,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = CriticalUpBuff,
                            value = 20,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Galactic Kaiser-Walzer NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 4,
                        )
                        applyTimedBuff(
                            effect = ConfusionBuff,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
                            value = 5000,
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
                    trEventBonusPassive(SagittariusJunna),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr26EmperorAkiraVer2023 =
    tr26EmperorAkira.copy(
        name = "TR26 Emperor Akira 2023",
        dress =
            tr26EmperorAkira.dress.copy(
                autoSkills =
                    listOf(
                        trEventBonusPassiveV2(SagittariusJunna),
                        AbnormalResistPassiveA.new(100),
                        BossElementResistPassive.new(50),
                    ),
            ),
    )

val tr26EmperorAkiraStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act2]
      +boss[ActType.Act7]
    }
    2 -> {
      +boss[ActType.Act5]
      +boss[ActType.Act2]
      +boss[ActType.Act3]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

val tr26EmperorAkiraDiff4 =
    ActorLoadout(
        "TR26 Emperor Akira Difficulty 4",
        Dress(
            name = "Emperor Akira",
            character = Character.Akira,
            attribute = Attribute.Moon,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 1_800_000_000,
                    actPower = 10000,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Violent Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Violent Dual Slash", 2) {
                      targetBack(2).act {
                        attack(
                            modifier = 120,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act3("Violent Triple Slash", 2) {
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
                    ActType.Act5("Defense Concerto", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 4,
                        )
                      }
                      targetSelf().act {
                        applyTimedBuff(
                            effect = DamageReceivedDownBuff,
                            value = 30,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act6("Confusing Fire Moon", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 120,
                            hitCount = 4,
                        )
                        applyTimedBuff(
                            effect = ConfusionBuff,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
                            value = 99999,
                            turns = 3,
                        )
                      }
                    },
                    ActType.Act7("Inspiring Gust", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            effect = ActPowerUpBuff,
                            value = 30,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = DexterityUpBuff,
                            value = 20,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = CriticalUpBuff,
                            value = 20,
                            turns = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("Galactic Kaiser-Walzer NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 4,
                            mode = HitMode.FIXED,
                        )
                        applyTimedBuff(
                            effect = ConfusionBuff,
                            turns = 3,
                        )
                        applyTimedBuff(
                            effect = BurnBuff,
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
                    trEventBonusPassive(SagittariusJunna),
                    AbnormalResistPassiveA.new(100),
                    BossElementResistPassive.new(50),
                ),
        ),
    )

val tr26EmperorAkiraDiff4Ver2023 =
    tr26EmperorAkiraDiff4.copy(
        name = "TR26 Emperor Akira Difficulty 4 2023",
        dress =
            tr26EmperorAkiraDiff4.dress.copy(
                autoSkills =
                    listOf(
                        trEventBonusPassiveV2(SagittariusJunna),
                        AbnormalResistPassiveA.new(100),
                        BossElementResistPassive.new(50),
                    ),
            ),
    )

val tr26EmperorAkiraDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act2]
      +boss[ActType.Act7]
    }
    2 -> {
      +boss[ActType.Act5]
      +boss[ActType.Act2]
      +boss[ActType.Act3]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    5 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act5]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
