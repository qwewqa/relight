package xyz.qwewqa.relive.simulator.stage.loadout

import xyz.qwewqa.relive.simulator.stage.actor.Actor
import xyz.qwewqa.relive.simulator.stage.memoir.Memoir

data class ActorLoadout(
    val name: String,
    val dress: Dress,
    val memoir: Memoir? = null,
) {
    fun create() = Actor(name, dress, memoir)
}