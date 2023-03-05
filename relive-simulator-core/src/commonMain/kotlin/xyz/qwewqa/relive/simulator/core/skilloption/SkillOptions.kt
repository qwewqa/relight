@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package xyz.qwewqa.relive.simulator.core.skilloption

import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkillType
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.School

object SkillOptions : ImplementationRegistry<SkillOption>() {
  // Note that some buffs have separate percent and fixed versions.
  // The only difference is the description, the actual effect checks whether the value is <= 100.

  fun SkillOptionData.simpleAttack() = makeSkillOption { value, time, chance ->
    attack(modifier = value, hitCount = time)
  }

  fun SkillOptionData.elementalFixedAttack() = makeSkillOption { value, time, chance ->
    attack(modifier = value, hitCount = time, mode = HitMode.ELEMENTAL_FIXED)
  }

  @Suppress("UNCHECKED_CAST")
  fun SkillOptionData.applyEffect(
      activeType: AutoSkillType = AutoSkillType.TurnStartB
  ): SkillOption {
    return when (val effect = Buffs[params[0]] ?: error("No buff effect for ${params[0]}")) {
      is TimedBuffEffect<*> -> {
        makeDualSkillOption(
            activeType = activeType,
            activeAction = { value, time, chance ->
              applyTimedBuff(effect = effect, value = value, turns = time, chance = chance)
            },
            passiveAction = { value ->
              targets.forEach { target ->
                target.buffs.activatePsuedoBuff(effect as TimedBuffEffect<Unit>, value = value)
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

  fun SkillOptionData.dispelTimedEffect(): ActiveSkillOption {
    val effect = Buffs[params[0]] as? TimedBuffEffect<*> ?: error("No buff effect for ${params[0]}")
    return makeSkillOption { value, time -> dispelTimed(effect = effect) }
  }

  fun SkillOptionData.reduceCountable(): ActiveSkillOption {
    val effect =
        Buffs[params[0]] as? CountableBuffEffect ?: error("No buff effect for ${params[0]}")
    return makeSkillOption { _, time ->
      targets.forEach { target -> repeat(time) { target.buffs.remove(effect) } }
    }
  }

  fun SkillOptionData.removeAllCountable(): ActiveSkillOption {
    val effect =
        Buffs[params[0]] as? CountableBuffEffect ?: error("No buff effect for ${params[0]}")
    return makeSkillOption { _ ->
      targets.forEach { target ->
        repeat(target.buffs.count(effect)) { target.buffs.remove(effect) }
      }
    }
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
  val BrillianceRecovery = +skillOptionData(89).makeSkillOption { value -> addBrilliance(value) }

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

  //    val DispelStatBuffs = +skillOptionData(101).makeSkillOption {  }
  //    val DispelStatDebuffs = +skillOptionData(102).makeSkillOption {  }
  val DispelPoison = +skillOptionData(103).dispelTimedEffect()
  val DispelBurn = +skillOptionData(104).dispelTimedEffect()
  val DispelProvoke = +skillOptionData(105).dispelTimedEffect()
  val DispelStun = +skillOptionData(106).dispelTimedEffect()
  val DispelSleep = +skillOptionData(107).dispelTimedEffect()
  val DispelConfusion = +skillOptionData(108).dispelTimedEffect()
  val DispelStop = +skillOptionData(109).dispelTimedEffect()
  val DispelFreeze = +skillOptionData(110).dispelTimedEffect()
  val DispelBlindness = +skillOptionData(111).dispelTimedEffect()
  val DispelHpRecoveryReduction = +skillOptionData(112).dispelTimedEffect()
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
  val DispelContinuousPositiveEffects =
      +skillOptionData(127).makeSkillOption { _ -> dispelTimed(BuffCategory.Positive) }
  val DispelContinuousNegativeEffects =
      +skillOptionData(128).makeSkillOption { _ -> dispelTimed(BuffCategory.Negative) }

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
        flipTimed(category = BuffCategory.Negative, count = time)
      }
  val Aggro = +skillOptionData(152).applyEffect()
  val AggroResistanceUp = +skillOptionData(153).applyEffect(AutoSkillType.TurnStartA)
  val DispelAggro = +skillOptionData(154).dispelTimedEffect()
  val ExitEvasion = +skillOptionData(155).applyEffect()
  val Invincible = +skillOptionData(156).applyEffect()
  val ApDown = +skillOptionData(157).applyEffect()

  val ApUp = +skillOptionData(224).applyEffect()
  val ApUpResistanceUp = +skillOptionData(225).applyEffect(AutoSkillType.TurnStartA)

  val HitRandom20Stop1t =
      +skillOptionData(230).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
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

  val DispelContinuousEffects =
      +skillOptionData(239).makeSkillOption { _ ->
        dispelTimed(BuffCategory.Positive)
        dispelTimed(BuffCategory.Negative)
      }
  val AllEffectsResistanceUp = +skillOptionData(240).applyEffect(AutoSkillType.TurnStartA)

  val CounterHealPercent = +skillOptionData(241).applyEffect()

  val NormalBarrierPercent =
      +skillOptionData(242).makeSkillOption { value, time, chance ->
        applyTimedBuff(
            effect = Buffs.NormalBarrierBuff,
            value = { target: Actor -> target.maxHp * value / 100 },
            turns = time,
            chance = chance,
        )
      }
  val SpecialBarrierPercent =
      +skillOptionData(243).makeSkillOption { value, time, chance ->
        applyTimedBuff(
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
  val DispelSealAct1 = +skillOptionData(256).dispelTimedEffect()
  val DispelSealAct2 = +skillOptionData(257).dispelTimedEffect()
  val DispelSealAct3 = +skillOptionData(258).dispelTimedEffect()
  val BrillianceRecoveryDown = +skillOptionData(259).applyEffect()
  val BrillianceRecoveryDownResistanceUp =
      +skillOptionData(260).applyEffect(AutoSkillType.TurnStartA)
  val DispelBrillianceRecoveryDown = +skillOptionData(261).dispelTimedEffect()

  val HitRandom20Stun2t =
      +skillOptionData(262).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.StunBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Sleep2t =
      +skillOptionData(263).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.SleepBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Confusion2t =
      +skillOptionData(264).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.ConfusionBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Freeze2t =
      +skillOptionData(265).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.FreezeBuff,
            value = 0,
            time = 2,
            chance = 20,
        )
      }
  val HitRandom20Blindness2t =
      +skillOptionData(266).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
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
      +skillOptionData(276).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.PoisonBuff in it.buffs })
      }
  val AttackBurnBoost =
      +skillOptionData(277).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.BurnBuff in it.buffs })
      }
  val AttackProvokeBoost =
      +skillOptionData(278).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.ProvokeBuff in it.buffs })
      }
  val AttackStunBoost =
      +skillOptionData(279).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.StunBuff in it.buffs })
      }
  val AttackSleepBoost =
      +skillOptionData(280).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.SleepBuff in it.buffs })
      }
  val AttackConfusionBoost =
      +skillOptionData(281).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.ConfusionBuff in it.buffs })
      }
  val AttackStopBoost =
      +skillOptionData(282).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.StopBuff in it.buffs })
      }
  val AttackFreezeBoost =
      +skillOptionData(283).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.FreezeBuff in it.buffs })
      }
  val AttackBlindnessBoost =
      +skillOptionData(284).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.BlindnessBuff in it.buffs })
      }
  val AttackHpRecoveryDownBoost =
      +skillOptionData(285).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.HpRecoveryDownBuff in it.buffs })
      }
  val AttackMarkBoost =
      +skillOptionData(286).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.MarkBuff in it.buffs })
      }
  val AttackAggroBoost =
      +skillOptionData(287).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.AggroBuff in it.buffs })
      }
  val AttackApUpBoost =
      +skillOptionData(288).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.ApUpBuff in it.buffs })
      }
  val AttackSealAct1Boost =
      +skillOptionData(289).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.SealAct1Buff in it.buffs })
      }
  val AttackSealAct2Boost =
      +skillOptionData(290).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.SealAct2Buff in it.buffs })
      }
  val AttackSealAct3Boost =
      +skillOptionData(291).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.SealAct3Buff in it.buffs })
      }
  val AttackBrillianceGainDownBoost =
      +skillOptionData(292).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.BrillianceGainDownBuff in it.buffs })
      }

  val ActChange = +skillOptionData(293).applyEffect()
  val ReduceActChange = +skillOptionData(294).reduceCountable()
  val DispelActChange = +skillOptionData(295).removeAllCountable()
  val ActChangeContinuous = +skillOptionData(296).applyEffect()
  val DispelActChangeContinuous = +skillOptionData(297).dispelTimedEffect()

  val LockedConfusion = +skillOptionData(298).applyEffect()

  val Resilience = +skillOptionData(299).applyEffect()

  val LockedPoison = +skillOptionData(300).applyEffect()
  val LockedBurn = +skillOptionData(301).applyEffect()
  val LockedBlindness = +skillOptionData(302).applyEffect()
  val LockedStrongPoison = +skillOptionData(303).applyEffect()
  val LockedHeavyBurn = +skillOptionData(304).applyEffect()

  val AttackNormalBoost125 =
      +skillOptionData(305).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.damageType == DamageType.Normal })
      }
  val AttackNormalBoost150 =
      +skillOptionData(306).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.damageType == DamageType.Normal })
      }
  val AttackSpecialBoost125 =
      +skillOptionData(307).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.damageType == DamageType.Special })
      }
  val AttackSpecialBoost150 =
      +skillOptionData(308).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.damageType == DamageType.Special })
      }

  // TODO: remove exit

  val FocusAttack =
      +skillOptionData(310).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            focus = true,
        )
      }

  val LockedHpRecoveryDown = +skillOptionData(311).applyEffect()

  // TODO: 312, 313 : DoT dispel/resistance

  val AttackElementalSetDamage7Hit = +skillOptionData(314).elementalFixedAttack()
  val AttackElementalSetDamage8Hit = +skillOptionData(315).elementalFixedAttack()
  val AttackElementalSetDamage9Hit = +skillOptionData(316).elementalFixedAttack()
  val AttackElementalSetDamage10Hit = +skillOptionData(317).elementalFixedAttack()

  // TODO: Implement buffs
  //    val StrongPoisonResistanceUp = +skillOptionData(318).applyEffect(AutoSkillType.TurnStartA)
  //    val HeavyBurnResistanceUp = +skillOptionData(319).applyEffect(AutoSkillType.TurnStartA)

  val AttackNonElementalSetDamage =
      +skillOptionData(320).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            mode = HitMode.FIXED,
        )
      }

  // TODO: ignore fortitude, exit if hp < 0

  val FlipPositiveEffects =
      +skillOptionData(323).makeSkillOption { _, time ->
        flipTimed(BuffCategory.Positive, count = time)
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

  val DispelPositiveEffects =
      +skillOptionData(338).makeSkillOption { _ ->
        dispelTimed(BuffCategory.Positive)
        dispelCountable(BuffCategory.Positive)
      }

  val ClimaxActDamageDown = +skillOptionData(339).applyEffect()

  val Lovesickness = +skillOptionData(340).applyEffect()
  val LockedLovesickness = +skillOptionData(341).applyEffect()
  val LovesicknessResistanceUp = +skillOptionData(342).applyEffect(AutoSkillType.TurnStartA)
  val LockedLovesicknessResistanceUp = +skillOptionData(343).applyEffect(AutoSkillType.TurnStartA)
  val DispelLovesickness = +skillOptionData(344).dispelTimedEffect()
  val AttackLovesicknessBoost =
      +skillOptionData(345).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.LovesicknessBuff in it.buffs })
      }

  val LockedContinuousNegativeEffectResistanceUp =
      +skillOptionData(346).applyEffect(AutoSkillType.TurnStartA)
  val BrillianceReduction =
      +skillOptionData(347).makeSkillOption { value -> removeBrilliance(value) }

  val SealClimaxAct = +skillOptionData(348).applyEffect()
  val LockedSealClimaxAct = +skillOptionData(349).applyEffect()

  val DispelContinuousNegativeEffectResistanceUp = +skillOptionData(350).dispelTimedEffect()
  val DispelContinuousNegativeEffectResistanceDown = +skillOptionData(351).dispelTimedEffect()

  val ShockFixed = +skillOptionData(352).applyEffect()
  //    val ShockPercent = +skillOptionData(353).applyEffect()
  val LockedShockFixed = +skillOptionData(354).applyEffect()
  //    val LockedShockPercent = +skillOptionData(355).applyEffect()
  val ShockResistanceUp = +skillOptionData(356).applyEffect(AutoSkillType.TurnStartA)
  val LockedShockResistanceUp = +skillOptionData(357).applyEffect(AutoSkillType.TurnStartA)
  val DispelShock = +skillOptionData(358).dispelTimedEffect()
  val AttackShockBoost =
      +skillOptionData(359).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { Buffs.ElectricShockBuff in it.buffs })
      }

  val ReviveBuff = +skillOptionData(360).applyEffect()

  val AttackSeishoBoost150 =
      +skillOptionData(361).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seisho })
      }
  val AttackRinmeikanBoost150 =
      +skillOptionData(362).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Rinmeikan })
      }
  val AttackFrontierBoost150 =
      +skillOptionData(363).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Frontier })
      }
  val AttackSiegfeldBoost150 =
      +skillOptionData(364).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Siegfeld })
      }
  val AttackSeiranBoost150 =
      +skillOptionData(365).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 150,
            bonusCondition = { it.dress.character.school == School.Seiran })
      }
  // TODO: other boosts

  val HitRandom33Stop1t =
      +skillOptionData(371).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.StopBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33Stun2t =
      +skillOptionData(372).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.StunBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Sleep2t =
      +skillOptionData(373).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.SleepBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Confusion2t =
      +skillOptionData(374).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.ConfusionBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Freeze2t =
      +skillOptionData(375).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.FreezeBuff,
            value = 0,
            time = 2,
            chance = 33,
        )
      }
  val HitRandom33Blindness2t =
      +skillOptionData(376).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
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

  val DispelCountablePositiveEffects =
      +skillOptionData(383).makeSkillOption { _ -> dispelCountable(BuffCategory.Positive) }

  val Daze = +skillOptionData(384).applyEffect()
  val Impudence = +skillOptionData(385).applyEffect()

  val AttackFocusSeishoBoost =
      +skillOptionData(386).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Seisho },
            focus = true,
        )
      }
  val AttackFocusRinmeikanBoost =
      +skillOptionData(387).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Rinmeikan },
            focus = true,
        )
      }
  val AttackFocusFrontierBoost =
      +skillOptionData(388).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Frontier },
            focus = true,
        )
      }
  val AttackFocusSiegfeldBoost =
      +skillOptionData(389).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Siegfeld },
            focus = true,
        )
      }
  val AttackFocusSeiranBoost =
      +skillOptionData(390).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Seiran },
            focus = true,
        )
      }

  val HitRandom33Impudence5000v1x =
      +skillOptionData(391).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            effect = Buffs.ImpudenceBuff,
            value = 5000,
            time = 1,
            chance = 33,
        )
      }

  val Hope = +skillOptionData(392).applyEffect()

  val HitRandom33Daze1x =
      +skillOptionData(393).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
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
      +skillOptionData(397).makeSkillOption { value, time ->
        attack(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.id in DressCategory.Arcana.ids },
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

  val CountableNegativeEffectsReduction =
      +skillOptionData(444).makeSkillOption { _, time ->
        dispelCountable(BuffCategory.Negative, count = time)
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
        dispelCountable(BuffCategory.Positive, count = time)
      }

  val ReviveReduction = +skillOptionData(454).reduceCountable()

  val CutinInitialCooldownReduction = +skillOptionData(455).applyEffect()

  val HoldBack = +skillOptionData(460).applyEffect()

  val DispelCountableNegativeEffectResistance = +skillOptionData(462).dispelTimedEffect()

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
  val BlessingDispelContinuousNegtiveEffects = +skillOptionData(475).applyEffect()
  val DazeResistanceUp = +skillOptionData(476).applyEffect(AutoSkillType.TurnStartA)
  val LockedDazeResistanceUp = +skillOptionData(477).applyEffect(AutoSkillType.TurnStartA)
  val BlessingHope = +skillOptionData(478).applyEffect()
  val ImpudenceResistanceUp = +skillOptionData(479).applyEffect(AutoSkillType.TurnStartA)
  val LockedImpudenceResistanceUp = +skillOptionData(480).applyEffect(AutoSkillType.TurnStartA)

  fun SkillOptionData.scalingEffect(
      effect: TimedBuffEffect<Unit>,
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
              target.buffs.activatePsuedoBuff(effect, value = totalValue)
            }
          },
      )

  fun SkillOptionData.scalingActPowerUp(cap: Int, condition: (Actor) -> Boolean) =
      scalingEffect(Buffs.ActPowerUpBuff, cap, condition)
  fun SkillOptionData.scalingMaxHpUp(cap: Int, condition: (Actor) -> Boolean) =
      scalingEffect(Buffs.MaxHpUpBuff, cap, condition)
  fun SkillOptionData.scalingEvasionUp(cap: Int, condition: (Actor) -> Boolean) =
      scalingEffect(Buffs.EvasionUpBuff, cap, condition)

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
      +skillOptionData(488).makeSkillOption { _, time -> convertRevive(time) }

  val HitRandom33DazeSeishoBoost =
      +skillOptionData(489).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Seisho },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeRinmeikanBoost =
      +skillOptionData(490).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Rinmeikan },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeFrontierBoost =
      +skillOptionData(491).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Frontier },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeSiegfeldBoost =
      +skillOptionData(492).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Siegfeld },
            effect = Buffs.DazeBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33DazeSeiranBoost =
      +skillOptionData(493).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
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
      +skillOptionData(509).makeSkillOption { _, time -> convertCountableNegative(time) }

  val StaminaActPowerUp = +skillOptionData(510).applyEffect()

  val Overwhelm =
      +skillOptionData(511).makeSkillOption { _ ->
        targets.forEach { target ->
          // Bypass resistances
          target.buffs.dispelCountable(Buffs.OverwhelmBuff)
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

  val DispelCountableNegativeEffects =
      +skillOptionData(548).makeSkillOption { _ -> dispelCountable(BuffCategory.Negative) }

  val BrillianceSap = +skillOptionData(549).applyEffect()
  val LockedEffectiveDamageUp = +skillOptionData(550).applyEffect()

  val HitRandom33ImpudenceSeishoBoost =
      +skillOptionData(551).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Seisho },
            effect = Buffs.ImpudenceBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceRinmeikanBoost =
      +skillOptionData(552).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Rinmeikan },
            effect = Buffs.ImpudenceBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceFrontierBoost =
      +skillOptionData(553).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Frontier },
            effect = Buffs.ImpudenceBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceSiegfeldBoost =
      +skillOptionData(554).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Siegfeld },
            effect = Buffs.ImpudenceBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }
  val HitRandom33ImpudenceSeiranBoost =
      +skillOptionData(555).makeSkillOption { value, time ->
        attackWithDebuff(
            modifier = value,
            hitCount = time,
            bonusMultiplier = 200,
            bonusCondition = { it.dress.character.school == School.Seiran },
            effect = Buffs.ImpudenceBuff,
            value = 0,
            time = 1,
            chance = 33,
        )
      }

  val LockedBrillianceRegeneration = +skillOptionData(556).applyEffect()
  val ReviveRegeneration = +skillOptionData(557).applyEffect()
  val LockedInvincibility = +skillOptionData(558).applyEffect()
  val SealStageEffectResistance = +skillOptionData(559).applyEffect(AutoSkillType.TurnStartA)
}
