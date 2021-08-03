package xyz.qwewqa.relivesim.stage.act

import xyz.qwewqa.relivesim.stage.context.ActionContext

data class ActData(
    val name: String,
    val type: ActType,
    val apCost: Int,
    val act: Act,
)

fun interface Act {
    fun action(context: ActionContext)
}

