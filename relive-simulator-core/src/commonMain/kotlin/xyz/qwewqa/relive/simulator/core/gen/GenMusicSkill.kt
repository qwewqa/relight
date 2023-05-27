@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenMusicSkill(
    val description: Map<String, String>,
    val name: Map<String, String>,
    val published_at: Int,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val skill_option1_value: Int,
    val skill_option1_values: Array<Int>,
    val _id_: Int
)

expect val valuesGenMusicSkill: Map<Int, GenMusicSkill>
