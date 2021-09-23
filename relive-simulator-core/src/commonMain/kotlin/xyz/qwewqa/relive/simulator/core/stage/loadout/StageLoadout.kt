package xyz.qwewqa.relive.simulator.core.stage.loadout

import xyz.qwewqa.relive.simulator.core.stage.DamageCalculator
import xyz.qwewqa.relive.simulator.core.stage.RandomDamageCalculator
import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.StageConfiguration
import kotlin.random.Random

data class StageLoadout(
    val player: TeamLoadout,
    val enemy: TeamLoadout,
    val prerun: Stage.() -> Unit,
    val damageCalculator: DamageCalculator = RandomDamageCalculator(),
    val configuration: StageConfiguration,
) {
    fun create(random: Random = Random.Default) = Stage(
        player.create(),
        enemy.create(),
        damageCalculator,
        configuration,
        random,
    ).also { it.prerun() }
}
