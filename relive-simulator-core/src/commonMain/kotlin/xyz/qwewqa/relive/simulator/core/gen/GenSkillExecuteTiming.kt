@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable data class GenSkillExecuteTiming(val description: Map<String, String>, val _id_: Int)

expect val valuesGenSkillExecuteTiming: Map<Int, GenSkillExecuteTiming>
