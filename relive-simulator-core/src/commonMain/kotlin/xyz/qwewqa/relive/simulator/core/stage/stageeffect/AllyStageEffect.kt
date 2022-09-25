package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.or

val AngelicSmile = StageEffect(
    "Angelic Smile",
    listOf(
        30,
        35,
        40,
        45,
        50,
    ).map { value ->
        listOf(
            StageBuff(DamageTakenDownBuff, value),
            StageBuff(NormalDefenseUpBuff, value),
            StageBuff(SpecialDefenseUpBuff, value),
        )
    },
    StageEffectTarget.All,
)

val HyakkaRyoran = StageEffect(
    "Hyakka Ryoran",
    listOf(
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(HpRegenBuff, 15000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(HpRegenBuff, 17000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(HpRegenBuff, 19000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(HpRegenBuff, 22000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(HpRegenBuff, 25000),
        ),
    ),
    StageEffectTarget.All,
)

val Bullseye = StageEffect(
    "Bullseye",
    listOf(
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 30),
            StageBuff(PerfectAimBuff, 0),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 35),
            StageBuff(PerfectAimBuff, 0),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 40),
            StageBuff(PerfectAimBuff, 0),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 45),
            StageBuff(PerfectAimBuff, 0),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 50),
            StageBuff(PerfectAimBuff, 0),
        ),
    ),
    StageEffectTarget.All,
)

val TheStageWhereHoshimiJunnaPlaysTheLead = StageEffect(
    "The Stage Where Hoshimi Junna Plays The Lead",
    listOf(
        25,
        50,
        55,
        60,
        65,
    ).map { value ->
        listOf(
            StageBuff(DexterityUpBuff, value),
            StageBuff(CriticalUpBuff, value),
        )
    },
    StageEffectTarget.All,
)

val LightOfCourage = StageEffect(
    "Light of Courage",
    listOf(
        listOf(
            StageBuff(ActPowerUpBuff, 30),
            StageBuff(DexterityUpBuff, 10),
            StageBuff(CriticalUpBuff, 20),
        ),
        listOf(
            StageBuff(ActPowerUpBuff, 40),
            StageBuff(DexterityUpBuff, 15),
            StageBuff(CriticalUpBuff, 25),
        ),
        listOf(
            StageBuff(ActPowerUpBuff, 50),
            StageBuff(DexterityUpBuff, 20),
            StageBuff(CriticalUpBuff, 30),
        ),
        listOf(
            StageBuff(ActPowerUpBuff, 60),
            StageBuff(DexterityUpBuff, 25),
            StageBuff(CriticalUpBuff, 40),
        ),
        listOf(
            StageBuff(ActPowerUpBuff, 70),
            StageBuff(DexterityUpBuff, 30),
            StageBuff(CriticalUpBuff, 50),
        ),
    ),
    StageEffectTarget.All,
)

val TrialsForHeroesTemptationsForSaints = StageEffect(
    "Trials for Heroes, Temptations for Saints",
    listOf(
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(ClimaxDamageUpBuff, 25),
            StageBuff(DexterityUpBuff, 25),
            StageBuff(CriticalUpBuff, 25),
            StageBuff(AgilityUpBuff, 10),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(ClimaxDamageUpBuff, 50),
            StageBuff(DexterityUpBuff, 50),
            StageBuff(CriticalUpBuff, 50),
            StageBuff(AgilityUpBuff, 20),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(ClimaxDamageUpBuff, 55),
            StageBuff(DexterityUpBuff, 55),
            StageBuff(CriticalUpBuff, 55),
            StageBuff(AgilityUpBuff, 25),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(ClimaxDamageUpBuff, 60),
            StageBuff(DexterityUpBuff, 60),
            StageBuff(CriticalUpBuff, 60),
            StageBuff(AgilityUpBuff, 30),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(ClimaxDamageUpBuff, 65),
            StageBuff(DexterityUpBuff, 65),
            StageBuff(CriticalUpBuff, 65),
            StageBuff(AgilityUpBuff, 35),
        ),
    ),
    StageEffectTarget.All,
    MayaOnlyCondition.or(ClaudineOnlyCondition),
)

val FlamesFallingTogether = StageEffect(
    "Flames Falling Together",
    listOf(
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 25),
            StageBuff(CriticalUpBuff, 25),
            StageBuff(BrillianceRegenBuff, 10),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 50),
            StageBuff(CriticalUpBuff, 50),
            StageBuff(BrillianceRegenBuff, 15),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 55),
            StageBuff(CriticalUpBuff, 55),
            StageBuff(BrillianceRegenBuff, 20),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 60),
            StageBuff(CriticalUpBuff, 60),
            StageBuff(BrillianceRegenBuff, 25),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 65),
            StageBuff(CriticalUpBuff, 65),
            StageBuff(BrillianceRegenBuff, 30),
        ),
    ),
    StageEffectTarget.All,
    MayaOnlyCondition.or(ClaudineOnlyCondition),
)

val WildHope = StageEffect(
    "Wild Hope",
    listOf(
        listOf(
            StageBuff(ActPowerUpBuff,20),
            StageBuff(NormalDefenseUpBuff, 30),
            StageBuff(SpecialDefenseUpBuff, 30),
            StageBuff(CriticalUpBuff, 20),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,30),
            StageBuff(NormalDefenseUpBuff, 35),
            StageBuff(SpecialDefenseUpBuff, 35),
            StageBuff(CriticalUpBuff, 25),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,40),
            StageBuff(NormalDefenseUpBuff, 40),
            StageBuff(SpecialDefenseUpBuff, 40),
            StageBuff(CriticalUpBuff, 30),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,50),
            StageBuff(NormalDefenseUpBuff, 45),
            StageBuff(SpecialDefenseUpBuff, 45),
            StageBuff(CriticalUpBuff, 35),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,60),
            StageBuff(NormalDefenseUpBuff, 50),
            StageBuff(SpecialDefenseUpBuff, 50),
            StageBuff(CriticalUpBuff, 40),
        ),
    ),
    StageEffectTarget.All,
    FrontierOnlyCondition,
)

val ThisIsSeparation = StageEffect(
    "This is Separation",
    listOf(
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 30),
            StageBuff(CriticalUpBuff, 30),
            StageBuff(NegativeEffectResistanceBuff, 100),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 60),
            StageBuff(CriticalUpBuff, 60),
            StageBuff(NegativeEffectResistanceBuff, 100),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 80),
            StageBuff(CriticalUpBuff, 80),
            StageBuff(NegativeEffectResistanceBuff, 100),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 90),
            StageBuff(CriticalUpBuff, 90),
            StageBuff(NegativeEffectResistanceBuff, 100),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 100),
            StageBuff(NegativeEffectResistanceBuff, 100),
        ),
    ),
    StageEffectTarget.All,
    KaorukoOnlyCondition
)

val YoureAllHopeless = StageEffect(
    "You're All Hopeless",
    listOf(
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 30),
            StageBuff(CriticalUpBuff, 30),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 60),
            StageBuff(CriticalUpBuff, 60),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 80),
            StageBuff(CriticalUpBuff, 80),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 90),
            StageBuff(CriticalUpBuff, 90),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(ApDownBuff,0),
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 100),
            StageBuff(CounterHealBuff, 20),
        ),
    ),
    StageEffectTarget.All,
    KaorukoOnlyCondition.or(FutabaOnlyCondition)
)

val GlitteringStage = StageEffect(
    "Glittering Stage",
    listOf(
        listOf(
            StageBuff(ActPowerUpBuff,30),
            StageBuff(DexterityUpBuff, 30),
            StageBuff(CriticalUpBuff, 30),
            StageBuff(AgilityUpBuff, 30),
            StageBuff(EffectiveDamageDealtUpBuff, 20),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,60),
            StageBuff(DexterityUpBuff, 60),
            StageBuff(CriticalUpBuff, 60),
            StageBuff(AgilityUpBuff, 60),
            StageBuff(EffectiveDamageDealtUpBuff, 25),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,80),
            StageBuff(DexterityUpBuff, 80),
            StageBuff(CriticalUpBuff, 80),
            StageBuff(AgilityUpBuff, 80),
            StageBuff(EffectiveDamageDealtUpBuff, 30),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,90),
            StageBuff(DexterityUpBuff, 90),
            StageBuff(CriticalUpBuff, 90),
            StageBuff(AgilityUpBuff, 90),
            StageBuff(EffectiveDamageDealtUpBuff, 35),
        ),
        listOf(
            StageBuff(ActPowerUpBuff,100),
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 100),
            StageBuff(AgilityUpBuff, 100),
            StageBuff(EffectiveDamageDealtUpBuff, 40),
        ),
    ),
    StageEffectTarget.All,
    SeishoOnlyCondition
)

val SweetMoment = StageEffect(
    "Sweet Moment",
    listOf(
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 50),
            StageBuff(EffectiveDamageDealtUpBuff, 20),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 60),
            StageBuff(EffectiveDamageDealtUpBuff, 25),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 70),
            StageBuff(EffectiveDamageDealtUpBuff, 30),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 80),
            StageBuff(EffectiveDamageDealtUpBuff, 35),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 90),
            StageBuff(EffectiveDamageDealtUpBuff, 40),
        ),
    ),
    StageEffectTarget.All,
)

val WeAreRivals = StageEffect(
    "We are rivals!",
    listOf(
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(DexterityUpBuff, 30),
            StageBuff(CriticalUpBuff, 30),
            StageBuff(DamageTakenDownBuff, 30),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(DexterityUpBuff, 40),
            StageBuff(CriticalUpBuff, 40),
            StageBuff(DamageTakenDownBuff, 40),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(DexterityUpBuff, 50),
            StageBuff(CriticalUpBuff, 50),
            StageBuff(DamageTakenDownBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(DexterityUpBuff, 60),
            StageBuff(CriticalUpBuff, 60),
            StageBuff(DamageTakenDownBuff, 60),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(DexterityUpBuff, 70),
            StageBuff(CriticalUpBuff, 70),
            StageBuff(DamageTakenDownBuff, 70),
        ),
    ),
    StageEffectTarget.All,
    SeishoOnlyCondition
)