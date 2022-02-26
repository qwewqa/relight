package xyz.qwewqa.relive.simulator.stage.character

import xyz.qwewqa.relive.simulator.stage.character.School.*

enum class Character {
    None(School.None),
    Unknown(School.None),
    Karen(Seisho),
    Hikari(Seisho),
    Mahiru(Seisho),
    Claudine(Seisho),
    Maya(Seisho),
    Junna(Seisho),
    Nana(Seisho),
    Futaba(Seisho),
    Kaoruko(Seisho),
    Tamao(Rinmeikan),
    Ichie(Rinmeikan),
    Fumi(Rinmeikan),
    Rui(Rinmeikan),
    Yuyuko(Rinmeikan),
    Aruru(Frontier),
    Misora(Frontier),
    Lalafin(Frontier),
    Tsukasa(Frontier),
    Shizuha(Frontier),
    Akira(Siegfeld),
    Michiru(Siegfeld),
    MeiFan(Siegfeld, "Mei Fan"),
    Shiori(Siegfeld),
    Yachiyo(Siegfeld),
    Koharu(Seiran),
    Suzu(Seiran),
    Hisame(Seiran),
    Sakura(School.None),
    Erika(School.None),
    Gemie(School.None, "Gemini"),
    ;

    val school: School
    val displayName: String

    constructor(school: School, displayName: String) {
        this.school = school
        this.displayName = displayName
    }

    constructor(school: School) {
        this.school = school
        this.displayName = name
    }
}
