package xyz.qwewqa.relive.simulator.core.presets.dress.back.sun

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val MarieAntoinetteKoharu = dress5010006(
    name = "Marie Antoinette Koharu",
    acts = listOf(
        ActType.Act1.blueprint("Suppression Slash") {
            Act {
                targetBack().act{
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                }
                // TODO: Unremovable SE Seal
                // TODO: Reduce negative ally SE level
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("Graceful Slash") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack(2).act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyEnemyStageEffect(
                    effect = AlluringEyes,
                    turns = 2,
                )
                /*
               AP減少
                 target: 味方全体
                 hit_rate1: 100
                 values1: [0, 0, 0, 0, 0]
                 times1: [2, 2, 2, 2, 2]
               %attr%属性攻撃(威力%value%)
                 target: 後ろから2体の敵役
                 hit_rate2: 100
                 values2: [131, 137, 143, 150, 157]
                 times2: 1

               field_effects:
                 魅惑の瞳 (value: 1, time: 2, target: enemies)
               */
            }
        },
        ActType.Act3.blueprint("Absorbing Slash") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack(2).act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                // TODO: Absorb kira
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [131, 137, 143, 150, 157]
                  times3: 1
                キラめき吸収(%value%)
                  target: 後ろから2体の敵役
                  hit_rate4: 100
                  values4: [100, 100, 100, 100, 100]
                  times4: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("Rose of Nobility") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.BlessingCountableDebuffReduction,
                        value = values2,
                        count = times2,
                    )
                }
                // TODO: revive reduction
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values4,
                            hitCount = times4,
                        )
                        applyCountableBuff(
                            effect = CountableBuff.Daze,
                            count = times5,
                        )
                    }
                }
                applyAllyStageEffect(DivinePower, 2)
                // TODO: Reduce negative ally SE level
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                祝福[回数マイナス効果減少](%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [1, 1, 1, 1, 1]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [225, 236, 247, 258, 270]
                  times4: [3, 3, 3, 3, 3]
                錯乱
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [1, 1, 1, 1, 1]

                field_effects:
                  神授の力 (value: 1, time: 2, target: allies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 4),
            SelfReviveBuffPassive.new(50, 1),
            SelfExitEvasionBuffPassive.new(time = 3),
            TeamReviveBuffPassive.new(50, 1),
            TeamNegativeCountableEffectResistanceBuffPassive.new(time = 2, value = 100),
            /*
            auto skill 1:
              不屈
                target: 自身
                hit_rate: 100
                value: 0
                time: 4
              起死回生(%value%) (回復量は対象の最大HPに依存する)
                target: 自身
                hit_rate: 100
                value: 50
                time: 1
              退場回避 (発動時に効果解除)
                target: 自身
                hit_rate: 100
                value: 0
                time: 3
              起死回生(%value%) (回復量は対象の最大HPに依存する)
                target: 味方全体
                hit_rate: 100
                value: 50
                time: 1
              回数マイナス効果耐性アップ(%value%)
                target: 味方全体
                hit_rate: 100
                value: 100
                time: 2
            */
        ),
        listOf(
            EnemyPrideBuffPassive.new(value = 3000, time = 1),
            EnemyBrillianceDrainPassive.new(30),
            EnemyAPUpBuffPassive.new(time = 2),

            /*
            auto skill 2:
              慢心(%value%)
                target: 敵役全体
                hit_rate: 100
                value: 3000
                time: 1
              キラめき減少(%value%)
                target: 敵役全体
                hit_rate: 100
                value: 30
                time: 0
              AP増加
                target: 敵役全体
                hit_rate: 100
                value: 0
                time: 2
            */
        ),
        listOf(
            TeamBlessingCountableDebuffReductionPassive.new(value = 2, time = 1),
            TeamBlessingHPRecoveryPassive.new(value = 20, time = 1),
            // TODO: Disaster [Kira Reduction]
            /*
            auto skill 3:
              祝福[回数マイナス効果減少](%value%)
                target: 味方全体
                hit_rate: 100
                value: 2
                time: 1
              祝福[HP回復](%value%)
                target: 味方全体
                hit_rate: 100
                value: 20
                time: 1
              災難[キラめき減少](%value%)
                target: 前から1番目の敵役
                hit_rate: 100
                value: 100
                time: 1
            */
        ),
        listOf(
            TeamActUpScalingPassive120.new(30) + (FlowerOnlyCondition or WindOnlyCondition or SnowOnlyCondition),
            SelfActUpScalingPassive120.new(30) + (FlowerOnlyCondition or WindOnlyCondition or SnowOnlyCondition),
            /*
            auto skill 4:
              ACTパワーアップ(開幕時味方の舞台上にいる花・風・雪属性舞台少女1体につき%value%) (最大120％)
                target: 自身
                values: [30, 30, 30, 30, 30]
              ACTパワーアップ(開幕時味方の舞台上にいる花・風・雪属性舞台少女1体につき%value%) (最大120％)
                target: 味方の花・風・雪属性
                values: [30, 30, 30, 30, 30]
            */
        ),
    ),
    unitSkill = (ActCritical25UnitSkill + (FlowerOnlyCondition or WindOnlyCondition or SnowOnlyCondition)) + SelfActCritical25UnitSkill,
    multipleCA = true,
    categories = setOf(DressCategory.RoV),
)