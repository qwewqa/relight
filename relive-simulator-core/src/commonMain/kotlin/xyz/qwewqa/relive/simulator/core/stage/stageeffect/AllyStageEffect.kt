package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.stage.buff.*

val AngelicSmile = StageEffect(
    "Angelic Smile",
    22,
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
    27,
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
    36,
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
    29,
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
    1,
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
    30,
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
    32,
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
    20,
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

val Majestic = StageEffect(
    "Majestic",
    53,
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
    RinmeikanOnlyCondition,
)

val ThisIsSeparation = StageEffect(
    "This is Separation",
    33,
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
    34,
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
    35,
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
    31,
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
    43,
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

val RoyalAuthority = StageEffect(
    "Royal Authority",
    44,
    listOf(
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(ActPowerUpBuff, 30),
            StageBuff(DamageTakenDownBuff, 30),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(ActPowerUpBuff, 40),
            StageBuff(DamageTakenDownBuff, 40),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(ActPowerUpBuff, 50),
            StageBuff(DamageTakenDownBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(ActPowerUpBuff, 60),
            StageBuff(DamageTakenDownBuff, 60),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(ActPowerUpBuff, 70),
            StageBuff(DamageTakenDownBuff, 70),
        ),
    ),
    StageEffectTarget.All,
    SiegfeldOnlyCondition
)

//ここが舞台だ
//味方の聖翔音楽学園にAP減少、クリティカル率アップ[30, 40, 50, 60, 70]%、クリティカル威力アップ[30, 40, 50, 60, 70]%、属性有利ダメージUP[30, 40, 50, 60, 70]%、味方の愛城華恋と神楽ひかりにクリティカル率アップ[10, 15, 20, 25, 30]%
//🞖 味方側の舞台
val ThisIsTheStage = StageEffect(
    "This is the Stage",
    48,
    listOf(
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(DexterityUpBuff, 30),
                    StageBuff(CriticalUpBuff, 30),
                    StageBuff(EffectiveDamageDealtUpBuff, 30),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(DexterityUpBuff, 40),
                    StageBuff(CriticalUpBuff, 40),
                    StageBuff(EffectiveDamageDealtUpBuff, 40),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(DexterityUpBuff, 50),
                    StageBuff(CriticalUpBuff, 50),
                    StageBuff(EffectiveDamageDealtUpBuff, 50),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(DexterityUpBuff, 60),
                    StageBuff(CriticalUpBuff, 60),
                    StageBuff(EffectiveDamageDealtUpBuff, 60),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(DexterityUpBuff, 70),
                    StageBuff(CriticalUpBuff, 70),
                    StageBuff(EffectiveDamageDealtUpBuff, 70),
                ),
            ),
            SeishoOnlyCondition,
        ),
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(DexterityUpBuff, 10),
                ),
                listOf(
                    StageBuff(DexterityUpBuff, 15),
                ),
                listOf(
                    StageBuff(DexterityUpBuff, 20),
                ),
                listOf(
                    StageBuff(DexterityUpBuff, 25),
                ),
                listOf(
                    StageBuff(DexterityUpBuff, 30),
                ),
            ),
            KarenOnlyCondition or HikariOnlyCondition,
        ),
    ),
    StageEffectTarget.All,
)

val GoldenVitality = StageEffect(
    "Golden Vitality",
    58,
    listOf(
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 50),
            StageBuff(NegativeCountableEffectResistanceBuff, 50),
            StageBuff(DamageTakenDownBuff, 30),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 60),
            StageBuff(NegativeCountableEffectResistanceBuff, 60),
            StageBuff(DamageTakenDownBuff, 40),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 70),
            StageBuff(NegativeCountableEffectResistanceBuff, 70),
            StageBuff(DamageTakenDownBuff, 50),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 80),
            StageBuff(NegativeCountableEffectResistanceBuff, 80),
            StageBuff(DamageTakenDownBuff, 60),
        ),
        listOf(
            StageBuff(NegativeEffectResistanceBuff, 90),
            StageBuff(NegativeCountableEffectResistanceBuff, 90),
            StageBuff(DamageTakenDownBuff, 70),
        ),
    ),
    StageEffectTarget.All,
)

//賢者の契り
//味方全体にAP減少、必中、クリティカル率アップ[50, 55, 60, 65, 70]%、クリティカル威力アップ[50, 55, 60, 65, 70]%、味方の純那とななにHP回復[100, 100, 100, 100, 100]%
//🞖 味方側の舞台
val SagesCovenant = StageEffect(
    "Sage's Covenant",
    59,
    listOf(
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(PerfectAimBuff, 0),
                    StageBuff(DexterityUpBuff, 50),
                    StageBuff(CriticalUpBuff, 50),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(PerfectAimBuff, 0),
                    StageBuff(DexterityUpBuff, 55),
                    StageBuff(CriticalUpBuff, 55),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(PerfectAimBuff, 0),
                    StageBuff(DexterityUpBuff, 60),
                    StageBuff(CriticalUpBuff, 60),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(PerfectAimBuff, 0),
                    StageBuff(DexterityUpBuff, 65),
                    StageBuff(CriticalUpBuff, 65),
                ),
                listOf(
                    StageBuff(ApDownBuff, 0),
                    StageBuff(PerfectAimBuff, 0),
                    StageBuff(DexterityUpBuff, 70),
                    StageBuff(CriticalUpBuff, 70),
                ),
            ),
        ),
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(HpRegenBuff, 100),
                ),
                listOf(
                    StageBuff(HpRegenBuff, 100),
                ),
                listOf(
                    StageBuff(HpRegenBuff, 100),
                ),
                listOf(
                    StageBuff(HpRegenBuff, 100),
                ),
                listOf(
                    StageBuff(HpRegenBuff, 100),
                ),
            ),
            JunnaOnlyCondition or NanaOnlyCondition,
        ),
    ),
    StageEffectTarget.All,
)

//美しく、気高く、楽しく
//味方の青嵐総合芸術院にAP減少2、継続マイナス効果耐性アップ[100, 100, 100, 100, 100]、ACTパワーアップ[20, 25, 30, 35, 40]%
val BeautifulNobleAndFun = StageEffect(
    "Beautiful, Noble, and Fun",
    61,
    listOf(
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 20),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 25),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 30),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 35),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 40),
                ),
            ),
            SeiranOnlyCondition,
        ),
    ),
    StageEffectTarget.All,
)

val LightningShade = StageEffect(
    "Lightning Shade",
    10,
    listOf(
        listOf(
            StageBuff(AgilityUpBuff,20),
            StageBuff(ActPowerUpBuff, 20),
            StageBuff(DexterityUpBuff, 20),
        ),
        listOf(
            StageBuff(AgilityUpBuff,25),
            StageBuff(ActPowerUpBuff, 30),
            StageBuff(DexterityUpBuff, 25),
        ),
        listOf(
            StageBuff(AgilityUpBuff,30),
            StageBuff(ActPowerUpBuff, 40),
            StageBuff(DexterityUpBuff, 30),
        ),
        listOf(
            StageBuff(AgilityUpBuff,35),
            StageBuff(ActPowerUpBuff, 50),
            StageBuff(DexterityUpBuff, 35),
        ),
        listOf(
            StageBuff(AgilityUpBuff,40),
            StageBuff(ActPowerUpBuff, 60),
            StageBuff(DexterityUpBuff, 40),
        ),
    ),
    StageEffectTarget.All,
)

val DivinePower = StageEffect(
    "Divine Power",
    52,
    listOf(
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeCountableEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 20),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeCountableEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 30),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeCountableEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 40),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeCountableEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 50),
                ),
                listOf(
                    StageBuff(Ap2DownBuff, 0),
                    StageBuff(NegativeCountableEffectResistanceBuff, 100),
                    StageBuff(ActPowerUpBuff, 60),
                ),
            ),
        ),
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(NegativeEffectResistanceBuff, 100),
                ),
                listOf(
                    StageBuff(NegativeEffectResistanceBuff, 100),
                ),
                listOf(
                    StageBuff(NegativeEffectResistanceBuff, 100),
                ),
                listOf(
                    StageBuff(NegativeEffectResistanceBuff, 100),
                ),
                listOf(
                    StageBuff(NegativeEffectResistanceBuff, 100),
                ),
            ),
            RoVOnlyCondition,
        ),
    ),
    StageEffectTarget.All,
)

val HappyFootsteps = StageEffect(
    "Happy Footsteps",
    62,
    listOf(
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 20),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 30),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 40),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 50),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 60),
            StageBuff(BrillianceRegenBuff, 50),
        ),
    ),
    StageEffectTarget.All,
)

val LeapOath = StageEffect(
    "Leap Oath",
    63,
    listOf(
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 20),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 30),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 40),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 50),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 60),
            StageBuff(BrillianceRegenBuff, 50),
        ),
    ),
    StageEffectTarget.All,
)

val ElegantInvitation = StageEffect(
    "ElegantInvitation",
    71,
    listOf(
        listOf(
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 20),
            StageBuff(NormalDefenseUpBuff, 30),
            StageBuff(SpecialDefenseUpBuff, 30),
            StageBuff(CriticalUpBuff, 50),
        ),
        listOf(
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 30),
            StageBuff(NormalDefenseUpBuff, 35),
            StageBuff(SpecialDefenseUpBuff, 35),
            StageBuff(CriticalUpBuff, 55),
        ),
        listOf(
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 40),
            StageBuff(NormalDefenseUpBuff, 40),
            StageBuff(SpecialDefenseUpBuff, 40),
            StageBuff(CriticalUpBuff, 60),
        ),
        listOf(
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 50),
            StageBuff(NormalDefenseUpBuff, 45),
            StageBuff(SpecialDefenseUpBuff, 45),
            StageBuff(CriticalUpBuff, 65),
        ),
        listOf(
            StageBuff(NegativeCountableEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 60),
            StageBuff(NormalDefenseUpBuff, 50),
            StageBuff(SpecialDefenseUpBuff, 50),
            StageBuff(CriticalUpBuff, 70),
        ),
    ),
    StageEffectTarget.All,
)

val FloatingWithTheTide = StageEffect(
    "Floating with the Tide",
    72,
    listOf(
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 20),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 25),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 30),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 35),
        ),
        listOf(
            StageBuff(ApDownBuff, 0),
            StageBuff(NegativeEffectResistanceBuff, 100),
            StageBuff(ActPowerUpBuff, 40),
        ),
    ),
    StageEffectTarget.All,
)

val SparklingTide = StageEffect(
    "Sparkling Tide",
    73,
    listOf(
        listOf(
            StageBuff(EvasionRateUpBuff, 70),
            StageBuff(DexterityUpBuff, 30),
            StageBuff(CriticalUpBuff, 30),
            StageBuff(BrillianceRegenBuff, 50),
        ),
        listOf(
            StageBuff(EvasionRateUpBuff, 75),
            StageBuff(DexterityUpBuff, 35),
            StageBuff(CriticalUpBuff, 35),
            StageBuff(BrillianceRegenBuff, 60),
        ),
        listOf(
            StageBuff(EvasionRateUpBuff, 80),
            StageBuff(DexterityUpBuff, 40),
            StageBuff(CriticalUpBuff, 40),
            StageBuff(BrillianceRegenBuff, 70),
        ),
        listOf(
            StageBuff(EvasionRateUpBuff, 85),
            StageBuff(DexterityUpBuff, 45),
            StageBuff(CriticalUpBuff, 45),
            StageBuff(BrillianceRegenBuff, 80),
        ),
        listOf(
            StageBuff(EvasionRateUpBuff, 90),
            StageBuff(DexterityUpBuff, 50),
            StageBuff(CriticalUpBuff, 50),
            StageBuff(BrillianceRegenBuff, 90),
        ),
    ),
    StageEffectTarget.All,
)

val MellowFlavor = StageEffect(
    "Mellow Flavor",
    55,
    listOf(
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 20),
            StageBuff(AgilityUpBuff, 20),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 25),
            StageBuff(AgilityUpBuff, 25),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 30),
            StageBuff(AgilityUpBuff, 30),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 40),
            StageBuff(AgilityUpBuff, 35),
            StageBuff(CounterHealBuff, 20),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            StageBuff(CriticalUpBuff, 50),
            StageBuff(AgilityUpBuff, 40),
            StageBuff(CounterHealBuff, 20),
        ),
    ),
    StageEffectTarget.All,
)
