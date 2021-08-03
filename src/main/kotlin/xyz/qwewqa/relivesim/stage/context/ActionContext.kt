package xyz.qwewqa.relivesim.stage.context

import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.TimedEffect
import xyz.qwewqa.relivesim.stage.team.Team
import kotlin.math.log

data class ActionContext(
    val self: StageGirl,
    val stage: Stage,
    val team: Team,
    val enemies: Team,
) {
    private fun List<StageGirl>.targetContext() = TargetContext(this@ActionContext, this)

    inline fun StageGirl.act(action: TargetContext.() -> Unit) =
        TargetContext(this@ActionContext, listOf(this)).act(action)

    fun targetSelf() = listOf(self).targetContext()
    fun targetFront(count: Int = 1) = enemies.active.take(count).targetContext()
    fun targetBack(count: Int = 1) = enemies.active.takeLast(count).targetContext()
    fun targetAoe() = enemies.active.targetContext()
    fun targetTeamAoe() = team.active.targetContext()

    fun targetHighestAct(count: Int = 1) = targetHighest(count) { it.actPower.get() }
    fun <T : Comparable<T>> targetHighest(count: Int = 1, condition: (StageGirl) -> T) =
        enemies.active.sortedBy(condition).take(count).targetContext()

    fun Team.forEach(action: (StageGirl) -> Unit) = active.forEach(action)
}

class TargetContext(val actionContext: ActionContext, val targets: List<StageGirl>) {
    val stage get() = actionContext.stage
    val self = actionContext.self

    inline fun act(action: TargetContext.() -> Unit) = run(action)

    fun attack(
        modifier: Percent,
        hitCount: Int = 1,
        bonusMultiplier: Double = 1.0,
        bonusCondition: StageGirl.() -> Boolean = { false },
        overrideAttribute: Attribute? = null,
    ) {
        if (!self.isAlive) return
        repeat(hitCount) {
            targets.forEach { target ->
                stage.hit(
                    self,
                    target,
                    if (bonusCondition(target)) modifier * bonusMultiplier.toPercent() else modifier,
                    hitCount,
                    overrideAttribute,
                )
            }
        }
    }

    fun applyEffects(vararg effectFactories: () -> TimedEffect, chance: Percent = 100.percent) {
        effectFactories.forEach {
            applyEffect(chance, it)
        }
    }

    fun applyEffect(chance: Percent = 100.percent, effectFactory: () -> TimedEffect)  {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                val effect = effectFactory()
                when (effect.effectClass) {
                    EffectClass.Positive -> {
                        if (positiveEffectBlockCounter > 0) {
                            stage.log("Effect") { "[$this]: Positive effect $effect blocked" }
                        }
                        val applyChance = chance * (100.percent - positiveEffectResist.value)
                        if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                            effects.add(effect)
                            stage.log("Effect") { "[$this]: Positive effect $effect applied" }
                        } else {
                            stage.log("Effect") { "[$this]: Positive effect $effect missed" }
                        }
                    }
                    EffectClass.Negative -> {
                        if (negativeEffectBlockCounter > 0) {
                            stage.log("Effect") { "[$this]: Negative effect $effect blocked" }
                        }
                        val applyChance = chance * (100.percent - negativeEffectResist.value)
                        if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                            effects.add(effect)
                            stage.log("Effect") { "[$this]: Negative effect $effect applied" }
                        } else {
                            stage.log("Effect") { "[$this]: Negative effect $effect missed" }
                        }
                    }
                }
            }
        }
    }

    fun dispelTimed(effectClass: EffectClass) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Dispel") { "[$self] dispels ${effectClass.name} effects from [$this]" }
                effects.dispelTimed(effectClass)
            }
        }
    }

    fun heal(percent: Percent = 0.percent, fixed: Int = 0) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Heal") { "[$self] heals [$this] (percent: $percent, fixed: $fixed)" }
                stage.heal(this, fixed + (percent * maxHp.get().toInt()).toInt())
            }
        }
    }

    fun addBrilliance(amount: Int) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Brilliance") { "[$self] gives brilliance to [$this] (amount: $amount)" }
                stage.addBrilliance(this, amount)
            }
        }
    }

    fun removeBrilliance(amount: Int) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Brilliance") { "[$self] removes brilliance from [$this] (amount: $amount)" }
                stage.addBrilliance(this, -amount)
            }
        }
    }
}
