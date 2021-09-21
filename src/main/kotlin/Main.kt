package xyz.qwewqa.relive.simulator

import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relive.simulator.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.presets.condition.characterCondition
import xyz.qwewqa.relive.simulator.presets.dress.back.flower.StageGirlMeiFan
import xyz.qwewqa.relive.simulator.presets.dress.back.snow.DeathTamao
import xyz.qwewqa.relive.simulator.presets.dress.back.snow.StageGirlRui
import xyz.qwewqa.relive.simulator.presets.dress.back.snow.StageGirlRui95
import xyz.qwewqa.relive.simulator.presets.dress.back.snow.StageGirlYachiyo
import xyz.qwewqa.relive.simulator.presets.dress.boss.tr9.tr9Misora
import xyz.qwewqa.relive.simulator.presets.dress.boss.tr9.tr9MisoraStrategy
import xyz.qwewqa.relive.simulator.presets.dress.boss.tr9.tr9Shizuha
import xyz.qwewqa.relive.simulator.presets.dress.boss.tr9.tr9ShizuhaStrategy
import xyz.qwewqa.relive.simulator.presets.dress.middle.flower.DevilKaoruko
import xyz.qwewqa.relive.simulator.presets.memoir.*
import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.StageConfiguration
import xyz.qwewqa.relive.simulator.stage.actor.ActType
import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.autoskill.new
import xyz.qwewqa.relive.simulator.stage.condition.Condition
import xyz.qwewqa.relive.simulator.stage.condition.plus
import xyz.qwewqa.relive.simulator.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.stage.loadout.TeamLoadout
import xyz.qwewqa.relive.simulator.stage.loadout.simulate
import xyz.qwewqa.relive.simulator.stage.passive.TeamActPassive
import xyz.qwewqa.relive.simulator.stage.passive.TeamCriticalPassive
import xyz.qwewqa.relive.simulator.stage.song.*
import xyz.qwewqa.relive.simulator.stage.strategy.FixedStrategy

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
                    FriendsAtTheAquarium,
                )
            ),
            song = Song(
                SongEffectData(
                    AttributeDamageDealtUpSongEffect(Attribute.Flower),
                    3,
                ),
            ),
            strategy = FixedStrategy {
                val devil = -"Devil"
                val meif = -"Meif"
                when (turn) {
                    1 -> {
                        +meif[ActType.Act2]
                        +meif[ActType.Act3]
                        +meif[ActType.Act1]
                    }
                    2 -> {
                        +devil[ActType.Act2]
                        +meif[ActType.Act2]
                        +meif[ActType.Act3]
                        +meif[ActType.Act1]
                        +devil[ActType.Act3]
                    }
                    3 -> {
                        climax()
                        +devil[ActType.Act2]
                        +meif[ActType.Act2]
                        +meif[ActType.Act3]
                        +meif[ActType.ClimaxAct]
                        +meif[ActType.Act1]
                    }
                }
            }
        ),
        enemy = TeamLoadout(
            actors = listOf(
                tr9Shizuha,
            ),
            strategy = tr9ShizuhaStrategy,
        ),
        prerun = {
            player.actors.values.forEach { it.eventBonus = 50 }
        },
        configuration = StageConfiguration(logging = true)
    ).simulate(1, 3)
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
}
