package xyz.qwewqa.relivesim.stage

interface DamageCalculator {
    fun calculate(
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int = 1,
        overrideAttribute: Attribute? = null,
    ): DamageResult
}

class StandardDamageCalculator : DamageCalculator {
    override fun calculate(
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int,
        overrideAttribute: Attribute?,
    ): DamageResult {
        var atk = 2.0 * attacker.actPower.get() * modifier
        if (attacker.inCA) atk *= 1.1
        val def =
            if (attacker.characterData.damageType == DamageType.Normal) target.normalDefense.get()
            else target.specialDefense.get()
        val attribute = overrideAttribute ?: attacker.characterData.attribute
        var eleCoef = target.characterData.effectivenessTable.getValue(attribute)
        // burn
        if (eleCoef > 1.0) eleCoef *= 100.percent * attacker.effectiveDamage.get()
        val critCoef = 100.percent + attacker.critical.get().coerceAtLeast(0.percent)
        val dex = attacker.dexterity.get().coerceIn(0.percent, 100.percent)
        val acc = (100.percent + attacker.accuracy.get() - target.evasion.get()).coerceIn(0.percent, 100.percent)
        // blind
        // mark
        val bonusCoef = 100.percent + attacker.eventBonus
        val baseDmg = ((atk / hitCount).toInt() - (def / hitCount).toInt()) * eleCoef * bonusCoef
        val criticalDmg = baseDmg * critCoef
        return DamageResult(
            base = baseDmg.toInt(),
            critical = criticalDmg.toInt(),
            criticalChance = dex.asDouble(),
            hitChance = acc.asDouble(),
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
        ((if (critical) this.critical else this.base) * (1.0 + it / 100.0)).toInt()
    }
}
