package xyz.qwewqa.relive.simulator.stage.song

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.condition.Condition

object DexterityUpSongEffect : SongEffect {
    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.valueDexterity += value
    }
    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.valueDexterity -= value
    }
}

object CriticalUpSongEffect : SongEffect {
    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.valueCritical += value
    }
    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.valueCritical -= value
    }
}

data class DamageAgainstAttributeUpSongEffect(val attribute: Attribute) : SongEffect {
    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.againstAttributeDamageDealtUp[attribute] = (self.againstAttributeDamageDealtUp[attribute] ?: 0) + value
    }
    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        self.againstAttributeDamageDealtUp[attribute] = (self.againstAttributeDamageDealtUp[attribute] ?: 0) - value
    }
}
