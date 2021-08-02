package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.effect.StackedEffect
import xyz.qwewqa.relivesim.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.random.Random

data class Stage(
    val player: Team,
    val enemy: Team,
    val damageCalculator: DamageCalculator = LoggingDamageCalculator(),
    val configuration: StageConfiguration = StageConfiguration(),
    val random: Random = Random.Default,
) {
    val logger = Logger()

    fun hit(
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int,
        isClimax: Boolean = false,
        overrideAttribute: Attribute? = null,
    ) {
        log("Hit") { "[${attacker.loadout.data.displayName}] attempts to hit [${target.loadout.data.displayName}]" }
        if (!attacker.isAlive) {
            log("Hit") { "Attacker is already dead" }
            return
        }
        val result = damageCalculator.calculate(this, attacker, target, modifier, hitCount, isClimax, overrideAttribute)
        if (target.effects.get(StackedEffect.Evade) > 0) {
            target.effects.removeStacked(StackedEffect.Evade)
            if (!(attacker.perfectAimCounter > 0)) {
                log("Hit") { "Miss from Evade" }
            }
        }
        if (random.nextDouble() < result.hitChance) {
            val n = random.nextInt(-8, 9)
            val isCritical = random.nextDouble() < result.criticalChance
            val damage = if (isCritical) {
                (result.critical * (100.percent + n.percent)).toInt()

            } else {
                (result.base * (100.percent + n.percent)).toInt()
            }
            val reflect = when (attacker.loadout.data.damageType) {
                DamageType.Normal -> target.normalReflect.get()
                DamageType.Special -> target.specialReflect.get()
                DamageType.NeutralDamage -> 0.percent
            }
            log("Hit") { "Damage roll: $damage (critical: $isCritical, varianceRoll: $n)" }
            val reflected = (damage * reflect).toInt()
            val unreflected = damage - reflected
            log("Hit") { "Unreflected: $unreflected, Reflected: $reflected" }
        } else {
            log("Hit") { "Miss" }
        }
    }

}

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(tag: String = "", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(tag, value())
    }
}
