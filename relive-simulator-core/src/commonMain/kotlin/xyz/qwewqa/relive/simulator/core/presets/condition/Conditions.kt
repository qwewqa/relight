package xyz.qwewqa.relive.simulator.core.presets.condition

val conditions by lazy {
    listOf(
        KarenOnlyCondition,
        HikariOnlyCondition,
        MahiruOnlyCondition,
        ClaudineOnlyCondition,
        MayaOnlyCondition,
        JunnaOnlyCondition,
        NanaOnlyCondition,
        FutabaOnlyCondition,
        KaorukoOnlyCondition,
        TamaoOnlyCondition,
        IchieOnlyCondition,
        FumiOnlyCondition,
        RuiOnlyCondition,
        YuyukoOnlyCondition,
        AruruOnlyCondition,
        MisoraOnlyCondition,
        LalafinOnlyCondition,
        TsukasaOnlyCondition,
        ShizuhaOnlyCondition,
        AkiraOnlyCondition,
        MichiruOnlyCondition,
        MeiFanOnlyCondition,
        ShioriOnlyCondition,
        YachiyoOnlyCondition,
        KoharuOnlyCondition,
        SuzuOnlyCondition,
        HisameOnlyCondition,
    ).associateBy { it.name }
}
