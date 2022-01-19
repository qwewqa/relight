@file:OptIn(ExperimentalCoroutinesApi::class)

package xyz.qwewqa.relive.simulator.core.regression_tests.complete

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.core.regression_tests.assertSimulationResults
import kotlin.test.Test

class TR10Tests {
    // Config from Mikayla
    @Test
    fun devilFoolVsHellsing() = runTest {
        assertSimulationResults(
            """
                {"maxIterations":10000,"team":[{"name":"Devil","dress":"Devil Kaoruko","memoir":"Unshakable Feelings","memoirLevel":80,"unitSkillLevel":21},{"name":"Fool","dress":"Fool Yachiyo","memoir":"XVI Tower [Upright]","memoirLevel":80,"unitSkillLevel":21}],"song":{"passiveEffect":{"name":"Against Dream Damage Dealt Up","value":9,"conditions":[["Kaoruko"]]}},"strategy":{"type":"Simple","value":"Turn 1:\nDevil 2\nFool 3\nFool 2\n\nTurn 2:\nFool 3\nDevil 2\nFool 2\nDevil 1\nDevil 3\n\nTurn 3:\nclimax\nFool cutin\nFool 3\nDevil 2\nDevil cx\nDevil 3\nDevil 1"},"boss":"TR10 Hellsing Michiru","seed":576957280}
            """.trimIndent(),
            mapOf(
                SimulationResultType.Victory(3, 5) to 6454,
                SimulationResultType.Victory(3, 6) to 3529,
                SimulationResultType.End to 17,
            ),
        )
    }

    // Config from Mikayla
    @Test
    fun devilSGMeiFanVsDracula() = runTest {
        assertSimulationResults(
            """
                {"maxIterations":10000,"team":[{"name":"Devil","dress":"Devil Kaoruko","memoir":"Prince and Princess Etude","memoirLevel":80,"unitSkillLevel":21},{"name":"MF","dress":"Stage Girl Mei Fan","memoir":"Crazy Mad Scientist","memoirLevel":80,"unitSkillLevel":21}],"song":{"passiveEffect":{"name":"Against Dream Damage Dealt Up","value":10,"conditions":[["Siegfeld"]]}},"strategy":{"type":"Simple","value":"Turn 1:\nDevil 2\nMF 2\nMF 3\n\nTurn 2:\nDevil 2\nMF 2\nMF 3\nDevil 3\nMF 1\n\nTurn 3:\nMF 2\nMF 3\nDevil 2\nDevil 3\nMF 1"},"boss":"TR10 Dracula Claudine","seed":1809392959}
            """.trimIndent(),
            mapOf(
                SimulationResultType.Victory(2, 6) to 862,
                SimulationResultType.Victory(3, 1) to 7783,
                SimulationResultType.Victory(3, 2) to 1343,
                SimulationResultType.Victory(3, 3) to 10,
                SimulationResultType.Victory(3, 5) to 1,
                SimulationResultType.Victory(3, 6) to 1,
            ),
        )
    }

    // Config from Mikayla
    @Test
    fun doubleFoolFaith() = runTest {
        assertSimulationResults(
            """
                {"maxIterations":10000,"team":[{"name":"F1","dress":"Fool Yachiyo","memoir":"Stretching Help...?","memoirLevel":70,"unitSkillLevel":21},{"name":"F2","dress":"Fool Yachiyo","memoir":"Poolside Incident","memoirLevel":80,"unitSkillLevel":21}],"song":{"passiveEffect":{"name":"Critical Up","value":25,"conditions":[]}},"strategy":{"type":"Simple","value":"Turn 1:\nF2 3\nF1 3\nF2 2\n\nTurn 2:\nF2 3\nF1 3\nF2 2\nF1 2\nF2 1\n\nTurn 3:\nclimax\nF1 3\nF2 3\nF2 cx\nF2 2\nF1 2"},"boss":"TR10 Faith Misora","seed":210238671}
            """.trimIndent(),
            mapOf(
                SimulationResultType.Victory(3, 3) to 9,
                SimulationResultType.Victory(3, 4) to 7071,
                SimulationResultType.Victory(3, 5) to 2919,
                SimulationResultType.End to 1,
            ),
        )
    }

    // Config from Mikayla
    @Test
    fun aceSGClaudineVsDracula() = runTest {
        assertSimulationResults(
            """
                {"maxIterations":10000,"team":[{"name":"Ace","dress":"Stormy Ace Misora","memoir":"Kappo Tomoye's Poster Girl","memoirLevel":60,"memoirLimitBreak":0,"unitSkillLevel":9},{"name":"Kuro","dress":"Stage Girl Claudine","memoir":"Merry Christmas 2019","memoirLevel":80,"unitSkillLevel":9}],"song":{"activeEffects":[{"name":"Dexterity Up","value":7,"conditions":[]},{"name":"Critical Up","value":25,"conditions":[]}]},"strategy":{"type":"Complete","value":"switch turn {\n\ncase 1:\ntryHold(Ace.act1)\nqueue(Ace.act3)\nqueue(Ace.act2)\nqueue(Kuro.act3)\n\ncase 2:\ntryHold(Ace.act1)\nqueue(Kuro.act1)\nqueue(Ace.act3)\nqueue(Ace.act2)\nqueue(Kuro.act2)\nqueue(Kuro.act3)\n\ncase 3:\ndiscard(Kuro.act1)\nclimax()\ntryQueue(Ace.act3)\nqueue(Kuro.cx)\ntryQueue(Ace.act2)\ntryQueue(Kuro.act2)\ntryQueue(Kuro.act3)\nqueue(Ace.cx)\n\n}"},"boss":"TR10 Dracula Claudine","seed":1733039018}
            """.trimIndent(),
            mapOf(
                SimulationResultType.Victory(3, 5) to 9201,
                SimulationResultType.Victory(3, 6) to 47,
                SimulationResultType.End to 752,
            ),
        )
    }

    // Config from Mikayla
    @Test
    fun hondaFoolVsFaith() = runTest {
        assertSimulationResults(
            """
                {"maxIterations":10000,"team":[{"name":"Honda","dress":"Honda Tadakatsu Futaba","memoir":"Sunset Lab Mem Badge","memoirLevel":80,"unitSkillLevel":3},{"name":"Fool","dress":"Fool Yachiyo","memoir":"Reminiscence Melody","memoirLevel":60,"memoirLimitBreak":0,"unitSkillLevel":19}],"song":{"activeEffects":[{"name":"Dexterity Up","value":5,"conditions":[]},{"name":"Critical Up","value":25,"conditions":[]}]},"strategy":{"type":"Complete","value":"switch turn {\ncase 1:\ntryHold(Honda.act1)\nqueue(Honda.act2)\nqueue(Fool.act3)\nqueue(Fool.act2)\n\ncase 2:\ntryHold(Honda.act1)\nqueue(Honda.act2)\nqueue(Honda.act3)\nqueue(Fool.act3)\nqueue(Fool.act2)\nqueue(Fool.act1)\n\ncase 3:\ndiscard(Fool.act1)\nclimax()\nqueue(Honda.cx)\ntryQueue(Honda.act2)\ntryQueue(Honda.act3)\ntryQueue(Fool.act3)\nqueue(Fool.cx)\ntryQueue(Fool.act2)\n}"},"boss":"TR10 Faith Misora","seed":1295851906}
            """.trimIndent(),
            mapOf(
                SimulationResultType.Victory(3, 5) to 1917,
                SimulationResultType.Victory(3, 6) to 4351,
                SimulationResultType.End to 3732,
            ),
        )
    }
}