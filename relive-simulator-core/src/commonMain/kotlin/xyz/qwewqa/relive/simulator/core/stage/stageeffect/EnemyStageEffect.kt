package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.buff.*

val SelfTrapping = StageEffect(
    "Self Trapping",
    23,
    listOf(
        20,
        25,
        30,
        40,
        50,
    ).map { value ->
        listOf(
            StageBuff(StunBuff, 0),
            StageBuff(NormalDefenseDownBuff, value),
            StageBuff(SpecialDefenseDownBuff, value),
        )
    },
    StageEffectTarget.All,
)

val AlluringEyes = StageEffect(
    "Alluring Eyes",
    45,
    listOf(
        20,
        25,
        30,
        40,
        50,
    ).map { value ->
        listOf(
            StageBuff(LovesicknessBuff, 0),
            StageBuff(NormalDefenseDownBuff, value),
            StageBuff(SpecialDefenseDownBuff, value),
        )
    },
    StageEffectTarget.All,
)

// TODO: Find out how fumbling affects AI with set moves
val DeathsKiss = StageEffect(
    "Death's Kiss",
    25,
    listOf(
        5,
        10,
        15,
        20,
        25,
    ).map { value ->
        listOf(
            StageBuff(NormalDefenseDownBuff, value),
            StageBuff(SpecialDefenseDownBuff, value),
        )
    },
    StageEffectTarget.All,
)

// TODO: Find out how curse affects AI with set moves
val AfterlifeTrials = StageEffect(
    "Afterlife Trials",
    28,
    listOf(
        5,
        10,
        15,
        20,
        25,
    ).map { value ->
        listOf(
            StageBuff(NormalDefenseDownBuff, value),
            StageBuff(SpecialDefenseDownBuff, value),
        )
    },
    StageEffectTarget.All,
)

val DisasterHail = StageEffect(
    "Disaster Hail",
    24,
    listOf(
        3000,
        3500,
        4000,
        4500,
        5000,
    ).map { value ->
        listOf(
            StageBuff(BurnBuff, value),
            StageBuff(ConfusionBuff,0),
            StageBuff(BlindnessBuff,0),
        )
    },
    StageEffectTarget.All,
)

val RoaringFire = StageEffect(
    "Roaring Fire",
    21,
    listOf(
        listOf(
            StageBuff(BurnBuff, 3000),
            StageBuff(BlindnessBuff,0),
            StageBuff(NormalDefenseDownBuff, 20),
            StageBuff(SpecialDefenseDownBuff, 20),
        ),
        listOf(
            StageBuff(BurnBuff, 3500),
            StageBuff(BlindnessBuff,0),
            StageBuff(NormalDefenseDownBuff, 25),
            StageBuff(SpecialDefenseDownBuff, 25),
        ),
        listOf(
            StageBuff(BurnBuff, 4000),
            StageBuff(BlindnessBuff,0),
            StageBuff(NormalDefenseDownBuff, 30),
            StageBuff(SpecialDefenseDownBuff, 30),
        ),
        listOf(
            StageBuff(BurnBuff, 4500),
            StageBuff(BlindnessBuff,0),
            StageBuff(NormalDefenseDownBuff, 40),
            StageBuff(SpecialDefenseDownBuff, 40),
        ),
        listOf(
            StageBuff(BurnBuff, 5000),
            StageBuff(BlindnessBuff,0),
            StageBuff(NormalDefenseDownBuff, 50),
            StageBuff(SpecialDefenseDownBuff, 50),
        ),
    ),
    StageEffectTarget.All,
)

val Thunder = StageEffect(
    "Thunder",
    13,
    listOf(
        20,
        30,
        40,
        50,
        60,
    ).map { value ->
        listOf(
            StageBuff(ElectricShockBuff, 0),
            StageBuff(ActPowerDownBuff, value),
        )
    },
    StageEffectTarget.All,
)

val SunsetTune = StageEffect(
    "Sunset Tune",
    8,
    listOf(
        listOf(
            StageBuff(ActPowerDownBuff, 30),
            StageBuff(NormalDefenseDownBuff, 30),
            StageBuff(SpecialDefenseDownBuff, 30),
        ),
        listOf(
            StageBuff(ActPowerDownBuff, 40),
            StageBuff(NormalDefenseDownBuff, 35),
            StageBuff(SpecialDefenseDownBuff, 35),
        ),
        listOf(
            StageBuff(ActPowerDownBuff, 50),
            StageBuff(NormalDefenseDownBuff, 40),
            StageBuff(SpecialDefenseDownBuff, 40),
        ),
        listOf(
            StageBuff(ActPowerDownBuff, 60),
            StageBuff(NormalDefenseDownBuff, 45),
            StageBuff(SpecialDefenseDownBuff, 45),
        ),
        listOf(
            StageBuff(ActPowerDownBuff, 70),
            StageBuff(NormalDefenseDownBuff, 50),
            StageBuff(SpecialDefenseDownBuff, 50),
        ),
    ),
    StageEffectTarget.All,
)

val Hesitation = StageEffect(
    "Hesitation",
    54,
    listOf(
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(ApUpBuff, 0),
                    StageBuff(NormalDefenseDownBuff, 20),
                    StageBuff(SpecialDefenseDownBuff, 20),
                ),
                listOf(
                    StageBuff(ApUpBuff, 0),
                    StageBuff(NormalDefenseDownBuff, 25),
                    StageBuff(SpecialDefenseDownBuff, 25),
                ),
                listOf(
                    StageBuff(ApUpBuff, 0),
                    StageBuff(NormalDefenseDownBuff, 30),
                    StageBuff(SpecialDefenseDownBuff, 30),
                ),
                listOf(
                    StageBuff(ApUpBuff, 0),
                    StageBuff(NormalDefenseDownBuff, 40),
                    StageBuff(SpecialDefenseDownBuff, 40),
                ),
                listOf(
                    StageBuff(ApUpBuff, 0),
                    StageBuff(NormalDefenseDownBuff, 50),
                    StageBuff(SpecialDefenseDownBuff, 50),
                ),
            ),
        ),
        StageEffectBuffs(
            listOf(
                listOf(
                    StageBuff(Ap2UpBuff, 0),
                ),
                listOf(
                    StageBuff(Ap2UpBuff, 0),
                ),
                listOf(
                    StageBuff(Ap2UpBuff, 0),
                ),
                listOf(
                    StageBuff(Ap2UpBuff, 0),
                ),
                listOf(
                    StageBuff(Ap2UpBuff, 0),
                ),
            ),
            SeishoOnlyCondition,
        ),
    ),
    StageEffectTarget.All,
)

//天体ハイライト
//敵役全体に狭窄、ACTパワーダウン[20, 25, 30, 35, 40]%
val CelestialHighlights = StageEffect(
    "Celestial Highlights",
    55,
    listOf(
        listOf(
            StageBuff(ConstrainBuff, 0),
            StageBuff(ActPowerDownBuff, 20),
        ),
        listOf(
            StageBuff(ConstrainBuff, 0),
            StageBuff(ActPowerDownBuff, 25),
        ),
        listOf(
            StageBuff(ConstrainBuff, 0),
            StageBuff(ActPowerDownBuff, 30),
        ),
        listOf(
            StageBuff(ConstrainBuff, 0),
            StageBuff(ActPowerDownBuff, 35),
        ),
        listOf(
            StageBuff(ConstrainBuff, 0),
            StageBuff(ActPowerDownBuff, 40),
        ),
    ),
    StageEffectTarget.All,
)

val ShadowStupor = StageEffect(
    "Shadow Stupor",
    9,
    listOf(
        listOf(
            StageBuff(AgilityDownBuff, 20),
            StageBuff(ActPowerDownBuff, 20),
            StageBuff(DexterityDownBuff, 20),
        ),
        listOf(
            StageBuff(AgilityDownBuff, 25),
            StageBuff(ActPowerDownBuff, 30),
            StageBuff(DexterityDownBuff, 25),
        ),
        listOf(
            StageBuff(AgilityDownBuff, 30),
            StageBuff(ActPowerDownBuff, 40),
            StageBuff(DexterityDownBuff, 30),
        ),
        listOf(
            StageBuff(AgilityDownBuff, 35),
            StageBuff(ActPowerDownBuff, 50),
            StageBuff(DexterityDownBuff, 35),
        ),
        listOf(
            StageBuff(AgilityDownBuff, 40),
            StageBuff(ActPowerDownBuff, 60),
            StageBuff(DexterityDownBuff, 40),
        ),
    ),
    StageEffectTarget.All,
)
