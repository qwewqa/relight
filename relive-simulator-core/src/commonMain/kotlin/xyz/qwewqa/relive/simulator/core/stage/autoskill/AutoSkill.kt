package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

interface AutoSkill {
  val iconId: Int?
  val descriptions: Map<String, String>?
  val type: AutoSkillType
  fun execute(context: ActionContext)
}

interface AutoSkillGroup {
  val skills: List<AutoSkill>
}

interface AutoSkillGroupBlueprint {
  fun create(level: Int): AutoSkillGroup
}

interface UnitAutoSkillGroupBlueprint {
  fun create(level: Int): AutoSkillGroup
}

/** Determines the order of passive application. */
enum class AutoSkillType {
  Passive,
  TurnStartA,
  TurnStartB,
  StageEffect,
}
