package xyz.qwewqa.relive.simulator.core.presets.song

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue
import xyz.qwewqa.relive.simulator.core.stage.song.SongEffect

object DexterityUpSongEffect : SongEffect {
    override val displayName = "Dexterity Up"

    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.valueDexterity += value
        }
    }

    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.valueDexterity -= value
        }
    }
}

object CriticalUpSongEffect : SongEffect {
    override val displayName = "Critical Up"

    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.valueCritical += value
        }
    }

    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.valueCritical -= value
        }
    }
}

data class DamageAgainstAttributeUpSongEffect(val attribute: Attribute) : SongEffect {
    override val name = "DamageAgainst${attribute.name}UpSongEffect"
    override val displayName = "Damage Against ${attribute.name} Up"

    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.againstAttributeDamageDealtUp[attribute] = (self.againstAttributeDamageDealtUp[attribute] ?: 0) + value.coerceAtMost(10)
        }
    }

    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.againstAttributeDamageDealtUp[attribute] = (self.againstAttributeDamageDealtUp[attribute] ?: 0) - value.coerceAtMost(10)
        }
    }
}


data class AttributeDamageDealtUpSongEffect(val attribute: Attribute) : SongEffect {
    override val name = "t${attribute.name}DamageUpSongEffect"
    override val displayName = "${attribute.name} Damage Up"

    override fun start(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.attributeDamageDealtUp[attribute] = (self.againstAttributeDamageDealtUp[attribute] ?: 0) + value.coerceAtMost(10)
        }
    }

    override fun end(context: ActionContext, value: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            self.attributeDamageDealtUp[attribute] = (self.againstAttributeDamageDealtUp[attribute] ?: 0) - value.coerceAtMost(10)
        }
    }
}
