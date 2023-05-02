package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr30

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

val tr30AliceAruru =
    ActorLoadout(
        "TR30 Alice Aruru",
        Dress(
            name = "Alice Aruru",
            character = Character.Aruru,
            attribute = Attribute.Space,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 112_500_000,
                actPower = 2300,
                normalDefense = 650,
                specialDefense = 650,
                agility = 1,
            ),
            acts =
            actsOf(
                ActType.Act1("Strong Sharpshooting", 2) {
                  targetFront().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                  }
                },
                ActType.Act2("Triple Slash", 2) {
                  targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act3("Strong Triple Slash", 2) {
                  targetBack(3).act {
                    attack(
                        modifier = 70,
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
                ActType.Act5("Perfect Aim Sharpshooting", 2) {
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
                ActType.Act7("Dark Blaze Concerto", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BurnBuff,
                        value = 7000,
                        turns = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.BlindnessBuff,
                        turns = 2,
                    )
                  }
                },
                ActType.ClimaxAct("Eat Me! NEO", 2) {
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
                        effect = Buffs.BlindnessBuff,
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
                trEventBonusPassive2023V2(4040012),
                AbnormalResistPassiveA.new(100),
                BossElementResistPassive.new(50),
            ),
        ),
    )

val tr30AliceAruruStrategy = FixedStrategy {
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
      +boss[ActType.Act6]
      +boss[ActType.Act7]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act5]
      +boss[ActType.Act4]
    }
    else -> error("Not supported.")
  }
}

val tr30AliceAruruDiff4 =
    ActorLoadout(
        "TR30 Alice Aruru Difficulty 4",
        Dress(
            name = "Alice Aruru",
            character = Character.Aruru,
            attribute = Attribute.Space,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_500_000_000,
                actPower = 10000,
                normalDefense = 10000,
                specialDefense = 10000,
                agility = 1,
            ),
            acts =
            actsOf(
                ActType.Act1("Strong Sharpshooting", 2) {
                  targetFront().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                  }
                },
                ActType.Act2("Triple Slash", 2) {
                  targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act3("Strong Triple Slash", 2) {
                  targetFront(3).act {
                    attack(
                        modifier = 70,
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
                ActType.Act5("Perfect Aim Sharpshooting", 2) {
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
                ActType.Act7("Dark Blaze Concerto", 2) {
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
                        effect = Buffs.BlindnessBuff,
                        turns = 2,
                    )
                  }
                },
                ActType.ClimaxAct("Eat Me! NEO", 2) {
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
                        effect = Buffs.BlindnessBuff,
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
                trEventBonusPassive2023V2(4040012),
                FullNegativeEffectResistancePassive.new(100),
                BossElementResistPassive.new(50),
                TrDamageReductionPassive.new(90),
            ),
        ),
    )

val tr30AliceAruruDiff4Strategy = FixedStrategy {
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
      +boss[ActType.Act6]
      +boss[ActType.Act7]
      +boss[ActType.Act4]
    }
    6 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act5]
      +boss[ActType.Act4]
    }
    else -> error("Not supported.")
  }
}

