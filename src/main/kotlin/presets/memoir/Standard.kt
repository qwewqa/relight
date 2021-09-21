package xyz.qwewqa.relive.simulator.presets.memoir

import xyz.qwewqa.relivesim.stage.character.School
import xyz.qwewqa.relive.simulator.presets.condition.schoolCondition
import xyz.qwewqa.relive.simulator.stage.actor.StatData
import xyz.qwewqa.relive.simulator.stage.autoskill.new
import xyz.qwewqa.relive.simulator.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.stage.passive.BrillianceRecoverPassive
import xyz.qwewqa.relive.simulator.stage.passive.DamageDealtPassive
import xyz.qwewqa.relive.simulator.stage.passive.DexterityPassive
import xyz.qwewqa.relive.simulator.stage.passive.TeamActPassive

val UrashimaTaroPerformanceFlyer = Memoir(
    name = "Urashima Taro Performance Flyer",
    stats = StatData(
        actPower = 149,
    ),
    autoskills = listOf(
        DamageDealtPassive.new(8),
        DexterityPassive.new(16),
    )
)

val CoStarringWithHatsuneMiku = Memoir(
    name = "Co-starring with Hatsune Miku!",
    stats = StatData(
        actPower = 149,
    ),
    autoskills = listOf(
        BrillianceRecoverPassive.new(40)
    )
)

val FirstAnnivSiegfeldInstituteOfMusic = Memoir(
    name = "(1st Anniv.) Siegfeld Institute of Music",
    stats = StatData(
        hp = 2999,
    ),
    autoskills = listOf(
        TeamActPassive.new(7) + schoolCondition(School.Siegfeld)
    )
)

val FirstAnnivSiegfeldInstituteOfMusicLv1 = Memoir(
    name = "(1st Anniv.) Siegfeld Institute of Music [lv1]",
    stats = StatData(
        hp = 2999,
    ),
    autoskills = listOf(
        TeamActPassive.new(5) + schoolCondition(School.Siegfeld)
    )
)
