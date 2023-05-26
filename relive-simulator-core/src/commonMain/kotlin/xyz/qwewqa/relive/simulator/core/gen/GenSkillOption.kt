@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenSkillOption(
    val effect_description: Map<String, String>,
    val extra_description: Map<String, String>,
    val icon_id: Int,
    val param1: Int,
    val skill_option_filter_id: Int,
    val skill_option_filter_id2: Int,
    val time_override: Int,
    val time_unit: Int,
    val type: Int,
    val value_override: Int,
    val value_unit: Int,
    val _id_: Int
)

expect val valuesGenSkillOption: Map<Int, GenSkillOption>
