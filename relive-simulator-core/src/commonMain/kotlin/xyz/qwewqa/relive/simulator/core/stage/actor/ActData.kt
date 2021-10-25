package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.Act

data class ActData(
    val name: String,
    val type: ActType,
    val apCost: Int,
    val act: Act,
)

enum class ActType {
    Act1,
    Act2,
    Act3,
    Act4,
    Act5,
    Act6,
    Act7,
    Act8,
    Act9,
    Act10,
    ClimaxAct,
    ConfusionAct;
}

operator fun ActType.invoke(name: String, apCost: Int, act: Act) = ActData(name, this, apCost, act)

fun actsOf(vararg acts: ActData) = acts.associateBy { it.type }
