package xyz.qwewqa.relive.simulator.core.stage.memoir

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkill
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkillGroupBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprintContext
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters

data class Memoir(
    val id: Int,
    val name: String,
    val stats: StatData,
    val autoskills: List<AutoSkill>,
    val cutinData: CutinData? = null,
)

data class MemoirBlueprint(
    override val id: Int,
    val name: String,
    val rarity: Int,
    val cost: Int,
    val baseStats: StatData,
    val growthStats: StatData,
    val autoskills: List<AutoSkillGroupBlueprint>,
    val cutinData: CutinBlueprint? = null,
) : FeatureImplementation {
  fun maxLevel(limitBreak: Int) = (rarity + 2) * 10 + limitBreak * 5

  fun create(level: Int, limitBreak: Int): Memoir {
    require(level in 1..maxLevel(limitBreak)) {
      "Invalid level $level for rarity $rarity at limit break $limitBreak."
    }
    return Memoir(
        id,
        name,
        baseStats + growthStats * (level - 1) / 1000,
        when (limitBreak) {
          4 -> autoskills.map { it.create(5) }
          else -> autoskills.map { it.create(1) }
        }.flatMap { it.skills },
        cutinData?.create(limitBreak),
    )
  }
}

data class CutinBlueprint(
    val costs: List<Int>,
    val startCooldowns: List<Int>,
    val cooldowns: List<Int>,
    val usageLimits: List<Int>,
    val parameters: List<ActParameters>,
    val target: CutinTarget = CutinTarget.TurnStart,
    val act: ActBlueprintContext.() -> Act = { Act {} },
) {
  fun create(limitBreak: Int): CutinData? =
      if (limitBreak > 0) {
        CutinData(
            costs[limitBreak],
            startCooldowns[limitBreak],
            cooldowns[limitBreak],
            usageLimits[limitBreak],
            target,
            act(
                ActBlueprintContext(
                    limitBreak + 1,
                    parameters.map {
                      if (limitBreak < it.values.size) it.values[limitBreak] else 0
                    },
                    parameters.map { if (limitBreak < it.times.size) it.times[limitBreak] else 0 },
                    parameters.map { it.hitRate }),
            ),
        )
      } else {
        null
      }
}

data class CutinData(
    val cost: Int,
    val startCooldown: Int,
    val cooldown: Int,
    val usageLimit: Int,
    val target: CutinTarget,
    val act: Act,
)

sealed class CutinTarget {
  object TurnStart : CutinTarget()
  object TurnEnd : CutinTarget()
  data class BeforeAllyAct(val index: Int) : CutinTarget()
  data class BeforeEnemyAct(val index: Int) : CutinTarget()
}
