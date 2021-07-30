package xyz.qwewqa.relivesim.stage

interface DamageCalculator {
    fun calculate(attacker: CharacterData, target: CharacterData, modifier: Percent, hitCount: Int = 1): DamageResult
}

data class DamageResult(
    val base: Int,
    val critical: Int,
    val criticalChance: Double,
    val hitChance: Double,
)
