package xyz.qwewqa.relive.simulator.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveAutoSkill
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress

@Serializable
data class SimulationParameters(
    val maxTurns: Int = 3,
    val maxIterations: Int = 10000,
    val team: List<PlayerLoadoutParameters>,
    val guest: PlayerLoadoutParameters? = null,
    val song: SongParameters = SongParameters(),
    val strategy: StrategyParameter = StrategyParameter("Simple", ""),
    val bossStrategy: StrategyParameter? = null,
    val boss: String,
    val bossHp: Double? = null,
    val bossAttribute: Attribute? = null,
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
  override fun toString() = "v$version"

  companion object {
    val CURRENT_VERSION = SimulatorVersion(MAVEN_GROUP, VERSION, GIT_SHA, API_VERSION)
  }
}

@Serializable
data class InteractiveLog(
    val data: InteractiveLogData?,
    val queueInfo: InteractiveQueueInfo? = null,
    val rev: Int = -1,
)

@Serializable
data class InteractiveQueueInfo(
    val queueDamageEstimate: Double? = null,
    val perActQueueDamageEstimates: List<Double>? = null,
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
    val dressId: Int,
    val isSupport: Boolean,
    val hp: Double,
    val maxHp: Double,
    val dexterity: Int,
    val brilliance: Int,
    val inClimax: Boolean,
    val damageContribution: Double,
    val displayBuffs: List<DisplayBuffData>,
)

@Serializable
data class DisplayBuffData(
    val iconId: Int,
    val isLocked: Boolean,
    val value: Int,
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
    val teamStageEffects: List<DisplayStageEffectData> = emptyList(),
    val enemyStageEffects: List<DisplayStageEffectData> = emptyList(),
    val canUndo: Boolean = false,
    val canRedo: Boolean = false,
)

@Serializable
data class DisplayStageEffectData(
    val iconId: Int,
    val level: Int,
    val turns: Int,
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

@Serializable data class InteractiveCommand(val text: String)

@Serializable
data class SimulationOptions(
    val locales: Map<String, String>,
    val commonText: List<SimulationOption>,
    val dresses: List<DataSimulationOption<DressData>>,
    val memoirs: List<DataSimulationOption<MemoirData>>,
    val bosses: List<DataSimulationOption<BossData>>,
    val strategyTypes: List<SimulationOption>,
    val bossStrategyTypes: List<SimulationOption>,
    val remakeSkills: List<DataSimulationOption<RemakeSkillData>>,
    val accessories: List<DataSimulationOption<AccessoryData>>,
    val songs: List<DataSimulationOption<SongData>>,
    val awakeningSongs: List<DataSimulationOption<SongAwakeningData>>,
    val songEffects: List<DataSimulationOption<SongEffectData>>,
    val awakeningSongEffects: List<DataSimulationOption<AwakeningSongEffectData>>,
    val passiveSongEffects: List<DataSimulationOption<PassiveSongEffectData>>,
) {
  val commonTextById by lazy { commonText.associateBy { it.id } }
  val dressesById by lazy { dresses.associateBy { it.id } }
  val memoirsById by lazy { memoirs.associateBy { it.id } }
  val bossesById by lazy { bosses.associateBy { it.id } }
  val strategyTypesById by lazy { strategyTypes.associateBy { it.id } }
  val bossStrategyTypesById by lazy { bossStrategyTypes.associateBy { it.id } }
  val remakeSkillsById by lazy { remakeSkills.associateBy { it.id } }
  val accessoriesById by lazy { accessories.associateBy { it.id } }
  val songsById by lazy { songs.associateBy { it.id } }
  val awakeningSongsById by lazy { awakeningSongs.associateBy { it.id } }
  val songEffectsById by lazy { songEffects.associateBy { it.id } }
  val awakeningSongEffectsById by lazy { awakeningSongEffects.associateBy { it.id } }
  val passiveSongEffectsById by lazy { passiveSongEffects.associateBy { it.id } }
}

typealias SimulationOption = DataSimulationOption<Unit>

fun SimulationOption(
    id: String,
    name: Map<String, String>,
    descriptionIcons: List<String>? = null,
    description: Map<String, String>? = null,
    tags: Map<String, List<String>>? = null,
    imagePath: String? = null,
) = DataSimulationOption(id, name, descriptionIcons, description, tags, imagePath, Unit)

@Serializable
data class DataSimulationOption<T>(
    val id: String,
    val name: Map<String, String>,
    val descriptionIcons: List<String>? = null,
    val description: Map<String, String>? = null,
    val tags: Map<String, List<String>>? = null,
    val imagePath: String? = null,
    val data: T,
) {
  operator fun get(key: String): String = name[key] ?: name["en"] ?: name["ja"] ?: id
}

@Serializable
data class BossData(
    val bonusDresses: Map<Int, Int>,
    val bonusCharacters: Map<Character, Int>,
) {
  fun getBonus(dress: DressData): Int =
      bonusDresses[dress.id] ?: bonusCharacters[dress.character] ?: 0
  fun getBonuses(dresses: Iterable<DressData>): Int = dresses.sumOf { getBonus(it) }

  companion object {
    fun fromDress(dress: Dress): BossData {
      val bonusPassive =
          dress.autoSkills
              .mapNotNull { (it as? PassiveAutoSkill)?.effect }
              .filterIsInstance<EventBonusPassive>()
              .singleOrNull()
              ?: return BossData(emptyMap(), emptyMap())
      val bonusDresses = mutableMapOf<Int, Int>()
      val bonusCharacters = mutableMapOf<Character, Int>()
      bonusPassive.categories.forEach { (dresses, value) ->
        dresses.forEach { dressId -> bonusDresses[dressId] = value }
      }
      bonusPassive.characters.forEach { (character, value) -> bonusCharacters[character] = value }
      bonusPassive.dresses.forEach { (dressId, value) -> bonusDresses[dressId] = value }
      return BossData(bonusDresses, bonusCharacters)
    }
  }
}

@Serializable
data class DressData(
    val id: Int,
    val attribute: Int,
    val damageType: Int,
    val positionValue: Int,
    val positionName: String,
    val characterName: String = "",
    val character: Character,
    val releaseTime: Int?,
    val cost: Int,
) : Comparable<DressData> {
  override fun compareTo(other: DressData): Int {
    if (positionValue != other.positionValue) return positionValue - other.positionValue
    if (id != other.id) return other.id - id // Note how this is reversed
    return 0
  }
}

@Serializable
data class MemoirData(
    val id: Int,
    val cost: Int,
    val releaseTime: Int?,
)

@Serializable
data class AccessoryData(
    val id: Int,
    val dressIds: Set<Int>,
    val attributeId: Int?,
    val autoSkillLimitBreak: List<Int>,
) {
  fun compatibleWith(dress: DressData): Boolean {
    return (dressIds.isEmpty() || dressIds.contains(dress.id)) &&
        (attributeId == null || attributeId == dress.attribute)
  }
}

@Serializable
data class RemakeSkillData(
    val value: String?,
    val time: String?,
    val targeting: String,
)

@Serializable data class SimulatorFeatures(val shutdown: Boolean = false)

@Serializable
data class SongParameters(
    val id: String = "0",
    val activeEffect1: SongEffectParameter? = null,
    val activeEffect2: SongEffectParameter? = null,
    val passiveEffect: SongEffectParameter? = null,
    val awakenSkill1Value: Int = 0,
    val awakenSkill2Value: Int = 0,
    val awakenSkill3Value: Int = 0,
    val awakenSkill4Value: Int = 0,
    val awakenExtraSkillSongs: List<String> = emptyList(),
)

@Serializable
data class SongEffectParameter(
    val id: String,
    val value: Int,
)

@Serializable
data class SongData(
    val id: Int,
    val awakenSkill1Id: Int?,
    val awakenSkill2Id: Int?,
    val awakenSkill3Id: Int?,
    val awakenSkill4Id: Int?,
)

@Serializable
data class SongAwakeningData(
    val id: Int,
)

@Serializable
data class SongEffectData(
    val id: Int,
)

@Serializable
data class AwakeningSongEffectData(
    val id: Int,
    val values: Array<Int>,
)

@Serializable
data class PassiveSongEffectData(
    val id: Int,
) {
  val songId
    get() = id / 100
}

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
  val done
    get() = cancelled || complete
}

@Serializable
data class FilterLogRequest(
    val type: SimulationResultType?,
    val minDamage: Double?,
    val maxDamage: Double?,
    val index: Int,
)

@Serializable
data class FilterLogResponse(
    val log: List<LogEntry>?,
    val error: String?,
    val resultCount: Int,
)

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

  @Serializable @SerialName("end") object End : SimulationResultType()

  @Serializable @SerialName("excluded") object Excluded : SimulationResultType()

  @Serializable @SerialName("error") object Error : SimulationResultType()
}

@Serializable
enum class SimulationMarginResultType {
  Wipe,
  End,
}

@Serializable data class SimulateResponse(val token: String)
