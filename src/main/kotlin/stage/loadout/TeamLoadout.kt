package xyz.qwewqa.relive.simulator.stage.loadout

import xyz.qwewqa.relive.simulator.stage.actor.Actor
import xyz.qwewqa.relive.simulator.stage.song.Song
import xyz.qwewqa.relive.simulator.stage.strategy.Strategy
import xyz.qwewqa.relive.simulator.stage.team.Team

data class TeamLoadout(
    val actors: List<ActorLoadout>,
    val guest: ActorLoadout? = null,
    val song: Song = Song(),
    val strategy: Strategy,
) {
    fun create() = Team(
        LinkedHashMap<String, Actor>().apply {
            actors.forEach {
                this[it.name] = it.create()
            }
        },
        guest?.create(),
        song,
        strategy,
    )
}
