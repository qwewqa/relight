package xyz.qwewqa.relive.simulator.core.stage.loadout

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.song.SongDetails
import xyz.qwewqa.relive.simulator.core.stage.strategy.Strategy
import xyz.qwewqa.relive.simulator.core.stage.team.Team

data class TeamLoadout(
  val actors: List<ActorLoadout>,
  val guest: ActorLoadout? = null,
  val song: SongDetails = SongDetails(),
  val strategy: () -> Strategy,
) {
  fun create() =
      Team(
          LinkedHashMap<String, Actor>().apply { actors.forEach { this[it.name] = it.create() } },
          guest?.create(),
          song,
          strategy(),
      )
}
