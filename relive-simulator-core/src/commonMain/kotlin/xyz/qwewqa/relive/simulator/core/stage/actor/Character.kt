package xyz.qwewqa.relive.simulator.core.stage.actor

import kotlinx.serialization.Serializable
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenChara
import xyz.qwewqa.relive.simulator.core.stage.actor.School.Frontier
import xyz.qwewqa.relive.simulator.core.stage.actor.School.Rinmeikan
import xyz.qwewqa.relive.simulator.core.stage.actor.School.Seiran
import xyz.qwewqa.relive.simulator.core.stage.actor.School.Seisho
import xyz.qwewqa.relive.simulator.core.stage.actor.School.Siegfeld

@Serializable
enum class Character(val id: Int? = null, val school: School) {
  None(school = School.None),
  Unknown(school = School.None),
  Karen(id = 101, school = Seisho),
  Hikari(id = 102, school = Seisho),
  Mahiru(id = 103, school = Seisho),
  Claudine(id = 104, school = Seisho),
  Maya(id = 105, school = Seisho),
  Junna(id = 106, school = Seisho),
  Nana(id = 107, school = Seisho),
  Futaba(id = 108, school = Seisho),
  Kaoruko(id = 109, school = Seisho),
  Tamao(id = 201, school = Rinmeikan),
  Ichie(id = 202, school = Rinmeikan),
  Fumi(id = 203, school = Rinmeikan),
  Rui(id = 204, school = Rinmeikan),
  Yuyuko(id = 205, school = Rinmeikan),
  Aruru(id = 301, school = Frontier),
  Misora(id = 302, school = Frontier),
  Lalafin(id = 303, school = Frontier),
  Tsukasa(id = 304, school = Frontier),
  Shizuha(id = 305, school = Frontier),
  Akira(id = 401, school = Siegfeld),
  Michiru(id = 402, school = Siegfeld),
  MeiFan(id = 403, school = Siegfeld),
  Shiori(id = 404, school = Siegfeld),
  Yachiyo(id = 405, school = Siegfeld),
  Stella(id = 406, school = Siegfeld),
  Shiro(id = 407, school = Siegfeld),
  Ryoko(id = 408, school = Siegfeld),
  Minku(id = 409, school = Siegfeld),
  Kuina(id = 410, school = Siegfeld),
  Koharu(id = 501, school = Seiran),
  Suzu(id = 502, school = Seiran),
  Hisame(id = 503, school = Seiran),
  Sakura(id = 901, school = School.None),
  Erika(id = 902, school = School.None),
  Gemie(id = 903, school = School.None),
  ;

  val names: Map<String, String>

  val displayName: String
    get() = names.getLocalizedString()

  init {
    if (id == null) {
      names = mapOf("ja" to name, "en" to name)
    } else {
      names = valuesGenChara[id]!!.first_name
    }
  }

  companion object {
    private val byId = values().associateBy { it.id }
    fun fromId(id: Int) = byId[id] ?: Unknown
  }
}
