@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenFieldEffectOption(
    val effect_description: Map<String, String>,
    val effect_name: String,
    val extra_description: Map<String, String>,
    val icon_id: Int,
    val param1: Int,
    val param1_unit: Int,
    val time_unit: Int,
    val type: Int,
    val value_unit: Int,
    val _id_: Int
)

expect val valuesGenFieldEffectOption: Map<Int, GenFieldEffectOption>
