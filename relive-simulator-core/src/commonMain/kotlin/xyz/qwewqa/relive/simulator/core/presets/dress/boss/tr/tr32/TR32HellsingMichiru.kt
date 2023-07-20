package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr32

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
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr32HellsingMichiru =
    ActorLoadout(
        "TR32 Hellsing Michiru",
        Dress(
            name = "Hellsing Michiru",
            character = Character.Michiru,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
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
                      applyContinuousBuff(
                          effect = Buffs.ActPowerDownBuff,
                          value = 50,
                          turns = 3,
                      )
                    }
                  },
                  ActType.Act8("Helpless Concerto", 2) {
                    targetAoe().act {
                      applyContinuousBuff(
                          effect = Buffs.DexterityDownBuff,
                          value = 30,
                          turns = 3,
                      )
                      applyContinuousBuff(
                          effect = Buffs.CriticalDownBuff,
                          value = 30,
                          turns = 3,
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
                      attack(
                          modifier = 150,
                          hitCount = 4,
                      )
                    }
                  },
                  ActType.ClimaxAct("Cross of Retribution NEO", 2) {
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
                  trEventBonusPassive2023V2(4050024),
                  AbnormalGuardPassive.new(),
              ),
        ),
    )

val tr32HellsingMichiruStrategy = FixedStrategy {
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
    4 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act4]
      +boss[ActType.Act6]
    }
    6 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act9]
      +boss[ActType.Act6]
    }
    else -> error("Not supported.")
  }
}

val tr32HellsingMichiruDiff4 =
    ActorLoadout(
        "TR32 Hellsing Michiru Difficulty 4",
        Dress(
            name = "Hellsing Michiru",
            character = Character.Michiru,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
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
                      applyContinuousBuff(
                          effect = Buffs.ActPowerDownBuff,
                          value = 50,
                          turns = 3,
                      )
                    }
                  },
                  ActType.Act8("Helpless Concerto", 2) {
                    targetAoe().act {
                      applyContinuousBuff(
                          effect = Buffs.DexterityDownBuff,
                          value = 30,
                          turns = 3,
                      )
                      applyContinuousBuff(
                          effect = Buffs.CriticalDownBuff,
                          value = 30,
                          turns = 3,
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
                      attack(
                          modifier = 99999,
                          hitCount = 4,
                          mode = HitMode.FIXED,
                      )
                    }
                  },
                  ActType.ClimaxAct("Cross of Retribution NEO", 2) {
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
                          modifier = 99999,
                          hitCount = 4,
                          mode = HitMode.FIXED,
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
                  trEventBonusPassive2023V2(4050024),
                  FullNegativeEffectResistancePassive.new(100),
                  BossElementResistPassive.new(50),
                  TrDamageReductionPassive.new(90),
              ),
        ),
    )

val tr32HellsingMichiruDiff4Strategy = FixedStrategy {
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
    4 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act4]
      +boss[ActType.Act6]
    }
    6 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act9]
      +boss[ActType.Act6]
    }
    else -> error("Not supported.")
  }
}

