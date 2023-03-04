package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.FilterLogRequest
import xyz.qwewqa.relive.simulator.common.FilterLogResponse
import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import kotlin.random.Random

class LogFilter(
    private val loadout: StageLoadout,
    private val maxTurns: Int,
    private val maxIterations: Int,
    entries: List<ResultEntry>,
) {
  private val entries = entries.sortedBy { it.index }
  private val entriesByType = this.entries.groupBy { it.type }

  fun get(request: FilterLogRequest): FilterLogResponse {
    var results =
        if (request.type != null) {
          entriesByType[request.type] ?: emptyList()
        } else {
          entries
        }
    if ((request.type == SimulationResultType.End ||
        request.type is SimulationResultType.Wipe ||
        request.type == null) && (request.minDamage != null || request.maxDamage != null)) {
      results =
          results.filter {
            val damage =
                when (it.type) {
                  is SimulationResultType.Wipe -> it.damage
                  is SimulationResultType.End -> it.damage
                  is SimulationResultType.Victory -> loadout.enemy.actors.first().dress.stats.hp
                  else -> null
                }
            damage != null &&
                (request.minDamage == null || damage >= request.minDamage!!) &&
                (request.maxDamage == null || damage <= request.maxDamage!!)
          }
    }
    return if (request.index in results.indices) {
      val result = results[request.index]
      val stage = loadout.create(Random(result.seed), StageConfiguration(logging = true))
      val stageResult = stage.play(PlayInfo(maxTurns, result.index, maxIterations))
      val headerEntry =
          LogEntry(
              tags = listOf("Info"),
              content =
                  "Iteration ${result.index + 1}, Result ${request.index + 1}/${results.size}, ${
                    when (result.type) {
                        is SimulationResultType.Wipe -> "Wipe (t${result.type.turn}.${result.type.tile})"
                        is SimulationResultType.Victory -> "Victory (t${result.type.turn}.${result.type.tile})"
                        SimulationResultType.End -> "End"
                        SimulationResultType.Excluded -> "Excluded"
                        SimulationResultType.Error -> "Error"
                    }
                } ${result.damage?.let { "($it damage)" } ?: ""}",
          )
      FilterLogResponse(
          listOf(headerEntry) + stage.logger.get(),
          (stageResult as? PlayError)?.exception?.stackTraceToString(),
          results.size,
      )
    } else {
      if (results.isEmpty()) {
        FilterLogResponse(
            null,
            "No results found.",
            0,
        )
      } else {
        FilterLogResponse(
            null,
            "Invalid result index. ${results.size} results found.",
            results.size,
        )
      }
    }
  }
}

data class ResultEntry(
    val index: Int,
    val seed: Int,
    val type: SimulationResultType,
    val damage: Int?,
)
