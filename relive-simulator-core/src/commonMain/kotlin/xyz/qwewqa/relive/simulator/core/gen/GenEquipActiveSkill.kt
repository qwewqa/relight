@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenEquipActiveSkill(
    val attribute_id: Int,
    val description: Map<String, String> = emptyMap(),
    val execute_limit_counts: Array<Int>,
    val first_executable_turns: Array<Int>,
    val recast_turns: Array<Int>,
    val skill_cost_values: Array<Int>,
    val skill_execute_timing_id: Int,
    val skill_option1_hit_rate: Int,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val skill_option1_times: Array<Int>,
    val skill_option1_values: Array<Int>,
    val skill_option2_hit_rate: Int,
    val skill_option2_id: Int,
    val skill_option2_target_id: Int,
    val skill_option2_times: Array<Int>,
    val skill_option2_values: Array<Int>,
    val skill_option3_hit_rate: Int,
    val skill_option3_id: Int,
    val skill_option3_target_id: Int,
    val skill_option3_times: Array<Int>,
    val skill_option3_values: Array<Int>,
    val skill_option4_hit_rate: Int,
    val skill_option4_id: Int,
    val skill_option4_target_id: Int,
    val skill_option4_times: Array<Int>,
    val skill_option4_values: Array<Int>,
    val skill_option5_hit_rate: Int,
    val skill_option5_id: Int,
    val skill_option5_target_id: Int,
    val skill_option5_times: Array<Int>,
    val skill_option5_values: Array<Int>,
    val _id_: Int
)

expect val valuesGenEquipActiveSkill: Map<Int, GenEquipActiveSkill>
