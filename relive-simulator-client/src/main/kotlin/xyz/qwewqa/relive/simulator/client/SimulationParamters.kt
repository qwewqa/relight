package xyz.qwewqa.relive.simulator.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
)

@Serializable
data class SimulationOptionNames(
    val dresses: List<String>,
    val memoirs: List<String>,
    val songEffects: List<String>,
    val conditions: List<String>,
    val bosses: List<String>,
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
) {
    val done get() = cancelled || currentIterations >= maxIterations
}

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
    data class End(val margin: Int) : SimulationResultType()

    @Serializable
    @SerialName("excluded")
    object Excluded : SimulationResultType()

    @Serializable
    @SerialName("error")
    object Error : SimulationResultType()
}

@Serializable
data class SimulateResponse(val token: String)
