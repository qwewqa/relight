@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.stage.character.Character

data class Targeting(
    val name: String,
    val value: ActionContext.() -> TargetContext,
)

data class Effect(
    val name: String,
    val category: PassiveEffectCategory,
    val value: TargetContext.(value: Int, time: Int) -> Unit,
)

val targetings = buildMap {
    this[1001] = Targeting("Self") { targetSelf() }
    this[1002] = Targeting("All Allies") { targetAllyAoe() }
    Character.values().drop(2).forEachIndexed { index, character ->
        this[index + 2501] = Targeting("Allied ${character.displayName}") {
            targetAllyAoe { it.dress.character == character }
        }
        this[index + 2601] = Targeting("Enemy ${character.displayName}") {
            targetAoe { it.dress.character == character }
        }
    }
    Attribute.values().drop(1).forEachIndexed { index, attribute ->
        this[index + 4008] = Targeting("Allied ${attribute.name}") {
            targetAllyAoe { it.dress.attribute == attribute }
        }
    }
    (1..5).forEachIndexed { index, value ->
        this[index + 2111] = Targeting("Front $value Enemies") {
            targetFront(value)
        }
        this[index + 2121] = Targeting("Back $value Enemies") {
            targetBack(value)
        }
    }
}

val passiveEffects = buildMap {
    this[123] = Effect(
        "Damage Dealt Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueDamageDealtUp += value }
    }
    this[39] = Effect(
        "Effective Damage Dealt Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueEffectiveDamageUp += value }
    }
    this[126] = Effect(
        "Damage Taken Down",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueDamageTakenDown += value }
    }
    this[8] = Effect(
        "Act Power Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueActPower += value }
    }
    this[10] = Effect(
        "Normal Defense Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueNormalDefense += value }
    }
    this[12] = Effect(
        "Special Defense Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueSpecialDefense += value }
    }
    this[14] = Effect(
        "Agility Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueAgility += value }
    }
    this[18] = Effect(
        "Evasion Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueEvasion += value }
    }
    this[20] = Effect(
        "Dexterity Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueDexterity += value }
    }
    this[22] = Effect(
        "Critical Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueCritical += value }
    }
    this[24] = Effect(
        "Max HP Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueMaxHp += value }
    }
    this[26] = Effect(
        "Continuous Negative Effect Resistance Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueNegativeEffectResist += value }
    }
    this[40] = Effect(
        "Climax Damage Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.valueClimaxDamageUp += value }
    }
    this[244] = Effect(
        "Turn HP Recovery",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach {
            if (value <= 100) {
                it.hpPercentRegen += value
            } else {
                it.hpRegen += value
            }
        }
    }
    this[29] = Effect(
        "Turn Brilliance Recovery",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach { it.brillianceRegen += value }
    }
    listOf(
        PoisonBuff,
        BurnBuff,
        ProvokeBuff,
        StunBuff,
        SleepBuff,
        ConfusionBuff,
        StopBuff,
        FreezeBuff,
        BlindnessBuff,
    ).forEachIndexed { index, buffEffect ->
        this[index + 91] = Effect(
            "${buffEffect.name} Resistance Up",
            category = PassiveEffectCategory.Passive
        ) { value, time ->
            targets.forEach {
                it.specificBuffResist[buffEffect] = (it.specificBuffResist[buffEffect] ?: 0) + value
            }
        }
    }
    this[248] = Effect(
        "${MarkBuff.name} Resistance Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach {
            it.specificBuffResist[MarkBuff] = (it.specificBuffResist[MarkBuff] ?: 0) + value
        }
    }
    this[153] = Effect(
        "${AggroBuff.name} Resistance Up",
        category = PassiveEffectCategory.Passive
    ) { value, time ->
        targets.forEach {
            it.specificBuffResist[AggroBuff] = (it.specificBuffResist[AggroBuff] ?: 0) + value
        }
    }
}

val startEffects = buildMap {
    this[89] = Effect(
        "Brilliance Recovery",
        category = PassiveEffectCategory.TurnStartPositiveA,
    ) { value, time ->
        addBrilliance(value)
    }
    this[347] = Effect(
        "Brilliance Reduction",
        category = PassiveEffectCategory.TurnStartNegative,
    ) { value, time ->
        removeBrilliance(value)
    }
    this[123] = Effect(
        "Damage Dealt Up Buff",
        category = PassiveEffectCategory.TurnStartPositiveB,
    ) { value, time ->
        applyBuff(DamageDealtUpBuff, value, time)
    }
    this[126] = Effect(
        "Damage Taken Down Buff",
        category = PassiveEffectCategory.TurnStartPositiveB,
    ) { value, time ->
        applyBuff(DamageTakenDownBuff, value, time)
    }
    Attribute.values().drop(1).forEachIndexed { index, attribute ->
        this[index + 66] = Effect(
            "${attribute.name} Damage Taken Down Buff",
            category = PassiveEffectCategory.TurnStartPositiveB,
        ) { value, time ->
            applyBuff(AgainstAttributeDamageTakenDownBuff(attribute), value, time)
        }
    }
    this[34] = Effect(
        "Evasion",
        category = PassiveEffectCategory.TurnStartPositiveB,
    ) { value, time ->
        applyCountableBuff(CountableBuff.Evasion, time)
    }
    this[36] = Effect(
        "Fortitude",
        category = PassiveEffectCategory.TurnStartPositiveB,
    ) { value, time ->
        applyCountableBuff(CountableBuff.Fortitude, time)
    }
    this[30] = Effect(
        "Normal Barrier Buff",
        category = PassiveEffectCategory.TurnStartPositiveB,
    ) { value, time ->
        applyBuff(NormalBarrierBuff, value, time)
    }
    this[31] = Effect(
        "Special Barrier Buff",
        category = PassiveEffectCategory.TurnStartPositiveB,
    ) { value, time ->
        applyBuff(SpecialBarrierBuff, value, time)
    }
    this[56] = Effect(
        "Provoke Buff",
        category = PassiveEffectCategory.TurnStartNegative,
    ) { value, time ->
        applyBuff(ProvokeBuff, value, time)
    }
    this[152] = Effect(
        "Aggro Buff",
        category = PassiveEffectCategory.TurnStartNegative,
    ) { value, time ->
        applyBuff(AggroBuff, value, time)
    }
}

data class RemakePassiveEffect(
    val targeting: Targeting,
    val effect: Effect,
) : PassiveEffect {
    override val name = "[${targeting.name}] ${effect.name}"
    override val category = effect.category

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) {
        effect.value(targeting.value(context), value, time)
    }
}

data class RemakeEffectEntry(
    val targeting: Targeting,
    val effect: Effect,
    val value: Int,
    val time: Int,
) {
    val data = PassiveData(RemakePassiveEffect(targeting, effect), value, time)
    val name = "${data.name}${if (time > 0) " (${time}t)" else ""}"
}

data class RemakeSkill(
    val id: Int,
    val effects: List<RemakeEffectEntry>,
    val icon: Int,
) {
    val name = if (effects.isNotEmpty()) effects.joinToString(", ") { it.name } else "None"
    val data = effects.map { it.data }
}
