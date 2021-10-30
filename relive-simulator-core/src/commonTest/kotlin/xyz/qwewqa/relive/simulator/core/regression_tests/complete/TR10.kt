package xyz.qwewqa.relive.simulator.core.regression_tests.complete

import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.core.regression_tests.aggregate
import xyz.qwewqa.relive.simulator.core.regression_tests.simulate
import xyz.qwewqa.relive.simulator.core.regression_tests.simulationConfig
import kotlin.test.Test
import kotlin.test.assertEquals

class TR10Tests {
    @Test
    fun devilFoolVsHellsing() {
        assertEquals(
            mapOf(
                SimulationResultType.Victory(3, 5) to 6454,
                SimulationResultType.Victory(3, 6) to 3529,
                SimulationResultType.End to 17,
            ),
            simulationConfig(
                """{"maxIterations":10000,"team":[{"name":"Devil","dress":"Devil Kaoruko","memoir":"Unshakable Feelings","memoirLevel":80,"unitSkillLevel":21},{"name":"Fool","dress":"Fool Yachiyo","memoir":"XVI Tower [Upright]","memoirLevel":80,"unitSkillLevel":21}],"song":{"passiveEffect":{"name":"Against Dream Damage Dealt Up","value":9,"conditions":[["Kaoruko"]]}},"strategy":{"type":"Simple","value":"Turn 1:\nDevil 2\nFool 3\nFool 2\n\nTurn 2:\nFool 3\nDevil 2\nFool 2\nDevil 1\nDevil 3\n\nTurn 3:\nclimax\nFool cutin\nFool 3\nDevil 2\nDevil cx\nDevil 3\nDevil 1"},"boss":"TR10 Hellsing Michiru","seed":576957280}"""
            ).simulate().aggregate()
        )
    }
}