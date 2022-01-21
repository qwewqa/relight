package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val sakuraTaisenStageGirlMahiruBoss = ActorLoadout(
    "Sakura Taisen Stage Girl Mahiru",
    Dress(
        name = "Stage Girl Mahiru",
        character = Character.Mahiru,
        attribute = Attribute.Snow,
        damageType = DamageType.Special,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 358_951_010,
            actPower = 1500,
            normalDefense = 1500,
            specialDefense = 1500,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Inspiring Slash", 2) {
                targetSelf().act {
                    applyBuff(
                        ActPowerUpBuff,
                        value = 30,
                        turns = 3,
                    )
                }
                targetFront(3).act {
                    attack(
                        modifier = 115,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act2("Violent Slash", 2) {
                targetSelf().act {
                    applyBuff(
                        DexterityUpBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyBuff(
                        CriticalUpBuff,
                        value = 30,
                        turns = 3,
                    )
                }
                targetFront(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act3("Accuracy Slash", 2) {
                targetSelf().act {
                    applyBuff(
                        PerfectAimBuff,
                        turns = 1,
                    )
                }
                targetFront(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.ClimaxAct("I was the one...who was always by your side NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                    applyBuff(
                        EvasionRateUpBuff,
                        value = 50,
                        turns = 2,
                    )
                    applyBuff(
                        NormalBarrierBuff,
                        value = 7500,
                        turns = 3,
                    )
                }
            },
        ),
        autoSkills = listOf(
            sakuraTaisenBonusPassive.new(),
            AbnormalResistPassiveA.new(100),
        ),
    ),
)
