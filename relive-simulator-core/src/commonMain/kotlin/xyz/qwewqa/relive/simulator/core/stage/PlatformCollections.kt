@file:Suppress("NOTHING_TO_INLINE")

package xyz.qwewqa.relive.simulator.core.stage

expect inline fun <K, V> emptyPlatformMap(): MutableMap<K, V>
expect inline fun <E> emptyPlatformSet(): MutableSet<E>

inline fun <K, V> platformMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V> = emptyPlatformMap<K, V>().apply { putAll(pairs) }
inline fun <E> platformSetOf(vararg elements: E): MutableSet<E> = emptyPlatformSet<E>().apply { addAll(elements) }
inline fun <K, V> platformMapOf(): MutableMap<K, V> = emptyPlatformMap()
inline fun <E> platformSetOf(): MutableSet<E> = emptyPlatformSet()

fun <K, V> Map<K, V>.toPlatformMap(): MutableMap<K, V> = platformMapOf<K, V>().apply { putAll(this@toPlatformMap) }
fun <E> Set<E>.toPlatformSet(): MutableSet<E> = platformSetOf<E>().apply { addAll(this@toPlatformSet) }
