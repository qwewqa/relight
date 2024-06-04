@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package xyz.qwewqa.relive.simulator.core.stage.skilloption

import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.School
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkillType
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.FortitudeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterEvasionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterFortitudeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterReviveBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterWeakSpotBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.InvincibleRebirthBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ReviveBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.WeakSpotBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.ContinuousBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.modifier.positiveEffectResistance

object SkillOptions : ImplementationRegistry<SkillOption>() {
  // Note that some buffs have separate percent and fixed versions.
  // The only difference is the description, the actual effect checks whether the value is <= 100.

  fun SkillOptionData.simpleAttack() = makeSkillOption { value, time, chance, attribute ->
    attack(modifier = value, hitCount = time, attribute = attribute)
  }

  fun SkillOptionData.elementalFixedAttack() = makeSkillOption { value, time, chance, attribute ->
    attack(modifier = value, hitCount = time, attribute = attribute, mode = HitMode.ELEMENTAL_FIXED)
  }

  @Suppress("UNCHECKED_CAST")
  fun SkillOptionData.applyEffect(
      activeType: AutoSkillType = AutoSkillType.TurnStartB
  ): SkillOption {
    return when (val effect = Buffs[params[0]] ?: error("No buff effect for ${params[0]}")) {
      is ContinuousBuffEffect<*> -> {
        makeDualReversibleSkillOption(
            activeType = activeType,
            activeAction = { value, time, chance ->
              applyContinuousBuff(effect = effect, value = value, turns = time, chance = chance)
            },
            passiveAction = { value ->
              if (effect.category !=
                  BuffCategory.Negative) { // TODO: temporary measure until we know what bosses do
                targets.forEach { target ->
                  effect as ContinuousBuffEffect<Unit>
                  val res =
                      when (effect.category) {
                        BuffCategory.Positive -> target.mod.positiveEffectResistance(effect)
                        BuffCategory.Negative -> target.mod.negativeEffectResistance(effect)
                      }
                  if (res == 0.i54 || target.context.stage.random.nextDouble() > (res / 100.0)) {
                    target.buffs.activatePsuedoBuff(effect, value = value.toI54())
                  }
                }
              }
            },
            forwardAction = { value ->
              targets.forEach { target ->
                target.buffs.activatePsuedoBuff(
                    effect as ContinuousBuffEffect<Unit>, value = value.toI54())
              }
            },
            reverseAction = { value ->
              targets.forEach { target ->
                target.buffs.removePseudoBuff(
                    effect as ContinuousBuffEffect<Unit>, value = value.toI54())
              }
            })
      }
      is CountableBuffEffect -> {
        makeSkillOption { value, time, chance ->
          applyCountableBuff(effect, count = time, value = value, chance = chance)
        }
      }
    }
  }

  fun SkillOptionData.removeContinuousEffect(): ActiveSkillOption {
    val effect =
        Buffs[params[0]] as? ContinuousBuffEffect<*> ?: error("No buff effect for ${params[0]}")
    return makeSkillOption { value, time -> removeContinuous(effect = effect) }
  }

  fun SkillOptionData.removeContinuousEffects(
      vararg effects: ContinuousBuffEffect<*>
  ): ActiveSkillOption {
    return makeSkillOption { value, time -> effects.forEach { removeContinuous(effect = it) } }
  }

  fun SkillOptionData.reduceCountable(): ActiveSkillOption {
    val effect =
        Buffs[params[0]] as? CountableBuffEffect ?: error("No buff effect for ${params[0]}")
    return makeSkillOption { value -> removeCountable(effect, value) }
  }

  fun SkillOptionData.removeAllCountable(): ActiveSkillOption {
    val effect =
        Buffs[params[0]] as? CountableBuffEffect ?: error("No buff effect for ${params[0]}")
    return makeSkillOption { _ -> removeCountable(effect) }
  }

  val Attack1Hit = +skillOptionData(1).simpleAttack()

  // TODO: bypass damage

  val AttackElementalSetDamage1Hit = +skillOptionData(4).elementalFixedAttack()
  val FixedHpRecovery =
      +skillOptionData(6).makeSkillOption { value, time, chance -> heal(fixed = value) }
  val PercentHpRecovery =
      +skillOptionData(7).makeSkillOption { value, time, chance -> heal(percent = value) }
  val ActPowerUp = +skillOptionData(8).applyEffect()
  val ActPowerDown = +skillOptionData(9).applyEffect()
  val NormalDefenseUp = +skillOptionData(10).applyEffect()
  val NormalDefenseDown = +skillOptionData(11).applyEffect()
  val SpecialDefenseUp = +skillOptionData(12).applyEffect()
  val SpecialDefenseDown = +skillOptionData(13).applyEffect()
  val AgilityUp = +skillOptionData(14).applyEffect()
  val AgilityDown = +skillOptionData(15).applyEffect()
  val AccuracyUp = +skillOptionData(16).applyEffect()
  val AccuracyDown = +skillOptionData(17).applyEffect()
  val EvasionUp = +skillOptionData(18).applyEffect()
  val EvasionDown = +skillOptionData(19).applyEffect()
  val DexterityUp = +skillOptionData(20).applyEffect()
  val DexterityDown = +skillOptionData(21).applyEffect()
  val CriticalUp = +skillOptionData(22).applyEffect()
  val CriticalDown = +skillOptionData(23).applyEffect()
  val MaxHpUp = +skillOptionData(24).applyEffect()
  val MaxHpDown = +skillOptionData(25).applyEffect()
  val ContinuousNegativeEffectResistanceUp =
      +skillOptionData(26).applyEffect(AutoSkillType.TurnStartA)
  val ContinuousNegativeEffectResistanceDown =
      +skillOptionData(27).applyEffect(AutoSkillType.TurnStartA)
  val HpRegen = +skillOptionData(28).applyEffect()
  val BrillianceRegen = +skillOptionData(29).applyEffect()
  val NormalBarrierFixed = +skillOptionData(30).applyEffect()
  val SpecialBarrierFixed = +skillOptionData(31).applyEffect()
  val ReflectNormalDamage = +skillOptionData(32).applyEffect()
  val ReflectSpecialDamage = +skillOptionData(33).applyEffect()
  val Evasion = +skillOptionData(34).applyEffect()
  val PerfectAim = +skillOptionData(35).applyEffect()
  val Fortitude = +skillOptionData(36).applyEffect()
  val FixedNormalDefenseUp = +skillOptionData(37).applyEffect()
  val FixedSpecialDefenseUp = +skillOptionData(38).applyEffect()
  val EffectiveDamageUp = +skillOptionData(39).applyEffect()
  val ClimaxDamageUp = +skillOptionData(40).applyEffect()
  val CriticalDamageReceivedDown = +skillOptionData(41).applyEffect()
  val FixedActPowerUp = +skillOptionData(42).applyEffect()

  //    val FixedActPowerDown = +skillOptionData(43).applyEffect()
  val Absorb = +skillOptionData(44).applyEffect()
  val CounterHealFixed = +skillOptionData(45).applyEffect()
  val AgainstFlowerDamageUp = +skillOptionData(46).applyEffect()
  val AgainstWindDamageUp = +skillOptionData(47).applyEffect()
  val AgainstSnowDamageUp = +skillOptionData(48).applyEffect()
  val AgainstMoonDamageUp = +skillOptionData(49).applyEffect()
  val AgainstSpaceDamageUp = +skillOptionData(50).applyEffect()
  val AgainstCloudDamageUp = +skillOptionData(51).applyEffect()
  val AgainstDreamDamageUp = +skillOptionData(52).applyEffect()
  val AgainstBossDamageUp = +skillOptionData(53).applyEffect()
  val Posion = +skillOptionData(54).applyEffect()
  val Burn = +skillOptionData(55).applyEffect()
  val Provoke = +skillOptionData(56).applyEffect()
  val Stun = +skillOptionData(57).applyEffect()
  val Sleep = +skillOptionData(58).applyEffect()
  val Confusion = +skillOptionData(59).applyEffect()
  val Stop = +skillOptionData(60).applyEffect()
  val Freeze = +skillOptionData(61).applyEffect()
  val Blindness = +skillOptionData(62).applyEffect()
  val HpRecoveryReduction = +skillOptionData(65).applyEffect()
  val FlowerDamageReceivedDown = +skillOptionData(66).applyEffect()
  val WindDamageReceivedDown = +skillOptionData(67).applyEffect()
  val SnowDamageReceivedDown = +skillOptionData(68).applyEffect()
  val MoonDamageReceivedDown = +skillOptionData(69).applyEffect()
  val SpaceDamageReceivedDown = +skillOptionData(70).applyEffect()
  val CloudDamageReceivedDown = +skillOptionData(71).applyEffect()
  val DreamDamageReceivedDown = +skillOptionData(72).applyEffect()
  val FlowerDamageUp = +skillOptionData(73).applyEffect()
  val WindDamageUp = +skillOptionData(74).applyEffect()
  val SnowDamageUp = +skillOptionData(75).applyEffect()
  val MoonDamageUp = +skillOptionData(76).applyEffect()
  val SpaceDamageUp = +skillOptionData(77).applyEffect()
  val CloudDamageUp = +skillOptionData(78).applyEffect()
  val DreamDamageUp = +skillOptionData(79).applyEffect()
  val Attack2Hit = +skillOptionData(80).simpleAttack()
  val Attack3Hit = +skillOptionData(81).simpleAttack()
  val Attack4Hit = +skillOptionData(82).simpleAttack()
  val Attack5Hit = +skillOptionData(83).simpleAttack()
  val Attack6Hit = +skillOptionData(84).simpleAttack()
  val Attack7Hit = +skillOptionData(85).simpleAttack()
  val Attack8Hit = +skillOptionData(86).simpleAttack()
  val Attack9Hit = +skillOptionData(87).simpleAttack()
  val Attack10Hit = +skillOptionData(88).simpleAttack()
  val BrillianceRecovery =
      +skillOptionData(89).makeSkillOption(AutoSkillType.TurnStartA) { value ->
        addBrilliance(value)
      }

  //    val ActionRestrictionResistanceUpAuto = +skillOptionData(90).applyEffect()
  val PoisonResistanceUp = +skillOptionData(91).applyEffect(AutoSkillType.TurnStartA)
  val BurnResistanceUp = +skillOptionData(92).applyEffect(AutoSkillType.TurnStartA)
  val ProvokeResistanceUp = +skillOptionData(93).applyEffect(AutoSkillType.TurnStartA)
  val StunResistanceUp = +skillOptionData(94).applyEffect(AutoSkillType.TurnStartA)
  val SleepResistanceUp = +skillOptionData(95).applyEffect(AutoSkillType.TurnStartA)
  val ConfusionResistanceUp = +skillOptionData(96).applyEffect(AutoSkillType.TurnStartA)
  val StopResistanceUp = +skillOptionData(97).applyEffect(AutoSkillType.TurnStartA)
  val FreezeResistanceUp = +skillOptionData(98).applyEffect(AutoSkillType.TurnStartA)
  val BlindnessResistanceUp = +skillOptionData(99).applyEffect(AutoSkillType.TurnStartA)
  val HpRecoveryReductionResistanceUp = +skillOptionData(100).applyEffect(AutoSkillType.TurnStartA)

  //    val RemoveStatBuffs = +skillOptionData(101).makeSkillOption {  }
  //    val RemoveStatDebuffs = +skillOptionData(102).makeSkillOption {  }
  val RemovePoison = +skillOptionData(103).removeContinuousEffect()
  val RemoveBurn = +skillOptionData(104).removeContinuousEffect()
  val RemoveProvoke = +skillOptionData(105).removeContinuousEffect()
  val RemoveStun = +skillOptionData(106).removeContinuousEffect()
  val RemoveSleep = +skillOptionData(107).removeContinuousEffect()
  val RemoveConfusion = +skillOptionData(108).removeContinuousEffect()
  val RemoveStop = +skillOptionData(109).removeContinuousEffect()
  val RemoveFreeze = +skillOptionData(110).removeContinuousEffect()
  val RemoveBlindness = +skillOptionData(111).removeContinuousEffect()
  val RemoveHpRecoveryReduction = +skillOptionData(112).removeContinuousEffect()
  val BonusDamageVsSoldiers = +skillOptionData(113).applyEffect()
  val BonusDamageVsLancers = +skillOptionData(114).applyEffect()
  val BonusDamageVsFencers = +skillOptionData(115).applyEffect()
  val BonusDamageVsMagicians = +skillOptionData(116).applyEffect()
  val BonusDamageVsShielders = +skillOptionData(117).applyEffect()
  val BonusDamageVsGunners = +skillOptionData(118).applyEffect()
  val BonusDamageVsJokers = +skillOptionData(119).applyEffect()
  val BonusDamageVsBeasts = +skillOptionData(120).applyEffect()
  val BonusDamageVsQQQ = +skillOptionData(121).applyEffect()
  val BonusDamageVsMaterials = +skillOptionData(122).applyEffect()
  val DamageDealtUp = +skillOptionData(123).applyEffect()
  val DamageDealtDown = +skillOptionData(124).applyEffect()
  val DamageReceivedUp = +skillOptionData(125).applyEffect()
  val DamageReceivedDown = +skillOptionData(126).applyEffect()
  val RemoveContinuousPositiveEffects =
      +skillOptionData(127).makeSkillOption { _ -> removeContinuous(BuffCategory.Positive) }
  val RemoveContinuousNegativeEffects =
      +skillOptionData(128).makeSkillOption { _ -> removeContinuous(BuffCategory.Negative) }

  // TODO: bypass damage

  val AttackElementalSetDamage2Hit = +skillOptionData(140).elementalFixedAttack()
  val AttackElementalSetDamage3Hit = +skillOptionData(141).elementalFixedAttack()
  val AttackElementalSetDamage4Hit = +skillOptionData(142).elementalFixedAttack()
  val AttackElementalSetDamage5Hit = +skillOptionData(143).elementalFixedAttack()
  val AttackElementalSetDamage6Hit = +skillOptionData(144).elementalFixedAttack()

  // Todo: enmity

  val Mark = +skillOptionData(150).applyEffect()
  val FlipNegativeEffects =
      +skillOptionData(151).makeSkillOption { value, time ->
        flipContinuous(category = BuffCategory.Negative, count = time)
      }
  val Aggro = +skillOptionData(152).applyEffect()
  val AggroResistanceUp = +skillOptionData(153).applyEffect(AutoSkillType.TurnStartA)
  val RemoveAggro = +skillOptionData(154).removeContinuousEffect()
  val ExitEvasion = +skillOptionData(155).applyEffect()
  val Invincible = +skillOptionData(156).applyEffect()
  val ApDown = +skillOptionData(157).applyEffect()

  val ApUp = +skillOptionData(224).applyEffect()
  val ApUpResistanceUp = +skillOptionData(225).applyEffect(AutoSkillType.TurnStartA)

  val HitRandom20Stop1t =
      +skillOptionData(230).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.StopBuff,
            value = 0,
            time = 1,
            chance = 20,
        )
      }

  val LockedApUp = +skillOptionData(231).applyEffect()
  val LockedStun = +skillOptionData(232).applyEffect()
  val LockedHpRegen = +skillOptionData(233).applyEffect()
  val LockedStop = +skillOptionData(234).applyEffect()
  val LockedCounterHealFixed = +skillOptionData(235).applyEffect()
  val ActionRestrictionResistanceUp = +skillOptionData(238).applyEffect(AutoSkillType.TurnStartA)

  val RemoveContinuousEffects =
      +skillOptionData(239).makeSkillOption { _ ->
        removeContinuous(BuffCategory.Positive)
        removeContinuous(BuffCategory.Negative)
      }
  val AllEffectsResistanceUp = +skillOptionData(240).applyEffect(AutoSkillType.TurnStartA)

  val CounterHealPercent = +skillOptionData(241).applyEffect()

  val NormalBarrierPercent =
      +skillOptionData(242).makeSkillOption { value, time, chance ->
        applyContinuousBuff(
            effect = Buffs.NormalBarrierBuff,
            value = { target: Actor -> target.maxHp * value / 100 },
            turns = time,
            chance = chance,
        )
      }
  val SpecialBarrierPercent =
      +skillOptionData(243).makeSkillOption { value, time, chance ->
        applyContinuousBuff(
            effect = Buffs.SpecialBarrierBuff,
            value = { target: Actor -> target.maxHp * value / 100 },
            turns = time,
            chance = chance,
        )
      }

  val HpRegenPercent = +skillOptionData(244).applyEffect()
  val StrongPoison = +skillOptionData(245).applyEffect()
  val HeavyBurn = +skillOptionData(246).applyEffect()

  // TODO: figure out 247

  val MarkResistanceUp = +skillOptionData(248).applyEffect(AutoSkillType.TurnStartA)
  val EventBossDamageReceivedDown = +skillOptionData(249).applyEffect()
  val SealAct1 = +skillOptionData(250).applyEffect()
  val SealAct2 = +skillOptionData(251).applyEffect()
  val SealAct3 = +skillOptionData(252).applyEffect()
  val SealAct1ResistanceUp = +skillOptionData(253).applyEffect(AutoSkillType.TurnStartA)
  val SealAct2ResistanceUp = +skillOptionData(254).applyEffect(AutoSkillType.TurnStartA)
  val SealAct3ResistanceUp = +skillOptionData(255).applyEffect(AutoSkillType.TurnStartA)
  val RemoveSealAct1 = +skillOptionData(256).removeContinuousEffect()
  val RemoveSealAct2 = +skillOptionData(257).removeContinuousEffect()
  val RemoveSealAct3 = +skillOptionData(258).removeContinuousEffect()
  val BrillianceRecoveryDown = +skillOptionData(259).applyEffect()
  val BrillianceRecoveryDownResistanceUp =
      +skillOptionData(260).applyEffect(AutoSkillType.TurnStartA)
  val RemoveBrillianceRecoveryDown = +skillOptionData(261).removeContinuousEffect()

  val HitRandom20Stun2t =
      +skillOptionData(262).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.StunBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Sleep2t =
      +skillOptionData(263).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.SleepBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Confusion2t =
      +skillOptionData(264).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.ConfusionBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Freeze2t =
      +skillOptionData(265).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.FreezeBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Blindness2t =
      +skillOptionData(266).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.BlindnessBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }

  // TODO: 267

  val LockedPoisonResistanceUp = +skillOptionData(268).applyEffect(AutoSkillType.TurnStartA)
  val LockedBurnResistanceUp = +skillOptionData(269).applyEffect(AutoSkillType.TurnStartA)
  val LockedStunResistanceUp = +skillOptionData(270).applyEffect(AutoSkillType.TurnStartA)
  val LockedSleepResistanceUp = +skillOptionData(271).applyEffect(AutoSkillType.TurnStartA)
  val LockedConfusionResistanceUp = +skillOptionData(272).applyEffect(AutoSkillType.TurnStartA)
  val LockedStopResistanceUp = +skillOptionData(273).applyEffect(AutoSkillType.TurnStartA)
  val LockedFreezeResistanceUp = +skillOptionData(274).applyEffect(AutoSkillType.TurnStartA)
  val LockedBlindnessResistanceUp = +skillOptionData(275).applyEffect(AutoSkillType.TurnStartA)

  val AttackPoisonBoost =
      +skillOptionData(276).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.PoisonBuff in it.buffs })
      }
  val AttackBurnBoost =
      +skillOptionData(277).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.BurnBuff in it.buffs })
      }
  val AttackProvokeBoost =
      +skillOptionData(278).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.ProvokeBuff in it.buffs })
      }
  val AttackStunBoost =
      +skillOptionData(279).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.StunBuff in it.buffs })
      }
  val AttackSleepBoost =
      +skillOptionData(280).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.SleepBuff in it.buffs })
      }
  val AttackConfusionBoost =
      +skillOptionData(281).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.ConfusionBuff in it.buffs })
      }
  val AttackStopBoost =
      +skillOptionData(282).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.StopBuff in it.buffs })
      }
  val AttackFreezeBoost =
      +skillOptionData(283).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.FreezeBuff in it.buffs })
      }
  val AttackBlindnessBoost =
      +skillOptionData(284).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.BlindnessBuff in it.buffs })
      }
  val AttackHpRecoveryDownBoost =
      +skillOptionData(285).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.HpRecoveryDownBuff in it.buffs })
      }
  val AttackMarkBoost =
      +skillOptionData(286).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.MarkBuff in it.buffs })
      }
  val AttackAggroBoost =
      +skillOptionData(287).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.AggroBuff in it.buffs })
      }
  val AttackApUpBoost =
      +skillOptionData(288).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.ApUpBuff in it.buffs })
      }
  val AttackSealAct1Boost =
      +skillOptionData(289).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.SealAct1Buff in it.buffs })
      }
  val AttackSealAct2Boost =
      +skillOptionData(290).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.SealAct2Buff in it.buffs })
      }
  val AttackSealAct3Boost =
      +skillOptionData(291).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.SealAct3Buff in it.buffs })
      }
  val AttackBrillianceGainDownBoost =
      +skillOptionData(292).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.BrillianceGainDownBuff in it.buffs })
      }

  val ActChange = +skillOptionData(293).applyEffect()
  val ReduceActChange = +skillOptionData(294).reduceCountable()
  val RemoveActChange = +skillOptionData(295).removeAllCountable()
  val ActChangeContinuous = +skillOptionData(296).applyEffect()
  val RemoveActChangeContinuous = +skillOptionData(297).removeContinuousEffect()

  val LockedConfusion = +skillOptionData(298).applyEffect()

  val Resilience = +skillOptionData(299).applyEffect()

  val LockedPoison = +skillOptionData(300).applyEffect()
  val LockedBurn = +skillOptionData(301).applyEffect()
  val LockedBlindness = +skillOptionData(302).applyEffect()
  val LockedStrongPoison = +skillOptionData(303).applyEffect()
  val LockedHeavyBurn = +skillOptionData(304).applyEffect()

  val AttackNormalBoost125 =
      +skillOptionData(305).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 125,
            ampCondition = { it.dress.damageType == DamageType.Normal })
      }
  val AttackNormalBoost150 =
      +skillOptionData(306).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.damageType == DamageType.Normal })
      }
  val AttackSpecialBoost125 =
      +skillOptionData(307).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 125,
            ampCondition = { it.dress.damageType == DamageType.Special })
      }
  val AttackSpecialBoost150 =
      +skillOptionData(308).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.damageType == DamageType.Special })
      }

  val RemoveExit =
      +skillOptionData(309).makeSkillOption { value, time ->
        // TODO: implement
      }

  val FocusAttack =
      +skillOptionData(310).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            focus = true,
        )
      }

  val LockedHpRecoveryDown = +skillOptionData(311).applyEffect()

  // TODO: 312, 313 : DoT remove/resistance

  val AttackElementalSetDamage7Hit = +skillOptionData(314).elementalFixedAttack()
  val AttackElementalSetDamage8Hit = +skillOptionData(315).elementalFixedAttack()
  val AttackElementalSetDamage9Hit = +skillOptionData(316).elementalFixedAttack()
  val AttackElementalSetDamage10Hit = +skillOptionData(317).elementalFixedAttack()

  // TODO: Implement buffs
  //    val StrongPoisonResistanceUp = +skillOptionData(318).applyEffect(AutoSkillType.TurnStartA)
  //    val HeavyBurnResistanceUp = +skillOptionData(319).applyEffect(AutoSkillType.TurnStartA)

  val AttackNonElementalSetDamage =
      +skillOptionData(320).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            mode = HitMode.FIXED,
        )
      }

  // TODO: ignore fortitude, exit if hp < 0

  val FlipPositiveEffects =
      +skillOptionData(323).makeSkillOption { _, time ->
        flipContinuous(BuffCategory.Positive, count = time)
      }

  val FlowerDamageReceiveedUp = +skillOptionData(324).applyEffect()
  val WindDamageReceivedUp = +skillOptionData(325).applyEffect()
  val SnowDamageReceivedUp = +skillOptionData(326).applyEffect()
  val MoonDamageReceivedUp = +skillOptionData(327).applyEffect()
  val SpaceDamageReceivedUp = +skillOptionData(328).applyEffect()
  val CloudDamageReceivedUp = +skillOptionData(329).applyEffect()
  val DreamDamageReceivedUp = +skillOptionData(330).applyEffect()

  val FlowerDamageDealtDown = +skillOptionData(331).applyEffect()
  val WindDamageDealtDown = +skillOptionData(332).applyEffect()
  val SnowDamageDealtDown = +skillOptionData(333).applyEffect()
  val MoonDamageDealtDown = +skillOptionData(334).applyEffect()
  val SpaceDamageDealtDown = +skillOptionData(335).applyEffect()
  val CloudDamageDealtDown = +skillOptionData(336).applyEffect()
  val DreamDamageDealtDown = +skillOptionData(337).applyEffect()

  val RemovePositiveEffects =
      +skillOptionData(338).makeSkillOption { _ ->
        removeContinuous(BuffCategory.Positive)
        removeCountable(BuffCategory.Positive)
      }

  val ClimaxActDamageDown = +skillOptionData(339).applyEffect()

  val Lovesickness = +skillOptionData(340).applyEffect()
  val LockedLovesickness = +skillOptionData(341).applyEffect()
  val LovesicknessResistanceUp = +skillOptionData(342).applyEffect(AutoSkillType.TurnStartA)
  val LockedLovesicknessResistanceUp = +skillOptionData(343).applyEffect(AutoSkillType.TurnStartA)
  val RemoveLovesickness = +skillOptionData(344).removeContinuousEffect()
  val AttackLovesicknessBoost =
      +skillOptionData(345).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.LovesicknessBuff in it.buffs })
      }

  val LockedContinuousNegativeEffectResistanceUp =
      +skillOptionData(346).applyEffect(AutoSkillType.TurnStartA)
  val BrillianceReduction =
      +skillOptionData(347).makeSkillOption { value -> removeBrilliance(value) }

  val SealClimaxAct = +skillOptionData(348).applyEffect()
  val LockedSealClimaxAct = +skillOptionData(349).applyEffect()

  val RemoveContinuousNegativeEffectResistanceUp = +skillOptionData(350).removeContinuousEffect()
  val RemoveContinuousNegativeEffectResistanceDown = +skillOptionData(351).removeContinuousEffect()

  val ShockFixed = +skillOptionData(352).applyEffect()
  //    val ShockPercent = +skillOptionData(353).applyEffect()
  val LockedShockFixed = +skillOptionData(354).applyEffect()
  //    val LockedShockPercent = +skillOptionData(355).applyEffect()
  val ShockResistanceUp = +skillOptionData(356).applyEffect(AutoSkillType.TurnStartA)
  val LockedShockResistanceUp = +skillOptionData(357).applyEffect(AutoSkillType.TurnStartA)
  val RemoveShock = +skillOptionData(358).removeContinuousEffect()
  val AttackShockBoost =
      +skillOptionData(359).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { Buffs.ElectricShockBuff in it.buffs })
      }

  val Revive = +skillOptionData(360).applyEffect()

  val AttackSeishoBoost150 =
      +skillOptionData(361).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Seisho })
      }
  val AttackRinmeikanBoost150 =
      +skillOptionData(362).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Rinmeikan })
      }
  val AttackFrontierBoost150 =
      +skillOptionData(363).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Frontier })
      }
  val AttackSiegfeldBoost150 =
      +skillOptionData(364).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Siegfeld })
      }
  val AttackSeiranBoost150 =
      +skillOptionData(365).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Seiran })
      }

  val AttackSeishoBoost200 =
      +skillOptionData(366).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { it.dress.character.school == School.Seisho })
      }
  val AttackRinmeikanBoost200 =
      +skillOptionData(367).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { it.dress.character.school == School.Rinmeikan })
      }
  val AttackFrontierBoost200 =
      +skillOptionData(368).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { it.dress.character.school == School.Frontier })
      }
  val AttackSiegfeldBoost200 =
      +skillOptionData(369).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { it.dress.character.school == School.Siegfeld })
      }
  val AttackSeiranBoost200 =
      +skillOptionData(370).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 200,
            ampCondition = { it.dress.character.school == School.Seiran })
      }

  val HitRandom33Stop1t =
      +skillOptionData(371).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.StopBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33Stun2t =
      +skillOptionData(372).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.StunBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Sleep2t =
      +skillOptionData(373).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.SleepBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Confusion2t =
      +skillOptionData(374).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.ConfusionBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Freeze2t =
      +skillOptionData(375).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.FreezeBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Blindness2t =
      +skillOptionData(376).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.BlindnessBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }

  val NightmareFixed = +skillOptionData(377).applyEffect()
  //    val NightmarePercent = +skillOptionData(378).applyEffect()

  val ContinuousPositiveEffectResistanceUp =
      +skillOptionData(379).applyEffect(AutoSkillType.TurnStartA)
  val LockedContinuousPositiveEffectResistanceUp =
      +skillOptionData(380).applyEffect(AutoSkillType.TurnStartA)
  val PositiveEffectResistanceUp = +skillOptionData(381).applyEffect(AutoSkillType.TurnStartA)
  val LockedPositiveEffectResistanceUp = +skillOptionData(382).applyEffect(AutoSkillType.TurnStartA)

  val RemoveCountablePositiveEffects =
      +skillOptionData(383).makeSkillOption { _ -> removeCountable(BuffCategory.Positive) }

  val Daze = +skillOptionData(384).applyEffect()
  val Impudence = +skillOptionData(385).applyEffect()

  val AttackFocusSeishoBoost =
      +skillOptionData(386).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Seisho },
            focus = true,
        )
      }
  val AttackFocusRinmeikanBoost =
      +skillOptionData(387).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Rinmeikan },
            focus = true,
        )
      }
  val AttackFocusFrontierBoost =
      +skillOptionData(388).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Frontier },
            focus = true,
        )
      }
  val AttackFocusSiegfeldBoost =
      +skillOptionData(389).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Siegfeld },
            focus = true,
        )
      }
  val AttackFocusSeiranBoost =
      +skillOptionData(390).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.character.school == School.Seiran },
            focus = true,
        )
      }

  val HitRandom33Impudence5000v1x =
      +skillOptionData(391).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.ImpudenceBuff,
            value = 5000,
            time = 1,
            chance = 33,
        )
      }

  val Hope = +skillOptionData(392).applyEffect()

  val HitRandom33Daze1x =
      +skillOptionData(393).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val WeakSpot = +skillOptionData(394).applyEffect()

  val AgilityUpFixed = +skillOptionData(395).applyEffect()
  val MaxHpUpFixed = +skillOptionData(396).applyEffect()

  val AttackArcanaBoost =
      +skillOptionData(397).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = { it.dress.id in DressCategory.Arcana },
        )
      }

  val Frostbite = +skillOptionData(398).applyEffect()

  val DamageUpToSeisho = +skillOptionData(399).applyEffect()
  val DamageUpToRinmeikan = +skillOptionData(400).applyEffect()
  val DamageUpToFrontier = +skillOptionData(401).applyEffect()
  val DamageUpToSiegfeld = +skillOptionData(402).applyEffect()
  val DamageUpToSeiran = +skillOptionData(403).applyEffect()

  val DamageReceivedFromKarenUp = +skillOptionData(404).applyEffect()
  val DamageReceivedFromHikariUp = +skillOptionData(405).applyEffect()
  val DamageReceivedFromMahiruUp = +skillOptionData(406).applyEffect()
  val DamageReceivedFromClaudineUp = +skillOptionData(407).applyEffect()
  val DamageReceivedFromMayaUp = +skillOptionData(408).applyEffect()
  val DamageReceivedFromJunnaUp = +skillOptionData(409).applyEffect()
  val DamageReceivedFromNanaUp = +skillOptionData(410).applyEffect()
  val DamageReceivedFromFutabaUp = +skillOptionData(411).applyEffect()
  val DamageReceivedFromKaorukoUp = +skillOptionData(412).applyEffect()
  val DamageReceivedFromTamaoUp = +skillOptionData(413).applyEffect()
  val DamageReceivedFromIchieUp = +skillOptionData(414).applyEffect()
  val DamageReceivedFromFumiUp = +skillOptionData(415).applyEffect()
  val DamageReceivedFromRuiUp = +skillOptionData(416).applyEffect()
  val DamageReceivedFromYuyukoUp = +skillOptionData(417).applyEffect()
  val DamageReceivedFromAruruUp = +skillOptionData(418).applyEffect()
  val DamageReceivedFromMisoraUp = +skillOptionData(419).applyEffect()
  val DamageReceivedFromLalafinUp = +skillOptionData(420).applyEffect()
  val DamageReceivedFromTsukasaUp = +skillOptionData(421).applyEffect()
  val DamageReceivedFromShizuhaUp = +skillOptionData(422).applyEffect()
  val DamageReceivedFromAkiraUp = +skillOptionData(423).applyEffect()
  val DamageReceivedFromMichiruUp = +skillOptionData(424).applyEffect()
  val DamageReceivedFromMeiFanUp = +skillOptionData(425).applyEffect()
  val DamageReceivedFromShioriUp = +skillOptionData(426).applyEffect()
  val DamageReceivedFromYachiyoUp = +skillOptionData(427).applyEffect()
  val DamageReceivedFromKoharuUp = +skillOptionData(428).applyEffect()
  val DamageReceivedFromSuzuUp = +skillOptionData(429).applyEffect()
  val DamageReceivedFromHisameUp = +skillOptionData(430).applyEffect()

  val Agony = +skillOptionData(431).applyEffect()

  val LockedAggro = +skillOptionData(432).applyEffect()

  val LockedSealAct1 = +skillOptionData(433).applyEffect()
  val LockedSealAct2 = +skillOptionData(434).applyEffect()
  val LockedSealAct3 = +skillOptionData(435).applyEffect()

  val LockedNormalBarrierFixed = +skillOptionData(436).applyEffect()
  val LockedNormalBarrierFixed2 = +skillOptionData(437).applyEffect()

  val Possession = +skillOptionData(438).applyEffect()
  val LockedPossession = +skillOptionData(439).applyEffect()

  val LockedApDown = +skillOptionData(440).applyEffect()
  val LockedCriticalUp = +skillOptionData(441).applyEffect()

  val CurtainsClosed =
      +skillOptionData(442).makeSkillOption { _ ->
        // Noop in PvE
      }
  val LockedCurtainsClosed =
      +skillOptionData(443).makeSkillOption { _ ->
        // Noop in PvE
      }

  val ReduceCountableNegativeEffects =
      +skillOptionData(444).makeSkillOption { _, time ->
        removeCountable(BuffCategory.Negative, count = time)
      }

  val CountableNegativeEffectResistanceUp =
      +skillOptionData(445).applyEffect(AutoSkillType.TurnStartA)
  val LockedCountableNegativeEffectResistanceUp =
      +skillOptionData(446).applyEffect(AutoSkillType.TurnStartA)
  val BrillianceGainUp = +skillOptionData(447).applyEffect()
  val LockedResilience = +skillOptionData(448).applyEffect()
  val ApUp2 = +skillOptionData(449).applyEffect()
  val LockedApUp2 = +skillOptionData(450).applyEffect()
  val ApDown2 = +skillOptionData(451).applyEffect()
  val LockedApDown2 = +skillOptionData(452).applyEffect()

  val CountablePositiveEffectsReduction =
      +skillOptionData(453).makeSkillOption { _, time ->
        removeCountable(BuffCategory.Positive, count = time)
      }

  val ReviveReduction = +skillOptionData(454).reduceCountable()

  val CutinInitialCooldownReduction = +skillOptionData(455).applyEffect()

  val HoldBack = +skillOptionData(460).applyEffect()

  val RemoveCountableNegativeEffectResistance = +skillOptionData(462).removeContinuousEffect()

  val SealStageEffect = +skillOptionData(463).applyEffect()
  val LockedSealStageEffect = +skillOptionData(464).applyEffect()

  val FortitudeReduction = +skillOptionData(465).reduceCountable()

  // Some OR stuff here
  val OathDamageUp = +skillOptionData(469).applyEffect()

  val DisasterBrillianceReduction = +skillOptionData(470).applyEffect()

  val AbsorbBrilliance = +skillOptionData(471).makeSkillOption { value -> absorbBrilliance(value) }

  val BlessingHpRecovery = +skillOptionData(472).applyEffect()
  val BlessingCountableNegativeEffectReduction = +skillOptionData(473).applyEffect()
  val DisasterDaze = +skillOptionData(474).applyEffect()
  val BlessingRemoveContinuousNegtiveEffects = +skillOptionData(475).applyEffect()
  val DazeResistanceUp = +skillOptionData(476).applyEffect(AutoSkillType.TurnStartA)
  val LockedDazeResistanceUp = +skillOptionData(477).applyEffect(AutoSkillType.TurnStartA)
  val BlessingHope = +skillOptionData(478).applyEffect()
  val ImpudenceResistanceUp = +skillOptionData(479).applyEffect(AutoSkillType.TurnStartA)
  val LockedImpudenceResistanceUp = +skillOptionData(480).applyEffect(AutoSkillType.TurnStartA)

  fun SkillOptionData.scalingEffect(
      effect: ContinuousBuffEffect<Unit>,
      cap: Int,
      condition: (Actor) -> Boolean
  ) =
      makeDualSkillOption(
          activeAction = { value, time, chance ->
            val totalValue = (team.active.count { condition(it) } * value).coerceAtMost(cap)
            applyBuff(effect, value = totalValue, time = time, chance = chance)
          },
          passiveAction = { value ->
            val totalValue = (team.active.count { condition(it) } * value).coerceAtMost(cap)
            targets.forEach { target ->
              target.buffs.activatePsuedoBuff(effect, value = totalValue.toI54())
            }
          },
      )

  fun SkillOptionData.scalingActPowerUp(cap: Int, condition: (Actor) -> Boolean) =
      scalingEffect(Buffs.ActPowerUpBuff, cap, condition)

  fun SkillOptionData.scalingMaxHpUp(cap: Int, condition: (Actor) -> Boolean) =
      scalingEffect(Buffs.MaxHpUpBuff, cap, condition)

  fun SkillOptionData.scalingEvasionUp(cap: Int, condition: (Actor) -> Boolean) =
      scalingEffect(Buffs.EvasionUpBuff, cap, condition)

  fun SkillOptionData.scalingGreaterActPowerUp(cap: Int, condition: (Actor) -> Boolean) =
      scalingEffect(Buffs.GreaterActPowerUpBuff, cap, condition)

  val ScalingActPowerUp120FlowerWindSnow =
      +skillOptionData(481).scalingActPowerUp(120) {
        it.dress.attribute.let { attr ->
          attr == Attribute.Flower || attr == Attribute.Wind || attr == Attribute.Snow
        }
      }
  val ScalingActPowerUp120MoonSpaceCloud =
      +skillOptionData(482).scalingActPowerUp(120) {
        it.dress.attribute.let { attr ->
          attr == Attribute.Moon || attr == Attribute.Space || attr == Attribute.Cloud
        }
      }

  val SuperReflectNormal = +skillOptionData(483).applyEffect()
  val SuperReflectSpecial = +skillOptionData(484).applyEffect()
  val LockedSuperReflectNormal = +skillOptionData(485).applyEffect()
  val LockedSuperReflectSpecial = +skillOptionData(486).applyEffect()
  val BlessingEffectiveDamageUp = +skillOptionData(487).applyEffect()
  val ConversionReviveToWeakSpot =
      +skillOptionData(488).makeSkillOption { value, _ -> convert(ReviveBuff, WeakSpotBuff, value) }

  val HitRandom33DazeSeishoBoost =
      +skillOptionData(489).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seisho },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeRinmeikanBoost =
      +skillOptionData(490).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Rinmeikan },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeFrontierBoost =
      +skillOptionData(491).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Frontier },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeSiegfeldBoost =
      +skillOptionData(492).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Siegfeld },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeSeiranBoost =
      +skillOptionData(493).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seiran },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val InvincibleRebirth = +skillOptionData(494).applyEffect()
  val Sacrifice = +skillOptionData(495).applyEffect()
  val DisasterApUp = +skillOptionData(496).applyEffect()
  val BlessingApDown2 = +skillOptionData(497).applyEffect()
  val Contraction = +skillOptionData(498).applyEffect()
  val SealInstantSkill = +skillOptionData(499).applyEffect()
  val LockedSealInstantSkill = +skillOptionData(500).applyEffect()
  val CountablePositiveEffectResistanceUp =
      +skillOptionData(501).applyEffect(AutoSkillType.TurnStartA)
  val LockedCountablePositiveEffectResistanceUp =
      +skillOptionData(502).applyEffect(AutoSkillType.TurnStartA)

  val ScalingActPowerUp100Seisho =
      +skillOptionData(503).scalingActPowerUp(100) { it.dress.character.school == School.Seisho }
  val ScalingActPowerUp100Rinmeikan =
      +skillOptionData(504).scalingActPowerUp(100) { it.dress.character.school == School.Rinmeikan }
  val ScalingActPowerUp100Frontier =
      +skillOptionData(505).scalingActPowerUp(100) { it.dress.character.school == School.Frontier }
  val ScalingActPowerUp100Siegfeld =
      +skillOptionData(506).scalingActPowerUp(100) { it.dress.character.school == School.Siegfeld }
  val ScalingActPowerUp100Seiran =
      +skillOptionData(507).scalingActPowerUp(100) { it.dress.character.school == School.Seiran }

  val LockedPerfectAim = +skillOptionData(508).applyEffect()

  val ConversionCountableNegativeEffectToRevive =
      +skillOptionData(509).makeSkillOption { value, _ -> convertCountableNegative(value) }

  val StaminaActPowerUp = +skillOptionData(510).applyEffect()

  val Overwhelm =
      +skillOptionData(511).makeSkillOption { _ ->
        targets.forEach { target ->
          // Bypass resistances
          target.buffs.removeCountable(Buffs.OverwhelmBuff)
          target.buffs.addCountable(Buffs.OverwhelmBuff)
        }
      }

  val MultiCAfication = +skillOptionData(512).applyEffect()

  val ScalingActPowerUp40Flower =
      +skillOptionData(513).scalingActPowerUp(40) { it.dress.attribute == Attribute.Flower }
  val ScalingActPowerUp40Wind =
      +skillOptionData(514).scalingActPowerUp(40) { it.dress.attribute == Attribute.Wind }
  val ScalingActPowerUp40Snow =
      +skillOptionData(515).scalingActPowerUp(40) { it.dress.attribute == Attribute.Snow }
  val ScalingActPowerUp40Moon =
      +skillOptionData(516).scalingActPowerUp(40) { it.dress.attribute == Attribute.Moon }
  val ScalingActPowerUp40Space =
      +skillOptionData(517).scalingActPowerUp(40) { it.dress.attribute == Attribute.Space }
  val ScalingActPowerUp40Cloud =
      +skillOptionData(518).scalingActPowerUp(40) { it.dress.attribute == Attribute.Cloud }
  val ScalingActPowerUp40Dream =
      +skillOptionData(519).scalingActPowerUp(40) { it.dress.attribute == Attribute.Dream }

  val ScalingMaxHpUp40Flower =
      +skillOptionData(520).scalingMaxHpUp(40) { it.dress.attribute == Attribute.Flower }
  val ScalingMaxHpUp40Wind =
      +skillOptionData(521).scalingMaxHpUp(40) { it.dress.attribute == Attribute.Wind }
  val ScalingMaxHpUp40Snow =
      +skillOptionData(522).scalingMaxHpUp(40) { it.dress.attribute == Attribute.Snow }
  val ScalingMaxHpUp40Moon =
      +skillOptionData(523).scalingMaxHpUp(40) { it.dress.attribute == Attribute.Moon }
  val ScalingMaxHpUp40Space =
      +skillOptionData(524).scalingMaxHpUp(40) { it.dress.attribute == Attribute.Space }
  val ScalingMaxHpUp40Cloud =
      +skillOptionData(525).scalingMaxHpUp(40) { it.dress.attribute == Attribute.Cloud }
  val ScalingMaxHpUp40Dream =
      +skillOptionData(526).scalingMaxHpUp(40) { it.dress.attribute == Attribute.Dream }

  val ScalingActPowerUp100Flower =
      +skillOptionData(527).scalingActPowerUp(100) { it.dress.attribute == Attribute.Flower }
  val ScalingActPowerUp100Wind =
      +skillOptionData(528).scalingActPowerUp(100) { it.dress.attribute == Attribute.Wind }
  val ScalingActPowerUp100Snow =
      +skillOptionData(529).scalingActPowerUp(100) { it.dress.attribute == Attribute.Snow }
  val ScalingActPowerUp100Moon =
      +skillOptionData(530).scalingActPowerUp(100) { it.dress.attribute == Attribute.Moon }
  val ScalingActPowerUp100Space =
      +skillOptionData(531).scalingActPowerUp(100) { it.dress.attribute == Attribute.Space }
  val ScalingActPowerUp100Cloud =
      +skillOptionData(532).scalingActPowerUp(100) { it.dress.attribute == Attribute.Cloud }
  val ScalingActPowerUp100Dream =
      +skillOptionData(533).scalingActPowerUp(100) { it.dress.attribute == Attribute.Dream }

  val ScalingMaxHpUp150Flower =
      +skillOptionData(534).scalingMaxHpUp(150) { it.dress.attribute == Attribute.Flower }
  val ScalingMaxHpUp150Wind =
      +skillOptionData(535).scalingMaxHpUp(150) { it.dress.attribute == Attribute.Wind }
  val ScalingMaxHpUp150Snow =
      +skillOptionData(536).scalingMaxHpUp(150) { it.dress.attribute == Attribute.Snow }
  val ScalingMaxHpUp150Moon =
      +skillOptionData(537).scalingMaxHpUp(150) { it.dress.attribute == Attribute.Moon }
  val ScalingMaxHpUp150Space =
      +skillOptionData(538).scalingMaxHpUp(150) { it.dress.attribute == Attribute.Space }
  val ScalingMaxHpUp150Cloud =
      +skillOptionData(539).scalingMaxHpUp(150) { it.dress.attribute == Attribute.Cloud }
  val ScalingMaxHpUp150Dream =
      +skillOptionData(540).scalingMaxHpUp(150) { it.dress.attribute == Attribute.Dream }

  val ScalingEvasionUp60Flower =
      +skillOptionData(541).scalingEvasionUp(60) { it.dress.attribute == Attribute.Flower }
  val ScalingEvasionUp60Wind =
      +skillOptionData(542).scalingEvasionUp(60) { it.dress.attribute == Attribute.Wind }
  val ScalingEvasionUp60Snow =
      +skillOptionData(543).scalingEvasionUp(60) { it.dress.attribute == Attribute.Snow }
  val ScalingEvasionUp60Moon =
      +skillOptionData(544).scalingEvasionUp(60) { it.dress.attribute == Attribute.Moon }
  val ScalingEvasionUp60Space =
      +skillOptionData(545).scalingEvasionUp(60) { it.dress.attribute == Attribute.Space }
  val ScalingEvasionUp60Cloud =
      +skillOptionData(546).scalingEvasionUp(60) { it.dress.attribute == Attribute.Cloud }
  val ScalingEvasionUp60Dream =
      +skillOptionData(547).scalingEvasionUp(60) { it.dress.attribute == Attribute.Dream }

  val RemoveCountableNegativeEffects =
      +skillOptionData(548).makeSkillOption { _ -> removeCountable(BuffCategory.Negative) }

  val BrillianceSap = +skillOptionData(549).applyEffect()
  val LockedEffectiveDamageUp = +skillOptionData(550).applyEffect()

  val HitRandom33ImpudenceSeishoBoost =
      +skillOptionData(551).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seisho },
            effect = Buffs.ImpudenceBuff,
            value = 5000,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceRinmeikanBoost =
      +skillOptionData(552).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Rinmeikan },
            effect = Buffs.ImpudenceBuff,
            value = 5000,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceFrontierBoost =
      +skillOptionData(553).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Frontier },
            effect = Buffs.ImpudenceBuff,
            value = 5000,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceSiegfeldBoost =
      +skillOptionData(554).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Siegfeld },
            effect = Buffs.ImpudenceBuff,
            value = 5000,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceSeiranBoost =
      +skillOptionData(555).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seiran },
            effect = Buffs.ImpudenceBuff,
            value = 5000,
            time = 1,
            chance = 33,
        )
      }

  val LockedBrillianceRegen = +skillOptionData(556).applyEffect()
  val ReviveRegen = +skillOptionData(557).applyEffect()
  val LockedInvincibility = +skillOptionData(558).applyEffect()
  val SealStageEffectResistance = +skillOptionData(559).applyEffect(AutoSkillType.TurnStartA)
  val LockedSealStageEffectResistance = +skillOptionData(560).applyEffect(AutoSkillType.TurnStartA)
  val TurnRemoveContinuousNegativeEffects = +skillOptionData(561).applyEffect()
  val LockedTurnRemoveContinuousNegativeEffects = +skillOptionData(562).applyEffect()
  val TurnRemoveCountableNegativeEffects = +skillOptionData(563).applyEffect()
  val LockedTurnRemoveCountableNegativeEffects = +skillOptionData(564).applyEffect()
  val TurnRemoveContinuousPositiveEffects = +skillOptionData(565).applyEffect()
  val LockedTurnRemoveContinuousPositiveEffects = +skillOptionData(566).applyEffect()
  val SuperStrength = +skillOptionData(567).applyEffect()
  val SuperStrengthRegen = +skillOptionData(568).applyEffect()
  val LockedSuperStrengthRegen = +skillOptionData(569).applyEffect()
  val Cheer = +skillOptionData(570).applyEffect()

  val HitSunStarBoost =
      +skillOptionData(571).makeSkillOption { value, time, _, attribute ->
        attack(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            ampMultiplier = 150,
            ampCondition = {
              it.dress.attribute == Attribute.Sun || it.dress.attribute == Attribute.Star
            },
        )
      }

  val CountablePositiveEffectIncrease =
      +skillOptionData(572).makeSkillOption { value -> increaseCountablePositive(value) }

  val TurnReduceCountableNegativeEffects = +skillOptionData(573).applyEffect()
  val LockedTurnReduceCountableNegativeEffects = +skillOptionData(574).applyEffect()

  val BrillianceRegenTurnScaling = +skillOptionData(575).applyEffect()
  val LockedBrillianceRegenTurnScaling = +skillOptionData(576).applyEffect()

  val LockedAgony = +skillOptionData(577).applyEffect()

  val SealMultipleCA = +skillOptionData(578).applyEffect()
  val LockedSealMultipleCA = +skillOptionData(579).applyEffect()

  val ActBoostPride = +skillOptionData(580).applyEffect()

  val ShortenContinuousPositiveEffects =
      +skillOptionData(581).makeSkillOption { value ->
        shortenContinuous(BuffCategory.Positive, value)
      }

  val BlessingRemoveCountableNegativeEffect = +skillOptionData(582).applyEffect()

  val Delusion = +skillOptionData(583).applyEffect()

  val CutinCostReduction = +skillOptionData(584).applyEffect()
  val LockedCutinCostReduction = +skillOptionData(585).applyEffect()

  val ActBoostDaze = +skillOptionData(586).applyEffect()

  val HitRandom33DelusionSeishoBoost =
      +skillOptionData(587).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seisho },
            effect = Buffs.DelusionBuff,
            value = 20,
            time = 1,
            chance = 33,
        )
      }

  val Weaken = +skillOptionData(588).applyEffect()

  val StageEffectSealResistanceRegen = +skillOptionData(589).applyEffect()

  val InvincibleRebirthReduction = +skillOptionData(590).reduceCountable()

  val TurnReduceCountableNegativeEffectsBuff = +skillOptionData(591).applyEffect()
  val LockedTurnReduceCountableNegativeEffectsBuff = +skillOptionData(592).applyEffect()

  val ScalingActPowerUp80FlowerWindSnow =
      +skillOptionData(593).scalingActPowerUp(80) {
        it.dress.attribute.let { attr ->
          attr == Attribute.Flower || attr == Attribute.Wind || attr == Attribute.Snow
        }
      }

  val ScalingActPowerUp80MoonSpaceCloud =
      +skillOptionData(594).scalingActPowerUp(80) {
        it.dress.attribute.let { attr ->
          attr == Attribute.Moon || attr == Attribute.Space || attr == Attribute.Cloud
        }
      }

  val StealContinuousPositiveEffects =
      +skillOptionData(595).makeSkillOption { value ->
        // TODO
      }

  val StealCountablePositiveEffects =
      +skillOptionData(596).makeSkillOption { value ->
        // TODO
      }

  val AgonyResistanceUp = +skillOptionData(597).applyEffect()
  val LockedAgonyResistanceUp = +skillOptionData(598).applyEffect()

  val SealCAResistanceUp = +skillOptionData(599).applyEffect()
  val LockedSealCAResistanceUp = +skillOptionData(600).applyEffect()

  val AccuracyDownResistanceUp = +skillOptionData(601).applyEffect()
  val LockedAccuracyDownResistanceUp = +skillOptionData(602).applyEffect()

  val AgilityDownResistanceUp = +skillOptionData(603).applyEffect()
  val LockedAgilityDownResistanceUp = +skillOptionData(604).applyEffect()

  val DelusionResistanceUp = +skillOptionData(605).applyEffect()
  val LockedDelusionResistanceUp = +skillOptionData(606).applyEffect()

  val FallingOutDaze = +skillOptionData(607).applyEffect()

  val FallingOutImpudence = +skillOptionData(608).applyEffect()

  val ScalingActPowerUp150Flower =
      +skillOptionData(609).scalingActPowerUp(150) { it.dress.attribute == Attribute.Flower }

  val ScalingActPowerUp150Wind =
      +skillOptionData(610).scalingActPowerUp(150) { it.dress.attribute == Attribute.Wind }

  val ScalingActPowerUp150Snow =
      +skillOptionData(611).scalingActPowerUp(150) { it.dress.attribute == Attribute.Snow }

  val ScalingActPowerUp150Moon =
      +skillOptionData(612).scalingActPowerUp(150) { it.dress.attribute == Attribute.Moon }

  val ScalingActPowerUp150Space =
      +skillOptionData(613).scalingActPowerUp(150) { it.dress.attribute == Attribute.Space }

  val ScalingActPowerUp150Cloud =
      +skillOptionData(614).scalingActPowerUp(150) { it.dress.attribute == Attribute.Cloud }

  val ScalingActPowerUp150Dream =
      +skillOptionData(615).scalingActPowerUp(150) { it.dress.attribute == Attribute.Dream }

  val ContractionResistanceUp = +skillOptionData(616).applyEffect()
  val LockedContractionResistanceUp = +skillOptionData(617).applyEffect()

  val StealResistanceUp = +skillOptionData(618).applyEffect()

  val ConversionInvincibleRebirthToWeakSpot =
      +skillOptionData(619).makeSkillOption { value, _ ->
        convert(InvincibleRebirthBuff, WeakSpotBuff, value)
      }

  val ConversionFortitudeToInvincibleRebirth =
      +skillOptionData(620).makeSkillOption { value, _ ->
        convert(FortitudeBuff, InvincibleRebirthBuff, value)
      }

  val ConversionGreaterEvasionGreaterFortitude =
      +skillOptionData(621).makeSkillOption { value, _ ->
        convert(GreaterEvasionBuff, GreaterFortitudeBuff, value)
      }

  val ConversionGreaterFortitudeGreaterRevive =
      +skillOptionData(622).makeSkillOption { value, _ ->
        convert(GreaterFortitudeBuff, GreaterReviveBuff, value)
      }

  val ConversionGreaterFortitudeGreaterWeakSpot =
      +skillOptionData(623).makeSkillOption { value, _ ->
        convert(GreaterFortitudeBuff, GreaterWeakSpotBuff, value)
      }

  val HitRandom33GreaterDazeSeishoBoost =
      +skillOptionData(624).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seisho },
            effect = Buffs.GreaterDazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val HitRandom33GreaterDazeRinmeikanBoost =
      +skillOptionData(625).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Rinmeikan },
            effect = Buffs.GreaterDazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val HitRandom33GreaterDazeFrontierBoost =
      +skillOptionData(626).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Frontier },
            effect = Buffs.GreaterDazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val HitRandom33GreaterDazeSiegfeldBoost =
      +skillOptionData(627).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Siegfeld },
            effect = Buffs.GreaterDazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val HitRandom33GreaterDazeSeiranBoost =
      +skillOptionData(628).makeSkillOption { value, time, _, attribute ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            attribute = attribute,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seiran },
            effect = Buffs.GreaterDazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val Intimidate =
      +skillOptionData(629).makeSkillOption { _ ->
        targets.forEach { target ->
          target.buffs.removeCountable(BuffCategory.Positive, 2)
          // Bypass resistances
          target.buffs.removeCountable(Buffs.IntimidationBuff)
          target.buffs.addCountable(Buffs.IntimidationBuff)
        }
      }

  val GreaterBurn = +skillOptionData(10010).applyEffect()
  val GreaterConfusion = +skillOptionData(10020).applyEffect()
  val GreaterBlindness = +skillOptionData(10030).applyEffect()
  val GreaterFreeze = +skillOptionData(10040).applyEffect()
  val GreaterApUp = +skillOptionData(10050).applyEffect()
  val GreaterProvoke = +skillOptionData(10060).applyEffect()
  val GreaterBurnResistanceUp = +skillOptionData(10070).applyEffect()
  val GreaterBlindnessResistanceUp = +skillOptionData(10080).applyEffect()
  val GreaterConfusionResistanceUp = +skillOptionData(10090).applyEffect()
  val GreaterDamageReceivedDown = +skillOptionData(10100).applyEffect()
  val GreaterEvasion = +skillOptionData(10110).applyEffect()
  val GreaterStop = +skillOptionData(10120).applyEffect()
  val GreaterFortitude = +skillOptionData(10130).applyEffect()
  val GreaterFreezeResistanceUp = +skillOptionData(10140).applyEffect()
  val GreaterStopResistanceUp = +skillOptionData(10150).applyEffect()
  val GreaterFrostbite = +skillOptionData(10160).applyEffect()
  val GreaterElectricShock = +skillOptionData(10170).applyEffect()
  val GreaterAgony = +skillOptionData(10180).applyEffect()
  val GreaterAgonyResistanceUp = +skillOptionData(10190).applyEffect()
  val GreaterFrostbiteResistanceUp = +skillOptionData(10200).applyEffect()
  val GreaterStagnation = +skillOptionData(10210).applyEffect()
  val GreaterIgnorance = +skillOptionData(10220).applyEffect()
  val GreaterAggro = +skillOptionData(10230).applyEffect()
  val GreaterCriticalDamageReceivedDown = +skillOptionData(10240).applyEffect()
  val GreaterCombinedResistanceUp = +skillOptionData(10250).applyEffect()
  val GreaterInsanity = +skillOptionData(10260).applyEffect()
  val GreaterFixedClimaxActPowerUp = +skillOptionData(10270).applyEffect()
  val GreaterAPDown = +skillOptionData(10280).applyEffect()
  val GreaterSleep = +skillOptionData(10281).applyEffect()
  val GreaterCriticalUp = +skillOptionData(10282).applyEffect()
  val GreaterEffectiveDamageUp = +skillOptionData(10283).applyEffect()
  val GreaterArrogance = +skillOptionData(10284).applyEffect()
  val GreaterElectricShockResistanceUp = +skillOptionData(10285).applyEffect()
  val GreaterRevive = +skillOptionData(10286).applyEffect()
  val ExcludingGreaterArroganceResistanceUp = +skillOptionData(10289).applyEffect()
  val GreaterCombinedResistanceUpFreezeStop = +skillOptionData(10290).applyEffect()
  val GreaterStun = +skillOptionData(10291).applyEffect()
  val GreaterPerfectAim = +skillOptionData(10292).applyEffect()
  val GreaterSleepResistanceUp = +skillOptionData(10293).applyEffect()
  val GreaterApUpResistanceUp = +skillOptionData(10294).applyEffect()
  val GreaterInvincibility = +skillOptionData(10295).applyEffect()
  val ResistanceUpExceptGreaterInsanity = +skillOptionData(10296).applyEffect()
  val GreaterStunResistanceUp = +skillOptionData(10297).applyEffect()
  val GreaterMark = +skillOptionData(10298).applyEffect()
  val GreaterAgilityUp = +skillOptionData(10299).applyEffect()
  val GreaterBrillianceGainDown = +skillOptionData(10300).applyEffect()
  val GreaterSealAct3 = +skillOptionData(10301).applyEffect()
  val GreaterPierceInvincible = +skillOptionData(10302).applyEffect()
  val GreaterHope = +skillOptionData(10303).applyEffect()
  val GreaterMaxHpUp = +skillOptionData(10304).applyEffect()
  val GreaterLovesickness = +skillOptionData(10305).applyEffect()
  val GreaterDexterityUp = +skillOptionData(10306).applyEffect()
  val GreaterActPowerDown = +skillOptionData(10307).applyEffect()
  val GreaterCriticalDown = +skillOptionData(10308).applyEffect()
  val GreaterCombinedResistanceUpElectricShockSleep = +skillOptionData(10309).applyEffect()
  val GreaterHpRegen = +skillOptionData(10310).applyEffect()
  val GreaterBrillianceRegen = +skillOptionData(10311).applyEffect()
  val GreaterFortitudeReduction = +skillOptionData(10312).reduceCountable()
  val GreaterAgilityDown = +skillOptionData(10314).applyEffect()
  val GreaterCounterHeal = +skillOptionData(10315).applyEffect()
  val GreaterBlessingHpRecovery = +skillOptionData(10316).applyEffect()
  val GreaterAggroResistanceUp = +skillOptionData(10318).applyEffect()
  val GreaterSuperstrength = +skillOptionData(10319).applyEffect()
  val GreaterSealStageEffect = +skillOptionData(10320).applyEffect()
  val GreaterSealStageEffectResistanceUp = +skillOptionData(10321).applyEffect()
  val GreaterLovesicknessResistanceUp = +skillOptionData(10322).applyEffect()
  val GreaterMaxHpDown = +skillOptionData(10323).applyEffect()
  val GreaterPanic = +skillOptionData(10324).applyEffect()
  // Res up except greater panic
  val GreaterNightmare = +skillOptionData(10326).applyEffect()
  val GreaterNightmareResistanceUp = +skillOptionData(10327).applyEffect()
  val GreaterMultiCAfication = +skillOptionData(10328).applyEffect()
  val GreaterImpudence = +skillOptionData(10329).applyEffect()
  val GreaterReviveReduction = +skillOptionData(10330).reduceCountable()

  val ScalingGreaterActPowerUp100Flower =
      +skillOptionData(10331).scalingGreaterActPowerUp(100) {
        it.dress.attribute == Attribute.Flower
      }
  val ScalingGreaterActPowerUp100Wind =
      +skillOptionData(10332).scalingGreaterActPowerUp(100) { it.dress.attribute == Attribute.Wind }
  val ScalingGreaterActPowerUp100Snow =
      +skillOptionData(10333).scalingGreaterActPowerUp(100) { it.dress.attribute == Attribute.Snow }
  val ScalingGreaterActPowerUp100Moon =
      +skillOptionData(10334).scalingGreaterActPowerUp(100) { it.dress.attribute == Attribute.Moon }
  val ScalingGreaterActPowerUp100Space =
      +skillOptionData(10335).scalingGreaterActPowerUp(100) {
        it.dress.attribute == Attribute.Space
      }
  val ScalingGreaterActPowerUp100Cloud =
      +skillOptionData(10336).scalingGreaterActPowerUp(100) {
        it.dress.attribute == Attribute.Cloud
      }
  val ScalingGreaterActPowerUp100Dream =
      +skillOptionData(10337).scalingGreaterActPowerUp(100) {
        it.dress.attribute == Attribute.Dream
      }

  val GreaterActPowerUp = +skillOptionData(10338).applyEffect()
  val GreaterNormalReflect = +skillOptionData(10339).applyEffect()
  val GreaterSpecialReflect = +skillOptionData(10340).applyEffect()
  val GreaterPoison = +skillOptionData(10341).applyEffect()
  val GreaterCutinInitialCooldownReduction = +skillOptionData(10342).applyEffect()
  val GreaterCutinCostReduction = +skillOptionData(10343).applyEffect()
  // Dmg vs boss
  val GreaterInvincibleRebirth = +skillOptionData(10345).applyEffect()
  val GreaterSealClimate = +skillOptionData(10346).applyEffect()
  val GreaterApDown2 = +skillOptionData(10347).applyEffect()
  val GreaterCombinedResistanceUpStunLovesickness = +skillOptionData(10348).applyEffect()
  val GreaterApUp2 = +skillOptionData(10349).applyEffect()
  val GreaterMiraculousRecovery = +skillOptionData(10350).applyEffect()
  val GreaterImpudenceResistanceUp = +skillOptionData(10351).applyEffect()
  val GreaterSealAct2 = +skillOptionData(10352).applyEffect()
  val GreaterContraction = +skillOptionData(10353).applyEffect()
  val GreaterDisasterBrillianceReduction = +skillOptionData(10354).applyEffect()
  val GreaterDisasterGreaterApUp = +skillOptionData(10355).applyEffect()
  val GreaterSealAct1 = +skillOptionData(10356).applyEffect()
  val GreaterCheer = +skillOptionData(10357).applyEffect()
  val GreaterDamageDownResistanceUp = +skillOptionData(10358).applyEffect()
  val GreaterDamageDown = +skillOptionData(10359).applyEffect()
  val GreaterWeakSpot = +skillOptionData(10360).applyEffect()
  val GreaterDaze = +skillOptionData(10361).applyEffect()
  val GreaterSealClimaxAct = +skillOptionData(10362).applyEffect()
  val GreaterActBoostGreaterDaze = +skillOptionData(10363).applyEffect()
  val GreaterCombinedResistanceUpSealStageEffectApUp = +skillOptionData(10364).applyEffect()
  val GreaterPoisonEnhancementApUp2 = +skillOptionData(10365).applyEffect()
  val GreaterPoisonEnhancementMark = +skillOptionData(10366).applyEffect()
  val GreaterHinderGreaterApDown = +skillOptionData(10367).applyEffect()
  val GreaterPoisonEnhancementSealStageEffect = +skillOptionData(10368).applyEffect()
  val GreaterPoisonEnhancementApUp = +skillOptionData(10369).applyEffect()
  val GreaterPoisonEnhancementSealAct3 = +skillOptionData(10370).applyEffect()
  val GreaterDazeResistanceUp = +skillOptionData(10371).applyEffect()
  val GreaterDamageDealtUp = +skillOptionData(10372).applyEffect()
  val GreaterCombinedResistanceUpSealAct2SealAct3SealCA = +skillOptionData(10373).applyEffect()
  val GreaterSlump = +skillOptionData(10374).applyEffect()
  val GreaterFallingOutGreaterDaze = +skillOptionData(10375).applyEffect()
  val GreaterCountableNegativeEffectsResistanceUp = +skillOptionData(10376).applyEffect()
  val GreaterPoisonEnhancementBrillianceRecoveryReduction = +skillOptionData(10377).applyEffect()
  val GreaterActBoostGreaterImpudence = +skillOptionData(10378).applyEffect()
  val GreaterApUp3 = +skillOptionData(10379).applyEffect()
  val GreaterPoisonEnhancementBrillianceRecoveryReduction2 = +skillOptionData(10380).applyEffect()
  val GreaterActBoostGreaterPanic = +skillOptionData(10381).applyEffect()
  val GreaterPoisionResistanceUp = +skillOptionData(10382).applyEffect()
  // Blank
  val GreaterContinuousNegativeEffectsResistanceUp = +skillOptionData(10384).applyEffect()
  val GreaterGospelOfGlory = +skillOptionData(10385).applyEffect()
  // Blank
  val HinderGreaterApDown2 = +skillOptionData(10387).applyEffect()
  val GreaterFallingOutGreaterSlump = +skillOptionData(10388).applyEffect()
  val GreaterBrillianceRegenEnhancement = +skillOptionData(10389).applyEffect()
  val GreaterSlumpEnhancementApUp2 = +skillOptionData(10390).applyEffect()
  val GreaterSlumpEnhancementMark = +skillOptionData(10391).applyEffect()
  val GreaterDisheartening = +skillOptionData(10392).applyEffect()
  val GreaterCurtainsClosed =
      +skillOptionData(10393).makeSkillOption { _, _ ->
        // Do nothing
      }
  val GreaterSlumpEnhancementSealClimaxAct = +skillOptionData(10394).applyEffect()
  val GreaterSlumpEnhancementSealAct3 = +skillOptionData(10395).applyEffect()
  val GreaterBrillianceRecoveryUp = +skillOptionData(10396).applyEffect()
  val GreaterCombinedResistanceUpApUpApUp2ApUp3 = +skillOptionData(10397).applyEffect()
  val GreaterResilience = +skillOptionData(10398).applyEffect()
  val GreaterBlessingGreaterDispelCountableNegativeEffects = +skillOptionData(10399).applyEffect()
  val GreaterBlessingGreaterApDown2 = +skillOptionData(10400).applyEffect()
  // Blank
  val GreaterDisasterGreaterDisheartening = +skillOptionData(10402).applyEffect()
  val GreaterSlumpEnhancementBrillianceRecoveryDown = +skillOptionData(10403).applyEffect()
  val GreaterBlessingGreaterDispelContinuousNegativeEffects = +skillOptionData(10404).applyEffect()
  val GreaterApDown3 = +skillOptionData(10405).applyEffect()
  val GreaterSlumpResistanceUp = +skillOptionData(10406).applyEffect()
  val GreaterBrillianceSap = +skillOptionData(10407).applyEffect()
  val GreaterBrillianceGainDownResistanceUp = +skillOptionData(10409).applyEffect()
  val GreaterStunResistanceUp2 = +skillOptionData(10410).applyEffect()
  val UpgradeGreaterStunContraction = +skillOptionData(10411).applyEffect()
  val LockedGreaterApDown3 = +skillOptionData(10412).applyEffect()
  val GreaterLethargy = +skillOptionData(10413).applyEffect()
  val GreaterCombinedResistanceUpDazeImpudence = +skillOptionData(10414).applyEffect()
  val LockedGreaterStunEnhancementContraction = +skillOptionData(10415).applyEffect()
  val GreaterBlessingGreaterResilience = +skillOptionData(10416).applyEffect()
  val LockedGreaterStopResistanceUp2 = +skillOptionData(10417).applyEffect()
  val GreaterStunEnhancementSealAct1 = +skillOptionData(10418).applyEffect()
  val GreaterStunEnhancementSealClimaxAct = +skillOptionData(10419).applyEffect()
  val LockedGreaterStunEnhancementSealAct1 = +skillOptionData(10420).applyEffect()
  val LockedGreaterStunEnhancementSealClimaxAct = +skillOptionData(10421).applyEffect()
  val GreaterMastery = +skillOptionData(10422).applyEffect()
  val GreaterStunEnhancementGreaterDisheartening = +skillOptionData(10423).applyEffect()
  val LockedGreaterStunEnhancementGreaterDisheartening = +skillOptionData(10424).applyEffect()
  val LockedGreaterLovesickness = +skillOptionData(10425).applyEffect()
  val GreaterInvincibleRebirthReduction = +skillOptionData(10426).reduceCountable()
  val LockedGreaterApUp = +skillOptionData(10427).applyEffect()
  val LockedGreaterSlump = +skillOptionData(10428).applyEffect()
  val LockedGreaterCombinedResistanceUpConfusionBlindnessBurn =
      +skillOptionData(10429).applyEffect()
  val LockedGreaterCombinedResistanceUpFreezeStop = +skillOptionData(10430).applyEffect()
  val LockedGreaterCombinedResistanceUpShockSleep = +skillOptionData(10431).applyEffect()
  val LockedGreaterCombinedResistanceUpStunLovesickness = +skillOptionData(10432).applyEffect()
  val EndOfThePerformance =
      +skillOptionData(10433).makeSkillOption { _, _ ->
        // Do nothing
      }
  val LockedGreaterContinuousNegativeEffectsResistanceUp = +skillOptionData(10434).applyEffect()
  val LockedGreaterCountableNegativeEffectsResistanceUp = +skillOptionData(10435).applyEffect()
  val LockedGreaterResilience = +skillOptionData(10436).applyEffect()
  val GreaterBlessingGreaterEffectiveDamageUp = +skillOptionData(10437).applyEffect()
  val LockedGreaterApUp2 = +skillOptionData(10438).applyEffect()

  // Skip

  val LockedGreaterLethargy = +skillOptionData(10440).applyEffect()

  val GreaterStealContinuousPositiveEffects =
      +skillOptionData(10441).makeSkillOption { _, _ ->
        // TODO: implement
      }

  // TODO: figure out if these affect base

  val RemoveGreaterBurn =
      +skillOptionData(20001)
          .removeContinuousEffects(
              Buffs.GreaterBurnBuff,
          )

  val RemoveGreaterConfusion =
      +skillOptionData(20002)
          .removeContinuousEffects(
              Buffs.GreaterConfusionBuff,
          )

  val RemoveGreaterBlindness =
      +skillOptionData(20003)
          .removeContinuousEffects(
              Buffs.GreaterBlindnessBuff,
          )

  val RemoveGreaterStop =
      +skillOptionData(20004)
          .removeContinuousEffects(
              Buffs.GreaterStopBuff,
          )

  val RemoveGreaterFreeze =
      +skillOptionData(20005)
          .removeContinuousEffects(
              Buffs.GreaterFreezeBuff,
          )

  val RemoveGreaterElectricShock =
      +skillOptionData(20006)
          .removeContinuousEffects(
              Buffs.GreaterElectricShockBuff,
          )

  val RemoveGreaterConfusionResistanceUp =
      +skillOptionData(20007)
          .removeContinuousEffects(
              Buffs.GreaterConfusionResistanceUpBuff,
          )

  val RemoveGreaterBurnResistanceUp =
      +skillOptionData(20008)
          .removeContinuousEffects(
              Buffs.GreaterBurnResistanceUpBuff,
          )

  val RemoveGreaterFreezeResistanceUp =
      +skillOptionData(20009)
          .removeContinuousEffects(
              Buffs.GreaterFreezeResistanceUpBuff,
          )

  val RemoveGreaterApUp =
      +skillOptionData(20010)
          .removeContinuousEffects(
              Buffs.GreaterApUpBuff,
          )

  val RemoveGreaterSleep =
      +skillOptionData(20011)
          .removeContinuousEffects(
              Buffs.GreaterSleepBuff,
          )

  val RemoveGreaterStopResistanceUp =
      +skillOptionData(20012)
          .removeContinuousEffects(
              Buffs.GreaterStopResistanceUpBuff,
          )

  val RemoveGreaterStun =
      +skillOptionData(20013)
          .removeContinuousEffects(
              Buffs.GreaterStunBuff,
          )

  val RemoveGreaterAggro =
      +skillOptionData(20014)
          .removeContinuousEffects(
              Buffs.GreaterAggroBuff,
          )

  val RemoveGreaterLovesickness =
      +skillOptionData(20015)
          .removeContinuousEffects(
              Buffs.GreaterLovesicknessBuff,
          )

  val RemoveGreaterApDown =
      +skillOptionData(20016)
          .removeContinuousEffects(
              Buffs.GreaterApDownBuff,
          )

  val GreaterDispelStunResistanceUp =
      +skillOptionData(20017)
          .removeContinuousEffects(
              Buffs.GreaterStunResistanceUpBuff,
          )

  val GreaterDispelImpudence =
      +skillOptionData(20018)
          .copy(params = listOf(Buffs.GreaterImpudenceBuff.id!!))
          .removeAllCountable()

  val GreaterDispelLovesicknessResistanceUp =
      +skillOptionData(20019)
          .removeContinuousEffects(
              Buffs.GreaterLovesicknessResistanceUpBuff,
          )

  val GreaterDispelDaze = +skillOptionData(20020).removeAllCountable()

  val GreaterDispelApDown2 =
      +skillOptionData(20021)
          .removeContinuousEffects(
              Buffs.GreaterApDown2Buff,
          )

  val GreaterDispelPoisonResistanceUp =
      +skillOptionData(20022)
          .removeContinuousEffects(
              Buffs.GreaterPoisonResistanceUpBuff,
          )

  val GreaterDispelContinuousNegativeEffects =
      +skillOptionData(20023).makeSkillOption { _ -> removeContinuous(BuffCategory.Negative, 2) }

  val GreaterDispelCountableNegativeEffects =
      +skillOptionData(20024).makeSkillOption { _ ->
        removeCountableLevel(BuffCategory.Negative, 2)
      }

  val GreaterDispelNegativeEffects =
      +skillOptionData(20025).makeSkillOption { _ ->
        removeCountableLevel(BuffCategory.Negative, 2)
        removeContinuous(BuffCategory.Negative, 2)
      }

  private val resistanceBuffs =
      Buffs.values.filterIsInstance<ContinuousBuffEffect<*>>().filter { it.isResistance }
  val GreaterDispelAllResistanceUp =
      +skillOptionData(20026).makeSkillOption { _ ->
        resistanceBuffs.forEach { removeContinuous(it) }
      }

  val GreaterDispelGreaterCombinedResistanceUpStunLovesickness =
      +skillOptionData(20027).makeSkillOption { _ ->
        removeContinuous(Buffs.GreaterCombinedResistanceUpStunLovesicknessBuff)
      }

  val GreaterDispelContinuousPositiveEffects =
      +skillOptionData(20028).makeSkillOption { _ -> removeContinuous(BuffCategory.Positive, 2) }

  val GreaterDispelGreaterCombinedResistanceUpFreezeStop =
      +skillOptionData(20029).makeSkillOption { _ ->
        removeContinuous(Buffs.GreaterCombinedResistanceUpFreezeStopBuff)
      }

  val GreaterDispelCountableNegativeEffectsResistanceUp =
      +skillOptionData(20030).makeSkillOption { _ ->
        removeContinuous(Buffs.GreaterContinuousNegativeEffectResistanceUpBuff)
      }
}
