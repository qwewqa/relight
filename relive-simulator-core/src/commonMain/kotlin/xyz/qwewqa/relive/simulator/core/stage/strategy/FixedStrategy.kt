package xyz.qwewqa.relive.simulator.core.stage.strategy

import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.team.Team

class FixedStrategy(val strategy: FixedStrategyContext.() -> Unit) : Strategy {
    override fun nextQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        return FixedStrategyContext(stage, team, enemy).apply(strategy).get()
    }
}

class FixedStrategyContext(val stage: Stage, val team: Team, val enemy: Team) {
    private val queue = mutableListOf<QueueTile>()
    private var climax = false

    val turn get() = stage.turn
    val guest get() = team.guest ?: error("Guest not found.")

    fun climax() {
        climax = true
    }

    operator fun String.unaryMinus() = team.actors[this] ?: error("Stage girl not found.")
    operator fun Actor.get(act: ActType) = BoundAct(this, this.acts[act] ?: error("Act does not exist."))

    fun BoundAct.enqueue() {
        repeat(apCost - 1) { queue.add(IdleTile) }
        queue.add(ActionTile(actor, apCost, actData))
    }

    fun BoundAct.tryEnqueue() {
        if (apCost + queue.size > 6) return
        repeat(apCost - 1) { queue.add(IdleTile) }
        queue.add(ActionTile(actor, apCost, actData))
    }

    operator fun BoundAct.unaryPlus() = enqueue()
    operator fun BoundAct.unaryMinus() = tryEnqueue()

    fun get() = QueueResult(queue.take(6), climax)
}

data class BoundAct(val actor: Actor, val actData: ActData) {
    val act = actData.act
    val apCost: Int
        get() {
            return (actData.apCost + actor.mod { apChange }).coerceAtLeast(1)
        }
}
