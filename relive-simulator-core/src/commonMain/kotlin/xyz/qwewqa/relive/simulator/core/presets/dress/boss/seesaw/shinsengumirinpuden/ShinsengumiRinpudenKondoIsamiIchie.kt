package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.shinsengumirinpuden

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BlindnessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.PoisonBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val shinsengumiRinpudenKondoIsamiIchieBoss = ActorLoadout(
    "Shinsengumi Rinpuden Kondo Isami Ichie",
    Dress(
        name = "Kondo Isami Ichie",
        character = Character.Ichie,
        attribute = Attribute.Flower,
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
            ActType.Act1("Strong Flash", 2) {
                targetFront().act {
                    attack(
                        modifier = 200,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act2("Noxious Flower", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 115,
                        hitCount = 3,
                    )
                    applyBuff(
                        PoisonBuff,
                        value = 6000,
                        turns = 3,
                    )
                }
            },
            ActType.Act3("Firedance", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 115,
                        hitCount = 3,
                    )
                    applyBuff(
                        BurnBuff,
                        value = 3000,
                        turns = 3,
                    )
                }
            },
            ActType.ClimaxAct("Kotetsu's Roar NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                    applyBuff(
                        BlindnessBuff,
                        turns = 2,
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
