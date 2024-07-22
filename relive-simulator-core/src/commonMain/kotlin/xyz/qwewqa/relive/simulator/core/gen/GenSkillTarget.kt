@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenSkillTarget(
    val attack_type: Int,
    val attribute_ids: Array<Int>,
    val chara_ids: Array<Int>,
    val description: Map<String, String>,
    val description_for_field_effect: Map<String, String>,
    val roles: Array<Int>,
    val school_id: Int? = null,
    val school_ids: Array<Int>,
    val skill_target_filter_ids: Array<Int>,
    val _id_: Int
)

expect val valuesGenSkillTarget: Map<Int, GenSkillTarget>
