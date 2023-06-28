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

val tr32DraculaClaudine =
    ActorLoadout(
        "TR32 Dracula Claudine",
        Dress(
            name = "Dracula Claudine",
            character = Character.Claudine,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 90_000_000,
                actPower = 2300,
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
                          hitCount = 2,
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
                  ActType.Act6("Pursuit Concerto", 2) {
                    targetAoe().act {
                      attack(
                          modifier = 150,
                          hitCount = 5,
                      )
                    }
                  },
                  ActType.Act7("Inspiring Dance", 2) {
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
                  ActType.Act8("Befuddling Concerto", 2) {
                    targetAoe().act {
                      attack(
                          modifier = 150,
                          hitCount = 3,
                      )
                      applyContinuousBuff(
                          effect = Buffs.ConfusionBuff,
                          turns = 2,
                      )
                    }
                  },
                  ActType.ClimaxAct("Bloody Midnight NEO", 2) {
                    targetAoe().act {
                      attack(
                          modifier = 200,
                          hitCount = 3,
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
                  trEventBonusPassive2023V2(4050024),
                  AbnormalGuardPassive.new(),
              ),
        ),
    )

val tr32DraculaClaudineStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    2 -> {
      +boss[ActType.Act3]
      +boss[ActType.Act3]
      +boss[ActType.Act7]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act2]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act6]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.Act6]
    }
    else -> error("Not supported.")
  }
}

val tr32DraculaClaudineDiff4 =
    ActorLoadout(
        "TR32 Dracula Claudine Difficulty 4",
        Dress(
            name = "Dracula Claudine",
            character = Character.Claudine,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_200_000_000,
                actPower = 10000,
                normalDefense = 10000,
                specialDefense = 10000,
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
                          hitCount = 2,
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
                  ActType.Act6("Pursuit Concerto", 2) {
                    targetAoe().act {
                      attack(
                          modifier = 150,
                          hitCount = 5,
                      )
                    }
                  },
                  ActType.Act7("Inspiring Dance", 2) {
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
                  ActType.Act8("Befuddling Concerto", 2) {
                    targetAoe().act {
                      attack(
                          modifier = 99999,
                          hitCount = 3,
                          mode = HitMode.FIXED,
                      )
                      applyContinuousBuff(
                          effect = Buffs.ConfusionBuff,
                          turns = 2,
                      )
                    }
                  },
                  ActType.ClimaxAct("Bloody Midnight NEO", 2) {
                    targetAoe().act {
                      attack(
                          modifier = 99999,
                          hitCount = 3,
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
                  trEventBonusPassive2023V2(4050024),
                  FullNegativeEffectResistancePassive.new(100),
                  BossElementResistPassive.new(50),
                  TrDamageReductionPassive.new(90),
              ),
        ),
    )

val tr32DraculaClaudineDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act1]
      +boss[ActType.Act4]
      +boss[ActType.Act7]
    }
    2 -> {
      +boss[ActType.Act3]
      +boss[ActType.Act3]
      +boss[ActType.Act7]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act2]
      +boss[ActType.Act6]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act2]
      +boss[ActType.Act6]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.Act6]
    }
    else -> error("Not supported.")
  }
}
