package xyz.qwewqa.relive.simulator.core.stage.actor

data class StatData(
    val hp: Int = 0,
    val actPower: Int = 0,
    val normalDefense: Int = 0,
    val specialDefense: Int = 0,
    val agility: Int = 0,
    val dexterity: Int = 0,
    val critical: Int = 0,
    val accuracy: Int = 0,
    val evasion: Int = 0,
) {
    fun addToActor(actor: Actor) {
        actor.valueMaxHp += hp
        actor.valueActPower += actPower
        actor.valueNormalDefense += normalDefense
        actor.valueSpecialDefense += specialDefense
        actor.valueAgility += agility
        actor.valueDexterity += dexterity
        actor.valueCritical += critical
        actor.valueAccuracy += accuracy
        actor.valueEvasion += evasion
    }

    operator fun plus(other: StatData) = StatData(
        hp + other.hp,
        actPower + other.actPower,
        normalDefense + other.normalDefense,
        specialDefense + other.specialDefense,
        agility + other.agility,
        dexterity + other.dexterity,
        critical + other.critical,
        accuracy + other.accuracy,
        evasion + other.evasion,
    )

    operator fun times(value: Int) = StatData(
        hp * value,
        actPower * value,
        normalDefense * value,
        specialDefense * value,
        agility * value,
        dexterity * value,
        critical * value,
        accuracy * value,
        evasion * value,
    )

    operator fun div(value: Int) = StatData(
        hp / value,
        actPower / value,
        normalDefense / value,
        specialDefense / value,
        agility / value,
        dexterity / value,
        critical / value,
        accuracy / value,
        evasion / value,
    )
}

val defaultDressStats
    get() = StatData(
        dexterity = 5,
        critical = 50,
    )
