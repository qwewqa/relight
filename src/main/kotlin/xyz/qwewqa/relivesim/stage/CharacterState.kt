package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.activeeffects.ActiveEffectManager

class CharacterState(
    val characterData: CharacterData,
) {
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
    val negativeEffectBlock: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val positiveEffectBlock: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val climaxDamage: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val damageDealtUp: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val damageTakenDown: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val damageTakenDownBuff: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val negativeEffectResist: SimpleModifier<Percent> = SimpleModifier(0.percent)
    val effects: ActiveEffectManager<CharacterState> = ActiveEffectManager(this)
    var burnTick: Int = 0
    var poisonTick: Int = 0
    var eventBonus: Percent = 0.percent
    var inCA: Boolean = false

    val alive get() = currentHP > 0
}