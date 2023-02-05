package xyz.qwewqa.relive.simulator.core.presets.accessory

import xyz.qwewqa.relive.simulator.core.presets.accessory.generated.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val ringAutoskills = listOf(
    4 to listOf(
        SelfReviveBuffPassive.new(value = 50, time = 1),
    ),
    7 to listOf(
        SelfFortitudeBuffPassive.new(time = 4),
        SelfBlessingEffectiveDamagePassive.new(value = 30, time = 1),
    ),
)

val pendantAutoskills = listOf(
    3 to listOf(
        SelfReviveBuffPassive.new(value = 50, time = 1),
        SelfFortitudeBuffPassive.new(time = 2),
    ),
    6 to listOf(
        SelfFortitudeBuffPassive.new(time = 2),
        SelfBlessingEffectiveDamagePassive.new(value = 50, time = 1),
    ),
    9 to listOf(
        SelfBlessingEffectiveDamagePassive.new(value = 50, time = 1),
        SelfBlessingCountableDebuffReductionPassive.new(value = 2, time = 1)
    )
)

val broochAutoskills = listOf(
    2 to listOf(
        SelfReviveBuffPassive.new(value = 50, time = 1),
        SelfFortitudeBuffPassive.new(time = 4),
    ),
    5 to listOf(
        SelfBlessingEffectiveDamagePassive.new(value = 50, time = 2),
    ),
    8 to listOf(
        SelfBlessingCountableDebuffReductionPassive.new(value = 2, time = 1),
        SelfBlessingBlessingContinuousDebuffRemovalPassive.new(time = 1),
    ),
    10 to listOf(
        SelfLockedEffectiveDamageDealtUpBuffPassive.new(value = 30, time = 12),
        SelfInvincibleRebirthBuffPassive.new(value = 100, time = 1),
    )
)
val flowerRing = accessory38(
    "Flower Ring",
    autoskills = ringAutoskills,
)
val flowerPendant = accessory39(
    "Flower Pendant",
    autoskills = pendantAutoskills,
)
val flowerBrooch = accessory40(
    "Flower Brooch",
    autoskills = broochAutoskills,
)
val windRing = accessory41(
    "Wind Ring",
    autoskills = ringAutoskills,
)
val windPendant = accessory42(
    "Wind Pendant",
    autoskills = pendantAutoskills,
)
val windBrooch = accessory43(
    "Wind Brooch",
    autoskills = broochAutoskills,
)
val snowRing = accessory44(
    "Snow Ring",
    autoskills = ringAutoskills,
)
val snowPendant = accessory45(
    "Snow Pendant",
    autoskills = pendantAutoskills,
)
val snowBrooch = accessory46(
    "Snow Brooch",
    autoskills = broochAutoskills,
)
val moonRing = accessory47(
    "Moon Ring",
    autoskills = ringAutoskills,
)
val moonPendant = accessory48(
    "Moon Pendant",
    autoskills = pendantAutoskills,
)
val moonBrooch = accessory49(
    "Moon Brooch",
    autoskills = broochAutoskills,
)
val spaceRing = accessory50(
    "Space Ring",
    autoskills = ringAutoskills,
)
val spacePendant = accessory51(
    "Space Pendant",
    autoskills = pendantAutoskills,
)
val spaceBrooch = accessory52(
    "Space Brooch",
    autoskills = broochAutoskills,
)
val cloudRing = accessory53(
    "Cloud Ring",
    autoskills = ringAutoskills,
)
val cloudPendant = accessory54(
    "Cloud Pendant",
    autoskills = pendantAutoskills,
)
val cloudBrooch = accessory55(
    "Cloud Brooch",
    autoskills = broochAutoskills,
)
val dreamRing = accessory56(
    "Dream Ring",
    autoskills = ringAutoskills,
)
val dreamPendant = accessory57(
    "Dream Pendant",
    autoskills = pendantAutoskills,
)
val dreamBrooch = accessory58(
    "Dream Brooch",
    autoskills = broochAutoskills,
)
val sunRing = accessory59(
    "Sun Ring",
    autoskills = ringAutoskills,
)
val sunPendant = accessory60(
    "Sun Pendant",
    autoskills = pendantAutoskills,
)
val sunBrooch = accessory61(
    "Sun Brooch",
    autoskills = broochAutoskills,
)
val starRing = accessory62(
    "Star Ring",
    autoskills = ringAutoskills,
)
val starPendant = accessory63(
    "Star Pendant",
    autoskills = pendantAutoskills,
)
val starBrooch = accessory64(
    "Star Brooch",
    autoskills = broochAutoskills,
)