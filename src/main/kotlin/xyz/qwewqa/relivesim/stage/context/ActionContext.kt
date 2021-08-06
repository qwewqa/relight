package xyz.qwewqa.relivesim.stage.context

import xyz.qwewqa.relivesim.dsl.StageDslMarker
import xyz.qwewqa.relivesim.presets.effect.BarrierTimedEffect
import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.EffectType
import xyz.qwewqa.relivesim.stage.effect.StackedEffect
import xyz.qwewqa.relivesim.stage.effect.TimedEffect
import xyz.qwewqa.relivesim.stage.team.Team

@StageDslMarker
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
    fun targetAllyAoe() = team.active.targetContext()
    fun targetAllyFront(count: Int = 1) = team.active.take(count).targetContext()
    fun targetAllyRandom(count: Int = 1) = List(count) { team.active.random(stage.random) }.targetContext()

    fun targetHighestAct(count: Int = 1) = targetHighest(count) { it.actPower.value }
    fun <T : Comparable<T>> targetHighest(count: Int = 1, condition: (StageGirl) -> T) =
        enemies.active.sortedBy(condition).take(count).targetContext()

    fun Team.forEach(action: (StageGirl) -> Unit) = active.forEach(action)
}

@StageDslMarker
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
                hit(
                    target,
                    if (bonusCondition(target)) modifier * bonusMultiplier.toPercent() else modifier,
                    hitCount,
                    overrideAttribute,
                )
            }
        }
    }

    private fun hit(
        target: StageGirl,
        modifier: Percent,
        hitCount: Int,
        overrideAttribute: Attribute? = null,
    ) {
        stage.log("Hit") { "[${self.loadout.data.displayName}] attempts to hit [${target.loadout.data.displayName}]" }
        val result = stage.damageCalculator.calculate(stage, self, target, modifier, hitCount, overrideAttribute)
        if (target.effects.get(StackedEffect.Evade) > 0) {
            target.effects.removeStacked(StackedEffect.Evade)
            if (self.perfectAimCounter <= 0) {
                stage.log("Hit") { "Miss from Evade" }
            }
        }
        if (stage.random.nextDouble() < result.hitChance) {
            val n = stage.random.nextInt(-8, 9)
            val isCritical = stage.random.nextDouble() < result.criticalChance
            val damage = if (isCritical) {
                result.critical * (100 + n) / 100
            } else {
                result.base * (100 + n) / 100
            }
            val reflect = when (self.loadout.data.damageType) {
                DamageType.Normal -> target.normalReflect.value
                DamageType.Special -> target.specialReflect.value
                DamageType.NeutralDamage -> 0.percent
            }
            stage.log("Hit") { "Damage roll: $damage (critical: $isCritical, varianceRoll: $n)" }
            val reflected = (damage * reflect).toInt()
            val unreflected = damage - reflected
            if (reflected > 0) stage.log("Hit") { "Unreflected: $unreflected, Reflected: $reflected" }
            var afterBarrier = unreflected
            when (self.loadout.data.damageType) {
                DamageType.Normal -> EffectType.NormalBarrier
                DamageType.Special -> EffectType.SpecialBarrier
                else -> null
            }?.let { barrierEffectType ->
                val barriers = target.effects.get(barrierEffectType)
                if (barriers.isNotEmpty()) {
                    for (barrier in barriers.filterIsInstance<BarrierTimedEffect>()) {
                        if (barrier.value > afterBarrier) {
                            stage.log("Hit") { "Blocked by barrier (damage: $afterBarrier barrierStart: ${barrier.value}, barrierAfter: ${barrier.value - afterBarrier})" }
                            barrier.value -= afterBarrier
                            afterBarrier = 0
                            break
                        } else {
                            stage.log("Hit") { "Destroys barrier (damage: $afterBarrier, after: $afterBarrier, barrier: ${barrier.value})" }
                            afterBarrier -= barrier.value
                            target.effects.removeTimed(barrier)
                        }
                    }
                }
            }
            target.damage(afterBarrier, DamageType.NeutralDamage)
            if (reflected > 0) {
                self.damage(reflected, self.loadout.data.damageType, isDirect = false)
            }
        } else {
            stage.log("Hit") { "Miss" }
        }
    }

    fun applyEffects(vararg effectFactories: () -> TimedEffect, chance: Percent = 100.percent) {
        effectFactories.forEach {
            applyEffect(chance, it)
        }
    }

    fun applyEffect(chance: Percent = 100.percent, effectFactory: () -> TimedEffect) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                val effect = effectFactory()
                when (effect.effectClass) {
                    EffectClass.Positive -> {
                        val applyChance = chance * (100.percent - positiveEffectResist.value)
                        if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                            effects.add(effect)
                            stage.log("Effect") { "[$this]: Positive effect [$effect] applied" }
                        } else {
                            stage.log("Effect") { "[$this]: Positive effect [$effect] missed" }
                        }
                    }
                    EffectClass.Negative -> {
                        val applyChance = chance * (100.percent - negativeEffectResist.value)
                        if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                            effects.add(effect)
                            stage.log("Effect") { "[$this]: Negative effect [$effect] applied" }
                        } else {
                            stage.log("Effect") { "[$this]: Negative effect [$effect] missed" }
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
                this.heal(fixed + (percent * maxHp.value).toInt())
            }
        }
    }

    fun addBrilliance(amount: Int) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Brilliance") { "[$self] gives brilliance to [$this] (amount: $amount)" }
                this.addBrilliance(amount)
            }
        }
    }

    fun removeBrilliance(amount: Int) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Brilliance") { "[$self] removes brilliance from [$this] (amount: $amount)" }
                this.addBrilliance(-amount)
            }
        }
    }
}
