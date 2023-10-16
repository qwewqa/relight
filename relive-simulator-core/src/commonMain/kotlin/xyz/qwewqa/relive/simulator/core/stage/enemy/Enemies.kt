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
    for ((id, enemy) in valuesGenEnemy) {
      val acts = mutableMapOf<ActType, ActData>()
      if (enemy.command_skill1_id > 0) {
        acts[ActType.Act1] =
            Skills[enemy.command_skill1_id]!!.asActBlueprint(ActType.Act1).create(1)
      }
      if (enemy.command_skill2_id > 0) {
        acts[ActType.Act2] =
            Skills[enemy.command_skill2_id]!!.asActBlueprint(ActType.Act2).create(1)
      }
      if (enemy.command_skill3_id > 0) {
        acts[ActType.Act3] =
            Skills[enemy.command_skill3_id]!!.asActBlueprint(ActType.Act3).create(1)
      }
      if (enemy.command_skill4_id > 0) {
        acts[ActType.Act4] =
            Skills[enemy.command_skill4_id]!!.asActBlueprint(ActType.Act4).create(1)
      }
      if (enemy.command_skill5_id > 0) {
        acts[ActType.Act5] =
            Skills[enemy.command_skill5_id]!!.asActBlueprint(ActType.Act5).create(1)
      }
      if (enemy.command_skill6_id > 0) {
        acts[ActType.Act6] =
            Skills[enemy.command_skill6_id]!!.asActBlueprint(ActType.Act6).create(1)
      }
      if (enemy.command_skill7_id > 0) {
        acts[ActType.Act7] =
            Skills[enemy.command_skill7_id]!!.asActBlueprint(ActType.Act7).create(1)
      }
      if (enemy.command_skill8_id > 0) {
        acts[ActType.Act8] =
            Skills[enemy.command_skill8_id]!!.asActBlueprint(ActType.Act8).create(1)
      }
      if (enemy.command_skill9_id > 0) {
        acts[ActType.Act9] =
            Skills[enemy.command_skill9_id]!!.asActBlueprint(ActType.Act9).create(1)
      }
      if (enemy.command_skill10_id > 0) {
        acts[ActType.Act10] =
            Skills[enemy.command_skill10_id]!!.asActBlueprint(ActType.Act10).create(1)
      }
      if (enemy.command_unique_skill_id > 0) {
        acts[ActType.ClimaxAct] =
            Skills[enemy.command_unique_skill_id]!!.asActBlueprint(ActType.ClimaxAct).create(1)
      }
      +Enemy(id, acts)
    }
  }
}
