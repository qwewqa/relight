package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.html.dom.append
import kotlinx.html.figcaption
import kotlinx.html.i
import kotlinx.html.img
import kotlinx.html.js.a
import kotlinx.html.js.figure
import kotlinx.html.span
import kotlinx.html.style
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

enum class FlagCharacterGroup(val color: String) {
  Misc("#888888"),
  Seisho("#f7545d"),
  Rinmeikan("#ba65eb"),
  Frontier("#ffc134"),
  Siegfeld("#6880f3"),
  Seiran("#1f5ba5"),
}

enum class FlagCharacter(val group: FlagCharacterGroup) {
  Kirin(FlagCharacterGroup.Misc),
  Andrew(FlagCharacterGroup.Misc),
  Ellen(FlagCharacterGroup.Misc),
  Amemiya(FlagCharacterGroup.Misc),
  Masai(FlagCharacterGroup.Misc),
  Karen(FlagCharacterGroup.Seisho),
  Hikari(FlagCharacterGroup.Seisho),
  Mahiru(FlagCharacterGroup.Seisho),
  Claudine(FlagCharacterGroup.Seisho),
  Maya(FlagCharacterGroup.Seisho),
  Junna(FlagCharacterGroup.Seisho),
  Nana(FlagCharacterGroup.Seisho),
  Futaba(FlagCharacterGroup.Seisho),
  Kaoruko(FlagCharacterGroup.Seisho),
  Tamao(FlagCharacterGroup.Rinmeikan),
  Ichie(FlagCharacterGroup.Rinmeikan),
  Fumi(FlagCharacterGroup.Rinmeikan),
  Rui(FlagCharacterGroup.Rinmeikan),
  Yuyuko(FlagCharacterGroup.Rinmeikan),
  Aruru(FlagCharacterGroup.Frontier),
  Misora(FlagCharacterGroup.Frontier),
  Lalafin(FlagCharacterGroup.Frontier),
  Tsukasa(FlagCharacterGroup.Frontier),
  Shizuha(FlagCharacterGroup.Frontier),
  Akira(FlagCharacterGroup.Siegfeld),
  Michiru(FlagCharacterGroup.Siegfeld),
  MeiFan(FlagCharacterGroup.Siegfeld),
  Shiori(FlagCharacterGroup.Siegfeld),
  Yachiyo(FlagCharacterGroup.Siegfeld),
  Stella(FlagCharacterGroup.Siegfeld),
  Shiro(FlagCharacterGroup.Siegfeld),
  Ryoko(FlagCharacterGroup.Siegfeld),
  Minku(FlagCharacterGroup.Siegfeld),
  Kuina(FlagCharacterGroup.Siegfeld),
  Koharu(FlagCharacterGroup.Seiran),
  Suzu(FlagCharacterGroup.Seiran),
  Hisame(FlagCharacterGroup.Seiran),
}

data class FlagInfo(
    val artist: ArtistInfo,
    val character: FlagCharacter,
    val name: String,
    val weight: Double = 1.0,
) {
  private fun String.normalize() =
      lowercase().replace(Regex("\\s+"), "_").replace(Regex("[^a-z0-9_]"), "")

  val smallUrl = "img/flags/${artist.name.normalize()}_${character.name.lowercase()}_${name}_sm.png"
  val largeUrl = "img/flags/${artist.name.normalize()}_${character.name.lowercase()}_${name}.png"
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

  val cy =
      +ArtistInfo(
          name = "cy",
          twitter = "cy_gameslol",
          twitterId = "1375725356263477252",
      )

  val hainu =
      +ArtistInfo(
          name = "Hainu",
          twitter = "hainusan",
          twitterId = "1220281569966903296",
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

  val tsunamyWave =
      +ArtistInfo(
          name = "TsUNaMy WaVe",
          twitter = "TsUNaMy_WaVe",
          twitterId = "4475654952",
          website = "http://www.alsubs.net/",
      )

  val vani =
      +ArtistInfo(
          name = "vani",
          twitter = "vanillabeanpuff",
          twitterId = "1515186747834978304",
      )

  val limeMahiruCupidLesbian =
      +FlagInfo(
          artist = lime,
          character = FlagCharacter.Mahiru,
          name = "cupid_lesbian",
      )

  val anonymousValentinesJunnaLesbian =
      +FlagInfo(
          artist = anonymous,
          character = FlagCharacter.Junna,
          name = "valentines_lesbian",
      )

  val huiyuanNanaFruitsTartPride =
      +FlagInfo(
          artist = huiyuan,
          character = FlagCharacter.Nana,
          name = "fruits_tart_pride",
      )

  val kekkersRuiBeachTrans =
      +FlagInfo(
          artist = kekkers,
          character = FlagCharacter.Rui,
          name = "beach_trans",
      )

  val hainuYuyukoEurydiceLesbian =
      +FlagInfo(
          artist = hainu,
          character = FlagCharacter.Yuyuko,
          name = "eurydice_lesbian",
      )

  val cyTsukasaBenzaitenLesbian =
      +FlagInfo(
          artist = cy,
          character = FlagCharacter.Tsukasa,
          name = "benzaiten_lesbian",
      )

  val anonymousArtemisAkiraAro =
      +FlagInfo(
          artist = anonymous,
          character = FlagCharacter.Akira,
          name = "artemis_aro",
      )

  val tsunamyWaveMichiruDorothyPride =
      +FlagInfo(
          artist = tsunamyWave,
          character = FlagCharacter.Michiru,
          name = "dorothy_pride",
      )

  val cyMeiFanHikoboshiPan =
      +FlagInfo(
          artist = cy,
          character = FlagCharacter.MeiFan,
          name = "hikoboshi_pan",
      )

  val vaniShioriShutenBi =
      +FlagInfo(
          artist = vani,
          character = FlagCharacter.Shiori,
          name = "shuten_bi",
      )

  val vaniRyokoCasualAgender =
      +FlagInfo(
          artist = vani,
          character = FlagCharacter.Ryoko,
          name = "casual_agender",
      )

  val limeKuinaFsgAgenderAromantic =
      +FlagInfo(
          artist = lime,
          character = FlagCharacter.Kuina,
          name = "fsg_agender_aro",
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

  ele.clear()
  ele.append {
    FlagData.flags.forEach { flag ->
      figure("art-list-figure") {
        style = "border: 2px solid ${flag.character.group.color};"
        img(classes = "art-list-img", src = flag.largeUrl)
        figcaption {
          val artist = flag.artist
          +artist.name
          +" "
          span {
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
            +" "
            if (artist.website != null) {
              a {
                href = artist.website
                target = "_blank"
                i("bi bi-link-45deg")
              }
            }
          }
        }
      }
    }
  }
}
