package xyz.qwewqa.relive.simulator.stage.loadout

import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relive.simulator.stage.actor.ActData
import xyz.qwewqa.relive.simulator.stage.actor.ActType
import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.actor.StatData
import xyz.qwewqa.relive.simulator.stage.passive.PassiveData

data class Dress(
    val name: String,
    val character: Character,
    val attribute: Attribute,
    val damageType: DamageType,
    val position: Position,
    val stats: StatData,
    val acts: Map<ActType, ActData>,
    val autoSkills: List<PassiveData>,
    val unitSkill: List<PassiveData>,
)
