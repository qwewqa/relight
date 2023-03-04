package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.ConfusionBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val sakuraTaisenStageGirlKarenBoss =
    ActorLoadout(
        "Sakura Taisen Stage Girl Karen",
        Dress(
            name = "Stage Girl Karen",
            character = Character.Karen,
            attribute = Attribute.Wind,
            damageType = DamageType.Special,
            position = Position.None,
            stats =
                defaultDressStats.copy(
                    hp = 358_951_010,
                    actPower = 1500,
                    normalDefense = 1500,
                    specialDefense = 1500,
                    agility = 1,
                ),
            acts =
                actsOf(
                    ActType.Act1("Strong Slash", 2) {
                      targetFront().act {
                        attack(
                            modifier = 200,
                            hitCount = 2,
                        )
                      }
                    },
                    ActType.Act2("Firedance", 2) {
                      targetFront(3).act {
                        applyTimedBuff(
                            BurnBuff,
                            value = 3000,
                            turns = 3,
                        )
                        attack(
                            modifier = 115,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.Act3("Befuddling Slash", 2) {
                      targetFront(3).act {
                        applyTimedBuff(
                            ConfusionBuff,
                            turns = 2,
                            chance = 50,
                        )
                        attack(
                            modifier = 115,
                            hitCount = 3,
                        )
                      }
                    },
                    ActType.ClimaxAct("We will all do Starlight! NEO", 2) {
                      targetAoe().act {
                        applyTimedBuff(
                            ConfusionBuff,
                            turns = 2,
                        )
                        attack(
                            modifier = 150,
                            hitCount = 3,
                        )
                      }
                    },
                ),
            autoSkills =
                listOf(
                    sakuraTaisenBonusPassive.new(),
                    AbnormalResistPassiveA.new(100),
                ),
        ),
    )
