package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060025
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val SagittariusJunna = dress1060025(
    name = "Sagittarius Junna",
    acts = listOf(
        ActType.Act1.blueprint("示しの矢") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果3) (value: 1, time: 1, target: allies)
                */
                targetSelf().act {
                    addBrilliance(values1)
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                    // TODO: Add stage effect seal
                }
                // TODO: Negative stage effect level down
            }
        },
        ActType.Act2.blueprint("止める者") {
            Act {
                /*
                希望
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times1,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyEnemyStageEffect(AlluringEyes, 2)
            }
        },
        ActType.Act3.blueprint("いて座のキラめき") {
            Act {
                /*
                必中
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                キラめき回復(%value%)
                  target: 後ろから3体の味方
                  hit_rate2: 100
                  values2: [20, 30, 40, 50, 60]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1
                キラめき減少(%value%)
                  target: 後ろから3体の敵役
                  hit_rate4: 100
                  values4: [20, 20, 20, 20, 20]
                  times4: [0, 0, 0, 0, 0]
                */
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times1,
                    )
                }
                targetAllyBack(3).act {
                    addBrilliance(values2)
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                targetBack(3).act {
                    addBrilliance(-values4)
                }
            }
        },
        ActType.ClimaxAct.blueprint("賢者の弓") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                回数マイナス効果減少(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [0, 0, 0, 0, 0]
                慢心(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [3000, 3500, 4000, 4500, 5000]
                  times3: [1, 1, 1, 1, 1]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [1, 1, 1, 1, 1]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [200, 210, 220, 230, 240]
                  times5: 3

                field_effects:
                  賢者の契り (value: 1, time: 2, target: allies)
                  天体ハイライト (value: 1, time: 2, target: enemies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果3) (value: 1, time: 1, target: allies)
                */
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = values1,
                    )
                    dispelCountable(BuffCategory.Negative, values2)
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = values3,
                    )
                    dispelCountable(CountableBuff.Revive, values4)
                    attack(
                        modifier = values5,
                        hitCount = times5,
                    )
                }
                applyAllyStageEffect(SagesCovenant, 2)
                applyEnemyStageEffect(CelestialHighlights, 2)
                // TODO: Negative stage effect level down
            }
        }
    ),
    autoSkills = listOf(
        listOf(
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
              祝福[回数マイナス効果減少](%value%)
                target: 味方全体
                hit_rate: 100
                value: 2
                time: 1
              無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
                target: 味方のクイナと珠緒と晶
                hit_rate: 100
                value: 100
                time: 1
            */
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 2),
            TeamReviveBuffPassive.new(time = 1),
            TeamBlessingCountableDebuffReductionPassive.new(value = 2, time = 1),
            TeamInvincibleRebirthBuffPassive.new(time = 1) + (KuinaOnlyCondition or TamaoOnlyCondition or AkiraOnlyCondition),
        ),
        listOf(
            /*
            auto skill 2:
              慢心(%value%)
                target: 敵役全体
                hit_rate: 100
                value: 3000
                time: 1
              起死回生減少(%value%)
                target: 敵役全体
                hit_rate: 100
                value: 1
                time: 0
              キラめき減少(%value%)
                target: 敵役全体
                hit_rate: 100
                value: 30
                time: 0

              field_effects:
                落日の音色 (value: 1, time: 6, target: enemies)
            */
            EnemyPrideBuffPassive.new(value = 3000, time = 1),
            DispelRevivePassive.new(time = 1),
            EnemyBrillianceDrainPassive.new(value = 30),
            EnemyStageEffectPassive(SunsetTune).new(value = 1, time = 6),
        ),
        listOf(
            /*
            auto skill 3:
              回数マイナス効果耐性アップ(%value%)
                target: 自身
                hit_rate: 100
                value: 100
                time: 2
              回数マイナス効果耐性アップ(%value%)
                target: 味方全体
                hit_rate: 100
                value: 100
                time: 1
              AP減少
                target: 味方全体
                hit_rate: 100
                value: 0
                time: 1
              キラめき獲得アップ(%value%)
                target: 味方全体
                hit_rate: 100
                value: 50
                time: 3
            */
            SelfNegativeCountableEffectResistanceBuffPassive.new(value = 100, time = 2),
            TeamNegativeCountableEffectResistanceBuffPassive.new(value = 100, time = 1),
            TeamAPDownBuffPassive.new(time = 1),
            TeamBrillianceGainUpBuffPassive.new(value = 50, time = 3),
        ),
        listOf(
            /*
            auto skill 4:
              ACTパワーアップ(開幕時味方の舞台上にいる%attr%属性舞台少女1体につき%value%) (最大100％)
                target: 味方の雲属性
                values: [30, 30, 30, 30, 30]
            */
            TeamActUpScalingPassive100.new(30) + CloudOnlyCondition,
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    multipleCA = true,
    categories = setOf(),
)
