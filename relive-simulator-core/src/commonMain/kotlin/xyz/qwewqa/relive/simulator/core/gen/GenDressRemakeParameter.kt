@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

typealias ListGenDressRemakeParameter = List<DressRemakeParameter>

@Serializable
data class DressRemakeParameter(
    val hp: Int,
    val atk: Int,
    val pdef: Int,
    val mdef: Int,
    val agi: Int,
)

expect val valuesGenDressRemakeParameter: Map<Int, List<DressRemakeParameter>>
