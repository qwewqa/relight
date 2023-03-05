@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenSkillFieldEffect(
    val option1_id: Int,
    val option1_target_type: Int,
    val option1_time: Int,
    val option1_value: Int,
    val option2_id: Int,
    val option2_target_type: Int,
    val option2_time: Int,
    val option2_value: Int,
    val option3_id: Int,
    val option3_target_type: Int,
    val option3_time: Int,
    val option3_value: Int,
    val option4_id: Int,
    val option4_target_type: Int,
    val option4_time: Int,
    val option4_value: Int,
    val option5_id: Int,
    val option5_target_type: Int,
    val option5_time: Int,
    val option5_value: Int,
    val _id_: Int
)

val valuesGenSkillFieldEffect = loadMasterData<GenSkillFieldEffect>(dataGenSkillFieldEffect)
