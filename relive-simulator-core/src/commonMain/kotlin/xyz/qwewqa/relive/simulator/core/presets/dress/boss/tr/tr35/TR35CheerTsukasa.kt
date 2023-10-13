package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr35

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.FullNegativeEffectResistancePassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.SuperBossPassive1
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
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr35CheerTsukasa =
    ActorLoadout(
        "TR35 Cheer Tsukasa",
        Dress(
            name = "Cheer Tsukasa",
            character = Character.Tsukasa,
            attribute = Attribute.Wind,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 112_500_000,
                actPower = 2300,
                normalDefense = 650,
                specialDefense = 650,
                agility = 9999,
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
                        modifier = 200,
                        hitCount = 1,
                    )
                  }
                },
                ActType.Act3("Triple Slash", 2) {
                  targetFront(3).act {
                    attack(
                        modifier = 80,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act4("Violent Triple Slash", 2) {
                  targetFront(3).act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act5("Counter Concerto", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                  }
                },
                ActType.Act6("Perfect Aim Flurry", 2) {
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.PerfectAimBuff,
                        turns = 1,
                    )
                  }
                  targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act7("FireDance", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BurnBuff,
                        value = 7000,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.GreaterFrostbiteBuff,
                        value = 99999,
                        turns = 1,
                    )
                  }
                },
                ActType.Act8("Ironclad Dance", 2) {
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.NormalBarrierBuff,
                        value = 10000,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.SpecialBarrierBuff,
                        value = 10000,
                        turns = 3,
                    )
                  }
                },
                ActType.Act9("Purifying Dance", 2) {
                  targetSelf().act { removeContinuous(BuffCategory.Negative) }
                  targetAoe().act { removeContinuous(BuffCategory.Positive) }
                },
                ActType.ClimaxAct("Shining Hope★ NEO", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BurnBuff,
                        value = 7000,
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

val tr35CheerTsukasaStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act1]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act9]
    }
    4 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    5 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    6 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act4]
      +boss[ActType.Act6]
    }
    else -> error("Not supported.")
  }
}

val tr35CheerTsukasaDiff4 =
    ActorLoadout(
        "TR35 Cheer Tsukasa Difficulty 4",
        Dress(
            name = "Cheer Tsukasa",
            character = Character.Tsukasa,
            attribute = Attribute.Wind,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_500_000_000,
                actPower = 10000,
                normalDefense = 10000,
                specialDefense = 10000,
                agility = 9999,
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
                        modifier = 200,
                        hitCount = 1,
                    )
                  }
                },
                ActType.Act3("Triple Slash", 2) {
                  targetFront(3).act {
                    attack(
                        modifier = 80,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act4("Violent Triple Slash", 2) {
                  targetFront(3).act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act5("Counter Concerto", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                  }
                },
                ActType.Act6("Perfect Aim Flurry", 2) {
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.PerfectAimBuff,
                        turns = 1,
                    )
                  }
                  targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act7("FireDance", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 99999,
                        hitCount = 2,
                        mode = HitMode.FIXED,
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
                ActType.Act8("Ironclad Dance", 2) {
                  targetSelf().act {
                    applyContinuousBuff(
                        effect = Buffs.NormalBarrierBuff,
                        value = 10000,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.SpecialBarrierBuff,
                        value = 10000,
                        turns = 3,
                    )
                  }
                },
                ActType.Act9("Purifying Dance", 2) {
                  targetSelf().act { removeContinuous(BuffCategory.Negative) }
                  targetAoe().act { removeContinuous(BuffCategory.Positive) }
                },
                ActType.ClimaxAct("Shining Hope★ NEO", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 99999,
                        hitCount = 4,
                        mode = HitMode.FIXED,
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
                SuperBossPassive1.new(100, 6),
                BossElementResistPassive.new(50),
                TrDamageReductionPassive.new(90),
            ),
        ),
    )

val tr35CheerTsukasaDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act1]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act6]
      +boss[ActType.Act9]
    }
    4 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    5 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    6 -> {
      +boss[ActType.Act9]
      +boss[ActType.Act4]
      +boss[ActType.Act6]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
