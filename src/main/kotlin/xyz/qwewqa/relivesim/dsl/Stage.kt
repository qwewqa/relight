package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.LoggingDamageCalculator
import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.team.Team
import kotlin.random.Random

@StageDslMarker
class StageBuilder {
    var playerTeam: Team? = null
    var enemyTeam: Team? = null
    var damageCalculator = LoggingDamageCalculator()
    var configuration = StageConfiguration()
    var seed = 0

    fun player(init: TeamBuilder.() -> Unit) {
        playerTeam = TeamBuilder().apply(init).build()
    }

    fun enemy(init: TeamBuilder.() -> Unit) {
        enemyTeam = TeamBuilder().apply(init).build()
    }

    fun build() = Stage(
        playerTeam ?: error("No player team."),
        enemyTeam ?: error("No enemy team"),
        damageCalculator,
        configuration,
        Random(seed),
    )
}

fun stage(init: StageBuilder.() -> Unit) = StageBuilder().apply(init).build()
