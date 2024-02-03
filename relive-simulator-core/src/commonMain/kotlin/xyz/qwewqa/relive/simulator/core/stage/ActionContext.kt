package xyz.qwewqa.relive.simulator.core.stage

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.i54.minus
import xyz.qwewqa.relive.simulator.core.i54.times
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.consumeOnAttackCountableBuffs
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ContractionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterContractionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ReviveBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.ContinuousBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHp
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.modifier.positiveEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.StageEffect
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTarget
import xyz.qwewqa.relive.simulator.core.stage.team.Team

data class ActionLog(
    var successfulHits: Int = 0,
    var attemptedHit: Boolean = false,
    var damageDealtToEnemy: I54 = 0.i54,
    val consumeCountableBuffs: MutableSet<CountableBuffEffect> = mutableSetOf(),
) {
  fun markConsumeOnAttackCountableBuffs(actor: Actor) {
    consumeOnAttackCountableBuffs.forEach { buffs ->
      for (buff in buffs) {
        if (buff in actor.buffs) {
          consumeCountableBuffs.add(buff)
          break
        }
      }
    }
  }
}

interface TargetSelectionContext {
  val self: Actor?
  val team: Team
  val enemy: Team
}

class BasicTargetSelectionContext(
    override val self: Actor?,
    override val team: Team,
    override val enemy: Team,
) : TargetSelectionContext

class ActionContext(
    override val self: Actor,
    val stage: Stage,
    override val team: Team,
    override val enemy: Team,
) : TargetSelectionContext {
  private var focus = 0
  val focusEnabled
    get() = focus > 0

  var actionLog = ActionLog()

  fun focus(block: () -> Unit) {
    focus++
    block()
    focus--
  }

  val Actor.contracted
    get() = ContractionBuff in buffs || GreaterContractionBuff in buffs

  private fun List<Actor>.targetContext(
      affectedByAggro: Boolean = false,
  ): TargetContext {
    return TargetContext(
        this@ActionContext,
        this,
        enemy.active.firstOrNull()?.takeIf { self.contracted && affectedByAggro }
            ?: self.aggroTarget.takeIf { affectedByAggro },
    )
  }

  inline fun Actor.act(action: TargetContext.() -> Unit) =
      TargetContext(this@ActionContext, listOf(this)).act(action)

  private fun provokable(selector: () -> List<Actor>) =
      self.provokeTarget?.let { listOf(it) }
          ?: enemy.active.firstOrNull()?.takeIf { self.contracted }?.let { listOf(it) }
          ?: selector()

  fun targetSelf() = listOf(self).targetContext()

  fun targetCutinTarget(): TargetContext {
    val target = stage.cutinTarget ?: error("Cutin target not available.")
    return if (target in enemy.actors.values) {
      provokable { listOf(target) }.targetContext(true)
    } else {
      listOf(target).targetContext()
    }
  }

  fun targetFront(count: Int = 1) = provokable { enemy.active.take(count) }.targetContext(true)

  fun targetBack(count: Int = 1) = provokable { enemy.active.takeLast(count) }.targetContext(true)

  fun targetAoe() = enemy.active.targetContext(true)

  fun targetAoe(condition: Condition) =
      enemy.active.filter { condition.evaluate(it) }.targetContext(true)

  // TODO: Check if pride is affected by provoke / aggro
  fun targetRandom(count: Int = 1) =
      provokable { List(count) { enemy.active.random(stage.random) } }.targetContext(true)

  fun targetAllyAoe() = team.active.targetContext()

  fun targetAllyAoe(condition: Condition) =
      team.active.filter { condition.evaluate(it) }.targetContext()

  fun targetAllyFront(count: Int = 1) = team.active.take(count).targetContext()

  fun targetAllyBack(count: Int = 1) = team.active.takeLast(count).targetContext()

  fun targetAllyRandom(count: Int = 1) =
      List(count) { team.active.random(stage.random) }.targetContext()

  fun targetNextActingAlly() =
      (team.nextAct?.actor?.let { listOf(it) } ?: emptyList()).targetContext()

  fun targetNextActingEnemy() =
      (enemy.nextAct?.actor?.let { listOf(it) } ?: emptyList()).targetContext(false)

  fun <T : Comparable<T>> targetByHighest(count: Int = 1, condition: (Actor) -> T) =
      provokable { enemy.active.sortedBy(condition).takeLast(count) }.targetContext(true)

  fun <T : Comparable<T>> targetByLowest(count: Int = 1, condition: (Actor) -> T) =
      provokable { enemy.active.sortedBy(condition).take(count) }.targetContext(true)

  fun <T : Comparable<T>> targetAllyByHighest(count: Int = 1, selector: (Actor) -> T) =
      team.active.sortedBy(selector).takeLast(count).targetContext()

  fun <T : Comparable<T>> targetAllyByLowest(count: Int = 1, selector: (Actor) -> T) =
      team.active.sortedBy(selector).take(count).targetContext()

  fun Team.forEach(action: (Actor) -> Unit) = active.forEach(action)

  fun applyAllyStageEffect(effect: StageEffect, turns: Int, level: Int = 1) {
    log("Stage Effect", category = LogCategory.BUFF) {
      "Apply stage effect ${effect.name} lv${level} (${turns}t) to ally stage."
    }
    team.stageEffects.add(effect, turns, level)
  }

  fun applyEnemyStageEffect(effect: StageEffect, turns: Int, level: Int = 1) {
    log("Stage Effect", category = LogCategory.BUFF) {
      "Apply stage effect ${effect.name} lv${level} (${turns}t) to enemy stage."
    }
    enemy.stageEffects.add(effect, turns, level)
  }

  fun resolveTarget(target: SkillTarget) =
      TargetContext(
          this,
          target.getTargets(this, self.provokeTarget).map { self.aggroTarget ?: it },
      )
}

class TargetContext(
    val actionContext: ActionContext,
    /**
     * The targeted actors. Could be either allies or enemies. Note that since multiple actions can
     * be taken within a single TargetContext, there's no guarantee all targets are alive at the
     * start of a particular action.
     */
    private val originalTargets: List<Actor>,
    private val aggroTarget: Actor? = null, // TODO: Get rid of this
) {
  val stage
    get() = actionContext.stage

  val self = actionContext.self
  val team = actionContext.team

  val targets
    get() = originalTargets.filter { it.isAlive }.map { aggroTarget ?: it }

  inline fun act(action: TargetContext.() -> Unit) = run(action)

  fun attack(
      modifier: Int,
      hitCount: Int = 1,
      ampMultiplier: Int = 100,
      ampCondition: Condition = Condition { false },
      damageType: DamageType = self.dress.damageType,
      attribute: Attribute = self.dress.attribute,
      addBrilliance: Boolean = true,
      focus: Boolean = actionContext.focusEnabled,
      noVariance: Boolean = false,
      noReflect: Boolean = false,
      mode: HitMode = HitMode.NORMAL,
  ) {
    if (!self.isAlive) return
    val hitAttribute =
        HitAttribute(
            modifier = modifier,
            hitCount = hitCount,
            attribute = attribute,
            damageType = damageType,
            ampModifier = ampMultiplier,
            ampCondition = ampCondition,
            addBrilliance = addBrilliance,
            focus = focus,
            noReflect = noReflect,
            noVariance = noVariance,
            mode = mode,
        )
    val impudenceBoost = self.buffs.tryRemove(Buffs.ActBoostImpudenceBuff)
    val dazeBoost = self.buffs.tryRemove(Buffs.ActBoostDazeBuff)
    val greaterDazeBoost = self.buffs.tryRemove(Buffs.GreaterActBoostGreaterDazeBuff)
    repeat(hitCount) { hitIndex ->
      val isLastHit = hitIndex == hitCount - 1
      for (originalTarget in originalTargets) {
        val target = aggroTarget ?: originalTarget
        if (!self.isAlive) return
        if (target.isAlive) {
          stage.damageCalculator.damage(
              self,
              target,
              hitAttribute,
          )
          if (isLastHit) {
            TargetContext(actionContext, listOf(target)).act {
              if (impudenceBoost) {
                applyBuff(Buffs.ImpudenceBuff, time = 1, value = 5000)
              }
              if (dazeBoost) {
                applyBuff(Buffs.DazeBuff, time = 1)
              }
              if (greaterDazeBoost) {
                applyBuff(Buffs.GreaterDazeBuff, time = 1)
              }
            }
          }
        }
      }
    }
  }

  fun attackWithDebuff(
      modifier: Int,
      hitCount: Int = 1,
      bonusMultiplier: Int = 100,
      bonusCondition: Condition = Condition { false },
      damageType: DamageType = self.dress.damageType,
      attribute: Attribute = self.dress.attribute,
      addBrilliance: Boolean = true,
      focus: Boolean = actionContext.focusEnabled,
      noVariance: Boolean = false,
      noReflect: Boolean = false,
      mode: HitMode = HitMode.NORMAL,
      effect: BuffEffect,
      value: Int,
      time: Int,
      chance: Int,
  ) {
    if (!self.isAlive) return
    val hitAttribute =
        HitAttribute(
            modifier = modifier,
            hitCount = hitCount,
            attribute = attribute,
            damageType = damageType,
            ampModifier = bonusMultiplier,
            ampCondition = bonusCondition,
            addBrilliance = addBrilliance,
            focus = focus,
            noReflect = noReflect,
            noVariance = noVariance,
            mode = mode,
        )
    val impudenceBoost = self.buffs.tryRemove(Buffs.ActBoostImpudenceBuff)
    val dazeBoost = self.buffs.tryRemove(Buffs.ActBoostDazeBuff)
    repeat(hitCount) { hitIndex ->
      val isLastHit = hitIndex == hitCount - 1
      val target = aggroTarget ?: originalTargets.random(stage.random)
      if (!self.isAlive) return
      if (target.isAlive) {
        stage.damageCalculator.damage(
            self,
            target,
            hitAttribute,
        )
        // TODO: Make this less hacky
        TargetContext(actionContext, listOf(target)).act {
          applyBuff(effect, value.toI54(), time, chance)
          if (isLastHit) {
            if (impudenceBoost) {
              applyBuff(Buffs.ImpudenceBuff, time = 1, value = 5000)
            }
            if (dazeBoost) {
              applyBuff(Buffs.DazeBuff, time = 1)
            }
          }
        }
      }
    }
  }

  fun applyBuff(effect: BuffEffect, value: I54 = 0.i54, time: Int, chance: Int = 100) =
      when (effect) {
        is ContinuousBuffEffect<*> ->
            applyContinuousBuff(effect = effect, value = value, turns = time, chance = chance)
        is CountableBuffEffect ->
            applyCountableBuff(effect = effect, count = time, value = value, chance = chance)
      }

  fun applyBuff(effect: BuffEffect, value: Int, time: Int, chance: Int = 100) =
      applyBuff(effect, value.toI54(), time, chance)

  fun applyContinuousBuff(
      effect: ContinuousBuffEffect<*>,
      value: I54 = 0.i54,
      turns: Int,
      chance: Int = 100
  ) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        when (effect.category) {
          BuffCategory.Positive -> {
            val applyChance =
                chance / 100.0 * (100 - mod { positiveEffectResistance(effect) }) / 100.0
            if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
              buffs.add(self, effect, value, turns)
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Positive buff ${effect.formatName(value)} (${turns}t) applied to [$name]."
              }
            } else {
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Positive buff ${effect.formatName(value)} (${turns}t) missed to [$name]."
              }
            }
          }
          BuffCategory.Negative -> {
            val applyChance =
                chance / 100.0 * (100 - mod { negativeEffectResistance(effect) }) / 100.0
            if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
              buffs.add(self, effect, value, turns)
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Negative buff ${effect.formatName(value)} (${turns}t) applied to [$name]."
              }
            } else {
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Negative buff ${effect.formatName(value)} (${turns}t) missed to [$name]."
              }
            }
          }
        }
      }
    }
  }

  fun applyContinuousBuff(
      effect: ContinuousBuffEffect<*>,
      value: Int,
      turns: Int,
      chance: Int = 100
  ) = applyContinuousBuff(effect, value.toI54(), turns, chance)

  fun applyContinuousBuff(
      effect: ContinuousBuffEffect<*>,
      value: (Actor) -> I54,
      turns: Int,
      chance: Int = 100
  ) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      val computedValue = value(target)
      target.apply {
        when (effect.category) {
          BuffCategory.Positive -> {
            val applyChance =
                chance / 100.0 * (100 - mod { positiveEffectResistance(effect) }) / 100.0
            if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
              buffs.add(self, effect, computedValue, turns)
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Positive buff ${effect.formatName(computedValue)} (${turns}t) applied to [$name]."
              }
            } else {
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Positive buff ${effect.formatName(computedValue)} (${turns}t) missed to [$name]."
              }
            }
          }
          BuffCategory.Negative -> {
            val applyChance =
                chance / 100.0 * (100 - mod { negativeEffectResistance(effect) }) / 100.0
            if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
              buffs.add(self, effect, computedValue, turns)
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Negative buff ${effect.formatName(computedValue)} (${turns}t) applied to [$name]."
              }
            } else {
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Negative buff ${effect.formatName(computedValue)} (${turns}t) missed to [$name]."
              }
            }
          }
        }
      }
    }
  }

  fun applyCountableBuff(
      effect: CountableBuffEffect,
      count: Int = 1,
      value: I54 = 0.i54,
      chance: Int = 100
  ) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        when (effect.category) {
          BuffCategory.Positive -> {
            val applyChance =
                chance / 100.0 * (100 - mod { positiveEffectResistance(effect) }) / 100.0
            if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
              buffs.addCountable(effect, count, value)
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Positive buff [${effect.name}] (${count}x) applied to [$name]."
              }
            } else {
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Positive buff [${effect.name}] (${count}x) missed to [$name]."
              }
            }
          }
          BuffCategory.Negative -> {
            val applyChance =
                chance / 100.0 * (100 - mod { negativeEffectResistance(effect) }) / 100.0
            if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
              buffs.addCountable(effect, count, value)
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Negative buff [${effect.name}] (${count}x) applied to [$name]."
              }
            } else {
              actionContext.log("Buff", category = LogCategory.BUFF) {
                "Negative buff [${effect.name}] (${count}x) missed to [$name]."
              }
            }
          }
        }
      }
    }
  }

  fun applyCountableBuff(
      effect: CountableBuffEffect,
      count: Int = 1,
      value: Int,
      chance: Int = 100
  ) = applyCountableBuff(effect, count, value.toI54(), chance)

  fun removeContinuous(category: BuffCategory) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Dispel continuous ${category.name} effects from [$name]."
        }
        buffs.remove(category)
      }
    }
  }

  fun shortenContinuous(category: BuffCategory, amount: Int) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Shorten continuous ${category.name} effects to [$name]."
        }
        buffs.adjustContinuousTurns(category, -amount)
      }
    }
  }

  fun lengthenContinuous(category: BuffCategory, amount: Int) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Lengthen continuous ${category.name} effects to [$name]."
        }
        buffs.adjustContinuousTurns(category, amount)
      }
    }
  }

  fun removeContinuous(effect: ContinuousBuffEffect<*>) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Dispel continuous ${effect.name} effects from [$name]."
        }
        buffs.removeAll(effect)
      }
    }
  }

  fun flipContinuous(category: BuffCategory, count: Int) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Flip", category = LogCategory.BUFF) {
          "Flip last $count continuous ${category.name} effects from [$name]."
        }
        buffs.flip(category, count)
      }
    }
  }

  fun removeCountable(category: BuffCategory) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Dispel countable ${category.name} effects from [$name]."
        }
        buffs.removeCountable(category)
      }
    }
  }

  fun removeCountable(category: BuffCategory, count: Int) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Dispel ${count}x countable ${category.name} effects from [$name]."
        }
        buffs.removeCountables(category, count)
      }
    }
  }

  fun removeCountable(effect: CountableBuffEffect, count: Int) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Dispel ${count}x countable effect ${effect.name} from [$name]."
        }
        buffs.removeCountables(effect, count)
      }
    }
  }

  fun removeCountable(effect: CountableBuffEffect) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Dispel", category = LogCategory.BUFF) {
          "Dispel all countable effect ${effect.name} from [$name]."
        }
        buffs.removeCountable(effect)
      }
    }
  }

  fun convert(from: CountableBuffEffect, to: CountableBuffEffect, count: Int) {
    // TODO: handle greater effects
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        val actualCount = buffs.removeCountables(from, count)
        actionContext.log("Conversion", category = LogCategory.BUFF) {
          "Convert ${actualCount}x (max: $count) ${from.name} to ${to.name} from [$name]."
        }
        buffs.addCountable(to, count = actualCount)
      }
    }
  }

  fun convertCountableNegative(count: Int) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Conversion", category = LogCategory.BUFF) {
          "Convert ${count}x negative countable effects from [$name]."
        }
        buffs.addCountable(ReviveBuff, count = buffs.removeCountables(BuffCategory.Negative, count))
      }
    }
  }

  fun increaseCountablePositive(count: Int) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Countable Increase", category = LogCategory.BUFF) {
          "Increase positive countable effects ${count}x to [$name]."
        }
        buffs.increaseCountable(BuffCategory.Positive, count)
      }
    }
  }

  fun heal(percent: I54 = 0.i54, fixed: I54 = 0.i54) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Heal", category = LogCategory.HEAL) {
          "Heal [$name] (percent: $percent, fixed: $fixed)."
        }
        this.heal(fixed + (percent * mod { +maxHp } / 100))
      }
    }
  }

  fun heal(percent: Int = 0, fixed: Int = 0) = heal(percent.toI54(), fixed.toI54())

  fun addBrilliance(amount: I54) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Brilliance", category = LogCategory.BRILLIANCE) {
          "Add brilliance to [$name] (amount: $amount)."
        }
        this.addBrilliance(amount)
      }
    }
  }

  fun addBrilliance(amount: Int) = addBrilliance(amount.toI54())

  fun removeBrilliance(amount: I54) {
    if (!self.isAlive) return
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Brilliance", category = LogCategory.BRILLIANCE) {
          "Remove brilliance from [$name] (amount: $amount)."
        }
        this.addBrilliance(-amount)
      }
    }
  }

  fun removeBrilliance(amount: Int) = removeBrilliance(amount.toI54())

  fun absorbBrilliance(amount: I54) {
    if (!self.isAlive) return
    var drained = 0.i54
    for (originalTarget in originalTargets) {
      val target = aggroTarget ?: originalTarget
      if (!target.isAlive) continue
      target.apply {
        actionContext.log("Brilliance", category = LogCategory.BRILLIANCE) {
          "Remove brilliance from [$name] (amount: $amount)."
        }
        if (hasBrillianceBar) {
          val startingBrilliance = this.brilliance
          this.addBrilliance(-amount)
          drained += startingBrilliance - this.brilliance
        }
      }
    }
    if (drained > 0) {
      actionContext.log("Brilliance", category = LogCategory.BRILLIANCE) {
        "Absorb $drained brilliance from targets."
      }
      self.addBrilliance(drained)
    }
  }

  fun absorbBrilliance(amount: Int) = absorbBrilliance(amount.toI54())
}

fun interface Act {
  fun ActionContext.execute()
}

fun Act.execute(context: ActionContext) = run { context.execute() }

@OptIn(ExperimentalContracts::class)
inline fun ActionContext.log(
    vararg tags: String,
    category: LogCategory = LogCategory.DEFAULT,
    debug: Boolean = false,
    summary: () -> String? = { null },
    value: () -> String
) {
  contract { callsInPlace(value, InvocationKind.AT_MOST_ONCE) }

  // Inlining the stage.log call avoids the overhead of the spread operator
  stage.run {
    if (configuration.logging && (!debug || configuration.debug) && logger.prepare()) {
      logger.log(
          turn, tile, move, category, self.name, *tags, summary = summary(), content = value())
    }
  }
}
