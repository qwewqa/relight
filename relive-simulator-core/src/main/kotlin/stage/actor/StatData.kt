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
}

val defaultDressStats = StatData(
    dexterity = 5,
    critical = 50,
    accuracy = 100,
)
