package xyz.qwewqa.relive.simulator.core.presets.memoir

val memoirs = listOf(
    UnshakableFeelings,
    FriendsAtTheAquarium,
    UrashimaTaroPerformanceFlyer,
    CoStarringWithHatsuneMiku,
    FirstAnnivSiegfeldInstituteOfMusic,
    FirstAnnivSiegfeldInstituteOfMusicLv1,
    BandsmansGreeting,
    CrazyMadScientist,
    ThePhantomAndChristine,
).sortedBy { it.name }.sortedBy { it.cutinData == null }.associateBy { it.name }
