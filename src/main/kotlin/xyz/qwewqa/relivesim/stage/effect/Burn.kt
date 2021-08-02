package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.context.ActionContext
import kotlin.properties.Delegates

class Burn(
    override var turns: Int,
    val fixedDamage: Int = 0,
    val percentDamage: Percent = 0.percent,
    override val locked: Boolean = false,
) : TimedEffect {
    override fun toString() = "Burn(turns = $turns, fixedDamage = $fixedDamage, percentDamage = $percentDamage)"

    override val effectClass = EffectClass.Negative
    override val effectType = EffectType.Burn

    var damage by Delegates.notNull<Int>()

    override fun start(context: ActionContext) = context.run {
        damage = fixedDamage + (self.maxHp.get() * percentDamage).toInt()
        if (self.burnCounter == 0) {
            self.actPower.buff -= 10.percent
        }
        self.burnCounter++
        self.burnTick += damage
    }

    override fun stop(context: ActionContext) = context.run {
        self.burnCounter--
        self.burnTick -= damage
        if (self.burnCounter == 0) {
            self.actPower.buff += 10.percent
        }
    }
}