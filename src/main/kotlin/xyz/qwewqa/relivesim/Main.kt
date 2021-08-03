package xyz.qwewqa.relivesim

import xyz.qwewqa.relivesim.dsl.stage
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.act.ActType.*
import xyz.qwewqa.relivesim.stage.character.Attribute.*
import xyz.qwewqa.relivesim.stage.character.Character.*
import xyz.qwewqa.relivesim.stage.character.DamageType.*
import xyz.qwewqa.relivesim.stage.character.Position.*
import xyz.qwewqa.relivesim.stage.character.School.*
import xyz.qwewqa.relivesim.stage.effect.ApDownTimedEffect
import xyz.qwewqa.relivesim.stage.effect.EffectClass.*
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.strategy.FixedStrategy
import xyz.qwewqa.relivesim.stage.team.ClimaxSong

fun main() {
    stage {
        player {
            loadout {
                name = "Justice"
                stageGirl {
                    name = "Justice"
                    character = Nana
                    attribute = Space
                    damageType = Normal
                    position = Back
                    stats {
                        maxHp = 31701
                        actPower = 3416
                        normalDefense = 1577
                        specialDefense = 1025
                        agility = 2113
                    }
                    positionValue = 35050

                    Act1("Brilliance Slash", 2) {
                        targetFront().act {
                            attack(112.percent, hitCount = 2)
                        }
                        targetSelf().act {
                            addBrilliance(20)
                        }
                    }
                    Act2("Sword of Justice", 2) {
                        targetAoe().act {
                            attack(64.percent, hitCount = 2)
                        }
                        targetTeamAoe().act {
                            applyEffects(
                                { ActTimedEffect(turns = 3, 20.percent) },
                                { ApDownTimedEffect(turns = 2) },
                            )
                        }
                    }
                    Act3("Right Judgement", 2) {
                        targetBack().act {
                            attack(198.percent, hitCount = 3)
                        }
                        targetTeamAoe().act {
                            dispelTimed(Negative)
                            heal(30.percent)
                        }
                    }
                    ClimaxAct("Absolute Justice", 2) {
                        targetSelf().act {
                            applyEffects(
                                { ActTimedEffect(turns = 3, 20.percent) },
                                { DexterityTimedEffect(turns = 3, 20.percent) },
                                { CriticalTimedEffect(turns = 3, 20.percent) },
                            )
                        }
                        targetAoe().act {
                            attack(240.percent, hitCount = 4)
                        }
                    }

                    +TeamTimedDexterityAutoEffect(turns = 3, 10.percent)
                    +TeamTimedEffectiveDamageAutoEffect(turns = 3, 20.percent)
                    // Brilliance Down

                    unitSkill = TeamActCriticalAutoEffect(36.percent).attributeOnly(Space)
                }

                memoir {
                    name = "Seisho Act"
                    stats {
                        maxHp = 2316
                    }
                    +TeamActAutoEffect(5.percent).schoolOnly(Seisho)
                }
            }
            loadout {
                name = "Sanada"
                stageGirl {
                    name = "Sanada"
                    character = Mahiru
                    attribute = Space
                    damageType = Normal
                    position = Back
                    stats {
                        maxHp = 18605
                        actPower = 2747
                        normalDefense = 1541
                        specialDefense = 1076
                        agility = 2113
                    }
                    positionValue = 34050

                    Act1("Strong Slash", 2) {
                        targetFront().act {
                            attack(176.percent)
                        }
                    }
                    Act2("Spearheading Blade", 2) {
                        targetSelf().act {
                            applyEffects(
                                { ActTimedEffect(turns = 3, 20.percent) },
                                { CriticalTimedEffect(turns = 3, 20.percent) },
                            )
                        }
                        targetHighestAct().act {
                            attack(155.percent, hitCount = 2)
                        }
                    }
                    Act3("Dashing Blade", 2) {
                        targetSelf().act {
                            applyEffects(
                                { DexterityTimedEffect(turns = 3, 20.percent) },
                                { EffectiveDamageTimedEffect(turns = 3, 30.percent) },
                            )
                        }
                        targetHighestAct().act {
                            attack(198.percent, hitCount = 2)
                        }
                    }
                    ClimaxAct("Greatest Spear", 2) {
                        targetHighestAct().act {
                            applyEffects(
                                { Mark(turns = 2) },
                                { NormalDefenseTimedEffect(turns = 3, -30.percent) },
                            )
                            attack(
                                369.percent,
                                bonusMultiplier = 1.5,
                                bonusCondition = { data.damageType == Special },
                                hitCount = 3,
                            )
                        }
                    }

                    +DamageDealtAutoEffect(10.percent)
                    +DexterityAutoEffect(10.percent)
                    +EffectiveDamageAutoEffect(20.percent)

                    unitSkill = TeamActCriticalAutoEffect(30.percent).positionOnly(Back)
                }

                memoir {
                    name = "Turtle Rui"
                    stats {
                        actPower = 149
                    }
                    +DamageDealtAutoEffect(8.percent)
                    +DexterityAutoEffect(16.percent)
                }
            }

            loadout {
                name = "BS Nana"
                stageGirl {
                    name = "Stage Girl"
                    character = Nana
                    attribute = Cloud
                    damageType = Normal
                    position = Middle
                    stats {
                        maxHp = 4203
                        actPower = 281
                        normalDefense = 279
                        specialDefense = 144
                        agility = 215
                    }
                    positionValue = 21040

                    // Acts don't matter here
                    // Neither do autoskills

                    unitSkill = TeamActCriticalAutoEffect(50.percent).schoolOnly(Seisho)
                }

                memoir {
                    name = "Seisho Act"
                    stats {
                        maxHp = 1291
                    }
                    +TeamActAutoEffect(5.percent).schoolOnly(Seisho)
                }
            }

            friendLoadout {
                stageGirl {
                    name = "Mad Scientist"
                    character = Nana
                    damageType = Normal
                    unitSkill = TeamHpDefenseAutoEffect(20.percent, 10.percent)
                }
            }

            song = ClimaxSong(
                CriticalSongEffect(25.percent),
                DexteritySongEffect(4.percent),
            )

            eventBonus = 672.percent

            strategy = FixedStrategy {
                val sanada = -"Sanada"
                val justice = -"Justice"
                val nana = -"BS Nana"

                when (turn) {
                    1 -> {
                        +sanada[Act3]
                        +sanada[Act1]
                        +justice[Act3]
                    }
                    2 -> {
                        +justice[Act2]
                        +sanada[Act3]
                        +sanada[Act2]
                    }
                    3 -> {
                        +justice[Act2]
                        +sanada[Act3]
                        +justice[Act3]
                        +sanada[Act2]
                        +sanada[Act1]
                    }
                    4 -> {
                        sanada.currentBrilliance = 100
                        climax()
                        +sanada[Act3]
                        +sanada[Act2]
                        +justice[Act3]
                        +sanada[ClimaxAct]
                        +justice[Act2]
                    }
                }
            }
        }

        enemy {
            loadout {
                name = "Boss"
                stageGirl {
                    name = "Raid Boss"
                    attribute = Cloud
                    character = Maya
                    damageType = Normal
                    stats {
                        maxHp = 100_000_000
                        actPower = 1500
                        normalDefense = 1500
                        specialDefense = 1500
                        agility = 1  // who knows
                    }

                    Act1("Strong Slash", 2) {
                        targetFront().act {
                            attack(200.percent, hitCount = 2)
                        }
                    }
                    Act2("Weakening Slash", 2) {
                        targetFront(3).act {
                            attack(115.percent, hitCount = 3)
                            applyEffect { ActTimedEffect(turns = 3, -30.percent) }
                        }
                    }
                    Act3("Softening Slash", 2) {
                        targetFront(3).act {
                            attack(115.percent, hitCount = 3)
                            applyEffects(
                                { NormalDefenseTimedEffect(turns = 3, -30.percent) },
                                { SpecialDefenseTimedEffect(turns = 3, -30.percent) },
                            )
                        }
                    }
                    ClimaxAct("Odette the Mavericks Neo", 2) {
                        targetAoe().act {
                            attack(150.percent, hitCount = 3)
                            applyEffects(
                                { DexterityTimedEffect(turns = 3, -30.percent) },
                                { ActTimedEffect(turns = 3, -30.percent) },
                                { CriticalTimedEffect(turns = 3, -30.percent) },
                            )
                        }
                    }
                }
            }

            strategy = FixedStrategy {
                val boss = -"Boss"

                when (turn) {
                    1 -> {
                        +boss[Act2]
                        +boss[Act1]
                        +boss[Act3]
                    }
                    2 -> {
                        +boss[Act3]
                        +boss[Act2]
                        +boss[Act1]
                    }
                    3 -> {
                        +boss[Act1]
                        +boss[Act3]
                        +boss[Act2]
                    }
                    4 -> {
                        +boss[ClimaxAct]
                        +boss[Act2]
                        +boss[Act1]
                    }
                }
            }
        }

        configuration = StageConfiguration(
            logging = true,
        )
    }.run(4)
}