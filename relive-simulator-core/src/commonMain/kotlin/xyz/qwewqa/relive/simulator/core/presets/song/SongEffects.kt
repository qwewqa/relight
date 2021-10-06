package xyz.qwewqa.relive.simulator.core.presets.song

import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute

val songEffects = listOf(
    DexterityUpSongEffect,
    CriticalUpSongEffect,
    DamageAgainstAttributeUpSongEffect(Attribute.Flower),
    DamageAgainstAttributeUpSongEffect(Attribute.Wind),
    DamageAgainstAttributeUpSongEffect(Attribute.Ice),
    DamageAgainstAttributeUpSongEffect(Attribute.Moon),
    DamageAgainstAttributeUpSongEffect(Attribute.Space),
    DamageAgainstAttributeUpSongEffect(Attribute.Cloud),
    AttributeDamageDealtUpSongEffect(Attribute.Flower),
    AttributeDamageDealtUpSongEffect(Attribute.Wind),
    AttributeDamageDealtUpSongEffect(Attribute.Ice),
    AttributeDamageDealtUpSongEffect(Attribute.Moon),
    AttributeDamageDealtUpSongEffect(Attribute.Space),
    AttributeDamageDealtUpSongEffect(Attribute.Cloud),
).associateBy { it.displayName }