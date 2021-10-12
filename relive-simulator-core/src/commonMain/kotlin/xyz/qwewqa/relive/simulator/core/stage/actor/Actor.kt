package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.execute
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData
import xyz.qwewqa.relive.simulator.core.stage.strategy.BoundCutin

class Actor(
    val name: String,
    val dress: Dress,
    val memoir: Memoir?,
    val unitSkillLevel: Int,
) {
    val passives = mutableListOf<PassiveData>().apply {
        addAll(dress.autoSkills)
        if (memoir != null) addAll(memoir.autoskills)
    }
    val acts = dress.acts.toMutableMap()

    var hp = 1
        private set
    var brilliance = 0
        private set
    val buffs = BuffManager(this)

    lateinit var context: ActionContext

    val maxHp get() = valueMaxHp * (100 + boostMaxHp) / 100
    var valueMaxHp = 0
    var boostMaxHp = 0

    val actPower get() = valueActPower * (100 + boostActPower + actBurnFactor) / 100 + songActPower
    val actBurnFactor get() = if (buffs.any(BurnBuff)) -10 else 0
    var valueActPower = 0
    var boostActPower = 0
    var songActPower = 0

    val normalDefense get() = valueNormalDefense * (100 + boostNormalDefense) / 100
    var valueNormalDefense = 0
    var boostNormalDefense = 0

    val specialDefense get() = valueSpecialDefense * (100 + boostSpecialDefense) / 100
    var valueSpecialDefense = 0
    var boostSpecialDefense = 0

    val agility get() = valueAgility * (100 + boostAgility) / 100
    var valueAgility = 0
    var boostAgility = 0

    val dexterity
        get() = (valueDexterity +
                buffDexterity.coerceAtMost(100) -
                debuffDexterity.coerceAtMost(100)).coerceIn(0, 100)
    var valueDexterity = 0
    var buffDexterity = 0
    var debuffDexterity = 0

    val critical get() = valueCritical.coerceAtLeast(0)
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

    val absorb get() = valueAbsorb
    var valueAbsorb = 0

    val negativeEffectResist get() = valueNegativeEffectResist
    var valueNegativeEffectResist = 0

    val positiveEffectResist get() = valuePositiveEffectResist
    var valuePositiveEffectResist = 0

    val specificBuffResist = mutableMapOf<BuffEffect, Int>()
    val specificCountableBuffResist = mutableMapOf<CountableBuff, Int>()

    val climaxDamageUp get() = valueClimaxDamageUp
    var valueClimaxDamageUp = 0

    val damageDealtUp get() = valueDamageDealtUp
    var valueDamageDealtUp = 0

    val damageTakenDown get() = valueDamageTakenDown
    var valueDamageTakenDown = 0

    val damageDealtUpBuff get() = valueDamageDealtUpBuff
    var valueDamageDealtUpBuff = 0

    val damageTakenDownBuff get() = valueDamageTakenDownBuff
    var valueDamageTakenDownBuff = 0

    val againstAttributeDamageDealtUp = mutableMapOf<Attribute, Int>().withDefault { 0 }
    val againstAttributeDamageTakenDown = mutableMapOf<Attribute, Int>().withDefault { 0 }
    val attributeDamageDealtUp = mutableMapOf<Attribute, Int>().withDefault { 0 }

    // For bosses
    val innateAgainstAttributeDamageTakenDown = mutableMapOf<Attribute, Int>().withDefault { 0 }

    var perfectAimCounter = 0

    var eventBonus: Int = 0

    var inCX = false
        private set
    var inCXAct: Boolean = false

    val isAlive get() = hp > 0

    val cutin = memoir?.cutinData?.let { BoundCutin(this, it) }

    fun initializeTurnZero() {
        hp = maxHp
    }

    fun tick() {
        buffs.tick()
        val burn = buffs.get(BurnBuff).map { it.value }
        val burnFixed = burn.filter { it > 100 }.sum()
        val burnPercent = burn.filter { it <= 100 }.map { maxHp * it / 100 }.sum()
        val burnTotal = burnFixed + burnPercent
        if (burnTotal > 0) {
            context.log("Burn") { "Burn tick." }
            damage(burnTotal, additionalEffects = false)
        }
        val poison = buffs.get(PoisonBuff).map { it.value }
        val poisonFixed = poison.filter { it > 100 }.sum()
        val poisonPercent = poison.filter { it <= 100 }.map { maxHp * it / 100 }.sum()
        val poisonTotal = poisonFixed + poisonPercent
        if (poisonTotal > 0) {
            context.log("Poison") { "Poison tick." }
            damage(poisonTotal, additionalEffects = false)
        }
        val nightmare = buffs.get(NightmareBuff).sumOf { it.value }
        if (nightmare > 0) {
            context.log("Nightmare") { "Nightmare tick." }
            damage(nightmare, additionalEffects = false)
        }
    }

    /**
     * Execute an act normally, as from an act tile.
     * Factors in CC effects and adds brilliance based on ap cost.
     */
    fun execute(act: Act, apCost: Int) {
        if (!isAlive) {
            context.log("Act") { "Actor has already exited." }
            return
        }
        if (buffs.any(StopBuff)) {
            context.log("Abnormal") { "Act prevented by stop." }
            return
        }
        if (buffs.any(FreezeBuff)) {
            context.log("Abnormal") { "Act prevented by freeze." }
            return
        }
        if (buffs.any(SleepBuff)) {
            context.log("Abnormal") { "Act prevented by sleep." }
            return
        }
        if (buffs.any(NightmareBuff)) {
            context.log("Abnormal") { "Act prevented by nightmare." }
            return
        }
        if (buffs.any(StunBuff) && context.stage.random.nextDouble() < 0.5) {
            context.log("Abnormal") { "Act prevented by stun." }
            return
        }
        if (buffs.any(CountableBuff.Daze)) {
            context.log("Abnormal") { "Act prevented by daze." }
            Act {
                targetAllyRandom().act {
                    attack(
                        modifier = 71, // TODO: figure out what the actual value is
                        hitCount = 1,
                        removeOnConnect = CountableBuff.Daze,
                    )
                }
            }.execute(context)
            return
        }
        if (buffs.any(ConfusionBuff) && context.stage.random.nextDouble() < 0.3) {
            context.log("Abnormal") { "Act prevented by confuse." }
            val confusionAct = acts[ActType.ConfusionAct]?.act ?: Act {
                targetAllyRandom().act {
                    targetAllyRandom().act {
                        attack(
                            modifier = 105,
                            hitCount = 1,
                        )
                    }
                }
            }
            confusionAct.execute(context)
            return
        }
        this.addBrilliance(7 * apCost)
        act.execute(context)
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
            context.log("Damage") { "Already exited" }
            return
        }
        val newHp = (self.hp - amount).coerceAtLeast(0)
        context.log("Damage") { "Taken damage $amount (prevHp: ${self.hp}, newHp: $newHp)" }
        self.hp = newHp
        if (newHp == 0) {
            if (self.buffs.tryRemove(CountableBuff.Fortitude)) {
                self.hp = 1
                context.log("Damage") { "Fortitude activate (newHp: 1)" }
                return@run
            }
            if (self.buffs.tryRemove(CountableBuff.Revive)) {
                self.hp = self.maxHp / 2
                context.log("Damage") { "Revive activate (newHp: ${self.maxHp / 2})" }
                return@run
            }
            exit()
            return@run
        }
        if (additionalEffects) {
            self.addBrilliance(amount * 70 / self.maxHp)
            self.buffs.removeAll(FreezeBuff)
            if (self.buffs.count(SleepBuff) > 0 && stage.random.nextDouble() > 0.2) {
                self.buffs.removeAll(SleepBuff)
            }
            if (self.buffs.count(NightmareBuff) > 0 && stage.random.nextDouble() > 0.2) {
                self.buffs.removeAll(NightmareBuff)
            }
        }

    }

    fun exit() = context.run {
        team.strategy.onExit(self)
        buffs.clear()
        self.exitCX()
        log("Exit") { "Exited" }
    }

    fun heal(amount: Int) = context.run {
        context.log("Heal") {
            "Healed $amount (prevHp: ${self.hp}, newHp: ${
                (self.hp + amount).coerceAtMost(self.maxHp)
            })"
        }
        self.hp += amount
        self.hp = self.hp.coerceAtMost(self.maxHp)
    }

    fun addBrilliance(base: Int) = context.run {
        if (buffs.any(StopBuff)) {
            context.log("Abnormal") { "Brilliance gain prevented by stop." }
            return
        }
        val amount = base * (100 + brillianceGainUp) / 100
        context.log("Brilliance") {
            "Brilliance charge $amount (prevBril: ${self.brilliance}, newBril: ${
                (self.brilliance + amount).coerceIn(0, 100)
            })"
        }
        self.brilliance += amount
        self.brilliance = self.brilliance.coerceIn(0, 100)
    }

    fun enterCX() = context.run {
        if (inCX) return
        context.log("Climax") { "Enter cx" }
        team.song.effects.forEach {
            context.log("Song") { "Apply song effect ${it.name}." }
            it.start(context)
        }
        inCX = true
    }

    fun exitCX() = context.run {
        if (!inCX) return
        context.log("Climax") { "Exit cx" }
        team.song.effects.forEach {
            it.end(context)
        }
        inCX = false
    }

    init {
        dress.stats.addToActor(this)
        memoir?.stats?.addToActor(this)
    }
}
