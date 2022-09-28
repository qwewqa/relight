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
