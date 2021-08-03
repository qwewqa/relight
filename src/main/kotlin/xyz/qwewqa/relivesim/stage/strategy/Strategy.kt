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

sealed class QueueTile
object PrepareTile : QueueTile()
class ActionTile(val stageGirl: StageGirl, val actData: ActData) : QueueTile() {
    fun execute() {
        stageGirl.context.stage.log("Act") { "[$stageGirl] executes act [${actData.name}]" }
        if (actData.type == ActType.ClimaxAct) {
            stageGirl.inCXAct = true
            actData.act.action(stageGirl.context)
            stageGirl.inCXAct = false
        } else {
            actData.act.action(stageGirl.context)
        }
    }
}

class EmptyStrategy : Strategy() {
    override fun getQueue(stage: Stage, team: Team, enemy: Team) = QueueResult(mutableListOf<QueueTile>(), false)

    override fun onStageGirlExit(sg: StageGirl) {}
    override fun onStageGirlRevive(sg: StageGirl) {}
}
