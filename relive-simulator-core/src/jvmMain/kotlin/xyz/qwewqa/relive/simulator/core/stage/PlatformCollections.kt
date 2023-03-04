@file:JvmName("PlatformCollectionsImplKt")
@file:Suppress("NOTHING_TO_INLINE")

package xyz.qwewqa.relive.simulator.core.stage

actual class PlatformMap<K, V> : MutableMap<K, V> by mutableMapOf() {
  actual fun putQuick(key: K, value: V) {
    put(key, value)
  }
  actual operator fun set(key: K, value: V) {
    put(key, value)
  }
}

actual class PlatformSet<E> : MutableSet<E> by mutableSetOf() {
  actual fun addQuick(element: E) {
    add(element)
  }
  actual operator fun plusAssign(element: E) {
    add(element)
  }
}

actual inline fun <K, V> emptyPlatformMap(): PlatformMap<K, V> = PlatformMap()

actual inline fun <E> emptyPlatformSet(): PlatformSet<E> = PlatformSet()
