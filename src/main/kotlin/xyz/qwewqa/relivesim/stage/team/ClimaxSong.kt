package xyz.qwewqa.relivesim.stage.team

import xyz.qwewqa.relivesim.stage.effect.AutoEffect
import xyz.qwewqa.relivesim.stage.effect.SongEffect

data class ClimaxSong(val effects: List<SongEffect>, val passive: AutoEffect? = null) {
    constructor(vararg effects: SongEffect, passive: AutoEffect? = null) : this(effects.toList(), passive)
}
