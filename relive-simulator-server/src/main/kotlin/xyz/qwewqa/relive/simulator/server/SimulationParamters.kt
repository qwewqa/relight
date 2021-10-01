package xyz.qwewqa.relive.simulator.server

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import xyz.qwewqa.relive.simulator.core.presets.condition.conditions
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.presets.dress.playerDresses
import xyz.qwewqa.relive.simulator.core.presets.memoir.memoirs
import xyz.qwewqa.relive.simulator.core.presets.song.songEffects
import xyz.qwewqa.relive.simulator.core.stage.RandomDamageCalculator
import xyz.qwewqa.relive.simulator.core.stage.StageConfiguration
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.condition.or
import xyz.qwewqa.relive.simulator.core.stage.condition.plus
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.TeamLoadout
import xyz.qwewqa.relive.simulator.core.stage.song.Song
import xyz.qwewqa.relive.simulator.core.stage.song.SongEffectData
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers

@Serializable
data class SimulationParameters(
    val maxTurns: Int,
    val maxIterations: Int,
    val team: List<PlayerLoadoutParameters>,
    val guest: PlayerLoadoutParameters?,
    val song: SongParameters,
    val strategy: StrategyParameter,
    val boss: String,
    val eventBonus: Int,
    val seed: Int,
) {
    fun createStageLoadout(): StageLoadout {
        require(maxTurns > 0) { "Max turns should be a positive integer." }
        require(maxIterations > 0) { "Max iterations should be a positive integer" }
        require(team.isNotEmpty()) { "Team should not be empty." }
        require(team.map { it.name }.toSet().size == team.size) { "Team must not have duplicate names." }
        return StageLoadout(
            TeamLoadout(
                team.map {
                    ActorLoadout(
                        it.name,
                        playerDresses[it.dress]!!,
                        memoirs[it.memoir]!!,
                        it.unitSkillLevel,
                    )
                },
                guest?.let {
                    ActorLoadout(
                        it.name,
                        playerDresses[it.dress]!!,
                        memoirs[it.memoir]!!,
                        it.unitSkillLevel,
                    )
                },
                Song(
                    song.activeEffects.map {
                        SongEffectData(
                            songEffects[it.name]!!,
                            it.value,
                            it.conditions.map { group ->
                                group.map { name -> conditions[name]!! }.reduce { acc, condition -> acc or condition }
                            }.fold<NamedCondition?, NamedCondition?>(null) { acc, condition -> acc + condition }
                        )
                    },
                    song.passiveEffect?.let {
                        SongEffectData(
                            songEffects[it.name]!!,
                            it.value,
                            it.conditions.map { group ->
                                group.map { name -> conditions[name]!! }.reduce { acc, condition -> acc or condition }
                            }.fold<NamedCondition?, NamedCondition?>(null) { acc, condition -> acc + condition }
                        )
                    }
                ),
                strategyParsers[strategy.type]!!.parse(strategy.value),
            ),
            TeamLoadout(
                listOf(
                    bossLoadouts[boss]!!.loadout
                ),
                strategy = bossLoadouts[boss]!!.strategy
            ),
            {
                player.actors.values.forEach { it.eventBonus = eventBonus }
            },
            RandomDamageCalculator(),
            if (maxIterations > 1) StageConfiguration(logging = false) else StageConfiguration(logging = true)
        )
    }
}

@Serializable
data class SimulationOptionNames(
    val dresses: List<String>,
    val memoirs: List<String>,
    val songEffects: List<String>,
    val conditions: List<String>,
    val bosses: List<String>,
    val strategyTypes: List<String>,
)

@Serializable
data class SongParameters(
    val activeEffects: List<SongEffectParameter>,
    val passiveEffect: SongEffectParameter?,
)

@Serializable
data class SongEffectParameter(
    val name: String,
    val value: Int,
    val conditions: List<List<String>>,
)

@Serializable
data class PlayerLoadoutParameters(
    val name: String,
    val dress: String,
    val memoir: String,
    val unitSkillLevel: Int,
)

@Serializable
data class StrategyParameter(
    val type: String,
    val value: String,
)

@Serializable
data class SimulationResult(
    val maxIterations: Int,
    val currentIterations: Int,
    val results: List<SimulationResultValue>,
    val log: String?,
    val cancelled: Boolean = false,
    val error: String? = null,
)

@Serializable
data class SimulationResultValue(val result: SimulationResultType, val count: Int)

@Serializable
sealed class SimulationResultType {
    @Serializable
    @SerialName("wipe")
    data class Wipe(val turn: Int) : SimulationResultType()

    @Serializable
    @SerialName("victory")
    data class Victory(val turn: Int) : SimulationResultType()

    @Serializable
    @SerialName("end")
    object End : SimulationResultType()

    @Serializable
    @SerialName("excluded")
    object Excluded : SimulationResultType()

    @Serializable
    @SerialName("error")
    object Error : SimulationResultType()
}

@Serializable
data class SimulateResponse(val token: String)