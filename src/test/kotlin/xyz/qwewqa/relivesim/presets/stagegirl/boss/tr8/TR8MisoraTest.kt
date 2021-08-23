package xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import xyz.qwewqa.relivesim.dsl.bulkPlay
import xyz.qwewqa.relivesim.dsl.fixedStrategy
import xyz.qwewqa.relivesim.dsl.simulate
import xyz.qwewqa.relivesim.dsl.stage
import xyz.qwewqa.relivesim.presets.ActStatUpSongEffect
import xyz.qwewqa.relivesim.presets.AttributeDamageDealtUp
import xyz.qwewqa.relivesim.presets.conditional
import xyz.qwewqa.relivesim.presets.memoir.FriendsAtTheAquarium
import xyz.qwewqa.relivesim.presets.memoir.SunsetLabMemBadge
import xyz.qwewqa.relivesim.presets.stagegirl.backrow.flower.StageGirlMeiFan
import xyz.qwewqa.relivesim.presets.stagegirl.midrow.flower.DevilKaoruko
import xyz.qwewqa.relivesim.stage.OutOfTurns
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.team.ClimaxSong

internal class TR8MisoraTest {
    @Test
    fun `TR8 Misora`() = runBlocking {
        val result = stage(0) {
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
                    AttributeDamageDealtUp(Attribute.Flower, 8.percent),
                    passive = ActStatUpSongEffect(58).conditional {
                        data.character in setOf(Character.Junna, Character.Kaoruko, Character.Rui, Character.Yuyuko)
                    }
                )

                eventBonus = 140.percent

                strategy = fixedStrategy {
                    val meif = -"BSMeif"
                    val devil = -"Devil"

                    when (turn) {
                        1 -> {
                            +meif[ActType.Act2]
                            +devil[ActType.Act2]
                            +meif[ActType.Act3]
                        }
                        2 -> {
                            +devil[ActType.Act2]
                            +meif[ActType.Act2]
                            +meif[ActType.Act3]
                            +meif[ActType.Act1]
                            +devil[ActType.Act1]
                        }
                        3 -> {
                            when (stage.random.nextInt(0, 4)) {
                                0 -> {
                                    climax()
                                    +devil[ActType.ClimaxAct]
                                    +meif[ActType.Act2]
                                    +meif[ActType.Act3]
                                    +meif[ActType.ClimaxAct]
                                    +meif[ActType.Act1]
                                }
                                1 -> {
                                    climax()
                                    +devil[ActType.ClimaxAct]
                                    +devil[ActType.Act2]
                                    +meif[ActType.Act3]
                                    +meif[ActType.ClimaxAct]
                                    +meif[ActType.Act1]
                                }
                                2 -> {
                                    climax()
                                    +devil[ActType.ClimaxAct]
                                    +devil[ActType.Act2]
                                    +meif[ActType.Act2]
                                    +meif[ActType.ClimaxAct]
                                    +meif[ActType.Act1]
                                }
                                3 -> {
                                    climax()
                                    +devil[ActType.ClimaxAct]
                                    +devil[ActType.Act2]
                                    +meif[ActType.Act2]
                                    +meif[ActType.Act3]
                                    +meif[ActType.ClimaxAct]
                                }
                            }
                        }
                    }
                }
            }

            enemy {
                loadout {
                    stageGirl = TR8FaithMisora {
                        stats = stats.copy(hp = 999_999_999)
                    }
                }
                strategy = TR8FaithMisoraStrategy
            }
        }.play(3)
        assertTrue(result is OutOfTurns)
        assertEquals(995464091, (result as OutOfTurns).margin)
    }
}