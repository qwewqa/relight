package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.DexterityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.EffectiveDamageDealtUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.FreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.MarkBuff
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinData
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.passive.BrillianceRecoveryPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.DexterityPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.EffectiveDamageDealtPassive

val UnshakableFeelings = Memoir(
    name = "Unshakable Feelings",
    stats = StatData(
        hp = 2999,
        actPower = 299,
        normalDefense = 499,
        specialDefense = 499,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(32)
    ),
    cutinData = CutinData(
        cooldownStart = 1,
        cooldown = 2,
        usageLimit = 2,
        target = CutinTarget.BeforeAllyAct(1),
        act = {
            targetAllyByLowest { it.hp }.act {
                heal(fixed = 25000)
            }
        }
    )
)

val UnburnedFlowerUnwitheredFlame = Memoir(
    name = "Unburned Flower, Unwithered Flame",
    stats = StatData(
        hp = 4000,
        actPower = 350,
        normalDefense = 600,
        specialDefense = 600,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinData = CutinData(
        cooldownStart = 2,
        cooldown = 2,
        usageLimit = 2,
        target = CutinTarget.BeforeEnemyAct(1),
        act = {
            targetByLowest { it.EnemyTurnOrder }.act {
                applyBuff(
                    effect = FreezeBuff,
                    turns = 2,
                    chance = 100,
                )
            }
        }
    )
)

val XIIHangedManReverse = Memoir(
    name = "XII Hanged Man [Reverse]",
    stats = StatData(
        actPower = 500,
    ),
    autoskills = listOf(
        EffectiveDamageDealtPassive.new(30)
    ),
    cutinData = CutinData(
        cooldownStart = 1,
        cooldown = 2,
        usageLimit = 2,
        target = CutinTarget.StartOfTurn(),
        act = {
            targetAllyFront(5).act {
                applyBuff(
                    effect = EffectiveDamageDealtUpBuff,
                    value = 50,
                    turns = 2,
                )
            }
        }
    )
)

val XIIHangedManReverseLv65 = Memoir(
    name = "XII Hanged Man [Reverse] 1ub Lv65",
    stats = StatData(
        actPower = 425,
    ),
    autoskills = listOf(
        EffectiveDamageDealtPassive.new(20)
    ),
    cutinData = CutinData(
        cooldownStart = 2,
        cooldown = 3,
        usageLimit = 1,
        target = CutinTarget.StartOfTurn(),
        act = {
            targetAllyFront(5).act {
                applyBuff(
                    effect = EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 1,
                )
            }
        }
    )
)

val VILoversReverse = Memoir(
    name = "VI Lovers [Reverse]",
    stats = StatData(
        actPower = 500,
    ),
    autoskills = listOf(
        DexterityPassive.new(20)
    ),
    cutinData = CutinData(
        cooldownStart = 1,
        cooldown = 2,
        usageLimit = 2,
        target = CutinTarget.StartOfTurn(),
        act = {
            targetAllyFront(5).act {
                applyBuff(
                    effect = DexterityUpBuff,
                    value = 30,
                    turns = 2,
                )
            }
        }
    )
)

val VILoversReverseLv65 = Memoir(
    name = "VI Lovers [Reverse] 1ub Lv65",
    stats = StatData(
        actPower = 425,
    ),
    autoskills = listOf(
        DexterityPassive.new(14)
    ),
    cutinData = CutinData(
        cooldownStart = 2,
        cooldown = 3,
        usageLimit = 1,
        target = CutinTarget.StartOfTurn(),
        act = {
            targetAllyFront(5).act {
                applyBuff(
                    effect = DexterityUpBuff,
                    value = 15,
                    turns = 1,
                )
            }
        }
    )
)

val XVITowerUpright = Memoir(
    name = "XVI Tower [Upright]",
    stats = StatData(
        hp = 4000,
        actPower = 350,
        normalDefense = 600,
        specialDefense = 600,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinData = CutinData(
        cooldownStart = 1,
        cooldown = 2,
        usageLimit = 2,
        target = CutinTarget.StartOfTurn(),
        act = {
            targetBack(1).act {
                applyBuff(
                    effect = MarkBuff,
                    turns = 3,
                )
            }
        }
    )
)

val XVITowerUprightLv65 = Memoir(
    name = "XVI Tower [Upright] 1ub Lv65",
    stats = StatData(
        hp = 3325,
        actPower = 305,
        normalDefense = 555,
        specialDefense = 555,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    cutinData = CutinData(
        cooldownStart = 2,
        cooldown = 3,
        usageLimit = 1,
        target = CutinTarget.StartOfTurn(),
        act = {
            targetBack(1).act {
                applyBuff(
                    effect = MarkBuff,
                    turns = 2,
                )
            }
        }
    )
)