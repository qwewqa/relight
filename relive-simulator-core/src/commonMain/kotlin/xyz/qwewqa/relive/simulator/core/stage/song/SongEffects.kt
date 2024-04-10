package xyz.qwewqa.relive.simulator.core.stage.song

import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenMusicExtraSkill
import xyz.qwewqa.relive.simulator.core.gen.valuesGenMusicSkill
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.common.DescriptionUnit
import xyz.qwewqa.relive.simulator.core.stage.skilloption.ReversiblePassiveSkillOption
import xyz.qwewqa.relive.simulator.core.stage.skilloption.SkillOptions
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

open class CommonSongEffect(
    override val id: Int,
    val skillOption: ReversiblePassiveSkillOption,
    val target: SkillTarget,
    override val defaultValue: Int?,
) : SongEffect {
  override val iconId = skillOption.iconId
  override val names =
      skillOption.descriptions.mapValues { (_, v) ->
        Regex(" *\\(%value%\\)").replace(v, "")
      } // Names aren't reliably translated

  override fun start(context: ActionContext, value: Int) =
      context.run {
        if (self in target.getTargets(context, null)) {
          skillOption.executeForward(TargetContext(context, listOf(self)), value)
        }
      }

  override fun end(context: ActionContext, value: Int) =
      context.run {
        if (self in target.getTargets(context, null)) {
          skillOption.executeReverse(TargetContext(context, listOf(self)), value)
        }
      }
}

class ExtraSongEffect(
    id: Int,
    skillOption: ReversiblePassiveSkillOption,
    target: SkillTarget,
    defaultValue: Int?,
) : CommonSongEffect(id, skillOption, target, defaultValue) {

  override val names =
      skillOption.descriptions.mapValues { (_, v) ->
        val effectName = Regex(" *\\(%value%\\)").replace(v, "")
        if (skillOption.valueUnit == DescriptionUnit.Percent && skillOption in showPercentSkills) {
          "$effectName %"
        } else {
          effectName
        }
      }

  companion object {
    private val showPercentSkills =
        setOf(
            SkillOptions.NormalDefenseUp,
            SkillOptions.SpecialDefenseUp,
        )
  }
}

class AwakeningSongEffect(
    id: Int,
    val shortNames: Map<String, String>,
    skillOption: ReversiblePassiveSkillOption,
    target: SkillTarget,
    defaultValue: Int?,
    val values: Array<Int>,
) : CommonSongEffect(id, skillOption, target, defaultValue) {
  override val names =
      skillOption.descriptions.mapValues { (k, v) ->
        val effectName = Regex(" *\\(%value%\\)").replace(v, "")
        val targetName = target.descriptions.getLocalizedString(k)
        "$effectName [$targetName]"
      }
}

object BasicSongEffects : ImplementationRegistry<SongEffect>() {
  init {
    +NoneSongEffect
    valuesGenMusicSkill
        .filterKeys { it < 1000 }
        .values
        .groupBy { it.skill_option1_id }
        .values
        .forEach {
          val effect = it.first()
          +CommonSongEffect(
              id = effect._id_,
              skillOption =
                  (SkillOptions[effect.skill_option1_id] as? ReversiblePassiveSkillOption)
                      ?: error(
                          "Skill option ${effect.skill_option1_id} is not reversible, got ${SkillOptions[effect.skill_option1_id]}"),
              target =
                  if (effect.skill_option1_target_id != 0) {
                    SkillTargets[effect.skill_option1_target_id]
                        ?: error("Target ${effect.skill_option1_target_id} not found.")
                  } else {
                    SkillTargets.self
                  },
              defaultValue = effect.skill_option1_values.firstOrNull(),
          )
        }
  }

  val aliases: Map<String, SongEffect> =
      mutableMapOf<String, SongEffect>().also { map ->
        values.forEach { effect -> map["${effect.id}"] = effect }
      }
}

object ExtraSongEffects : ImplementationRegistry<SongEffect>() {
  init {
    val showPercentSkills =
        setOf(
            SkillOptions.NormalDefenseUp,
            SkillOptions.SpecialDefenseUp,
        )
    +NoneSongEffect
    valuesGenMusicExtraSkill.values.forEach { effect ->
      val skillOption =
          (SkillOptions[effect.skill_option1_id] as? ReversiblePassiveSkillOption)
              ?: error(
                  "Skill option ${effect.skill_option1_id} is not reversible, got ${SkillOptions[effect.skill_option1_id]}")
      +ExtraSongEffect(
          id = effect._id_,
          skillOption = skillOption,
          target =
              if (effect.skill_option1_target_id != 0) {
                SkillTargets[effect.skill_option1_target_id]
                    ?: error("Target ${effect.skill_option1_target_id} not found.")
              } else {
                SkillTargets.self
              },
          defaultValue = null,
      )
    }
  }

  val aliases: Map<String, SongEffect> =
      mutableMapOf<String, SongEffect>().also { map ->
        values.forEach { effect -> map["${effect.id}"] = effect }
      }
}

object AwakeningSongEffects : ImplementationRegistry<AwakeningSongEffect>() {
  init {
    valuesGenMusicSkill
        .filterKeys { it >= 1000 }
        .values
        .forEach {
          val target =
              SkillTargets[it.skill_option1_target_id]
                  ?: error("Target ${it.skill_option1_target_id} not found.")
          +AwakeningSongEffect(
              id = it._id_,
              shortNames = it.name,
              skillOption =
                  (SkillOptions[it.skill_option1_id] as? ReversiblePassiveSkillOption)
                      ?: error(
                          "Skill option ${it.skill_option1_id} is not reversible, got ${SkillOptions[it.skill_option1_id]}"),
              target = target,
              defaultValue = it.skill_option1_values.firstOrNull(),
              values = it.skill_option1_values,
          )
        }
  }
}
