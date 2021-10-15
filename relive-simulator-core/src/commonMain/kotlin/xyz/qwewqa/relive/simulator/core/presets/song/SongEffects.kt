package xyz.qwewqa.relive.simulator.core.presets.song

import xyz.qwewqa.relive.simulator.core.stage.actor.nonNeutralAttributes

val songEffects = listOf(
    ActPowerUpSongEffect,
    DexterityUpSongEffect,
    CriticalUpSongEffect,
    *nonNeutralAttributes.map { AttributeDamageDealtUpSongEffect(it) }.toTypedArray(),
    *nonNeutralAttributes.map { AgainstAttributeDamageDealtUpSongEffect(it) }.toTypedArray(),
).associateBy { it.displayName }
