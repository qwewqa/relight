package xyz.qwewqa.relive.simulator.core.skilloption

import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.common.DescriptionUnit

interface SkillOption : FeatureImplementation {
  val description: String
  val extraDescription: String
  val iconId: Int
  val params: List<Int>
  val timeOverride: Int?
  val timeUnit: DescriptionUnit
  val valueOverride: Int?
  val valueUnit: DescriptionUnit
  val type: Int?
}

interface ActiveSkillOption : SkillOption {
  fun actActive(context: TargetContext, value: Int, time: Int, chance: Int, params: List<Int>)
}

interface PassiveSkillOption : SkillOption {
  fun actPassive(context: TargetContext, value: Int, params: List<Int>)
}

interface DualSkillOption : ActiveSkillOption, PassiveSkillOption
