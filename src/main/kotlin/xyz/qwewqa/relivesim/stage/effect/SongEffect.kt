package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext

interface SongEffect {
    fun start(context: ActionContext)
    fun stop(context: ActionContext)
}