package xyz.qwewqa.relive.simulator.core.stage.strategy

import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.team.Team


interface Strategy {
    fun initialize(stage: Stage, team: Team, enemy: Team) {}
    fun getQueue(stage: Stage, team: Team, enemy: Team): QueueResult

    fun onExit(actor: Actor) {}
    fun onRevive(actor: Actor) {}
}

data class QueueResult(
    val tiles: List<QueueTile>,
    val climax: Boolean,
)

sealed class QueueTile {
    abstract val agility: Int
    abstract fun execute()
}

object IdleTile : QueueTile() {
    override val agility = 0
    override fun execute() {}
}

class ActionTile(val actor: Actor, val apCost: Int, val actData: ActData) : QueueTile() {
    override val agility get() = actor.agility

    override fun execute() {
        actor.context.log("Act") { "[${actor.name}] executes act [${actData.name}]" }
        if (actData.type == ActType.ClimaxAct) {
            actor.inCXAct = true
            actor.execute(actData.act, apCost)
            actor.inCXAct = false
        } else {
            actor.execute(actData.act, apCost)
        }
    }
}


class EmptyStrategy : Strategy {
    override fun getQueue(stage: Stage, team: Team, enemy: Team) = QueueResult(mutableListOf(), false)
}
