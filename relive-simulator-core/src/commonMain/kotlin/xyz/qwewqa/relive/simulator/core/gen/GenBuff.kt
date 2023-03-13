@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenBuff(
    val base_point: Int,
    val card_abnormal_priority: Int,
    val card_abnormal_type: Int,
    val category: Int,
    val chara_add_color: List<Double>,
    val chara_color: List<Double>,
    val chara_gray_scale: Int,
    val icon_id: Int,
    val is_lock: Int,
    val is_motion_stop: Int,
    val loop: Int,
    val loop_filename: String,
    val max_value: Int,
    val name: Map<String, String>,
    val priority: Int,
    val value_unit: Int,
    val _id_: Int
)

val valuesGenBuff = loadMasterData<GenBuff>(dataGenBuff)
