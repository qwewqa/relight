package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.act.Act
import xyz.qwewqa.relivesim.stage.act.ActData
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.ActiveEffectManager
import xyz.qwewqa.relivesim.stage.log
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.team.Team

class StageGirl(
    val loadout: StageGirlLoadout,
) {
    lateinit var context: ActionContext
    lateinit var team: Team

    override fun toString() = loadout.data.displayName

    val acts: MutableMap<ActType, ActData> = mutableMapOf()
    var currentHP: Int = 1
    var currentBrilliance: Int = 0
        set(value) {
            field = value.coerceIn(0, 100)
        }
    val maxHp: MultiplicativeBuffModifier = MultiplicativeBuffModifier()
    val actPower: MultiplicativeBuffModifier = MultiplicativeBuffModifier()
    val normalDefense: MultiplicativeBuffModifier = MultiplicativeBuffModifier()
    val specialDefense: MultiplicativeBuffModifier = MultiplicativeBuffModifier()
    val agility: MultiplicativeBuffModifier = MultiplicativeBuffModifier()
    val dexterity: AdditivePercentModifier = AdditivePercentModifier()
    val critical: AdditivePercentModifier = AdditivePercentModifier()
    val accuracy: AdditivePercentModifier = AdditivePercentModifier()
    val evasion: AdditivePercentModifier = AdditivePercentModifier()
    val effectiveDamage: AdditivePercentModifier = AdditivePercentModifier()
    val normalReflect: AdditivePercentModifier = AdditivePercentModifier()
    val specialReflect: AdditivePercentModifier = AdditivePercentModifier()
    val brillianceGain: AdditivePercentModifier = AdditivePercentModifier()
    val absorb: AdditivePercentModifier = AdditivePercentModifier()
    val negativeEffectResist: AdditivePercentModifier = AdditivePercentModifier()
    val positiveEffectResist: AdditivePercentModifier = AdditivePercentModifier()
    val climaxDamage: AdditivePercentModifier = AdditivePercentModifier()
    val damageDealtUp: AdditivePercentModifier = AdditivePercentModifier()
    val damageDealtUpBuff: AdditivePercentModifier = AdditivePercentModifier()
    val damageTakenDown: AdditivePercentModifier = AdditivePercentModifier()
    val damageTakenDownBuff: AdditivePercentModifier = AdditivePercentModifier()
    val effects: ActiveEffectManager = ActiveEffectManager(this)
    var counterHealValue: Percent = 0.percent
    var apUpCounter: Int = 0
    var apDownCounter: Int = 0
    var perfectAimCounter: Int = 0
    var blindCounter: Int = 0
    var markCounter: Int = 0
    var antiMarkCounter: Int = 0
    var burnCounter: Int = 0
    var burnTick: Int = 0
    var poisonTick: Int = 0
    var eventBonus: Percent = 0.percent
    var inCX: Boolean = false
        private set
    var inCXAct: Boolean = false

    val data get() = loadout.data

    val againstAttributeDamageDealtUp = mutableMapOf<Attribute, Percent>().withDefault { 0.percent }
    val againstAttributeDamageTakenDown = mutableMapOf<Attribute, Percent>().withDefault { 0.percent }
    val attributeDamageDealtUp = mutableMapOf<Attribute, Percent>().withDefault { 0.percent }

    fun execute(act: Act, apCost: Int) {
        this.addBrilliance(7 * apCost)
        act.action(context)
    }

    /**
     * Damages this stage girl by [amount].
     *
     * @param amount The amount of damage dealt
     * @param type The type of damage dealt
     * @param isDirect Is true for standard act damage, false for indirect sources like dots and reflected damage
     */
    fun damage(amount: Int, type: DamageType, isDirect: Boolean = true) = context.run {
        if (!isAlive) {
            stage.log("Damage") { "[$self] has already exited" }
            return
        }
        val newHp = (self.currentHP - amount).coerceAtLeast(0)
        stage.log("Damage") { "[$self] damaged $amount (prevHp: ${self.currentHP}, newHp: $newHp)" }
        self.currentHP = newHp
        if (newHp == 0) {
            stage.log("Exit") { "[$self] has exited" }
            self.team.strategy.onStageGirlExit(self)
            self.exitCX()
        } else {
            if (isDirect) {
                self.addBrilliance(amount * 70 / self.maxHp.get())
            }
        }
    }

    fun heal(amount: Int) = context.run {
        stage.log("Heal") {
            "[$self] healed $amount (prevHp: ${self.currentHP}, newHp: ${
                (self.currentHP + amount).coerceAtMost(self.maxHp.get())
            })"
        }
        self.currentHP += amount
        self.currentHP = self.currentHP.coerceAtMost(self.maxHp.get())
    }

    fun addBrilliance(amount: Int) = context.run {
        // stop
        stage.log("Brilliance") {
            "[$self] brilliance charge $amount (prevBril: ${self.currentBrilliance}, newBril: ${
                (self.currentBrilliance + amount).coerceIn(0, 100)
            })"
        }
        self.currentBrilliance += amount
        self.currentBrilliance = self.currentBrilliance.coerceIn(0, 100)
    }

    fun enterCX() {
        if (inCX) return
        context.stage.log("Climax") { "[$this] enter cx" }
        team.song.effects.forEach {
            it.start(context)
        }
        inCX = true
    }

    fun exitCX() {
        if (!inCX) return
        context.stage.log("Climax") { "[$this] exit cx" }
        team.song.effects.forEach {
            it.stop(context)
        }
        inCX = false
    }

    val isAlive get() = currentHP > 0
}