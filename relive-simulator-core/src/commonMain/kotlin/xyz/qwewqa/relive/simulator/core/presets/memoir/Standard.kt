package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.RinmeikanOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.memoir.generated.*
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val EmptyMemoir = MemoirBlueprint(
    -1,
    name = "None",
    rarity = 4,
    cost = 0,
    baseStats = StatData(),
    growthStats = StatData(),
    baseAutoskills = listOf(),
    maxAutoskills = listOf(),
)

val ADayInTheGodessesLife = equip4000009(
    name = "A Day in the Goddesses' Life",
    baseAutoskills = listOf(
        EffectiveDamageDealtPassive.new(10),
    ),
    maxAutoskills = listOf(
        EffectiveDamageDealtPassive.new(15),
    ),
)

val TurbulentNinja  = equip4000056(
    name = "Turbulent Ninja",
    baseAutoskills = listOf(
        ClimaxActPowerPassive.new(8),
        EffectiveDamageDealtPassive.new(8),
    ),
    maxAutoskills = listOf(
        ClimaxActPowerPassive.new(12),
        EffectiveDamageDealtPassive.new(12),
    ),
)

val EnjoyingWinter = equip4000026(
    name = "Enjoying Winter",
    baseAutoskills = listOf(
        CriticalUpPassive.new(21),
        PerfectAimPassive.new(),
    ),
    maxAutoskills = listOf(
        CriticalUpPassive.new(30),
        PerfectAimPassive.new(),
    ),
)

val StretchingHelp = equip3000054(
    name = "Stretching Help...?",
    baseAutoskills = listOf(
        EffectiveDamageDealtPassive.new(6),
        PerfectAimPassive.new(),
    ),
    maxAutoskills = listOf(
        EffectiveDamageDealtPassive.new(9),
        PerfectAimPassive.new(),
    ),
)

val ReverberatingVoiceTsubasaMaya = equip4000118(
    name = "Reverberating Voice Tsubasa & Maya",
    baseAutoskills = listOf(
        DexterityPassive.new(11),
        PerfectAimPassive.new(),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(16),
        PerfectAimPassive.new(),
    ),
)

val FriendsAtTheAquarium = equip4000011(
    name = "Friends at the Aquarium",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
)

val ChinatownDelicacies = equip4000111(
    name = "Chinatown Delicacies",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
)

val UrashimaTaroPerformanceFlyer = equip4000075(
    name = "Urashima Taro Performance Flyer",
    baseAutoskills = listOf(
        DamageDealtPassive.new(5),
        DexterityPassive.new(11),
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(8),
        DexterityPassive.new(16),
    ),
)

val CoStarringWithHatsuneMiku = equip4000098(
    name = "Co-starring with Hatsune Miku!",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
)

val FirstAnnivSiegfeldInstituteOfMusic = equip4000087(
    name = "(1st Anniv.) Siegfeld Institute of Music",
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + SiegfeldOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + SiegfeldOnlyCondition
    )
)

val FirstAnnivSeishoMusicAcademy = equip4000086(
    name = "(1st Anniv.) Seisho Music Academy",
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + SeishoOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + SeishoOnlyCondition
    )
)

val FirstAnnivRinmeikanGirlsSchool = equip4000088(
    name = "(1st Anniv.) Rinmeikan Girls School",
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + RinmeikanOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + RinmeikanOnlyCondition
    )
)

val FirstAnnivFrontierSchoolOfArts = equip4000089(
    name = "(1st Anniv.) Frontier School of Arts",
    baseAutoskills = listOf(
        TeamActPowerUpPassive.new(5) + FrontierOnlyCondition
    ),
    maxAutoskills = listOf(
        TeamActPowerUpPassive.new(7) + FrontierOnlyCondition
    )
)

val BandsmansGreeting = equip4000101(
    name = "Bandsman's Greeting",
    baseAutoskills = listOf(
        TeamActPowerUpBuffPassive.new(3, time = 3)
    ),
    maxAutoskills = listOf(
        TeamActPowerUpBuffPassive.new(10, time = 3)
    ),
)

val BlessedDawn = equip4000104(
    name = "Blessed Dawn",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(16),
        TeamDexterityUpBuffPassive.new(5, time = 2)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(24),
        TeamDexterityUpBuffPassive.new(10, time = 2)
    ),
)

val KeepersOfThePeace = equip4000007(
    name = "Keepers of the Peace",
    baseAutoskills = listOf(
        DexterityPassive.new(14),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(20),
    ),
)

val CrazyMadScientist = equip4000123(
    name = "Crazy Mad Scientist",
    baseAutoskills = listOf(
        CriticalUpPassive.new(21),
        DexterityPassive.new(11)
    ),
    maxAutoskills = listOf(
        CriticalUpPassive.new(30),
        DexterityPassive.new(16)
    ),
)

val SunnyLunchtime = equip4000137(
    name = "Sunny Lunchtime",
    baseAutoskills = listOf(
        DamageDealtPassive.new(5),
        DexterityPassive.new(11),
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(8),
        DexterityPassive.new(16),
    ),
)

val ToTheWonderfulWorldOfRakugo = equip4000135(
    name = "To the Wonderful World of Rakugo",
    baseAutoskills = listOf(
        CriticalUpPassive.new(21),
        DexterityPassive.new(11)
    ),
    maxAutoskills = listOf(
        CriticalUpPassive.new(30),
        DexterityPassive.new(16)
    ),
)

val DeuxJunoJuneBride = equip4000059(
    name = "Deux JUNO!? -June Bride-",
    baseAutoskills = listOf(
        CriticalUpPassive.new(21),
        DexterityPassive.new(11)
    ),
    maxAutoskills = listOf(
        CriticalUpPassive.new(30),
        DexterityPassive.new(16)
    ),
)

val ThePhantomAndChristine = equip4000018(
    name = "The Phantom and Christine",
    baseAutoskills = listOf(
        DamageDealtPassive.new(5),
        CriticalUpPassive.new(21),
    ),
    maxAutoskills = listOf(
        DamageDealtPassive.new(8),
        CriticalUpPassive.new(30),
    ),
)

val PoolsideIncident = equip4000077(
    name = "Poolside Incident",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfPerfectAimBuffPassive.new(time = 3),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfPerfectAimBuffPassive.new(time = 3),
    ),
)

val MerryChristmas2019 = equip4000093(
    name = "Merry Christmas 2019",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11, 3),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16, 3),
    ),
)

val CherryBlossomsInTheBento = equip4000050(
    name = "Cherry Blossoms in the Bento",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfAbsorbBuffPassive.new(5, 3),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfAbsorbBuffPassive.new(10, 3),
    ),
)

val PrinceAndPrincessEtude = equip4000097(
    name = "Prince and Princess Etude",
    baseAutoskills = listOf(
        DexterityPassive.new(11),
        EffectiveDamageDealtPassive.new(8),
    ),
    maxAutoskills = listOf(
        DexterityPassive.new(16),
        EffectiveDamageDealtPassive.new(12),
    ),
)

val StarOfTheDay = equip4000155(
    name = "[Star of the day] (This Stage Girl)",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28),
        SelfEvasionBuffPassive.new(time = 1),
        SelfFortitudeBuffPassive.new(time = 1),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40),
        SelfEvasionBuffPassive.new(time = 1),
        SelfFortitudeBuffPassive.new(time = 1),
    ),
)

val WrongStarOfTheDay = equip4000185(
    name = "[Star of the day] (Someone Else)",
    baseAutoskills = listOf(),
    maxAutoskills = listOf(),
)

val SunsetLabMemBadge = equip4000125(
    name = "Sunset Lab Mem Badge",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(28)
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(40)
    ),
)

val ReminiscenceMelody = equip4000129(
    name = "Reminiscence Melody",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfCriticalUpBuffPassive.new(21, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8, 6),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfCriticalUpBuffPassive.new(30, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12, 6),
    ),
)

val KappoTomoyesPosterGirl = equip4000136(
    name = "Kappo Tomoye's Poster Girl",
    baseAutoskills = listOf(
        BrillianceRecoveryPassive.new(22),
        SelfDexterityUpBuffPassive.new(11, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(8, 6),
    ),
    maxAutoskills = listOf(
        BrillianceRecoveryPassive.new(32),
        SelfDexterityUpBuffPassive.new(16, 6),
        SelfEffectiveDamageDealtUpBuffPassive.new(12, 6),
    ),
)

val SparklingStageChika = equip4000107(
    name = "Sparkling Stage Chika",
    baseAutoskills = listOf(
        SelfNormalBarrierBuffPassive.new(4000, 3),
        SelfSpecialBarrierBuffPassive.new(4000, 3),
    ),
    maxAutoskills = listOf(
        SelfNormalBarrierBuffPassive.new(8000, 3),
        SelfSpecialBarrierBuffPassive.new(8000, 3),
    ),
)

val TheGreatYearEndCleanup = equip4000029(
    name = "The Great Year-End Cleanup",
    baseAutoskills = listOf(
        SelfNormalBarrierBuffPassive.new(560, 3),
        SelfEvasionBuffPassive.new(time = 1),
    ),
    maxAutoskills = listOf(
        SelfNormalBarrierBuffPassive.new(2260, 3),
        SelfEvasionBuffPassive.new(time = 1),
    ),
)

val ConfidantsOnADate = equip4000014(
    name = "Confidants on a Date",
    baseAutoskills = listOf(
        SelfEvasionBuffPassive.new(time = 1),
    ),
    maxAutoskills = listOf(
        SelfEvasionBuffPassive.new(time = 2),
    ),
)

val OneForAll = equip4000006(
    name = "One for All",
    baseAutoskills = listOf(
        CriticalUpPassive.new(26),
    ),
    maxAutoskills = listOf(
        CriticalUpPassive.new(37),
    ),
)
