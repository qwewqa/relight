import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.Attribute.*
import xyz.qwewqa.relivesim.stage.Character.*
import xyz.qwewqa.relivesim.stage.DamageType.*
import xyz.qwewqa.relivesim.stage.Position.Back
import xyz.qwewqa.relivesim.stage.Position.Front

fun main() {
    Stage(
        configuration = StageConfiguration(
            logging = true,
        ),
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
            },
            CharacterData(
                name = "Empress",
                attribute = Cloud,
                character = MeiFan,
                damageType = Special,
                position = Front,
                stats = StatData(
                    actPower = 1593,
                )
            ).createState().apply {
                eventBonus = 120.percent
            },
            CharacterData(
                name = "Santa",
                attribute = Ice,
                character = Mahiru,
                damageType = Normal,
                position = Back,
                stats = StatData(
                    actPower = 1474,
                )
            ).createState().apply {
                eventBonus = 0.percent
            },
            CharacterData(
                name = "Ori",
                attribute = Space,
                damageType = Normal,
                stats = StatData(
                    actPower = 1133,
                )
            ).createState().apply {
                actPower.buff += 0.percent
                eventBonus = 0.percent
            },
        ),
        enemyCharacters = listOf(
            CharacterData(
                name = "Raid Boss",
                attribute = Cloud,
                character = Maya,
                damageType = Normal,
                stats = StatData(
                    normalDefense = 1500,
                    specialDefense = 1500,
                ),
            ).createState(),
            CharacterData(
                name = "Holmes",
                attribute = Flower,
                character = Karen,
                damageType = Normal,
                stats = StatData(
                    normalDefense = 693,
                ),
            ).createState(),
        )
    ).run {
        hit(
            attacker = playerCharacters[2],
            target = enemyCharacters[0],
            modifier = 105.percent,
            hitCount = 1,
        )
        print(logger)
    }
}