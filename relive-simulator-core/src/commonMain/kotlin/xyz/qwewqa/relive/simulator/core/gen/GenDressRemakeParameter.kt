@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class DressRemakeParameter(
    val hp: Int,
    val atk: Int,
    val pdef: Int,
    val mdef: Int,
    val agi: Int,
)

typealias GenDressRemakeParameter = List<DressRemakeParameter>

val valuesGenDressRemakeParameter = loadMasterData<GenDressRemakeParameter>(dataGenDressRemakeParameter)
