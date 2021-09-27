package xyz.qwewqa.relive.simulator.core.presets.memoir

val memoirs by lazy {
    listOf(
        FriendsAtTheAquarium,
        UrashimaTaroPerformanceFlyer,
        CoStarringWithHatsuneMiku,
        FirstAnnivSiegfeldInstituteOfMusic,
        FirstAnnivSiegfeldInstituteOfMusicLv1,
        BandsmansGreeting,
        CrazyMadScientist,
    ).associateBy { it.name }
}
