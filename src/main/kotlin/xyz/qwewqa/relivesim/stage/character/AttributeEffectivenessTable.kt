package xyz.qwewqa.relivesim.stage.character

typealias AttributeEffectivenessTable = Map<Attribute, Double>

val standardAttributeEffectivenessTables = getAttributeEffectivenessTableSet()

fun getAttributeEffectivenessTableSet(
    defaultValue: Double = 1.0,
    effectiveValue: Double = 1.5,
    weakValue: Double = 0.5,
    dreamDealtValue: Double = 1.25,
): Map<Attribute, AttributeEffectivenessTable> {
    val base = mapOf(
        Attribute.NeutralAttribute to defaultValue,
        Attribute.Flower to defaultValue,
        Attribute.Wind to defaultValue,
        Attribute.Ice to defaultValue,
        Attribute.Moon to defaultValue,
        Attribute.Space to defaultValue,
        Attribute.Cloud to defaultValue,
        Attribute.Dream to dreamDealtValue,
    )

    fun getTableFor(effectiveAttribute: Attribute, weakAttribute: Attribute) = base.toMutableMap().apply {
        this[effectiveAttribute] = effectiveValue
        this[weakAttribute] = weakValue
    }.toMap()

    return mapOf(
        Attribute.NeutralAttribute to base,
        Attribute.Flower to getTableFor(Attribute.Ice, Attribute.Wind),
        Attribute.Wind to getTableFor(Attribute.Flower, Attribute.Ice),
        Attribute.Ice to getTableFor(Attribute.Wind, Attribute.Flower),
        Attribute.Moon to getTableFor(Attribute.Cloud, Attribute.Space),
        Attribute.Space to getTableFor(Attribute.Moon, Attribute.Cloud),
        Attribute.Cloud to getTableFor(Attribute.Space, Attribute.Moon),
        Attribute.Dream to mapOf(
            Attribute.NeutralAttribute to effectiveValue,
            Attribute.Flower to effectiveValue,
            Attribute.Wind to effectiveValue,
            Attribute.Ice to effectiveValue,
            Attribute.Moon to effectiveValue,
            Attribute.Space to effectiveValue,
            Attribute.Cloud to effectiveValue,
            Attribute.Dream to dreamDealtValue,
        ),
    )
}

