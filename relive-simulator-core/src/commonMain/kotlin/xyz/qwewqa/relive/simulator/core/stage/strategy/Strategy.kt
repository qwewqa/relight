package xyz.qwewqa.relive.simulator.core.stage.strategy

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.PlayInfo
import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinData
import xyz.qwewqa.relive.simulator.core.stage.modifier.agility
import xyz.qwewqa.relive.simulator.core.stage.team.Team

/**
 * A strategy dictates what queue a team performs each turn.
 * Much of validation is left to the strategy itself, such as whether an act or cutin may be played or not.
 */
interface Strategy {
    /**
     * Called once at the start of the first turn before [nextQueue].
     */
    fun initialize(stage: Stage, team: Team, enemy: Team, playInfo: PlayInfo) {
        initialize(stage, team, enemy)
    }

    fun initialize(stage: Stage, team: Team, enemy: Team) {}

    /**
     * Called once at the end, after play has ended.
     */
    fun finalize(stage: Stage, team: Team, enemy: Team) {}

    /**
     * Called at the start of each turn to get a new queue.
     */
    fun nextQueue(stage: Stage, team: Team, enemy: Team): QueueResult

    /**
     * Called after each act is performed, including cutin acts.
     */
    fun afterAct(stage: Stage, team: Team, enemy: Team) {}

    /**
     * Called at the end of each turn.
     */
    fun endTurn(stage: Stage, team: Team, enemy: Team, teamQueue: QueueResult, enemyQueue: QueueResult) {}

    fun onExit(actor: Actor) {}
    fun onRevive(actor: Actor) {}
}

data class QueueResult(
    /**
     * The list of (up to) 6 tiles which make up this queue.
     */
    val tiles: List<QueueTile>,

    /**
     * Whether to enter climax this turn.
     */
    val climax: Boolean,

    /**
     * The list of cutin skills used this turn.
     */
    val cutins: List<BoundCutin> = emptyList(),
)

sealed class QueueTile {
    abstract val agility: Int
}

object IdleTile : QueueTile() {
    override val agility = 0
}

class ActionTile(val actor: Actor, val apCost: Int, val actData: ActData) : QueueTile() {
    override val agility get() = actor.mod { +agility }

    fun execute() {
        actor.context.log("Act", category = LogCategory.EMPHASIS) { "Begin act [${actData.name}]." }
        if (actData.type == ActType.ClimaxAct) {
            actor.inCXAct = true
            actor.execute(actData.act, apCost)
            actor.inCXAct = false
        } else {
            actor.execute(actData.act, apCost)
        }
        actor.context.log("Act", category = LogCategory.EMPHASIS) { "End act [${actData.name}]." }
    }
}

data class BoundCutin(val actor: Actor, val data: CutinData) {
    val agility get() = actor.mod { +agility }

    fun execute() {
        actor.context.log("Act", category = LogCategory.EMPHASIS) { "Begin cutin act." }
        actor.executeCutin(data.act)
        actor.context.log("Act", category = LogCategory.EMPHASIS) { "End cutin act." }
    }

    override fun toString() = "@(memoir:${actor.memoir?.id})[${actor.name} (${actor.dress.name})]:[${actor.memoir?.name}]"
}

object EmptyStrategy : Strategy {
    override fun nextQueue(stage: Stage, team: Team, enemy: Team) = QueueResult(mutableListOf(), false)
}
