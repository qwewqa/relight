package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020026
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val CarmenHikari = dress1020026(
    name = "Carmen Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Charming Tango") {
            Act {
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
                  times2: [2, 2, 2, 2, 2]
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
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate5: 100
                  values5: [165, 173, 181, 189, 198]
                  times5: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceUpBuff,
                        value = values2,
                        turns = 2,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                    // TODO: seal SE
                }
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values5,
                        hitCount = times5,
                    )
                }
                applyEnemyStageEffect(
                    effect = AlluringEyes,
                    turns = 2,
                )
            }
        },
        ActType.Act2.blueprint("La Caña of Sealing") {
            Act {
                /*
                AP減少
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                回数マイナス効果耐性解除
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                カットインスキル封印 (解除不可)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1
                慢心(%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate5: 100
                  values5: [3000, 3500, 4000, 4500, 5000]
                  times5: [1, 1, 1, 1, 1]
                */
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = 2,
                    )
                }
                targetByHighest { it.mod { +actPower } }.act {
                    dispelTimed(NegativeCountableEffectResistanceUpBuff)
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        value = values5,
                        count = times5,
                    )
                }
                // TODO: instant skill seal
            }
        },
        ActType.Act3.blueprint("Solea of Freedom") {
            Act {
                /*
                変換[起死回生→急所](%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [1, 1, 1, 1, 1]
                  times1: [0, 0, 0, 0, 0]
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                カットインスキル封印
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
                // TODO: revive to weak spot, instant skill seal
                targetAoe().act{
                    dispelTimed(NegativeEffectResistanceUpBuff)
                }
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyEnemyStageEffect(
                    effect = SelfTrapping,
                    turns = 2,
                )
            }
        },
        ActType.ClimaxAct.blueprint("Red Passion Flamenco") {
            Act {
                /*
                通常ダメージ超反射 (解除不可)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                特殊ダメージ超反射
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                回数マイナス効果耐性アップ(%value%) (解除不可)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [2, 2, 2, 2, 2]
                カットインスキル封印
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [200, 210, 220, 230, 240]
                  times5: 3

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  遅疑逡巡 (value: 1, time: 2, target: enemies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        effect = LockedNormalSuperReflectBuff,
                        turns = times1,
                    )
                    applyBuff(
                        effect = SpecialSuperReflectBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = LockedNegativeCountableEffectResistanceUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    // TODO: seal instant skill
                }
                targetAoe().act {
                    attack(
                        modifier = values5,
                        hitCount = times5
                    )
                }
                // TODO: stage effect down
                applyEnemyStageEffect(
                    effect = Hesitation,
                    turns = 2,
                )
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
            time: 4
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
        */
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(time = 1),
            ),
        listOf(
        /*
        auto skill 2:
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          回数マイナス効果耐性アップ(%value%) (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 0
        */
            TeamLockedNegativeCountableEffectResistanceUpBuffPassive.new(time = 2, value = 100),
            TeamLockedNegativeEffectResistanceUpBuffPassive.new(time = 2, value = 100),
            TeamBrillianceRecoveryPassive.new(value = 50),
        ),
        listOf(
        /*
        auto skill 3:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 50
            time: 0
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
          回数マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          災難[AP増加]
            target: 敵役全体
            hit_rate: 100
            value: 1
            time: 1

          field_effects:
            遅疑逡巡 (value: 1, time: 2, target: enemies)
            火煙轟々 (value: 1, time: 2, target: enemies)
        */
            EnemyBrillianceDrainPassive.new(value = 50),
            EnemyAPUpBuffPassive.new(time = 1),
            DispelTimedBuffPassive(NegativeCountableEffectResistanceUpBuff).new(),
            // TODO: Disaster (AP Up)
            EnemyStageEffectPassive(Hesitation).new(value = 1, time = 2),
            EnemyStageEffectPassive(RoaringFire).new(value = 1, time = 2),
        ),
        listOf(
        /*
        auto skill 4:
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
            CutinInitialCooldownReductionPassive.new(value = 1)
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
    multipleCA = false,
    categories = setOf(DressCategory.Birthday2023),
)
