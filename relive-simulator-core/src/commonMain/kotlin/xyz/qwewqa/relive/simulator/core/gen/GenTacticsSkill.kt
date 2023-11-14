@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenTacticsSkill(
    val icon_id: Int,
    val rate: Int,
    val skill_option1_hit_rate: Int,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val skill_option1_time: Int,
    val skill_option1_value: Int,
    val skill_option2_hit_rate: Int,
    val skill_option2_id: Int,
    val skill_option2_target_id: Int,
    val skill_option2_time: Int,
    val skill_option2_value: Int,
    val skill_option3_hit_rate: Int,
    val skill_option3_id: Int,
    val skill_option3_target_id: Int,
    val skill_option3_time: Int,
    val skill_option3_value: Int,
    val skill_option4_hit_rate: Int,
    val skill_option4_id: Int,
    val skill_option4_target_id: Int,
    val skill_option4_time: Int,
    val skill_option4_value: Int,
    val skill_option5_hit_rate: Int,
    val skill_option5_id: Int,
    val skill_option5_target_id: Int,
    val skill_option5_time: Int,
    val skill_option5_value: Int,
    val _id_: Int
)

val valuesGenTacticsSkill = loadMasterData<GenTacticsSkill>(dataGenTacticsSkill)
