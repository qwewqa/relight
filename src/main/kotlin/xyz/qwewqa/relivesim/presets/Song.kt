package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.SongEffect

data class ActStatUpSongEffect(val efficacy: Int) : SongEffect {
    override fun start(context: ActionContext) = context.run {
        self.actPower.base += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.actPower.base -= efficacy
    }
}

data class CriticalSongEffect(val efficacy: Percent) : SongEffect {
    override fun start(context: ActionContext) = context.run {
        self.critical.base += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.critical.base -= efficacy
    }
}

data class DexteritySongEffect(val efficacy: Percent) : SongEffect {
    override fun start(context: ActionContext) = context.run {
        self.dexterity.buff += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.dexterity.buff -= efficacy
    }
}

data class AttributeDamageDealtUp(val attribute: Attribute, val efficacy: Percent) : SongEffect {
    override fun start(context: ActionContext) = context.run {
        self.attributeDamageDealtUp[attribute] = self.attributeDamageDealtUp.getValue(attribute) + (efficacy)
    }

    override fun stop(context: ActionContext) = context.run {
        self.attributeDamageDealtUp[attribute] = self.attributeDamageDealtUp.getValue(attribute) - efficacy
    }
}

fun SongEffect.conditional(condition: StageGirl.() -> Boolean) = object : SongEffect {
    override fun start(context: ActionContext) {
        if (context.self.condition()) {
            this@conditional.start(context)
        }
    }

    override fun stop(context: ActionContext) {
        if (context.self.condition()) {
            this@conditional.stop(context)
        }
    }
}
