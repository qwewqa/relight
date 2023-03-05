@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenGrowthBoard(
    val panel1_id: Int,
    val panel2_id: Int,
    val panel3_id: Int,
    val panel4_id: Int,
    val panel5_id: Int,
    val panel6_id: Int,
    val panel7_id: Int,
    val panel8_id: Int,
    val _id_: Int
)

val valuesGenGrowthBoard = loadMasterData<GenGrowthBoard>(dataGenGrowthBoard)
