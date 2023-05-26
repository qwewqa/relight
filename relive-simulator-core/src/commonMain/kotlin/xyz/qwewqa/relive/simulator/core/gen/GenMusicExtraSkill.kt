@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenMusicExtraSkill(
    val description: Map<String, String>,
    val name: Map<String, String>,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val _id_: Int
)

expect val valuesGenMusicExtraSkill: Map<Int, GenMusicExtraSkill>
