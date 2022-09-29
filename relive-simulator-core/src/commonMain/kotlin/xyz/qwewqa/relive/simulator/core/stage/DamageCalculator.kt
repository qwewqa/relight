package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.actor.getEffectiveCoef
import xyz.qwewqa.relive.simulator.core.stage.buff.NormalBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SpecialBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import kotlin.math.floor

interface DamageCalculator {
    fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute)
}

class RandomDamageCalculator : DamageCalculator {
    override fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute): Unit = attacker.context.run {
        if (!attacker.isAlive) return@run
        log(
            "Hit",
            category = LogCategory.DAMAGE,
            debug = true
        ) { "[${attacker.name}] attempts to hit [${target.name}]." }
        actionLog.attemptedHit = true

        val result = calculateDamage(attacker, target, hitAttribute)
        result.apply {
            log(
                "DamageCalculator",
                summary = { "[${attacker.name}] attacks [${target.name}]." },
                category = LogCategory.DAMAGE
            ) {
                "Base: $base, Critical: $critical, Critical Chance: $criticalChance, Hit Chance: $hitChance.\n" +
                        "Possible base rolls: ${possibleRolls(false)}.\n" +
                        "Possible critical rolls: ${possibleRolls(true)}."
            }
        }
        if (target.buffs.tryRemove(CountableBuff.Evasion)) {
            if (self.perfectAimCounter <= 0 && !hitAttribute.focus) {
                log("Hit", category = LogCategory.DAMAGE) { "Miss against [${target.name}] from Evade." }
                return@run
            }
        }
        if (self.perfectAimCounter > 0 || hitAttribute.focus || stage.random.nextDouble() < result.hitChance) {
            val n = if (result.variance) stage.random.nextInt(-8, 9) else 0
            val isCritical = stage.random.nextDouble() < result.criticalChance
            val damage = if (isCritical) {
                result.critical.toDouble() * (100 + n) / 100
            } else {
                result.base.toDouble() * (100 + n) / 100
            }.toInt()
            val reflect = when (hitAttribute.damageType) {
                DamageType.Normal -> target.normalReflect
                DamageType.Special -> target.specialReflect
                DamageType.Neutral -> 0
            }
            attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                "Landed hit against [${target.name}]."
            }
            attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                "Damage roll: $damage (critical: $isCritical, varianceRoll: $n)."
            }
            val reflected = if (hitAttribute.focus || hitAttribute.noReflect) 0 else damage * reflect / 100
            val unreflected = damage - reflected
            if (reflected > 0) attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                "Unreflected: $unreflected, Reflected: $reflected."
            }
            var afterBarrier = unreflected
            if (!hitAttribute.focus) {
                when (hitAttribute.damageType) {
                    DamageType.Normal -> NormalBarrierBuff
                    DamageType.Special -> SpecialBarrierBuff
                    else -> null
                }?.let { barrierEffectType ->
                    val barriers = target.buffs.get(barrierEffectType)
                    if (barriers.isNotEmpty()) {
                        for (barrier in barriers) {
                            if (barrier.value > afterBarrier) {
                                attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                                    "Blocked by barrier (damage: $afterBarrier barrierStart: ${barrier.value}, barrierAfter: ${barrier.value - afterBarrier})."
                                }
                                barrier.value -= afterBarrier
                                afterBarrier = 0
                                break
                            } else {
                                attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                                    "Destroys barrier (damage: $afterBarrier, after: ${afterBarrier - barrier.value}, barrier: ${barrier.value})."
                                }
                                afterBarrier -= barrier.value
                                target.buffs.remove(barrier)
                            }
                        }
                    }
                }
            }
            target.damage(afterBarrier, additionalEffects = hitAttribute.addBrilliance)
            if (attacker.context.team != target.context.team) {
                actionLog.damageDealtToEnemy += afterBarrier
            }
            if (reflected > 0) {
                self.damage(reflected, additionalEffects = false)
            }
            if (self.absorb > 0) {
                self.heal(afterBarrier * self.absorb / 100)
            }
            actionLog.successfulHits++
        } else {
            attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                "Miss against [${target.name}]."
            }
        }
    }

    fun calculateDamage(attacker: Actor, target: Actor, hitAttribute: HitAttribute): DamageResult {
        val acc = (100 + attacker.accuracy - target.evasion).coerceIn(0, 100) *
                (if (attacker.isBlinded) 0.3 else 1.0)

        if (target.isInvincible) {
            // Critical chance isn't actually 0 against invincible targets, but
            // it doesn't matter, so we'll skip calculating it.
            return DamageResult(0, 0, 0.0, acc / 100.0, false)
        } else if (hitAttribute.mode == HitMode.FIXED) {
            return DamageResult(
                base = hitAttribute.modifier / hitAttribute.hitCount,
                critical = hitAttribute.modifier / hitAttribute.hitCount,
                criticalChance = 0.0,
                hitChance = acc / 100.0,
                variance = false,
            )
        }

        val base: Int

        if (hitAttribute.mode == HitMode.ELEMENTAL_FIXED) {
            base = hitAttribute.modifier / hitAttribute.hitCount
        } else {
            var atk = attacker.actPower
            if (attacker.inCX) atk = atk * 110 / 100
            atk = atk * 2 * hitAttribute.modifier / 100

            val def = when (attacker.dress.damageType) {
                DamageType.Normal -> target.normalDefense
                DamageType.Special -> target.specialDefense
                else -> 0
            }.coerceAtLeast(0)

            base = (atk - def).coerceAtLeast(atk / 10) / hitAttribute.hitCount
        }

        val bonusCoef = if (hitAttribute.bonusCondition != null && hitAttribute.bonusCondition.evaluate(target)) {
            hitAttribute.bonusModifier
        } else {
            100
        }

        val attribute = hitAttribute.attribute
        val eleCoef = getEffectiveCoef(attribute, target.dress.attribute)
        val effEleCoef = if (eleCoef > 100) {
            100 + attacker.effectiveDamageUp
        } else {
            100
        }

        val critCoef = 100 + attacker.critical
        val dex = attacker.dexterity

        val dmgDealtUp = (attacker.damageDealtUp +
                attacker.conditionalDamageDealtUp.filter { (cond, _) -> cond.evaluate(target) }.sumOf { (_, v) -> v })
            .coerceAtLeast(0)
        val dmgDealtDownCoef = (100 - target.damageTakenDown).coerceAtLeast(0)

        // tentative
        var buffDmgTakenDownCoef = (100 - (target.damageTakenDownBuff).coerceAtMost(50) - target.damageTakenDownDebuff)
        if (target.buffs.any(CountableBuff.WeakSpot)) buffDmgTakenDownCoef += 60
        val buffDmgDealtUpCoef = 100 + attacker.damageDealtUpBuff + dmgDealtUp

        val attributeDamageDealtUpCoef = 100 + attacker.attributeDamageDealtUp[attribute]
        val againstAttributeDamageDealtUpCoef =
            100 + attacker.againstAttributeDamageDealtUp[target.dress.attribute]
        val targetAgainstAttributeDamageTakenDownCoef = (100 - target.againstAttributeDamageTakenDown[attribute]).coerceAtLeast(50)
        val targetInnateAgainstAttributeDamageTakenDownCoef =
            100 - target.innateAgainstAttributeDamageTakenDown[attribute]

        val freezeCoef = if (target.isFrozen) 130 else 100

        // cx damage up
        val cxDmgCoef = if (attacker.inCXAct) {
            100 + attacker.climaxDamageUp
        } else {
            100
        }

        val eventBonusCoef = 100 + attacker.eventBonus
        val eventMultiplier = attacker.eventMultiplier
        
        infix fun Double.pfmul(other: Int) = floor(this * other / 100.0)

        var dmg = base.toDouble()
        dmg = dmg pfmul eleCoef
        dmg = dmg pfmul effEleCoef
        dmg = dmg pfmul attributeDamageDealtUpCoef
        dmg = dmg pfmul againstAttributeDamageDealtUpCoef
        dmg = dmg pfmul bonusCoef  // tentative
        dmg = dmg pfmul eventBonusCoef
        dmg = dmg pfmul targetAgainstAttributeDamageTakenDownCoef // tentative
        dmg = dmg pfmul targetInnateAgainstAttributeDamageTakenDownCoef
        dmg = dmg pfmul freezeCoef
//        dmg = dmg pfmul dmgDealtUpCoef
        dmg = dmg pfmul cxDmgCoef
        dmg = dmg pfmul dmgDealtDownCoef
        dmg = dmg pfmul buffDmgTakenDownCoef
        dmg = dmg pfmul buffDmgDealtUpCoef
        dmg = dmg pfmul eventMultiplier // tentative

        var criticalDmg = base.toDouble()
        criticalDmg = criticalDmg pfmul eleCoef
        criticalDmg = criticalDmg pfmul effEleCoef
        criticalDmg = criticalDmg pfmul critCoef
        criticalDmg = criticalDmg pfmul attributeDamageDealtUpCoef
        criticalDmg = criticalDmg pfmul againstAttributeDamageDealtUpCoef
        criticalDmg = criticalDmg pfmul bonusCoef  // tentative
        criticalDmg = criticalDmg pfmul eventBonusCoef
        criticalDmg = criticalDmg pfmul targetAgainstAttributeDamageTakenDownCoef // tentative
        criticalDmg = criticalDmg pfmul targetInnateAgainstAttributeDamageTakenDownCoef
        criticalDmg = criticalDmg pfmul freezeCoef
//        criticalDmg = criticalDmg pfmul dmgDealtUpCoef
        criticalDmg = criticalDmg pfmul cxDmgCoef
        criticalDmg = criticalDmg pfmul dmgDealtDownCoef
        criticalDmg = criticalDmg pfmul buffDmgTakenDownCoef
        criticalDmg = criticalDmg pfmul buffDmgDealtUpCoef
        criticalDmg = criticalDmg pfmul eventMultiplier

        return DamageResult(
            base = dmg.toInt(),
            critical = criticalDmg.toInt(),
            criticalChance = dex / 100.0,
            hitChance = acc / 100.0,
            variance = true,
        )
    }
}

data class DamageResult(
    val base: Int,
    val critical: Int,
    val criticalChance: Double,
    val hitChance: Double,
    val variance: Boolean,
) {
    fun possibleRolls(critical: Boolean = false) = if (variance) {
        (-8..8).map {
            ((if (critical) this.critical else this.base).toDouble() * (100 + it) / 100).toInt()
        }
    } else {
        listOf(if (critical) this.critical else this.base)
    }
}


data class HitAttribute(
    val modifier: Int = 0,
    val hitCount: Int = 1,
    val attribute: Attribute = Attribute.Neutral,
    val damageType: DamageType = DamageType.Neutral,
    val bonusModifier: Int = 100,
    val bonusCondition: Condition? = null,
    val addBrilliance: Boolean = true,
    val focus: Boolean = false,
    val noReflect: Boolean = false,
    val noVariance: Boolean = false,
    val mode: HitMode = HitMode.NORMAL,
)

enum class HitMode {
    NORMAL,
    FIXED,
    ELEMENTAL_FIXED,
}
