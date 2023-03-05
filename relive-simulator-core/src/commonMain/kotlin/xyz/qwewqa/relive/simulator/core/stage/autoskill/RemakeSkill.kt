@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.againstAttributeDamageReceivedDownBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.modifier.*
import xyz.qwewqa.relive.simulator.stage.character.Character

// TODO: Generate this from datamines

data class Targeting(
  val name: String,
  val shortName: String = name,
  val value: ActionContext.() -> TargetContext,
)

data class Effect(
  val name: String,
  val category: AutoSkillType,
  val valueSuffix: String?,
  val timeSuffix: String?,
  val value: TargetContext.(value: Int, time: Int) -> Unit,
)

val targetings = buildMap {
  this[1001] = Targeting("Self") { targetSelf() }
  this[1002] = Targeting("All Allies", "All") { targetAllyAoe() }
  Character.values().drop(2).take(24).forEachIndexed { index, character ->
    this[index + 2501] =
        Targeting("Allied ${character.displayName}", character.displayName) {
          targetAllyAoe { it.dress.character == character }
        }
    this[index + 2601] =
        Targeting("Enemy ${character.displayName}", character.displayName) {
          targetAoe { it.dress.character == character }
        }
  }
  listOf(Character.Koharu, Character.Suzu, Character.Hisame).forEachIndexed { index, character ->
    this[index + 2525] =
        Targeting("Allied ${character.displayName}", character.displayName) {
          targetAllyAoe { it.dress.character == character }
        }
    this[index + 2625] =
        Targeting("Enemy ${character.displayName}", character.displayName) {
          targetAoe { it.dress.character == character }
        }
  }
  Attribute.values().drop(1).forEachIndexed { index, attribute ->
    this[index + 4008] =
        Targeting("Allied ${attribute.name}", attribute.name) {
          targetAllyAoe { it.dress.attribute == attribute }
        }
  }
  (1..5).forEachIndexed { index, value ->
    this[index + 2111] = Targeting("Front $value Enemies", "Front $value") { targetFront(value) }
    this[index + 2121] = Targeting("Back $value Enemies", "Back $value") { targetBack(value) }
  }
}

val passiveEffects = buildMap {
  this[123] =
      Effect(
          "Damage Dealt Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { damageDealtUp += value } }
      }
  this[39] =
      Effect(
          "Effective Damage Dealt Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { effectiveDamageUp += value } }
      }
  this[126] =
      Effect(
          "Damage Taken Down",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { damageReceivedDown += value } }
      }
  this[8] =
      Effect(
          "Act Power Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { actPowerUp += value } }
      }
  this[10] =
      Effect(
          "Normal Defense Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { normalDefenseUp += value } }
      }
  this[12] =
      Effect(
          "Special Defense Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { specialDefenseUp += value } }
      }
  this[14] =
      Effect(
          "Agility Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { agilityUp += value } }
      }
  this[18] =
      Effect(
          "Evasion Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { evasionUp += value } }
      }
  this[20] =
      Effect(
          "Dexterity Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { buffDexterity += value } }
      }
  this[22] =
      Effect(
          "Critical Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { buffCritical += value } }
      }
  this[24] =
      Effect(
          "Max HP Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { maxHpUp += value } }
      }
  this[26] =
      Effect(
          "Continuous Negative Effect Resistance Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { negativeEffectResistanceUp += value } }
      }
  this[40] =
      Effect(
          "Climax Damage Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { climaxDamageUp += value } }
      }
  this[244] =
      Effect(
          "Turn HP Recovery",
          category = AutoSkillType.Passive,
          valueSuffix = "%/t",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach {
          it.mod {
            if (value <= 100) {
              hpPercentRegen += value
            } else {
              hpFixedRegen += value
            }
          }
        }
      }
  this[29] =
      Effect(
          "Turn Brilliance Recovery",
          category = AutoSkillType.Passive,
          valueSuffix = "/t",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach { it.mod { brillianceRegen += value } }
      }
  listOf(
      Buffs.PoisonBuff,
      Buffs.BurnBuff,
      Buffs.ProvokeBuff,
      Buffs.StunBuff,
      Buffs.SleepBuff,
      Buffs.ConfusionBuff,
      Buffs.StopBuff,
      Buffs.FreezeBuff,
      Buffs.BlindnessBuff,
  )
      .forEachIndexed { index, buffEffect ->
        this[index + 91] =
            Effect(
                "${buffEffect.name} Resistance Up",
                category = AutoSkillType.Passive,
                valueSuffix = "%",
                timeSuffix = null,
            ) { value, time ->
              targets.forEach {
                it.specificBuffResist[buffEffect] = (it.specificBuffResist[buffEffect] ?: 0) + value
              }
            }
      }
  this[248] =
      Effect(
          "${Buffs.MarkBuff.name} Resistance Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach {
          it.specificBuffResist[Buffs.MarkBuff] =
              (it.specificBuffResist[Buffs.MarkBuff] ?: 0) + value
        }
      }
  this[153] =
      Effect(
          "${Buffs.AggroBuff.name} Resistance Up",
          category = AutoSkillType.Passive,
          valueSuffix = "%",
          timeSuffix = null,
      ) { value, time ->
        targets.forEach {
          it.specificBuffResist[Buffs.AggroBuff] =
              (it.specificBuffResist[Buffs.AggroBuff] ?: 0) + value
        }
      }
}

val startEffects = buildMap {
  this[89] =
      Effect(
          "Brilliance Recovery",
          category = AutoSkillType.TurnStartA,
          valueSuffix = "",
          timeSuffix = null,
      ) { value, time ->
        addBrilliance(value)
      }
  this[347] =
      Effect(
          "Brilliance Reduction",
          category = AutoSkillType.TurnStartB,
          valueSuffix = "",
          timeSuffix = null,
      ) { value, time ->
        removeBrilliance(value)
      }
  this[123] =
      Effect(
          "Damage Dealt Up Buff",
          category = AutoSkillType.TurnStartB,
          valueSuffix = "%",
          timeSuffix = "t",
      ) { value, time ->
        applyTimedBuff(Buffs.DamageDealtUpBuff, value, time)
      }
  this[126] =
      Effect(
          "Damage Taken Down Buff",
          category = AutoSkillType.TurnStartB,
          valueSuffix = "%",
          timeSuffix = "t",
      ) { value, time ->
        applyTimedBuff(Buffs.DamageReceivedDownBuff, value, time)
      }
  Attribute.values().drop(1).forEachIndexed { index, attribute ->
    this[index + 66] =
        Effect(
            "${attribute.name} Damage Taken Down Buff",
            category = AutoSkillType.TurnStartB,
            valueSuffix = "%",
            timeSuffix = "t",
        ) { value, time ->
          applyTimedBuff(againstAttributeDamageReceivedDownBuff(attribute), value, time)
        }
  }
  this[34] =
      Effect(
          "Evasion",
          category = AutoSkillType.TurnStartB,
          valueSuffix = null,
          timeSuffix = "x",
      ) { value, time ->
        applyCountableBuff(Buffs.EvasionBuff, time)
      }
  this[36] =
      Effect(
          "Fortitude",
          category = AutoSkillType.TurnStartB,
          valueSuffix = null,
          timeSuffix = "x",
      ) { value, time ->
        applyCountableBuff(Buffs.Fortitude, time)
      }
  this[30] =
      Effect(
          "Normal Barrier Buff",
          category = AutoSkillType.TurnStartB,
          valueSuffix = "",
          timeSuffix = "t",
      ) { value, time ->
        applyTimedBuff(Buffs.NormalBarrierBuff, value, time)
      }
  this[31] =
      Effect(
          "Special Barrier Buff",
          category = AutoSkillType.TurnStartB,
          valueSuffix = "",
          timeSuffix = "t",
      ) { value, time ->
        applyTimedBuff(Buffs.SpecialBarrierBuff, value, time)
      }
  this[56] =
      Effect(
          "Provoke Buff",
          category = AutoSkillType.TurnStartB,
          valueSuffix = null,
          timeSuffix = "t",
      ) { value, time ->
        applyTimedBuff(Buffs.ProvokeBuff, value, time)
      }
  this[152] =
      Effect(
          "Aggro Buff",
          category = AutoSkillType.TurnStartB,
          valueSuffix = null,
          timeSuffix = "t",
      ) { value, time ->
        applyTimedBuff(Buffs.AggroBuff, value, time)
      }
}

data class RemakePassiveEffect(
  val targeting: Targeting,
  val effect: Effect,
) : PassiveEffect {
  val name = "[${targeting.name}] ${effect.name}"
  override val type = effect.category

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) {
    effect.value(targeting.value(context), value, time)
  }
}

data class RemakeEffectEntry(
  val targeting: Targeting,
  val effect: Effect,
  val value: Int,
  val time: Int,
) {
  val passive = RemakePassiveEffect(targeting, effect)
  val data = passive.new(value, time)
  val name = "${passive.name}${if (time > 0) " (${time}t)" else ""}"
}

data class RemakeSkill(
  val id: Int,
  val effects: List<RemakeEffectEntry>,
  val icon: Int,
) {
  val name = if (effects.isNotEmpty()) effects.joinToString(", ") { it.name } else "None"
  val data = effects.map { it.data }
}
