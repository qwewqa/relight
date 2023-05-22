package xyz.qwewqa.relive.simulator.core

import Accessories
import xyz.qwewqa.relive.simulator.common.AccessoryData
import xyz.qwewqa.relive.simulator.common.AwakeningSongEffectData
import xyz.qwewqa.relive.simulator.common.BossData
import xyz.qwewqa.relive.simulator.common.DataSimulationOption
import xyz.qwewqa.relive.simulator.common.DressData
import xyz.qwewqa.relive.simulator.common.MemoirData
import xyz.qwewqa.relive.simulator.common.PassiveSongEffectData
import xyz.qwewqa.relive.simulator.common.RemakeSkillData
import xyz.qwewqa.relive.simulator.common.SimulationOption
import xyz.qwewqa.relive.simulator.common.SimulationOptions
import xyz.qwewqa.relive.simulator.common.SongAwakeningData
import xyz.qwewqa.relive.simulator.common.SongData
import xyz.qwewqa.relive.simulator.common.SongEffectData
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenRemakeSkill
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.stage.actor.Skill
import xyz.qwewqa.relive.simulator.core.stage.autoskill.remakeSkills
import xyz.qwewqa.relive.simulator.core.stage.common.substitute
import xyz.qwewqa.relive.simulator.core.stage.dress.Dresses
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoirs
import xyz.qwewqa.relive.simulator.core.stage.song.AwakeningSongEffect
import xyz.qwewqa.relive.simulator.core.stage.song.AwakeningSongEffects
import xyz.qwewqa.relive.simulator.core.stage.song.BasicSongEffects
import xyz.qwewqa.relive.simulator.core.stage.song.ExtraSongEffects
import xyz.qwewqa.relive.simulator.core.stage.song.Songs
import xyz.qwewqa.relive.simulator.core.stage.song.awakenSkills
import xyz.qwewqa.relive.simulator.core.stage.strategy.bossStrategyParsers
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers

fun getSimulationOptions(): SimulationOptions {
  val locales = mapOf("en" to "English", "zh_hant" to "繁体中文", "ko" to "한국어")
  val localeIds = locales.keys
  return SimulationOptions(
      locales = locales,
      commonText = commonText.map { (k, v) -> SimulationOption(k, v) },
      dresses =
          Dresses.map { (id, dress) ->
                val tags =
                    localeIds.associateWith { locale ->
                      listOfNotNull(
                          dress.character.names.getLocalizedString(locale).lowercase(),
                          dress.character.school.name.lowercase(),
                          dress.attribute.name.lowercase(),
                          dress.damageType.name.lowercase(),
                          dress.position.name.lowercase(),
                          "c${dress.cost}",
                      )
                    }
                DataSimulationOption(
                    id = "$id",
                    name = dress.fullNames,
                    descriptionIcons =
                        listOfNotNull(
                            dress.character.school.id?.let {
                              "img/icon_colored/60x56_school$it.png"
                            },
                            dress.attribute.id?.let { "img/icon_colored/56x56_attribute$it.png" },
                            dress.damageType.id?.let {
                              "img/icon_colored/54x54_attack_type$it.png"
                            },
                            dress.position.id?.let { "img/icon_colored/54x54_position$it.png" },
                        ),
                    description = localeIds.associateWith { "c${dress.cost}" },
                    tags = tags,
                    imagePath = "img/large_icon/1_${dress.id}.png".takeIf { dress.id > 0 },
                    data =
                        DressData(
                            id = dress.id,
                            attribute = dress.attribute.ordinal,
                            damageType = dress.damageType.ordinal,
                            positionValue = dress.positionValue,
                            positionName = dress.position.name.lowercase(),
                            characterName = dress.character.displayName,
                            character = dress.character,
                            releaseTime = dress.releaseTime,
                            cost = dress.cost,
                        ),
                )
              }
              .sortedByDescending { it.data.releaseTime },
      memoirs =
          Memoirs.map { (id, memoir) ->
                DataSimulationOption(
                    id = "$id",
                    name = memoir.names,
                    description =
                        localeIds.associateWith { locale ->
                          "c${memoir.cost}${if (memoir.cutinData != null) ", cutin" else ""}"
                        },
                    descriptionIcons =
                        memoir.autoskills
                            .flatMap { it.create(5).skills }
                            .mapNotNull { it.iconId }
                            .map { "img/skill_icon/skill_icon_$it.png" }
                            .distinct(),
                    tags =
                        localeIds.associateWith { locale ->
                          memoir.characters.map { it.names.getLocalizedString(locale) } +
                              memoir.autoskills
                                  .flatMap { it.create(5).skills }
                                  .mapNotNull { it.descriptions?.getLocalizedString(locale) } +
                              ((memoir.cutinData?.create(4)?.act as? Skill)?.descriptions?.map {
                                it.getLocalizedString(locale)
                              }
                                  ?: emptyList()) +
                              listOfNotNull(
                                  "c${memoir.cost}", "cutin".takeIf { memoir.cutinData != null })
                        },
                    imagePath =
                        if (memoir.id > 0) {
                          "img/large_icon/2_${memoir.id}.png"
                        } else {
                          "img/common/plate_unselected_3.png"
                        },
                    data =
                        MemoirData(
                            id = memoir.id,
                            cost = memoir.cost,
                            releaseTime = memoir.releaseTime,
                        ))
              }
              .sortedByDescending { it.data.releaseTime ?: Int.MAX_VALUE },
      songs =
          Songs.map { (id, song) ->
            val awakenSkills = song.awakenSkills
            DataSimulationOption(
                id = "$id",
                name = song.names,
                description =
                    localeIds.associateWith { locale ->
                      if (awakenSkills.isEmpty()) {
                        "∅"
                      } else {
                        val target =
                            awakenSkills
                                .map { (it as? AwakeningSongEffect)?.target }
                                .toSet()
                                .singleOrNull()
                        if (target != null) {
                          target.descriptions.getLocalizedString(locale)
                        } else {
                          ""
                        }
                      }
                    },
                descriptionIcons =
                    awakenSkills
                        .filter { it.iconId != null }
                        .map { "img/skill_icon/skill_icon_${it.iconId}.png" },
                tags =
                    localeIds.associateWith { locale ->
                      awakenSkills.map { it.names.getLocalizedString(locale) }
                    },
                imagePath = "img/music_coverart/27_$id.png".takeIf { id >= 0 },
                data =
                    SongData(
                        id = song.id,
                        awakenSkill1Id = song.awakenSkill1?.id,
                        awakenSkill2Id = song.awakenSkill2?.id,
                        awakenSkill3Id = song.awakenSkill3?.id,
                        awakenSkill4Id = song.awakenSkill4?.id,
                    ),
            )
          },
      awakeningSongs =
          Songs.filter { (_, song) -> song.awakenExtraSkill != null }
              .map { (id, song) ->
                val skill = song.awakenExtraSkill!!
                DataSimulationOption(
                    id = "$id",
                    name = song.names,
                    description = skill.names.mapValues { (_, v) -> "$v ${skill.defaultValue}" },
                    descriptionIcons = listOf("img/skill_icon/skill_icon_${skill.iconId}.png"),
                    imagePath = "img/music_coverart/27_$id.png",
                    data = SongAwakeningData(id = id))
              },
      songEffects =
          BasicSongEffects.map { (id, effect) ->
            DataSimulationOption(
                id = "$id",
                name = effect.names,
                imagePath =
                    "img/skill_icon/skill_icon_${effect.iconId}.png".takeIf {
                      effect.iconId != null
                    },
                data =
                    SongEffectData(
                        id = id,
                    ),
            )
          },
      awakeningSongEffects =
          AwakeningSongEffects.map { (id, effect) ->
            DataSimulationOption(
                id = "$id",
                name = effect.names,
                imagePath =
                    "img/skill_icon/skill_icon_${effect.iconId}.png".takeIf {
                      effect.iconId != null
                    },
                data =
                    AwakeningSongEffectData(
                        id = id,
                    ),
            )
          },
      passiveSongEffects =
          ExtraSongEffects.map { (id, effect) ->
            DataSimulationOption(
                id = "$id",
                name = effect.names,
                description = Songs[id / 100]?.let { song -> song.names },
                imagePath =
                    "img/skill_icon/skill_icon_${effect.iconId}.png".takeIf {
                      effect.iconId != null
                    },
                data =
                    PassiveSongEffectData(
                        id = id,
                    ),
            )
          },
      bosses =
          bossLoadouts.map { (k, v) ->
            val boss = v.loadout.create()
            val dress = boss.dress
            DataSimulationOption(
                id = k,
                name = mapOf("en" to k),
                descriptionIcons =
                    listOfNotNull(
                        dress.character.school.id?.let { "img/icon_colored/60x56_school$it.png" },
                        dress.attribute.id?.let { "img/icon_colored/56x56_attribute$it.png" },
                        dress.damageType.id?.let { "img/icon_colored/54x54_attack_type$it.png" },
                        dress.position.id?.let { "img/icon_colored/54x54_position$it.png" },
                    ),
                description = mapOf("en" to "hp${boss.maxHp}"),
                imagePath = v.info?.iconId?.let { "img/enemy/$it.png" },
                data = BossData.fromDress(dress),
            )
          },
      strategyTypes = strategyParsers.map { (k, _) -> SimulationOption(k, mapOf("en" to k)) },
      bossStrategyTypes =
          bossStrategyParsers.map { (k, _) -> SimulationOption(k, mapOf("en" to k)) },
      remakeSkills =
          remakeSkills.values.map { skill ->
            val effect = skill.effects.firstOrNull()
            val value = effect?.value ?: 0
            val valueSuffix = effect?.effect?.valueSuffix
            val time = effect?.time ?: 0
            val timeSuffix = effect?.effect?.timeSuffix
            val data = valuesGenRemakeSkill[skill.id]
            DataSimulationOption(
                id = skill.name,
                name =
                    if (skill.id == 0)
                        mapOf(
                            "en" to "None",
                            "ko" to "없음",
                            "zh_hant" to "無",
                        )
                    else
                        data!!.description.mapValues { (_, desc) ->
                          desc.substitute(
                              "opt1_value" to "$value",
                              "opt1_time" to "$time",
                          )
                        },
                imagePath = "img/skill_icon/skill_icon_${skill.icon}.png",
                data =
                    RemakeSkillData(
                        value = "$value$valueSuffix".takeIf { valueSuffix != null },
                        time = "$time$timeSuffix".takeIf { timeSuffix != null },
                        targeting = skill.effects.firstOrNull()?.targeting?.shortName ?: "None",
                    ))
          },
      accessories =
          Accessories.map { (id, accessory) ->
            DataSimulationOption(
                id = "$id",
                name = accessory.names,
                description = null,
                tags = mapOf("en" to listOf(), "ja" to listOf()),
                imagePath =
                    if (accessory.iconId == 0) "img/common/plate_unselected_6.png"
                    else "img/medium_icon/38_${accessory.iconId}.png",
                data =
                    AccessoryData(
                        id = accessory.id,
                        dressIds = accessory.dressIds,
                        attributeId = accessory.attribute?.ordinal,
                        autoSkillLimitBreak = accessory.autoskills.map { it.first }.sorted()),
            )
          })
}
