package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val DelightKoharu = dress5010007(
    name = "Delight Koharu",
    acts = listOf(
        ActType.Act1.blueprint("輝く斬撃") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 後ろから2体の味方
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
                継続プラス効果解除
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                AP増加
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  雷鳴 (value: 1, time: 2, target: enemies)
                */
                targetAllyBack(2).act {
                    addBrilliance(values1)
                }
                targetBack(2).act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = ApUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetBack(1).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyEnemyStageEffect(Thunder, 2)
            }
        },
        ActType.Act2.blueprint("碧き斬撃") {
            Act {
                /*
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [2, 2, 2, 2, 2]
                必中 (解除不可)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                継続マイナス効果耐性解除
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  拍手喝采（雲） (value: 1, time: 6, target: allies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        effect = NegativeEffectResistanceUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = LockedPerfectAimBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack(2).act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                }
                targetBack(1).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(ApplauseCloud, 6)
            }
        },
        ActType.Act3.blueprint("致命の斬撃") {
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
                AP減少
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetBack(1).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(BloomingFlowers, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Delight ～我が想い～") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率で慢心(5000)を1回付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate4: 100
                  values4: [450, 460, 470, 480, 500]
                  times4: [10, 10, 10, 10, 10]

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                  拍手喝采（雲） (value: 1, time: 6, target: allies)
                */
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        value = values1,
                        count = times1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(10).act {
                    attack(
                        modifier = values4,
                        hitCount = 10,
                    )
                    applyCountableBuff(
                        CountableBuff.Pride,
                        chance = 33,
                    )
                }
                applyAllyStageEffect(BloomingFlowers, 2)
                applyAllyStageEffect(ApplauseCloud, 6)
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

              field_effects:
                昏迷の影 (value: 1, time: 2, target: enemies)
            */
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(value = 50, time = 1),
            TeamBlessingEffectiveDamagePassive.new(value = 50, time = 1),
            EnemyStageEffectPassive(ShadowStupor).new(value = 1, time = 2),
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
              AP減少
                target: 味方全体
                hit_rate: 100
                value: 0
                time: 1

              field_effects:
                美しく、気高く、楽しく (value: 1, time: 2, target: allies)
            */
            TeamDexterityUpBuffPassive.new(value = 20, time = 3),
            TeamCriticalUpPassive.new(value = 20, time = 3),
            TeamAPDownBuffPassive.new(time = 1),
            AllyStageEffectPassive(BeautifulNobleAndFun).new(value = 1, time = 2),
        ),
        listOf(
            /*
            auto skill 3:
              ACTパワーアップ(開幕時味方の舞台上にいる%attr%属性舞台少女1体につき%value%) (最大100％)
                target: 味方の雲属性
                values: [30, 30, 30, 30, 30]
            */
            TeamActUpScalingPassive100.new(30) + CloudOnlyCondition,
        ),
        listOf(
            /*
            auto skill 4:
              継続マイナス効果耐性アップ(%value%)
                target: 自身
                values: [100, 100, 100, 100, 100]
              回数マイナス効果耐性アップ(%value%)
                target: 自身
                values: [100, 100, 100, 100, 100]
            */
            NegativeEffectResistancePassive.new(value = 100),
            NegativeCountableResistancePassive.new(value = 100),
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    multipleCA = true,
    categories = setOf(),
)
