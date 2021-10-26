package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.DexterityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.EffectiveDamageDealtUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.FreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.MarkBuff
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinData
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.BrillianceRecoveryPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.DexterityPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.EffectiveDamageDealtPassive

val UnshakableFeelings = MemoirBlueprint(
    name = "Unshakable Feelings",
    rarity = 4,
    baseStats = StatData(
        hp = 300,
        actPower = 30,
        normalDefense = 50,
        specialDefense = 50,
    ),
    growthStats = StatData(
        hp = 34177,
        actPower = 3417,
        normalDefense = 5696,
        specialDefense = 5696,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32)
    ),
    cutinData = listOf(
        null,
        CutinData(
            cost = 4,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.BeforeAllyAct(1),
            act = {
                targetAllyByLowest { it.hp }.act {
                    heal(fixed = 10000)
                }
            }
        ),
        CutinData(
            cost = 4,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.BeforeAllyAct(1),
            act = {
                targetAllyByLowest { it.hp }.act {
                    heal(fixed = 15000)
                }
            }
        ),
        CutinData(
            cost = 4,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.BeforeAllyAct(1),
            act = {
                targetAllyByLowest { it.hp }.act {
                    heal(fixed = 20000)
                }
            }
        ),
        CutinData(
            cost = 3,
            cooldownStart = 1,
            cooldown = 2,
            usageLimit = 2,
            target = CutinTarget.BeforeAllyAct(1),
            act = {
                targetAllyByLowest { it.hp }.act {
                    heal(fixed = 25000)
                }
            }
        ),
    )
)

val UnburnedFlowerUnwitheredFlame = MemoirBlueprint(
    name = "Unburned Flower, Unwithered Flame",
    rarity = 4,
    baseStats = StatData(
        hp = 445,
        actPower = 113,
        normalDefense = 363,
        specialDefense = 363,
    ),
    growthStats = StatData(
        hp = 45000,
        actPower = 3000,
        normalDefense = 3000,
        specialDefense = 3000,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinData = listOf(
        null,
        CutinData(
            cost = 4,
            cooldownStart = 3,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.BeforeEnemyAct(1),
            act = {
                targetCutinTarget().act {
                    applyBuff(
                        effect = FreezeBuff,
                        turns = 1,
                        chance = 100,
                    )
                }
            }
        ),
        CutinData(
            cost = 4,
            cooldownStart = 3,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.BeforeEnemyAct(1),
            act = {
                targetCutinTarget().act {
                    applyBuff(
                        effect = FreezeBuff,
                        turns = 1,
                        chance = 100,
                    )
                }
            }
        ),
        CutinData(
            cost = 4,
            cooldownStart = 3,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.BeforeEnemyAct(1),
            act = {
                targetCutinTarget().act {
                    applyBuff(
                        effect = FreezeBuff,
                        turns = 1,
                        chance = 100,
                    )
                }
            }
        ),
        CutinData(
            cost = 3,
            cooldownStart = 2,
            cooldown = 2,
            usageLimit = 2,
            target = CutinTarget.BeforeEnemyAct(1),
            act = {
                targetCutinTarget().act {
                    applyBuff(
                        effect = FreezeBuff,
                        turns = 2,
                        chance = 100,
                    )
                }
            }
        ),
    )
)

val XIIHangedManReverse = MemoirBlueprint(
    name = "XII Hanged Man [Reverse]",
    rarity = 4,
    baseStats = StatData(
        actPower = 105,
    ),
    growthStats = StatData(
        actPower = 5000,
    ),
    baseAutoskills = listOf(
        EffectiveDamageDealtPassive.new(20)
    ),
    maxAutoskills = listOf(
        EffectiveDamageDealtPassive.new(30)
    ),
    cutinData = listOf(
        null,
        CutinData(
            cost = 3,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = 30,
                        turns = 1,
                    )
                }
            }
        ),
        CutinData(
            cost = 3,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = 35,
                        turns = 1,
                    )
                }
            }
        ),
        CutinData(
            cost = 3,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = 40,
                        turns = 1,
                    )
                }
            }
        ),
        CutinData(
            cost = 2,
            cooldownStart = 1,
            cooldown = 2,
            usageLimit = 2,
            target = CutinTarget.TurnStart,
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
)

val VILoversReverse = MemoirBlueprint(
    name = "VI Lovers [Reverse]",
    rarity = 4,
    baseStats = StatData(
        actPower = 105,
    ),
    growthStats = StatData(
        actPower = 5000,
    ),
    baseAutoskills = listOf(
        DexterityPassive.new(14)
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(20)
    ),
    cutinData = listOf(
        null,
        CutinData(
            cost = 3,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = 15,
                        turns = 1,
                    )
                }
            }
        ),
        CutinData(
            cost = 3,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = 20,
                        turns = 1,
                    )
                }
            }
        ),
        CutinData(
            cost = 3,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = 25,
                        turns = 1,
                    )
                }
            }
        ),
        CutinData(
            cost = 2,
            cooldownStart = 1,
            cooldown = 2,
            usageLimit = 2,
            target = CutinTarget.TurnStart,
            act = {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = 30,
                        turns = 2,
                    )
                }
            }
        ),
    )
)

val XVITowerUpright = MemoirBlueprint(
    name = "XVI Tower [Upright]",
    rarity = 4,
    baseStats = StatData(
        hp = 445,
        actPower = 113,
        normalDefense = 363,
        specialDefense = 363,
    ),
    growthStats = StatData(
        hp = 45000,
        actPower = 3000,
        normalDefense = 3000,
        specialDefense = 3000,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinData = listOf(
        null,
        CutinData(
            cost = 2,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetBack(1).act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = 2,
                    )
                }
            }
        ),
        CutinData(
            cost = 2,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetBack(1).act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = 2,
                    )
                }
            }
        ),
        CutinData(
            cost = 2,
            cooldownStart = 2,
            cooldown = 3,
            usageLimit = 1,
            target = CutinTarget.TurnStart,
            act = {
                targetBack(1).act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = 2,
                    )
                }
            }
        ),
        CutinData(
            cost = 1,
            cooldownStart = 1,
            cooldown = 2,
            usageLimit = 2,
            target = CutinTarget.TurnStart,
            act = {
                targetBack(1).act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = 3,
                    )
                }
            }
        ),
    )
)
