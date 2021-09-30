package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.execute
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

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

    val actPower get() = valueActPower * (100 + boostActPower + actBurnFactor) / 100
    val actBurnFactor get() = if (buffs.count(BurnBuff) + buffs.count(LockedBurnBuff) > 0) -10 else 0
    var valueActPower = 0
    var boostActPower = 0

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
                buffDexterity.coerceAtMost(100) +
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

    var perfectAimCounter = 0

    var eventBonus: Int = 0

    var inCX = false
        private set
    var inCXAct: Boolean = false

    val isAlive get() = hp > 0

    fun initializeTurnZero() {
        hp = maxHp
    }

    fun tick() {
        buffs.tick()
        val burn = (buffs.get(BurnBuff) + buffs.get(LockedBurnBuff)).map { it.value }
        val burnFixed = burn.filter { it > 100 }.sum()
        val burnPercent = burn.filter { it <= 100 }.map { maxHp * it / 100 }.sum()
        val burnTotal = burnFixed + burnPercent
        if (burnTotal > 0) {
            context.log("Burn") { "Burn tick." }
            damage(burnTotal, addBrilliance = false)
        }
    }

    /**
     * Execute an act normally, as from an act tile.
     * Factors in CC effects and adds brilliance based on ap cost.
     */
    fun execute(act: Act, apCost: Int) {
        if (buffs.any(StopBuff)) {
            context.log("Abnormal") { "Act prevented by stop." }
            return
        }
        if (buffs.any(SleepBuff)) {
            context.log("Abnormal") { "Act prevented by sleep." }
            return
        }
        if (buffs.any(CountableBuff.Daze)) {
            context.log("Abnormal") { "Act prevented by daze." }
            Act {
                targetAllyRandom().act {
                    targetAllyRandom().act {
                        attack(
                            modifier = 71, // TODO: figure out what the actual value is
                            hitCount = 1,
                            removeOnConnect = CountableBuff.Daze,
                        )
                    }
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


    /**
     * Damages this stage girl by [amount].
     */
    fun damage(amount: Int, addBrilliance: Boolean = true) = context.run {
        if (!isAlive) {
            context.log("Damage") { "Already exited" }
            return
        }
        val newHp = (self.hp - amount).coerceAtLeast(0)
        context.log("Damage") { "Taken damage $amount (prevHp: ${self.hp}, newHp: $newHp)" }
        self.hp = newHp
        if (newHp == 0) {
            exit()
            return@run
        }
        if (addBrilliance) {
            self.addBrilliance(amount * 70 / self.maxHp)
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
