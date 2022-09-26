package xyz.qwewqa.relive.simulator.worker

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.DedicatedWorkerGlobalScope
import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResultType
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
                GlobalScope.promise {
                    Json.encodeToString(requests.map { request ->
                        if (request.log) {
                            val stage = ld.create(
                                random = Random(request.seed),
                                configuration = StageConfiguration(logging = true)
                            )
                            val result = stage.play(turns)
                            IterationResult(
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
                            val result = ld.create(random = Random(request.seed)).play(turns)
                            IterationResult(
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
                self.postMessage(Json.encodeToString(requests.map { request ->
                    if (request.log) {
                        IterationResult(
                            request,
                            SimulationResultType.Error,
                            "Default",
                            error = initializationError,
                        )
                    } else {
                        IterationResult(request, SimulationResultType.Error, "Default")
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
    val groupName: String,
    val tags: List<String> = emptyList(),
    val margin: Int? = 0,
    val damage: Int? = 0,
    val log: List<LogEntry>? = null,
    val error: String? = null,
)
