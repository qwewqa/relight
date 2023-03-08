package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseAccuracy
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseActPower
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseAgility
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseCritical
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseDexterity
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseEvasion
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseMaxHp
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseNormalDefense
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseSpecialDefense

data class StatData(
    val hp: I54 = 0.i54,
    val actPower: I54 = 0.i54,
    val normalDefense: I54 = 0.i54,
    val specialDefense: I54 = 0.i54,
    val agility: I54 = 0.i54,
    val dexterity: I54 = 0.i54,
    val critical: I54 = 0.i54,
    val accuracy: I54 = 0.i54,
    val evasion: I54 = 0.i54,
) {
  constructor(
      hp: Int,
      actPower: Int = 0,
      normalDefense: Int = 0,
      specialDefense: Int = 0,
      agility: Int = 0,
      dexterity: Int = 0,
      critical: Int = 0,
      accuracy: Int = 0,
      evasion: Int = 0,
  ) : this(
      hp.toI54(),
      actPower.toI54(),
      normalDefense.toI54(),
      specialDefense.toI54(),
      agility.toI54(),
      dexterity.toI54(),
      critical.toI54(),
      accuracy.toI54(),
      evasion.toI54(),
  )

  fun copy(
      hp: Int? = null,
      actPower: Int? = null,
      normalDefense: Int? = null,
      specialDefense: Int? = null,
      agility: Int? = null,
      dexterity: Int? = null,
      critical: Int? = null,
      accuracy: Int? = null,
      evasion: Int? = null,
  ) =
      copy(
          hp = hp?.toI54() ?: this.hp,
          actPower = actPower?.toI54() ?: this.actPower,
          normalDefense = normalDefense?.toI54() ?: this.normalDefense,
          specialDefense = specialDefense?.toI54() ?: this.specialDefense,
          agility = agility?.toI54() ?: this.agility,
          dexterity = dexterity?.toI54() ?: this.dexterity,
          critical = critical?.toI54() ?: this.critical,
          accuracy = accuracy?.toI54() ?: this.accuracy,
          evasion = evasion?.toI54() ?: this.evasion,
      )

  fun growthPart() =
      StatData(
          hp = hp,
          actPower = actPower,
          normalDefense = normalDefense,
          specialDefense = specialDefense,
          agility = agility,
      )

  fun fixedPart() =
      StatData(dexterity = dexterity, critical = critical, accuracy = accuracy, evasion = evasion)

  fun display() =
      """{
        |  hp: $hp,
        |  actPower: $actPower,
        |  normalDefense: $normalDefense,
        |  specialDefense: $specialDefense,
        |  agility: $agility,
        |  dexterity: $dexterity,
        |  critical: $critical,
        |  accuracy: $accuracy,
        |  evasion: $evasion,
        |}"""
          .trimMargin()

  fun displayGrowth() =
      """{
        |  hp: $hp,
        |  actPower: $actPower,
        |  normalDefense: $normalDefense,
        |  specialDefense: $specialDefense,
        |  agility: $agility,
        |}"""
          .trimMargin()

  fun addToActor(actor: Actor) {
    actor.mod {
      baseMaxHp += this@StatData.hp
      baseActPower += this@StatData.actPower
      baseNormalDefense += this@StatData.normalDefense
      baseSpecialDefense += this@StatData.specialDefense
      baseAgility += this@StatData.agility
      baseDexterity += this@StatData.dexterity
      baseCritical += this@StatData.critical
      baseAccuracy += this@StatData.accuracy
      baseEvasion += this@StatData.evasion
    }
  }

  operator fun plus(other: StatData) =
      StatData(
          hp + other.hp,
          actPower + other.actPower,
          normalDefense + other.normalDefense,
          specialDefense + other.specialDefense,
          agility + other.agility,
          dexterity + other.dexterity,
          critical + other.critical,
          accuracy + other.accuracy,
          evasion + other.evasion,
      )

  operator fun times(value: Int) =
      StatData(
          hp * value,
          actPower * value,
          normalDefense * value,
          specialDefense * value,
          agility * value,
          dexterity * value,
          critical * value,
          accuracy * value,
          evasion * value,
      )

  operator fun div(value: Int) =
      StatData(
          hp / value,
          actPower / value,
          normalDefense / value,
          specialDefense / value,
          agility / value,
          dexterity / value,
          critical / value,
          accuracy / value,
          evasion / value,
      )
}

val defaultDressStats
  get() =
      StatData(
          dexterity = 5.i54,
          critical = 50.i54,
      )
