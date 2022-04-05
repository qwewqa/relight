package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.stage.buff.*

val SelfTrapping = StageEffect(
    "Self Trapping",
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

// TODO: Find out how fumbling affects AI with set moves
val DeathsKiss = StageEffect(
    "Death's Kiss",
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

val Thunder = StageEffect(
    "Thunder",
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
