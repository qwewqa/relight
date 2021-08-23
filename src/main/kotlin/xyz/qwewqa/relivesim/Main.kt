package xyz.qwewqa.relivesim

import kotlinx.coroutines.coroutineScope
import xyz.qwewqa.relivesim.dsl.bulkPlay
import xyz.qwewqa.relivesim.dsl.fixedStrategy
import xyz.qwewqa.relivesim.dsl.simulate
import xyz.qwewqa.relivesim.dsl.standardStrategy
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.memoir.*
import xyz.qwewqa.relivesim.presets.stagegirl.IzanagiNana
import xyz.qwewqa.relivesim.presets.stagegirl.JusticeNana
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud.BabyStageGirlNana
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud.StageGirlClaudine
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.flower.StageGirlMeiFan
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.moon.BabyStageGirlHikari
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.space.SanadaMahiru
import xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8.TR8EvilBanishingKomachiTamao
import xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8.TR8EvilBanishingKomachiTamaoStrategy
import xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8.TR8FaithMisora
import xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8.TR8FaithMisoraStrategy
import xyz.qwewqa.relivesim.presets.stagegirl.midrow.flower.DevilKaoruko
import xyz.qwewqa.relivesim.presets.stagegirl.midrow.space.WheelOfFortuneKaren
import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.act.ActType.*
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Attribute.*
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.Character.*
import xyz.qwewqa.relivesim.stage.character.DamageType.Normal
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.character.Position.Back
import xyz.qwewqa.relivesim.stage.team.ClimaxSong
import kotlin.system.measureTimeMillis

suspend fun main() = coroutineScope {
    simulate(1_000_000, maxTurns = 3) {
        configuration = StageConfiguration(
            logging = false,
            displayLogging = false,
        )

        player {
            loadout {
                name = "Justice"
                stageGirl = JusticeNana {
                    unitSkill = TeamActCriticalAutoEffect(36.percent).attributeOnly(Space)
                }
                memoir = ReverberatingVoiceTsuabasaAndMaya.lv1max()
            }
            loadout {
                name = "BSHikari"
                stageGirl = BabyStageGirlHikari()
                memoir = BandsmansGreeting.max()
            }
            loadout {
                name = "Sanada"
                stageGirl = SanadaMahiru()
                memoir = PoolsideIncident.max()
            }

            song = ClimaxSong(
                AttributeDamageTakenDown(Space, 5.percent),
                AttributeDamageTakenDown(Dream, 1.percent),
                passive = DexteritySongEffect(7.percent).conditional {
                    data.attribute == Space && data.position == Back
                }
            )

            eventBonus = 50.percent

//            strategy = fixedStrategy {
//                val justice = -"Justice"
//                val hikari = -"BSHikari"
//                val sanada = -"Sanada"
//
//                when (turn) {
//                    1 -> {
//                        +sanada[Act3]
//                        +justice[Act3]
//                        +sanada[Act2]
//                    }
//                    2 -> {
//                        +sanada[Act3]
//                        +sanada[Act2]
//                        +justice[Act2]
//                    }
//                    3 -> {
//                        climax()
//                        +justice[Act3]
//                        +sanada[Act3]
//                        +sanada[Act2]
//                        +sanada[ClimaxAct]
//                        +sanada[Act1]
//                    }
//                }
//            }

            strategy = standardStrategy {
                val justice = -"Justice"
                val hikari = -"BSHikari"
                val sanada = -"Sanada"

                var turn1ApDown: Boolean by vars

                when (turn) {
                    1 -> {
                        if (
                            haveAny(sanada[Act1], sanada[Act2], sanada[Act3]) &&
                            haveCount(sanada[Act1], sanada[Act2], sanada[Act3], justice[Act2], justice[Act3]) >= 3
                        ) {
                            justice[Act1].tryHold()
                        }
                        hikari[Act1].tryHold()
                        hikari[Act2].tryHold()
                        hikari[Act3].tryHold()
                        if (haveAny(sanada[Act1], sanada[Act2], sanada[Act3])) {
                            -justice[Act2]
                        }
                        -sanada[Act3]
                        -sanada[Act2]
                        -sanada[Act1]
                        -justice[Act3]
                        -justice[Act1]
                        turn1ApDown = justice[Act2] in queued
                    }
                    2 -> {
                        justice[Act1].tryHold()
                        if (turn1ApDown) {
                            +justice[Act2]
                            +sanada[Act3]
                            +justice[Act3]
                            +sanada[Act2]
                            +sanada[Act1]
                        } else {
                            +sanada[Act3]
                            +justice[Act2]
                            +sanada[Act2]
                        }
                    }
                    3 -> {
                        if (canClimax) {
                            if (turn1ApDown) {
                                if (isHolding) {
                                    justice[Act3].tryDiscard()
                                } else {
                                    if (justice[Act1] !in hand) {
                                        justice[Act3].tryHold()
                                    } else if (justice[Act3] !in hand) {
                                        justice[Act1].tryHold()
                                    }
                                }
                                climax()
                                justice[Act1].tryHold()
                                justice[Act3].tryHold()
                                -justice[Act2]
                                -sanada[Act3]
                                -sanada[Act2]
                                -sanada[ClimaxAct]
                                -sanada[Act1]
                                -justice[Act3]
                                -justice[Act1]
                            } else {
                                if (isHolding) {
                                    justice[Act2].tryDiscard()
                                } else {
                                    if (justice[Act1] !in hand) {
                                        justice[Act2].tryHold()
                                    } else if (justice[Act2] !in hand) {
                                        justice[Act1].tryHold()
                                    }
                                }
                                climax()
                                justice[Act1].tryHold()
                                justice[Act2].tryHold()
                                -justice[Act3]
                                -justice[Act2]
                                -sanada[Act3]
                                -sanada[Act2]
                                -sanada[ClimaxAct]
                                -sanada[Act1]
                                -justice[Act3]
                                -justice[Act1]
                            }
                        } else {
                            justice[Act1].tryHold()
                            -justice[Act2]
                            -justice[Act3]
                            -sanada[Act3]
                            -sanada[Act2]
                            -sanada[Act1]
                            -justice[Act3]
                            -justice[Act1]
                        }
                    }
                }
            }
        }

        enemy {
            loadout {
                stageGirl = TR8EvilBanishingKomachiTamao()
            }
            strategy = TR8EvilBanishingKomachiTamaoStrategy
        }
    }
}