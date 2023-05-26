@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenGrowthPanel(
    val coin: Int,
    val growth_item1_id: Int,
    val growth_item1_quantity: Int,
    val growth_item2_id: Int,
    val growth_item2_quantity: Int,
    val growth_item3_id: Int,
    val growth_item3_quantity: Int,
    val growth_item4_id: Int,
    val growth_item4_quantity: Int,
    val growth_item5_id: Int,
    val growth_item5_quantity: Int,
    val growth_item6_id: Int,
    val growth_item6_quantity: Int,
    val label: Map<String, String>,
    val type: Int,
    val value: Int,
    val _id_: Int
)

expect val valuesGenGrowthPanel: Map<Int, GenGrowthPanel>
