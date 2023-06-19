package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.html.dom.append
import kotlinx.html.h4
import kotlinx.html.img
import kotlinx.html.js.a
import kotlinx.html.js.div
import kotlinx.html.js.i
import kotlinx.html.js.small
import org.w3c.dom.HTMLDivElement
import kotlin.random.Random

data class ArtistInfo(
    val name: String,
    val twitter: String? = null,
    val twitterId: String? = null,
    val discord: String? = null,
    val discordId: String? = null,
    val pixiv: String? = null,
    val pixivId: String? = null,
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

object FlagData {
  val artists = mutableListOf<ArtistInfo>()
  val flags = mutableListOf<FlagInfo>()

  operator fun ArtistInfo.unaryPlus() = this.also { artists.add(it) }
  operator fun FlagInfo.unaryPlus() = this.also { flags.add(it) }

  val anonymous =
      +ArtistInfo(
          name = "Anonymous",
      )

  val huiyuan =
      +ArtistInfo(
          name = "Huiyuan",
          twitter = "touchluck62",
          twitterId = "803899963688165376",
      )

  val kekkers =
      +ArtistInfo(
          name = "Kekkers",
          twitter = "kekwallce",
          twitterId = "1497466709581520900",
      )

  val lime =
      +ArtistInfo(
          name = "Lime",
          twitter = "LimeApricots",
          twitterId = "1223276551023685633",
      )

  val vani =
      +ArtistInfo(
          name = "vani",
          twitter = "vanillabeanpuff",
          twitterId = "1515186747834978304",
      )

  val anonymousArtemisAkiraAro =
      +FlagInfo(
          artist = anonymous,
          name = "artemis_akira_aro",
      )

  val anonymousValentinesJunnaLesbian =
      +FlagInfo(
          artist = anonymous,
          name = "valentines_junna_lesbian",
      )

  val huiyuanNanaFruitsTartPride =
      +FlagInfo(
          artist = huiyuan,
          name = "nana_fruits_tart_pride",
      )

  val limeKuinaFsgAgenderAromantic =
      +FlagInfo(
          artist = lime,
          name = "kuina_fsg_agender_aro",
      )

  val kekkersRuiBeachTrans =
      +FlagInfo(
          artist = kekkers,
          name = "rui_beach_trans",
      )

  val vaniShioriShutenBi =
      +FlagInfo(
          artist = vani,
          name = "shiori_shuten_bi",
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

val flagPicker = WeightedRandomPicker(FlagData.flags, FlagInfo::weight)

fun randomFlagSmallUrl() = flagPicker.pick().smallUrl

fun initAboutArtists() {
  val ele = document.getElementById("about-artists") as? HTMLDivElement ?: return

  if (ele.childElementCount > 0) return

  val flagsByArtist = FlagData.flags.groupBy { it.artist }

  ele.clear()
  ele.append {
    for (artist in FlagData.artists) {
      val flags = flagsByArtist[artist] ?: continue
      div("my-3") {
        h4 {
          +artist.name
          +" "
          small {
            if (artist.discordId != null) {
              a {
                href = "https://discordapp.com/users/${artist.discordId}/"
                target = "_blank"
                i("bi bi-discord")
              }
            }
            +" "
            if (artist.twitterId != null) {
              a {
                href = "https://twitter.com/i/user/${artist.twitterId}/"
                target = "_blank"
                i("bi bi-twitter")
              }
            }
            +" "
            if (artist.pixivId != null) {
              a {
                href = "https://www.pixiv.net/users/${artist.pixivId}"
                target = "_blank"
                i("bi bi-pixiv")
              }
            }
          }
        }
        div("d-flex flex-wrap") {
          for (flag in flags) {
            img(classes = "art-list-img") {
              src = flag.largeUrl
            }
          }
        }
      }
    }
  }
}
