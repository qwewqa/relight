package xyz.qwewqa.relive.simulator.core.presets.song

import xyz.qwewqa.relive.simulator.core.stage.actor.nonNeutralAttributes

val songEffects = listOf(
    ActPowerUpSongEffect,
    DexterityUpSongEffect,
    CriticalUpSongEffect,
    DamageDealtUpSongEffect,
    *nonNeutralAttributes.map { AttributeDamageDealtUpSongEffect(it) }.toTypedArray(),
    *nonNeutralAttributes.map { againstAttributeDamageDealtUpSongEffect(it) }.toTypedArray(),
).associateBy { it.displayName }
