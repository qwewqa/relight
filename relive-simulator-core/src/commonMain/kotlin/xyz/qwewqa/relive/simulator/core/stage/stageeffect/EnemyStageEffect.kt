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
