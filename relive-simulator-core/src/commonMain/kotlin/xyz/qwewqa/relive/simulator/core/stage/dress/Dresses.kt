package xyz.qwewqa.relive.simulator.core.stage.dress

import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenDress
import xyz.qwewqa.relive.simulator.core.gen.valuesGenDressRemakeParameter
import xyz.qwewqa.relive.simulator.core.gen.valuesGenFriendshipPattern
import xyz.qwewqa.relive.simulator.core.gen.valuesGenGrowthBoard
import xyz.qwewqa.relive.simulator.core.gen.valuesGenGrowthPanel
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Skills
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveSkillGroups
import xyz.qwewqa.relive.simulator.core.stage.autoskill.StartSkillGroups
import xyz.qwewqa.relive.simulator.core.stage.autoskill.UnitSkills
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

const val DRESS_AUTO_SKILL_LEVEL = 1

object Dresses : ImplementationRegistry<DressBlueprint>() {
  init {
    for ((id, dress) in valuesGenDress) {
      if (dress.base_rarity < 4) {
        continue
      }
      +DressBlueprint(
          id = id,
          name = dress.name.getLocalizedString(),
          baseRarity = dress.base_rarity,
          cost = dress.cost,
          character = characterFromId(dress.chara_id) ?: continue,
          attribute = attributeFromId(dress.attribute_id) ?: continue,
          damageType = attackTypeFromId(dress.attack_type) ?: continue,
          position = positionTypeFromPosition(dress.role_index),
          positionValue = dress.role_index,
          stats =
              StatData(
                  hp = dress.base_hp,
                  actPower = dress.base_atk,
                  normalDefense = dress.base_pdef,
                  specialDefense = dress.base_mdef,
                  agility = dress.base_agi,
                  dexterity = dress.dex,
                  critical = dress.cri,
                  accuracy = dress.hit,
                  evasion = dress.eva,
              ),
          growthStats =
              StatData(
                  hp = dress.delta_hp,
                  actPower = dress.delta_atk,
                  normalDefense = dress.delta_pdef,
                  specialDefense = dress.delta_mdef,
                  agility = dress.delta_agi,
              ),
          acts =
              listOf(
                  (Skills[dress.command_skill1_id] ?: continue).asActBlueprint(ActType.Act1),
                  (Skills[dress.command_skill2_id] ?: continue).asActBlueprint(ActType.Act2),
                  (Skills[dress.command_skill3_id] ?: continue).asActBlueprint(ActType.Act3),
                  (Skills[dress.command_unique_skill_id] ?: continue).asActBlueprint(
                      ActType.ClimaxAct),
              ),
          autoSkills =
              listOfNotNull(
                  when (dress.auto_skill1_type) {
                    1 ->
                        (PassiveSkillGroups[dress.auto_skill1_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    2 ->
                        (StartSkillGroups[dress.auto_skill1_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    else -> null
                  }?.skills,
                  when (dress.auto_skill2_type) {
                    1 ->
                        (PassiveSkillGroups[dress.auto_skill2_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    2 ->
                        (StartSkillGroups[dress.auto_skill2_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    else -> null
                  }?.skills,
                  when (dress.auto_skill3_type) {
                    1 ->
                        (PassiveSkillGroups[dress.auto_skill3_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    2 ->
                        (StartSkillGroups[dress.auto_skill3_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    else -> null
                  }?.skills,
                  when (dress.auto_skill4_type) {
                    1 ->
                        (PassiveSkillGroups[dress.auto_skill4_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    2 ->
                        (StartSkillGroups[dress.auto_skill4_id] ?: continue).create(
                            DRESS_AUTO_SKILL_LEVEL)
                    else -> null
                  }?.skills,
              ),
          autoSkillRanks =
              listOf(
                  dress.auto_skill1_release_rank,
                  dress.auto_skill2_release_rank,
                  dress.auto_skill3_release_rank,
                  dress.auto_skill4_release_rank,
              ),
          autoSkillPanels =
              listOf(
                  0,
                  0,
                  dress.auto_skill3_release_panel_number,
                  dress.auto_skill4_release_panel_number,
              ),
          rankPanels =
              listOf(
                      dress.growth_board1_id,
                      dress.growth_board2_id,
                      dress.growth_board3_id,
                      dress.growth_board4_id,
                      dress.growth_board5_id,
                      dress.growth_board6_id,
                      dress.growth_board7_id,
                      dress.growth_board8_id,
                      dress.growth_board9_id,
                  )
                  .map { growthBoardId ->
                    valuesGenGrowthBoard[growthBoardId]!!.let { board ->
                      listOf(
                              board.panel1_id,
                              board.panel2_id,
                              board.panel3_id,
                              board.panel4_id,
                              board.panel5_id,
                              board.panel6_id,
                              board.panel7_id,
                              board.panel8_id,
                          )
                          .map { panelId ->
                            valuesGenGrowthPanel[panelId]!!.let { panel ->
                              StatBoost(type = growthTypeFromId(panel.type), value = panel.value)
                            }
                          }
                    }
                  },
          friendshipPanels =
              valuesGenFriendshipPattern[dress.friendship_pattern_id]!!.map { panel ->
                StatBoost(type = growthTypeFromId(panel.effect_type), value = panel.effect_arg1)
              },
          remakeParameters =
              valuesGenDressRemakeParameter[id]?.map {
                StatData(
                    hp = it.hp,
                    actPower = it.atk,
                    normalDefense = it.pdef,
                    specialDefense = it.mdef,
                    agility = it.agi,
                )
              }
                  ?: emptyList(),
          unitSkill = UnitSkills[dress.party_skill_id] ?: continue,
          multipleCA = Skills[dress.command_unique_skill_id]!!.isMultipleCa,
      )
    }
  }

  val aliases: Map<String, DressBlueprint> =
      mutableMapOf<String, DressBlueprint>().also { map ->
        values.forEach { dress ->
          map[dress.fullName] = dress
          map["${dress.id}"] = dress
        }
      }
}

fun characterFromId(id: Int) =
    when (id) {
      101 -> Character.Karen
      102 -> Character.Hikari
      103 -> Character.Mahiru
      104 -> Character.Claudine
      105 -> Character.Maya
      106 -> Character.Junna
      107 -> Character.Nana
      108 -> Character.Futaba
      109 -> Character.Kaoruko
      201 -> Character.Tamao
      202 -> Character.Ichie
      203 -> Character.Fumi
      204 -> Character.Rui
      205 -> Character.Yuyuko
      301 -> Character.Aruru
      302 -> Character.Misora
      303 -> Character.Lalafin
      304 -> Character.Tsukasa
      305 -> Character.Shizuha
      401 -> Character.Akira
      402 -> Character.Michiru
      403 -> Character.MeiFan
      404 -> Character.Shiori
      405 -> Character.Yachiyo
      406 -> Character.Stella
      407 -> Character.Shiro
      408 -> Character.Ryoko
      409 -> Character.Minku
      410 -> Character.Kuina
      501 -> Character.Koharu
      502 -> Character.Suzu
      503 -> Character.Hisame
      901 -> Character.Sakura
      902 -> Character.Erika
      903 -> Character.Gemie
      else -> null
    }

fun growthTypeFromId(id: Int) =
    when (id) {
      11 -> StatBoostType.Hp
      12 -> StatBoostType.ActPower
      13 -> StatBoostType.NormalDefense
      14 -> StatBoostType.SpecialDefense
      15 -> StatBoostType.Agility
      31 -> StatBoostType.Act1Level
      32 -> StatBoostType.Act2Level
      33 -> StatBoostType.Act3Level
      34 -> StatBoostType.ClimaxActLevel
      else -> StatBoostType.None
    }

fun attributeFromId(id: Int) =
    when (id) {
      1 -> Attribute.Flower
      2 -> Attribute.Wind
      3 -> Attribute.Snow
      4 -> Attribute.Moon
      5 -> Attribute.Space
      6 -> Attribute.Cloud
      7 -> Attribute.Dream
      8 -> Attribute.Sun
      9 -> Attribute.Star
      else -> null
    }

fun attackTypeFromId(id: Int) =
    when (id) {
      1 -> DamageType.Normal
      2 -> DamageType.Special
      else -> null
    }

fun positionTypeFromPosition(position: Int) =
    when {
      position <= 9999 -> Position.None
      position <= 19999 -> Position.Front
      position <= 29999 -> Position.Middle
      position <= 39999 -> Position.Back
      else -> error("Invalid position $position")
    }
