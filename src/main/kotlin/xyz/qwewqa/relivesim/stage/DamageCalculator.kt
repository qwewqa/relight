package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.character.DamageType
import kotlin.math.ceil

interface DamageCalculator {
    fun calculate(
        stage: Stage,
        attacker: StageGirl,
        target: StageGirl,
        modifier: Percent,
        hitCount: Int = 1,
        overrideAttribute: Attribute? = null,
    ): DamageResult
}

class StandardDamageCalculator : DamageCalculator {
    override fun calculate(
        stage: Stage,
        attacker: StageGirl,
        target: StageGirl,
        modifier: Percent,
        hitCount: Int,
        overrideAttribute: Attribute?,
    ): DamageResult {
        val atk = 2.0 * attacker.actPower.get().toInt() * modifier * (if (attacker.inCX) 1.1 else 1.0)
        val def = when (attacker.loadout.data.damageType) {
            DamageType.Normal -> target.normalDefense.get()
            DamageType.Special -> target.specialDefense.get()
            else -> 0.0
        }.toInt()
        val attribute = overrideAttribute ?: attacker.loadout.data.attribute
        val eleCoef = target.loadout.data.effectivenessTable.getValue(attribute).toPercent()
        val effEleCoef = 100.percent + if (eleCoef > 100.percent) attacker.effectiveDamage.get() else 0.percent
        val critCoef = 100.percent + attacker.critical.get().coerceAtLeast(0.percent)
        val dex = attacker.dexterity.get().coerceIn(0.percent, 100.percent)
        val acc = (100.percent + attacker.accuracy.get() - target.evasion.get()).coerceIn(0.percent, 100.percent) *
                if (attacker.blindCounter > 0) 30.percent else 100.percent
        val dmgDealtCoef = (100.percent + attacker.damageDealtUp.get() - target.damageTakenDown.get())
            .coerceAtLeast(0.percent)
        var markFactor = 100.percent
        if (target.markCounter > 0) {
            markFactor += 30.percent
        }
        if (target.antiMarkCounter > 0) {
            markFactor -= 30.percent
        }
        // cx damage up
        val bonusCoef = 100.percent + attacker.eventBonus
        val atkFactor = (atk.toInt() / hitCount)
        val defFactor = (def.toInt() / hitCount)
        var baseDmg = (atkFactor - defFactor).coerceAtLeast(atkFactor / 10)
        baseDmg += (baseDmg * (dmgDealtCoef - 100.percent)).toInt()
        baseDmg += (baseDmg * (effEleCoef - 100.percent)).toInt()
        baseDmg += (baseDmg * (eleCoef - 100.percent)).toInt()
        baseDmg += (baseDmg * (markFactor - 100.percent)).toInt()
        baseDmg += (baseDmg * (bonusCoef - 100.percent)).toInt()
        val criticalDmg = (baseDmg * critCoef).toInt()
        return DamageResult(
            base = baseDmg,
            critical = criticalDmg,
            criticalChance = dex.toDouble(),
            hitChance = acc.toDouble(),
        )
    }
}

class LoggingDamageCalculator(private val calculator: DamageCalculator = StandardDamageCalculator()) :
    DamageCalculator {
    override fun calculate(
        stage: Stage,
        attacker: StageGirl,
        target: StageGirl,
        modifier: Percent,
        hitCount: Int,
        overrideAttribute: Attribute?,
    ): DamageResult {
        return calculator.calculate(stage, attacker, target, modifier, hitCount, overrideAttribute).apply {
            stage.log("DamageCalculator") {
                "[${attacker.loadout.data.displayName}] attacks [${target.loadout.data.displayName}]\n" +
                        "Info: { base: $base, critical: $critical, criticalChance: $criticalChance, hitChance: $hitChance }\n" +
                        "Possible base rolls: ${possibleRolls(false)}\n" +
                        "Possible critical rolls: ${possibleRolls(true)}"
            }
        }
    }
}

data class DamageResult(
    val base: Int,
    val critical: Int,
    val criticalChance: Double,
    val hitChance: Double,
) {
    fun possibleRolls(critical: Boolean = false) = (-8..8).map {
        ((if (critical) this.critical else this.base) * (1.0 + it / 100.0)).toInt()
    }
}
