package xyz.qwewqa.relive.simulator.core.stage.memoir

import xyz.qwewqa.relive.simulator.core.gen.valuesGenEquip
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveSkillGroups
import xyz.qwewqa.relive.simulator.core.stage.autoskill.StartSkillGroups

object Memoirs : ImplementationRegistry<MemoirBlueprint>() {
  val EmptyMemoir =
      +MemoirBlueprint(
          0,
          mapOf("en" to "None", "ja" to "なし", "zh_hant" to "無", "ko" to "없음"),
          rarity = 4,
          cost = 0,
          baseStats = StatData(),
          growthStats = StatData(),
          autoskills = emptyList(),
      )
  init {
    for ((id, equip) in valuesGenEquip) {
      if (equip.type != 1) continue
      +MemoirBlueprint(
          id = id,
          names = equip.name,
          rarity = equip.rarity,
          cost = equip.cost,
          baseStats =
              StatData(
                  hp = equip.base_hp,
                  actPower = equip.base_atk,
                  normalDefense = equip.base_pdef,
                  specialDefense = equip.base_mdef,
              ),
          growthStats =
              StatData(
                  hp = equip.delta_hp,
                  actPower = equip.delta_atk,
                  normalDefense = equip.delta_pdef,
                  specialDefense = equip.delta_mdef,
              ),
          autoskills =
              listOfNotNull(
                  when (equip.auto_skill1_type) {
                    1 -> (PassiveSkillGroups[equip.auto_skill1_id] ?: continue)
                    2 -> (StartSkillGroups[equip.auto_skill1_id] ?: continue)
                    else -> null
                  }),
          cutinData =
              if (equip.active_skill_id != 0)
                  (CutinSkills[equip.active_skill_id] ?: continue).asCutinBlueprint()
              else null,
          releaseTime = equip.published_at,
      )
    }
  }

  val aliases: Map<String, MemoirBlueprint> =
      mutableMapOf<String, MemoirBlueprint>().also { map ->
        values.forEach { memoir ->
          map[memoir.name] = memoir
          map["${memoir.id}"] = memoir
        }
      }
}
