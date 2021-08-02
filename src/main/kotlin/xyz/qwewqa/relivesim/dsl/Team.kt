package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.presets.ActStatUpSongEffect
import xyz.qwewqa.relivesim.stage.character.CharacterLoadout
import xyz.qwewqa.relivesim.stage.team.ClimaxSong
import xyz.qwewqa.relivesim.stage.team.Team

@StageDslMarker
class TeamBuilder {
    val loadouts = mutableListOf<CharacterLoadout>()
    var friend: CharacterLoadout? = null
    var song: ClimaxSong = ClimaxSong(ActStatUpSongEffect(5))

    fun loadout(init: LoadoutBuilder.() -> Unit) {
        loadouts.add(LoadoutBuilder().apply(init).build())
    }

    fun friendLoadout(init: LoadoutBuilder.() -> Unit) {
        friend = LoadoutBuilder().apply(init).build()
    }

    fun build() = Team(
        // It's expected for loadouts to be declared back to front,
        // however, in code, lower indicies are more front
        loadouts.asReversed().associate { it.name to it.createState() }.also {
            if (it.size != loadouts.size) error("Duplicate loadout names")
        },
        friend?.createState(),
        song,
    )
}