package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.presets.ActStatUpSongEffect
import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.StageGirlLoadout
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.strategy.EmptyStrategy
import xyz.qwewqa.relivesim.stage.strategy.Strategy
import xyz.qwewqa.relivesim.stage.team.ClimaxSong
import xyz.qwewqa.relivesim.stage.team.Team

@StageDslMarker
class TeamBuilder : Builder<Team> {
    val loadouts = mutableListOf<StageGirlLoadout>()
    var friend: StageGirlLoadout? = null
    var song: ClimaxSong = ClimaxSong(ActStatUpSongEffect(5))
    var eventBonus: Percent = 0.percent
    var strategy: Strategy = EmptyStrategy()

    inline fun loadout(init: LoadoutBuilder.() -> Unit) {
        loadouts.add(LoadoutBuilder().apply(init).build())
    }

    inline fun friendLoadout(init: LoadoutBuilder.() -> Unit) {
        friend = LoadoutBuilder().apply(init).build()
    }

    override fun build() = Team(
        // It's expected for loadouts to be declared back to front,
        // however, in code, lower indicies are more front
        loadouts.asReversed().associate { it.name to it.createStageGirl() }.also {
            if (it.size != loadouts.size) error("Duplicate loadout names")
        },
        friend?.createStageGirl(),
        song,
        eventBonus,
        strategy,
    )
}