package xyz.qwewqa.relivesim

import kotlinx.coroutines.coroutineScope
import xyz.qwewqa.relivesim.dsl.bulkPlay
import xyz.qwewqa.relivesim.dsl.fixedStrategy
import xyz.qwewqa.relivesim.dsl.simulate
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.memoir.*
import xyz.qwewqa.relivesim.presets.stagegirl.IzanagiNana
import xyz.qwewqa.relivesim.presets.stagegirl.JusticeNana
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud.BabyStageGirlNana
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud.StageGirlClaudine
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.flower.StageGirlMeiFan
import xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8.TR8FaithMisora
import xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8.TR8FaithMisoraStrategy
import xyz.qwewqa.relivesim.presets.stagegirl.midrow.flower.DevilKaoruko
import xyz.qwewqa.relivesim.presets.stagegirl.midrow.space.WheelOfFortuneKaren
import xyz.qwewqa.relivesim.stage.OutOfTurns
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.Victory
import xyz.qwewqa.relivesim.stage.act.ActType.*
import xyz.qwewqa.relivesim.stage.character.Attribute.Cloud
import xyz.qwewqa.relivesim.stage.character.Attribute.Flower
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.Character.*
import xyz.qwewqa.relivesim.stage.character.DamageType.Normal
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.team.ClimaxSong
import kotlin.system.measureTimeMillis

suspend fun main() = coroutineScope {
    simulate(1_000_000, maxTurns = 3) {
        configuration = StageConfiguration(
            logging = false,
        )

        player {
            loadout {
                name = "BSMeif"
                stageGirl = StageGirlMeiFan()
                memoir = SunsetLabMemBadge.max()
            }
            loadout {
                name = "Devil"
                stageGirl = DevilKaoruko()
                memoir = FriendsAtTheAquarium.max()
            }

            song = ClimaxSong(
                ActStatUpSongEffect(65),
                AttributeDamageDealtUp(Flower, 8.percent),
                passive = ActStatUpSongEffect(58).conditional {
                    data.character in setOf(Junna, Kaoruko, Rui, Yuyuko)
                }
            )

            eventBonus = 140.percent

            strategy = fixedStrategy {
                val meif = -"BSMeif"
                val devil = -"Devil"

                when (turn) {
                    1 -> {
                        +meif[Act2]
                        +devil[Act2]
                        +meif[Act3]
                    }
                    2 -> {
                        +devil[Act2]
                        +meif[Act2]
                        +meif[Act3]
                        +meif[Act1]
                        +devil[Act1]
                    }
                    3 -> {
                        when (stage.random.nextInt(0, 4)) {
                            0 -> {
                                climax()
                                +devil[ClimaxAct]
                                +meif[Act2]
                                +meif[Act3]
                                +meif[ClimaxAct]
                                +meif[Act1]
                            }
                            1 -> {
                                climax()
                                +devil[ClimaxAct]
                                +devil[Act2]
                                +meif[Act3]
                                +meif[ClimaxAct]
                                +meif[Act1]
                            }
                            2 -> {
                                climax()
                                +devil[ClimaxAct]
                                +devil[Act2]
                                +meif[Act2]
                                +meif[ClimaxAct]
                                +meif[Act1]
                            }
                            3 -> {
                                climax()
                                +devil[ClimaxAct]
                                +devil[Act2]
                                +meif[Act2]
                                +meif[Act3]
                                +meif[ClimaxAct]
                            }
                        }
                    }
                }
            }
        }

        enemy {
            loadout {
                stageGirl = TR8FaithMisora()
            }
            strategy = TR8FaithMisoraStrategy
        }
    }
}