package xyz.qwewqa.relive.simulator.core.stage.actor

enum class Attribute {
    Neutral,
    Flower,
    Wind,
    Snow,
    Moon,
    Space,
    Cloud,
    Dream,
}

// Has a minor performance benefit
class AttributeMap<V>(val default: V) : MutableMap<Attribute, V> {
    private var neutral: V = default
    private var flower: V = default
    private var wind: V = default
    private var snow: V = default
    private var moon: V = default
    private var space: V = default
    private var cloud: V = default
    private var dream: V = default

    override val entries: MutableSet<MutableMap.MutableEntry<Attribute, V>>
        get() {
            throw UnsupportedOperationException()
        }
    override val keys: MutableSet<Attribute>
        get() {
            throw UnsupportedOperationException()
        }
    override val size: Int
        get() {
            throw UnsupportedOperationException()
        }
    override val values: MutableCollection<V>
        get() {
            throw UnsupportedOperationException()
        }

    override fun clear() {
        throw UnsupportedOperationException()
    }

    override fun isEmpty(): Boolean = false

    override fun remove(key: Attribute): V? {
        throw UnsupportedOperationException()
    }

    override fun putAll(from: Map<out Attribute, V>) {
        for ((key, value) in from) {
            this[key] = value
        }
    }

    override fun put(key: Attribute, value: V): V? = when (key) {
        Attribute.Neutral -> neutral.also { neutral = value }
        Attribute.Flower -> flower.also { flower = value }
        Attribute.Wind -> wind.also { wind = value }
        Attribute.Snow -> snow.also { snow = value }
        Attribute.Moon -> moon.also { moon = value }
        Attribute.Space -> space.also { space = value }
        Attribute.Cloud -> cloud.also { cloud = value }
        Attribute.Dream -> dream.also { dream = value }
    }

    override fun get(key: Attribute) = when (key) {
        Attribute.Neutral -> neutral
        Attribute.Flower -> flower
        Attribute.Wind -> wind
        Attribute.Snow -> snow
        Attribute.Moon -> moon
        Attribute.Space -> space
        Attribute.Cloud -> cloud
        Attribute.Dream -> dream
    }

    override fun containsValue(value: V) = (
            neutral == value ||
                    flower == value ||
                    wind == value ||
                    snow == value ||
                    moon == value ||
                    space == value ||
                    cloud == value ||
                    dream == value
            )

    override fun containsKey(key: Attribute) = true

}

val nonNeutralAttributes = Attribute.values().filter { it != Attribute.Neutral }

val Attribute.advantagedAgainst
    get() = when (this) {
        Attribute.Flower -> Attribute.Wind
        Attribute.Wind -> Attribute.Snow
        Attribute.Snow -> Attribute.Flower
        Attribute.Moon -> Attribute.Space
        Attribute.Space -> Attribute.Cloud
        Attribute.Cloud -> Attribute.Moon
        else -> null
    }

val Attribute.disadvantagedAgainst
    get() = when (this) {
        Attribute.Flower -> Attribute.Snow
        Attribute.Wind -> Attribute.Flower
        Attribute.Snow -> Attribute.Wind
        Attribute.Moon -> Attribute.Cloud
        Attribute.Space -> Attribute.Moon
        Attribute.Cloud -> Attribute.Space
        else -> null
    }

fun getEffectiveCoef(attacker: Attribute, defender: Attribute) = when (defender) {
    Attribute.Flower -> when (attacker) {
        Attribute.Snow -> 150
        Attribute.Wind -> 50
        Attribute.Dream -> 125
        else -> 100
    }

    Attribute.Wind -> when (attacker) {
        Attribute.Flower -> 150
        Attribute.Snow -> 50
        Attribute.Dream -> 125
        else -> 100
    }

    Attribute.Snow -> when (attacker) {
        Attribute.Wind -> 150
        Attribute.Flower -> 50
        Attribute.Dream -> 125
        else -> 100
    }

    Attribute.Moon -> when (attacker) {
        Attribute.Cloud -> 150
        Attribute.Space -> 50
        Attribute.Dream -> 125
        else -> 100
    }

    Attribute.Space -> when (attacker) {
        Attribute.Moon -> 150
        Attribute.Cloud -> 50
        Attribute.Dream -> 125
        else -> 100
    }

    Attribute.Cloud -> when (attacker) {
        Attribute.Space -> 150
        Attribute.Moon -> 50
        Attribute.Dream -> 125
        else -> 100
    }

    Attribute.Dream -> when (attacker) {
        Attribute.Dream -> 100
        Attribute.Neutral -> 100
        else -> 150
    }

    else -> 100
}
