package xyz.qwewqa.relive.simulator.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class SimulationParameters(
    val maxTurns: Int = 3,
    val maxIterations: Int = 100000,
    val team: List<PlayerLoadoutParameters>,
    val guest: PlayerLoadoutParameters? = null,
    val song: SongParameters = SongParameters(),
    val strategy: StrategyParameter = StrategyParameter("Simple", ""),
    val bossStrategy: StrategyParameter? = null,
    val boss: String,
    val bossHp: Int? = null,
    val additionalEventBonus: Int = 0,
    val eventMultiplier: Int = 100,
    val seed: Int = 0,
)

@Serializable
data class SimulatorVersion(
    val name: String = "unknown",
    val version: String,
    val hash: String,
) {
    override fun toString() = "$version (${hash.take(8)})"
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
    val bossStrategyTypes: List<SimulationOption>,
)

@Serializable
data class SimulationOption(
    val id: String,
    val name: Map<String, String>,
    val description: Map<String, String>? = null,
    val tags: Map<String, List<String>>? = null,
) : Map<String, String> by name {
    override fun get(key: String): String = name[key] ?: name["en"] ?: id
}

@Serializable
data class SimulatorFeatures(
    val shutdown: Boolean,
) {
    companion object {
        val MINIMAL = SimulatorFeatures(
            shutdown = false,
        )
    }
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
    val level: Int = 80,
    val rarity: Int = 6,
    val friendship: Int = 30,
    val rank: Int = 9,
    val rankPanelPattern: List<Boolean> = listOf(true, true, true, true, true, true, true, true),
    val remake: Int = 0,
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
    val marginResults: Map<SimulationMarginResultType, Map<Int, Int>>,
    val log: String?,
    val runtime: Double? = null,
    val cancelled: Boolean = false,
    val error: String? = null,
    val complete: Boolean = false,
) {
    val done get() = cancelled || complete
}

@Serializable
data class SimulationResultValue(
    val tags: List<String>,
    val result: SimulationResultType,
    val count: Int,
) : Comparable<SimulationResultValue> {
    val totalTags = tags + result.tags

    override fun compareTo(other: SimulationResultValue): Int = sequence {
        tags.zip(other.tags).forEach { (a, b) ->
            yield(a.compareTo(b))
        }
        yield(-tags.size.compareTo(other.tags.size))
    }.firstOrNull { it != 0 } ?: result.compareTo(other.result)
}

@Serializable
sealed class SimulationResultType : Comparable<SimulationResultType> {
    abstract val order: Int
    abstract val color: String
    open val tags: List<String> get() = listOf(toString())
    override fun compareTo(other: SimulationResultType) = order.compareTo(other.order)

    @Serializable
    @SerialName("wipe")
    data class Wipe(val turn: Int, val tile: Int) : SimulationResultType() {
        override val order = 2
        override val color = "DarkMagenta"
        override fun compareTo(other: SimulationResultType) = if (other is Wipe) {
            compareValuesBy(this, other, { it.turn }, { it.tile })
        } else super.compareTo(other)

        override val tags = listOf("Wipe", "t$turn.$tile")
        override fun toString() = "Wipe (t$turn.$tile)"
    }

    @Serializable
    @SerialName("victory")
    data class Victory(val turn: Int, val tile: Int) : SimulationResultType() {
        override val order = 0
        override val color = "Green"
        override fun compareTo(other: SimulationResultType) = if (other is Victory) {
            compareValuesBy(this, other, { it.turn }, { it.tile })
        } else super.compareTo(other)

        override val tags = listOf("Victory", "t$turn.$tile")
        override fun toString() = "Victory (t$turn.$tile)"
    }

    @Serializable
    @SerialName("end")
    object End : SimulationResultType() {
        override val order = 1
        override val color = "FireBrick"
        override fun toString() = "End"
    }

    @Serializable
    @SerialName("excluded")
    object Excluded : SimulationResultType() {
        override val order = 4
        override val color = "Gray"
        override fun toString() = "Excluded"
    }

    @Serializable
    @SerialName("error")
    object Error : SimulationResultType() {
        override val order = 3
        override val color = "Orange"
        override fun toString() = "Error"
    }
}

@Serializable
enum class SimulationMarginResultType(val color: String = "Black") {
    Wipe("DarkMagenta"),
    End("FireBrick"),
}

@Serializable
data class SimulateResponse(val token: String)
