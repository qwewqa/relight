package xyz.qwewqa.relive.simulator.core.presets.accessory

val accessories =
    listOf(
            emptyAccessory,
            beachVolleyball,
            goldBarsOfFrontier,
            memorablePotpourri,
            seishoBdayAcc,
            flowerRing,
            flowerPendant,
            flowerBrooch,
            windRing,
            windPendant,
            windBrooch,
            snowRing,
            snowPendant,
            snowBrooch,
            moonRing,
            moonPendant,
            moonBrooch,
            spaceRing,
            spacePendant,
            spaceBrooch,
            cloudRing,
            cloudPendant,
            cloudBrooch,
            dreamRing,
            dreamPendant,
            dreamBrooch,
            sunRing,
            sunPendant,
            sunBrooch,
            starRing,
            starPendant,
            starBrooch,
        )
        .sortedBy { it.id }
        .associateBy { it.name }
