package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.shinsengumirinpuden

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

val shinsengumiRinpudenNagakuraShinpachiFumiBoss = ActorLoadout(
    "Shinsengumi Rinpuden Nagakura Shinpachi Fumi",
    Dress(
        name = "Nagakura Shinpachi Fumi",
        character = Character.Fumi,
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
            ActType.Act3("Helpless Slash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 115,
                        hitCount = 3,
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
            ActType.ClimaxAct("Flying Dragon NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                    applyTimedBuff(
                        AccuracyDownBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyTimedBuff(
                        BrillianceGainDownBuff,
                        value = 80,
                        turns = 3,
                    )
                }
            },
        ),
        autoSkills = listOf(
            shinsengumiRinpudenBonusPassive.new(),
            AbnormalResistPassiveA.new(100),
        ),
    ),
)
