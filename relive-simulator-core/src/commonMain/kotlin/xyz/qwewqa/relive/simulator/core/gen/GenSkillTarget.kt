@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenSkillTarget(
    val description: Map<String, String>,
    val description_for_field_effect: Map<String, String>,
    val skill_target_filter_ids: List<Int>,
    val _id_: Int
)

val valuesGenSkillTarget = loadMasterData<GenSkillTarget>(dataGenSkillTarget)
