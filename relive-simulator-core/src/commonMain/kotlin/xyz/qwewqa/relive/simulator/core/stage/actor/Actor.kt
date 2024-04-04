package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.coerceAtLeast
import xyz.qwewqa.relive.simulator.core.i54.coerceAtMost
import xyz.qwewqa.relive.simulator.core.i54.coerceIn
import xyz.qwewqa.relive.simulator.core.i54.div
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.i54.plus
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.accessory.Accessory
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AggroBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AgonyBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BrillianceRegenBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ConfusionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ElectricShockBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ExitEvasionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.FreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.FrostbiteBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterAgonyBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterConfusionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterElectricShockBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterFreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterFrostbiteBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterImpudenceBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterLovesicknessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterNightmareBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterProvokeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterResilienceBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterReviveBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterSleepBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterStopBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterStunBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedAggroBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LovesicknessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NightmareBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.OverwhelmBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ProvokeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ResilienceBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SleepBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.StopBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.StunBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.execute
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifiers
import xyz.qwewqa.relive.simulator.core.stage.modifier.brillianceGainAdjustment
import xyz.qwewqa.relive.simulator.core.stage.modifier.hpRecoveryAdjustment
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHp
import xyz.qwewqa.relive.simulator.core.stage.platformMapOf
import xyz.qwewqa.relive.simulator.core.stage.strategy.BoundCutin

data class ActorStatistics(
    var damageTaken: I54 = 0.i54,
)

class Actor(
    val name: String,
    val dress: Dress,
    val memoir: Memoir?,
    val accessory: Accessory?,
    val isSupport: Boolean = false,
) {
  val autoskills =
      dress.unitSkill +
          dress.autoSkills +
          (memoir?.autoskills ?: emptyList()) +
          (accessory?.autoskills ?: emptyList())
  val acts = dress.acts.toMutableMap()

  val statistics = ActorStatistics()

  var undying = false

  var hp = 1.i54
    private set

  var brilliance = 0.i54
    private set

  val buffs = BuffManager(this)
  val mod = Modifiers(this)

  val hpFraction
    get() = hp.toDouble() / maxHp

  val maxHp
    get() = mod { maxHp }

  lateinit var context: ActionContext

  val specificBuffResist = platformMapOf<BuffEffect, I54>()
  var conditionalDamageDealtUp = mutableListOf<Pair<Condition, I54>>()
  val againstSchoolDamageDealtUp = platformMapOf<School, I54>()
  val fromCharacterDamageReceivedUp = platformMapOf<Character, I54>()

  var aggroTarget: Actor? = null

  // Not sure if this logic is exactly right, but it's rare for this to be a problem.
  fun updateAggroTarget() {
    aggroTarget =
        buffs.get(AggroBuff).toList().lastOrNull()?.source
            ?: buffs.get(LockedAggroBuff).toList().lastOrNull()?.source
  }

  var provokeTarget: Actor? = null

  fun updateProvokeTarget() {
    val provokeBuffs = setOf(ProvokeBuff, GreaterProvokeBuff)
    provokeTarget =
        buffs.continuousNegative().filter { it.effect in provokeBuffs }.lastOrNull()?.source
  }

  /** If true, prevents taking damage via [damage]. Calling [exit] will still result in an exit. */
  var forceInvulnerable = false

  val againstAttributeDamageDealtUp = platformMapOf<Attribute, I54>()
  val againstAttributeDamageReceivedDown = platformMapOf<Attribute, I54>()
  val attributeDamageDealtUp = platformMapOf<Attribute, I54>()

  val cutinInitialCooldownReductionPool = mutableListOf<I54>()
  val cutinCostReductionPool = mutableListOf<I54>()

  val cutinInitialCooldownReduction
    get() = cutinInitialCooldownReductionPool.maxOrNull() ?: 0.i54

  val cutinCostReduction
    get() = cutinCostReductionPool.maxOrNull() ?: 0.i54

  var eventBonus: Int = 0
  var eventMultiplier: Int = 100

  // TODO: Have a better way of doing this. (Some bosses do have brilliance bars)
  val hasBrillianceBar
    get() = dress.position != Position.None

  var inCX = false
    private set

  var inCXAct: Boolean = false

  val isAlive
    get() = hp > 0

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
   * Execute an act normally, as from an act tile. Factors in CC effects and adds brilliance based
   * on ap cost.
   */
  fun execute(act: Act, apCost: Int) {
    val startLog = context.actionLog.copy()
    try {
      if (!isAlive) {
        context.log("Act", category = LogCategory.EMPHASIS) { "Actor has already exited." }
        return
      }
      if (buffs.tryRemove(OverwhelmBuff)) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by overwhelm." }
        return
      }
      if (StopBuff in buffs || GreaterStopBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by stop." }
        return
      }
      if (AgonyBuff in buffs || GreaterAgonyBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by agony." }
        return
      }
      if (FreezeBuff in buffs || GreaterFreezeBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by freeze." }
        return
      }
      if (FrostbiteBuff in buffs || GreaterFrostbiteBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by frostbite." }
        return
      }
      if (SleepBuff in buffs || GreaterSleepBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by sleep." }
        return
      }
      if (NightmareBuff in buffs || GreaterNightmareBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by nightmare." }
        return
      }
      if ((StunBuff in buffs || GreaterStunBuff in buffs) &&
          context.stage.random.nextDouble() < 0.5) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by stun." }
        return
      }
      if ((LovesicknessBuff in buffs || GreaterLovesicknessBuff in buffs) &&
          context.stage.random.nextDouble() < 0.5) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) {
          "Act prevented by lovesickness."
        }
        return
      }
      // TODO: account for buff values
      if (buffs.tryRemove(Buffs.ImpudenceBuff) || buffs.tryRemove(GreaterImpudenceBuff)) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by pride." }
        Act { targetRandom().act { heal(fixed = 5000) } }.execute(context)
        return
      }
      if (buffs.tryRemove(Buffs.GreaterArroganceBuff)) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by arrogance." }
        Act { targetRandom().act { heal(fixed = 5000) } }.execute(context)
        return
      }
      // TODO: test order
      if (buffs.tryRemove(Buffs.DelusionBuff)) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by delusion." }
        Act { targetRandom().act { heal(percent = 20) } }.execute(context)
        return
      }
      if (Buffs.DazeBuff in buffs || Buffs.GreaterDazeBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by daze." }
        Act {
              targetAllyRandom().act {
                attack(
                    modifier = 71, // TODO: figure out what the actual value is
                    hitCount = 1,
                )
              }
            }
            .execute(context)
        return
      }
      if (Buffs.GreaterInsanityBuff in buffs) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) {
          "Act prevented by greater insanity."
        }
        Act {
              targetAllyRandom().act {
                attack(
                    modifier = 71, // TODO: figure out what the actual value is
                    hitCount = 1,
                )
              }
            }
            .execute(context)
        return
      }
      if ((ConfusionBuff in buffs || GreaterConfusionBuff in buffs) &&
          context.stage.random.nextDouble() < 0.3) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) { "Act prevented by confuse." }
        val confusionAct =
            acts[ActType.ConfusionAct]?.act
                ?: Act {
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
      if ((ElectricShockBuff in buffs || GreaterElectricShockBuff in buffs) &&
          context.stage.random.nextDouble() < 0.3) {
        context.log("Abnormal", category = LogCategory.EMPHASIS) {
          "Act prevented by electric shock."
        }
        Act { damage(7500.i54) }.execute(context)
        return
      }
      if (inCXAct && !inCX) {
        // Relevant for bosses
        brilliance = 0.i54
      }
      if (!inCXAct) {
        addBrilliance(7.i54 * apCost)
      }
      act.execute(context)
    } finally {
      if (context.actionLog.successfulHits > startLog.successfulHits) {
        buffs.tryRemove(Buffs.DazeBuff) || buffs.tryRemove(Buffs.GreaterDazeBuff) || buffs.tryRemove(Buffs.GreaterInsanityBuff)
      }
      context.actionLog.consumeCountableBuffs.forEach { buffs.tryRemove(it) }
    }
  }

  fun executeCutin(act: Act) {
    if (!isAlive) {
      context.log("Act") { "Actor has already exited." }
    }
    act.execute(context)
  }

  /** Damages this stage girl by [amount]. */
  fun damage(amount: I54, additionalEffects: Boolean = true) =
      context.run {
        if (!isAlive) {
          context.log("Damage", category = LogCategory.DAMAGE, debug = true) { "Already exited." }
          return
        }
        statistics.damageTaken += amount
        val newHp = if (!forceInvulnerable) (self.hp - amount).coerceAtLeast(0) else self.hp
        context.log("Damage", category = LogCategory.DAMAGE) {
          if (!forceInvulnerable) "Taken damage $amount (prevHp: ${self.hp}, newHp: $newHp)"
          else "Force invulnerable."
        }
        self.hp = newHp
        if (newHp == 0.i54) {
          if (undying) {
            self.hp = 1.i54
            return@run
          }
          if (self.buffs.count(ResilienceBuff) > 0 || self.buffs.count(GreaterResilienceBuff) > 0) {
            self.hp = 1.i54
            context.log("Damage", category = LogCategory.DAMAGE) {
              "Resilience activate (newHp: 1)."
            }
            return@run
          }
          if (self.buffs.tryRemove(Buffs.InvincibleRebirthBuff) ||
              self.buffs.tryRemove(Buffs.GreaterInvincibleRebirthBuff)) {
            self.hp = self.maxHp
            context.log("Damage", category = LogCategory.DAMAGE) {
              "Invincible Rebirth activate (newHp: ${self.maxHp})."
            }
            return@run
          }
          if (self.buffs.tryRemove(Buffs.FortitudeBuff) ||
              self.buffs.tryRemove(Buffs.GreaterFortitudeBuff)) {
            self.hp = 1.i54
            context.log("Damage", category = LogCategory.DAMAGE) {
              "Fortitude activate (newHp: 1)."
            }
            return@run
          }
          if (self.buffs.tryRemove(Buffs.ReviveBuff) || self.buffs.tryRemove(GreaterReviveBuff)) {
            self.hp = self.maxHp / 2
            context.log("Damage", category = LogCategory.DAMAGE) {
              "Revive activate (newHp: ${self.maxHp / 2})."
            }
            return@run
          }
          if (self.buffs.count(ExitEvasionBuff) > 0) {
            self.buffs.removeAll(ExitEvasionBuff)
            self.hp = self.maxHp / 2
            self.buffs.add(null, BrillianceRegenBuff, 100.i54, 2)
            context.log("Damage", category = LogCategory.DAMAGE) {
              "Exit Evasion activate (newHp: ${self.maxHp / 2})."
            }
            return@run
          }
          exit()
          return@run
        }
        if (additionalEffects) {
          self.addBrilliance(amount * 70 / self.maxHp)
          self.buffs.removeAll(FreezeBuff)
          self.buffs.removeAll(GreaterFreezeBuff)
          self.buffs.tryRemove(Buffs.WeakSpotBuff) ||
              self.buffs.tryRemove(Buffs.GreaterWeakSpotBuff)
          if ((SleepBuff in self.buffs || GreaterSleepBuff in self.buffs) &&
              stage.random.nextDouble() > 0.2) {
            self.buffs.removeAll(SleepBuff)
            self.buffs.removeAll(GreaterSleepBuff) // TODO: probably not right but who cares
          }
          if ((NightmareBuff in self.buffs || GreaterNightmareBuff in self.buffs) &&
              stage.random.nextDouble() > 0.2) {
            self.buffs.removeAll(NightmareBuff)
            self.buffs.removeAll(GreaterNightmareBuff) // TODO: probably not right but who cares
          }
          if (self.mod { +Modifier.CounterHealFixed } > 0 ||
              self.mod { +Modifier.CounterHealPercent } > 0) {
            self.heal(
                self.mod { Modifier.CounterHealFixed + Modifier.CounterHealPercent * maxHp / 100 })
          }
        }
      }

  fun damage(amount: Int, additionalEffects: Boolean = true) =
      damage(amount.toI54(), additionalEffects)

  fun exit() =
      context.run {
        hp = 0.i54
        brilliance = 0.i54
        team.onActorExit(self)
        buffs.clear()
        self.exitCX()
        enemy.forEach { enemy ->
          enemy.buffs.get(AggroBuff).filter { it.source == self }.forEach { it.remove() }
          enemy.buffs.get(ProvokeBuff).filter { it.source == self }.forEach { it.remove() }
        }
        log("Exit", category = LogCategory.EMPHASIS) { "Exited." }
      }

  fun revive() =
      context.run {
        team.onActorEnter(self)
        log("Revive", category = LogCategory.EMPHASIS) { "Revived." }
      }

  fun heal(amount: I54) =
      context.run {
        context.log("Heal") {
          "Healed $amount (prevHp: ${self.hp}, newHp: ${
                (self.hp + amount).coerceAtMost(self.maxHp)
            })"
        }
        self.hp += amount * (100 + mod { hpRecoveryAdjustment }) / 100
        self.hp = self.hp.coerceAtMost(self.maxHp)
      }

  fun heal(amount: Int) = heal(amount.toI54())

  fun adjustHp(amount: I54) =
      context.run {
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
          hp = amount
          context.log("Hp") { "Set Hp to $hp." }
        }
      }

  fun adjustHp(amount: Int) = adjustHp(amount.toI54())

  fun addBrilliance(base: I54) =
      context.run {
        if (base > 0) {
          if (StopBuff in buffs || GreaterStopBuff in buffs) {
            context.log("Abnormal") { "Brilliance gain prevented by stop." }
            return
          }
          if (AgonyBuff in buffs || GreaterAgonyBuff in buffs) {
            context.log("Abnormal") { "Brilliance gain prevented by agony." }
            return
          }
        }
        if (inCX) {
          context.log("Brilliance", category = LogCategory.BRILLIANCE) {
            "Brilliance change ignored due to CX."
          }
          return
        }
        val amount =
            if (base > 0) {
              base * (100 + self.mod { brillianceGainAdjustment }) / 100
            } else {
              base
            }
        adjustBrilliance(self.brilliance + amount)
      }

  fun addBrilliance(base: Int) = addBrilliance(base.toI54())

  fun adjustBrilliance(amount: I54) =
      context.run {
        val newValue = amount.coerceIn(0, 100)
        context.log("Brilliance", category = LogCategory.BRILLIANCE) {
          "Brilliance charge ${newValue - self.brilliance} (prevBril: ${self.brilliance}, newBril: $newValue)."
        }
        self.brilliance = newValue
      }

  fun adjustBrilliance(amount: Int) = adjustBrilliance(amount.toI54())

  fun enterCX() =
      context.run {
        if (inCX) return
        context.log("Climax") { "Enter cx." }
        team.song.effects.forEach {
          context.log("Song") { "Apply song effect ${it.name}." }
          it.start(context)
        }
        inCX = true
      }

  fun exitCX() =
      context.run {
        if (!inCX) return
        context.log("Climax") { "Exit cx." }
        team.song.effects.forEach { it.end(context) }
        brilliance = 0.i54
        inCX = false
      }

  init {
    dress.stats.addToActor(this)
    memoir?.stats?.addToActor(this)
    accessory?.stats?.addToActor(this)

    accessory?.act?.let { actData -> acts[actData.type] = actData }
  }
}
