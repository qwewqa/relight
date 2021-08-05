package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.percent

data class StatData(
    val hp: Int = 0,
    val actPower: Int = 0,
    val normalDefense: Int = 0,
    val specialDefense: Int = 0,
    val agility: Int = 0,
    val dexterity: Percent = 0.percent,
    val critical: Percent = 0.percent,
    val accuracy: Percent = 0.percent,
    val evasion: Percent = 0.percent,
) {
    fun applyToStageGirl(sg: StageGirl) {
        sg.maxHp.value = hp
        sg.actPower.value = actPower
        sg.normalDefense.value = normalDefense
        sg.specialDefense.value = specialDefense
        sg.agility.value = agility
        sg.dexterity.value = dexterity
        sg.critical.value = critical
        sg.accuracy.value = accuracy
        sg.evasion.value = evasion
    }
    
    fun addToStageGirl(sg: StageGirl) {
        sg.maxHp.value += hp
        sg.actPower.value += actPower
        sg.normalDefense.value += normalDefense
        sg.specialDefense.value += specialDefense
        sg.agility.value += agility
        sg.dexterity.value += dexterity
        sg.critical.value += critical
        sg.accuracy.value += accuracy
        sg.evasion.value += evasion
    }
}