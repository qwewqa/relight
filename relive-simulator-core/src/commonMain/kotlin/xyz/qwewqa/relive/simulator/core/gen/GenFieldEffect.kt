@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenFieldEffect(
    val buff_type1: Int,
    val buff_type1_target_id: Int,
    val buff_type1_value_list: List<Int>,
    val buff_type2: Int,
    val buff_type2_target_id: Int,
    val buff_type2_value_list: List<Int>,
    val buff_type3: Int,
    val buff_type3_target_id: Int,
    val buff_type3_value_list: List<Int>,
    val buff_type4: Int,
    val buff_type4_target_id: Int,
    val buff_type4_value_list: List<Int>,
    val buff_type5: Int,
    val buff_type5_target_id: Int,
    val buff_type5_value_list: List<Int>,
    val description: Map<String, String>,
    val effect_name: String,
    val icon_id: Int,
    val name: Map<String, String>,
    val _id_: Int
)

val valuesGenFieldEffect = loadMasterData<GenFieldEffect>(dataGenFieldEffect)
