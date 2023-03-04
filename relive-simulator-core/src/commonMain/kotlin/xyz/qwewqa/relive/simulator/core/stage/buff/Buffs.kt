package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.abnormalCountableBuffs
import xyz.qwewqa.relive.simulator.core.stage.modifier.*
import xyz.qwewqa.relive.simulator.core.stage.platformSetOf
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.School

object Buffs : ImplementationRegistry<BuffEffect>() {
  private fun BuffData.makeDamageOverTimeBuffEffect(
      modifier: Modifier,
      exclusive: Boolean = false,
      locked: Boolean = false,
  ) =
      makeSimpleTimedBuffEffect(
          category = BuffCategory.Negative,
          exclusive = exclusive,
          locked = locked,
          onStart = { value ->
            val damage =
                if (value <= 100) {
                  self.mod { +maxHp pfmul value }.coerceAtMost(99_999)
                } else {
                  value
                }
            self.mod { modifier += damage }
          },
          onEnd = { value ->
            val damage =
                if (value <= 100) {
                  self.mod { +maxHp pfmul value }.coerceAtMost(99_999)
                } else {
                  value
                }
            self.mod { modifier -= damage }
          },
      )

  private fun BuffData.makeSpecificResistanceUpBuff(
      buff: BuffEffect,
      locked: Boolean = false,
  ) =
      makeSimpleTimedBuffEffect(
          category = BuffCategory.Positive,
          locked = locked,
          onStart = { value ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + value
          },
          onEnd = { value ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) - value
          },
      )

  private inline fun <T> BuffData.makeMapModifierTimedBuffEffect(
      crossinline mapAccessor: (Actor) -> MutableMap<T, Int>,
      key: T,
      category: BuffCategory,
      locked: Boolean = false,
      exclusive: Boolean = false,
  ) =
      makeSimpleTimedBuffEffect(
          category = category,
          locked = locked,
          exclusive = exclusive,
          onStart = { value -> mapAccessor(self)[key] = (mapAccessor(self)[key] ?: 0) + value },
          onEnd = { value -> mapAccessor(self)[key] = (mapAccessor(self)[key] ?: 0) - value },
      )

  private fun BuffData.againstAttributeDamageReceivedUpBuff(attribute: Attribute) =
      makeSimpleTimedBuffEffect(
          category = BuffCategory.Negative,
          onStart = { value -> self.againstAttributeDamageReceivedDown[attribute] -= value },
          onEnd = { value -> self.againstAttributeDamageReceivedDown[attribute] += value })

  private fun BuffData.againstAttributeDamageReceivedDownBuff(attribute: Attribute) =
      makeSimpleTimedBuffEffect(
          category = BuffCategory.Positive,
          onStart = { value -> self.againstAttributeDamageReceivedDown[attribute] += value },
          onEnd = { value -> self.againstAttributeDamageReceivedDown[attribute] -= value })

  private fun BuffData.againstAttributeDamageDealtUpBuff(attribute: Attribute) =
      makeSimpleTimedBuffEffect(
          category = BuffCategory.Positive,
          onStart = { value -> self.againstAttributeDamageDealtUp[attribute] += value },
          onEnd = { value -> self.againstAttributeDamageDealtUp[attribute] -= value })

  private fun BuffData.attributeDamageDealtUpBuff(attribute: Attribute) =
      makeSimpleTimedBuffEffect(
          category = BuffCategory.Positive,
          onStart = { value -> self.attributeDamageDealtUp[attribute] += value },
          onEnd = { value -> self.attributeDamageDealtUp[attribute] -= value })

  private fun BuffData.attributeDamageDealtDownBuff(attribute: Attribute) =
      makeSimpleTimedBuffEffect(
          category = BuffCategory.Negative,
          onStart = { value -> self.attributeDamageDealtUp[attribute] -= value },
          onEnd = { value -> self.attributeDamageDealtUp[attribute] += value })

  val poisonDamage = modifier("poisonDamage")
  val burnDamage = modifier("burnDamage")
  val frostbiteDamage = modifier("frostbiteDamage")
  val nightmareDamage = modifier("nightmareDamage")

  val ActPowerUpBuff: TimedBuffEffect<Unit> =
      +buffData(1)
          .makeModifierTimedBuffEffect(
              modifier = actPowerUp,
              category = BuffCategory.Positive,
              flipped = { ActPowerDownBuff })

  val ActPowerDownBuff: TimedBuffEffect<Unit> =
      +buffData(2)
          .makeModifierTimedBuffEffect(
              modifier = actPowerDown,
              category = BuffCategory.Negative,
              flipped = { ActPowerUpBuff })

  val NormalDefenseUpBuff: TimedBuffEffect<Unit> =
      +buffData(3)
          .makeModifierTimedBuffEffect(
              modifier = normalDefenseUp,
              category = BuffCategory.Positive,
              flipped = { NormalDefenseDownBuff })

  val NormalDefenseDownBuff: TimedBuffEffect<Unit> =
      +buffData(4)
          .makeModifierTimedBuffEffect(
              modifier = normalDefenseDown,
              category = BuffCategory.Negative,
              flipped = { NormalDefenseUpBuff })

  val SpecialDefenseUpBuff: TimedBuffEffect<Unit> =
      +buffData(5)
          .makeModifierTimedBuffEffect(
              modifier = specialDefenseUp,
              category = BuffCategory.Positive,
              flipped = { SpecialDefenseDownBuff })

  val SpecialDefenseDownBuff: TimedBuffEffect<Unit> =
      +buffData(6)
          .makeModifierTimedBuffEffect(
              modifier = specialDefenseDown,
              category = BuffCategory.Negative,
              flipped = { SpecialDefenseUpBuff })

  val AgilityUpBuff: TimedBuffEffect<Unit> =
      +buffData(7)
          .makeModifierTimedBuffEffect(
              modifier = agilityUp, category = BuffCategory.Positive, flipped = { AgilityDownBuff })

  val AgilityDownBuff: TimedBuffEffect<Unit> =
      +buffData(8)
          .makeModifierTimedBuffEffect(
              modifier = agilityDown, category = BuffCategory.Negative, flipped = { AgilityUpBuff })

  val AccuracyUpBuff: TimedBuffEffect<Unit> =
      +buffData(9)
          .makeModifierTimedBuffEffect(
              modifier = accuracyUp,
              category = BuffCategory.Positive,
              flipped = { AccuracyDownBuff })

  val AccuracyDownBuff: TimedBuffEffect<Unit> =
      +buffData(10)
          .makeModifierTimedBuffEffect(
              modifier = accuracyDown,
              category = BuffCategory.Negative,
              flipped = { AccuracyUpBuff })

  val EvasionUpBuff: TimedBuffEffect<Unit> =
      +buffData(11)
          .makeModifierTimedBuffEffect(
              modifier = evasionUp, category = BuffCategory.Positive, flipped = { EvasionDownBuff })

  val EvasionDownBuff: TimedBuffEffect<Unit> =
      +buffData(12)
          .makeModifierTimedBuffEffect(
              modifier = evasionDown, category = BuffCategory.Negative, flipped = { EvasionUpBuff })

  val DexterityUpBuff: TimedBuffEffect<Unit> =
      +buffData(13)
          .makeModifierTimedBuffEffect(
              modifier = buffDexterity,
              category = BuffCategory.Positive,
              flipped = { DexterityDownBuff })

  val DexterityDownBuff: TimedBuffEffect<Unit> =
      +buffData(14)
          .makeModifierTimedBuffEffect(
              modifier = debuffDexterity,
              category = BuffCategory.Negative,
              flipped = { DexterityUpBuff })

  val CriticalUpBuff: TimedBuffEffect<Unit> =
      +buffData(15)
          .makeModifierTimedBuffEffect(
              modifier = buffCritical,
              category = BuffCategory.Positive,
              flipped = { CriticalDownBuff })

  val CriticalDownBuff: TimedBuffEffect<Unit> =
      +buffData(16)
          .makeModifierTimedBuffEffect(
              modifier = debuffCritical,
              category = BuffCategory.Negative,
              flipped = { CriticalUpBuff })

  // Note: should not be used as a buff until DoTs are updated to support this
  val MaxHpUpBuff: TimedBuffEffect<Unit> =
      +buffData(17)
          .makeModifierTimedBuffEffect(
              modifier = maxHpUp,
              category = BuffCategory.Positive,
          )

  val MaxHpDownBuff: TimedBuffEffect<Unit> =
      +buffData(18)
          .makeModifierTimedBuffEffect(
              modifier = maxHpDown,
              category = BuffCategory.Negative,
          )

  val ContinuousNegativeEffectResistanceUpBuff =
      +buffData(19)
          .makeModifierTimedBuffEffect(
              modifier = negativeEffectResistanceUp,
              category = BuffCategory.Positive,
          )

  val ContinuousNegativeEffectResistanceDownBuff =
      +buffData(20)
          .makeModifierTimedBuffEffect(
              modifier = negativeEffectResistanceDown,
              category = BuffCategory.Negative,
          )

  val HpRegenBuff =
      +buffData(21)
          .copy(name = "HP Regen")
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value ->
                if (value <= 100) {
                  self.mod { hpPercentRegen += value }
                } else {
                  self.mod { hpFixedRegen += value }
                }
              },
              onEnd = { value ->
                if (value <= 100) {
                  self.mod { hpPercentRegen -= value }
                } else {
                  self.mod { hpFixedRegen -= value }
                }
              },
          )

  val BrillianceRegenBuff =
      +buffData(22)
          .copy(name = "Brilliance Regen")
          .makeModifierTimedBuffEffect(
              modifier = brillianceRegen,
              category = BuffCategory.Positive,
          )
  val NormalBarrierBuff =
      +buffData(23)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
          )

  val SpecialBarrierBuff =
      +buffData(24)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
          )

  val NormalReflectBuff =
      +buffData(25)
          .makeModifierTimedBuffEffect(
              modifier = normalReflect,
              category = BuffCategory.Positive,
          )

  val SpecialReflectBuff =
      +buffData(26)
          .makeModifierTimedBuffEffect(
              modifier = specialReflect,
              category = BuffCategory.Positive,
          )

  val EvasionBuff = buffData(27).makeCountableBuffEffect(BuffCategory.Positive)

  val PerfectAimBuff =
      +buffData(28)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val Fortitude = buffData(29).makeCountableBuffEffect(BuffCategory.Positive)

  val FixedNormalDefenseBoostBuff =
      +buffData(30)
          .makeModifierTimedBuffEffect(
              modifier = fixedNormalDefense,
              category = BuffCategory.Positive,
          )

  val FixedSpecialDefenseBoostBuff =
      +buffData(31)
          .makeModifierTimedBuffEffect(
              modifier = fixedSpecialDefense,
              category = BuffCategory.Positive,
          )

  val EffectiveDamageDealtUpBuff =
      +buffData(32)
          .makeModifierTimedBuffEffect(
              modifier = effectiveDamageUp,
              category = BuffCategory.Positive,
          )

  val ClimaxDamageUpBuff: TimedBuffEffect<Unit> =
      +buffData(33)
          .makeModifierTimedBuffEffect(
              modifier = climaxDamageUp,
              category = BuffCategory.Positive,
              exclusive = true,
              flipped = { ClimaxDamageDownBuff })

  val CriticalDamageReceivedDownBuff: TimedBuffEffect<Unit> =
      +buffData(34)
          .makeModifierTimedBuffEffect(
              modifier = criticalDamageReceivedDown,
              category = BuffCategory.Positive,
          )

  val FixedActPowerBoostBuff =
      +buffData(35)
          .makeModifierTimedBuffEffect(
              modifier = fixedActPower,
              category = BuffCategory.Positive,
          )

  val AbsorbBuff =
      +buffData(37)
          .makeModifierTimedBuffEffect(
              modifier = absorb,
              category = BuffCategory.Positive,
          )

  val CounterHealBuff =
      +buffData(38)
          .makeTimedBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value, _ ->
                if (value <= 100) {
                  self.mod { counterHealPercent += value }
                } else {
                  self.mod { counterHealFixed += value }
                }
              },
              onEnd = { value, _, _ ->
                if (value <= 100) {
                  self.mod { counterHealPercent -= value }
                } else {
                  self.mod { counterHealFixed -= value }
                }
              },
          )

  // Note: EN localization got the names backwards
  val AgainstFlowerDamageDealtUpBuff =
      buffData(39)
          .copy(name = "Bonus Dmg vs. Flower")
          .againstAttributeDamageDealtUpBuff(Attribute.Flower)
  val AgainstWindDamageDealtUpBuff =
      buffData(40)
          .copy(name = "Bonus Dmg vs. Wind")
          .againstAttributeDamageDealtUpBuff(Attribute.Wind)
  val AgainstSnowDamageDealtUpBuff =
      buffData(41)
          .copy(name = "Bonus Dmg vs. Snow")
          .againstAttributeDamageDealtUpBuff(Attribute.Snow)
  val AgainstMoonDamageDealtUpBuff =
      buffData(42)
          .copy(name = "Bonus Dmg vs. Moon")
          .againstAttributeDamageDealtUpBuff(Attribute.Moon)
  val AgainstSpaceDamageDealtUpBuff =
      buffData(43)
          .copy(name = "Bonus Dmg vs. Space")
          .againstAttributeDamageDealtUpBuff(Attribute.Space)
  val AgainstCloudDamageDealtUpBuff =
      buffData(44)
          .copy(name = "Bonus Dmg vs. Cloud")
          .againstAttributeDamageDealtUpBuff(Attribute.Cloud)
  val AgainstDreamDamageDealtUpBuff =
      buffData(45)
          .copy(name = "Bonus Dmg vs. Dream")
          .againstAttributeDamageDealtUpBuff(Attribute.Dream)

  //    val BonusDamageVsBossesBuff = +buffData(46).makeModifierTimedBuffEffect(
  //        modifier = bonusDamageVsBosses,
  //        category = BuffCategory.Positive,
  //    )

  val PoisonBuff = +buffData(47).makeDamageOverTimeBuffEffect(poisonDamage)

  val BurnBuff = +buffData(48).makeDamageOverTimeBuffEffect(burnDamage)

  val ProvokeBuff =
      +buffData(49)
          .makeTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
              onStart = { _, source -> self.provokeTarget = source },
              onEnd = { _, _, _ -> self.updateProvokeTarget() },
          )

  val StunBuff =
      +buffData(50)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val SleepBuff =
      +buffData(51)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val ConfusionBuff =
      +buffData(52)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val StopBuff =
      +buffData(53)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val FreezeBuff =
      +buffData(54)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val BlindnessBuff =
      +buffData(55)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  // 56: ???
  // 57: ???

  val HpRecoveryDownBuff =
      +buffData(58)
          .makeModifierTimedBuffEffect(
              modifier = hpRecoveryDown,
              category = BuffCategory.Negative,
          )

  val FlowerDamageReceivedDownBuff =
      +buffData(59).againstAttributeDamageReceivedDownBuff(Attribute.Flower)
  val WindDamageReceivedDownBuff =
      +buffData(60).againstAttributeDamageReceivedDownBuff(Attribute.Wind)
  val SnowDamageReceivedDownBuff =
      +buffData(61).againstAttributeDamageReceivedDownBuff(Attribute.Snow)
  val MoonDamageReceivedDownBuff =
      +buffData(62).againstAttributeDamageReceivedDownBuff(Attribute.Moon)
  val SpaceDamageReceivedDownBuff =
      +buffData(63).againstAttributeDamageReceivedDownBuff(Attribute.Space)
  val CloudDamageReceivedDownBuff =
      +buffData(64).againstAttributeDamageReceivedDownBuff(Attribute.Cloud)
  val DreamDamageReceivedDownBuff =
      +buffData(65).againstAttributeDamageReceivedDownBuff(Attribute.Dream)

  val FlowerDamageDealtUpBuff = +buffData(66).attributeDamageDealtUpBuff(Attribute.Flower)
  val WindDamageDealtUpBuff = +buffData(67).attributeDamageDealtUpBuff(Attribute.Wind)
  val SnowDamageDealtUpBuff = +buffData(68).attributeDamageDealtUpBuff(Attribute.Snow)
  val MoonDamageDealtUpBuff = +buffData(69).attributeDamageDealtUpBuff(Attribute.Moon)
  val SpaceDamageDealtUpBuff = +buffData(70).attributeDamageDealtUpBuff(Attribute.Space)
  val CloudDamageDealtUpBuff = +buffData(71).attributeDamageDealtUpBuff(Attribute.Cloud)
  val DreamDamageDealtUpBuff = +buffData(72).attributeDamageDealtUpBuff(Attribute.Dream)

  // We handle this using a special passive
  //    val ActionRestrictionResistanceUpBuffAuto = +buffData(73)

  val ActionRestrictionResistanceUpBuff =
      +buffData(74)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              locked = true,
              onStart = {
                abnormalBuffs.forEach { buff ->
                  self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + 100
                }
                abnormalCountableBuffs.forEach { buff ->
                  self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + 100
                }
              },
              onEnd = {
                abnormalBuffs.forEach { buff ->
                  self.specificBuffResist[buff] = self.specificBuffResist[buff]!! - 100
                }
                abnormalCountableBuffs.forEach { buff ->
                  self.specificBuffResist[buff] = self.specificBuffResist[buff]!! - 100
                }
              },
          )

  val PoisonResistanceUpBuff = +buffData(75).makeSpecificResistanceUpBuff(PoisonBuff)
  val BurnResistanceUpBuff = +buffData(76).makeSpecificResistanceUpBuff(BurnBuff)
  val ProvokeResistanceUpBuff = +buffData(77).makeSpecificResistanceUpBuff(ProvokeBuff)
  val StunResistanceUpBuff = +buffData(78).makeSpecificResistanceUpBuff(StunBuff)
  val SleepResistanceUpBuff = +buffData(79).makeSpecificResistanceUpBuff(SleepBuff)
  val ConfusionResistanceUpBuff = +buffData(80).makeSpecificResistanceUpBuff(ConfusionBuff)
  val StopResistanceUpBuff = +buffData(81).makeSpecificResistanceUpBuff(StopBuff)
  val FreezeResistanceUpBuff = +buffData(82).makeSpecificResistanceUpBuff(FreezeBuff)
  val BlindResistanceUpBuff = +buffData(83).makeSpecificResistanceUpBuff(BlindnessBuff)
  val RecoveryReductionResistance = +buffData(84).makeSpecificResistanceUpBuff(HpRecoveryDownBuff)

  // Not implemented
  val AntiSoliderBuff = +buffData(85).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiLancerBuff = +buffData(86).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiFencerBuff = +buffData(87).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiMagicianBuff = +buffData(88).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiShielderBuff = +buffData(89).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiGunnerBuff = +buffData(90).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiJokerBuff = +buffData(91).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiBeastBuff = +buffData(92).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiQQQBuff = +buffData(93).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AntiMaterialBuff = +buffData(94).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  val DamageDealtUpBuff: TimedBuffEffect<Unit> =
      +buffData(95)
          .makeModifierTimedBuffEffect(
              modifier = damageDealtUp,
              category = BuffCategory.Positive,
              flipped = { DamageDealtDownBuff })

  val DamageDealtDownBuff: TimedBuffEffect<Unit> =
      +buffData(96)
          .makeModifierTimedBuffEffect(
              modifier = damageDealtDown,
              category = BuffCategory.Negative,
              flipped = { DamageDealtUpBuff })

  val DamageReceivedUpBuff: TimedBuffEffect<Unit> =
      +buffData(97)
          .makeModifierTimedBuffEffect(
              modifier = damageReceivedUp,
              category = BuffCategory.Negative,
              flipped = { DamageReceivedDownBuff })

  val DamageReceivedDownBuff: TimedBuffEffect<Unit> =
      +buffData(98)
          .makeModifierTimedBuffEffect(
              modifier = damageReceivedDown,
              category = BuffCategory.Positive,
              flipped = { DamageReceivedUpBuff })

  val MarkBuff: TimedBuffEffect<Unit> =
      +buffData(99)
          .makeIdempotentTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
              flipped = { FlippedMarkBuff },
              onStart = { self.mod { damageReceivedUp += 30 } },
              onEnd = { self.mod { damageReceivedUp -= 30 } },
          )

  val FlippedMarkBuff: TimedBuffEffect<Unit> =
      +buffData(100)
          .makeIdempotentTimedBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
              flipped = { MarkBuff },
              onStart = { self.mod { damageReceivedDown += 30 } },
              onEnd = { self.mod { damageReceivedDown -= 30 } },
          )

  val AggroBuff =
      +buffData(101)
          .makeTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
              onStart = { _, source -> self.aggroTarget = source },
              onEnd = { _, _, _ -> self.updateAggroTarget() },
          )

  val AggroResistanceUpBuff = +buffData(102).makeSpecificResistanceUpBuff(AggroBuff)

  val ExitEvasionBuff =
      +buffData(103)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val InvincibilityBuff =
      +buffData(104)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val ApDownBuff: TimedBuffEffect<Unit> =
      +buffData(105)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              flipped = { ApUpBuff },
          )

  val ApUpBuff: TimedBuffEffect<Unit> =
      +buffData(106)
          .copy(name = "AP Up")
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              flipped = { ApDownBuff },
          )

  val ApUpResistanceUpBuff = +buffData(107).makeSpecificResistanceUpBuff(ApUpBuff)

  // 108: ???
  // 109: ???

  val LockedApUpBuff = +buffData(110).makeLockedVariantOf(ApUpBuff)

  val LockedStunBuff = +buffData(111).makeLockedVariantOf(StunBuff)

  val LockedHpRegenBuff = +buffData(112).makeLockedVariantOf(HpRegenBuff)

  val LockedStopBuff = +buffData(113).makeLockedVariantOf(StopBuff)

  val LockedCounterHealBuff = +buffData(114).makeLockedVariantOf(CounterHealBuff)

  // 115: ???
  // 116: ???

  val AllEffectResistanceUpBuff =
      +buffData(117)
          .makeTimedBuffEffect(
              category = BuffCategory.Positive,
              locked = true,
              onStart = { value, _ ->
                self.mod {
                  positiveEffectResistanceUp += value
                  positiveCountableEffectResistanceUp += value
                  negativeEffectResistanceUp += value
                  negativeCountableEffectResistanceUp += value
                }
              },
              onEnd = { value, _, _ ->
                self.mod {
                  positiveEffectResistanceUp -= value
                  positiveCountableEffectResistanceUp += value
                  negativeEffectResistanceUp -= value
                  negativeCountableEffectResistanceUp -= value
                }
              },
          )

  val MarkResistanceUpBuff = +buffData(118).makeSpecificResistanceUpBuff(MarkBuff)

  // Not implemented
  val EventBossDamageReductionBuff = +buffData(119).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  // Not Implemented
  val SealAct1Buff = +buffData(120).makeSimpleTimedBuffEffect(BuffCategory.Negative)
  val SealAct2Buff = +buffData(121).makeSimpleTimedBuffEffect(BuffCategory.Negative)
  val SealAct3Buff = +buffData(122).makeSimpleTimedBuffEffect(BuffCategory.Negative)

  val SealAct1ResistanceUpBuff = +buffData(123).makeSpecificResistanceUpBuff(SealAct1Buff)
  val SealAct2ResistanceUpBuff = +buffData(124).makeSpecificResistanceUpBuff(SealAct2Buff)
  val SealAct3ResistanceUpBuff = +buffData(125).makeSpecificResistanceUpBuff(SealAct3Buff)

  val BrillianceGainDownBuff =
      +buffData(126).makeModifierTimedBuffEffect(brillianceGainDown, BuffCategory.Negative)

  val BrillianceGainDownResistanceBuff =
      +buffData(127).makeSpecificResistanceUpBuff(BrillianceGainDownBuff)

  val LockedPoisonResistanceUpBuff = +buffData(128).makeLockedVariantOf(PoisonResistanceUpBuff)
  val LockedBurnResistanceUpBuff = +buffData(129).makeLockedVariantOf(BurnResistanceUpBuff)
  val LockedStunResistanceUpBuff = +buffData(130).makeLockedVariantOf(StunResistanceUpBuff)
  val LockedSleepResistanceUpBuff = +buffData(131).makeLockedVariantOf(SleepResistanceUpBuff)
  val LockedConfusionResistanceUpBuff =
      +buffData(132).makeLockedVariantOf(ConfusionResistanceUpBuff)
  val LockedStopResistanceUpBuff = +buffData(133).makeLockedVariantOf(StopResistanceUpBuff)
  val LockedFreezeResistanceUpBuff = +buffData(134).makeLockedVariantOf(FreezeResistanceUpBuff)
  val LockedBlindResistanceUpBuff = +buffData(135).makeLockedVariantOf(BlindResistanceUpBuff)

  val CountableActChange = +buffData(136).makeCountableBuffEffect(BuffCategory.Positive)
  val TimedActChange = +buffData(137).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  val LockedConfusionBuff = +buffData(138).makeLockedVariantOf(ConfusionBuff)

  val ResilienceBuff =
      +buffData(139)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val LockedPoisonBuff = +buffData(140).makeLockedVariantOf(PoisonBuff)

  val LockedBurnBuff = +buffData(141).makeLockedVariantOf(BurnBuff)

  val LockedBlindnessBuff = +buffData(142).makeLockedVariantOf(BlindnessBuff)

  val LockedHpRecoveryDownBuff = +buffData(143).makeLockedVariantOf(HpRecoveryDownBuff)

  //    val ContinuousDamageResistanceUpBuff =
  // +buffData(144).makeSpecificResistanceUpBuff(ContinuousDamageBuff)

  //    val StrongPoisonResistanceUpBuff =
  // +buffData(145).makeSpecificResistanceUpBuff(StrongPoisonBuff)
  //    val HeavyBurnResistanceUpBuff = +buffData(146).makeSpecificResistanceUpBuff(HeavyBurnBuff)

  val FlowerDamageReceivedUpBuff =
      +buffData(147).againstAttributeDamageReceivedUpBuff(Attribute.Flower)
  val WindDamageReceivedUpBuff = +buffData(148).againstAttributeDamageReceivedUpBuff(Attribute.Wind)
  val SnowDamageReceivedUpBuff = +buffData(149).againstAttributeDamageReceivedUpBuff(Attribute.Snow)
  val MoonDamageReceivedUpBuff = +buffData(150).againstAttributeDamageReceivedUpBuff(Attribute.Moon)
  val SpaceDamageReceivedUpBuff =
      +buffData(151).againstAttributeDamageReceivedUpBuff(Attribute.Space)
  val CloudDamageReceivedUpBuff =
      +buffData(152).againstAttributeDamageReceivedUpBuff(Attribute.Cloud)
  val DreamDamageReceivedUpBuff =
      +buffData(153).againstAttributeDamageReceivedUpBuff(Attribute.Dream)

  val FlowerDamageDealtDownBuff = +buffData(154).attributeDamageDealtDownBuff(Attribute.Flower)
  val WindDamageDealtDownBuff = +buffData(155).attributeDamageDealtDownBuff(Attribute.Wind)
  val SnowDamageDealtDownBuff = +buffData(156).attributeDamageDealtDownBuff(Attribute.Snow)
  val MoonDamageDealtDownBuff = +buffData(157).attributeDamageDealtDownBuff(Attribute.Moon)
  val SpaceDamageDealtDownBuff = +buffData(158).attributeDamageDealtDownBuff(Attribute.Space)
  val CloudDamageDealtDownBuff = +buffData(159).attributeDamageDealtDownBuff(Attribute.Cloud)
  val DreamDamageDealtDownBuff = +buffData(160).attributeDamageDealtDownBuff(Attribute.Dream)

  val ClimaxDamageDownBuff: TimedBuffEffect<Unit> =
      +buffData(161)
          .makeModifierTimedBuffEffect(
              modifier = climaxDamageDown,
              category = BuffCategory.Negative,
              flipped = { ClimaxDamageUpBuff })

  val LovesicknessBuff =
      +buffData(162)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val LockedLovesicknessBuff = +buffData(163).makeLockedVariantOf(LovesicknessBuff)

  val LovesicknessResistanceUpBuff = +buffData(164).makeSpecificResistanceUpBuff(LovesicknessBuff)

  val LockedLovesicknessResistanceUpBuff =
      +buffData(165).makeLockedVariantOf(LovesicknessResistanceUpBuff)

  val LockedContinuousNegativeEffectResistanceUpBuff =
      +buffData(166).makeLockedVariantOf(ContinuousNegativeEffectResistanceUpBuff)

  // Not implemented
  val SealCABuff = +buffData(167).makeSimpleTimedBuffEffect(BuffCategory.Negative)

  val LockedSealCABuff = +buffData(168).makeLockedVariantOf(SealCABuff)

  val ElectricShockBuff =
      +buffData(169)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val LockedElectricShockBuff = +buffData(170).makeLockedVariantOf(ElectricShockBuff)

  val ElectricShockResistanceUpBuff = +buffData(171).makeSpecificResistanceUpBuff(ElectricShockBuff)

  val LockedElectricShockResistanceUpBuff =
      +buffData(172).makeLockedVariantOf(ElectricShockResistanceUpBuff)

  val ReviveBuff = +buffData(173).makeCountableBuffEffect(BuffCategory.Positive)

  val NightmareBuff = +buffData(174).makeDamageOverTimeBuffEffect(nightmareDamage, exclusive = true)

  val ContinuousPositiveEffectResistanceUpBuff =
      +buffData(175)
          .makeModifierTimedBuffEffect(
              modifier = positiveEffectResistanceUp, category = BuffCategory.Negative)

  val LockedContinuousPositiveEffectResistanceUpBuff =
      +buffData(176).makeLockedVariantOf(ContinuousPositiveEffectResistanceUpBuff)

  val PositiveEffectResistanceUpBuff =
      +buffData(177)
          .makeTimedBuffEffect(
              category = BuffCategory.Positive,
              locked = true,
              onStart = { value, _ ->
                self.mod {
                  positiveEffectResistanceUp += value
                  positiveCountableEffectResistanceUp += value
                }
              },
              onEnd = { value, _, _ ->
                self.mod {
                  positiveEffectResistanceUp -= value
                  positiveCountableEffectResistanceUp += value
                }
              },
          )

  val LockedPositiveEffectResistanceUpBuff =
      +buffData(178).makeLockedVariantOf(PositiveEffectResistanceUpBuff)

  val DazeBuff = +buffData(179).makeCountableBuffEffect(BuffCategory.Negative)

  val ImpudenceBuff = +buffData(180).makeCountableBuffEffect(BuffCategory.Negative)

  val HopeBuff = +buffData(181).makeCountableBuffEffect(BuffCategory.Positive)

  val WeakSpotBuff = +buffData(182).makeCountableBuffEffect(BuffCategory.Negative)

  val FixedAgilityBoost =
      +buffData(183)
          .makeModifierTimedBuffEffect(
              modifier = fixedAgility,
              category = BuffCategory.Positive,
          )

  val FixedMaxHpBoost =
      +buffData(184)
          .makeModifierTimedBuffEffect(
              modifier = fixedMaxHp,
              category = BuffCategory.Positive,
          )

  val FrostbiteBuff = +buffData(185).makeDamageOverTimeBuffEffect(frostbiteDamage, exclusive = true)

  val DamageToSeishoUpBuff =
      +buffData(186)
          .makeMapModifierTimedBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Seisho,
              category = BuffCategory.Positive,
          )

  val DamageToRinmeikanUpBuff =
      +buffData(187)
          .makeMapModifierTimedBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Rinmeikan,
              category = BuffCategory.Positive,
          )

  val DamageToFrontierUpBuff =
      +buffData(188)
          .makeMapModifierTimedBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Frontier,
              category = BuffCategory.Positive,
          )

  val DamageToSiegfeldUpBuff =
      +buffData(189)
          .makeMapModifierTimedBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Siegfeld,
              category = BuffCategory.Positive,
          )

  val DamageToSeiranUpBuff =
      +buffData(190)
          .makeMapModifierTimedBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Seiran,
              category = BuffCategory.Positive,
          )

  val DamageFromKarenUpBuff =
      +buffData(191)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Karen,
              category = BuffCategory.Negative,
          )

  val DamageFromHikariUpBuff =
      +buffData(192)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Hikari,
              category = BuffCategory.Negative,
          )

  val DamageFromMahiruUpBuff =
      +buffData(193)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Mahiru,
              category = BuffCategory.Negative,
          )

  val DamageFromClaudineUpBuff =
      +buffData(194)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Claudine,
              category = BuffCategory.Negative,
          )

  val DamageFromMayaUpBuff =
      +buffData(195)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Maya,
              category = BuffCategory.Negative,
          )

  val DamageFromJunnaUpBuff =
      +buffData(196)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Junna,
              category = BuffCategory.Negative,
          )

  val DamageFromNanaUpBuff =
      +buffData(197)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Nana,
              category = BuffCategory.Negative,
          )

  val DamageFromFutabaUpBuff =
      +buffData(198)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Futaba,
              category = BuffCategory.Negative,
          )

  val DamageFromKaorukoUpBuff =
      +buffData(199)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Kaoruko,
              category = BuffCategory.Negative,
          )

  val DamageFromTamaoUpBuff =
      +buffData(200)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Tamao,
              category = BuffCategory.Negative,
          )

  val DamageFromIchieUpBuff =
      +buffData(201)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Ichie,
              category = BuffCategory.Negative,
          )

  val DamageFromFumiUpBuff =
      +buffData(202)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Fumi,
              category = BuffCategory.Negative,
          )

  val DamageFromRuiUpBuff =
      +buffData(203)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Rui,
              category = BuffCategory.Negative,
          )

  val DamageFromYuyukoUpBuff =
      +buffData(204)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Yuyuko,
              category = BuffCategory.Negative,
          )

  val DamageFromAruruUpBuff =
      +buffData(205)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Aruru,
              category = BuffCategory.Negative,
          )

  val DamageFromMisoraUpBuff =
      +buffData(206)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Misora,
              category = BuffCategory.Negative,
          )

  val DamageFromLalafinUpBuff =
      +buffData(207)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Lalafin,
              category = BuffCategory.Negative,
          )

  val DamageFromTsukasaUpBuff =
      +buffData(208)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Tsukasa,
              category = BuffCategory.Negative,
          )

  val DamageFromShizuhaUpBuff =
      +buffData(209)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Shizuha,
              category = BuffCategory.Negative,
          )

  val DamageFromAkiraUpBuff =
      +buffData(210)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Akira,
              category = BuffCategory.Negative,
          )

  val DamageFromMichiruUpBuff =
      +buffData(211)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Michiru,
              category = BuffCategory.Negative,
          )

  val DamageFromMeiFanUpBuff =
      +buffData(212)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.MeiFan,
              category = BuffCategory.Negative,
          )

  val DamageFromShioriUpBuff =
      +buffData(213)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Shiori,
              category = BuffCategory.Negative,
          )

  val DamageFromYachiyoUpBuff =
      +buffData(214)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Yachiyo,
              category = BuffCategory.Negative,
          )

  val DamageFromKoharuUpBuff =
      +buffData(215)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Koharu,
              category = BuffCategory.Negative,
          )

  val DamageFromSuzuUpBuff =
      +buffData(216)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Suzu,
              category = BuffCategory.Negative,
          )

  val DamageFromHisameUpBuff =
      +buffData(217)
          .makeMapModifierTimedBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Hisame,
              category = BuffCategory.Negative,
          )

  val AgonyBuff =
      +buffData(218)
          .makeIdempotentTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
              onStart = { self.mod { damageReceivedUp += 30 } },
              onEnd = { self.mod { damageReceivedUp -= 30 } },
          )

  val LockedAggroBuff = +buffData(219).makeLockedVariantOf(AggroBuff)

  val LockedSealAct1Buff = +buffData(220).makeLockedVariantOf(SealAct1Buff)
  val LockedSealAct2Buff = +buffData(221).makeLockedVariantOf(SealAct2Buff)
  val LockedSealAct3Buff = +buffData(222).makeLockedVariantOf(SealAct3Buff)

  val LockedNormalBarrierBuff = +buffData(223).makeLockedVariantOf(NormalBarrierBuff)

  val LockedSpecialBarrierBuff = +buffData(224).makeLockedVariantOf(SpecialBarrierBuff)

  val PossessionBuff =
      +buffData(225)
          .makeTimedBuffEffect(
              BuffCategory.Positive,
              related = ResilienceBuff,
              onStart = { _, _ -> self.mod { negativeEffectResistanceUp += 100 } },
              onEnd = { _, _, _ ->
                self.mod { negativeEffectResistanceUp -= 100 }
                self.exit()
              },
          )

  val LockedPossessionBuff = +buffData(226).makeLockedVariantOf(PossessionBuff)

  val LockedApDownBuff = +buffData(227).makeLockedVariantOf(ApDownBuff)

  val LockedCriticalUpBuff = +buffData(228).makeLockedVariantOf(CriticalUpBuff)

  // Not implemented
  // Doesn't work in PvE anyways
  val CurtainsClosedBuff = +buffData(229).makeSimpleTimedBuffEffect(BuffCategory.Negative)

  val LockedCurtainsClosedBuff = +buffData(230).makeLockedVariantOf(CurtainsClosedBuff)

  val NegativeCountableEffectResistanceUpBuff =
      +buffData(231)
          .makeModifierTimedBuffEffect(
              modifier = negativeCountableEffectResistanceUp,
              category = BuffCategory.Positive,
          )

  val LockedNegativeCountableEffectResistanceUpBuff =
      +buffData(232).makeLockedVariantOf(NegativeCountableEffectResistanceUpBuff)

  val BrillianceGainUpBuff =
      +buffData(233)
          .makeModifierTimedBuffEffect(
              modifier = brillianceGainUp,
              category = BuffCategory.Positive,
          )

  val LockedResilienceBuff = +buffData(234).makeLockedVariantOf(ResilienceBuff)

  val ApUp2Buff: TimedBuffEffect<Unit> =
      +buffData(235)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
          )

  val LockedApUp2Buff: TimedBuffEffect<Unit> =
      +buffData(236)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
          )

  val ApDown2Buff: TimedBuffEffect<Unit> =
      +buffData(237)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
          )

  val LockedApDown2Buff: TimedBuffEffect<Unit> =
      +buffData(238)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
          )

  // TODO: handle stacking properly
  val CutinInitialCooldownReductionBuff =
      +buffData(239)
          .makeTimedBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value, _ -> self.cutinInitialCooldownReduction += value },
              onEnd = { value, _, _ -> self.cutinInitialCooldownReduction -= value },
          )

  val CounterHealBuff2 =
      +buffData(240)
          .makeModifierTimedBuffEffect(
              modifier = counterHealFixed,
              category = BuffCategory.Positive,
          )

  val HoldBackBuff = +buffData(241).makeCountableBuffEffect(BuffCategory.Negative)

  val SealStageEffectBuff = +buffData(242).makeSimpleTimedBuffEffect(BuffCategory.Negative)

  val LockedSealStageEffectBuff = +buffData(243).makeLockedVariantOf(SealStageEffectBuff)

  // This is for OR, so it's not really used
  val AddActs1Buff = +buffData(244).makeSimpleTimedBuffEffect(BuffCategory.Positive)
  val AddActs2Buff = +buffData(245).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  //    val BulkheadBuff = +buffData(246).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  // Not implemented
  val AntiOathRevueBuff = +buffData(247).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  val DisasterBrillianceReduction = buffData(248).makeCountableBuffEffect(BuffCategory.Negative)

  val BlessingHpRecovery = buffData(249).makeCountableBuffEffect(BuffCategory.Positive)

  val BlessingCountableDebuffReduction =
      buffData(250).makeCountableBuffEffect(BuffCategory.Positive)

  val DisasterDaze = buffData(251).makeCountableBuffEffect(BuffCategory.Negative)

  val BlessingContinuousDebuffRemoval = buffData(252).makeCountableBuffEffect(BuffCategory.Positive)

  val DazeResistanceUpBuff = buffData(253).makeSpecificResistanceUpBuff(DazeBuff)

  val LockedDazeResistanceUpBuff = buffData(254).makeLockedVariantOf(DazeResistanceUpBuff)

  val BlessingHope = buffData(255).makeCountableBuffEffect(BuffCategory.Positive)

  val ImpudenceResistanceUpBuff = buffData(256).makeSpecificResistanceUpBuff(ImpudenceBuff)

  val LockedImpudenceResistanceUpBuff = buffData(257).makeLockedVariantOf(ImpudenceResistanceUpBuff)

  val NormalSuperReflectBuff =
      +buffData(258)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
          )

  val SpecialSuperReflectBuff =
      +buffData(259)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
          )

  val LockedNormalSuperReflectBuff = +buffData(260).makeLockedVariantOf(NormalSuperReflectBuff)

  val LockedSpecialSuperReflectBuff = +buffData(261).makeLockedVariantOf(SpecialSuperReflectBuff)

  val BlessingEffectiveDamage = buffData(262).makeCountableBuffEffect(BuffCategory.Positive)

  val InvincibleRebirth = buffData(263).makeCountableBuffEffect(BuffCategory.Positive)

  // TODO: implement this
  val SacrificeBuff = buffData(264).makeCountableBuffEffect(BuffCategory.Negative)

  val DisasterApUp = buffData(265).makeCountableBuffEffect(BuffCategory.Negative)

  val BlessingApDown2 = buffData(266).makeCountableBuffEffect(BuffCategory.Positive)

  val ContractionBuff =
      +buffData(267)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val HpRegenBuff2 =
      +buffData(268)
          .copy(name = "HP Regen")
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value ->
                if (value <= 100) {
                  self.mod { hpPercentRegen += value }
                } else {
                  self.mod { hpFixedRegen += value }
                }
              },
              onEnd = { value ->
                if (value <= 100) {
                  self.mod { hpPercentRegen -= value }
                } else {
                  self.mod { hpFixedRegen -= value }
                }
              },
          )

  // Not implemented
  val SealInstantSkillBuff = +buffData(269).makeSimpleTimedBuffEffect(BuffCategory.Negative)

  val LockedSealInstantSkillBuff = +buffData(270).makeLockedVariantOf(SealInstantSkillBuff)

  val CountablePositiveEffectResistanceUpBuff =
      buffData(271)
          .makeModifierTimedBuffEffect(
              modifier = positiveCountableEffectResistanceUp,
              category = BuffCategory.Negative,
          )

  val LockedCountablePositiveEffectResistanceUpBuff =
      buffData(272).makeLockedVariantOf(CountablePositiveEffectResistanceUpBuff)

  val LockedPerfectAimBuff = +buffData(273).makeLockedVariantOf(PerfectAimBuff)

  val StaminaActPowerUpBuff =
      buffData(274)
          .makeModifierTimedBuffEffect(
              modifier = staminaActPowerUp,
              category = BuffCategory.Positive,
          )

  val OverwhelmBuff = +buffData(275).makeCountableBuffEffect(BuffCategory.Negative, isLocked = true)

  val MultipleCAficationBuff =
      +buffData(276)
          .makeSimpleTimedBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val BrillianceSap =
      buffData(277)
          .makeModifierTimedBuffEffect(
              modifier = brillianceRegen,
              category = BuffCategory.Negative,
          )

  val EffectiveDamageDealtUpBuff2 =
      buffData(278)
          .makeModifierTimedBuffEffect(
              modifier = effectiveDamageUp,
              category = BuffCategory.Positive,
          )

  val LockedBrillianceRegenBuff =
      +buffData(279)
          .copy(name = "(Unremovable) Brilliance Regen")
          .makeLockedVariantOf(BrillianceRegenBuff)

  val ReviveRegen =
      buffData(280)
          .makeModifierTimedBuffEffect(
              modifier = reviveRegen,
              category = BuffCategory.Positive,
          )

  val LockedInvincibilityBuff = +buffData(281).makeLockedVariantOf(InvincibilityBuff)

  val SealStageEffectResistanceUpBuff =
      buffData(282).makeSpecificResistanceUpBuff(SealStageEffectBuff)

  val LockedSealStageEffectResistanceUpBuff =
      buffData(283).makeLockedVariantOf(SealStageEffectResistanceUpBuff)

  val TurnDispelContinuousNegativeEffectsBuff =
      +buffData(284).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  val LockedTurnDispelContinuousNegativeEffectsBuff =
      +buffData(285).makeLockedVariantOf(TurnDispelContinuousNegativeEffectsBuff)

  val TurnDispelCountableNegativeEffectsBuff =
      +buffData(286).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  val LockedTurnDispelCountableNegativeEffectsBuff =
      +buffData(287).makeLockedVariantOf(TurnDispelCountableNegativeEffectsBuff)

  val TurnDispelContinuousPositiveEffectsBuff =
      +buffData(288).makeSimpleTimedBuffEffect(BuffCategory.Negative)

  val LockedTurnDispelContinuousPositiveEffectsBuff =
      +buffData(289).makeLockedVariantOf(TurnDispelContinuousPositiveEffectsBuff)

  val TurnDispelCountablePositiveEffectsBuff =
      +buffData(290).makeSimpleTimedBuffEffect(BuffCategory.Negative)

  val LockedTurnDispelCountablePositiveEffectsBuff =
      +buffData(291).makeLockedVariantOf(TurnDispelCountablePositiveEffectsBuff)

  val TurnAddSuperStrengthBuff = +buffData(292).makeSimpleTimedBuffEffect(BuffCategory.Positive)

  val LockedTurnAddSuperStrengthBuff = +buffData(293).makeLockedVariantOf(TurnAddSuperStrengthBuff)

  val CheerBuff = buffData(294).makeCountableBuffEffect(BuffCategory.Positive)

  val TurnReduceCountableNegativeEffectsBuff =
      +buffData(297)
          .makeModifierTimedBuffEffect(
              modifier = turnReduceCountableNegativeEffects,
              category = BuffCategory.Positive,
          )

  val LockedTurnReduceCountableNegativeEffectsBuff =
      +buffData(298).makeLockedVariantOf(TurnReduceCountableNegativeEffectsBuff)

  val abnormalBuffs =
      platformSetOf(
          StopBuff,
          SleepBuff,
          NightmareBuff,
          ConfusionBuff,
          FreezeBuff,
          StunBuff,
          LockedStunBuff,
          BurnBuff,
          LockedBurnBuff,
          PoisonBuff,
          LockedPoisonBuff,
          AgonyBuff,
          LovesicknessBuff,
          LockedLovesicknessBuff,
          ElectricShockBuff,
          LockedElectricShockBuff,
          FrostbiteBuff,
      )

  fun againstAttributeDamageDealtUpBuff(attribute: Attribute) =
      when (attribute) {
        Attribute.Flower -> AgainstFlowerDamageDealtUpBuff
        Attribute.Wind -> AgainstWindDamageDealtUpBuff
        Attribute.Snow -> AgainstSnowDamageDealtUpBuff
        Attribute.Moon -> AgainstMoonDamageDealtUpBuff
        Attribute.Space -> AgainstSpaceDamageDealtUpBuff
        Attribute.Cloud -> AgainstCloudDamageDealtUpBuff
        Attribute.Dream -> AgainstDreamDamageDealtUpBuff
        else -> error("Attribute $attribute not supported")
      }

  fun againstAttributeDamageReceivedUpBuff(attribute: Attribute) =
      when (attribute) {
        Attribute.Flower -> FlowerDamageReceivedUpBuff
        Attribute.Wind -> WindDamageReceivedUpBuff
        Attribute.Snow -> SnowDamageReceivedUpBuff
        Attribute.Moon -> MoonDamageReceivedUpBuff
        Attribute.Space -> SpaceDamageReceivedUpBuff
        Attribute.Cloud -> CloudDamageReceivedUpBuff
        Attribute.Dream -> DreamDamageReceivedUpBuff
        else -> error("Attribute $attribute not supported")
      }

  fun againstAttributeDamageReceivedDownBuff(attribute: Attribute) =
      when (attribute) {
        Attribute.Flower -> FlowerDamageReceivedDownBuff
        Attribute.Wind -> WindDamageReceivedDownBuff
        Attribute.Snow -> SnowDamageReceivedDownBuff
        Attribute.Moon -> MoonDamageReceivedDownBuff
        Attribute.Space -> SpaceDamageReceivedDownBuff
        Attribute.Cloud -> CloudDamageReceivedDownBuff
        Attribute.Dream -> DreamDamageReceivedDownBuff
        else -> error("Attribute $attribute not supported")
      }
}
