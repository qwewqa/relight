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
data class InteractiveLog(
    val data: InteractiveLogData?,
    val rev: Int = -1,
)

@Serializable
data class InteractiveLogData(
    val entries: List<LogEntry>,
    val error: String? = null,
    val queueStatus: InteractiveQueueStatus? = null,
    val enemyStatus: List<ActorStatus>? = null,
    val playerStatus: List<ActorStatus>? = null,
)

@Serializable
data class ActorStatus(
    val name: String,
    val hp: Int,
    val maxHp: Int,
    val brilliance: Int,
    val damageContribution: Int,
)

@Serializable
data class InteractiveQueueStatus(
    val turn: Int,
    val tile: Int,
    val maxTurns: Int,
    val queue: List<ActCardStatus>,
    val hand: List<ActCardStatus>,
    val hold: ActCardStatus?,
    val cutins: List<CutinCardStatus>,
    val cutinCostUsed: Int,
    val cutinCostMax: Int,
    val holdAction: Boolean,
    val climaxTurns: Int,
    val canClimax: Boolean,
    val lastExport: String?,
    val runState: InteractiveRunState,
)

@Serializable
enum class InteractiveRunState {
    SETUP,
    QUEUE,
    RUN,
    FINISHED,
}

@Serializable
data class ActCardStatus(
    val dressId: Int,
    val iconId: Int,
    val cost: Int,
    val baseCost: Int,
    val isClimax: Boolean,
    val isSupport: Boolean,
    val status: ActionStatus,
    val handIndex: Int,
)

@Serializable
data class CutinCardStatus(
    val actorName: String,
    val dressId: Int,
    val memoirId: Int,
    val cost: Int,
    val remainingColdown: Int,
    val useCount: Int,
    val maxUses: Int,
    val status: ActionStatus,
    val isSupport: Boolean,
)

enum class ActionStatus {
    READY,
    QUEUED,
    TOO_EXPENSIVE,
    SEALED,
    COOLDOWN,
    NO_MORE_USES,
    HOLDER_EXITED,
    HELD,
}

@Serializable
data class InteractiveCommand(val text: String)

@Serializable
data class SimulationOptions(
    val locales: Map<String, String>,
    val commonText: List<SimulationOption>,
    val dresses: List<DataSimulationOption<DressData>>,
    val memoirs: List<DataSimulationOption<MemoirData>>,
    val songEffects: List<SimulationOption>,
    val conditions: List<SimulationOption>,
    val bosses: List<SimulationOption>,
    val strategyTypes: List<SimulationOption>,
    val bossStrategyTypes: List<SimulationOption>,
    val remakeSkills: List<DataSimulationOption<RemakeSkillData>>,
    val accessories: List<DataSimulationOption<AccessoryData>>,
)  {
    val commonTextById by lazy { commonText.associateBy { it.id } }
    val dressesById by lazy { dresses.associateBy { it.id } }
    val memoirsById by lazy { memoirs.associateBy { it.id } }
    val songEffectsById by lazy { songEffects.associateBy { it.id } }
    val conditionsById by lazy { conditions.associateBy { it.id } }
    val bossesById by lazy { bosses.associateBy { it.id } }
    val strategyTypesById by lazy { strategyTypes.associateBy { it.id } }
    val bossStrategyTypesById by lazy { bossStrategyTypes.associateBy { it.id } }
    val remakeSkillsById by lazy { remakeSkills.associateBy { it.id } }
    val accessoriesById by lazy { accessories.associateBy { it.id } }
}

typealias SimulationOption = DataSimulationOption<Unit>

fun SimulationOption(
    id: String,
    name: Map<String, String>,
    description: Map<String, String>? = null,
    tags: Map<String, List<String>>? = null,
    imagePath: String? = null,
) = DataSimulationOption(id, name, description, tags, imagePath, Unit)

@Serializable
data class DataSimulationOption<T>(
    val id: String,
    val name: Map<String, String>,
    val description: Map<String, String>? = null,
    val tags: Map<String, List<String>>? = null,
    val imagePath: String? = null,
    val data: T,
) {
    operator fun get(key: String): String = name[key] ?: name["en"] ?: id
}


@Serializable
data class DressData(
    val id: Int,
    val attribute: Int,
    val damageType: Int,
    val positionValue: Int,
    val positionName: String,
    val characterName: String = "",
    val cost: Int,
) : Comparable<DressData> {
    override fun compareTo(other: DressData): Int {
        if (positionValue != other.positionValue) return positionValue - other.positionValue
        if (id != other.id) return other.id - id  // Note how this is reversed
        return 0
    }
}

@Serializable
data class MemoirData(
    val id: Int,
    val cost: Int,
)

@Serializable
data class AccessoryData(
    val id: Int,
    val dressIds: Set<Int>,
)

@Serializable
data class RemakeSkillData(
    val value: String?,
    val time: String?,
    val targeting: String,
)

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
    val remakeSkill: String? = null,
    val accessory: String? = null,
    val accessoryLevel: Int = 100,
    val accessoryLimitBreak: Int = 10,
    val isSupport: Boolean = false,
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
    val marginResults: Map<SimulationMarginResultType, Map<String?, MarginResult>>,
    val log: List<LogEntry>?,
    val runtime: Double? = null,
    val cancelled: Boolean = false,
    val error: String? = null,
    val complete: Boolean = false,
) {
    val done get() = cancelled || complete
}

@Serializable
data class MarginResult(
    val damage: Map<Double, Double>,
    val damageSummary: StatisticsSummary?,
    val margin: Map<Double, Double>,
    val marginSummary: StatisticsSummary?,
)

@Serializable
data class StatisticsSummary(
    val mean: Double,
    val stdDev: Double,
    val min: Double,
    val q1: Double,
    val median: Double,
    val q3: Double,
    val max: Double,
)

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
data class SimulationResultValue(
    val tags: List<String>,
    val result: SimulationResultType,
    val count: Int,
)

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
