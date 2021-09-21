package xyz.qwewqa.relive.simulator.stage.actor

enum class Attribute {
    Neutral,
    Flower,
    Wind,
    Ice,
    Moon,
    Space,
    Cloud,
    Dream,
}

val effectiveCoefTable = mutableMapOf<Pair<Attribute, Attribute>, Int>().apply {
    Attribute.values().forEach { a ->
        Attribute.values().forEach { b ->
            this[a to b] = 100
        }
    }
    this[Attribute.Flower to Attribute.Wind] = 150
    this[Attribute.Wind to Attribute.Ice] = 150
    this[Attribute.Ice to Attribute.Flower] = 150
    this[Attribute.Moon to Attribute.Space] = 150
    this[Attribute.Space to Attribute.Cloud] = 150
    this[Attribute.Cloud to Attribute.Moon] = 150
    
    this[Attribute.Wind to Attribute.Flower] = 50
    this[Attribute.Ice to Attribute.Wind] = 50
    this[Attribute.Flower to Attribute.Ice] = 50
    this[Attribute.Space to Attribute.Moon] = 50
    this[Attribute.Cloud to Attribute.Space] = 50
    this[Attribute.Moon to Attribute.Cloud] = 50

    this[Attribute.Flower to Attribute.Dream] = 150
    this[Attribute.Wind to Attribute.Dream] = 150
    this[Attribute.Ice to Attribute.Dream] = 150
    this[Attribute.Moon to Attribute.Dream] = 150
    this[Attribute.Space to Attribute.Dream] = 150
    this[Attribute.Cloud to Attribute.Dream] = 150
    
    this[Attribute.Dream to Attribute.Wind] = 125
    this[Attribute.Dream to Attribute.Ice] = 125
    this[Attribute.Dream to Attribute.Flower] = 125
    this[Attribute.Dream to Attribute.Space] = 125
    this[Attribute.Dream to Attribute.Cloud] = 125
    this[Attribute.Dream to Attribute.Moon] = 125
}
