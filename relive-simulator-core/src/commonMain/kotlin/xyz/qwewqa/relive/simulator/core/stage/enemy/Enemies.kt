package xyz.qwewqa.relive.simulator.core.stage.enemy

import xyz.qwewqa.relive.simulator.core.gen.valuesGenEnemy
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Skills

data class Enemy(override val id: Int, val acts: Map<ActType, ActData>) : FeatureImplementation

object Enemies : ImplementationRegistry<Enemy>() {
  init {
    outer@ for ((id, enemy) in valuesGenEnemy) {
      val acts = mutableMapOf<ActType, ActData>()
      for ((skillId, actType) in listOf(
          enemy.command_skill1_id to ActType.Act1,
          enemy.command_skill2_id to ActType.Act2,
          enemy.command_skill3_id to ActType.Act3,
          enemy.command_skill4_id to ActType.Act4,
          enemy.command_skill5_id to ActType.Act5,
          enemy.command_skill6_id to ActType.Act6,
          enemy.command_skill7_id to ActType.Act7,
          enemy.command_skill8_id to ActType.Act8,
          enemy.command_skill9_id to ActType.Act9,
          enemy.command_skill10_id to ActType.Act10,
          enemy.command_unique_skill_id to ActType.ClimaxAct,
      )) {
        if (skillId <= 0) continue
        if (Skills[skillId] == null) {
          continue@outer
        } else {
          acts[actType] = Skills[skillId]!!.asActBlueprint(actType).create(1)
        }
      }
      +Enemy(id, acts)
    }
  }
}
