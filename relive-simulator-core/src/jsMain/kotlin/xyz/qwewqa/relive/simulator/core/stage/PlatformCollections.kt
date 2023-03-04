@file:Suppress("NOTHING_TO_INLINE", "OVERRIDE_BY_INLINE")

package xyz.qwewqa.relive.simulator.core.stage

actual inline fun <K, V> emptyPlatformMap(): PlatformMap<K, V> = PlatformMap()

actual inline fun <E> emptyPlatformSet(): PlatformSet<E> = PlatformSet()

@JsName("Map")
external class RawJsMap {
  val size: Int

  fun clear()
  fun delete(key: Any?): Boolean
  fun get(key: Any?): Any?
  fun has(key: Any?): Boolean
  fun set(key: Any?, value: Any?)
  fun keys(): RawJsIterator
  fun values(): RawJsIterator
  fun entries(): RawJsIterator
}

@JsName("Set")
external class RawJsSet {
  val size: Int

  fun add(element: Any?)
  fun clear()
  fun delete(element: Any?): Boolean
  fun has(element: Any?): Boolean
  fun values(): RawJsIterator
}

external class RawJsIterator {
  class Result {
    val done: Boolean
    val value: Any?
  }

  fun next(): Result
}

val RawJsMap.iterator: () -> RawJsIterator
  get() {
    @Suppress("UNUSED_VARIABLE") val value = this
    return js("value[Symbol.iterator]")
  }
val RawJsSet.iterator: () -> RawJsIterator
  get() {
    @Suppress("UNUSED_VARIABLE") val value = this
    return js("value[Symbol.iterator]")
  }

fun RawJsIterator.forEach(action: (Any?) -> Unit) {
  while (true) {
    val result = next()
    if (result.done) break
    action(result.value)
  }
}

actual class PlatformMap<K, V> : MutableMap<K, V> {
  private val map = RawJsMap()

  class Entry<K, V>(override val key: K, override val value: V) : MutableMap.MutableEntry<K, V> {
    override fun setValue(newValue: V): V {
      throw UnsupportedOperationException()
    }
  }

  override val entries =
      object : MutableSet<MutableMap.MutableEntry<K, V>> {
        override fun add(element: MutableMap.MutableEntry<K, V>) =
            throw UnsupportedOperationException()
        override fun addAll(elements: Collection<MutableMap.MutableEntry<K, V>>) =
            throw UnsupportedOperationException()
        override val size
          get() = this@PlatformMap.size
        override fun clear() = this@PlatformMap.clear()
        override fun isEmpty(): Boolean = this@PlatformMap.isEmpty()
        override fun containsAll(elements: Collection<MutableMap.MutableEntry<K, V>>) =
            throw UnsupportedOperationException()
        override fun contains(element: MutableMap.MutableEntry<K, V>) =
            throw UnsupportedOperationException()
        override fun iterator() =
            object : MutableIterator<MutableMap.MutableEntry<K, V>> {
              private val entries = map.entries()
              private var next = entries.next()

              override fun hasNext() = !next.done

              override fun next(): MutableMap.MutableEntry<K, V> {
                val key = next.value.unsafeCast<Array<K>>()[0]
                val value = next.value.unsafeCast<Array<V>>()[1]
                next = entries.next()
                return Entry(key, value)
              }

              override fun remove() = throw UnsupportedOperationException()
            }
        override fun retainAll(elements: Collection<MutableMap.MutableEntry<K, V>>) =
            throw UnsupportedOperationException()
        override fun removeAll(elements: Collection<MutableMap.MutableEntry<K, V>>) =
            throw UnsupportedOperationException()
        override fun remove(element: MutableMap.MutableEntry<K, V>) =
            throw UnsupportedOperationException()
      }

  override val keys =
      object : MutableSet<K> {
        override fun add(element: K) = throw UnsupportedOperationException()
        override fun addAll(elements: Collection<K>) = throw UnsupportedOperationException()
        override val size
          get() = this@PlatformMap.size
        override fun clear() = this@PlatformMap.clear()
        override fun isEmpty(): Boolean = this@PlatformMap.isEmpty()
        override fun containsAll(elements: Collection<K>) = throw UnsupportedOperationException()
        override fun contains(element: K) = this@PlatformMap.contains(element)
        override fun iterator() =
            object : MutableIterator<K> {
              private val entries = map.keys()
              private var next = entries.next()

              override fun hasNext() = !next.done
              override fun next(): K = next.value.unsafeCast<K>().also { next = entries.next() }
              override fun remove() = throw UnsupportedOperationException()
            }
        override fun retainAll(elements: Collection<K>) = throw UnsupportedOperationException()
        override fun removeAll(elements: Collection<K>) = throw UnsupportedOperationException()
        override fun remove(element: K) = throw UnsupportedOperationException()
      }

  override val values =
      object : MutableCollection<V> {
        override fun add(element: V) = throw UnsupportedOperationException()
        override fun addAll(elements: Collection<V>) = throw UnsupportedOperationException()
        override val size
          get() = this@PlatformMap.size
        override fun clear() = this@PlatformMap.clear()
        override fun isEmpty(): Boolean = this@PlatformMap.isEmpty()
        override fun containsAll(elements: Collection<V>) = throw UnsupportedOperationException()
        override fun contains(element: V) = throw UnsupportedOperationException()
        override fun iterator() =
            object : MutableIterator<V> {
              private val entries = map.values()
              private var next = entries.next()

              override fun hasNext() = !next.done
              override fun next(): V = next.value.unsafeCast<V>().also { next = entries.next() }
              override fun remove() = throw UnsupportedOperationException()
            }
        override fun retainAll(elements: Collection<V>) = throw UnsupportedOperationException()
        override fun removeAll(elements: Collection<V>) = throw UnsupportedOperationException()
        override fun remove(element: V) = throw UnsupportedOperationException()
      }

  override val size: Int
    get() = map.size

  override fun clear() {
    map.clear()
  }

  override fun isEmpty(): Boolean {
    return map.size == 0
  }

  override fun remove(key: K): V? {
    return if (map.has(key)) {
      val value = map.get(key)
      map.delete(key)
      value.unsafeCast<V>()
    } else {
      null
    }
  }

  override fun putAll(from: Map<out K, V>) {
    from.forEach { map.set(it.key, it.value) }
  }

  override fun put(key: K, value: V): V? {
    val oldValue = map.get(key).unsafeCast<V?>()
    map.set(key, value)
    return oldValue
  }

  actual fun putQuick(key: K, value: V) {
    map.set(key, value)
  }

  actual operator fun set(key: K, value: V) {
    map.set(key, value)
  }

  override fun get(key: K): V? {
    return map.get(key).unsafeCast<V?>()
  }

  override fun containsValue(value: V): Boolean {
    throw UnsupportedOperationException()
  }

  override fun containsKey(key: K): Boolean {
    return map.has(key)
  }
}

actual class PlatformSet<E> : MutableSet<E> {
  private val set = RawJsSet()

  override fun add(element: E): Boolean {
    return if (set.has(element)) {
      false
    } else {
      set.add(element)
      true
    }
  }

  actual fun addQuick(element: E) {
    set.add(element)
  }

  actual operator fun plusAssign(element: E) {
    set.add(element)
  }

  override fun addAll(elements: Collection<E>): Boolean {
    var result = false
    elements.forEach { result = add(it) || result }
    return result
  }

  override val size: Int
    get() = set.size

  override fun clear() {
    set.clear()
  }

  override fun isEmpty(): Boolean {
    return set.size == 0
  }

  override fun containsAll(elements: Collection<E>): Boolean {
    elements.forEach { if (!set.has(it)) return false }
    return true
  }

  override fun contains(element: E): Boolean {
    return set.has(element)
  }

  override fun iterator(): MutableIterator<E> {
    return object : MutableIterator<E> {
      val iterator = set.iterator()
      var current: RawJsIterator.Result = iterator.next()

      override fun hasNext(): Boolean {
        return !current.done
      }

      override fun next(): E {
        return current.value.unsafeCast<E>().also { current = iterator.next() }
      }

      override fun remove() {
        throw UnsupportedOperationException()
      }
    }
  }

  override fun retainAll(elements: Collection<E>): Boolean {
    throw UnsupportedOperationException()
  }

  override fun removeAll(elements: Collection<E>): Boolean {
    var result = false
    elements.forEach { result = remove(it) || result }
    return result
  }

  override fun remove(element: E): Boolean {
    return set.delete(element)
  }
}
