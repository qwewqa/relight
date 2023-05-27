@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenAccessory(
    val attribute_id: Int,
    val auto_skill1_id: Int,
    val auto_skill1_release_limitbreak: Int,
    val auto_skill1_type: Int,
    val auto_skill2_id: Int,
    val auto_skill2_release_limitbreak: Int,
    val auto_skill2_type: Int,
    val auto_skill3_id: Int,
    val auto_skill3_release_limitbreak: Int,
    val auto_skill3_type: Int,
    val auto_skill4_id: Int,
    val auto_skill4_release_limitbreak: Int,
    val auto_skill4_type: Int,
    val auto_skill5_id: Int,
    val auto_skill5_release_limitbreak: Int,
    val auto_skill5_type: Int,
    val base_agi: Int,
    val base_atk: Int,
    val base_cri: Int,
    val base_dex: Int,
    val base_hp: Int,
    val base_mdef: Int,
    val base_pdef: Int,
    val dress_ids: Array<Int>,
    val grow_id: Int,
    val icon_id: Int,
    val max_agi: Int,
    val max_atk: Int,
    val max_cri: Int,
    val max_dex: Int,
    val max_hp: Int,
    val max_mdef: Int,
    val max_pdef: Int,
    val name: Map<String, String>,
    val sell_price: Int,
    val skill_id: Int,
    val skill_slot: Int,
    val _id_: Int
)

expect val valuesGenAccessory: Map<Int, GenAccessory>
