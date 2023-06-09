package xyz.qwewqa.relive.simulator.client

import kotlin.random.Random

data class ArtistInfo(
    val name: String,
    val twitter: String? = null,
    val discord: String? = null,
    val pixiv: String? = null,
    val website: String? = null,
)

data class FlagInfo(
    val artist: ArtistInfo,
    val name: String,
    val weight: Double = 1.0,
) {
  val smallUrl = "img/flags/${artist.name}_${name}_sm.png"
  val largeUrl = "img/flags/${artist.name}_${name}.png"
}

object Flags : ArrayList<FlagInfo>() {
  val lime = ArtistInfo(
      name = "Lime",
      twitter = "LimeApricots",
  )

  val kekkers = ArtistInfo(
      name = "Kekkers",
      twitter = "kekwallce",
  )
  operator fun FlagInfo.unaryPlus() = this.also { add(it) }

  val kekkersRuiBeachTrans = +FlagInfo(
      artist = kekkers,
      name = "rui_beach_trans",
  )

  val limeKuinaFsgAgenderAromantic = +FlagInfo(
      artist = lime,
      name = "kuina_fsg_agender_aromantic",
  )
}

class WeightedRandomPicker<T>(values: List<T>, weightSelector: (T) -> Double) {
  private val values = values.filter { weightSelector(it) > 0 }

  private val random = Random.Default

  private val cumulativeWeights =
      this.values.map { weightSelector(it) }.scan(0.0) { acc, weight -> acc + weight }.drop(1)

  fun pick(): T {
    val r = random.nextDouble() * cumulativeWeights.last()
    val index = cumulativeWeights.binarySearch(r)
    return values[if (index < 0) -index - 1 else index]
  }
}

val flagPicker = WeightedRandomPicker(Flags, FlagInfo::weight)

fun randomFlagSmallUrl() = flagPicker.pick().smallUrl
