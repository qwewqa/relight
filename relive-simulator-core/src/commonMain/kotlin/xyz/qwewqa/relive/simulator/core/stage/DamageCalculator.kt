package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.actor.effectiveCoefTable
import xyz.qwewqa.relive.simulator.core.stage.buff.BlindnessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.FreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NormalBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SpecialBarrierBuff

interface DamageCalculator {
    fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute)
}

class RandomDamageCalculator : DamageCalculator {
    override fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute): Unit = attacker.context.run {
        log("Hit") { "[${attacker.name}] attempts to hit [${target.name}]" }
        val result = calculateDamage(attacker, target, hitAttribute)
        result.apply {
            log("DamageCalculator") {
                "[${attacker.name}] attacks [${target.name}]\n" +
                        "Info: { base: $base, critical: $critical, criticalChance: $criticalChance, hitChance: $hitChance }\n" +
                        "Possible base rolls: ${possibleRolls(false)}\n" +
                        "Possible critical rolls: ${possibleRolls(true)}"
            }
        }
        if (target.buffs.tryRemove(CountableBuff.Evasion)) {
            if (self.perfectAimCounter <= 0 && !hitAttribute.focus) {
                log("Hit") { "Miss from Evade" }
                return@run
            }
        }
        if (self.perfectAimCounter > 0 || hitAttribute.focus || stage.random.nextDouble() < result.hitChance) {
            val n = if (hitAttribute.noVariance) 0 else stage.random.nextInt(-8, 9)
            val isCritical = stage.random.nextDouble() < result.criticalChance
            val damage = if (isCritical) {
                result.critical * (100 + n) / 100
            } else {
                result.base * (100 + n) / 100
            }
            val reflect = when (hitAttribute.damageType) {
                DamageType.Normal -> target.normalReflect
                DamageType.Special -> target.specialReflect
                DamageType.Neutral -> 0
            }
            attacker.context.log("Hit") { "Damage roll: $damage (critical: $isCritical, varianceRoll: $n)" }
            val reflected = if (hitAttribute.focus || hitAttribute.noReflect) 0 else damage * reflect / 100
            val unreflected = damage - reflected
            if (reflected > 0) attacker.context.log("Hit") { "Unreflected: $unreflected, Reflected: $reflected" }
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
                                attacker.context.log("Hit") { "Blocked by barrier (damage: $afterBarrier barrierStart: ${barrier.value}, barrierAfter: ${barrier.value - afterBarrier})" }
                                barrier.value -= afterBarrier
                                afterBarrier = 0
                                break
                            } else {
                                attacker.context.log("Hit") { "Destroys barrier (damage: $afterBarrier, after: ${afterBarrier - barrier.value}, barrier: ${barrier.value})" }
                                afterBarrier -= barrier.value
                                target.buffs.remove(barrier)
                            }
                        }
                    }
                }
            }
            target.damage(afterBarrier, additionalEffects = hitAttribute.addBrilliance)
            if (reflected > 0) {
                self.damage(reflected, additionalEffects = false)
            }
        } else {
            attacker.context.log("Hit") { "Miss" }
            return@run
        }
        hitAttribute.removeOnConnect?.let {
            if (attacker.isAlive) {
                attacker.buffs.remove(it)
            }
        }
    }

    fun calculateDamage(attacker: Actor, target: Actor, hitAttribute: HitAttribute): DamageResult {
        var atk = attacker.actPower
        if (attacker.inCX) atk = atk * 110 / 100
        atk = atk * 2 * hitAttribute.modifier / 100

        val def = when (attacker.dress.damageType) {
            DamageType.Normal -> target.normalDefense
            DamageType.Special -> target.specialDefense
            else -> 0
        }.coerceAtLeast(0)

        val attribute = hitAttribute.attribute
        val eleCoef = effectiveCoefTable[attribute to target.dress.attribute]!!
        val effEleCoef = if (eleCoef > 100) {
            100 + attacker.effectiveDamageUp
        } else {
            100
        }

        val critCoef = 100 + attacker.critical
        val dex = attacker.dexterity

        val acc = (100 + attacker.accuracy - target.evasion).coerceIn(0, 100) *
                (if (attacker.buffs.any(BlindnessBuff)) 0.3 else 1.0)

        val dmgDealtCoef = (100 + attacker.damageDealtUp - target.damageTakenDown).coerceAtLeast(0)

        // tentative
        val buffDmgDealtUpCoef = 100 + attacker.damageDealtUpBuff
        val buffDmgTakenDownCoef = (100 - target.damageTakenDownBuff).coerceAtLeast(50)

        val attributeDamageDealtUpCoef = 100 + attacker.attributeDamageDealtUp.getValue(attribute)
        val againstAttributeDamageDealtUpCoef =
            100 + attacker.againstAttributeDamageDealtUp.getValue(target.dress.attribute)
        val targetAgainstAttributeDamageTakenDownCoef = 100 - target.againstAttributeDamageTakenDown.getValue(attribute)
        val targetInnateAgainstAttributeDamageTakenDownCoef =
            100 - target.innateAgainstAttributeDamageTakenDown.getValue(attribute)

        val freezeCoef = if (target.buffs.any(FreezeBuff)) 130 else 100

        // cx damage up
        val cxDmgCoef = if (attacker.inCXAct) {
            100 + attacker.climaxDamageUp
        } else {
            100
        }

        val bonusCoef = 100 + attacker.eventBonus
        val eventMultiplier = attacker.eventMultiplier

        val base = (atk - def).coerceAtLeast(atk / 10) / hitAttribute.hitCount

        var dmg = base
        dmg = dmg * eleCoef / 100
        dmg = dmg * effEleCoef / 100
        dmg = dmg * attributeDamageDealtUpCoef / 100
        dmg = dmg * hitAttribute.bonus / 100  // tentative
        dmg = dmg * bonusCoef / 100
        dmg = dmg * targetAgainstAttributeDamageTakenDownCoef / 100 // tentative
        dmg = dmg * targetInnateAgainstAttributeDamageTakenDownCoef / 100
        dmg = dmg * buffDmgDealtUpCoef / 100
        dmg = dmg * freezeCoef / 100
        dmg = dmg * dmgDealtCoef / 100
        dmg = dmg * cxDmgCoef / 100
        dmg = dmg * againstAttributeDamageDealtUpCoef / 100
        dmg = dmg * buffDmgTakenDownCoef / 100
        dmg = dmg * eventMultiplier / 100 // tentative

        var criticalDmg = base
        criticalDmg = criticalDmg * eleCoef / 100
        criticalDmg = criticalDmg * effEleCoef / 100
        criticalDmg = criticalDmg * critCoef / 100
        criticalDmg = criticalDmg * attributeDamageDealtUpCoef / 100
        criticalDmg = criticalDmg * hitAttribute.bonus / 100  // tentative
        criticalDmg = criticalDmg * bonusCoef / 100
        criticalDmg = criticalDmg * targetAgainstAttributeDamageTakenDownCoef / 100 // tentative
        criticalDmg = criticalDmg * targetInnateAgainstAttributeDamageTakenDownCoef / 100
        criticalDmg = criticalDmg * buffDmgDealtUpCoef / 100
        criticalDmg = criticalDmg * freezeCoef / 100
        criticalDmg = criticalDmg * dmgDealtCoef / 100
        criticalDmg = criticalDmg * cxDmgCoef / 100
        criticalDmg = criticalDmg * againstAttributeDamageDealtUpCoef / 100
        criticalDmg = criticalDmg * buffDmgTakenDownCoef / 100
        criticalDmg = criticalDmg * eventMultiplier / 100

        return DamageResult(
            base = dmg,
            critical = criticalDmg,
            criticalChance = dex / 100.0,
            hitChance = acc / 100.0,
        )
    }
}

data class DamageResult(
    val base: Int,
    val critical: Int,
    val criticalChance: Double,
    val hitChance: Double,
) {
    fun possibleRolls(critical: Boolean = false) = (-8..8).map {
        ((if (critical) this.critical else this.base) * (100 + it) / 100)
    }
}


data class HitAttribute(
    val modifier: Int = 0,
    val hitCount: Int = 1,
    val attribute: Attribute = Attribute.Neutral,
    val damageType: DamageType = DamageType.Neutral,
    val bonus: Int = 0,
    val addBrilliance: Boolean = true,
    val focus: Boolean = false,
    val noReflect: Boolean = false,
    val noVariance: Boolean = false,
    val removeOnConnect: CountableBuff?,
)
