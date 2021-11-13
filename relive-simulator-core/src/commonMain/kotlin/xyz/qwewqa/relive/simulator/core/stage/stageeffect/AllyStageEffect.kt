package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.stage.buff.DamageTakenDownBuff
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