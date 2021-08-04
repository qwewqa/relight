package xyz.qwewqa.relivesim

import kotlinx.coroutines.coroutineScope
import xyz.qwewqa.relivesim.dsl.bulkPlay
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.stagegirl.JusticeNana
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.space.SanadaMahiru
import xyz.qwewqa.relivesim.stage.OutOfTurns
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.act.ActType.*
import xyz.qwewqa.relivesim.stage.character.Attribute.Cloud
import xyz.qwewqa.relivesim.stage.character.Attribute.Space
import xyz.qwewqa.relivesim.stage.character.Character.*
import xyz.qwewqa.relivesim.stage.character.DamageType.Normal
import xyz.qwewqa.relivesim.stage.character.DamageType.Special
import xyz.qwewqa.relivesim.stage.character.Position.Back
import xyz.qwewqa.relivesim.stage.character.Position.Middle
import xyz.qwewqa.relivesim.stage.character.School.Seisho
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.strategy.FixedStrategy
import xyz.qwewqa.relivesim.stage.team.ClimaxSong
import kotlin.system.measureTimeMillis

suspend fun main() = coroutineScope {
    measureTimeMillis {
        bulkPlay(1, maxTurns = 4) {
            player {
                loadout {
                    name = "Justice"
                    stageGirl = JusticeNana {
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
                    stageGirl = SanadaMahiru()

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
        }.let {
            println("${it.size} runs")
            println("${it.filterIsInstance<OutOfTurns>().map { it.margin }.average().toInt()}")
        }
    }.let {
        println("Time: $it")
    }
}