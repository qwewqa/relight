@file:JvmName("PlatformCollectionsImplKt")
@file:Suppress("NOTHING_TO_INLINE")

package xyz.qwewqa.relive.simulator.core.stage

actual inline fun <K, V> emptyPlatformMap(): MutableMap<K, V> = mutableMapOf()
actual inline fun <E> emptyPlatformSet(): MutableSet<E> = mutableSetOf()
