package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr35

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.FullNegativeEffectResistancePassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.TrDamageReductionPassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive2023V2
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

val tr35EmperorAkira =
    ActorLoadout(
        "TR35 Emperor Akira",
        Dress(
            name = "Emperor Akira",
            character = Character.Akira,
            attribute = Attribute.Wind,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 150_000_000,
                actPower = 2300,
                normalDefense = 650,
                specialDefense = 650,
                agility = 9999,
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
                        modifier = 150,
                        hitCount = 2,
                    )
                  }
                },
                ActType.Act5("Defense Concerto", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                  }
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.DamageReceivedDownBuff,
                        value = 30,
                        turns = 2,
                    )
                  }
                },
                ActType.Act6("Blind Fire Flower", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyContinuousBuff(
                        effect = Buffs.ConfusionBuff,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BurnBuff,
                        value = 5000,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.GreaterFrostbiteBuff,
                        value = 99999,
                        turns = 1,
                    )
                  }
                },
                ActType.Act7("Inspiring Gust", 2) {
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.ActPowerUpBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.DexterityUpBuff,
                        value = 20,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.CriticalUpBuff,
                        value = 20,
                        turns = 3,
                    )
                  }
                },
                ActType.ClimaxAct("Galactic Kaiser-Walzer NEO", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
                    )
                    applyContinuousBuff(
                        effect = Buffs.ConfusionBuff,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BurnBuff,
                        value = 5000,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.GreaterFrostbiteBuff,
                        value = 99999,
                        turns = 1,
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
                trEventBonusPassive2023V2(1090029),
                FullNegativeEffectResistancePassive.new(100),
                BossElementResistPassive.new(50),
            ),
        ),
    )

val tr35EmperorAkiraStrategy = FixedStrategy {
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
      +boss[ActType.Act6]
      +boss[ActType.Act7]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act7]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act3]
      +boss[ActType.Act5]
    }
    else -> {
      error("Unsupported.")
    }
  }
}

val tr35EmperorAkiraDiff4 =
    ActorLoadout(
        "TR35 Emperor Akira Difficulty 4",
        Dress(
            name = "Emperor Akira",
            character = Character.Akira,
            attribute = Attribute.Wind,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 2_000_000_000,
                actPower = 10000,
                normalDefense = 10000,
                specialDefense = 10000,
                agility = 9999,
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
                        modifier = 150,
                        hitCount = 2,
                    )
                  }
                },
                ActType.Act5("Defense Concerto", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                  }
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.DamageReceivedDownBuff,
                        value = 30,
                        turns = 2,
                    )
                  }
                },
                ActType.Act6("Blind Fire Flower", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyContinuousBuff(
                        effect = Buffs.ConfusionBuff,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BurnBuff,
                        value = 99999,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.GreaterFrostbiteBuff,
                        value = 99999,
                        turns = 1,
                    )
                  }
                },
                ActType.Act7("Inspiring Gust", 2) {
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.ActPowerUpBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.DexterityUpBuff,
                        value = 20,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.CriticalUpBuff,
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
                    applyContinuousBuff(
                        effect = Buffs.ConfusionBuff,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BurnBuff,
                        value = 99999,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.GreaterFrostbiteBuff,
                        value = 99999,
                        turns = 1,
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
                trEventBonusPassive2023V2(1090029),
                FullNegativeEffectResistancePassive.new(100),
                BossElementResistPassive.new(50),
                TrDamageReductionPassive.new(90),
            ),
        ),
    )

val tr35EmperorAkiraDiff4Strategy = FixedStrategy {
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

