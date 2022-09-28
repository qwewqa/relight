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
                result.critical.toLong() * (100 + n) / 100
            } else {
                result.base.toLong() * (100 + n) / 100
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

        val base: Long

        if (hitAttribute.mode == HitMode.ELEMENTAL_FIXED) {
            base = hitAttribute.modifier.toLong() / hitAttribute.hitCount
        } else {
            var atk = attacker.actPower.toLong()
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

        val attributeDamageDealtUpCoef = 100 + attacker.attributeDamageDealtUp.getValue(attribute)
        val againstAttributeDamageDealtUpCoef =
            100 + attacker.againstAttributeDamageDealtUp.getValue(target.dress.attribute)
        val targetAgainstAttributeDamageTakenDownCoef = (100 - target.againstAttributeDamageTakenDown.getValue(attribute)).coerceAtLeast(50)
        val targetInnateAgainstAttributeDamageTakenDownCoef =
            100 - target.innateAgainstAttributeDamageTakenDown.getValue(attribute)

        val freezeCoef = if (target.isFrozen) 130 else 100

        // cx damage up
        val cxDmgCoef = if (attacker.inCXAct) {
            100 + attacker.climaxDamageUp
        } else {
            100
        }

        val eventBonusCoef = 100 + attacker.eventBonus
        val eventMultiplier = attacker.eventMultiplier

        var dmg = base
        dmg = dmg * eleCoef / 100
        dmg = dmg * effEleCoef / 100
        dmg = dmg * attributeDamageDealtUpCoef / 100
        dmg = dmg * againstAttributeDamageDealtUpCoef / 100
        dmg = dmg * bonusCoef / 100  // tentative
        dmg = dmg * eventBonusCoef / 100
        dmg = dmg * targetAgainstAttributeDamageTakenDownCoef / 100 // tentative
        dmg = dmg * targetInnateAgainstAttributeDamageTakenDownCoef / 100
        dmg = dmg * freezeCoef / 100
//        dmg = dmg * dmgDealtUpCoef / 100
        dmg = dmg * cxDmgCoef / 100
        dmg = dmg * dmgDealtDownCoef / 100
        dmg = dmg * buffDmgTakenDownCoef / 100
        dmg = dmg * buffDmgDealtUpCoef / 100
        dmg = dmg * eventMultiplier / 100 // tentative

        var criticalDmg = base
        criticalDmg = criticalDmg * eleCoef / 100
        criticalDmg = criticalDmg * effEleCoef / 100
        criticalDmg = criticalDmg * critCoef / 100
        criticalDmg = criticalDmg * attributeDamageDealtUpCoef / 100
        criticalDmg = criticalDmg * againstAttributeDamageDealtUpCoef / 100
        criticalDmg = criticalDmg * bonusCoef / 100  // tentative
        criticalDmg = criticalDmg * eventBonusCoef / 100
        criticalDmg = criticalDmg * targetAgainstAttributeDamageTakenDownCoef / 100 // tentative
        criticalDmg = criticalDmg * targetInnateAgainstAttributeDamageTakenDownCoef / 100
        criticalDmg = criticalDmg * freezeCoef / 100
//        criticalDmg = criticalDmg * dmgDealtUpCoef / 100
        criticalDmg = criticalDmg * cxDmgCoef / 100
        criticalDmg = criticalDmg * dmgDealtDownCoef / 100
        criticalDmg = criticalDmg * buffDmgTakenDownCoef / 100
        criticalDmg = criticalDmg * buffDmgDealtUpCoef / 100
        criticalDmg = criticalDmg * eventMultiplier / 100

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
            ((if (critical) this.critical else this.base).toLong() * (100 + it) / 100).toInt()
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
