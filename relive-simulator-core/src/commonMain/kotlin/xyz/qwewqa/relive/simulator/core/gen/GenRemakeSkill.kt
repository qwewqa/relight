@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenRemakeSkill(
    val auto_skill_type: Int,
    val description: Map<String, String>,
    val icon_id: Int,
    val _id_: Int
)

val valuesGenRemakeSkill = loadMasterData<GenRemakeSkill>(dataGenRemakeSkill)
