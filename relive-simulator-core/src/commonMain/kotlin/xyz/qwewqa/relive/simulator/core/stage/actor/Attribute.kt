package xyz.qwewqa.relive.simulator.core.stage.actor

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

// Has a minor performance benefit
class AttributeMap(val default: Int) : MutableMap<Attribute, Int> {
  private val array = IntArray(Attribute.values().size) { default }

  override val entries: MutableSet<MutableMap.MutableEntry<Attribute, Int>>
    get() {
      throw UnsupportedOperationException()
    }
  override val keys: MutableSet<Attribute>
    get() {
      throw UnsupportedOperationException()
    }
  override val size: Int
    get() {
      throw UnsupportedOperationException()
    }
  override val values: MutableCollection<Int>
    get() {
      throw UnsupportedOperationException()
    }

  override fun clear() {
    throw UnsupportedOperationException()
  }

  override fun isEmpty(): Boolean = false

  override fun remove(key: Attribute): Int? {
    throw UnsupportedOperationException()
  }

  override fun putAll(from: Map<out Attribute, Int>) {
    for ((key, value) in from) {
      this[key] = value
    }
  }

  override fun put(key: Attribute, value: Int): Int =
      array[key.ordinal].also { array[key.ordinal] = value }

  override fun get(key: Attribute) = array[key.ordinal]

  override fun containsValue(value: Int) = array.contains(value)

  override fun containsKey(key: Attribute) = true
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
        else -> null
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
