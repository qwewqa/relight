package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.shinsengumirinpuden

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val shinsengumiRinpudenOkitaSojiYuyukoBoss =
    ActorLoadout(
        "Shinsengumi Rinpuden Okita Soji Yuyuko",
        Dress(
            name = "Okita Soji Yuyuko",
            character = Character.Yuyuko,
            attribute = Attribute.Wind,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 358_951_010,
                    actPower = 1500,
                    normalDefense = 1500,
                    specialDefense = 1500,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Inspiring Slash", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            ActPowerUpBuff,
                            value = 30,
                            turns = 3,
                        )
                      }
                      targetFront(3).act {
                        attack(
                            modifier = 115,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act2("Violent Slash", 2) {
                      targetSelf().act {
                        applyTimedBuff(
                            DexterityUpBuff,
                            value = 30,
                            turns = 3,
                        )
                        applyTimedBuff(
                            CriticalUpBuff,
                            value = 30,
                            turns = 3,
                        )
                      }
                      targetFront(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act3("Slash of Protection", 2) {
                      targetFront(3).act {
                        attack(
                            modifier = 100,
                            hitCount = 3,
                        )
                      }
                      targetSelf().act {
                        applyTimedBuff(
                            DamageReceivedDownBuff,
                            turns = 2,
                        )
                      }
                    },
                    ActType.ClimaxAct("Triple Thrust NEO", 2) {
                      targetAoe().act {
                        attack(
                            modifier = 150,
                            hitCount = 3,
                        )
                        applyTimedBuff(
                            EvasionUpBuff,
                            value = 50,
                            turns = 2,
                        )
                        applyTimedBuff(
                            SpecialReflectBuff,
                            value = 30,
                            turns = 2,
                        )
                      }
                    },
                ),
            autoSkills =
                listOf(
                    shinsengumiRinpudenBonusPassive.new(),
                    AbnormalResistPassiveA.new(100),
                ),
        ),
    )
