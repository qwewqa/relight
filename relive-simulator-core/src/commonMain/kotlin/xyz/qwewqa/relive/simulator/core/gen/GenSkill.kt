@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenSkillOptionInfo(
    val id: Int,
    val hit_rate: Int,
    val target_id: Int,
    val times: List<Int>,
    val values: List<Int>,
)

@Serializable
data class GenSkill(
    val attribute_id: Int,
    val cost: Int,
    val description: Map<String, String> = emptyMap(),
    val icon_id: Int,
    val is_multiple_command_unique_skill: Int,
    val name: Map<String, String>,
    val optional_description: Map<String, String>,
    val sequence_id: Int,
    val skill_field_effect_id: Int,
    val skill_options: List<GenSkillOptionInfo>,
    val _id_: Int
)

expect val valuesGenSkill: Map<Int, GenSkill>
