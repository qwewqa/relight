package xyz.qwewqa.relive.simulator.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    val apiVersion: Int = -1,
) {
    override fun toString() = "$version-${hash.take(8)} ($apiVersion)"

    companion object {
        val CURRENT_VERSION = SimulatorVersion(MAVEN_GROUP, VERSION, GIT_SHA, API_VERSION)
    }
}

@Serializable
data class InteractiveLog(val contents: List<LogEntry>?, val rev: Int = -1)

@Serializable
data class InteractiveCommand(val text: String)

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
    val imagePath: String? = null,
) : Map<String, String> by name {
    override fun get(key: String): String = name[key] ?: name["en"] ?: id
}

@Serializable
data class SimulatorFeatures(
    val shutdown: Boolean = false
)

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
        val log: List<LogEntry>?,
        val runtime: Double? = null,
        val cancelled: Boolean = false,
        val error: String? = null,
        val complete: Boolean = false,
) {
    val done get() = cancelled || complete
}

@Serializable
data class LogEntry(
    val turn: Int = 0,
    val tile: Int = 0,
    val move: Int = 0,
    val category: LogCategory = LogCategory.DEFAULT,
    val tags: List<String>,
    val summary: String? = null,
    val content: String,
)

@Serializable
enum class LogCategory {
    DEFAULT,
    EMPHASIS,
    WARNING,
    ERROR,
    DAMAGE,
    HEAL,
    BUFF,
    BRILLIANCE,
    USER,
    COMMAND,
}

@Serializable
data class SimulationResultValue(val tags: List<String>, val result: SimulationResultType, val count: Int)

@Serializable
sealed class SimulationResultType {
    @Serializable
    @SerialName("wipe")
    data class Wipe(val turn: Int, val tile: Int) : SimulationResultType()

    @Serializable
    @SerialName("victory")
    data class Victory(val turn: Int, val tile: Int) : SimulationResultType()

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
enum class SimulationMarginResultType {
    Wipe,
    End,
}

@Serializable
data class SimulateResponse(val token: String)
