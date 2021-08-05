package xyz.qwewqa.relivesim.stage.team

import xyz.qwewqa.relivesim.stage.effect.AutoEffect
import xyz.qwewqa.relivesim.stage.effect.SongEffect

data class ClimaxSong(val effects: List<SongEffect>, val passive: SongEffect? = null) {
    constructor(vararg effects: SongEffect, passive: SongEffect? = null) : this(effects.toList(), passive)
}
