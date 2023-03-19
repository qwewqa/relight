package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr29

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive2023
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position

val tr29CheerAkira =
    ActorLoadout(
        "TR29 Cheer Akira",
        Dress(
            name = "Cheer Akira",
            character = Character.Akira,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 7_500_000,
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
                ActType.Act4("Strong Triple Slash", 2) {
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
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act6("Poisonous Flower Dance", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                    applyContinuousBuff(
                        effect = Buffs.PoisonBuff,
                        value = 10000,
                        turns = 3,
                    )
                  }
                },
                ActType.Act7("Inspiring Concerto", 2) {
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
                ActType.ClimaxAct("Glorious Dream! NEO", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
                    )
                    applyContinuousBuff(
                        effect = Buffs.PoisonBuff,
                        value = 10000,
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
                trEventBonusPassive2023(2010021),
                AbnormalGuardPassive.new(),
            ),
        ),
    )

val tr29CheerAkiraStrategy = FixedStrategy {
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
      +boss[ActType.Act5]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    5 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    else -> error("Not supported.")
  }
}

val tr29CheerAkiraDiff4 =
    ActorLoadout(
        "TR29 Cheer Akira Difficulty 4",
        Dress(
            name = "Cheer Akira",
            character = Character.Akira,
            attribute = Attribute.Dream,
            damageType = DamageType.Normal,
            position = Position.None,
            stats =
            defaultDressStats.copy(
                hp = 1_080_000_000,
                actPower = 10000,
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
                ActType.Act4("Strong Triple Slash", 2) {
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
                        hitCount = 3,
                    )
                  }
                },
                ActType.Act6("Poisonous Flower Dance", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 99999,
                        hitCount = 3,
                        mode = HitMode.FIXED,
                    )
                    applyContinuousBuff(
                        effect = Buffs.PoisonBuff,
                        value = 99999,
                        turns = 3,
                    )
                  }
                },
                ActType.Act7("Inspiring Concerto", 2) {
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
                ActType.ClimaxAct("Glorious Dream! NEO", 2) {
                  targetAoe().act {
                    attack(
                        modifier = 99999,
                        hitCount = 4,
                        mode = HitMode.FIXED,
                    )
                    applyContinuousBuff(
                        effect = Buffs.PoisonBuff,
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
                trEventBonusPassive2023(2010021),
                AbnormalGuardPassive.new(),
            ),
        ),
    )

val tr29CheerAkiraDiff4Strategy = FixedStrategy {
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
      +boss[ActType.Act5]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act2]
      +boss[ActType.Act4]
    }
    5 -> {
      +boss[ActType.Act6]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act4]
      +boss[ActType.Act5]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
