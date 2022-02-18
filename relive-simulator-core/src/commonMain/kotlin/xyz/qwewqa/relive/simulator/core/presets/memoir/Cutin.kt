package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.presets.memoir.generated.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.core.presets.condition.characterCondition
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint
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

val StarOfTheDayFutabaKaoruko = equip4000215(
    name = "[Star of the day] Futaba & Kaoruko",
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
                    effect = CriticalUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val AimToUnifyTheWorld = equip4000211(
    name = "Aim to Unify the World!",
    baseAutoskills = listOf(
        SelfTurnBrillianceRecoveryPassive.new(10)
    ),
    maxAutoskills = listOf(
        SelfTurnBrillianceRecoveryPassive.new(20)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyAoe().act {
                applyBuff(
                    effect = BrillianceRegenBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val ForTheShinsengumi = equip4000204(
    name = "For the Shinsengumi!",
    baseAutoskills = listOf(
        DamageTakenDownPassive.new(10)
    ),
    maxAutoskills = listOf(
        DamageTakenDownPassive.new(15)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyFront(5).act {
                applyBuff(
                    effect = SpecialDefenseUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val ShinsengumiRinpuden = equip4000203(
    name = "Shinsengumi Rinpuden",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinTarget = CutinTarget.BeforeEnemyAct(3),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyBuff(
                    effect = SleepBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val StarOfTheDayMaHiKaren = equip4000212(
    name = "[Star of the day] Karen & Hikari & Mahiru",
    baseAutoskills = listOf(), // TODO: Agility or something
    maxAutoskills = listOf(),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
        }
    },
)

private fun brilliantBirthday(character: Character, memoFun: PartialMemoirBlueprint): MemoirBlueprint {
    val condition = characterCondition(character)
    return memoFun(
        name = "Brilliant Birthday " + character.displayName,
        baseAutoskills = listOf(
            SelfTurnBrillianceRecoveryPassive.new(20) + condition,
            DexterityPassive.new(10) + condition,
        ),
        maxAutoskills  = listOf(
            SelfTurnBrillianceRecoveryPassive.new(25) + condition,
            DexterityPassive.new(15) + condition,
        ),
        cutinTarget = CutinTarget.TurnStart,
        cutinAct = {
            Act {
                targetAllyAoe().act {
                    applyBuff(ActPowerUpBuff, values1, times1)
                    applyBuff(DexterityUpBuff, values2, times2)
                }
                targetAllyAoe(condition).act {
                    applyBuff(ActPowerUpBuff, values3, times3)
                    applyBuff(DexterityUpBuff, values4, times4)
                }
            }
        }
    )
}

val brilliantBirthdays = listOf(
    brilliantBirthday(Character.Hikari, equip4000220),
    brilliantBirthday(Character.Tsukasa, equip4000223),
    brilliantBirthday(Character.Fumi, equip4000230),
    brilliantBirthday(Character.Michiru, equip4000230), // TODO: use equip4000239
)

private fun slapMemo(
    name: String,
    attribute: Attribute,
    memoFun: PartialMemoirBlueprint
) = memoFun(
    name = name,
    baseAutoskills = listOf(DexterityPassive.new(14)),
    maxAutoskills = listOf(DexterityPassive.new(20)),
    cutinTarget = CutinTarget.BeforeEnemyAct(1),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                attack(values1, attribute = attribute)
            }
        }
    }
)

val slapMemos = listOf(
    slapMemo("Revue, Start!", Attribute.Dream, equip4000150),
    slapMemo("Menacing Tower", Attribute.Snow, equip4000152),
    slapMemo("To the Stage!", Attribute.Space, equip4000157),
    slapMemo("Revue of High Priestess and Devil", Attribute.Moon, equip4000172),
    slapMemo("Revue of Wisdom and Attachment", Attribute.Wind, equip4000171),
    slapMemo("Peach Oath", Attribute.Flower, equip4000177),
    slapMemo("V Hierophant [Reverse]", Attribute.Moon, equip4000179),
    slapMemo("Enchanting Spicy Curry", Attribute.Moon, equip4000187),
    slapMemo("XIX Sun [Reverse]", Attribute.Cloud, equip4000191),
    slapMemo("Revue of Hierophant and Chariot", Attribute.Cloud, equip4000193),
    slapMemo("Revue of Hermit and Justice", Attribute.Flower, equip4000227),
)
