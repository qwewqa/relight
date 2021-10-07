package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.RinmeikanOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val FriendsAtTheAquarium = MemoirBlueprint(
    name = "Friends at the Aquarium",
    rarity = 4,
    baseStats = StatData(
        hp = 210,
        normalDefense = 18,
    ),
    growthStats = StatData(
        hp = 23924,
        normalDefense = 2050,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
)

val UrashimaTaroPerformanceFlyer = MemoirBlueprint(
    name = "Urashima Taro Performance Flyer",
    rarity = 4,
    baseStats = StatData(
        actPower = 15,
    ),
    growthStats = StatData(
        actPower = 1708,
    ),
    baseAutoskills = listOf(
        DamageDealtPassive.new(5),
        DexterityPassive.new(11),
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(8),
        DexterityPassive.new(16),
    ),
)

val CoStarringWithHatsuneMiku = MemoirBlueprint(
    name = "Co-starring with Hatsune Miku!",
    rarity = 4,
    baseStats = StatData(
        actPower = 15,
    ),
    growthStats = StatData(
        actPower = 1708,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
)

val FirstAnnivSiegfeldInstituteOfMusic = MemoirBlueprint(
    name = "(1st Anniv.) Siegfeld Institute of Music",
    rarity = 4,
    baseStats = StatData(
        hp = 300,
    ),
    growthStats = StatData(
        hp = 34177,
    ),
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + SiegfeldOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + SiegfeldOnlyCondition
    )
)

val FirstAnnivSeishoMusicAcademy = MemoirBlueprint(
    name = "(1st Anniv.) Seisho Music Academy",
    rarity = 4,
    baseStats = StatData(
        hp = 300,
    ),
    growthStats = StatData(
        hp = 34177,
    ),
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + SeishoOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + SeishoOnlyCondition
    )
)

val FirstAnnivRinmeikanGirlsSchool = MemoirBlueprint(
    name = "(1st Anniv.) Rinmeikan Girls School",
    rarity = 4,
    baseStats = StatData(
        hp = 300,
    ),
    growthStats = StatData(
        hp = 34177,
    ),
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + RinmeikanOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + RinmeikanOnlyCondition
    )
)

val FirstAnnivFrontierSchoolOfArts = MemoirBlueprint(
    name = "(1st Anniv.) Frontier School of Arts",
    rarity = 4,
    baseStats = StatData(
        hp = 300,
    ),
    growthStats = StatData(
        hp = 34177,
    ),
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + FrontierOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + FrontierOnlyCondition
    )
)

val BandsmansGreeting = MemoirBlueprint(
    name = "Bandsman's Greeting",
    rarity = 4,
    baseStats = StatData(
        actPower = 15,
    ),
    growthStats = StatData(
        actPower = 1708,
    ),
    baseAutoskills = listOf(
        TeamActPowerUpBuffPassive.new(3, turns = 3)
    ),
    maxAutoskills = listOf(
        TeamActPowerUpBuffPassive.new(10, turns = 3)
    ),
)

val CrazyMadScientist = MemoirBlueprint(
    name = "Crazy Mad Scientist",
    rarity = 4,
    baseStats = StatData(
        actPower = 30,
        normalDefense = 50,
    ),
    growthStats = StatData(
        actPower = 3417,
        normalDefense = 5696,
    ),
    baseAutoskills = listOf(
        CriticalUpPassive.new(21),
        DexterityPassive.new(11)
    ),
    maxAutoskills = listOf(
        CriticalUpPassive.new(30),
        DexterityPassive.new(16)
    ),
)

val ThePhantomAndChristine = MemoirBlueprint(
    name = "The Phantom and Christine",
    rarity = 4,
    baseStats = StatData(
        actPower = 9,
        normalDefense = 18,
    ),
    growthStats = StatData(
        actPower = 1025,
        normalDefense = 2050,
    ),
    baseAutoskills = listOf(
        DamageDealtPassive.new(5),
        CriticalUpPassive.new(21),
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(8),
        CriticalUpPassive.new(30),
    ),
)

val PoolsideIncident = MemoirBlueprint(
    name = "Poolside Incident",
    rarity = 4,
    baseStats = StatData(
        actPower = 15,
    ),
    growthStats = StatData(
        actPower = 1708,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfPerfectAimBuffPassive.new(turns = 3),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfPerfectAimBuffPassive.new(turns = 3),
    ),
)

val MerryChristmas2019 = MemoirBlueprint(
    name = "Merry Christmas 2019",
    rarity = 4,
    baseStats = StatData(
        actPower = 15,
    ),
    growthStats = StatData(
        actPower = 1708,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11,3),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16,3),
    ),
)

val PrinceAndPrincessEtude = MemoirBlueprint(
    name = "Prince and Princess Etude",
    rarity = 4,
    baseStats = StatData(
        actPower = 15,
    ),
    growthStats = StatData(
        actPower = 1708,
    ),
    baseAutoskills = listOf(
        DexterityPassive.new(11),
        EffectiveDamageDealtPassive.new(8),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(16),
        EffectiveDamageDealtPassive.new(12),
    ),
)

val SunsetLabMemBadge = MemoirBlueprint(
    name = "Sunset Lab Mem Badge",
    rarity = 4,
    baseStats = StatData(
        actPower = 30,
        specialDefense = 50,
    ),
    growthStats = StatData(
        actPower = 3417,
        specialDefense = 5696,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
)

val ReminiscenceMelody = MemoirBlueprint(
    name = "Reminiscence Melody",
    rarity = 4,
    baseStats = StatData(
        actPower = 30,
        specialDefense = 50,
    ),
    growthStats = StatData(
        actPower = 3417,
        specialDefense = 5696,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfCriticalUpBuffPassive.new(21,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8,6),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfCriticalUpBuffPassive.new(30,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12,6),
    ),
)

val KappoTomoyesPosterGirl = MemoirBlueprint(
    name = "Kappo Tomoye's Poster Girl",
    rarity = 4,
    baseStats = StatData(
        hp = 300,
        actPower = 30,
    ),
    growthStats = StatData(
        hp = 34177,
        actPower = 3417,
    ),
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8,6),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16,6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12,6),
    ),
)