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
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr35CheerYachiyo =
    ActorLoadout(
        "TR35 Cheer Yachiyo",
        Dress(
            name = "Cheer Yachiyo",
            character = Character.Yachiyo,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 135_000_000,
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
                ActType.Act8("Restraint Slash", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.StunBuff,
                        turns = 2,
                    )
                    applyContinuousBuff(
                        effect = Buffs.GreaterFrostbiteBuff,
                        value = 99999,
                        turns = 1,
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
            ),
        ),
    )

val tr35CheerYachiyoStrategy = FixedStrategy {
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
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act9]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act9]
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

val tr35CheerYachiyoDiff4 =
    ActorLoadout(
        "TR35 Cheer Yachiyo Difficulty 4",
        Dress(
            name = "Cheer Yachiyo",
            character = Character.Yachiyo,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_800_000_000,
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
                    applyContinuousBuff(
                        effect = Buffs.GreaterFrostbiteBuff,
                        value = 99999,
                        turns = 1,
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

val tr35CheerYachiyoDiff4Strategy = FixedStrategy {
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
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act9]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act2]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act9]
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
