@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenMusic(
    val awaken_extra_skill_id: Int,
    val awaken_skill1_id: Int,
    val awaken_skill2_id: Int,
    val awaken_skill3_id: Int,
    val awaken_skill4_id: Int,
    val chara_ids: Array<Int>,
    val description: Map<String, String>,
    val disc_color: String,
    val event_id: Int,
    val gain1_category: Int,
    val gain1_item_id: Int,
    val gain1_quantity: Int,
    val jacket_color: String,
    val name: Map<String, String>,
    val published_at: Int,
    val school_ids: Array<Int>,
    val theme_color: String,
    val title_color: String,
    val _id_: Int
)

expect val valuesGenMusic: Map<Int, GenMusic>
