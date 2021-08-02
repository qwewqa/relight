package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.act.ActData
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.effect.ActiveEffectManager
import xyz.qwewqa.relivesim.stage.percent

class CharacterState(
    val loadout: CharacterLoadout,
) {
    val acts: MutableMap<ActType, ActData> = mutableMapOf()
    var currentHP: Int = 1
    var currentBrilliance: Int = 0
    val maxHp: ValueBuffModifier = ValueBuffModifier()
    val actPower: ValueBuffModifier = ValueBuffModifier()
    val normalDefense: ValueBuffModifier = ValueBuffModifier()
    val specialDefense: ValueBuffModifier = ValueBuffModifier()
    val agility: ValueBuffModifier = ValueBuffModifier()
    val dexterity: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val critical: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val accuracy: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val evasion: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val effectiveDamage: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val normalReflect: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val specialReflect: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val brillianceGain: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val absorb: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val negativeEffectResist: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val positiveEffectResist: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val climaxDamage: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val damageDealtUp: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val damageTakenDown: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val damageTakenDownBuff: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val effects: ActiveEffectManager = ActiveEffectManager()
    var counterHealValue: Percent = 0.percent
    var negativeEffectBlockCounter: Int = 0
    var positiveEffectBlockCounter: Int = 0
    val apUpCounter: Int = 0
    val apDownCounter: Int = 0
    var perfectAimCounter: Int = 0
    var blindCounter: Int = 0
    var burnCounter: Int = 0
    var burnTick: Int = 0
    var poisonTick: Int = 0
    var eventBonus: Percent = 0.percent
    var inCX: Boolean = false

    val isAlive get() = currentHP > 0
}