import xyz.qwewqa.relivesim.dsl.stage
import xyz.qwewqa.relivesim.presets.TeamHpDefenseAutoEffect
import xyz.qwewqa.relivesim.stage.character.Character.*
import xyz.qwewqa.relivesim.stage.character.DamageType.*
import xyz.qwewqa.relivesim.stage.percent

fun main() {
    stage {
        player {
            friendLoadout {
                character {
                    name = "Mad Scientist"
                    character = Nana
                    damageType = Normal
                    unitSkill = TeamHpDefenseAutoEffect(20.percent, 10.percent)
                }
            }
        }
        enemy {
            loadout {
                name = "Raid Boss Maya"
                character {
                    name = "Raid Boss"
                    character = Maya
                    damageType = Normal
                    stats {
                        maxHP = 1_000_000
                        actPower = 0
                        normalDefense = 1500
                        specialDefense = 1500
                        agility = 1  // who knows
                    }
                }
            }
        }
    }
}