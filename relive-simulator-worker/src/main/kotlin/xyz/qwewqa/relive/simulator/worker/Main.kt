package xyz.qwewqa.relive.simulator.worker

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.DedicatedWorkerGlobalScope
import org.w3c.dom.MessageEvent
import xyz.qwewqa.relive.simulator.common.SimulationMarginResultType
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import kotlin.random.Random

external val self: DedicatedWorkerGlobalScope

fun main() {
    var initialized = false
    var turns = 0
    var loadout: StageLoadout? = null
    var initializationError: String? = null
    self.onmessage = { ev ->
        if (!initialized) {
            try {
                val parameters: SimulationParameters = Json.decodeFromString(ev.data as String)
                loadout = parameters.createStageLoadout()
                turns = parameters.maxTurns
            } catch (e: Exception) {
                initializationError = e.stackTraceToString()
            }
            initialized = true
        } else {
            val requests: List<IterationRequest> = Json.decodeFromString(ev.data as String)
            val ld = loadout
            if (ld != null) {
                self.postMessage(Json.encodeToString(requests.map { request ->
                    if (request.log) {
                        val stage = ld.create(
                            random = Random(request.seed),
                            configuration = StageConfiguration(logging = true)
                        )
                        val result = stage.play(turns)
                        IterationResult(
                            request,
                            result.toSimulationResult(),
                            result.tags,
                            (result as? MarginStageResult)?.margin,
                            error = (result as? PlayError)?.exception?.stackTraceToString(),
                            log = stage.logger.toString(),
                        )
                    } else {
                        val result = ld.create(random = Random(request.seed)).play(turns)
                        IterationResult(
                            request,
                            result.toSimulationResult(),
                            result.tags,
                            (result as? MarginStageResult)?.margin,
                        )
                    }
                }))
            } else {
                self.postMessage(Json.encodeToString(requests.map { request ->
                    if (request.log) {
                        IterationResult(
                            request,
                            SimulationResultType.Error,
                            error = initializationError,
                        )
                    } else {
                        IterationResult(request, SimulationResultType.Error)
                    }
                }))
            }
        }
    }
}

@Serializable
data class IterationRequest(
    val index: Int,
    val seed: Int,
    val log: Boolean = false,
)

@Serializable
data class IterationResult(
    val request: IterationRequest,
    val result: SimulationResultType,
    val tags: List<String> = emptyList(),
    val margin: Int? = 0,
    val log: String? = null,
    val error: String? = null,
)

fun StageResult.toSimulationResult() = when (this) {
    is ExcludedRun -> SimulationResultType.Excluded
    is OutOfTurns -> SimulationResultType.End
    is PlayError -> SimulationResultType.Error
    is TeamWipe -> SimulationResultType.Wipe(turn, tile)
    is Victory -> SimulationResultType.Victory(turn, tile)
}
