@file:Suppress("NOTHING_TO_INLINE")

package xyz.qwewqa.relive.simulator.core.stage

expect class PlatformMap<K, V> : MutableMap<K, V> {
  fun putQuick(key: K, value: V)
  operator fun set(key: K, value: V)
}

expect class PlatformSet<E> : MutableSet<E> {
  fun addQuick(element: E)
  operator fun plusAssign(element: E)
}

expect inline fun <K, V> emptyPlatformMap(): PlatformMap<K, V>

expect inline fun <E> emptyPlatformSet(): PlatformSet<E>

inline fun <K, V> platformMapOf(vararg pairs: Pair<K, V>): PlatformMap<K, V> =
    emptyPlatformMap<K, V>().apply { putAll(pairs) }

inline fun <E> platformSetOf(vararg elements: E): PlatformSet<E> =
    emptyPlatformSet<E>().apply { addAll(elements) }

inline fun <K, V> platformMapOf(): PlatformMap<K, V> = emptyPlatformMap()

inline fun <E> platformSetOf(): PlatformSet<E> = emptyPlatformSet()

fun <K, V> Map<K, V>.toPlatformMap(): PlatformMap<K, V> =
    platformMapOf<K, V>().apply { putAll(this@toPlatformMap) }

fun <E> Set<E>.toPlatformSet(): PlatformSet<E> =
    platformSetOf<E>().apply { addAll(this@toPlatformSet) }
