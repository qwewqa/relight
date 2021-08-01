package xyz.qwewqa.relivesim.stage.activeeffects

import xyz.qwewqa.relivesim.stage.*
import kotlin.properties.Delegates

class Burn(
    override var turns: Int,
    val fixedDamage: Int = 0,
    val percentDamage: Percent = 0.percent,
    override val locked: Boolean = false,
) : CharacterEffect {
    override fun toString() = "Burn(turns = $turns, fixedDamage = $fixedDamage, percentDamage = $percentDamage)"

    override val effectClass = EffectClass.Negative
    override val effectType = EffectType.Burn

    var damage by Delegates.notNull<Int>()

    override fun start(target: CharacterState) {
        damage = fixedDamage + (target.maxHp.get() * percentDamage).toInt()
        if (target.burnCounter == 0) {
            target.actPower.buff -= 10.percent
        }
        target.burnCounter++
        target.burnTick += damage
    }

    override fun stop(target: CharacterState) {
        target.burnCounter--
        target.burnTick -= damage
        if (target.burnCounter == 0) {
            target.actPower.buff += 10.percent
        }
    }
}