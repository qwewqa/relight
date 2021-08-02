package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.SimpleSongEffect

class ActStatUpSongEffect(efficacy: Int) : SimpleSongEffect<Int>(efficacy) {
    override fun start(context: ActionContext) = context.run {
        self.actPower.value += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.actPower.value -= efficacy
    }
}