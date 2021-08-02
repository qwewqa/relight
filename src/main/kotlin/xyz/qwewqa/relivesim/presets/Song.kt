package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.Percent
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

class CriticalSongEffect(efficacy: Percent) : SimpleSongEffect<Percent>(efficacy) {
    override fun start(context: ActionContext) = context.run {
        self.critical.value += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.critical.value -= efficacy
    }
}

class DexteritySongEffect(efficacy: Percent) : SimpleSongEffect<Percent>(efficacy) {
    override fun start(context: ActionContext) = context.run {
        self.dexterity.value += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.dexterity.value -= efficacy
    }
}