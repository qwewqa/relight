package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.stage.buff.DamageTakenDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.DexterityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NormalDefenseUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SpecialDefenseUpBuff

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
    // TODO() HP Regen Buff
    listOf(
        listOf(
            StageBuff(DexterityUpBuff, 100),
            // StageBuff(HPRegenBuff,15000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            // StageBuff(HPRegenBuff,17000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            // StageBuff(HPRegenBuff,19000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            // StageBuff(HPRegenBuff,22000),
        ),
        listOf(
            StageBuff(DexterityUpBuff, 100),
            // StageBuff(HPRegenBuff,25000),
        ),
    ),
    StageEffectTarget.All,
)