package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.StageGirl

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
        var atk = 2 * attacker.actPower.get()
        if (attacker.inCX) atk = (atk * 110.percent).toInt()
        atk = (atk * modifier).toInt()

        var def = when (attacker.loadout.data.damageType) {
            DamageType.Normal -> target.normalDefense.get()
            DamageType.Special -> target.specialDefense.get()
            else -> 0
        }.coerceAtLeast(0)

        val attribute = overrideAttribute ?: attacker.loadout.data.attribute
        val eleCoef = target.loadout.data.effectivenessTable.getValue(attribute).toPercent()
        val effEleCoef = if (eleCoef > 100.percent) {
            100.percent + attacker.effectiveDamage.get()
        } else {
            100.percent
        }

        val critCoef = 100.percent + attacker.critical.get().coerceAtLeast(0.percent)
        val dex = attacker.dexterity.get().coerceIn(0.percent, 100.percent)

        val acc = (100.percent + attacker.accuracy.get() - target.evasion.get()).coerceIn(0.percent, 100.percent) *
                if (attacker.blindCounter > 0) 30.percent else 100.percent

        val dmgDealtCoef = (100.percent + attacker.damageDealtUp.get() - target.damageTakenDown.get())
            .coerceAtLeast(0.percent)

        // tentative
        var buffDmgDealtCoef = (100.percent + attacker.damageDealtUpBuff.get() - target.damageTakenDownBuff.get())
            .coerceAtLeast(10.percent)

        if (target.markCounter > 0) buffDmgDealtCoef += 30.percent
        if (target.antiMarkCounter > 0) buffDmgDealtCoef -= 30.percent

        // tentative
        val eleDmgDealtCoef = 100.percent +
                attacker.attributeDamageDealtUp.getValue(attribute) +
                attacker.againstAttributeDamageDealtUp.getValue(target.loadout.data.attribute) -
                target.againstAttributeDamageTakenDown.getValue(attribute)

        // cx damage up
        val cxDmgCoef = if (attacker.inCXAct) {
            100.percent + attacker.climaxDamage.get()
        } else {
            100.percent
        }

        val bonusCoef = 100.percent + attacker.eventBonus

        val base = (atk - def).coerceAtLeast(atk / 10) / hitCount

        var dmg = base
        dmg = (dmg * eleCoef).toInt()
        dmg = (dmg * effEleCoef).toInt()
        dmg = (dmg * bonusCoef).toInt()
        dmg = (dmg * dmgDealtCoef).toInt()
        dmg = (dmg * cxDmgCoef).toInt() // tentative
        dmg = (dmg * eleDmgDealtCoef).toInt()  // tentative
        dmg = (dmg * buffDmgDealtCoef).toInt()

        var criticalDmg = base
        criticalDmg = (criticalDmg * eleCoef).toInt()
        criticalDmg = (criticalDmg * effEleCoef).toInt()
        criticalDmg = (criticalDmg * critCoef).toInt()
        criticalDmg = (criticalDmg * bonusCoef).toInt()
        criticalDmg = (criticalDmg * dmgDealtCoef).toInt()
        criticalDmg = (criticalDmg * cxDmgCoef).toInt()
        criticalDmg = (criticalDmg * eleDmgDealtCoef).toInt()
        criticalDmg = (criticalDmg * buffDmgDealtCoef).toInt()

        return DamageResult(
            base = dmg,
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
        ((if (critical) this.critical else this.base) * (100 + it) / 100)
    }
}
