package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val FriendsAtTheAquarium = Memoir(
    name = "Friends at the Aquarium",
    stats = StatData(
        hp = 2099,
        normalDefense = 179,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    )
)

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
        BrillianceRecoveryPassive.new(40)
    )
)

val FirstAnnivSiegfeldInstituteOfMusic = Memoir(
    name = "(1st Anniv.) Siegfeld Institute of Music",
    stats = StatData(
        hp = 2999,
    ),
    autoskills = listOf(
        TeamActPowerUpPassive.new(7) + SiegfeldOnlyCondition
    )
)

val FirstAnnivSiegfeldInstituteOfMusicLv1 = Memoir(
    name = "(1st Anniv.) Siegfeld Institute of Music [0ub, lv1]",
    stats = StatData(
        hp = 300,
    ),
    autoskills = listOf(
        TeamActPowerUpPassive.new(5) + SiegfeldOnlyCondition
    )
)

val BandsmansGreeting = Memoir(
    name = "Bandsman's Greeting",
    stats = StatData(
        actPower = 149,
    ),
    autoskills = listOf(
        TeamActPowerUpBuffPassive.new(10, turns = 3)
    )
)

val CrazyMadScientist = Memoir(
    name = "Crazy Mad Scientist",
    stats = StatData(
        actPower = 299,
        normalDefense = 499,
    ),
    autoskills = listOf(
        CriticalUpPassive.new(30),
        DexterityPassive.new(16)
    )
)

val ThePhantomAndChristine = Memoir(
    name = "The Phantom and Christine",
    stats = StatData(
        actPower = 89,
        normalDefense = 179,
    ),
    autoskills = listOf(
        DamageDealtPassive.new(8),
        CriticalUpPassive.new(30),
    )
)

val PoolsideIncident = Memoir(
    name = "Poolside Incident",
    stats = StatData(
        actPower = 149,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfPerfectAimBuffPassive.new(turns = 3),
    )
)

val MerryChristmas2019 = Memoir(
    name = "Merry Christmas 2019",
    stats = StatData(
        actPower = 149,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16,3),
    )
)

val PrinceAndPrincessEtude = Memoir(
    name = "Prince and Princess Etude",
    stats = StatData(
        actPower = 149,
    ),
    autoskills = listOf(
        DexterityPassive.new(16),
        EffectiveDamageDealtPassive.new(12),
    )
)

val SunsetLabMemBadge = Memoir(
    name = "Sunset Lab Mem Badge",
    stats = StatData(
        actPower = 299,
        specialDefense = 499,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(40),
    )
)

val ReminiscenceMelody = Memoir(
    name = "Reminiscence Melody",
    stats = StatData(
        actPower = 299,
        specialDefense = 499,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfCriticalUpBuffPassive.new(30,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12,6),
    )
)

val ReminiscenceMelodyLv60 = Memoir(
    name = "Reminiscence Melody [0ub, Lv60]",
    stats = StatData(
        actPower = 231,
        specialDefense = 386,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfCriticalUpBuffPassive.new(21,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8,6),
    )
)

val KappoTomoyesPosterGirl = Memoir(
    name = "Kappo Tomoye's Poster Girl",
    stats = StatData(
        hp = 2999,
        actPower = 299,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12,6),
    )
)

val KappoTomoyesPosterGirlLv60 = Memoir(
    name = "Kappo Tomoye's Poster Girl [0ub, Lv60]",
    stats = StatData(
        hp = 2316,
        actPower = 231,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8,6),
    )
)