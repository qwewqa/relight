package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relivesim.stage.character.Character

val KarenOnlyCondition = characterCondition(Character.Karen)
val HikariOnlyCondition = characterCondition(Character.Hikari)
val MahiruOnlyCondition = characterCondition(Character.Mahiru)
val ClaudineOnlyCondition = characterCondition(Character.Claudine)
val MayaOnlyCondition = characterCondition(Character.Maya)
val JunnaOnlyCondition = characterCondition(Character.Junna)
val NanaOnlyCondition = characterCondition(Character.Nana)
val FutabaOnlyCondition = characterCondition(Character.Futaba)
val KaorukoOnlyCondition = characterCondition(Character.Kaoruko)
val TamaoOnlyCondition = characterCondition(Character.Tamao)
val IchieOnlyCondition = characterCondition(Character.Ichie)
val FumiOnlyCondition = characterCondition(Character.Fumi)
val RuiOnlyCondition = characterCondition(Character.Rui)
val YuyukoOnlyCondition = characterCondition(Character.Yuyuko)
val AruruOnlyCondition = characterCondition(Character.Aruru)
val MisoraOnlyCondition = characterCondition(Character.Misora)
val LalafinOnlyCondition = characterCondition(Character.Lalafin)
val TsukasaOnlyCondition = characterCondition(Character.Tsukasa)
val ShizuhaOnlyCondition = characterCondition(Character.Shizuha)
val AkiraOnlyCondition = characterCondition(Character.Akira)
val MichiruOnlyCondition = characterCondition(Character.Michiru)
val MeiFanOnlyCondition = characterCondition(Character.MeiFan)
val ShioriOnlyCondition = characterCondition(Character.Shiori)
val YachiyoOnlyCondition = characterCondition(Character.Yachiyo)
val KoharuOnlyCondition = characterCondition(Character.Koharu)
val SuzuOnlyCondition = characterCondition(Character.Suzu)
val HisameOnlyCondition = characterCondition(Character.Hisame)

private fun characterCondition(character: Character) = NamedCondition("${character.name} Only") {
    it.dress.character == character
}
