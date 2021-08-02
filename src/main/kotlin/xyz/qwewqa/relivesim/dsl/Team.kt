package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.presets.ActStatUpSongEffect
import xyz.qwewqa.relivesim.stage.character.CharacterLoadout
import xyz.qwewqa.relivesim.stage.team.ClimaxSong
import xyz.qwewqa.relivesim.stage.team.Team

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
        loadouts.associate { it.name to it.createState() }.also {
            if (it.size != loadouts.size) error("Duplicate loadout names")
        },
        friend?.createState(),
        song,
    )
}