package xyz.qwewqa.relive.simulator.worker

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import org.w3c.dom.DedicatedWorkerGlobalScope
import xyz.qwewqa.relive.simulator.common.*
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import kotlin.random.Random

external val self: DedicatedWorkerGlobalScope

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    var initialized = false
    var turns = 0
    var loadout: StageLoadout? = null
    var initializationError: String? = null
    var parameters: SimulationParameters? = null
    self.onmessage = { ev ->
        if (!initialized) {
            try {
                val rawParameters: RawSimulationParameters = JSON.parse(ev.data as String)
                parameters = rawParameters.parse()
                loadout = parameters!!.createStageLoadout()
                turns = parameters!!.maxTurns
            } catch (e: Exception) {
                initializationError = e.stackTraceToString()
            }
            initialized = true
        } else {
            val requests: Array<IterationRequest> = JSON.parse(ev.data as String)
            val ld = loadout
            if (ld != null) {
                GlobalScope.promise {
                    JSON.stringify(requests.amap { request ->
                        if (request.log) {
                            val stage = ld.create(
                                random = Random(request.seed),
                                configuration = StageConfiguration(logging = true)
                            )
                            val result = stage.play(PlayInfo(turns, request.index, parameters!!.maxIterations))
                            iterationResult(
                                request,
                                result.toSimulationResult(),
                                result.metadata.groupName,
                                result.metadata.tags,
                                (result as? MarginStageResult)?.margin,
                                (result as? MarginStageResult)?.damage,
                                error = (result as? PlayError)?.exception?.stackTraceToString(),
                                log = stage.logger.get(),
                            )
                        } else {
                            val result = ld.create(random = Random(request.seed))
                                .play(PlayInfo(turns, request.index, parameters!!.maxIterations))
                            iterationResult(
                                request,
                                result.toSimulationResult(),
                                result.metadata.groupName,
                                result.metadata.tags,
                                (result as? MarginStageResult)?.margin,
                                (result as? MarginStageResult)?.damage,
                            )
                        }
                    })
                }.then(self::postMessage)
            } else {
                self.postMessage(JSON.stringify(requests.amap { request ->
                    if (request.log) {
                        iterationResult(
                            request,
                            SimulationResultType.Error,
                            "Default",
                            error = initializationError,
                        )
                    } else {
                        iterationResult(request, SimulationResultType.Error, "Default")
                    }
                }))
            }
        }
    }
}

fun jsObject(init: dynamic.() -> Unit): dynamic {
    val obj = js("{}")
    init(obj)
    return obj
}

inline fun <T, reified R : Any> Array<T>.amap(transform: (T) -> R): Array<R> {
    val result = arrayOfNulls<R>(size)
    forEachIndexed { index, v ->
        result[index] = transform(v)
    }
    @Suppress("UNCHECKED_CAST")
    return result as Array<R>
}
inline fun <T, reified R : Any> Collection<T>.amap(transform: (T) -> R): Array<R> {
    val result = arrayOfNulls<R>(size)
    forEachIndexed { index, v ->
        result[index] = transform(v)
    }
    @Suppress("UNCHECKED_CAST")
    return result as Array<R>
}

external class IterationRequest {
    val index: Int
    val seed: Int
    val log: Boolean
}

external class RawSimulationParameters {
    val maxTurns: Int
    val maxIterations: Int
    val team: Array<RawPlayerLoadoutParameters>
    val guest: RawPlayerLoadoutParameters?
    val song: RawSongParameters
    val strategy: RawStrategyParameter
    val bossStrategy: RawStrategyParameter?
    val boss: String
    val bossHp: Int?
    val additionalEventBonus: Int
    val eventMultiplier: Int
    val seed: Int
}

external class RawSongEffectParameter {
    val name: String
    val value: Int
    val conditions: Array<Array<String>>
}

external class RawSongParameters {
    val activeEffects: Array<RawSongEffectParameter>?
    val passiveEffect: RawSongEffectParameter?
}

external class RawStrategyParameter {
    val type: String
    val value: String
}

external class RawPlayerLoadoutParameters {
    val name: String
    val dress: String
    val memoir: String
    val memoirLevel: Int
    val memoirLimitBreak: Int
    val unitSkillLevel: Int
    val level: Int
    val rarity: Int
    val friendship: Int
    val rank: Int
    val rankPanelPattern: Array<Boolean>
    val remake: Int
    val remakeSkill: String?
    val accessory: String?
    val accessoryLevel: Int
    val accessoryLimitBreak: Int
}

fun RawSongEffectParameter.parse() = SongEffectParameter(
    name = name,
    value = value,
    conditions = conditions.map { it.toList() },
)

fun RawSongParameters.parse() = SongParameters(
    activeEffects = activeEffects?.map { it.parse() } ?: emptyList(),
    passiveEffect = passiveEffect?.parse(),
)

fun RawStrategyParameter.parse() = StrategyParameter(
    type = type,
    value = value,
)

fun RawPlayerLoadoutParameters.parse() = PlayerLoadoutParameters(
    name = name,
    dress = dress,
    memoir = memoir,
    memoirLevel = memoirLevel,
    memoirLimitBreak = memoirLimitBreak,
    unitSkillLevel = unitSkillLevel,
    level = level,
    rarity = rarity,
    friendship = friendship,
    rank = rank,
    rankPanelPattern = rankPanelPattern.toList(),
    remake = remake,
    remakeSkill = remakeSkill,
    accessory = accessory,
    accessoryLevel = accessoryLevel,
    accessoryLimitBreak = accessoryLimitBreak,
)

fun RawSimulationParameters.parse() = SimulationParameters(
    maxTurns = maxTurns,
    maxIterations = maxIterations,
    team = team.map { it.parse() },
    guest = guest?.parse(),
    song = song.parse(),
    strategy = strategy.parse(),
    bossStrategy = bossStrategy?.parse(),
    boss = boss,
    bossHp = bossHp,
    additionalEventBonus = additionalEventBonus,
    eventMultiplier = eventMultiplier,
    seed = seed,
)

fun iterationResult(
    request: IterationRequest,
    result: SimulationResultType,
    groupName: String,
    tags: List<String> = emptyList(),
    margin: Int? = 0,
    damage: Int? = 0,
    log: List<LogEntry>? = null,
    error: String? = null,
) = jsObject {
    this.request = jsObject {
        this.index = request.index
        this.seed = request.seed
        this.log = request.log
    }
    this.result = when (result) {
        is SimulationResultType.Wipe -> jsObject {
            this.type = "wipe"
            this.turn = result.turn
            this.tile = result.tile
        }
        is SimulationResultType.Victory -> jsObject {
            this.type = "victory"
            this.turn = result.turn
            this.tile = result.tile
        }
        SimulationResultType.End -> jsObject {
            this.type = "end"
        }
        SimulationResultType.Error -> jsObject {
            this.type = "error"
        }
        SimulationResultType.Excluded -> jsObject {
            this.type = "excluded"
        }
    }
    this.groupName = groupName
    this.tags = tags.toTypedArray()
    this.margin = margin
    this.damage = damage
    this.log = log?.amap { logEntry ->
        jsObject {
            this.turn = logEntry.turn
            this.tile = logEntry.tile
            this.move = logEntry.move
            this.category = logEntry.category.name
            this.tags = logEntry.tags.toTypedArray()
            this.summary = logEntry.summary
            this.content = logEntry.content
        } as Any
    }
    this.error = error
} as Any
