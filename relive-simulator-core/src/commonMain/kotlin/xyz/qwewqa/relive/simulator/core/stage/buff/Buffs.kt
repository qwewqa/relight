package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.School
import xyz.qwewqa.relive.simulator.core.stage.actor.abnormalCountableBuffs
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifiers
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHp
import xyz.qwewqa.relive.simulator.core.stage.platformSetOf

object Buffs : ImplementationRegistry<BuffEffect>() {
  private fun BuffData.makeDamageOverTimeBuffEffect(
      modifier: Modifier,
      exclusive: Boolean = false,
      locked: Boolean = false,
  ) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Negative,
          exclusive = exclusive,
          locked = locked,
          onStart = { value ->
            val damage =
                if (value <= 100) {
                  self.mod { +maxHp ptmul value }.coerceAtMost(99_999.i54)
                } else {
                  value.toI54()
                }
            self.mod { modifier += damage }
          },
          onEnd = { value ->
            val damage =
                if (value <= 100) {
                  self.mod { +maxHp ptmul value }.coerceAtMost(99_999.i54)
                } else {
                  value.toI54()
                }
            self.mod { modifier -= damage }
          },
      )

  private fun BuffData.makeSpecificResistanceUpBuff(
      buff: BuffEffect,
      locked: Boolean = false,
  ) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Positive,
          locked = locked,
          isResistance = true,
          onStart = { value ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) + value
          },
          onEnd = { value ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) - value
          },
      )

  private fun BuffData.makeResistanceUpExceptBuff(
      buffs: List<BuffEffect>,
      locked: Boolean = false,
  ) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Positive,
          locked = locked,
          isResistance = true,
          onStart = { value ->
            self.mod {
              Modifier.NegativeEffectResistanceUp += value
              Modifier.NegativeCountableEffectResistanceUp += value
              if (groupLevel >= 2) {
                Modifier.GreaterNegativeEffectResistanceUp += value
                Modifier.GreaterNegativeCountableEffectResistanceUp += value
              }
            }
            buffs.forEach { buff ->
              self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) - value
            }
          },
          onEnd = { value ->
            self.mod {
              Modifier.NegativeEffectResistanceUp -= value
              Modifier.NegativeCountableEffectResistanceUp -= value
              if (groupLevel >= 2) {
                Modifier.GreaterNegativeEffectResistanceUp -= value
                Modifier.GreaterNegativeCountableEffectResistanceUp -= value
              }
            }
            buffs.forEach { buff ->
              self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) + value
            }
          },
      )

  private fun BuffData.makeMultipleResistanceUpBuff(
      buffs: List<BuffEffect>,
      locked: Boolean = false,
  ) =
      makeSimpleContinuousBuffEffect(
          category =
              if (buffs.all { it.category == BuffCategory.Positive }) BuffCategory.Negative
              else BuffCategory.Positive,
          locked = locked,
          isResistance = true,
          onStart = { value ->
            buffs.forEach { buff ->
              self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) + value
            }
          },
          onEnd = { value ->
            buffs.forEach { buff ->
              self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) - value
            }
          },
      )

  private inline fun <T> BuffData.makeMapModifierContinuousBuffEffect(
      crossinline mapAccessor: (Actor) -> MutableMap<T, I54>,
      key: T,
      category: BuffCategory,
      locked: Boolean = false,
      exclusive: Boolean = false,
  ) =
      makeSimpleContinuousBuffEffect(
          category = category,
          locked = locked,
          exclusive = exclusive,
          onStart = { value -> mapAccessor(self)[key] = (mapAccessor(self)[key] ?: 0.i54) + value },
          onEnd = { value -> mapAccessor(self)[key] = (mapAccessor(self)[key] ?: 0.i54) - value },
      )

  private fun BuffData.againstAttributeDamageReceivedUpBuff(attribute: Attribute) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Negative,
          onStart = { value ->
            self.againstAttributeDamageReceivedDown[attribute] =
                (self.againstAttributeDamageReceivedDown[attribute] ?: 0.i54) - value
          },
          onEnd = { value ->
            self.againstAttributeDamageReceivedDown[attribute] =
                self.againstAttributeDamageReceivedDown[attribute]!! + value
          })

  private fun BuffData.againstAttributeDamageReceivedDownBuff(attribute: Attribute) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Positive,
          onStart = { value ->
            self.againstAttributeDamageReceivedDown[attribute] =
                (self.againstAttributeDamageReceivedDown[attribute] ?: 0.i54) + value
          },
          onEnd = { value ->
            self.againstAttributeDamageReceivedDown[attribute] =
                self.againstAttributeDamageReceivedDown[attribute]!! - value
          })

  private fun BuffData.againstAttributeDamageDealtUpBuff(attribute: Attribute) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Positive,
          onStart = { value ->
            self.againstAttributeDamageDealtUp[attribute] =
                (self.againstAttributeDamageDealtUp[attribute] ?: 0.i54) + value
          },
          onEnd = { value ->
            self.againstAttributeDamageDealtUp[attribute] =
                self.againstAttributeDamageDealtUp[attribute]!! - value
          })

  private fun BuffData.attributeDamageDealtUpBuff(attribute: Attribute) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Positive,
          onStart = { value ->
            self.attributeDamageDealtUp[attribute] =
                (self.attributeDamageDealtUp[attribute] ?: 0.i54) + value
          },
          onEnd = { value ->
            self.attributeDamageDealtUp[attribute] =
                self.attributeDamageDealtUp[attribute]!! - value
          })

  private fun BuffData.attributeDamageDealtDownBuff(attribute: Attribute) =
      makeSimpleContinuousBuffEffect(
          category = BuffCategory.Negative,
          onStart = { value ->
            self.attributeDamageDealtUp[attribute] =
                (self.attributeDamageDealtUp[attribute] ?: 0.i54) - value
          },
          onEnd = { value ->
            self.attributeDamageDealtUp[attribute] =
                self.attributeDamageDealtUp[attribute]!! + value
          })

  val ActPowerUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(1)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.ActPowerUp,
              category = BuffCategory.Positive,
              flipped = { ActPowerDownBuff })

  val ActPowerDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(2)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.ActPowerDown,
              category = BuffCategory.Negative,
              flipped = { ActPowerUpBuff })

  val NormalDefenseUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(3)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.NormalDefenseUp,
              category = BuffCategory.Positive,
              flipped = { NormalDefenseDownBuff })

  val NormalDefenseDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(4)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.NormalDefenseDown,
              category = BuffCategory.Negative,
              flipped = { NormalDefenseUpBuff })

  val SpecialDefenseUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(5)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.SpecialDefenseUp,
              category = BuffCategory.Positive,
              flipped = { SpecialDefenseDownBuff })

  val SpecialDefenseDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(6)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.SpecialDefenseDown,
              category = BuffCategory.Negative,
              flipped = { SpecialDefenseUpBuff })

  val AgilityUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(7)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.AgilityUp,
              category = BuffCategory.Positive,
              flipped = { AgilityDownBuff })

  val AgilityDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(8)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.AgilityDown,
              category = BuffCategory.Negative,
              flipped = { AgilityUpBuff })

  val AccuracyUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(9)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BuffAccuracy,
              category = BuffCategory.Positive,
              flipped = { AccuracyDownBuff })

  val AccuracyDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(10)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DebuffAccuracy,
              category = BuffCategory.Negative,
              flipped = { AccuracyUpBuff })

  val EvasionUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(11)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BuffEvasion,
              category = BuffCategory.Positive,
              flipped = { EvasionDownBuff })

  val EvasionDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(12)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DebuffEvasion,
              category = BuffCategory.Negative,
              flipped = { EvasionUpBuff })

  val DexterityUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(13)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BuffDexterity,
              category = BuffCategory.Positive,
              flipped = { DexterityDownBuff })

  val DexterityDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(14)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DebuffDexterity,
              category = BuffCategory.Negative,
              flipped = { DexterityUpBuff })

  val CriticalUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(15)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BuffCritical,
              category = BuffCategory.Positive,
              flipped = { CriticalDownBuff })

  val CriticalDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(16)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DebuffCritical,
              category = BuffCategory.Negative,
              flipped = { CriticalUpBuff })

  // Note: should not be used as a buff until DoTs are updated to support this
  val MaxHpUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(17)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BuffMaxHp,
              category = BuffCategory.Positive,
          )

  val MaxHpDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(18)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DebuffMaxHp,
              category = BuffCategory.Negative,
          )

  val ContinuousNegativeEffectResistanceUpBuff =
      +buffData(19)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.NegativeEffectResistanceUp,
              category = BuffCategory.Positive,
              isResistance = true,
          )

  val ContinuousNegativeEffectResistanceDownBuff =
      +buffData(20)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.NegativeEffectResistanceDown,
              category = BuffCategory.Negative,
          )

  val HpRegenBuff =
      +buffData(21)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value ->
                if (value <= 100) {
                  self.mod { Modifier.HpPercentRegen += value }
                } else {
                  self.mod { Modifier.HpRegen += value }
                }
              },
              onEnd = { value ->
                if (value <= 100) {
                  self.mod { Modifier.HpPercentRegen -= value }
                } else {
                  self.mod { Modifier.HpRegen -= value }
                }
              },
          )

  val BrillianceRegenBuff =
      +buffData(22)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BrillianceRegen,
              category = BuffCategory.Positive,
          )
  val NormalBarrierBuff =
      +buffData(23)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
          )

  val SpecialBarrierBuff =
      +buffData(24)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
          )

  val NormalReflectBuff =
      +buffData(25)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.NormalReflect,
              category = BuffCategory.Positive,
          )

  val SpecialReflectBuff =
      +buffData(26)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.SpecialReflect,
              category = BuffCategory.Positive,
          )

  val EvasionBuff = +buffData(27).makeCountableBuffEffect(BuffCategory.Positive)

  val PerfectAimBuff =
      +buffData(28)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val FortitudeBuff = +buffData(29).makeCountableBuffEffect(BuffCategory.Positive)

  val FixedNormalDefenseBoostBuff =
      +buffData(30)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.FixedNormalDefense,
              category = BuffCategory.Positive,
          )

  val FixedSpecialDefenseBoostBuff =
      +buffData(31)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.FixedSpecialDefense,
              category = BuffCategory.Positive,
          )

  val EffectiveDamageDealtUpBuff =
      +buffData(32)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.EffectiveDamageUp,
              category = BuffCategory.Positive,
          )

  val ClimaxDamageUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(33)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.ClimaxDamageUp,
              category = BuffCategory.Positive,
              exclusive = true,
              flipped = { ClimaxDamageDownBuff })

  val CriticalDamageReceivedDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(34)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.CriticalDamageReceivedDown,
              category = BuffCategory.Positive,
          )

  val FixedActPowerBoostBuff =
      +buffData(35)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.FixedActPower,
              category = BuffCategory.Positive,
          )

  val AbsorbBuff =
      +buffData(37)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.Absorb,
              category = BuffCategory.Positive,
          )

  val CounterHealBuff =
      +buffData(38)
          .makeContinuousBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value, _ ->
                if (value <= 100) {
                  self.mod { Modifier.CounterHealPercent += value }
                } else {
                  self.mod { Modifier.CounterHealFixed += value }
                }
              },
              onEnd = { value, _, _ ->
                if (value <= 100) {
                  self.mod { Modifier.CounterHealPercent -= value }
                } else {
                  self.mod { Modifier.CounterHealFixed -= value }
                }
              },
          )

  // Note: EN localization got the names backwards
  val AgainstFlowerDamageDealtUpBuff =
      +buffData(39).againstAttributeDamageDealtUpBuff(Attribute.Flower)
  val AgainstWindDamageDealtUpBuff = +buffData(40).againstAttributeDamageDealtUpBuff(Attribute.Wind)
  val AgainstSnowDamageDealtUpBuff = +buffData(41).againstAttributeDamageDealtUpBuff(Attribute.Snow)
  val AgainstMoonDamageDealtUpBuff = +buffData(42).againstAttributeDamageDealtUpBuff(Attribute.Moon)
  val AgainstSpaceDamageDealtUpBuff =
      +buffData(43).againstAttributeDamageDealtUpBuff(Attribute.Space)
  val AgainstCloudDamageDealtUpBuff =
      +buffData(44).againstAttributeDamageDealtUpBuff(Attribute.Cloud)
  val AgainstDreamDamageDealtUpBuff =
      +buffData(45).againstAttributeDamageDealtUpBuff(Attribute.Dream)

  // TODO: Do something with this I guess
  val BonusDamageVsBossesBuff = +buffData(46).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val PoisonBuff = +buffData(47).makeDamageOverTimeBuffEffect(Modifier.PoisonDamage)

  val BurnBuff = +buffData(48).makeDamageOverTimeBuffEffect(Modifier.BurnDamage)

  val ProvokeBuff =
      +buffData(49)
          .makeContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
              onStart = { _, source -> self.provokeTarget = source },
              onEnd = { _, _, _ -> self.updateProvokeTarget() },
          )

  val StunBuff =
      +buffData(50)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val SleepBuff =
      +buffData(51)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val ConfusionBuff =
      +buffData(52)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val StopBuff =
      +buffData(53)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val FreezeBuff =
      +buffData(54)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val BlindnessBuff =
      +buffData(55)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  // 56: ???
  // 57: ???

  val HpRecoveryDownBuff =
      +buffData(58)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.HpRecoveryDown,
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
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              locked = true,
              isResistance = true,
              onStart = {
                abnormalBuffs.forEach { buff ->
                  self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) + 100
                }
                abnormalCountableBuffs.forEach { buff ->
                  self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0.i54) + 100
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
  val AntiSoliderBuff = +buffData(85).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiLancerBuff = +buffData(86).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiFencerBuff = +buffData(87).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiMagicianBuff = +buffData(88).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiShielderBuff = +buffData(89).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiGunnerBuff = +buffData(90).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiJokerBuff = +buffData(91).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiBeastBuff = +buffData(92).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiQQQBuff = +buffData(93).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AntiMaterialBuff = +buffData(94).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val DamageDealtUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(95)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DamageDealtUp,
              category = BuffCategory.Positive,
              flipped = { DamageDealtDownBuff })

  val DamageDealtDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(96)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DamageDealtDown,
              category = BuffCategory.Negative,
              flipped = { DamageDealtUpBuff })

  val DamageReceivedUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(97)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DamageReceivedUp,
              category = BuffCategory.Negative,
              flipped = { DamageReceivedDownBuff })

  val DamageReceivedDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(98)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.DamageReceivedDown,
              category = BuffCategory.Positive,
              flipped = { DamageReceivedUpBuff })

  val MarkBuff: ContinuousBuffEffect<Unit> =
      +buffData(99)
          .makeIdempotentContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
              flipped = { FlippedMarkBuff },
              onStart = { self.mod { Modifier.DamageReceivedUp += 30 } },
              onEnd = { self.mod { Modifier.DamageReceivedUp -= 30 } },
          )

  val FlippedMarkBuff: ContinuousBuffEffect<Unit> =
      +buffData(100)
          .makeIdempotentContinuousBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
              flipped = { MarkBuff },
              onStart = { self.mod { Modifier.DamageReceivedDown += 30 } },
              onEnd = { self.mod { Modifier.DamageReceivedDown -= 30 } },
          )

  val AggroBuff =
      +buffData(101)
          .makeContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
              onStart = { _, source -> self.aggroTarget = source },
              onEnd = { _, _, _ -> self.updateAggroTarget() },
          )

  val AggroResistanceUpBuff = +buffData(102).makeSpecificResistanceUpBuff(AggroBuff)

  val ExitEvasionBuff =
      +buffData(103)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val InvincibilityBuff =
      +buffData(104)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val ApDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(105)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              flipped = { ApUpBuff },
          )

  val ApUpBuff: ContinuousBuffEffect<Unit> =
      +buffData(106)
          .makeSimpleContinuousBuffEffect(
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
          .makeContinuousBuffEffect(
              category = BuffCategory.Positive,
              locked = true,
              isResistance = true,
              onStart = { value, _ ->
                self.mod {
                  Modifier.PositiveEffectResistanceUp += value
                  Modifier.PositiveCountableEffectResistanceUp += value
                  Modifier.NegativeEffectResistanceUp += value
                  Modifier.NegativeCountableEffectResistanceUp += value
                }
              },
              onEnd = { value, _, _ ->
                self.mod {
                  Modifier.PositiveEffectResistanceUp -= value
                  Modifier.PositiveCountableEffectResistanceUp += value
                  Modifier.NegativeEffectResistanceUp -= value
                  Modifier.NegativeCountableEffectResistanceUp -= value
                }
              },
          )

  val MarkResistanceUpBuff = +buffData(118).makeSpecificResistanceUpBuff(MarkBuff)

  // Not implemented
  val EventBossDamageReductionBuff =
      +buffData(119).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val SealAct1Buff = +buffData(120).makeSimpleContinuousBuffEffect(BuffCategory.Negative)
  val SealAct2Buff = +buffData(121).makeSimpleContinuousBuffEffect(BuffCategory.Negative)
  val SealAct3Buff = +buffData(122).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val SealAct1ResistanceUpBuff = +buffData(123).makeSpecificResistanceUpBuff(SealAct1Buff)
  val SealAct2ResistanceUpBuff = +buffData(124).makeSpecificResistanceUpBuff(SealAct2Buff)
  val SealAct3ResistanceUpBuff = +buffData(125).makeSpecificResistanceUpBuff(SealAct3Buff)

  val BrillianceGainDownBuff =
      +buffData(126)
          .makeModifierContinuousBuffEffect(Modifier.BrillianceGainDown, BuffCategory.Negative)

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

  val CountableActChangeBuff = +buffData(136).makeCountableBuffEffect(BuffCategory.Positive)
  val ContinuousActChangeBuff = +buffData(137).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val LockedConfusionBuff = +buffData(138).makeLockedVariantOf(ConfusionBuff)

  val ResilienceBuff =
      +buffData(139)
          .makeSimpleContinuousBuffEffect(
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

  val ClimaxDamageDownBuff: ContinuousBuffEffect<Unit> =
      +buffData(161)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.ClimaxDamageDown,
              category = BuffCategory.Negative,
              flipped = { ClimaxDamageUpBuff })

  val LovesicknessBuff =
      +buffData(162)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val LockedLovesicknessBuff = +buffData(163).makeLockedVariantOf(LovesicknessBuff)

  val LovesicknessResistanceUpBuff = +buffData(164).makeSpecificResistanceUpBuff(LovesicknessBuff)

  val LockedLovesicknessResistanceUpBuff =
      +buffData(165).makeLockedVariantOf(LovesicknessResistanceUpBuff)

  val LockedContinuousNegativeEffectResistanceUpBuff =
      +buffData(166).makeLockedVariantOf(ContinuousNegativeEffectResistanceUpBuff)

  val SealCABuff = +buffData(167).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedSealCABuff = +buffData(168).makeLockedVariantOf(SealCABuff)

  val ElectricShockBuff =
      +buffData(169)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val LockedElectricShockBuff = +buffData(170).makeLockedVariantOf(ElectricShockBuff)

  val ElectricShockResistanceUpBuff = +buffData(171).makeSpecificResistanceUpBuff(ElectricShockBuff)

  val LockedElectricShockResistanceUpBuff =
      +buffData(172).makeLockedVariantOf(ElectricShockResistanceUpBuff)

  val ReviveBuff = +buffData(173).makeCountableBuffEffect(BuffCategory.Positive)

  val NightmareBuff =
      +buffData(174).makeDamageOverTimeBuffEffect(Modifier.NightmareDamage, exclusive = true)

  val ContinuousPositiveEffectResistanceUpBuff =
      +buffData(175)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.PositiveEffectResistanceUp, category = BuffCategory.Negative)

  val LockedContinuousPositiveEffectResistanceUpBuff =
      +buffData(176).makeLockedVariantOf(ContinuousPositiveEffectResistanceUpBuff)

  val PositiveEffectResistanceUpBuff =
      +buffData(177)
          .makeContinuousBuffEffect(
              category = BuffCategory.Positive,
              locked = true,
              onStart = { value, _ ->
                self.mod {
                  Modifier.PositiveEffectResistanceUp += value
                  Modifier.PositiveCountableEffectResistanceUp += value
                }
              },
              onEnd = { value, _, _ ->
                self.mod {
                  Modifier.PositiveEffectResistanceUp -= value
                  Modifier.PositiveCountableEffectResistanceUp += value
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
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.FixedAgility,
              category = BuffCategory.Positive,
          )

  val FixedMaxHpBoost =
      +buffData(184)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.FixedMaxHp,
              category = BuffCategory.Positive,
          )

  val FrostbiteBuff =
      +buffData(185).makeDamageOverTimeBuffEffect(Modifier.FrostbiteDamage, exclusive = true)

  val DamageToSeishoUpBuff =
      +buffData(186)
          .makeMapModifierContinuousBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Seisho,
              category = BuffCategory.Positive,
          )

  val DamageToRinmeikanUpBuff =
      +buffData(187)
          .makeMapModifierContinuousBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Rinmeikan,
              category = BuffCategory.Positive,
          )

  val DamageToFrontierUpBuff =
      +buffData(188)
          .makeMapModifierContinuousBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Frontier,
              category = BuffCategory.Positive,
          )

  val DamageToSiegfeldUpBuff =
      +buffData(189)
          .makeMapModifierContinuousBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Siegfeld,
              category = BuffCategory.Positive,
          )

  val DamageToSeiranUpBuff =
      +buffData(190)
          .makeMapModifierContinuousBuffEffect(
              { it.againstSchoolDamageDealtUp },
              key = School.Seiran,
              category = BuffCategory.Positive,
          )

  val DamageFromKarenUpBuff =
      +buffData(191)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Karen,
              category = BuffCategory.Negative,
          )

  val DamageFromHikariUpBuff =
      +buffData(192)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Hikari,
              category = BuffCategory.Negative,
          )

  val DamageFromMahiruUpBuff =
      +buffData(193)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Mahiru,
              category = BuffCategory.Negative,
          )

  val DamageFromClaudineUpBuff =
      +buffData(194)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Claudine,
              category = BuffCategory.Negative,
          )

  val DamageFromMayaUpBuff =
      +buffData(195)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Maya,
              category = BuffCategory.Negative,
          )

  val DamageFromJunnaUpBuff =
      +buffData(196)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Junna,
              category = BuffCategory.Negative,
          )

  val DamageFromNanaUpBuff =
      +buffData(197)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Nana,
              category = BuffCategory.Negative,
          )

  val DamageFromFutabaUpBuff =
      +buffData(198)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Futaba,
              category = BuffCategory.Negative,
          )

  val DamageFromKaorukoUpBuff =
      +buffData(199)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Kaoruko,
              category = BuffCategory.Negative,
          )

  val DamageFromTamaoUpBuff =
      +buffData(200)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Tamao,
              category = BuffCategory.Negative,
          )

  val DamageFromIchieUpBuff =
      +buffData(201)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Ichie,
              category = BuffCategory.Negative,
          )

  val DamageFromFumiUpBuff =
      +buffData(202)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Fumi,
              category = BuffCategory.Negative,
          )

  val DamageFromRuiUpBuff =
      +buffData(203)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Rui,
              category = BuffCategory.Negative,
          )

  val DamageFromYuyukoUpBuff =
      +buffData(204)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Yuyuko,
              category = BuffCategory.Negative,
          )

  val DamageFromAruruUpBuff =
      +buffData(205)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Aruru,
              category = BuffCategory.Negative,
          )

  val DamageFromMisoraUpBuff =
      +buffData(206)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Misora,
              category = BuffCategory.Negative,
          )

  val DamageFromLalafinUpBuff =
      +buffData(207)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Lalafin,
              category = BuffCategory.Negative,
          )

  val DamageFromTsukasaUpBuff =
      +buffData(208)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Tsukasa,
              category = BuffCategory.Negative,
          )

  val DamageFromShizuhaUpBuff =
      +buffData(209)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Shizuha,
              category = BuffCategory.Negative,
          )

  val DamageFromAkiraUpBuff =
      +buffData(210)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Akira,
              category = BuffCategory.Negative,
          )

  val DamageFromMichiruUpBuff =
      +buffData(211)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Michiru,
              category = BuffCategory.Negative,
          )

  val DamageFromMeiFanUpBuff =
      +buffData(212)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.MeiFan,
              category = BuffCategory.Negative,
          )

  val DamageFromShioriUpBuff =
      +buffData(213)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Shiori,
              category = BuffCategory.Negative,
          )

  val DamageFromYachiyoUpBuff =
      +buffData(214)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Yachiyo,
              category = BuffCategory.Negative,
          )

  val DamageFromKoharuUpBuff =
      +buffData(215)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Koharu,
              category = BuffCategory.Negative,
          )

  val DamageFromSuzuUpBuff =
      +buffData(216)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Suzu,
              category = BuffCategory.Negative,
          )

  val DamageFromHisameUpBuff =
      +buffData(217)
          .makeMapModifierContinuousBuffEffect(
              { it.fromCharacterDamageReceivedUp },
              key = Character.Hisame,
              category = BuffCategory.Negative,
          )

  val AgonyBuff =
      +buffData(218)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val LockedAggroBuff = +buffData(219).makeLockedVariantOf(AggroBuff)

  val LockedSealAct1Buff = +buffData(220).makeLockedVariantOf(SealAct1Buff)
  val LockedSealAct2Buff = +buffData(221).makeLockedVariantOf(SealAct2Buff)
  val LockedSealAct3Buff = +buffData(222).makeLockedVariantOf(SealAct3Buff)

  val LockedNormalBarrierBuff = +buffData(223).makeLockedVariantOf(NormalBarrierBuff)

  val LockedSpecialBarrierBuff = +buffData(224).makeLockedVariantOf(SpecialBarrierBuff)

  val PossessionBuff =
      +buffData(225)
          .makeContinuousBuffEffect(
              BuffCategory.Positive,
              related = ResilienceBuff,
              onStart = { _, _ -> self.mod { Modifier.NegativeEffectResistanceUp += 100 } },
              onEnd = { _, _, _ ->
                self.mod { Modifier.NegativeEffectResistanceUp -= 100 }
                self.exit()
              },
          )

  val LockedPossessionBuff = +buffData(226).makeLockedVariantOf(PossessionBuff)

  val LockedApDownBuff = +buffData(227).makeLockedVariantOf(ApDownBuff)

  val LockedCriticalUpBuff = +buffData(228).makeLockedVariantOf(CriticalUpBuff)

  // Not implemented
  // Doesn't work in PvE anyways
  val CurtainsClosedBuff = +buffData(229).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedCurtainsClosedBuff = +buffData(230).makeLockedVariantOf(CurtainsClosedBuff)

  val NegativeCountableEffectResistanceUpBuff =
      +buffData(231)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.NegativeCountableEffectResistanceUp,
              category = BuffCategory.Positive,
              isResistance = true,
          )

  val LockedNegativeCountableEffectResistanceUpBuff =
      +buffData(232).makeLockedVariantOf(NegativeCountableEffectResistanceUpBuff)

  val BrillianceGainUpBuff =
      +buffData(233)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BrillianceGainUp,
              category = BuffCategory.Positive,
          )

  val LockedResilienceBuff = +buffData(234).makeLockedVariantOf(ResilienceBuff)

  val ApUp2Buff: ContinuousBuffEffect<Unit> =
      +buffData(235)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
          )

  val LockedApUp2Buff: ContinuousBuffEffect<Unit> =
      +buffData(236)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
          )

  val ApDown2Buff: ContinuousBuffEffect<Unit> =
      +buffData(237)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
          )

  val LockedApDown2Buff: ContinuousBuffEffect<Unit> =
      +buffData(238)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
          )

  val CutinInitialCooldownReductionBuff =
      +buffData(239)
          .makeContinuousBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value, _ -> self.cutinInitialCooldownReductionPool += value },
              onEnd = { value, _, _ -> self.cutinInitialCooldownReductionPool -= value },
          )

  val CounterHealBuff2 =
      +buffData(240)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.CounterHealFixed,
              category = BuffCategory.Positive,
          )

  val HoldBackBuff = +buffData(241).makeCountableBuffEffect(BuffCategory.Negative)

  val SealStageEffectBuff = +buffData(242).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedSealStageEffectBuff = +buffData(243).makeLockedVariantOf(SealStageEffectBuff)

  // This is for OR, so it's not really used
  val AddActs1Buff = +buffData(244).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val AddActs2Buff = +buffData(245).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  //    val BulkheadBuff = +buffData(246).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  // Not implemented
  val AntiOathRevueBuff = +buffData(247).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val DisasterBrillianceReductionBuff =
      +buffData(248).makeCountableBuffEffect(BuffCategory.Negative)

  val BlessingHpRecoveryBuff = +buffData(249).makeCountableBuffEffect(BuffCategory.Positive)

  val BlessingReduceCountableNegativeEffectsBuff =
      +buffData(250).makeCountableBuffEffect(BuffCategory.Positive)

  val DisasterDaze = +buffData(251).makeCountableBuffEffect(BuffCategory.Negative)

  val BlessingRemoveContinuousNegativeEffectsBuff =
      +buffData(252).makeCountableBuffEffect(BuffCategory.Positive)

  val DazeResistanceUpBuff = +buffData(253).makeSpecificResistanceUpBuff(DazeBuff)

  val LockedDazeResistanceUpBuff = +buffData(254).makeLockedVariantOf(DazeResistanceUpBuff)

  val BlessingHopeBuff = +buffData(255).makeCountableBuffEffect(BuffCategory.Positive)

  val ImpudenceResistanceUpBuff = +buffData(256).makeSpecificResistanceUpBuff(ImpudenceBuff)

  val LockedImpudenceResistanceUpBuff =
      +buffData(257).makeLockedVariantOf(ImpudenceResistanceUpBuff)

  val NormalSuperReflectBuff =
      +buffData(258)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
          )

  val SpecialSuperReflectBuff =
      +buffData(259)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
          )

  val LockedNormalSuperReflectBuff = +buffData(260).makeLockedVariantOf(NormalSuperReflectBuff)

  val LockedSpecialSuperReflectBuff = +buffData(261).makeLockedVariantOf(SpecialSuperReflectBuff)

  val BlessingEffectiveDamageUpBuff = +buffData(262).makeCountableBuffEffect(BuffCategory.Positive)

  val InvincibleRebirthBuff = +buffData(263).makeCountableBuffEffect(BuffCategory.Positive)

  // TODO: implement this
  val SacrificeBuff = +buffData(264).makeCountableBuffEffect(BuffCategory.Negative)

  val DisasterApUpBuff = +buffData(265).makeCountableBuffEffect(BuffCategory.Negative)

  val BlessingApDown2 = +buffData(266).makeCountableBuffEffect(BuffCategory.Positive)

  val ContractionBuff =
      +buffData(267)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Negative,
              exclusive = true,
          )

  val HpRegenBuff2 =
      +buffData(268)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value ->
                if (value <= 100) {
                  self.mod { Modifier.HpPercentRegen += value }
                } else {
                  self.mod { Modifier.HpRegen += value }
                }
              },
              onEnd = { value ->
                if (value <= 100) {
                  self.mod { Modifier.HpPercentRegen -= value }
                } else {
                  self.mod { Modifier.HpRegen -= value }
                }
              },
          )

  // TODO: Not implemented
  val SealInstantSkillBuff = +buffData(269).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedSealInstantSkillBuff = +buffData(270).makeLockedVariantOf(SealInstantSkillBuff)

  val CountablePositiveEffectResistanceUpBuff =
      +buffData(271)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.PositiveCountableEffectResistanceUp,
              category = BuffCategory.Negative,
          )

  val LockedCountablePositiveEffectResistanceUpBuff =
      +buffData(272).makeLockedVariantOf(CountablePositiveEffectResistanceUpBuff)

  val LockedPerfectAimBuff = +buffData(273).makeLockedVariantOf(PerfectAimBuff)

  val StaminaActPowerUpBuff =
      +buffData(274)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.StaminaActPowerUp,
              category = BuffCategory.Positive,
          )

  val OverwhelmBuff = +buffData(275).makeCountableBuffEffect(BuffCategory.Negative, isLocked = true)

  val MultipleCAficationBuff =
      +buffData(276)
          .makeSimpleContinuousBuffEffect(
              category = BuffCategory.Positive,
              exclusive = true,
          )

  val BrillianceSapBuff =
      +buffData(277)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BrillianceSap,
              category = BuffCategory.Negative,
          )

  val LockedEffectiveDamageDealtUpBuff =
      +buffData(278).makeLockedVariantOf(EffectiveDamageDealtUpBuff)

  val LockedBrillianceRegenBuff = +buffData(279).makeLockedVariantOf(BrillianceRegenBuff)

  val ReviveRegenBuff =
      +buffData(280)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.ReviveRegen,
              category = BuffCategory.Positive,
          )

  val LockedInvincibilityBuff = +buffData(281).makeLockedVariantOf(InvincibilityBuff)

  val SealStageEffectResistanceUpBuff =
      +buffData(282).makeSpecificResistanceUpBuff(SealStageEffectBuff)

  val LockedSealStageEffectResistanceUpBuff =
      +buffData(283).makeLockedVariantOf(SealStageEffectResistanceUpBuff)

  val TurnRemoveContinuousNegativeEffectsBuff =
      +buffData(284).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val LockedTurnRemoveContinuousNegativeEffectsBuff =
      +buffData(285).makeLockedVariantOf(TurnRemoveContinuousNegativeEffectsBuff)

  val TurnRemoveCountableNegativeEffectsBuff =
      +buffData(286).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val LockedTurnRemoveCountableNegativeEffectsBuff =
      +buffData(287).makeLockedVariantOf(TurnRemoveCountableNegativeEffectsBuff)

  val TurnRemoveContinuousPositiveEffectsBuff =
      +buffData(288).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedTurnRemoveContinuousPositiveEffectsBuff =
      +buffData(289).makeLockedVariantOf(TurnRemoveContinuousPositiveEffectsBuff)

  //  val TurnRemoveCountablePositiveEffectsBuff =
  //      +buffData(xxx).makeSimpleContinuousBuffEffect(BuffCategory.Negative)
  //
  //  val LockedTurnRemoveCountablePositiveEffectsBuff =
  //      +buffData(xxx).makeLockedVariantOf(TurnRemoveCountablePositiveEffectsBuff)

  val SuperStrengthBuff = +buffData(290).makeCountableBuffEffect(BuffCategory.Positive)

  val SuperStrengthRegenBuff =
      +buffData(292)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.SuperStrengthRegen,
              category = BuffCategory.Positive,
          )

  val LockedSuperStrengthRegenBuff = +buffData(293).makeLockedVariantOf(SuperStrengthRegenBuff)

  val CheerBuff = +buffData(294).makeCountableBuffEffect(BuffCategory.Positive)

  val TurnReduceCountableNegativeEffectsBuff =
      +buffData(297)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.TurnReduceCountableNegativeEffects,
              category = BuffCategory.Positive,
          )

  val LockedTurnReduceCountableNegativeEffectsBuff =
      +buffData(298).makeLockedVariantOf(TurnReduceCountableNegativeEffectsBuff)

  val BrillianceRegenTurnScalingBuff =
      +buffData(299)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.BrillianceRegenTurnScaling,
              category = BuffCategory.Positive,
          )

  val LockedBrillianceRegenTurnScalingBuff =
      +buffData(300).makeLockedVariantOf(BrillianceRegenTurnScalingBuff)

  val LockedAgonyBuff = +buffData(301).makeLockedVariantOf(AgonyBuff)

  val SealMultipleCABuff = +buffData(302).makeSimpleContinuousBuffEffect(BuffCategory.Negative)
  val LockedSealMultipleCABuff = +buffData(303).makeLockedVariantOf(SealMultipleCABuff)

  // TODO: Implement this if needed
  val FumblingInTheDarkBuff = +buffData(304).makeSimpleContinuousBuffEffect(BuffCategory.Negative)
  val EvilCurseBuff = +buffData(305).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val ActBoostImpudenceBuff = +buffData(306).makeCountableBuffEffect(BuffCategory.Positive)

  val BlessingRemoveCountableNegativeEffectsBuff =
      +buffData(307).makeCountableBuffEffect(BuffCategory.Positive)

  val DelusionBuff = +buffData(308).makeCountableBuffEffect(BuffCategory.Negative)

  val CutinCostReductionBuff =
      +buffData(309)
          .makeContinuousBuffEffect(
              category = BuffCategory.Positive,
              onStart = { value, _ -> self.cutinCostReductionPool += value },
              onEnd = { value, _, _ -> self.cutinCostReductionPool -= value },
          )

  val LockedCutinCostReductionBuff = +buffData(310).makeLockedVariantOf(CutinCostReductionBuff)

  val ActBoostDazeBuff = +buffData(311).makeCountableBuffEffect(BuffCategory.Positive)

  // TODO: Implement this if needed
  val ReflectStageEffectSelfTrappingBuff =
      +buffData(312).makeSimpleContinuousBuffEffect(BuffCategory.Positive)
  val ReflectStageEffectCaptivatingPupilsBuff =
      +buffData(313).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val WeakenBuff =
      +buffData(314)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.Weaken,
              category = BuffCategory.Negative,
          )

  // TODO: Implement
  val StageEffectSealResistanceRegenBuff =
      +buffData(315).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val ContinuousPositiveTurnReductionRegenBuff =
      +buffData(316)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.ContinuousPositiveTurnReductionRegen,
              category = BuffCategory.Negative,
          )

  val LockedContinuousPositiveTurnReductionRegenBuff =
      +buffData(317).makeLockedVariantOf(ContinuousPositiveTurnReductionRegenBuff)

  val ReflectStageEffectHesitationBuffEffect =
      +buffData(318).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val ReflectStageEffectPlanOfTheAbyssBuffEffect =
      +buffData(319).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val ReflectStageEffectSugaryCorruptionBuffEffect =
      +buffData(320).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val AgonyResistanceUpBuff = +buffData(321).makeSpecificResistanceUpBuff(AgonyBuff)

  val LockedAgonyResistanceUpBuff = +buffData(322).makeLockedVariantOf(AgonyResistanceUpBuff)

  val SealCAResistanceUpBuff = +buffData(323).makeSpecificResistanceUpBuff(SealCABuff)

  val LockedSealCAResistanceUpBuff = +buffData(324).makeLockedVariantOf(SealCAResistanceUpBuff)

  val AccuracyDownResistanceUpBuff = +buffData(325).makeSpecificResistanceUpBuff(AccuracyDownBuff)

  val LockedAccuracyDownResistanceUpBuff =
      +buffData(326).makeLockedVariantOf(AccuracyDownResistanceUpBuff)

  val AgilityDownResistanceUpBuff = +buffData(327).makeSpecificResistanceUpBuff(AgilityDownBuff)

  val LockedAgilityDownResistanceUpBuff =
      +buffData(328).makeLockedVariantOf(AgilityDownResistanceUpBuff)

  val DelusionResistanceUpBuff = +buffData(329).makeSpecificResistanceUpBuff(DelusionBuff)

  val LockedDelusionResistanceUpBuff = +buffData(330).makeLockedVariantOf(DelusionResistanceUpBuff)

  // TODO: Implement falling out

  val FallingOutDaze =
      +buffData(331)
          .makeCountableBuffEffect(
              category = BuffCategory.Negative,
          )

  val FallingOutImpudence =
      +buffData(332)
          .makeCountableBuffEffect(
              category = BuffCategory.Negative,
          )

  val ContractionResistanceUpBuff =
      +buffData(333)
          .makeSpecificResistanceUpBuff(
              ContractionBuff,
          )

  val LockedContractionResistanceUpBuff =
      +buffData(334).makeLockedVariantOf(ContractionResistanceUpBuff)

  val ReflectStageEffectGrayWorldBuff =
      +buffData(335).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val ReflectStageEffectThunderBuff =
      +buffData(336).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val StealResistanceUpBuff = +buffData(337).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val NegativeStageEffectResistanceUp =
      +buffData(338).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val PositiveStageEffectResistanceUp =
      +buffData(339).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val ReflectStageEffectNightPlayfulnessBuff =
      +buffData(340).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val ReflectStageEffectImprisonmentBuff =
      +buffData(341).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val IntimidationBuff =
      +buffData(342).makeCountableBuffEffect(BuffCategory.Negative, isLocked = true)

  val GreaterBurnBuff = +buffData(1001).makeGreaterVariantOf(BurnBuff)

  val GreaterConfusionBuff = +buffData(1002).makeGreaterVariantOf(ConfusionBuff)

  val GreaterBlindnessBuff = +buffData(1003).makeGreaterVariantOf(BlindnessBuff)

  val GreaterFreezeBuff = +buffData(1004).makeGreaterVariantOf(FreezeBuff)

  val GreaterApUpBuff = +buffData(1005).makeGreaterVariantOf(ApUpBuff)

  val GreaterProvokeBuff = +buffData(1006).makeGreaterVariantOf(ProvokeBuff)

  // TODO: figure out if greater resistances affect base resistances

  val GreaterBurnResistanceUpBuff = +buffData(1007).makeSpecificResistanceUpBuff(GreaterBurnBuff)

  val GreaterBlindnessResistanceUpBuff =
      +buffData(1008).makeSpecificResistanceUpBuff(GreaterBlindnessBuff)

  val GreaterConfusionResistanceUpBuff =
      +buffData(1009).makeSpecificResistanceUpBuff(GreaterConfusionBuff)

  val GreaterDamageReceivedDownBuff = +buffData(1010).makeGreaterVariantOf(DamageReceivedDownBuff)

  val GreaterEvasionBuff = +buffData(1011).makeGreaterVariantOf(EvasionBuff)

  val GreaterStopBuff = +buffData(1012).makeGreaterVariantOf(StopBuff)

  val GreaterFortitudeBuff = +buffData(1013).makeGreaterVariantOf(FortitudeBuff)

  val GreaterFreezeResistanceUpBuff =
      +buffData(1014).makeSpecificResistanceUpBuff(GreaterFreezeBuff)

  val GreaterStopResistanceUpBuff = +buffData(1015).makeSpecificResistanceUpBuff(GreaterStopBuff)

  val GreaterFrostbiteBuff = +buffData(1016).makeGreaterVariantOf(FrostbiteBuff)

  val GreaterElectricShockBuff = +buffData(1017).makeGreaterVariantOf(ElectricShockBuff)

  val GreaterAgonyBuff = +buffData(1018).makeGreaterVariantOf(AgonyBuff)

  val GreaterAgonyResistanceUpBuff = +buffData(1019).makeSpecificResistanceUpBuff(GreaterAgonyBuff)

  val GreaterFrostbiteResistanceUpBuff =
      +buffData(1020).makeSpecificResistanceUpBuff(GreaterFrostbiteBuff)

  val GreaterStagnationBuff = +buffData(1021).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterIgnoranceBuff =
      +buffData(1022)
          .makeSimpleContinuousBuffEffect(
              BuffCategory.Negative,
              onStart = { _ -> self.mod { Modifier.PositiveCountableEffectResistanceUp += 100 } },
              onEnd = { _ -> self.mod { Modifier.PositiveCountableEffectResistanceUp -= 100 } },
          )

  val GreaterAggroBuff = +buffData(1023).makeGreaterVariantOf(AggroBuff)

  val GreaterCriticalDamageReceivedDownBuff =
      +buffData(1024).makeGreaterVariantOf(CriticalDamageReceivedDownBuff)

  val GreaterCombinedResistanceUpBuff =
      +buffData(1025)
          .makeMultipleResistanceUpBuff(
              listOf(GreaterConfusionBuff, GreaterBlindnessBuff, GreaterBurnBuff))

  val GreaterInsanityBuff = +buffData(1026).makeCountableBuffEffect(BuffCategory.Negative)

  val GreaterFixedClimaxActPowerUp: ContinuousBuffEffect<Unit> =
      +buffData(1027)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.ClimaxDamageFixedUp,
              category = BuffCategory.Positive,
              exclusive = true)

  val GreaterApDownBuff = +buffData(1028).makeGreaterVariantOf(ApDownBuff)

  val GreaterSleepBuff = +buffData(1029).makeGreaterVariantOf(SleepBuff)

  val GreaterCriticalUpBuff = +buffData(1030).makeGreaterVariantOf(CriticalUpBuff)

  val GreaterEffectiveDamageDealtUpBuff =
      +buffData(1031).makeGreaterVariantOf(EffectiveDamageDealtUpBuff)

  val GreaterArroganceBuff = +buffData(1032).makeCountableBuffEffect(BuffCategory.Negative)

  val GreaterElectricShockResistanceUpBuff =
      +buffData(1033)
          .makeMultipleResistanceUpBuff(listOf(GreaterElectricShockBuff, ElectricShockBuff))

  val GreaterReviveBuff = +buffData(1034).makeGreaterVariantOf(ReviveBuff)

  val GreaterCombinedResistanceUpFreezeStopBuff =
      +buffData(1035).makeMultipleResistanceUpBuff(listOf(GreaterFreezeBuff, GreaterStopBuff))

  val GreaterStunBuff = +buffData(1036).makeGreaterVariantOf(StunBuff)

  val GreaterPerfectAimBuff = +buffData(1037).makeGreaterVariantOf(PerfectAimBuff)

  val GreaterSleepResistanceUpBuff = +buffData(1038).makeSpecificResistanceUpBuff(GreaterSleepBuff)

  val GreaterApUpResistanceUpBuff = +buffData(1039).makeSpecificResistanceUpBuff(GreaterApUpBuff)

  val GreaterInvincibilityBuff = +buffData(1040).makeGreaterVariantOf(InvincibilityBuff)

  val ExcludingGreaterArroganceResistanceUpBuff =
      +buffData(1041).makeResistanceUpExceptBuff(listOf(GreaterArroganceBuff))

  val ExcludingGreaterInsanityResistanceUpBuff =
      +buffData(1042).makeResistanceUpExceptBuff(listOf(GreaterInsanityBuff))

  val GreaterStunResistanceUpBuff = +buffData(1043).makeSpecificResistanceUpBuff(GreaterStunBuff)

  // TODO: Stacking with ordinary mark?
  val GreaterMarkBuff = +buffData(1044).makeGreaterVariantOf(MarkBuff)

  val GreaterAgilityUpBuff = +buffData(1045).makeGreaterVariantOf(AgilityUpBuff)

  val GreaterBrillianceRecoveryDownBuff =
      +buffData(1046).makeGreaterVariantOf(BrillianceGainDownBuff)

  val GreaterSealAct3Buff = +buffData(1047).makeGreaterVariantOf(SealAct3Buff)

  val PierceGreaterInvincible =
      +buffData(1048).makeSimpleContinuousBuffEffect(BuffCategory.Positive) // TODO

  // TODO: Priority vs normal hope buff?
  val GreaterHopeBuff = +buffData(1049).makeGreaterVariantOf(HopeBuff)

  val GreaterMaxHpUpBuff = +buffData(1050).makeGreaterVariantOf(MaxHpUpBuff)

  val GreaterLovesicknessBuff = +buffData(1051).makeGreaterVariantOf(LovesicknessBuff)

  val GreaterDexterityUpBuff = +buffData(1052).makeGreaterVariantOf(DexterityUpBuff)

  val GreaterActPowerDownBuff = +buffData(1053).makeGreaterVariantOf(ActPowerDownBuff)

  val GreaterCriticalDownBuff = +buffData(1054).makeGreaterVariantOf(CriticalDownBuff)

  val GreaterCombinedResistanceUpElectricShockSleep =
      +buffData(1055)
          .makeMultipleResistanceUpBuff(listOf(GreaterElectricShockBuff, GreaterSleepBuff))

  val GreaterHpRegenBuff = +buffData(1056).makeGreaterVariantOf(HpRegenBuff)

  val GreaterBrillianceRegenBuff = +buffData(1057).makeGreaterVariantOf(BrillianceRegenBuff)

  val GreaterAgilityDownBuff = +buffData(1058).makeGreaterVariantOf(AgilityDownBuff)

  val GreaterCounterHealBuff = +buffData(1059).makeGreaterVariantOf(CounterHealBuff)

  val GreaterBlessingHpRecoveryBuff = +buffData(1060).makeGreaterVariantOf(BlessingHpRecoveryBuff)

  val GreaterAggroResistanceUpBuff = +buffData(1061).makeSpecificResistanceUpBuff(GreaterAggroBuff)

  val GreaterSuperStrengthBuff = +buffData(1062).makeGreaterVariantOf(SuperStrengthBuff)

  val GreaterSealStageEffectBuff = +buffData(1063).makeGreaterVariantOf(SealStageEffectBuff)

  val GreaterSealStageEffectResistanceUpBuff =
      +buffData(1064).makeSpecificResistanceUpBuff(GreaterSealStageEffectBuff)

  val GreaterLovesicknessResistanceUpBuff =
      +buffData(1065).makeSpecificResistanceUpBuff(GreaterLovesicknessBuff)

  val GreaterMaxHpDownBuff = +buffData(1066).makeGreaterVariantOf(MaxHpDownBuff)

  val GreaterPanicBuff = +buffData(1067).makeCountableBuffEffect(BuffCategory.Negative)

  val ResistanceUpExceptGreaterPanicBuff =
      +buffData(1068).makeResistanceUpExceptBuff(listOf(GreaterPanicBuff))

  val GreaterNightmareBuff = +buffData(1069).makeGreaterVariantOf(NightmareBuff)

  val GreaterNightmareResistanceUpBuff =
      +buffData(1070).makeSpecificResistanceUpBuff(GreaterNightmareBuff)

  val GreaterMultipleCAficationBuff = +buffData(1071).makeGreaterVariantOf(MultipleCAficationBuff)

  val GreaterImpudenceBuff = +buffData(1072).makeGreaterVariantOf(ImpudenceBuff)

  val GreaterActPowerUpBuff = +buffData(1073).makeGreaterVariantOf(ActPowerUpBuff)

  val GreaterNormalReflectBuffBuff = +buffData(1074).makeGreaterVariantOf(NormalReflectBuff)

  val GreaterSpecialReflectBuffBuff = +buffData(1075).makeGreaterVariantOf(SpecialReflectBuff)

  val GreaterPoison = +buffData(1076).makeGreaterVariantOf(PoisonBuff)

  val GreaterCutinInitialCooldownReductionBuff =
      +buffData(1077).makeGreaterVariantOf(CutinInitialCooldownReductionBuff)

  val GreaterCutinCostReductionBuff = +buffData(1078).makeGreaterVariantOf(CutinCostReductionBuff)

  // Bonus DMG vs Boss

  val GreaterInvincibleRebirthBuff = +buffData(1080).makeGreaterVariantOf(InvincibleRebirthBuff)

  val GreaterSealCABuff = +buffData(1081).makeGreaterVariantOf(SealCABuff)

  val OpposeNegativeStageEffectBuff =
      +buffData(1082).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val RestrictPositiveStageEffectBuff =
      +buffData(1083).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterApDown2Buff = +buffData(1084).makeGreaterVariantOf(ApDown2Buff)

  // 1085: ?

  val GreaterCombinedResistanceUpStunLovesicknessBuff =
      +buffData(1086).makeMultipleResistanceUpBuff(listOf(GreaterStunBuff, GreaterLovesicknessBuff))

  val GreaterApUp2Buff = +buffData(1087).makeGreaterVariantOf(ApUp2Buff)

  // Disabled in PvE
  val GreaterMiraculousRecoveryBuff =
      +buffData(1088).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val GreaterImpudenceResistanceUpBuff =
      +buffData(1089).makeSpecificResistanceUpBuff(GreaterImpudenceBuff)

  val GreaterSealAct2Buff = +buffData(1090).makeGreaterVariantOf(SealAct2Buff)

  val GreaterContractionBuff = +buffData(1091).makeGreaterVariantOf(ContractionBuff)

  val GreaterDisasterBrillianceReductionBuff =
      +buffData(1092).makeGreaterVariantOf(DisasterBrillianceReductionBuff)

  val GreaterDisasterGreaterApUpBuff = +buffData(1093).makeGreaterVariantOf(DisasterApUpBuff)

  val GreaterSealAct1Buff = +buffData(1094).makeGreaterVariantOf(SealAct1Buff)

  val GreaterCheerBuff = +buffData(1095).makeGreaterVariantOf(CheerBuff)

  // Mind the swapped id order
  val GreaterDamageDownBuff = +buffData(1097).makeGreaterVariantOf(DamageDealtDownBuff)

  val GreaterDamageDownResistanceUpBuff =
      +buffData(1096).makeSpecificResistanceUpBuff(GreaterDamageDownBuff)

  val GreaterWeakSpotBuff = +buffData(1098).makeGreaterVariantOf(WeakSpotBuff)

  val GreaterDazeBuff = +buffData(1099).makeGreaterVariantOf(DazeBuff)

  val GreaterSealCAResistanceUpBuff =
      +buffData(1100).makeSpecificResistanceUpBuff(GreaterSealCABuff)

  val GreaterActBoostGreaterDazeBuff =
      +buffData(1101).makeCountableBuffEffect(BuffCategory.Positive)

  val GreaterCombinedResistanceUpSealStageEffectApUpBuff =
      +buffData(1102)
          .makeMultipleResistanceUpBuff(listOf(GreaterSealStageEffectBuff, GreaterApUpBuff))

  val HinderGreaterApDownBuff =
      +buffData(1103).makeMultipleResistanceUpBuff(listOf(GreaterApDownBuff))

  val GreaterDazeResistanceUpBuff = +buffData(1104).makeSpecificResistanceUpBuff(GreaterDazeBuff)

  val GreaterDamageDealtUpBuff = +buffData(1105).makeGreaterVariantOf(DamageDealtUpBuff)

  val GreaterCombinedResistanceSealAct2SealAct3SealCABuff =
      +buffData(1106)
          .makeMultipleResistanceUpBuff(
              listOf(
                  GreaterSealAct2Buff, GreaterSealAct3Buff, GreaterSealCABuff, GreaterSealCABuff))

  val GreaterSlumpBuff = +buffData(1107).makeModifierContinuousBuffEffect(
      Modifier.BrillianceGainDown,
      BuffCategory.Negative,
  )

  val GreaterFallingOutGreaterDazeBuff = +buffData(1108).makeGreaterVariantOf(FallingOutDaze)

  val GreaterCountableNegativeEffectResistanceUpBuff =
      +buffData(1109)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.GreaterNegativeCountableEffectResistanceUp,
              category = BuffCategory.Positive,
          )

  val GreaterActBoostGreaterImpudenceBuff =
      +buffData(1110).makeCountableBuffEffect(BuffCategory.Positive)

  val GreaterApUp3Buff = +buffData(1111).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterActBoostGreaterPanicBuff =
      +buffData(1112).makeCountableBuffEffect(BuffCategory.Positive)

  val GreaterPoisonResistanceUpBuff = +buffData(1113).makeSpecificResistanceUpBuff(GreaterPoison)

  val GreaterGospelOfGloryBuff =
      +buffData(1114)
          .makeContinuousBuffEffect(
              BuffCategory.Positive,
              onStart = { _, _ ->
                self.mod {
                  Modifier.BrillianceRegen += 100
                  Modifier.HpRegen += 99_999
                  Modifier.ActPowerUp += 50
                }
              },
              onEnd = { _, _, _ ->
                self.mod {
                  Modifier.BrillianceRegen -= 100
                  Modifier.HpRegen -= 99_999
                  Modifier.ActPowerUp -= 50
                }
              },
          )

  val GreaterContinuousNegativeEffectResistanceUpBuff =
      +buffData(1115)
          .makeModifierContinuousBuffEffect(
              modifier = Modifier.GreaterNegativeEffectResistanceUp,
              category = BuffCategory.Positive,
          )

  val HinderGreaterApDown2Buff =
      +buffData(1116).makeMultipleResistanceUpBuff(listOf(GreaterApDown2Buff))

  val GreaterFallingOutGreaterSlump = +buffData(1117).makeCountableBuffEffect(BuffCategory.Negative)

  val GreaterDishearteningBuff =
      +buffData(1118).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterCurtainsClosedBuff =
      +buffData(1119).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterBrillianceRecoveryUpBuff = +buffData(1120).makeGreaterVariantOf(BrillianceGainUpBuff)

  val GreaterCombinedResistanceApUpApUp2ApUp3Buff =
      +buffData(1121)
          .makeMultipleResistanceUpBuff(listOf(GreaterApUpBuff, GreaterApUp2Buff, GreaterApUp3Buff))

  val GreaterResilienceBuff = +buffData(1122).makeGreaterVariantOf(ResilienceBuff)

  val GreaterBlessingGreaterDispelCountableNegativeEffectsBuff =
      +buffData(1123).makeGreaterVariantOf(BlessingRemoveCountableNegativeEffectsBuff)

  val GreaterBlessingGreaterApDown2Buff = +buffData(1124).makeGreaterVariantOf(BlessingApDown2)

  val GreaterDisasterGreaterDishearteningBuff =
      +buffData(1125).makeCountableBuffEffect(BuffCategory.Negative)

  val GreaterBlessingGreaterDispelContinuousNegativeEffects =
      +buffData(1126).makeGreaterVariantOf(BlessingRemoveContinuousNegativeEffectsBuff)

  // TODO
  val ClimaxRevueShortenBuff = +buffData(1127).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterApDown3Buff = +buffData(1128).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val GreaterSlumpResistanceUpBuff = +buffData(1129).makeSpecificResistanceUpBuff(GreaterSlumpBuff)

  val GreaterBrillianceSapBuff = +buffData(1130).makeGreaterVariantOf(BrillianceSapBuff)

  val GreaterBrillianceGainDownResistanceUpBuff =
      +buffData(1132).makeSpecificResistanceUpBuff(GreaterBrillianceSapBuff)

  val LockedGreaterStunBuff = +buffData(1133).makeLockedVariantOf(GreaterStunBuff)

  val LockedGreaterApDownBuff = +buffData(1134).makeLockedVariantOf(GreaterApDownBuff)

  val GreaterLethargyBuff = +buffData(1135)
      .makeIdempotentContinuousBuffEffect(
          category = BuffCategory.Negative,
          onStart = { self.mod { Modifier.DamageReceivedUp += 20 } },
          onEnd = { self.mod { Modifier.DamageReceivedUp -= 20 } },
      )

  val GreaterCombinedResistanceUpDazeImpudence =
      +buffData(1136)
          .makeMultipleResistanceUpBuff(listOf(GreaterDazeBuff, GreaterImpudenceBuff))

  // TODO
  val ReflectAllNegativeStageEffectsBuff =
      +buffData(1137).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val GreaterBlessingGreaterResilienceBuff =
      +buffData(1138).makeCountableBuffEffect(BuffCategory.Positive)

  val LockedGreaterStopBuff = +buffData(1139).makeLockedVariantOf(GreaterStopBuff)

  val GreaterMasteryBuff = +buffData(1140).makeCountableBuffEffect(BuffCategory.Positive)

  // TODO: Implement enhancement

  val GreaterPoisonEnhancementApUp2Buff =
      +buffData(10001).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterPoisonEnhancementMarkBuff =
      +buffData(10002).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterPoisonEnhancementSealStageEffectBuff =
      +buffData(10003).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterPoisonEnhancementApUpBuff =
      +buffData(10004).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterPoisonEnhancementSealAct3Buff =
      +buffData(10005).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterPoisonEnhancementBrillianceRecoveryReductionBuff =
      +buffData(10006).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterPoisonEnhancementBrillianceRecoveryReductionBuff2 =
      +buffData(10007).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterBrillianceRegenEnhancementApDown2Buff =
      +buffData(10008).makeSimpleContinuousBuffEffect(BuffCategory.Positive)

  val GreaterSlumpEnhancementApUp2Buff =
      +buffData(10009).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterSlumpEnhancementMarkBuff =
      +buffData(10010).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterSlumpEnhancementSealClimaxActBuff =
      +buffData(10011).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterSlumpEnhancementSealAct3Buff =
      +buffData(10012).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterSlumpEnhancementBrillianceRecoveryReductionBuff =
      +buffData(10013).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterStunEnhancementContractionBuff =
      +buffData(10014).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedGreaterStunEnhancementContractionBuff =
      +buffData(10015).makeLockedVariantOf(GreaterStunEnhancementContractionBuff)

  val GreaterStunEnhancementSealAct1Buff =
      +buffData(10016).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val GreaterStunEnhancementSealClimateActBuff =
      +buffData(10017).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedGreaterStunEnhancementSealAct1Buff =
      +buffData(10018).makeLockedVariantOf(GreaterStunEnhancementSealAct1Buff)

  val LockedGreaterStunEnhancementSealClimateActBuff =
      +buffData(10019).makeLockedVariantOf(GreaterStunEnhancementSealClimateActBuff)

  val GreaterStunEnhancementGreaterDishearteningBuff =
      +buffData(10020).makeSimpleContinuousBuffEffect(BuffCategory.Negative)

  val LockedGreaterStunEnhancementGreaterDishearteningBuff =
      +buffData(10021).makeLockedVariantOf(GreaterStunEnhancementGreaterDishearteningBuff)

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
          LockedAgonyBuff,
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

inline val Modifiers.apChange: Int
  get() =
      actor.buffs.run {
        val decrease =
            when {
              Buffs.GreaterApDown3Buff in this -> 3
              Buffs.ApDown2Buff in this || Buffs.GreaterApDown2Buff in this -> 2
              Buffs.ApDownBuff in this || Buffs.GreaterApDownBuff in this -> 1
              else -> 0
            }
        val increase =
            when {
              Buffs.GreaterApUp3Buff in this -> 3
              Buffs.ApUp2Buff in this || Buffs.GreaterApUp2Buff in this -> 2
              Buffs.ApUpBuff in this || Buffs.GreaterApUpBuff in this -> 1
              else -> 0
            }
        increase - decrease
      }

val Actor.hasMultipleCA
  get() =
      (dress.multipleCA ||
          Buffs.MultipleCAficationBuff in buffs ||
          Buffs.GreaterMultipleCAficationBuff in buffs) && Buffs.SealMultipleCABuff !in buffs
