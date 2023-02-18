package xyz.qwewqa.relive.simulator.core.presets.dress.back.star

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4080003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val StNicholasRyoko = dress4080003(
    name = "St. Nicholas Ryoko",
    acts = listOf(
        ActType.Act1.blueprint("Good Deeds") {
            Act {
                targetSelf().act {
                    addBrilliance(20)
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                }
                // TODO: Unremovable SE Seal
                targetBack().act{
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                // TODO: Reduce negative ally SE level
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
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
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("Admonition and Charity") {
            Act {
                // TODO: Change Count. Neg Effects -> Revive
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
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
                // TODO: Reduce negative ally SE level
                /*
                変換[回数マイナス効果→起死回生](%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [2, 2, 2, 2, 2]
                  times1: [0, 0, 0, 0, 0]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1
                キラめき吸収(%value%)
                  target: 後ろから2体の敵役
                  hit_rate4: 100
                  values4: [100, 100, 100, 100, 100]
                  times4: [0, 0, 0, 0, 0]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("Flash of Reversal") {
            Act {
                // TODO: Change Count. Neg Effects -> Revive
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times3,
                    )
                }
                applyEnemyStageEffect(
                    effect = AlluringEyes,
                    turns = 2,
                )
                // TODO: Reduce negative ally SE level
                /*
                変換[回数マイナス効果→起死回生](%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [2, 2, 2, 2, 2]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [131, 137, 143, 150, 157]
                  times2: 1
                AP増加
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("Xmas Prayer") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                // TODO: Change Count. Neg Effects -> Revive
                // TODO: Revive reduction
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
                applyAllyStageEffect(HappyFootsteps, 2)
                // TODO: Reduce negative ally SE level
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                変換[回数マイナス効果→起死回生](%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [0, 0, 0, 0, 0]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [225, 236, 247, 258, 270]
                  times4: 3
                錯乱
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [1, 1, 1, 1, 1]

                field_effects:
                  幸福の足音 (value: 1, time: 2, target: allies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 2),
            TeamReviveBuffPassive.new(50, 1),
            TeamBlessingHPRecoveryPassive.new(value = 100, time = 1),
            /*
            auto skill 1:
              無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
                target: 自身
                hit_rate: 100
                value: 100
                time: 1
              不屈
                target: 自身
                hit_rate: 100
                value: 0
                time: 2
              起死回生(%value%) (回復量は対象の最大HPに依存する)
                target: 味方全体
                hit_rate: 100
                value: 50
                time: 1
              祝福[HP回復](%value%)
                target: 味方全体
                hit_rate: 100
                value: 100
                time: 1
            */
        ),
        listOf(
            SelfLockedNegativeEffectResistanceUpBuffPassive.new(value = 100, time = 2),
            TeamNegativeEffectResistanceUpBuffPassive.new(value = 100, time = 1),
            TeamStunResistanceUpBuffPassive.new(value = 100, time = 2),
            TeamAPDownBuffPassive.new(time = 1),
            /*
            auto skill 2:
              継続マイナス効果耐性アップ(%value%) (解除不可)
                target: 自身
                hit_rate: 100
                value: 100
                time: 2
              継続マイナス効果耐性アップ(%value%)
                target: 味方全体
                hit_rate: 100
                value: 100
                time: 1
              スタン耐性アップ(%value%)
                target: 味方全体
                hit_rate: 100
                value: 100
                time: 2
              AP減少
                target: 味方全体
                hit_rate: 100
                value: 0
                time: 1
            */
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(30),
            DispelTimedBuffPassive(NegativeEffectResistanceUpBuff).new(),
            EnemyLovesicknessBuffPassive.new(time = 1),
            /*
            auto skill 3:
              キラめき減少(%value%)
                target: 敵役全体
                hit_rate: 100
                value: 30
                time: 0
              継続マイナス効果耐性解除
                target: 敵役全体
                hit_rate: 100
                value: 0
                time: 0
              恋わずらい
                target: 敵役全体
                hit_rate: 100
                value: 0
                time: 1
            */
        ),
        listOf(
            TeamActUpScalingPassive120.new(30) + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition),
            SelfActUpScalingPassive120.new(30) + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition),
            /*
            auto skill 4:
              ACTパワーアップ(開幕時味方の舞台上にいる月・宙・雲属性舞台少女1体につき%value%) (最大120％)
                target: 味方の月・宙・雲属性
                values: [30, 30, 30, 30, 30]
              ACTパワーアップ(開幕時味方の舞台上にいる月・宙・雲属性舞台少女1体につき%value%) (最大120％)
                target: 自身
                values: [30, 30, 30, 30, 30]
            */
        ),
    ),
    unitSkill = (ActCritical25UnitSkill + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition)) + SelfActCritical25UnitSkill,
    multipleCA = true,
)
