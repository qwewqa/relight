package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

private val normalActs = listOf(ActType.Act1, ActType.Act2, ActType.Act3)

val seesawStrategy = FixedStrategy {
    val boss = enemy.actors.values.single()

    if (boss.brilliance >= 100) {
        +boss[ActType.ClimaxAct]
    }
    normalActs.shuffled(stage.random).forEach {
        -boss[it]
    }
}
