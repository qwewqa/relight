package xyz.qwewqa.relive.simulator

import xyz.qwewqa.relive.simulator.presets.condition.characterCondition
import xyz.qwewqa.relive.simulator.presets.dress.back.snow.DeathTamao
import xyz.qwewqa.relive.simulator.presets.dress.back.snow.StageGirlRui95
import xyz.qwewqa.relive.simulator.presets.dress.boss.tr9.tr9Misora
import xyz.qwewqa.relive.simulator.presets.dress.boss.tr9.tr9MisoraStrategy
import xyz.qwewqa.relive.simulator.presets.memoir.UrashimaTaroPerformanceFlyer
import xyz.qwewqa.relive.simulator.stage.StageConfiguration
import xyz.qwewqa.relive.simulator.stage.actor.ActType
import xyz.qwewqa.relive.simulator.stage.condition.plus
import xyz.qwewqa.relive.simulator.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.stage.loadout.TeamLoadout
import xyz.qwewqa.relive.simulator.stage.loadout.simulate
import xyz.qwewqa.relive.simulator.stage.song.CriticalUpSongEffect
import xyz.qwewqa.relive.simulator.stage.song.Song
import xyz.qwewqa.relive.simulator.stage.song.SongEffectData
import xyz.qwewqa.relive.simulator.stage.strategy.FixedStrategy
import xyz.qwewqa.relivesim.stage.character.Character

suspend fun main() {
    StageLoadout(
        player = TeamLoadout(
            actors = listOf(
                ActorLoadout(
                    "Death",
                    DeathTamao,
                    UrashimaTaroPerformanceFlyer,
                ),

                ActorLoadout(
                    "Rui",
                    StageGirlRui95,
                    UrashimaTaroPerformanceFlyer,
                )
            ),
            song = Song(
                passive = SongEffectData(
                    CriticalUpSongEffect,
                    21,
                    characterCondition(Character.Tamao) + characterCondition(Character.Rui)
                )
            ),
            strategy = FixedStrategy {
                val death = -"Death"
                val rui = -"Rui"

                when (turn) {
                    1 -> {
                        +death[ActType.Act2]
                        +rui[ActType.Act3]
                        +death[ActType.Act3]
                    }
                    2 -> {
                        +death[ActType.Act2]
                        +death[ActType.Act3]
                        +rui[ActType.Act2]
                        +rui[ActType.Act3]
                        +death[ActType.Act1]
                    }
                    3 -> {
                        +death[ActType.Act3]
                        +rui[ActType.Act2]
                        +rui[ActType.Act3]
                        +rui[ActType.Act1]
                        +death[ActType.Act1]
                    }
                }
            }
        ),
        enemy = TeamLoadout(
            actors = listOf(
                tr9Misora,
            ),
            strategy = tr9MisoraStrategy,
        ),
        prerun = {
            player.actors.values.forEach { it.eventBonus = 140 }
        },
        configuration = StageConfiguration(logging = false)
    ).simulate(1_000_000, 3)
}