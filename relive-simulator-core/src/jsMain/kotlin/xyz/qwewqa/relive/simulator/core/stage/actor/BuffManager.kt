package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect

actual fun activeBuffSet(): MutableSet<ActiveBuff> = JsSet()
actual fun <V> buffEffectMap(): MutableMap<TimedBuffEffect, V> = BuffEffectMap()
actual fun countableBuffMap(): MutableMap<CountableBuff, Int> = JsMap()

class BuffEffectMap<V> : MutableMap<TimedBuffEffect, V> {
    private val map = JsMap<String, V>()

    override val entries: MutableSet<MutableMap.MutableEntry<TimedBuffEffect, V>>
        get() {
            throw UnsupportedOperationException()
        }

    override val keys: MutableSet<TimedBuffEffect>
        get() {
            throw UnsupportedOperationException()
        }

    override val size: Int get() = map.size

    override val values: MutableCollection<V> get() = map.values

    override fun clear() = map.clear()

    override fun isEmpty(): Boolean = map.isEmpty()

    override fun remove(key: TimedBuffEffect): V? = map.remove(key.name)

    override fun putAll(from: Map<out TimedBuffEffect, V>) = map.putAll(from.mapKeys { it.key.name })

    override fun put(key: TimedBuffEffect, value: V): V? = map.put(key.name, value)

    override fun get(key: TimedBuffEffect): V? = map[key.name]

    override fun containsValue(value: V): Boolean = map.containsValue(value)

    override fun containsKey(key: TimedBuffEffect): Boolean = map.containsKey(key.name)
}

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
        @Suppress("UNUSED_VARIABLE")
        val value = this
        return js("value[Symbol.iterator]")
    }
val RawJsSet.iterator: () -> RawJsIterator
    get() {
        @Suppress("UNUSED_VARIABLE")
        val value = this
        return js("value[Symbol.iterator]")
    }

fun RawJsIterator.forEach(action: (Any?) -> Unit) {
    while (true) {
        val result = next()
        if (result.done) break
        action(result.value)
    }
}

class JsMap<K, V> : MutableMap<K, V> {
    private class Entry<K, V>(override val key: K, override val value: V) : MutableMap.MutableEntry<K, V> {
        override fun setValue(newValue: V): V {
            throw UnsupportedOperationException()
        }
    }

    private val map = RawJsMap()

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() {
            val result = mutableSetOf<MutableMap.MutableEntry<K, V>>()
            map.entries().forEach { entry ->
                val key = entry.unsafeCast<Array<K>>()[0]
                val value = entry.unsafeCast<Array<V>>()[1]
                result.add(Entry(key, value))
            }
            return result
        }

    override val keys: MutableSet<K>
        get() {
            val result = mutableSetOf<K>()
            map.keys().forEach { key ->
                result.add(key.unsafeCast<K>())
            }
            return result
        }

    override val size: Int
        get() = map.size

    override val values: MutableCollection<V>
        get() {
            val result = mutableSetOf<V>()
            map.values().forEach { value ->
                result.add(value.unsafeCast<V>())
            }
            return result
        }

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
        from.forEach {
            map.set(it.key, it.value)
        }
    }

    override fun put(key: K, value: V): V? {
        return if (map.has(key)) {
            val oldValue = map.get(key)
            map.set(key, value)
            oldValue.unsafeCast<V>()
        } else {
            map.set(key, value)
            null
        }
    }

    override fun get(key: K): V? {
        return if (map.has(key)) {
            map.get(key).unsafeCast<V>()
        } else {
            null
        }
    }

    override fun containsValue(value: V): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsKey(key: K): Boolean {
        return map.has(key)
    }
}

class JsSet<E> : MutableSet<E> {
    private val set = RawJsSet()

    override fun add(element: E): Boolean {
        return if (set.has(element)) {
            false
        } else {
            set.add(element)
            true
        }
    }

    override fun addAll(elements: Collection<E>): Boolean {
        var result = false
        elements.forEach {
            result = add(it) || result
        }
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
        elements.forEach {
            if (!set.has(it)) return false
        }
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
                return current.value.unsafeCast<E>().also {
                    current = iterator.next()
                }
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
        elements.forEach {
            result = remove(it) || result
        }
        return result
    }

    override fun remove(element: E): Boolean {
        return set.delete(element)
    }
}
