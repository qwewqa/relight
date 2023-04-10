package xyz.qwewqa.relive.simulator.core.stage.actor

import kotlinx.serialization.Serializable

@Serializable
enum class Attribute(val id: Int? = null) {
  Neutral,
  Flower(1),
  Wind(2),
  Snow(3),
  Moon(4),
  Space(5),
  Cloud(6),
  Dream(7),
  Sun(8),
  Star(9),
}

val nonNeutralAttributes = Attribute.values().filter { it != Attribute.Neutral }

val Attribute.advantagedAgainst
  get() =
      when (this) {
        Attribute.Flower -> Attribute.Wind
        Attribute.Wind -> Attribute.Snow
        Attribute.Snow -> Attribute.Flower
        Attribute.Moon -> Attribute.Space
        Attribute.Space -> Attribute.Cloud
        Attribute.Cloud -> Attribute.Moon
        else -> null
      }

val Attribute.disadvantagedAgainst
  get() =
    when (this) {
      Attribute.Flower -> listOf(Attribute.Snow, Attribute.Sun)
      Attribute.Wind -> listOf(Attribute.Flower, Attribute.Sun)
      Attribute.Snow -> listOf(Attribute.Wind, Attribute.Sun)
      Attribute.Moon -> listOf(Attribute.Cloud, Attribute.Star)
      Attribute.Space -> listOf(Attribute.Moon, Attribute.Star)
      Attribute.Cloud -> listOf(Attribute.Space, Attribute.Star)
      Attribute.Dream -> listOf(
          Attribute.Flower,
          Attribute.Wind,
          Attribute.Snow,
          Attribute.Moon,
          Attribute.Space,
          Attribute.Cloud,
          Attribute.Sun,
          Attribute.Star
      )
      Attribute.Sun -> listOf(Attribute.Star)
      Attribute.Star -> listOf(Attribute.Sun)
      Attribute.Neutral -> emptyList()
    }

fun getEffectiveCoef(attacker: Attribute, defender: Attribute) =
    effectiveCoefs[attacker.ordinal * attributeCount + defender.ordinal]

private val attributeCount = Attribute.values().size
private val effectiveCoefs =
    IntArray(attributeCount * attributeCount) { i ->
      val attacker = Attribute.values()[i / attributeCount]
      val defender = Attribute.values()[i % attributeCount]
      effectiveCoef(attacker, defender)
    }

private fun effectiveCoef(attacker: Attribute, defender: Attribute) =
    when (defender) {
      Attribute.Flower ->
          when (attacker) {
            Attribute.Snow -> 150
            Attribute.Wind -> 50
            Attribute.Dream -> 125
            Attribute.Sun -> 200
            else -> 100
          }
      Attribute.Wind ->
          when (attacker) {
            Attribute.Flower -> 150
            Attribute.Snow -> 50
            Attribute.Dream -> 125
            Attribute.Sun -> 200
            else -> 100
          }
      Attribute.Snow ->
          when (attacker) {
            Attribute.Wind -> 150
            Attribute.Flower -> 50
            Attribute.Dream -> 125
            Attribute.Sun -> 200
            else -> 100
          }
      Attribute.Moon ->
          when (attacker) {
            Attribute.Cloud -> 150
            Attribute.Space -> 50
            Attribute.Dream -> 125
            Attribute.Star -> 200
            else -> 100
          }
      Attribute.Space ->
          when (attacker) {
            Attribute.Moon -> 150
            Attribute.Cloud -> 50
            Attribute.Dream -> 125
            Attribute.Star -> 200
            else -> 100
          }
      Attribute.Cloud ->
          when (attacker) {
            Attribute.Space -> 150
            Attribute.Moon -> 50
            Attribute.Dream -> 125
            Attribute.Star -> 200
            else -> 100
          }
      Attribute.Dream ->
          when (attacker) {
            Attribute.Dream -> 125
            Attribute.Neutral -> 100
            Attribute.Sun -> 150
            Attribute.Star -> 150
            else -> 150
          }
      Attribute.Sun ->
          when (attacker) {
            Attribute.Dream -> 125
            Attribute.Neutral -> 100
            Attribute.Flower -> 50
            Attribute.Wind -> 50
            Attribute.Snow -> 50
            Attribute.Star -> 200
            else -> 100
          }
      Attribute.Star ->
          when (attacker) {
            Attribute.Dream -> 125
            Attribute.Neutral -> 100
            Attribute.Moon -> 50
            Attribute.Space -> 50
            Attribute.Cloud -> 50
            Attribute.Sun -> 200
            else -> 100
          }
      else -> 100
    }
