package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.ActionContext

data class ActData(
    val name: String,
    val type: ActType,
    val apCost: Int,
    val icon: Int?,
    val act: Act,
)

enum class ActType(val shortName: String) {
  Act1("1"),
  Act2("2"),
  Act3("3"),
  Act4("4"),
  Act5("5"),
  Act6("6"),
  Act7("7"),
  Act8("8"),
  Act9("9"),
  Act10("10"),
  ClimaxAct("cx"),
  ConfusionAct("conf");

  operator fun invoke(name: String, apCost: Int, icon: Int? = null, act: Act) =
      ActData(name, this, apCost, icon, act)
}

fun actsOf(vararg acts: ActData) = acts.associateBy { it.type }

inline fun ActData.wrap(crossinline act: ActionContext.(Act) -> Unit) = copy(act = { act(this@wrap.act) })
