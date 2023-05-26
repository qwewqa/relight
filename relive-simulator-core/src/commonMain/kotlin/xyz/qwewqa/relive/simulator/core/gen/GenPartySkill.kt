@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenPartySkill(
    val description: Map<String, String> = emptyMap(),
    val icon_id: Int,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val skill_option1_values: List<Int>,
    val skill_option2_id: Int,
    val skill_option2_target_id: Int,
    val skill_option2_values: List<Int>,
    val skill_option3_id: Int,
    val skill_option3_target_id: Int,
    val skill_option3_values: List<Int>,
    val skill_option4_id: Int,
    val skill_option4_target_id: Int,
    val skill_option4_values: List<Int>,
    val skill_option5_id: Int,
    val skill_option5_target_id: Int,
    val skill_option5_values: List<Int>,
    val skill_option_target_id: Int,
    val _id_: Int
)

expect val valuesGenPartySkill: Map<Int, GenPartySkill>
