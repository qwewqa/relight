package xyz.qwewqa.relive.simulator.core.stage.target

import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.TargetSelectionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

interface SkillTarget : FeatureImplementation {
  val isAffectedByAggro: Boolean
  val description: String
  val descriptions: Map<String, String>
  fun getTargets(context: TargetSelectionContext, provokeTarget: Actor?): List<Actor>
}
