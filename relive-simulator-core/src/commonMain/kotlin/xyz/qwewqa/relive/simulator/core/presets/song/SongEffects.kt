package xyz.qwewqa.relive.simulator.core.presets.song

val songEffects by lazy {
    listOf(
        DexterityUpSongEffect,
        CriticalUpSongEffect,
    ).associateBy { it.displayName }
}