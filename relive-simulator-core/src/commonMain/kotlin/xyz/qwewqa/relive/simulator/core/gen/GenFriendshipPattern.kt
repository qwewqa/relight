@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
class FriendshipPanel(
    val effect_arg1: Int,
    val effect_type: Int,
    val res_category: Int,
    val res_item_id: Int,
    val res_parameter: Map<String, Int>,
    val res_quantity: Int,
)

typealias GenFriendshipPattern = List<FriendshipPanel>

val valuesGenFriendshipPattern = loadMasterData<GenFriendshipPattern>(dataGenFriendshipPattern)
