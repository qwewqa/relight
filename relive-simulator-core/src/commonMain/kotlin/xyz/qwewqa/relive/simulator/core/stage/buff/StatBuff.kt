package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.modifier.*

val ActPowerUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(1).makeModifierTimedBuffEffect(
        modifier = actPowerUp,
        category = BuffCategory.Positive,
        flipped = { ActPowerDownBuff }
    )
}

val ActPowerDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(2).makeModifierTimedBuffEffect(
        modifier = actPowerDown,
        category = BuffCategory.Negative,
        flipped = { ActPowerUpBuff }
    )
}

val NormalDefenseUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(3).makeModifierTimedBuffEffect(
        modifier = normalDefenseUp,
        category = BuffCategory.Positive,
        flipped = { NormalDefenseDownBuff }
    )
}

val NormalDefenseDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(4).makeModifierTimedBuffEffect(
        modifier = normalDefenseDown,
        category = BuffCategory.Negative,
        flipped = { NormalDefenseUpBuff }
    )
}

val SpecialDefenseUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(5).makeModifierTimedBuffEffect(
        modifier = specialDefenseUp,
        category = BuffCategory.Positive,
        flipped = { SpecialDefenseDownBuff }
    )
}

val SpecialDefenseDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(6).makeModifierTimedBuffEffect(
        modifier = specialDefenseDown,
        category = BuffCategory.Negative,
        flipped = { SpecialDefenseUpBuff }
    )
}

val AgilityUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(7).makeModifierTimedBuffEffect(
        modifier = agilityUp,
        category = BuffCategory.Positive,
        flipped = { AgilityDownBuff }
    )
}

val AgilityDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(8).makeModifierTimedBuffEffect(
        modifier = agilityDown,
        category = BuffCategory.Negative,
        flipped = { AgilityUpBuff }
    )
}

val AccuracyUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(9).makeModifierTimedBuffEffect(
        modifier = accuracyUp,
        category = BuffCategory.Positive,
        flipped = { AccuracyDownBuff }
    )
}

val AccuracyDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(10).makeModifierTimedBuffEffect(
        modifier = accuracyDown,
        category = BuffCategory.Negative,
        flipped = { AccuracyUpBuff }
    )
}

val EvasionUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(11).makeModifierTimedBuffEffect(
        modifier = evasionUp,
        category = BuffCategory.Positive,
        flipped = { EvasionDownBuff }
    )
}

val EvasionDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(12).makeModifierTimedBuffEffect(
        modifier = evasionDown,
        category = BuffCategory.Negative,
        flipped = { EvasionUpBuff }
    )
}

val DexterityUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(13).makeModifierTimedBuffEffect(
        modifier = buffDexterity,
        category = BuffCategory.Positive,
        flipped = { DexterityDownBuff }
    )
}

val DexterityDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(14).makeModifierTimedBuffEffect(
        modifier = debuffDexterity,
        category = BuffCategory.Negative,
        flipped = { DexterityUpBuff }
    )
}

val CriticalUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(15).makeModifierTimedBuffEffect(
        modifier = buffCritical,
        category = BuffCategory.Positive,
        flipped = { CriticalDownBuff }
    )
}

val CriticalDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(16).makeModifierTimedBuffEffect(
        modifier = debuffCritical,
        category = BuffCategory.Negative,
        flipped = { CriticalUpBuff }
    )
}

val EffectiveDamageDealtUpBuff = buffData(32).makeModifierTimedBuffEffect(
    modifier = effectiveDamageUp,
    category = BuffCategory.Positive,
)

val LockedEffectiveDamageDealtUpBuff = buffData(278).makeLockedVariantOf(EffectiveDamageDealtUpBuff)


val DamageDealtUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(95).makeModifierTimedBuffEffect(
        modifier = damageDealtUp,
        category = BuffCategory.Positive,
        flipped = { DamageDealtDownBuff }
    )
}

val DamageDealtDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(96).makeModifierTimedBuffEffect(
        modifier = damageDealtDown,
        category = BuffCategory.Negative,
        flipped = { DamageDealtUpBuff }
    )
}

val DamageReceivedUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(97).makeModifierTimedBuffEffect(
        modifier = damageReceivedUp,
        category = BuffCategory.Negative,
        flipped = { DamageReceivedDownBuff }
    )
}

val DamageReceivedDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(98).makeModifierTimedBuffEffect(
        modifier = damageReceivedDown,
        category = BuffCategory.Positive,
        flipped = { DamageReceivedUpBuff }
    )
}

val BrillianceGainUpBuff = buffData(233).makeModifierTimedBuffEffect(
    modifier = brillianceGainUp,
    category = BuffCategory.Positive,
)

val BrillianceGainDownBuff = buffData(126).makeModifierTimedBuffEffect(
    modifier = brillianceGainDown,
    category = BuffCategory.Negative,
)

val ClimaxDamageUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(33).makeModifierTimedBuffEffect(
        modifier = climaxDamageUp,
        category = BuffCategory.Positive,
        flipped = { ClimaxDamageDownBuff }
    )
}

val ClimaxDamageDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(161).makeModifierTimedBuffEffect(
        modifier = climaxDamageDown,
        category = BuffCategory.Negative,
        flipped = { ClimaxDamageUpBuff }
    )
}

val NormalReflectBuff = buffData(25).makeModifierTimedBuffEffect(
    modifier = normalReflect,
    category = BuffCategory.Positive,
)

val SpecialReflectBuff = buffData(26).makeModifierTimedBuffEffect(
    modifier = specialReflect,
    category = BuffCategory.Positive,
)

val NormalSuperReflectBuff = buffData(258).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
)

val SpecialSuperReflectBuff = buffData(259).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
)

val LockedNormalSuperReflectBuff = buffData(260).makeLockedVariantOf(NormalSuperReflectBuff)

val LockedSpecialSuperReflectBuff = buffData(261).makeLockedVariantOf(SpecialSuperReflectBuff)

val HpRecoveryDownBuff = buffData(58).makeModifierTimedBuffEffect(
    modifier = hpRecoveryDown,
    category = BuffCategory.Negative,
)

private fun BuffData.againstAttributeDamageReceivedUpBuff(attribute: Attribute) = makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    onStart = { value ->
        self.againstAttributeDamageReceivedDown[attribute] -= value
    },
    onEnd = { value ->
        self.againstAttributeDamageReceivedDown[attribute] += value
    }
)

private fun BuffData.againstAttributeDamageReceivedDownBuff(attribute: Attribute) = makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    onStart = { value ->
        self.againstAttributeDamageReceivedDown[attribute] += value
    },
    onEnd = { value ->
        self.againstAttributeDamageReceivedDown[attribute] -= value
    }
)

private fun BuffData.againstAttributeDamageDealtUpBuff(attribute: Attribute) = makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    onStart = { value ->
        self.againstAttributeDamageDealtUp[attribute] += value
    },
    onEnd = { value ->
        self.againstAttributeDamageDealtUp[attribute] -= value
    }
)

val FlowerDamageReceivedDownBuff = buffData(59).againstAttributeDamageReceivedDownBuff(Attribute.Flower)
val WindDamageReceivedDownBuff = buffData(60).againstAttributeDamageReceivedDownBuff(Attribute.Wind)
val SnowDamageReceivedDownBuff = buffData(61).againstAttributeDamageReceivedDownBuff(Attribute.Snow)
val MoonDamageReceivedDownBuff = buffData(62).againstAttributeDamageReceivedDownBuff(Attribute.Moon)
val SpaceDamageReceivedDownBuff = buffData(63).againstAttributeDamageReceivedDownBuff(Attribute.Space)
val CloudDamageReceivedDownBuff = buffData(64).againstAttributeDamageReceivedDownBuff(Attribute.Cloud)
val DreamDamageReceivedDownBuff = buffData(65).againstAttributeDamageReceivedDownBuff(Attribute.Dream)

// TODO: Find out what these are
val AgainstFlowerDamageDealtUpBuff = buffData(95).againstAttributeDamageDealtUpBuff(Attribute.Flower)
val AgainstWindDamageDealtUpBuff = buffData(95).againstAttributeDamageDealtUpBuff(Attribute.Wind)
val AgainstSnowDamageDealtUpBuff = buffData(95).againstAttributeDamageDealtUpBuff(Attribute.Snow)
val AgainstMoonDamageDealtUpBuff = buffData(95).againstAttributeDamageDealtUpBuff(Attribute.Moon)
val AgainstSpaceDamageDealtUpBuff = buffData(95).againstAttributeDamageDealtUpBuff(Attribute.Space)
val AgainstCloudDamageDealtUpBuff = buffData(95).againstAttributeDamageDealtUpBuff(Attribute.Cloud)
val AgainstDreamDamageDealtUpBuff = buffData(95).againstAttributeDamageDealtUpBuff(Attribute.Dream)

val FlowerDamageReceivedUpBuff = buffData(147).againstAttributeDamageReceivedUpBuff(Attribute.Flower)
val WindDamageReceivedUpBuff = buffData(148).againstAttributeDamageReceivedUpBuff(Attribute.Wind)
val SnowDamageReceivedUpBuff = buffData(149).againstAttributeDamageReceivedUpBuff(Attribute.Snow)
val MoonDamageReceivedUpBuff = buffData(150).againstAttributeDamageReceivedUpBuff(Attribute.Moon)
val SpaceDamageReceivedUpBuff = buffData(151).againstAttributeDamageReceivedUpBuff(Attribute.Space)
val CloudDamageReceivedUpBuff = buffData(152).againstAttributeDamageReceivedUpBuff(Attribute.Cloud)
val DreamDamageReceivedUpBuff = buffData(153).againstAttributeDamageReceivedUpBuff(Attribute.Dream)

fun againstAttributeDamageDealtUpBuff(attribute: Attribute) = when (attribute) {
    Attribute.Flower -> AgainstFlowerDamageDealtUpBuff
    Attribute.Wind -> AgainstWindDamageDealtUpBuff
    Attribute.Snow -> AgainstSnowDamageDealtUpBuff
    Attribute.Moon -> AgainstMoonDamageDealtUpBuff
    Attribute.Space -> AgainstSpaceDamageDealtUpBuff
    Attribute.Cloud -> AgainstCloudDamageDealtUpBuff
    Attribute.Dream -> AgainstDreamDamageDealtUpBuff
    else -> error("Attribute $attribute not supported")
}

fun againstAttributeDamageReceivedUpBuff(attribute: Attribute) = when (attribute) {
    Attribute.Flower -> FlowerDamageReceivedUpBuff
    Attribute.Wind -> WindDamageReceivedUpBuff
    Attribute.Snow -> SnowDamageReceivedUpBuff
    Attribute.Moon -> MoonDamageReceivedUpBuff
    Attribute.Space -> SpaceDamageReceivedUpBuff
    Attribute.Cloud -> CloudDamageReceivedUpBuff
    Attribute.Dream -> DreamDamageReceivedUpBuff
    else -> error("Attribute $attribute not supported")
}

fun againstAttributeDamageReceivedDownBuff(attribute: Attribute) = when (attribute) {
    Attribute.Flower -> FlowerDamageReceivedDownBuff
    Attribute.Wind -> WindDamageReceivedDownBuff
    Attribute.Snow -> SnowDamageReceivedDownBuff
    Attribute.Moon -> MoonDamageReceivedDownBuff
    Attribute.Space -> SpaceDamageReceivedDownBuff
    Attribute.Cloud -> CloudDamageReceivedDownBuff
    Attribute.Dream -> DreamDamageReceivedDownBuff
    else -> error("Attribute $attribute not supported")
}


