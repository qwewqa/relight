package xyz.qwewqa.relivesim

import kotlinx.coroutines.coroutineScope
import xyz.qwewqa.relivesim.dsl.bulkPlay
import xyz.qwewqa.relivesim.dsl.fixedStrategy
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.effect.*
import xyz.qwewqa.relivesim.presets.memoir.*
import xyz.qwewqa.relivesim.presets.stagegirl.IzanagiNana
import xyz.qwewqa.relivesim.presets.stagegirl.JusticeNana
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud.BabyStageGirlNana
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud.StageGirlClaudine
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.space.SanadaMahiru
import xyz.qwewqa.relivesim.presets.stagegirl.midrow.space.WheelOfFortuneKaren
import xyz.qwewqa.relivesim.stage.OutOfTurns
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.act.ActType.*
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Attribute.*
import xyz.qwewqa.relivesim.stage.character.Character.*
import xyz.qwewqa.relivesim.stage.character.DamageType.Normal
import xyz.qwewqa.relivesim.stage.character.Position.Middle
import xyz.qwewqa.relivesim.stage.character.School.Seisho
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.autoEffect
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.strategy.FixedStrategy
import xyz.qwewqa.relivesim.stage.team.ClimaxSong
import kotlin.system.measureTimeMillis

suspend fun main() = coroutineScope {
    measureTimeMillis {
        bulkPlay(1, maxTurns = 3) {
            configuration = StageConfiguration(
                logging = true,
            )

            player {
                loadout {
                    name = "BSKuro"
                    stageGirl = StageGirlClaudine {
                        unitSkill = TeamActCriticalAutoEffect(5.percent).attributeOnly(Cloud)
                    }

                    memoir = FirstAnnivSeishoMusicAcademy.min()
                }
                loadout {
                    name = "Justice"
                    stageGirl = JusticeNana()
                    memoir = CoStarringWithHatsuneMiku.max()
                }
                loadout {
                    name = "Izanagi"
                    stageGirl = IzanagiNana {
                        unitSkill = TeamActCriticalAutoEffect(20.percent).damageTypeOnly(Normal)
                    }
                    memoir = FriendsAtTheAquarium.max()
                }
                loadout {
                    name = "Wheel"
                    stageGirl = WheelOfFortuneKaren()
                    memoir = BandsmansGreeting.max()
                }
                loadout {
                    name = "BSNana"
                    stageGirl = BabyStageGirlNana()
                    memoir = FirstAnnivSeishoMusicAcademy.min()
                }

                song = ClimaxSong(
                    DexteritySongEffect(7.percent),
                    AttributeDamageDealtUp(Space, 10.percent),
                )

                eventBonus = 190.percent

                strategy = fixedStrategy {
                    val bsKuro = -"BSKuro"
                    val justice = -"Justice"
                    val izanagi = -"Izanagi"
                    val wheel = -"Wheel"
                    val bsNana = -"BSNana"

                    when (turn) {
                        1 -> {
                            +izanagi[Act2]
                            +bsNana[Act3]
                            +bsKuro[Act3]
                            +bsKuro[Act2]
                            +justice[Act1]
                        }
                        2 -> {
                            +bsKuro[Act1]
                            +justice[Act2]
                            +justice[Act3]
                        }
                        3 -> {
                            climax()
                            +wheel[Act2]
                            +justice[Act2]
                            +izanagi[ClimaxAct]
                            +justice[ClimaxAct]
                            +justice[Act3]
                        }
                    }
                }
            }

            enemy {
                loadout {
                    name = "Boss"
                    stageGirl {
                        name = "TR Boss"
                        attribute = Cloud
                        character = Misora
                        damageType = Normal
                        stats {
                            hp = 10_000_000
                            actPower = 1900
                            normalDefense = 650
                            specialDefense = 650
                            agility = 1  // who knows
                        }

                        +autoEffect("Boss Special", EffectClass.Positive) {
                            self.againstAttributeDamageDealtUp[Flower] = 50.percent
                            self.againstAttributeDamageDealtUp[Wind] = 50.percent
                            self.againstAttributeDamageDealtUp[Ice] = 50.percent
                            self.againstAttributeDamageDealtUp[Cloud] = 50.percent
                            self.againstAttributeDamageDealtUp[Moon] = 50.percent
                            self.againstAttributeDamageTakenDown[Flower] = 50.percent
                            self.againstAttributeDamageTakenDown[Wind] = 50.percent
                            self.againstAttributeDamageTakenDown[Ice] = 50.percent
                            self.againstAttributeDamageTakenDown[Cloud] = 50.percent
                            self.againstAttributeDamageTakenDown[Moon] = 50.percent
                        }

                        Act1("Violent Thrust", 2) {
                            targetFront().act {
                                attack(100.percent)
                            }
                        }
                        Act2("Violent Dual Thrust", 2) {
                            targetFront(2).act {
                                attack(120.percent, hitCount = 2)
                            }
                        }
                        Act3("Violent Triple Thrust", 2) {
                            targetFront(3).act {
                                attack(100.percent, hitCount = 3)
                            }
                        }
                        Act4("Counter Concerto", 2) {
                            targetAoe().act {
                                attack(120.percent, hitCount = 2)
                            }
                        }
                        Act5("Thrust of Protection", 2) {
                            targetAoe().act {
                                attack(150.percent, hitCount = 4)
                            }
                            targetSelf().act {
                                applyEffect { DamageTakenDownTimedEffect(turns = 3, 50.percent) }
                            }
                        }
                        Act6("Inspiring Gust", 2) {
                            targetSelf().act {
                                applyEffect { ActTimedEffect(turns = 3, 50.percent) }
                                applyEffect { DexterityTimedEffect(turns = 3, 50.percent) }
                                applyEffect { CriticalTimedEffect(turns = 3, 50.percent) }
                            }
                        }
                        Act7("Weakening Concerto", 2) {
                            targetAoe().act {
                                applyEffect { ActTimedEffect(turns = 3, -50.percent) }
                            }
                        }
                        Act8("Poisonous Thrust", 2) {
                            targetAoe().act {
                                attack(150.percent, hitCount = 4)
                                // TODO
                            }
                        }
                        ClimaxAct("Moonlight Sacrament NEO", 2) {
                            targetAoe().act {
                                attack(200.percent, hitCount = 4)
                                // TODO
                            }
                        }
                    }
                }

                strategy = FixedStrategy {
                    val boss = -"Boss"

                    when (turn) {
                        1 -> {
                            +boss[Act7]
                            +boss[Act1]
                            +boss[Act2]
                        }
                        2 -> {
                            +boss[Act6]
                            +boss[Act3]
                            +boss[Act5]
                        }
                        3 -> {
                            +boss[ClimaxAct]
                            +boss[Act7]
                        }
                    }
                }
            }
        }.let {
            println("${it.size} runs")
            println("${it.filterIsInstance<OutOfTurns>().map { it.margin }.average().toInt()}")
        }
    }.let {
        println("Time: $it")
    }
}