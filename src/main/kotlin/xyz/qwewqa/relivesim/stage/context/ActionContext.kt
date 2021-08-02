package xyz.qwewqa.relivesim.stage.context

import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.TimedEffect
import xyz.qwewqa.relivesim.stage.team.Team

data class ActionContext(
    val self: CharacterState,
    val stage: Stage,
    val team: Team,
    val enemies: Team,
    val isCXAct: Boolean = false,
) {
    fun targetSelf() = listOf(self)
    fun targetFront() = enemies.active.firstOrNull()?.let { listOf(it) } ?: emptyList()
    fun targetBack() = enemies.active.lastOrNull()?.let { listOf(it) } ?: emptyList()
    fun targetAoe() = enemies.active
    fun targetTeamAoe() = team.active

    fun targetHighestAct(count: Int = 1) = targetHighest { it.actPower.get() }
    fun <T : Comparable<T>> targetHighest(count: Int = 1, condition: (CharacterState) -> T) =
        enemies.active.sortedBy(condition).take(count)

    val CharacterState.damageType get() = loadout.data.damageType

    inline fun Percent.conditionalMultiplier(value: Double, condition: () -> Boolean): Percent =
        if (condition()) this * value.toPercent() else this

    inline fun List<CharacterState>.act(action: CharacterState.() -> Unit) = forEach(action)

    fun CharacterState.attack(
        modifier: Percent,
        hitCount: Int = 1,
        inCX: Boolean? = null,
        overrideAttribute: Attribute? = null,
    ) {
        stage.log("Attack") { "[$self] attacks [$this] (modifier: $modifier, hitCount: $hitCount, inCX: $inCX, overrideAttribute: $overrideAttribute)" }
        repeat(hitCount) {
            stage.hit(
                self,
                this,
                modifier,
                hitCount,
                inCX ?: isCXAct,
                overrideAttribute,
            )
        }
    }

    fun CharacterState.heal(
        percent: Percent = 0.percent,
        fixed: Int = 0,
    ) {
        stage.log("Heal") { "[$self] heals [$this] (percent: $percent, fixed: $fixed)" }
        stage.heal(this, fixed + (percent * maxHp.get().toInt()).toInt())
    }

    fun CharacterState.addBrilliance(amount: Int) {
        stage.log("Brilliance") { "[$self] gives brilliance to [$this] (amount: $amount)" }
        stage.addBrilliance(this, amount)
    }

    fun CharacterState.removeBrilliance(amount: Int) {
        stage.log("Brilliance") { "[$self] removes brilliance from [$this] (amount: $amount)" }
        stage.addBrilliance(this, -amount)
    }

    fun Team.forEach(action: (CharacterState) -> Unit) = team.active.forEach(action)
    fun CharacterState.applyEffects(vararg effects: TimedEffect, chance: Percent = 100.percent) {
        effects.forEach {
            applyEffect(it, chance)
        }
    }

    fun CharacterState.applyEffect(effect: TimedEffect, chance: Percent = 100.percent) {
        stage.log("Effect") { "[$self] applies effect [$effect] to [$this] " }
        when (effect.effectClass) {
            EffectClass.Positive -> {
                if (positiveEffectBlockCounter > 0) {
                    stage.log("Effect") { "[$this]: Positive Effect [$effect] blocked" }
                }
                val applyChance = chance * (100.percent - positiveEffectResist.value)
                if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                    effects.add(effect)
                    stage.log("Effect") { "[$this]: Positive Effect [$effect] applied" }
                } else {
                    stage.log("Effect") { "[$this]: Positive Effect [$effect] missed" }
                }
            }
            EffectClass.Negative -> {
                if (negativeEffectBlockCounter > 0) {
                    stage.log("Effect") { "[$this]: Negative Effect [$effect] blocked" }
                }
                val applyChance = chance * (100.percent - negativeEffectResist.value)
                if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                    effects.add(effect)
                    stage.log("Effect") { "[$this]: Negative Effect [$effect] applied" }
                } else {
                    stage.log("Effect") { "[$this]: Negative Effect [$effect] missed" }
                }
            }
        }
    }
}
