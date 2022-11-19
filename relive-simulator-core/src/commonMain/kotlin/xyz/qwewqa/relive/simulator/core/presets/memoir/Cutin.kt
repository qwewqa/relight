package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.presets.condition.KaorukoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.characterCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.schoolCondition
import xyz.qwewqa.relive.simulator.core.presets.memoir.generated.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.School

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

val ForOurSpecialPlace = equip4000149(
    name = "For Our Special Place",
    baseAutoskills = listOf(
        DamageDealtPassive.new(5),
        DexterityPassive.new(11),
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(8),
        DexterityPassive.new(16),
    ),
    cutinTarget = CutinTarget.BeforeAllyAct(1),
    cutinAct = {
        Act {
            targetAllyAoe().act {
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
    brilliantBirthday(Character.Michiru, equip4000239),
    brilliantBirthday(Character.Kaoruko, equip4000246),
    brilliantBirthday(Character.Ichie, equip4000252),
    brilliantBirthday(Character.Yuyuko, equip4000275),
    brilliantBirthday(Character.Lalafin, equip4000253),
    brilliantBirthday(Character.Shiori, equip4000280),
    brilliantBirthday(Character.Aruru, equip4000274),
    brilliantBirthday(Character.Futaba, equip4000260),
    brilliantBirthday(Character.Mahiru, equip4000264),
    brilliantBirthday(Character.Koharu, equip4000247),
    brilliantBirthday(Character.Nana, equip4000285),
    brilliantBirthday(Character.Maya, equip4000289),
    brilliantBirthday(Character.Claudine, equip4000290),
    brilliantBirthday(Character.Shizuha, equip4000293),
    brilliantBirthday(Character.Suzu, equip4000296),
    brilliantBirthday(Character.MeiFan, equip4000303),
    brilliantBirthday(Character.Karen, equip4000315),
    brilliantBirthday(Character.Junna, equip4000316),
    brilliantBirthday(Character.Misora, equip4000317),
    brilliantBirthday(Character.Yachiyo, equip4000318),
    brilliantBirthday(Character.Rui, equip4000319),
)

private fun slapMemo(
    name: String,
    attribute: Attribute,
    memoFun: PartialMemoirBlueprint,
    baseAutoskills: List<PassiveData> = listOf(DexterityPassive.new(14)),
    maxAutoskills: List<PassiveData> = listOf(DexterityPassive.new(20)),
) = memoFun(
    name = name,
    baseAutoskills = baseAutoskills,
    maxAutoskills = maxAutoskills,
    cutinTarget = CutinTarget.BeforeEnemyAct(1),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                attack(values1, attribute = attribute)
            }
        }
    },
    additionalTags = listOf(EffectTag.Slap),
)

val slapMemos = listOf(
    slapMemo("Revue, Start!", Attribute.Dream, equip4000150,
             listOf(BrillianceRecoveryPassive.new(28)),
             listOf(BrillianceRecoveryPassive.new(40))),
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
    slapMemo("Revue of Emperor, Fool, and Empress", Attribute.Space, equip4000266),
    slapMemo("Revue of Death and Hanged Man", Attribute.Wind, equip4000278),
    slapMemo("Revue of Wheel of Fortune and Moon", Attribute.Dream, equip4000278),
    slapMemo("Revue of Moon, Judgement, Faith, Hope, and Charity", Attribute.Snow, equip4000255)
)

val XXJudgementUpright = equip4000188(
    name = "XX Judgement [Upright]",
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
    cutinTarget = CutinTarget.BeforeEnemyAct(1),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyBuff(
                    effect = StopBuff,
                    turns = times1,
                )
            }
        }
    },
)

val IIPriestessReverse = equip4000207(
    name = "II High Priestess [Reverse]",
    baseAutoskills = listOf(
        DexterityPassive.new(14)
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(20)
    ),
    cutinTarget = CutinTarget.BeforeAllyAct(1),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyBuff(
                    effect = ActPowerUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

private fun positionZero(
    leader: String,
    school: School,
    memoFun: PartialMemoirBlueprint,
    baseAutoskills: List<PassiveData> = listOf(TeamBrillianceRecoveryPassive.new(10) + schoolCondition(school)),
    maxAutoskills: List<PassiveData> = listOf(TeamBrillianceRecoveryPassive.new(15) + schoolCondition(school)),
) = memoFun(
    name = "Aiming for Position Zero - $leader",
    baseAutoskills = baseAutoskills,
    maxAutoskills = maxAutoskills,
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyAoe(schoolCondition(school)).act {
                // TODO: Count. cleanse
                applyBuff(
                    effect = DexterityUpBuff,
                    value = values2,
                    turns = times2,
                )
            }
        }
    },
    additionalTags = listOf(EffectTag.PositionZero),
)

val positionZeros = listOf(
    positionZero("Karen", School.Seisho, equip4000269),
    positionZero("Tamao", School.Rinmeikan, equip4000270),
    positionZero("Aruru", School.Frontier, equip4000271),
    positionZero("Akira", School.Siegfeld, equip4000272),
    positionZero("Koharu", School.Seiran, equip4000273),
)

val XXIVCharityUpright = equip4000169(
    name = "XXIV Charity [Upright]",
    baseAutoskills = listOf(
        SelfTurnBrillianceRecoveryPassive.new(10),
        AgilityPassive.new(10)
    ),
    maxAutoskills = listOf(
        SelfTurnBrillianceRecoveryPassive.new(20),
        AgilityPassive.new(12)
    ),
    cutinTarget = CutinTarget.BeforeEnemyAct(1),
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

val XIStrengthUpright = equip4000175(
    name = "XI Strength [Upright]",
    baseAutoskills = listOf(
        DamageDealtPassive.new(10)
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(15)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyBack(3).act {
                applyBuff(ActPowerUpBuff, values1, times1)
            }
            targetAllyAoe(KaorukoOnlyCondition).act {
                applyBuff(ActPowerUpBuff, values2, times2)
            }
        }
    },
)

val XXIIIHopeUpright = equip4000224(
    name = "XXIII Hope [Upright]",
    baseAutoskills = listOf(
        SelfHopeBuffPassive.new(value = 50, time = 1)
    ),
    maxAutoskills = listOf(
        SelfHopeBuffPassive.new(value = 50, time = 2)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyBack(3).act {
                applyCountableBuff(
                    effect = CountableBuff.Hope,
                    count = times1,
                )
            }
        }
    },
)

val XXJudgementReverse = equip4000189(
    name = "XX Judgement [Reverse]",
    baseAutoskills = listOf(
        DamageTakenDownPassive.new(10)
    ),
    maxAutoskills = listOf(
        DamageTakenDownPassive.new(15)
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyFront(3).act {
                heal(fixed = values1)
            }
        }
    },
)

val XXIWorldUpright = equip4000258(
    name = "XXI World [Upright]",
    baseAutoskills = listOf(
        TeamHpRegenBuffPassive.new(5000, 2)
    ),
    maxAutoskills = listOf(
        TeamHpRegenBuffPassive.new(7500, 3)
    ),
    cutinTarget = CutinTarget.TurnEnd,
    cutinAct = {
        Act {
            targetAllyAoe().act {
                applyBuff(
                    effect = ApDownBuff,
                    turns = times1,
                )
            }
        }
    },
)

val XXIWorldReverse = equip4000259(
    name = "XXI World [Reverse]",
    baseAutoskills = listOf(
        TeamHpRegenBuffPassive.new(5000, 2)
    ),
    maxAutoskills = listOf(
        TeamHpRegenBuffPassive.new(7500, 3)
    ),
    cutinTarget = CutinTarget.TurnEnd,
    cutinAct = {
        Act {
            targetAoe().act {
                applyBuff(
                    effect = ApUpBuff,
                    turns = times1,
                )
            }
        }
    },
)

val Carmen = equip4000276(
    name = "Carmen",
    baseAutoskills = listOf(
        SelfTurnBrillianceRecoveryPassive.new(10)
    ),
    maxAutoskills = listOf(
        SelfTurnBrillianceRecoveryPassive.new(20)
    ),
    cutinTarget = CutinTarget.TurnEnd,
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

val WatchingMoviesAtTheater = equip4000279(
    name = "Watching Movies at the Theater",
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
                applyCountableBuff(
                    effect = CountableBuff.Pride,
                    count = times1,
                )
            }
        }
    },
)

val SurroundedByNature = equip4000281(
    name = "Surrounded By Nature",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinTarget = CutinTarget.BeforeEnemyAct(2),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyCountableBuff(
                    effect = CountableBuff.Pride,
                    count = times1,
                )
            }
        }
    },
)

val NostalgicRyoko = equip4000286(
    name = "Nostalgic Ryoko",
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
                applyCountableBuff(
                    effect = CountableBuff.Daze,
                    count = times1,
                )
            }
        }
    },
)

val RevueOfFateAndTruth = equip4000287(
    name = "Revue of Fate and Truth",
    baseAutoskills = listOf(
        DexterityPassive.new(11),
        EffectiveDamageDealtPassive.new(8),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(16),
        EffectiveDamageDealtPassive.new(12),
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyFront(5).act {
                applyBuff(
                    effect = CriticalUpBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val TwoRevues = equip4000284(
    name = "2 Revues",
    baseAutoskills = listOf(
        DexterityPassive.new(11),
        CriticalUpPassive.new(21),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(16),
        CriticalUpPassive.new(30),
    ),
    cutinTarget = CutinTarget.BeforeAllyAct(3),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                //TODO() Cleanse count. times1
            }
        }
    },
)

val YachiyosFashionTips = equip4000292(
    name = "Yachiyo's Fashion Tips",
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
                applyCountableBuff(
                    effect = CountableBuff.Daze,
                    count = times1,
                )
            }
        }
    },
)

val MatchingCardigan = equip4000291(
    name = "Matching Cardigan",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinTarget = CutinTarget.BeforeAllyAct(3),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyBuff(
                    effect = NegativeEffectResistanceBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val FestivalKaren = equip4000294(
    name = "[On the Night of the Festival] Aijo Karen",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
    cutinTarget = CutinTarget.BeforeEnemyAct(2),
    cutinAct = {
        Act {
            targetCutinTarget().act {
                applyBuff(
                    effect = AgonyBuff,
                    value = values1,
                    turns = times1,
                )
            }
        }
    },
)

val MyOwnStage = equip4000297(
    name = "My Own Stage",
    baseAutoskills = listOf(
        DexterityPassive.new(14),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(20),
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

val RipeTomato = equip4000298(
    name = "Ripe Tomato",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8, 6),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12, 6),
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

val JesterontheStageoftheGods = equip4000300(
    name = "Jester on the Stage of the Gods",
    baseAutoskills = listOf(
        DexterityPassive.new(14),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(20),
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

val SingDanceandBattle = equip4000299(
    name = "Sing, Dance, and Battle",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8, 6),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12, 6),
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyFront(5).act {
                applyCountableBuff(
                    effect = CountableBuff.Hope,
                    count = times1,
                )
            }
        }
    },
)

val The101stSeishoFestivalRally = equip4000326(
    name = "The 101st Seisho Festival Rally",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8, 6),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12, 6),
    ),
    cutinTarget = CutinTarget.TurnStart,
    cutinAct = {
        Act {
            targetAllyBack(5).act {
                applyBuff(
                    effect = ActPowerUpBuff,
                    value = values1,
                    turns = times1,
                )
                applyBuff(
                    effect = DexterityUpBuff,
                    value = values2,
                    turns = times2,
                )
            }
        }
    },
)
