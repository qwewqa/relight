@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenSkillTarget(
    val attack_type: Int,
    val attribute_ids: List<Int>,
    val chara_ids: List<Int>,
    val description: Map<String, String>,
    val description_for_field_effect: Map<String, String>,
    val role: Int,
    val school_id: Int,
    val skill_target_filter_ids: List<Int>,
    val _id_: Int
)

val valuesGenSkillTarget = loadMasterData<GenSkillTarget>(dataGenSkillTarget)
