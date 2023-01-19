@file:JvmName("PlatformCollectionsImplKt")
@file:Suppress("NOTHING_TO_INLINE")

package xyz.qwewqa.relive.simulator.core.stage

actual class PlatformMap<K, V>: MutableMap<K, V> by mutableMapOf()
actual class PlatformSet<E>: MutableSet<E> by mutableSetOf()

actual inline fun <K, V> emptyPlatformMap(): PlatformMap<K, V> = PlatformMap()
actual inline fun <E> emptyPlatformSet(): PlatformSet<E> = PlatformSet()
