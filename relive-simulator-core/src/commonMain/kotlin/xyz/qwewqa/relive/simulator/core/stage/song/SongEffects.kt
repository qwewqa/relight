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

class CommonSongEffect(
    override val id: Int,
    override val names: Map<String, String>,
    val skillOption: ReversiblePassiveSkillOption,
    val target: SkillTarget,
    override val defaultValue: Int?,
) : SongEffect {
  override val iconId = skillOption.iconId

  override fun start(context: ActionContext, value: Int) =
      context.run {
        if (self in target.getTargets(context, null)) {
          skillOption.executePassive(TargetContext(context, listOf(self)), value)
        }
      }

  override fun end(context: ActionContext, value: Int) =
      context.run {
        if (self in target.getTargets(context, null)) {
          skillOption.reversePassive(TargetContext(context, listOf(self)), value)
        }
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
              names = effect.name,
              skillOption = (SkillOptions[effect.skill_option1_id] as? ReversiblePassiveSkillOption)
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
    +NoneSongEffect
    valuesGenMusicExtraSkill.values.forEach { effect ->
      val skillOption =
          (SkillOptions[effect.skill_option1_id] as? ReversiblePassiveSkillOption)
              ?: error(
                  "Skill option ${effect.skill_option1_id} is not reversible, got ${SkillOptions[effect.skill_option1_id]}")
      +CommonSongEffect(
          id = effect._id_,
          names =
              effect.name.mapValues { (_, v) ->
                if (skillOption.valueUnit == DescriptionUnit.None) {
                  "$v #"
                } else {
                  v
                }
              },
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

object AwakeningSongEffects : ImplementationRegistry<SongEffect>() {
  init {
    valuesGenMusicSkill
        .filterKeys { it >= 1000 }
        .values
        .forEach {
          val target =
              SkillTargets[it.skill_option1_target_id]
                  ?: error("Target ${it.skill_option1_target_id} not found.")
          +CommonSongEffect(
              id = it._id_,
              names =
                  it.name.mapValues { (k, v) ->
                    "$v [${target.descriptions.getLocalizedString(k)}]"
                  },
              skillOption = (SkillOptions[it.skill_option1_id] as? ReversiblePassiveSkillOption)
                      ?: error(
                          "Skill option ${it.skill_option1_id} is not reversible, got ${SkillOptions[it.skill_option1_id]}"),
              target = target,
              defaultValue = it.skill_option1_values.firstOrNull(),
          )
        }
  }
}
