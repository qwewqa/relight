package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.StackedEffect
import xyz.qwewqa.relivesim.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.random.Random

data class Stage(
    val player: Team,
    val opponent: Team,
    val damageCalculator: DamageCalculator = LoggingDamageCalculator(),
    val configuration: StageConfiguration = StageConfiguration(),
    val random: Random = Random.Default,
) {
    val logger = Logger()

    init {
        player.characters.values.forEach {
            it.context = ActionContext(it, this, player, opponent)
        }
        opponent.characters.values.forEach {
            it.context = ActionContext(it, this, opponent, player)
        }
    }

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
            damage(target, unreflected)
            log("Hit") { "Unreflected: $unreflected, Reflected: $reflected" }
            if (reflected > 0) {
                damage(attacker, reflected)
            }
        } else {
            log("Hit") { "Miss" }
        }
    }

    fun damage(target: CharacterState, amount: Int) {
        log("Damage") { "[$target] damaged $amount (prevHp: ${target.currentHP}, newHp: ${target.currentHP - amount})" }
        target.currentHP -= amount
    }

    fun heal(target: CharacterState, amount: Int) {
        log("Heal") {
            "[$target] healed $amount (prevHp: ${target.currentHP}, newHp: ${
                (target.currentHP + amount).coerceAtMost(target.maxHp.get().toInt())
            })"
        }
        target.currentHP += amount
        target.currentHP = target.currentHP.coerceAtMost(target.maxHp.get().toInt())
    }

    fun addBrilliance(target: CharacterState, amount: Int) {
        log("Brilliance") {
            "[$target] brilliance change $amount (prevBril: ${target.currentBrilliance}, newBril: ${
                (target.currentBrilliance + amount).coerceIn(0, 100)
            })"
        }
        target.currentBrilliance += amount
        target.currentBrilliance = target.currentBrilliance.coerceIn(0, 100)
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
