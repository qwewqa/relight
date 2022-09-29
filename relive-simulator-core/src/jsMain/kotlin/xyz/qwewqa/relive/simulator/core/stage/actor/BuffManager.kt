package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect

actual fun activeBuffSet(): MutableSet<ActiveBuff> = ActiveBuffSet()
actual fun <V> buffEffectMap(): MutableMap<BuffEffect, V> = BuffEffectMap()
actual fun countableBuffMap(): MutableMap<CountableBuff, Int> = EnumMap()

class BuffEffectMap<V> : MutableMap<BuffEffect, V> {
    private val map = stringMapOf<V>()

    override val entries: MutableSet<MutableMap.MutableEntry<BuffEffect, V>>
        get() {
            throw UnsupportedOperationException()
        }

    override val keys: MutableSet<BuffEffect>
        get() {
            throw UnsupportedOperationException()
        }

    override val size: Int get() = map.size

    override val values: MutableCollection<V> get() = map.values

    override fun clear() = map.clear()

    override fun isEmpty(): Boolean = map.isEmpty()

    override fun remove(key: BuffEffect): V? = map.remove(key.name)

    override fun putAll(from: Map<out BuffEffect, V>) = map.putAll(from.mapKeys { it.key.name })

    override fun put(key: BuffEffect, value: V): V? = map.put(key.name, value)

    override fun get(key: BuffEffect): V? = map[key.name]

    override fun containsValue(value: V): Boolean = map.containsValue(value)

    override fun containsKey(key: BuffEffect): Boolean = map.containsKey(key.name)
}

class ActiveBuffSet : MutableSet<ActiveBuff> {
    private val map = stringMapOf<ActiveBuff>()

    override fun add(element: ActiveBuff) = map.put(element.key, element) == null

    override fun addAll(elements: Collection<ActiveBuff>) = elements.any { add(it) }

    override val size: Int get() = map.size

    override fun clear() = map.clear()

    override fun isEmpty(): Boolean = map.isEmpty()

    override fun containsAll(elements: Collection<ActiveBuff>): Boolean = elements.all { contains(it) }

    override fun contains(element: ActiveBuff): Boolean = map.containsKey(element.key)

    override fun iterator(): MutableIterator<ActiveBuff> = map.values.iterator()

    override fun retainAll(elements: Collection<ActiveBuff>): Boolean = map.keys.retainAll(elements.map { it.key })

    override fun removeAll(elements: Collection<ActiveBuff>): Boolean = map.keys.removeAll(elements.map { it.key })

    override fun remove(element: ActiveBuff): Boolean = map.remove(element.key) != null
}

class EnumMap<K : Enum<K>, V> : MutableMap<K, V> {
    private val map = stringMapOf<V>()

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() {
            throw UnsupportedOperationException()
        }
    override val keys: MutableSet<K>
        get() {
            throw UnsupportedOperationException()
        }
    override val size: Int get() = map.size
    override val values: MutableCollection<V> get() = map.values

    override fun clear() = map.clear()

    override fun isEmpty(): Boolean = map.isEmpty()

    override fun remove(key: K): V? = map.remove(key.name)

    override fun putAll(from: Map<out K, V>) = map.putAll(from.mapKeys { it.key.name })

    override fun put(key: K, value: V): V? = map.put(key.name, value)

    override fun get(key: K): V? = map[key.name]

    override fun containsValue(value: V): Boolean = map.containsValue(value)

    override fun containsKey(key: K): Boolean = map.containsKey(key.name)
}
