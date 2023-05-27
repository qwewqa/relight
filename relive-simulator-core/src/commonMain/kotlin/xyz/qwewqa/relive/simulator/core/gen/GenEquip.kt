@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenEquip(
    val active_skill_id: Int,
    val appearance_chara_ids: Array<Int>,
    val auto_skill1_id: Int,
    val auto_skill1_type: Int,
    val base_atk: Int,
    val base_hp: Int,
    val base_mdef: Int,
    val base_pdef: Int,
    val can_use_limitbreak_item: Int,
    val cost: Int,
    val delta_atk: Int,
    val delta_hp: Int,
    val delta_mdef: Int,
    val delta_pdef: Int,
    val has_alternative_image: Int,
    val material_exp: Int,
    val name: Map<String, String>,
    val profile: Map<String, String>,
    val published_at: Int,
    val rarity: Int,
    val type: Int,
    val _id_: Int
)

expect val valuesGenEquip: Map<Int, GenEquip>
