@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenMusicExtraSkill(
    val description: Map<String, String>,
    val name: Map<String, String>,
    val skill_option1_id: Int,
    val skill_option1_target_id: Int,
    val _id_: Int
)

expect val valuesGenMusicExtraSkillBase: Map<Int, GenMusicExtraSkill>

private var _valuesGenMusicExtraSkill: Map<Int, GenMusicExtraSkill>? = null
val valuesGenMusicExtraSkill: Map<Int, GenMusicExtraSkill>
  get() {
    return _valuesGenMusicExtraSkill
        ?: valuesGenMusicExtraSkillBase
            .mapValues { (k, v) ->
              when (k) {
                4000221 ->
                    v.copy(
                        name = v.name + ("en" to "Siegfeld Rear Position Critical Up"),
                    )
                else -> v
              }
            }
            .also { _valuesGenMusicExtraSkill = it }
  }
