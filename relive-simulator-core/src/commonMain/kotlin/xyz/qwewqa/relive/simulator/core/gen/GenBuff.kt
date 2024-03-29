@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenBuff(
    val base_point: Int,
    val card_abnormal_priority: Int,
    val card_abnormal_type: Int,
    val category: Int,
    val chara_add_color: Array<Double>,
    val chara_color: Array<Double>,
    val chara_gray_scale: Int,
    val icon_id: Int,
    val is_motion_stop: Int,
    val loop: Int,
    val loop_filename: String,
    val max_value: Int,
    val name: Map<String, String>,
    val priority: Int,
    val value_unit: Int,
    val group: Int = 0,
    val group_level: Int,
    val _id_: Int
)

expect val valuesGenBuff: Map<Int, GenBuff>
