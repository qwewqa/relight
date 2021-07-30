import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.Attribute.*
import xyz.qwewqa.relivesim.stage.Character.*
import xyz.qwewqa.relivesim.stage.DamageType.*
import xyz.qwewqa.relivesim.stage.Position.Front

fun main() {
    Stage(
        playerCharacters = listOf(
            CharacterData(
                name = "Strength",
                attribute = Wind,
                character = Futaba,
                damageType = Normal,
                position = Front,
                stats = StatData(
                    maxHP = 57905,
                    actPower = 1704,
                    normalDefense = 3055,
                    specialDefense = 2032,
                    agility = 1307,
                )
            ).createState().apply {
                eventBonus = 120.percent
            }
        ),
        enemyCharacters = listOf(
            CharacterData(
                name = "Raid Boss",
                attribute = Cloud,
                character = Maya,
                damageType = Normal,
                stats = StatData(
                    normalDefense = 1500
                )
            ).createState()
        )
    ).run {
        println(damageCalculator.calculate(
            attacker = playerCharacters[0],
            target = enemyCharacters[0],
            modifier = 198.percent,
            hitCount = 2,
        ).possibleRolls())
    }
}