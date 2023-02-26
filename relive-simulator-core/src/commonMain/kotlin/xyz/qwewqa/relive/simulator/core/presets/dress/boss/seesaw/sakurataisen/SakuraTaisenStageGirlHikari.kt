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

val sakuraTaisenStageGirlHikariBoss = ActorLoadout(
    "Sakura Taisen Stage Girl Hikari",
    Dress(
        name = "Stage Girl Hikari",
        character = Character.Hikari,
        attribute = Attribute.Space,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 358_951_010,
            actPower = 1500,
            normalDefense = 1500,
            specialDefense = 1500,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Strong Slash", 2) {
                targetFront().act {
                    attack(
                        modifier = 200,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act2("Weakening Slash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 115,
                        hitCount = 3,
                    )
                    applyTimedBuff(
                        ActPowerDownBuff,
                        value = 30,
                        turns = 3,
                    )
                }
            },
            ActType.Act3("Softening Slash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 115,
                        hitCount = 3,
                    )
                    applyTimedBuff(
                        NormalDefenseDownBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyTimedBuff(
                        SpecialDefenseDownBuff,
                        value = 30,
                        turns = 3,
                    )
                }
            },
            ActType.ClimaxAct("All of this...is for the sake of \"Starlight\"! NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                    applyTimedBuff(
                        ActPowerDownBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyTimedBuff(
                        DexterityDownBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyTimedBuff(
                        CriticalDownBuff,
                        value = 30,
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
