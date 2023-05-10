@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenStartSkill(
    val description: Map<String, String> = emptyMap(),
    val icon_id: Int,
    val rate: Int,
    val skill_field_effect_id: Int,
    val skill_option1_hit_rate: Int,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val skill_option1_times: List<Int>,
    val skill_option1_values: List<Int>,
    val skill_option2_hit_rate: Int,
    val skill_option2_id: Int,
    val skill_option2_target_id: Int,
    val skill_option2_times: List<Int>,
    val skill_option2_values: List<Int>,
    val skill_option3_hit_rate: Int,
    val skill_option3_id: Int,
    val skill_option3_target_id: Int,
    val skill_option3_times: List<Int>,
    val skill_option3_values: List<Int>,
    val skill_option4_hit_rate: Int,
    val skill_option4_id: Int,
    val skill_option4_target_id: Int,
    val skill_option4_times: List<Int>,
    val skill_option4_values: List<Int>,
    val skill_option5_hit_rate: Int,
    val skill_option5_id: Int,
    val skill_option5_target_id: Int,
    val skill_option5_times: List<Int>,
    val skill_option5_values: List<Int>,
    val _id_: Int
)

val valuesGenStartSkill = loadMasterData<GenStartSkill>(dataGenStartSkill)
