package xyz.qwewqa.relive.simulator.core

import xyz.qwewqa.relive.simulator.core.presets.dress.back.flower.StageGirlMeiFan
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9QueenOfHeartsShizuha
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9.tr9QueenOfHeartsShizuhaStrategy
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.DevilKaoruko
import xyz.qwewqa.relive.simulator.core.presets.memoir.BandsmansGreeting
import xyz.qwewqa.relive.simulator.core.presets.memoir.CrazyMadScientist
import xyz.qwewqa.relive.simulator.core.stage.StageConfiguration
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.TeamLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.simulate
import xyz.qwewqa.relive.simulator.core.stage.song.AttributeDamageDealtUpSongEffect
import xyz.qwewqa.relive.simulator.core.stage.song.Song
import xyz.qwewqa.relive.simulator.core.stage.song.SongEffectData
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

suspend fun main() {
    StageLoadout(
        player = TeamLoadout(
            actors = listOf(
                ActorLoadout(
                    "Devil",
                    DevilKaoruko,
                    BandsmansGreeting,
                ),
                ActorLoadout(
                    "Meif",
                    StageGirlMeiFan,
                    CrazyMadScientist,
                )
            ),
            song = Song(
                passive = SongEffectData(
                    AttributeDamageDealtUpSongEffect(Attribute.Flower),
                    9,
                ),
            ),
            strategy = FixedStrategy {
                val devil = -"Devil"
                val meif = -"Meif"
                when (turn) {
                    1 -> {
                        +devil[ActType.Act2]
                        +meif[ActType.Act2]
                        +meif[ActType.Act3]
                    }
                    2 -> {
                        +devil[ActType.Act2]
                        +meif[ActType.Act2]
                        +meif[ActType.Act3]
                        +meif[ActType.Act1]
                        +devil[ActType.Act3]
                    }
                    3 -> {
                        +devil[ActType.Act2]
                        +meif[ActType.Act2]
                        +meif[ActType.Act3]
                        +meif[ActType.Act1]
                        +devil[ActType.Act3]
                    }
                }
            }
        ),
        enemy = TeamLoadout(
            actors = listOf(
                tr9QueenOfHeartsShizuha,
            ),
            strategy = tr9QueenOfHeartsShizuhaStrategy,
        ),
        prerun = {
            player.actors.values.forEach { it.eventBonus = 50 }
        },
        configuration = StageConfiguration(logging = false)
    ).simulate(100_000, 3)
//    StageLoadout(
//        player = TeamLoadout(
//            actors = listOf(
//                ActorLoadout(
//                    "Death",
//                    DeathTamao,
//                    FirstAnnivSiegfeldInstituteOfMusicLv1,
//                ),
//
//                ActorLoadout(
//                    "Meif",
//                    StageGirlMeiFan,
//                    CoStarringWithHatsuneMiku,
//                )
//            ),
//            song = Song(
//                SongEffectData(
//                    CriticalUpSongEffect,
//                    25,
//                ),
//                passive = SongEffectData(
//                    CriticalUpSongEffect,
//                    24,
//                    FlowerOnlyCondition,
//                )
//            ),
//            strategy = FixedStrategy {
//                val death = -"Death"
//                val meif = -"Meif"
//                when (turn) {
//                    1 -> {
//                        +meif[ActType.Act2]
//                        +meif[ActType.Act3]
//                        +meif[ActType.Act1]
//                    }
//                    2 -> {
//                        +death[ActType.Act2]
//                        +death[ActType.Act3]
//                        +meif[ActType.Act2]
//                        +meif[ActType.Act3]
//                        +meif[ActType.Act1]
//                    }
//                    3 -> {
//                        climax()
//                        +death[ActType.Act2]
//                        +meif[ActType.Act2]
//                        +meif[ActType.Act3]
//                        +meif[ActType.ClimaxAct]
//                        +meif[ActType.Act1]
//                    }
//                }
//            }
//        ),
//        enemy = TeamLoadout(
//            actors = listOf(
//                tr9Shizuha,
//            ),
//            strategy = tr9ShizuhaStrategy,
//        ),
//        prerun = {
//            player.actors.values.forEach { it.eventBonus = 140 }
//        },
//        configuration = StageConfiguration(logging = false)
//    ).simulate(1_000_000, 3)
//    StageLoadout(
//        player = TeamLoadout(
//            actors = listOf(
//                ActorLoadout(
//                    "Meif",
//                    StageGirlMeiFan.copy(
//                        unitSkill = listOf(
//                            TeamActPassive.new(30) + FlowerOnlyCondition,
//                            TeamCriticalPassive.new(30) + FlowerOnlyCondition,
//                        )
//                    ),
//                    CoStarringWithHatsuneMiku,
//                ),
//                ActorLoadout(
//                    "Yachi",
//                    StageGirlYachiyo,
//                    FirstAnnivSiegfeldInstituteOfMusicLv1,
//                ),
//            ),
//            song = Song(
//                passive = SongEffectData(
//                    CriticalUpSongEffect,
//                    25,
//                )
//            ),
//            strategy = FixedStrategy {
//                val meif = -"Meif"
//                val yachi = -"Yachi"
//                when (turn) {
//                    1 -> {
//                        +meif[ActType.Act2]
//                        +meif[ActType.Act3]
//                        +meif[ActType.Act1]
//                    }
//                    2 -> {
//                        +yachi[ActType.Act2]
//                        +meif[ActType.Act2]
//                        +meif[ActType.Act3]
//                        +meif[ActType.Act1]
//                        +yachi[ActType.Act3]
//                    }
//                    3 -> {
//                        climax()
//                        +yachi[ActType.Act2]
//                        +meif[ActType.Act2]
//                        +meif[ActType.Act3]
//                        +meif[ActType.ClimaxAct]
//                        +meif[ActType.Act1]
//                    }
//                }
//            }
//        ),
//        enemy = TeamLoadout(
//            actors = listOf(
//                tr9Shizuha,
//            ),
//            strategy = tr9ShizuhaStrategy,
//        ),
//        prerun = {
//            player.actors.values.forEach { it.eventBonus = 80 }
//        },
//        configuration = StageConfiguration(logging = false)
//    ).simulate(1_000_000, 3)
//    val results = Channel<Int>(10_000_000)
//    StageLoadout(
//        player = TeamLoadout(
//            actors = listOf(
//                ActorLoadout(
//                    "Sanada",
//                    Dress(
//                        "Sanada",
//                        Character.Mahiru,
//                        Attribute.Space,
//                        DamageType.Normal,
//                        Position.Back,
//                        defaultDressStats.copy(
//                            hp = 18605,
//                            specialDefense = 1076
//                        ),
//                        emptyMap(),
//                        listOf(
//                            BrillianceRecoverPassive.new(0),
//                        ),
//                        emptyList(),
//                    ),
//                ),
//                ActorLoadout(
//                    "Justice",
//                    Dress(
//                        "Justice",
//                        Character.Nana,
//                        Attribute.Space,
//                        DamageType.Normal,
//                        Position.Back,
//                        defaultDressStats.copy(
//                            hp = 999999
//                        ),
//                        emptyMap(),
//                        emptyList(),
//                        emptyList(),
//                    ),
//                )
//            ),
//            song = Song(
//            ),
//            strategy = FixedStrategy {
////                if (turn == 3 && (-"Sanada").brilliance < 100) ignoreRun()
//                if (turn == 3) results.trySend((-"Sanada").brilliance)
//            }
//        ),
//        enemy = TeamLoadout(
//            actors = listOf(
//                tr9WhiteRabbitMisora,
//            ),
//            strategy = tr9WhiteRabbitMisoraStrategy,
//        ),
//        prerun = {
//            player.actors.values.forEach { it.eventBonus = 10 }
//        },
//        configuration = StageConfiguration(logging = false)
//    ).simulate(10_000_000, 3)
//    var cum = 0.0
//    results.close()
//    results.toList().groupBy { it }.map { (k, v) -> k to v.size }.toList().sortedBy { it.first }.forEach { (k, v) ->
//        cum += v / 10_000_000.0 * 100
//        println("$k: ${"%.4f".format(v / 10_000_000.0 * 100)}%")
//    }
}
