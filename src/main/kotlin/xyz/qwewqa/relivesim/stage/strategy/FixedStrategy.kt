package xyz.qwewqa.relivesim.stage.strategy

import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.act.ActData
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.team.Team

class FixedStrategy(val strategy: FixedStrategyContext.() -> Unit) : Strategy {
    override fun getQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        return FixedStrategyContext(stage, team, enemy).apply(strategy).get()
    }

    override fun onStageGirlExit(sg: StageGirl) {}

    override fun onStageGirlRevive(sg: StageGirl) {}
}

class FixedStrategyContext(val stage: Stage, val team: Team, val enemy: Team) {
    private val queue = mutableListOf<QueueTile>()
    private var climax = false

    val turn get() = stage.turn
    val friend get() = team.friend ?: error("Friend not found.")

    fun climax() {
        climax = true
    }

    operator fun String.unaryMinus() = team.stageGirls[this] ?: error("Stage girl not found.")
    operator fun StageGirl.get(act: ActType) = BoundAct(this, this.acts[act] ?: error("Act does not exist."))

    fun BoundAct.enqueue() {
        repeat(apCost - 1) { queue.add(IdleTile) }
        queue.add(ActionTile(stageGirl, apCost, actData))
    }

    operator fun BoundAct.unaryPlus() = enqueue()

    fun get() = QueueResult(queue, climax)
}

data class BoundAct(val stageGirl: StageGirl, val actData: ActData) {
    val act = actData.act
    val apCost: Int
        get() {
            var cost = actData.apCost
            if (stageGirl.apUpCounter > 0) cost += 1
            if (stageGirl.apDownCounter > 0) cost -= 1
            return cost.coerceAtLeast(1)
        }
}
