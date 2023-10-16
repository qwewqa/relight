@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenEnemy(
    val attack_type: Int,
    val attribute_id: Int,
    val base_rarity: Int,
    val command_skill10_id: Int,
    val command_skill1_id: Int,
    val command_skill2_id: Int,
    val command_skill3_id: Int,
    val command_skill4_id: Int,
    val command_skill5_id: Int,
    val command_skill6_id: Int,
    val command_skill7_id: Int,
    val command_skill8_id: Int,
    val command_skill9_id: Int,
    val command_unique_skill_id: Int,
    val confusion_skill_id: Int,
    val effect_type: Int,
    val is_dress: Int,
    val model_id: Int,
    val model_scale: Int,
    val name: Map<String, String>,
    val personality_id: Int,
    val profile: Map<String, String>,
    val start_active_skill1_id: Int,
    val start_active_skill2_id: Int,
    val start_active_skill3_id: Int,
    val trance_stage_sequence_id: Int,
    val turn_end_skill1_id: Int,
    val turn_end_skill2_id: Int,
    val turn_end_skill3_id: Int
)

val valuesGenEnemy = loadMasterData<GenEnemy>(dataGenEnemy)
