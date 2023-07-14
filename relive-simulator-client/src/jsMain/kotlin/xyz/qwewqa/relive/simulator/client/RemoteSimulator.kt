package xyz.qwewqa.relive.simulator.client

import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.common.FilterLogRequest
import xyz.qwewqa.relive.simulator.common.FilterLogResponse
import xyz.qwewqa.relive.simulator.common.InteractiveCommand
import xyz.qwewqa.relive.simulator.common.InteractiveLog
import xyz.qwewqa.relive.simulator.common.SimulateResponse
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResult
import xyz.qwewqa.relive.simulator.common.SimulatorVersion

class RemoteSimulator(val baseUrl: URL) : Simulator {

  override suspend fun simulate(parameters: SimulationParameters): Simulation {
    return RemoteSimulation(
        this,
        json
            .decodeFromString<SimulateResponse>(
                fetch(
                        URL("/simulate", baseUrl.href).href,
                        jsObject {
                          method = "POST"
                          headers = jsObject { this["Content-Type"] = "application/json" }
                          body = json.encodeToString(parameters)
                        })
                    .await()
                    .text()
                    .await())
            .token)
  }

  override suspend fun simulateInteractive(
      parameters: SimulationParameters
  ): InteractiveSimulation {
    return RemoteInteractiveSimulation(
        this,
        json
            .decodeFromString<SimulateResponse>(
                fetch(
                        URL("/simulate_interactive", baseUrl.href).href,
                        jsObject {
                          method = "POST"
                          headers = jsObject { this["Content-Type"] = "application/json" }
                          body = json.encodeToString(parameters)
                        })
                    .await()
                    .text()
                    .await())
            .token)
  }

  override suspend fun version(): SimulatorVersion {
    return json.decodeFromString(fetch(URL("/version", baseUrl.href).href).await().text().await())
  }

  inner class RemoteSimulation(val simulator: RemoteSimulator, val token: String) : Simulation {
    override suspend fun pollResult(): SimulationResult {
      return json.decodeFromString(
          fetch(URL("/result/$token", baseUrl.href).href).await().text().await())
    }

    override suspend fun cancel() {
      fetch(URL("/result/$token/cancel", baseUrl.href).href).await()
    }

    override suspend fun filterLog(request: FilterLogRequest): FilterLogResponse {
      return json.decodeFromString(
          fetch(
                  URL("/result/$token/log", baseUrl.href).href,
                  jsObject {
                    method = "POST"
                    headers = jsObject { this["Content-Type"] = "application/json" }
                    body = json.encodeToString(request)
                  })
              .await()
              .text()
              .await())
    }
  }

  inner class RemoteInteractiveSimulation(val simulator: RemoteSimulator, val token: String) :
      InteractiveSimulation {
    private var rev = -1

    override suspend fun getLog(): InteractiveLog {
      val log: InteractiveLog =
          json.decodeFromString(
              fetch(
                      URL("/interactive/$token?rev=$rev", baseUrl.href).href,
                      jsObject {
                        method = "GET"
                        headers = jsObject { this["Content-Type"] = "application/json" }
                      })
                  .await()
                  .text()
                  .await())
      rev = log.rev
      return log
    }

    override suspend fun sendCommand(text: String) {
      fetch(
              URL("/interactive/$token", baseUrl.href).href,
              jsObject {
                method = "POST"
                headers = jsObject { this["Content-Type"] = "application/json" }
                body = json.encodeToString(InteractiveCommand(text))
              })
          .await()
    }

    override suspend fun end() {
      fetch(URL("/result/$token/end", baseUrl.href).href).await()
    }
  }
}
