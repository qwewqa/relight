package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.presets.memoir.generated.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinData
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val UnshakableFeelings = equip4000147(
    name = "Unshakable Feelings",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32)
    ),
    cutinTarget = CutinTarget.BeforeAllyAct(1),
    cutinAct = {
        Act {
            targetAllyByLowest { it.hp }.act {
                heal(fixed = values1)
            }
        }
    },
)

val UnburnedFlowerUnwitheredFlame = equip4000153(
    name = "Unburned Flower, Unwithered Flame",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinTarget = CutinTarget.BeforeEnemyAct(1),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyBuff(
                    effect = FreezeBuff,
                    turns = times1,
                    chance = 100,
                )
            }
        }
    },
)

val XIIHangedManReverse = equip4000163(
    name = "XII Hanged Man [Reverse]",
    baseAutoskills = listOf(
        EffectiveDamageDealtPassive.new(20)
    ),
    maxAutoskills = listOf(
        EffectiveDamageDealtPassive.new(30)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyFront(5).act {
                applyBuff(
                    effect = EffectiveDamageDealtUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val VILoversReverse = equip4000161(
    name = "VI Lovers [Reverse]",
    baseAutoskills = listOf(
        DexterityPassive.new(14)
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(20)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyFront(5).act {
                applyBuff(
                    effect = DexterityUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val XVITowerUpright = equip4000173(
    name = "XVI Tower [Upright]",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetBack(1).act {
                applyBuff(
                    effect = MarkBuff,
                    turns = times1,
                )
            }
        }
    },
)

val XVITowerReverse = equip4000174(
    name = "XVI Tower [Reverse]",
    baseAutoskills = listOf(
        DamageDealtPassive.new(10)
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(15)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyFront(5).act {
                applyBuff(
                    effect = DamageDealtUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val CleaningTogether = equip4000182(
    name = "Cleaning Together",
    baseAutoskills = listOf(
        DexterityPassive.new(14)
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(20)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyBack(5).act {
                applyBuff(
                    effect = DexterityUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val RareCoStar = equip4000183(
    name = "Rare Co-star",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfNormalDefenseUpBuffPassive.new(5, time = 1),
        SelfSpecialDefenseUpBuffPassive.new(5, time = 1),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfNormalDefenseUpBuffPassive.new(10, time = 2),
        SelfSpecialDefenseUpBuffPassive.new(10, time = 2),
    ),
    cutinTarget = CutinTarget.BeforeEnemyAct(2),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyBuff(
                    ActPowerDownBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)