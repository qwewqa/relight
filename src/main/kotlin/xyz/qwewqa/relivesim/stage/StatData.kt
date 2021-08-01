package xyz.qwewqa.relivesim.stage

data class StatData(
    val maxHP: Int = 1,
    val actPower: Int = 0,
    val normalDefense: Int = 0,
    val specialDefense: Int = 0,
    val agility: Int = 0,
    val dexterity: Percent = 5.percent,
    val critical: Percent = 50.percent,
    val accuracy: Percent = 100.percent,
    val evasion: Percent = 0.percent,
) {
    fun applyToCharacterState(state: CharacterState) {
        state.maxHp.value = maxHP
        state.actPower.value = actPower
        state.normalDefense.value = normalDefense
        state.specialDefense.value = specialDefense
        state.agility.value = agility
        state.dexterity.value = dexterity
        state.critical.value = critical
        state.accuracy.value = accuracy
        state.evasion.value = evasion
    }
    
    fun addToCharacterState(state: CharacterState) {
        state.maxHp.value += maxHP
        state.actPower.value += actPower
        state.normalDefense.value += normalDefense
        state.specialDefense.value += specialDefense
        state.agility.value += agility
        state.dexterity.value += dexterity
        state.critical.value += critical
        state.accuracy.value += accuracy
        state.evasion.value += evasion
    }
}