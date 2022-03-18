package xyz.qwewqa.relive.simulator.core.stage.dress

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

data class Dress(
    val id: Int = -1,
    val name: String,
    val character: Character,
    val attribute: Attribute,
    val damageType: DamageType,
    val position: Position,
    val positionValue: Int = 0,
    val stats: StatData,
    val acts: Map<ActType, ActData>,
    val autoSkills: List<PassiveData>,
    val unitSkill: List<PassiveData> = emptyList(),
    val categories: Set<DressCategory> = emptySet(),
    val blueprint: DressBlueprint? = null,
)
