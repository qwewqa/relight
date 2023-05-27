import xyz.qwewqa.relive.simulator.core.gen.valuesGenAccessory
import xyz.qwewqa.relive.simulator.core.gen.valuesGenAccessoryGrow
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.accessory.AccessoryBlueprint
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Skills
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveSkillGroups
import xyz.qwewqa.relive.simulator.core.stage.autoskill.StartSkillGroups

object Accessories : ImplementationRegistry<AccessoryBlueprint>() {
  val emptyAccessory =
      +AccessoryBlueprint(
          0,
          0,
          mapOf("en" to "None", "ja" to "なし", "zh_hant" to "無", "ko" to "없음"),
          emptyList(),
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          Array(100) { 0 },
          emptySet(),
      )

  init {
    for ((id, accessory) in valuesGenAccessory) {
      +AccessoryBlueprint(
          id = id,
          iconId = accessory.icon_id,
          names = accessory.name,
          autoskills =
              listOfNotNull(
                  if (accessory.auto_skill1_id != 0)
                      accessory.auto_skill1_release_limitbreak to
                          when (accessory.auto_skill1_type) {
                                1 -> (PassiveSkillGroups[accessory.auto_skill1_id] ?: continue)
                                2 -> (StartSkillGroups[accessory.auto_skill1_id] ?: continue)
                                else -> continue
                              }
                              .create(1)
                              .skills
                  else null,
                  if (accessory.auto_skill2_id != 0)
                      accessory.auto_skill2_release_limitbreak to
                          when (accessory.auto_skill2_type) {
                                1 -> (PassiveSkillGroups[accessory.auto_skill2_id] ?: continue)
                                2 -> (StartSkillGroups[accessory.auto_skill2_id] ?: continue)
                                else -> continue
                              }
                              .create(1)
                              .skills
                  else null,
                  if (accessory.auto_skill3_id != 0)
                      accessory.auto_skill3_release_limitbreak to
                          when (accessory.auto_skill3_type) {
                                1 -> (PassiveSkillGroups[accessory.auto_skill3_id] ?: continue)
                                2 -> (StartSkillGroups[accessory.auto_skill3_id] ?: continue)
                                else -> continue
                              }
                              .create(1)
                              .skills
                  else null,
                  if (accessory.auto_skill4_id != 0)
                      accessory.auto_skill4_release_limitbreak to
                          when (accessory.auto_skill4_type) {
                                1 -> (PassiveSkillGroups[accessory.auto_skill4_id] ?: continue)
                                2 -> (StartSkillGroups[accessory.auto_skill4_id] ?: continue)
                                else -> continue
                              }
                              .create(1)
                              .skills
                  else null,
                  if (accessory.auto_skill5_id != 0)
                      accessory.auto_skill5_release_limitbreak to
                          when (accessory.auto_skill5_type) {
                                1 -> (PassiveSkillGroups[accessory.auto_skill5_id] ?: continue)
                                2 -> (StartSkillGroups[accessory.auto_skill5_id] ?: continue)
                                else -> continue
                              }
                              .create(1)
                              .skills
                  else null,
              ),
          baseHp = accessory.base_hp,
          baseActPower = accessory.base_atk,
          baseNormalDefense = accessory.base_pdef,
          baseSpecialDefense = accessory.base_mdef,
          baseDexterity = accessory.base_dex,
          baseCritical = accessory.base_cri,
          baseAgility = accessory.base_agi,
          maxHp = accessory.max_hp,
          maxActPower = accessory.max_atk,
          maxNormalDefense = accessory.max_pdef,
          maxSpecialDefense = accessory.max_mdef,
          maxDexterity = accessory.max_dex,
          maxCritical = accessory.max_cri,
          maxAgility = accessory.max_agi,
          growValues = valuesGenAccessoryGrow[accessory.grow_id] ?: continue,
          dressIds = accessory.dress_ids.toSet(),
          attribute = getAttributeFromId(accessory.attribute_id),
          actData =
              if (accessory.skill_slot != 0)
                  Skills[accessory.skill_id]?.asActBlueprint(
                      when (accessory.skill_slot) {
                        1 -> ActType.Act1
                        2 -> ActType.Act2
                        3 -> ActType.Act3
                        4 -> ActType.ClimaxAct
                        else -> error("Invalid act slot ${accessory.skill_slot}")
                      })
              else null,
      )
    }
  }

  val aliases: Map<String, AccessoryBlueprint> =
      mutableMapOf<String, AccessoryBlueprint>().also { map ->
        values.forEach { accessory ->
          map["${accessory.id}"] = accessory
          accessory.names.values.forEach { name -> map[name] = accessory }
        }
      }
}

fun getAttributeFromId(id: Int) =
    when (id) {
      0 -> null
      1 -> Attribute.Flower
      2 -> Attribute.Wind
      3 -> Attribute.Snow
      4 -> Attribute.Moon
      5 -> Attribute.Space
      6 -> Attribute.Cloud
      7 -> Attribute.Dream
      8 -> Attribute.Sun
      9 -> Attribute.Star
      else -> error("Invalid attribute id $id")
    }
