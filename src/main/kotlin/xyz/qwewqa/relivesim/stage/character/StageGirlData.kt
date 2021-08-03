package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.act.ActData
import xyz.qwewqa.relivesim.stage.effect.AutoEffect
import xyz.qwewqa.relivesim.stage.effect.BlankAutoEffect

data class StageGirlData(
    val name: String = "",
    val attribute: Attribute = Attribute.NeutralAttribute,
    val character: Character = Character.OtherCharacter,
    val damageType: DamageType = DamageType.NeutralDamage,
    val position: Position = Position.NoPosition,
    val stats: StatData = StatData(),
    val positionValue: Int = 0,
    val normalActs: List<ActData> = emptyList(),
    val climaxAct: ActData? = null,
    val autoSkills: List<AutoEffect> = emptyList(),
    val unitSkill: AutoEffect = BlankAutoEffect,
    val effectivenessTable: AttributeEffectivenessTable = standardAttributeEffectivenessTables.getValue(attribute),
) {
    val displayName get() = "$name ${character.name}"

    fun applyToStageGirl(sg: StageGirl) {
        stats.applyToStageGirl(sg)
        normalActs.forEach { sg.acts[it.type] = it }
        climaxAct?.let { sg.acts[it.type] = it }
    }
}
