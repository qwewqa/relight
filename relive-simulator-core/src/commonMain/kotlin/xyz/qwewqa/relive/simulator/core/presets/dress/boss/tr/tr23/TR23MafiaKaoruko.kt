package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr23

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
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

val tr23MafiaKaoruko =
    ActorLoadout(
        "TR23 Mafia Kaoruko",
        Dress(
            name = "Mafia Kaoruko",
            character = Character.Kaoruko,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 11_250_000,
                    actPower = 2300,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 100,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Strong Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Strong Triple Slash", 2) {
                      targetBack(3).act {
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
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act6("Perfect Aim Tri-Slash", 2) {
                      targetSelf().act {
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
                    ActType.Act7("Ironclad Dance", 2) {
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
                    ActType.Act8("Dazzling Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.AccuracyDownBuff,
                            value = 50,
                            turns = 2,
                        )
                      }
                    },
                    ActType.ClimaxAct("Fuoco! NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 200,
                            hitCount = 5,
                        )
                        applyContinuousBuff(
                            effect = Buffs.AccuracyDownBuff,
                            value = 50,
                            turns = 2,
                        )
                      }
                    },
                    ActType.ConfusionAct("Smash", 2) {
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
                    trEventBonusPassive(1030024),
                    AbnormalGuardPassive.new(),
                ),
        ),
    )

val tr23MafiaKaorukoStrategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act1]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.Act6]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act5]
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

val tr23MafiaKaorukoDiff4 =
    ActorLoadout(
        "TR23 Mafia Kaoruko Difficulty 4",
        Dress(
            name = "Mafia Kaoruko",
            character = Character.Kaoruko,
            attribute = Attribute.Dream,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 540_000_000,
                    actPower = 10000,
                    normalDefense = 650,
                    specialDefense = 650,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 100,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act2("Strong Slash", 2) {
                      targetBack().act {
                        attack(
                            modifier = 150,
                            hitCount = 1,
                        )
                      }
                    },
                    ActType.Act3("Triple Slash", 2) {
                      targetBack(3).act {
                        attack(
                            modifier = 70,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act4("Strong Triple Slash", 2) {
                      targetBack(3).act {
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
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act6("Perfect Aim Tri-Slash", 2) {
                      targetSelf().act {
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
                    ActType.Act7("Ironclad Dance", 2) {
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
                    ActType.Act8("Dazzling Concerto", 2) {
                      targetAoe().act {
                        applyContinuousBuff(
                            effect = Buffs.AccuracyDownBuff,
                            value = 50,
                            turns = 2,
                        )
                      }
                    },
                    ActType.Act9("Perfect Aim Tri-Slash", 2) {
                      targetSelf().act {
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
                    ActType.ClimaxAct("Fuoco! NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 99999,
                            hitCount = 5,
                            mode = HitMode.FIXED,
                        )
                        applyContinuousBuff(
                            effect = Buffs.AccuracyDownBuff,
                            value = 50,
                            turns = 2,
                        )
                      }
                    },
                    ActType.ConfusionAct("Smash", 2) {
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
                    trEventBonusPassive(1030024),
                    AbnormalGuardPassive.new(),
                ),
        ),
    )

val tr23MafiaKaorukoDiff4Strategy = FixedStrategy {
  val boss = this.team.actors.values.first()

  when (turn) {
    1 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act1]
      +boss[ActType.Act4]
    }
    2 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act3]
      +boss[ActType.Act4]
    }
    3 -> {
      +boss[ActType.ClimaxAct]
      +boss[ActType.Act2]
      +boss[ActType.Act5]
    }
    4 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.Act6]
    }
    5 -> {
      +boss[ActType.Act8]
      +boss[ActType.Act5]
      +boss[ActType.Act9]
    }
    6 -> {
      +boss[ActType.Act7]
      +boss[ActType.Act5]
      +boss[ActType.Act6]
    }
    else -> {
      error("Unsupported.")
    }
  }
}
