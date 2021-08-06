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
        sg.maxHp.base = hp
        sg.actPower.base = actPower
        sg.normalDefense.base = normalDefense
        sg.specialDefense.base = specialDefense
        sg.agility.base = agility
        sg.dexterity.base = dexterity
        sg.critical.base = critical
        sg.accuracy.base = accuracy
        sg.evasion.base = evasion
    }
    
    fun addToStageGirl(sg: StageGirl) {
        sg.maxHp.base += hp
        sg.actPower.base += actPower
        sg.normalDefense.base += normalDefense
        sg.specialDefense.base += specialDefense
        sg.agility.base += agility
        sg.dexterity.base += dexterity
        sg.critical.base += critical
        sg.accuracy.base += accuracy
        sg.evasion.base += evasion
    }
}