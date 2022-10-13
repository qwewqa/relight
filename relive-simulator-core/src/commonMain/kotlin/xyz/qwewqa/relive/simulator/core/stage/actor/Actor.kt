package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.accessory.Accessory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.execute
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.strategy.BoundCutin

class Actor(
    val name: String,
    val dress: Dress,
    val memoir: Memoir?,
    val accessory: Accessory?,
    val isSupport: Boolean = false,
) {
    val passives = if (memoir != null) {
        dress.autoSkills + memoir.autoskills
    } else dress.autoSkills
    val acts = dress.acts.toMutableMap()

    var hp = 1
        private set
    var brilliance = 0
        private set
    val buffs = BuffManager(this)

    lateinit var context: ActionContext

    /**
     * If true, prevents taking damage via [damage].
     * Calling [exit] will still result in an exit.
     */
    var forceInvulnerable = false

    var maxHp = 0
        private set
    private fun updateMaxHp() {
        maxHp = (valueMaxHp.toDouble() * (100 + boostMaxHp) / 100).toInt()
    }
    var valueMaxHp = 0
        set(value) {
            field = value
            updateMaxHp()
        }
    var boostMaxHp = 0
        set(value) {
            field = value
            updateMaxHp()
        }

    val hopeFactor get() = if (buffs.any(CountableBuff.Hope)) 20 else 0

    val actPower get() = valueActPower * (100 + boostActPower + actBurnFactor + hopeFactor) / 100 + songActPower
    val actBurnFactor get() = if (isBurned) -10 else 0
    var valueActPower = 0
    var boostActPower = 0
    var songActPower = 0

    val normalDefense get() = valueNormalDefense * (100 + boostNormalDefense) / 100
    var valueNormalDefense = 0
    var boostNormalDefense = 0

    val specialDefense get() = valueSpecialDefense * (100 + boostSpecialDefense) / 100
    var valueSpecialDefense = 0
    var boostSpecialDefense = 0

    val agility get() = valueAgility * (100 + boostAgility + hopeFactor) / 100
    var valueAgility = 0
    var boostAgility = 0

    val dexterity
        get() = (valueDexterity +
                buffDexterity.coerceAtMost(100) -
                debuffDexterity.coerceAtMost(100) +
                hopeFactor).coerceIn(0, 100)
    var valueDexterity = 0
    var buffDexterity = 0
    var debuffDexterity = 0

    val critical get() = (valueCritical + hopeFactor).coerceAtLeast(0)
    var valueCritical = 0

    val accuracy get() = valueAccuracy
    var valueAccuracy = 0

    val evasion get() = valueEvasion
    var valueEvasion = 0

    val effectiveDamageUp get() = valueEffectiveDamageUp
    var valueEffectiveDamageUp = 0

    val normalReflect get() = valueNormalReflect
    var valueNormalReflect = 0

    val specialReflect get() = valueSpecialReflect
    var valueSpecialReflect = 0

    val brillianceGainUp get() = valueBrillianceGainUp
    var valueBrillianceGainUp = 0

    val hpRecoveryGainUp get() = valueHPRecoveryGainUp
    var valueHPRecoveryGainUp = 0

    val absorb get() = valueAbsorb
    var valueAbsorb = 0

    val negativeEffectResist get() = valueNegativeEffectResist
    var valueNegativeEffectResist = 0

    val negativeCountableResist get() = valueNegativeCountableResist
    var valueNegativeCountableResist = 0

    val positiveEffectResist get() = valuePositiveEffectResist
    var valuePositiveEffectResist = 0

    val specificBuffResist = mutableMapOf<TimedBuffEffect, Int>()
    val specificCountableBuffResist = mutableMapOf<CountableBuff, Int>()

    val climaxDamageUp get() = valueClimaxDamageUp
    var valueClimaxDamageUp = 0

    val damageDealtUp get() = valueDamageDealtUp
    var valueDamageDealtUp = 0

    var conditionalDamageDealtUp = mutableListOf<Pair<Condition, Int>>()

    val damageTakenDown get() = valueDamageTakenDown
    var valueDamageTakenDown = 0

    val damageDealtUpBuff get() = valueDamageDealtUpBuff
    var valueDamageDealtUpBuff = 0

    val damageTakenDownBuff get() = valueDamageTakenDownBuff
    var valueDamageTakenDownBuff = 0

    val damageTakenDownDebuff get() = valueDamageTakenDownDebuff
    var valueDamageTakenDownDebuff = 0

    val againstAttributeDamageDealtUp = AttributeMap(0)
    val againstAttributeDamageTakenDown = AttributeMap(0)
    val attributeDamageDealtUp = AttributeMap(0)

    // For bosses
    val innateAgainstAttributeDamageTakenDown = AttributeMap(0)

    inline val isInvincible get() = invincible > 0
    var invincible = 0

    inline val isStopped get() = stop > 0
    var stop = 0

    inline val isSleeping get() = sleep > 0
    var sleep = 0

    inline val isNightmaring get() = nightmare > 0
    var nightmare = 0

    inline val isConfused get() = confusion > 0
    var confusion = 0

    inline val isFrozen get() = frozen > 0
    var frozen = 0

    inline val isStunned get() = stun > 0
    var stun = 0

    inline val isBurned get() = burn > 0
    var burn = 0

    inline val isPoisoned get() = poison > 0
    var poison = 0

    inline val isShocked get() = shock > 0
    var shock = 0

    inline val isLovesick get() = lovesickness > 0
    var lovesickness = 0

    inline val isAgonized get() = agony > 0
    var agony = 0

    inline val isBlinded get() = blindness > 0
    var blindness = 0

    inline val isApUp get() = apUp > 0
    var apUp = 0

    inline val isAp2Up get() = ap2Up > 0
    var ap2Up = 0

    inline val isApDown get() = apDown > 0
    var apDown = 0

    inline val isAp2Down get() = ap2Down > 0
    var ap2Down = 0

    var brillianceRegen = 0
    var hpRegen = 0
    var hpPercentRegen = 0

    var counterHeal = 0

    var perfectAimCounter = 0

    var cutinInitialCooldownReduction = 0

    var eventBonus: Int = 0
    var eventMultiplier: Int = 100

    var aggroTarget: Actor? = null
    var provokeTarget: Actor? = null

    var inCX = false
        private set
    var inCXAct: Boolean = false

    val isAlive get() = hp > 0

    val cutin = memoir?.cutinData?.let { BoundCutin(this, it) }

    fun initializeTurnZero() {
        hp = maxHp
        context.log("Init") { "Dress Stats: ${dress.stats.display()}." }
        context.log("Init") { "Memoir Stats: ${memoir?.stats?.display()}." }
        context.log("Init") { "Accessory Stats: ${accessory?.stats?.display()}." }
    }

    fun tick() {
        buffs.tick()
    }

    /**
     * Execute an act normally, as from an act tile.
     * Factors in CC effects and adds brilliance based on ap cost.
     */
    fun execute(act: Act, apCost: Int) {
        val startLog = context.actionLog.copy()
        val startHope = buffs.count(CountableBuff.Hope)
        try {
            if (!isAlive) {
                context.log("Act", category = LogCategory.EMPHASIS) { "Actor has already exited." }
                return
            }
            if (isStopped) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by stop." }
                return
            }
            if (isAgonized) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by agony." }
                return
            }
            if (isFrozen) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by freeze." }
                return
            }
            if (isSleeping) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by sleep." }
                return
            }
            if (isNightmaring) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by nightmare." }
                return
            }
            if (isStunned && context.stage.random.nextDouble() < 0.5) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by stun." }
                return
            }
            if (isLovesick && context.stage.random.nextDouble() < 0.5) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by lovesickness." }
                return
            }
            if (buffs.any(CountableBuff.Daze)) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by daze." }
                Act {
                    targetAllyRandom().act {
                        attack(
                            modifier = 71, // TODO: figure out what the actual value is
                            hitCount = 1,
                        )
                    }
                }.execute(context)
                return
            }
            if (isConfused && context.stage.random.nextDouble() < 0.3) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by confuse." }
                val confusionAct = acts[ActType.ConfusionAct]?.act ?: Act {
                    targetAllyRandom().act {
                        attack(
                            modifier = 105,
                            hitCount = 1,
                        )
                    }
                }
                confusionAct.execute(context)
                return
            }
            if (isShocked && context.stage.random.nextDouble() < 0.3) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by electric shock." }
                Act {
                    damage(7500)
                }.execute(context)
                return
            }
            if (inCXAct && !inCX) {
                // Relevant for bosses
                brilliance = 0
            }
            if (buffs.tryRemove(CountableBuff.Pride)) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by pride." }
                Act {
                    targetRandom().act {
                        heal(fixed = 5000)
                    }
                }.execute(context)
                return
            }
            if (!inCXAct) {
                addBrilliance(7 * apCost)
            }
            act.execute(context)
        } finally {
            if (context.actionLog.successfulHits > startLog.successfulHits) {
                buffs.tryRemove(CountableBuff.Daze)
            }
            if (startHope > 0 && context.actionLog.attemptedHit) {
                buffs.tryRemove(CountableBuff.Hope)
            }
        }
    }

    fun executeCutin(act: Act) {
        if (!isAlive) {
            context.log("Act") { "Actor has already exited." }
        }
        act.execute(context)
    }

    /**
     * Damages this stage girl by [amount].
     */
    fun damage(amount: Int, additionalEffects: Boolean = true) = context.run {
        if (!isAlive) {
            context.log("Damage", category = LogCategory.DAMAGE, debug = true) { "Already exited." }
            return
        }
        val newHp = if (!forceInvulnerable) (self.hp - amount).coerceAtLeast(0) else self.hp
        context.log("Damage", category = LogCategory.DAMAGE) {
            if (!forceInvulnerable) "Taken damage $amount (prevHp: ${self.hp}, newHp: $newHp)" else "Force invulnerable."
        }
        self.hp = newHp
        if (newHp == 0) {
            if (self.buffs.count(ResilienceBuff) > 0) {
                self.hp = 1
                context.log("Damage", category = LogCategory.DAMAGE) { "Resilience activate (newHp: 1)." }
                return@run
            }
            if (self.buffs.tryRemove(CountableBuff.Fortitude)) {
                self.hp = 1
                context.log("Damage", category = LogCategory.DAMAGE) { "Fortitude activate (newHp: 1)." }
                return@run
            }
            if (self.buffs.tryRemove(CountableBuff.Revive)) {
                self.hp = self.maxHp / 2
                context.log("Damage", category = LogCategory.DAMAGE) { "Revive activate (newHp: ${self.maxHp / 2})." }
                return@run
            }
            if (self.buffs.count(ExitEvasionBuff) > 0) {
                self.buffs.removeAll(ExitEvasionBuff)
                self.hp = self.maxHp / 2
                self.buffs.add(null, BrillianceRegenBuff, 100, 2)
                context.log("Damage", category = LogCategory.DAMAGE) { "Exit Evasion activate (newHp: ${self.maxHp / 2})." }
                return@run
            }
            exit()
            return@run
        }
        if (additionalEffects) {
            self.addBrilliance(amount * 70 / self.maxHp)
            self.buffs.removeAll(FreezeBuff)
            self.buffs.tryRemove(CountableBuff.WeakSpot)
            if (self.isSleeping && stage.random.nextDouble() > 0.2) {
                self.buffs.removeAll(SleepBuff)
            }
            if (self.isNightmaring && stage.random.nextDouble() > 0.2) {
                self.buffs.removeAll(NightmareBuff)
            }
            if (self.counterHeal > 0) {
                self.heal(self.counterHeal * self.hp / 100)
            }
        }

    }

    fun exit() = context.run {
        hp = 0
        brilliance = 0
        team.strategy.onExit(self)
        buffs.clear()
        self.exitCX()
        enemy.forEach {
            if (it.aggroTarget == self) {
                it.buffs.removeAll(AggroBuff)
            }
            if (it.provokeTarget == self) {
                it.buffs.removeAll(ProvokeBuff)
            }
        }
        log("Exit", category = LogCategory.EMPHASIS) { "Exited." }
    }

    fun revive() = context.run {
        team.strategy.onRevive(self)
        log("Revive", category = LogCategory.EMPHASIS) { "Revived." }
    }

    fun heal(amount: Int) = context.run {
        context.log("Heal") {
            "Healed $amount (prevHp: ${self.hp}, newHp: ${
                (self.hp + amount).coerceAtMost(self.maxHp)
            })"
        }
        self.hp += amount * (100 + hpRecoveryGainUp) / 100
        self.hp = self.hp.coerceAtMost(self.maxHp)
    }

    fun adjustHp(amount: Int) = context.run {
        if (amount <= 0) {
            if (isAlive) {
                exit()
            } else {
                context.log("Hp") { "Already exited." }
            }
        } else {
            if (!isAlive) {
                revive()
            }
            hp = amount.coerceAtMost(maxHp)
            context.log("Hp") { "Set Hp to $hp." }
        }
    }

    fun addBrilliance(base: Int) = context.run {
        if (isStopped) {
            context.log("Abnormal") { "Brilliance gain prevented by stop." }
            return
        }
        if (isAgonized) {
            context.log("Abnormal") { "Brilliance gain prevented by agony." }
            return
        }
        val amount = base * (100 + brillianceGainUp) / 100
        adjustBrilliance(self.brilliance + amount)
    }

    fun adjustBrilliance(amount: Int) = context.run {
        val newValue = amount.coerceIn(0, 100)
        context.log("Brilliance", category = LogCategory.BRILLIANCE) {
            "Brilliance charge ${newValue - self.brilliance} (prevBril: ${self.brilliance}, newBril: $newValue)."
        }
        self.brilliance = newValue
    }

    fun enterCX() = context.run {
        if (inCX) return
        context.log("Climax") { "Enter cx." }
        team.song.effects.forEach {
            context.log("Song") { "Apply song effect ${it.name}." }
            it.start(context)
        }
        inCX = true
    }

    fun exitCX() = context.run {
        if (!inCX) return
        context.log("Climax") { "Exit cx." }
        team.song.effects.forEach {
            it.end(context)
        }
        brilliance = 0
        inCX = false
    }

    init {
        dress.stats.addToActor(this)
        memoir?.stats?.addToActor(this)
        accessory?.stats?.addToActor(this)

        accessory?.act?.let { actData ->
            acts[actData.type] = actData
        }
    }
}
