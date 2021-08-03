package xyz.qwewqa.relivesim.stage.strategy

import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.act.Act
import xyz.qwewqa.relivesim.stage.act.ActData
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.log
import xyz.qwewqa.relivesim.stage.team.Team

abstract class Strategy {
    abstract fun getQueue(stage: Stage, team: Team, enemy: Team): QueueResult

    abstract fun onStageGirlExit(sg: StageGirl)
    abstract fun onStageGirlRevive(sg: StageGirl)
}

data class QueueResult(
    val tiles: List<QueueTile>,
    val climax: Boolean,
)

sealed class QueueTile {
    abstract val agility: Int
    abstract fun execute()
}

object PrepareTile : QueueTile() {
    override val agility = 0
    override fun execute() {}
}

class ActionTile(val stageGirl: StageGirl, val apCost: Int, val actData: ActData) : QueueTile() {
    override val agility get() = stageGirl.agility.get()

    override fun execute() {
        stageGirl.context.stage.log("Act") { "[$stageGirl] executes act [${actData.name}]" }
        if (actData.type == ActType.ClimaxAct) {
            stageGirl.inCXAct = true
            stageGirl.execute(actData.act, apCost)
            stageGirl.inCXAct = false
        } else {
            stageGirl.execute(actData.act, apCost)
        }
    }
}

class EmptyStrategy : Strategy() {
    override fun getQueue(stage: Stage, team: Team, enemy: Team) = QueueResult(mutableListOf<QueueTile>(), false)

    override fun onStageGirlExit(sg: StageGirl) {}
    override fun onStageGirlRevive(sg: StageGirl) {}
}
