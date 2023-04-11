@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenGuildRaceBoss(
    val enemy_id: Int,
    val episode_id: Int,
    val guild_race_id: Int,
    val hp: Int,
    val icon_id: Int,
    val name: Map<String, String>,
    val number: Int,
    val phase: Int,
    val quest_id: Int,
    val _id_: Int
)

val valuesGenGuildRaceBoss = loadMasterData<GenGuildRaceBoss>(dataGenGuildRaceBoss)
