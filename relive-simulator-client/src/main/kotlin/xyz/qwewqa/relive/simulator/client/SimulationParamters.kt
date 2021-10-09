package xyz.qwewqa.relive.simulator.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimulationParameters(
    val maxTurns: Int = 3,
    val maxIterations: Int = 1000000,
    val team: List<PlayerLoadoutParameters>,
    val guest: PlayerLoadoutParameters? = null,
    val song: SongParameters = SongParameters(),
    val strategy: StrategyParameter = StrategyParameter("Simple", ""),
    val boss: String,
    val eventBonus: Int,
    val seed: Int = 0,
)

@Serializable
data class SimulationOptions(
    val locales: Map<String, String>,
    val commonText: List<SimulationOption>,
    val dresses: List<SimulationOption>,
    val memoirs: List<SimulationOption>,
    val songEffects: List<SimulationOption>,
    val conditions: List<SimulationOption>,
    val bosses: List<SimulationOption>,
    val strategyTypes: List<SimulationOption>,
)

@Serializable
data class SimulationOption(
    val id: String,
    val name: Map<String, String>,
) : Map<String, String> by name {
    override fun get(key: String): String = name[key] ?: name["en"] ?: id
}

@Serializable
data class SongParameters(
    val activeEffects: List<SongEffectParameter> = emptyList(),
    val passiveEffect: SongEffectParameter? = null,
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
    val memoirLevel: Int = 1,
    val memoirLimitBreak: Int = 4,
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
    val error: String?,
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
    object End : SimulationResultType() {
        override fun toString() = "End"
    }

    @Serializable
    @SerialName("excluded")
    object Excluded : SimulationResultType() {
        override fun toString() = "Excluded"
    }

    @Serializable
    @SerialName("error")
    object Error : SimulationResultType() {
        override fun toString() = "Error"
    }
}

@Serializable
data class SimulateResponse(val token: String)
