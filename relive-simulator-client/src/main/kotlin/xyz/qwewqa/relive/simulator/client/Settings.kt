package xyz.qwewqa.relive.simulator.client

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters
import kotlin.js.Date

const val EXPIRATION_AGE = 7 * 24 * 60 * 60 * 1000
const val EXPIRATION_THRESHOLD = 10_000

@Serializable
data class UserSettingsOld(
    val timestamp: Long = 0,
    val presets: MutableMap<String, PlayerLoadoutParameters> = mutableMapOf(),
)

@Serializable
data class UserData(
    val presets: MutableMap<String, SyncData<PlayerLoadoutParameters>> = mutableMapOf(),
) {
    @Transient
    val presetData = SyncMap(presets)

    fun update(other: UserData) {
        presetData.update(other.presetData)
    }
}

class SyncMap<T : Any>(
    private val map: MutableMap<String, SyncData<T>> = mutableMapOf(),
) : MutableMap<String, T> {
    override val entries
        get() = map.entries.asSequence().mapNotNull { (k, v) ->
            if (v.data != null) Entry(k, v.data) as MutableMap.MutableEntry<String, T> else null
        }.toMutableSet()
    override val keys: MutableSet<String>
        get() = map.keys
    override val size: Int
        get() = map.size
    override val values: MutableCollection<T>
        get() = map.values.mapNotNull { it.data }.toMutableSet()

    override fun clear() {
        val now = Date.now().toLong()
        map.keys.toList().forEach { map[it] = SyncData(now, null) }
    }

    override fun isEmpty(): Boolean = map.isEmpty()

    override fun remove(key: String): T? {
        val now = Date.now().toLong()
        return map[key].also {
            map[key] = SyncData(now, null)
        }?.data
    }

    override fun putAll(from: Map<out String, T>) {
        val now = Date.now().toLong()
        map.putAll(from.mapValues { SyncData(now, it.value) })
    }

    override fun put(key: String, value: T): T? {
        val now = Date.now().toLong()
        return map.put(key, SyncData(now, value))?.data
    }

    override fun get(key: String): T? {
        return map[key]?.data
    }

    override fun containsValue(value: T): Boolean {
        return map.values.any { it.data == value }
    }

    override fun containsKey(key: String): Boolean {
        return map.containsKey(key)
    }

    fun update(other: SyncMap<T>) {
        map.update(other.map)
        expireDeleted()
    }

    fun expireDeleted() {
        map.expireDeleted()
    }

    private inner class Entry(
        override val key: String,
        override val value: T,
    ) : MutableMap.MutableEntry<String, T> {
        override fun setValue(newValue: T): T {
            return value.also { this@SyncMap[key] = newValue }
        }
    }
}

@Serializable
data class SyncData<T : Any>(
    val timestamp: Long = 0,
    val data: T?,
)

fun <T : Any> SyncData<T>?.update(other: SyncData<T>?): SyncData<T> {
    return when {
        this == null && other == null -> SyncData(0, null)
        this == null -> other!!
        other == null -> this
        else -> if (this.timestamp > other.timestamp) {
            this
        } else {
            other
        }
    }
}

fun <T : Any> MutableMap<String, SyncData<T>>.expireDeleted() {
    if (size < EXPIRATION_THRESHOLD) return
    val now = Date.now().toLong()
    toList().forEach { (k, v) ->
        if (v.data == null && now - v.timestamp > EXPIRATION_AGE) {
            remove(k)
        }
    }
}

fun <T : Any> MutableMap<String, SyncData<T>>.update(other: Map<String, SyncData<T>>) {
    other.forEach { (k, v) ->
        this[k] = this[k].update(v)
    }
}
