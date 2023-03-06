package xyz.qwewqa.relive.simulator.core.stage.target

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

interface SkillTarget : FeatureImplementation {
    val isAffectedByAggro: Boolean
    val description: String
    fun getTargets(context: ActionContext, provokeTarget: Actor?): List<Actor>
}
