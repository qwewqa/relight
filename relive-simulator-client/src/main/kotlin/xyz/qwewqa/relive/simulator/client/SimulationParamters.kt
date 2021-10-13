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
data class SimulatorVersion(
    val version: String,
    val revision: Int,
    val hash: String,
) {
    override fun toString() = "$version ($revision-${hash.take(8)})"
}

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
    val runtime: Double? = null,
    val cancelled: Boolean = false,
    val error: String?,
) {
    val done get() = cancelled || currentIterations >= maxIterations
}

@Serializable
data class SimulationResultValue(val result: SimulationResultType, val count: Int)

@Serializable
sealed class SimulationResultType : Comparable<SimulationResultType> {
    abstract val order: Int
    abstract val color: String
    open val headingName: String get() = toString()
    override fun compareTo(other: SimulationResultType) = order.compareTo(other.order)

    @Serializable
    @SerialName("wipe")
    data class Wipe(val turn: Int, val tile: Int) : SimulationResultType() {
        override val order = 2
        override val color = "fuchsia"
        override fun compareTo(other: SimulationResultType) = if (other is Wipe) {
            compareValuesBy(this, other, { it.turn }, { it.tile })
        } else super.compareTo(other)

        override val headingName = "Wipe"
        override fun toString() = "Wipe (t$turn.$tile)"
    }

    @Serializable
    @SerialName("victory")
    data class Victory(val turn: Int, val tile: Int) : SimulationResultType() {
        override val order = 0
        override val color = "lime"
        override fun compareTo(other: SimulationResultType) = if (other is Victory) {
            compareValuesBy(this, other, { it.turn }, { it.tile })
        } else super.compareTo(other)

        override val headingName = "Victory"
        override fun toString() = "Victory (t$turn.$tile)"
    }

    @Serializable
    @SerialName("end")
    object End : SimulationResultType() {
        override val order = 1
        override val color = "crimson"
        override fun toString() = "End"
    }

    @Serializable
    @SerialName("excluded")
    object Excluded : SimulationResultType() {
        override val order = 4
        override val color = "gray"
        override fun toString() = "Excluded"
    }

    @Serializable
    @SerialName("error")
    object Error : SimulationResultType() {
        override val order = 3
        override val color = "yellow"
        override fun toString() = "Error"
    }
}

@Serializable
data class SimulateResponse(val token: String)
