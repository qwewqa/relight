package xyz.qwewqa.relivesim.presets.memoir

import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.stage.character.School
import xyz.qwewqa.relivesim.stage.percent

val UrashimaTaroPerformanceFlyer = memoirPreset(
    max = {
        name = "Urashima Taro Performance Flyer"
        stats {
            actPower = 149
        }
        +DamageDealtAutoEffect(8.percent)
        +DexterityAutoEffect(16.percent)
    }
)
val TurtleRui = UrashimaTaroPerformanceFlyer

val FirstAnnivSeishoMusicAcademy = memoirPreset(
    min = {
        name = "(1st Anniv.) Seisho Music Academy"
        stats {
            hp = 300
        }
        +TeamActAutoEffect(5.percent).schoolOnly(School.Seisho)
    },
    max = {
        name = "(1st Anniv.) Seisho Music Academy"
        stats {
            hp = 3000
        }
        +TeamActAutoEffect(7.percent).schoolOnly(School.Seisho)
    },
    lv1max = {
        name = "(1st Anniv.) Seisho Music Academy"
        stats {
            hp = 300
        }
        +TeamActAutoEffect(7.percent).schoolOnly(School.Seisho)
    }
)
val SeishoAct = FirstAnnivSeishoMusicAcademy

val FirstAnnivSiegfeldInstituteOfMusic = memoirPreset(
    min = {
        name = "(1st Anniv.) Siegfeld Institute of Music"
        stats {
            hp = 300
        }
        +TeamActAutoEffect(5.percent).schoolOnly(School.Siegfeld)
    },
    max = {
        name = "(1st Anniv.) Siegfeld Institute of Music"
        stats {
            hp = 3000
        }
        +TeamActAutoEffect(7.percent).schoolOnly(School.Siegfeld)
    },
    lv1max = {
        name = "(1st Anniv.) Siegfeld Institute of Music"
        stats {
            hp = 300
        }
        +TeamActAutoEffect(7.percent).schoolOnly(School.Siegfeld)
    }
)
val SiegfeldAct = FirstAnnivSiegfeldInstituteOfMusic

val CoStarringWithHatsuneMiku = memoirPreset(
    max = {
        name = "Co-starring with Hatsune Miku!"
        stats {
            actPower = 149
        }
        +SelfBrillianceRecoveryAutoEffect(40)
    }
)
val Miku = CoStarringWithHatsuneMiku

val SunsetLabMemBadge = memoirPreset(
    max = {
        name = "Sunset Lab Mem Badge"
        stats {
            actPower = 299
            specialDefense = 499
        }
        +SelfBrillianceRecoveryAutoEffect(40)
    }
)

val FriendsAtTheAquarium = memoirPreset(
    max = {
        name = "Friends at the Aquarium"
        stats {
            hp = 2099
            normalDefense = 179
        }
        +SelfBrillianceRecoveryAutoEffect(40)
    },
    lv1max = {
        name = "Friends at the Aquarium"
        stats {
            hp = 210
            normalDefense = 18
        }
        +SelfBrillianceRecoveryAutoEffect(40)
    }
)
val Aquarium = FriendsAtTheAquarium

val BandsmansGreeting = memoirPreset(
    max = {
        name = "Bandsman's Greeting"
        stats {
            actPower = 149
        }
        +TeamTimedActAutoEffect(turns = 3, 10.percent)
    }
)

val PoolsideIncident = memoirPreset(
    max = {
        name = "Poolside Incident"
        stats {
            actPower = 149
        }
        +SelfBrillianceRecoveryAutoEffect(32)
        +SelfPerfectAimTimedEffectAutoEffect(turns = 3)
    }
)

val MerryChristmas2019 = memoirPreset(
    max = {
        name = "Merry Christmas 2019"
        stats {
            actPower = 149
        }
        +SelfBrillianceRecoveryAutoEffect(32)
        +SelfDexterityTimedEffectAutoEffect(turns = 3, 16.percent)
    }
)

val ReverberatingVoiceTsuabasaAndMaya = memoirPreset(
    lv1max = {
        name = "Reverberating Voice Tsuabasa & Maya"
        stats {
            hp = 300
            normalDefense = 50
        }
        +DexterityAutoEffect(16.percent)
        +PerfectAimAutoEffect()
    }
)
