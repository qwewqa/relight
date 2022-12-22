package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5030005
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val EvilQueenHisame = dress5030005(
    name = "Evil Queen Hisame",
    acts = listOf(
        ActType.Act1.blueprint("冷酷な眼差し") {
            Act {
                /*
                AP減少
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [170, 180, 190, 200, 210]
                  times3: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyEnemyStageEffect(AlluringEyes, 2)
            }
        },
        ActType.Act2.blueprint("黒魔術") {
            Act {
                /*
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [170, 180, 190, 200, 210]
                  times3: 1

                field_effects:
                  拍手喝采（風） (value: 1, time: 6, target: allies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        NegativeEffectResistanceBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyAllyStageEffect(ApplauseWind, 6)
            }
        },
        ActType.Act3.blueprint("嫉妬と羨望") {
            Act {
                /*
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [30, 30, 30, 30, 30]
                  times1: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [3, 3, 3, 3, 3]
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [170, 180, 190, 200, 210]
                  times4: 1

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                  美しく、気高く、楽しく (value: 1, time: 2, target: allies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        CriticalUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(HyakkaRyoran, 2)
                applyAllyStageEffect(BeautifulNobleAndFun, 2)
            }
        },
        ActType.ClimaxAct.blueprint("giftigen Apfel") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                毒(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [99999, 99999, 99999, 99999, 99999]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率でストップを1ターン付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate3: 100
                  values3: [650, 660, 670, 680, 700]
                  times3: [10, 10, 10, 10, 10]

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                  災禍の呼び声 (value: 1, time: 2, target: enemies)
                */
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        PoisonBuff,
                        turns = times2,
                        value = values2,
                    )
                }
                targetAnyRandom(10).act {
                    attack(
                        modifier = values3,
                        hitCount = 10,
                    )
                    applyBuff(
                        StopBuff,
                        turns = 1,
                        chance = 33,
                    )
                }
                applyAllyStageEffect(HyakkaRyoran, 2)
                applyEnemyStageEffect(DisasterHail, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            /*
            auto skill 1:
              不屈
                target: 自身
                hit_rate: 100
                value: 0
                time: 4
              起死回生(%value%) (回復量は対象の最大HPに依存する)
                target: 味方全体
                hit_rate: 100
                value: 50
                time: 1
              祝福[有利属性ダメージアップ](%value%)
                target: 味方全体
                hit_rate: 100
                value: 50
                time: 1
            */
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(value = 50, time = 1),
            TeamBlessingEffectiveDamagePassive.new(value = 50, time = 1),
        ),
        listOf(
            /*
            auto skill 2:
              クリティカル率アップ(%value%)
                target: 味方全体
                hit_rate: 100
                value: 20
                time: 3
              クリティカル威力アップ(%value%)
                target: 味方全体
                hit_rate: 100
                value: 20
                time: 3
              継続マイナス効果耐性アップ(%value%)
                target: 味方の風属性
                hit_rate: 100
                value: 100
                time: 3
              AP減少2
                target: 味方の風属性
                hit_rate: 100
                value: 0
                time: 1

              field_effects:
                遅疑逡巡 (value: 1, time: 2, target: enemies)
            */
            TeamDexterityUpBuffPassive.new(value = 20, time = 3),
            TeamCriticalUpBuffPassive.new(value = 20, time = 3),
            TeamNegativeEffectResistanceBuffPassive.new(value = 100, time = 3),
            TeamAP2DownBuffPassive.new(time = 1) + WindOnlyCondition,
            EnemyStageEffectPassive(Hesitation).new(value = 1, time = 2),
        ),
        listOf(
            /*
            auto skill 3:
              誓いのレヴュー特攻(%value%)
                target: 自身
                values: [50, 50, 50, 50, 50]
              継続マイナス効果耐性アップ(%value%)
                target: 自身
                values: [100, 100, 100, 100, 100]
            */
            NegativeEffectResistancePassive.new(value = 100),
        ),
        listOf(
            /*
            auto skill 4:
              ACTパワーアップ(%value%) (自身のHPが最大時に発動)
                target: 自身
                values: [100, 100, 100, 100, 100]
              毎ターンHP回復(%value%)
                target: 自身
                values: [20000, 20000, 20000, 20000, 20000]
            */
            StaminaActUpPassive.new(value = 100),
            TurnHPRecoveryPassive.new(value = 20000),
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (WindOnlyCondition or SunOnlyCondition),
    multipleCA = false,
    categories = setOf(DressCategory.Birthday2022),
)
