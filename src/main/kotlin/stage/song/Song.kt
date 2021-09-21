package xyz.qwewqa.relive.simulator.stage.song

data class Song(val effects: List<SongEffectData>, val passive: SongEffectData? = null) {
    constructor(vararg effects: SongEffectData, passive: SongEffectData? = null) : this(effects.toList(), passive)
}
