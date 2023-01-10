package xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040022
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val CapricornClaudine = dress1040022(
    name = "Capricorn Claudine",
    acts = listOf(
        ActType.Act1.blueprint("希望の斬撃") {
            Act {
                /*
                希望
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                回数マイナス効果耐性アップ(%value%) (解除不可)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times1,
                    )
                    applyBuff(
                        effect = LockedNegativeCountableResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                // TODO: stage effect down

                applyEnemyStageEffect(
                    effect = AlluringEyes,
                    turns = 2,
                )
            }
        },
        ActType.Act2.blueprint("活力の斬撃") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1

                field_effects:
                  黄金の活力 (value: 1, time: 2, target: allies)
                  雷鳴 (value: 1, time: 2, target: enemies)
                */
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(
                    effect = GoldenVitality,
                    turns = 2
                )
                applyEnemyStageEffect(
                    effect = Thunder,
                    turns = 2,
                )
            }
        },
        ActType.Act3.blueprint("煌めく斬撃") {
            Act {
                /*
                AP減少2
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                キラめき回復(%value%)
                  target: 前から2体の味方
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [0, 0, 0, 0, 0]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [1, 1, 1, 1, 1]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  百発百中、一発必中 (value: 1, time: 2, target: allies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        effect = Ap2DownBuff,
                        turns = times1
                    )
                }
                targetAllyFront(2).act {
                    addBrilliance(values2)
                }
                // TODO: remove 1 revive to all enemies

                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }

                // TODO: stage effect down

                applyAllyStageEffect(
                    effect = Bullseye,
                    turns = 2,
                )
            }
        },
        ActType.ClimaxAct.blueprint("牧神パーンの笛") {
            Act {
                /*
                AP減少 (解除不可)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                回数マイナス効果解除
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                錯乱
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [197, 210, 220, 230, 240]
                  times5: 3

                field_effects:
                  黄金の活力 (value: 1, time: 2, target: allies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  凶変 (value: 1, time: 2, target: enemies)
                  天体ハイライト (value: 1, time: 2, target: enemies)
                */
                targetAllyAoe().act {
                    applyBuff(
                        effect = LockedApDownBuff,
                        turns = times1
                    )
                    dispelTimed(BuffCategory.Negative)
                    dispelCountable(BuffCategory.Negative)
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Daze,
                        count = times4,
                    )
                    attack(
                        modifier = values5,
                        hitCount = times5
                    )
                }
                applyAllyStageEffect(
                    effect = GoldenVitality,
                    turns = 2
                )
                // TODO: stage effect down
                applyEnemyStageEffect(
                    effect = Catastrophe,
                    turns = 2
                )
                applyEnemyStageEffect(
                    effect = CelestialHighlights,
                    turns = 2
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
            time: 2
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          祝福[AP減少2]
            target: 味方全体
            hit_rate: 100
            value: 1
            time: 1
          無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
            target: 味方の氷雨とひかりとつかさ
            hit_rate: 100
            value: 100
            time: 1
        */
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 2),
            TeamReviveBuffPassive.new(time = 1),
            TeamBlessingAp2DownPassive.new(time = 1),
            TeamInvincibleRebirthBuffPassive.new(time = 1) + (HisameOnlyCondition or HikariOnlyCondition or TsukasaOnlyCondition),
        ),
        listOf(
            /*
        auto skill 2:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 50
            time: 0
          ACTパワーアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          回数マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          災難[キラめき減少](%value%)
            target: 敵役全体
            hit_rate: 100
            value: 50
            time: 1

          field_effects:
            甘き堕落 (value: 1, time: 2, target: enemies)
        */
            BrillianceRecoveryPassive.new(value = 50),
            TeamActPowerUpBuffPassive.new(value = 20, time = 3),
            DispelTimedBuffPassive(NegativeCountableEffectResistanceBuff).new(),
            // TODO: kiradown disaster
            EnemyStageEffectPassive(SugaryCorruption).new(value = 1, time = 2),
        ),
        listOf(
            /*
        auto skill 3:
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 2
          AP減少2
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
          キラめき獲得アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 3

          field_effects:
            電光影裏 (value: 1, time: 6, target: allies)
        */
            SelfLockedNegativeEffectResistanceBuffPassive.new(value = 100, time = 2),
            SelfAP2DownBuffPassive.new(time = 1),
            TeamBrillianceGainUpBuffPassive.new(value = 50, time = 3),
            AllyStageEffectPassive(LightningShade).new(value = 1, time = 6),
        ),
        listOf(
            /*
         auto skill 4:
           カットインスキル発動準備ターン短縮(%value%)
             target: 自身
             values: [1, 1, 1, 1, 1]
         */
            CutinInitialCooldownReductionPassive.new(1)
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(),
)
