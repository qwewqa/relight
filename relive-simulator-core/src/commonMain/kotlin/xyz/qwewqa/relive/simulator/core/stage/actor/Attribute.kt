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

val nonNeutralAttributes = Attribute.values().filter { it != Attribute.Neutral }

val Attribute.advantagedAgainst get() = when(this) {
    Attribute.Flower -> Attribute.Wind
    Attribute.Wind -> Attribute.Snow
    Attribute.Snow -> Attribute.Flower
    Attribute.Moon -> Attribute.Space
    Attribute.Space -> Attribute.Cloud
    Attribute.Cloud -> Attribute.Moon
    else -> null
}

val Attribute.disadvantagedAgainst get() = when(this) {
    Attribute.Flower -> Attribute.Snow
    Attribute.Wind -> Attribute.Flower
    Attribute.Snow -> Attribute.Wind
    Attribute.Moon -> Attribute.Cloud
    Attribute.Space -> Attribute.Moon
    Attribute.Cloud -> Attribute.Space
    else -> null
}

val effectiveCoefTable = mutableMapOf<Pair<Attribute, Attribute>, Int>().apply {
    Attribute.values().forEach { a ->
        Attribute.values().forEach { b ->
            this[a to b] = 100
        }
    }
    this[Attribute.Flower to Attribute.Wind] = 150
    this[Attribute.Wind to Attribute.Snow] = 150
    this[Attribute.Snow to Attribute.Flower] = 150
    this[Attribute.Moon to Attribute.Space] = 150
    this[Attribute.Space to Attribute.Cloud] = 150
    this[Attribute.Cloud to Attribute.Moon] = 150
    
    this[Attribute.Wind to Attribute.Flower] = 50
    this[Attribute.Snow to Attribute.Wind] = 50
    this[Attribute.Flower to Attribute.Snow] = 50
    this[Attribute.Space to Attribute.Moon] = 50
    this[Attribute.Cloud to Attribute.Space] = 50
    this[Attribute.Moon to Attribute.Cloud] = 50

    this[Attribute.Flower to Attribute.Dream] = 150
    this[Attribute.Wind to Attribute.Dream] = 150
    this[Attribute.Snow to Attribute.Dream] = 150
    this[Attribute.Moon to Attribute.Dream] = 150
    this[Attribute.Space to Attribute.Dream] = 150
    this[Attribute.Cloud to Attribute.Dream] = 150
    
    this[Attribute.Dream to Attribute.Wind] = 125
    this[Attribute.Dream to Attribute.Snow] = 125
    this[Attribute.Dream to Attribute.Flower] = 125
    this[Attribute.Dream to Attribute.Space] = 125
    this[Attribute.Dream to Attribute.Cloud] = 125
    this[Attribute.Dream to Attribute.Moon] = 125
}
