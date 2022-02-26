package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.stage.buff.*

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

val TheStageWhereHoshimiJunnaPlaysTheLead = StageEffect(
    "The Stage Where Hoshimi Junna Plays The Lead",
    listOf(
        25,
        35,
        45,
        55,
        65,
    ).map { value ->
        listOf(
            StageBuff(DexterityUpBuff, value),
            StageBuff(CriticalUpBuff, value),
        )
    },
    StageEffectTarget.All,
)