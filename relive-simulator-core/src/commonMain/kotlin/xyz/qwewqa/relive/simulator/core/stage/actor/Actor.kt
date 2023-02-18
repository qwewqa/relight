package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.accessory.Accessory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.modifier.*
import xyz.qwewqa.relive.simulator.core.stage.strategy.BoundCutin

class Actor(
    val name: String,
    val dress: Dress,
    val memoir: Memoir?,
    val accessory: Accessory?,
    val isSupport: Boolean = false,
) {
    val passives = dress.autoSkills + (memoir?.autoskills ?: emptyList()) + (accessory?.autoskills ?: emptyList())
    val acts = dress.acts.toMutableMap()

    var hp = 1
        private set
    var brilliance = 0
        private set
    val buffs = BuffManager(this)
    val mod = _Modifiers(this)

    val maxHp get() = mod { maxHp }

    lateinit var context: ActionContext

    val specificBuffResist = platformMapOf<BuffEffect, Int>()
    var conditionalDamageDealtUp = mutableListOf<Pair<Condition, Int>>()

    // Not sure if this logic is exactly right, but it's rare for this to be a problem.
    val aggroTarget: Actor?
        get() = buffs.get(AggroBuff).toList().lastOrNull()?.source
            ?: buffs.get(LockedAggroBuff).toList().lastOrNull()?.source

    val provokeTarget: Actor?
        get() = buffs.get(ProvokeBuff).toList().lastOrNull()?.source

    /**
     * If true, prevents taking damage via [damage].
     * Calling [exit] will still result in an exit.
     */
    var forceInvulnerable = false

    val againstAttributeDamageDealtUp = AttributeMap(0)
    val againstAttributeDamageReceivedDown = AttributeMap(0)
    val attributeDamageDealtUp = AttributeMap(0)

    var cutinInitialCooldownReduction = 0

    var eventBonus: Int = 0
    var eventMultiplier: Int = 100

    var inCX = false
        private set
    var inCXAct: Boolean = false

    val isAlive get() = hp > 0

    val cutin = memoir?.cutinData?.let { BoundCutin(this, it) }

    fun initializeTurnZero() {
        hp = mod { maxHp }
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
        try {
            if (!isAlive) {
                context.log("Act", category = LogCategory.EMPHASIS) { "Actor has already exited." }
                return
            }
            if (StopBuff in buffs) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by stop." }
                return
            }
            if (AgonyBuff in buffs) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by agony." }
                return
            }
            if (FreezeBuff in buffs) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by freeze." }
                return
            }
            if (SleepBuff in buffs) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by sleep." }
                return
            }
            if (NightmareBuff in buffs) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by nightmare." }
                return
            }
            if (StunBuff in buffs && context.stage.random.nextDouble() < 0.5) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by stun." }
                return
            }
            if (LovesicknessBuff in buffs && context.stage.random.nextDouble() < 0.5) {
                context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by lovesickness." }
                return
            }
            if (CountableBuff.Daze in buffs) {
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
            if (ConfusionBuff in buffs && context.stage.random.nextDouble() < 0.3) {
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
            if (ElectricShockBuff in buffs && context.stage.random.nextDouble() < 0.3) {
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
            context.actionLog.consumeCountableBuffs.forEach {
                buffs.tryRemove(it)
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
            if (self.buffs.tryRemove(CountableBuff.InvincibleRebirth)) {
                self.hp = self.maxHp
                context.log(
                    "Damage",
                    category = LogCategory.DAMAGE
                ) { "Invincible Rebirth activate (newHp: ${self.maxHp})." }
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
                context.log(
                    "Damage",
                    category = LogCategory.DAMAGE
                ) { "Exit Evasion activate (newHp: ${self.maxHp / 2})." }
                return@run
            }
            exit()
            return@run
        }
        if (additionalEffects) {
            self.addBrilliance(amount * 70 / self.maxHp)
            self.buffs.removeAll(FreezeBuff)
            self.buffs.tryRemove(CountableBuff.WeakSpot)
            if (SleepBuff in self.buffs && stage.random.nextDouble() > 0.2) {
                self.buffs.removeAll(SleepBuff)
            }
            if (NightmareBuff in self.buffs && stage.random.nextDouble() > 0.2) {
                self.buffs.removeAll(NightmareBuff)
            }
            if (self.mod { +counterHeal } > 0) {
                self.heal(self.mod { +counterHeal } * self.hp / 100)
            }
        }

    }

    fun exit() = context.run {
        hp = 0
        brilliance = 0
        team.strategy.onExit(self)
        buffs.clear()
        self.exitCX()
        enemy.forEach { enemy ->
            enemy.buffs.get(AggroBuff).filter { it.source == self }.forEach { it.remove() }
            enemy.buffs.get(ProvokeBuff).filter { it.source == self }.forEach { it.remove() }
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
        self.hp += amount * (100 + mod { hpRecoveryAdjustment }) / 100
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
        if (base > 0) {
            if (StopBuff in buffs) {
                context.log("Abnormal") { "Brilliance gain prevented by stop." }
                return
            }
            if (AgonyBuff in buffs) {
                context.log("Abnormal") { "Brilliance gain prevented by agony." }
                return
            }
        }
        if (inCX) {
            context.log("Brilliance", category = LogCategory.BRILLIANCE) { "Brilliance change ignored due to CX." }
            return
        }
        val amount = if (base > 0) {
            base * (100 + self.mod { brillianceGainAdjustment }) / 100
        } else {
            base
        }
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
