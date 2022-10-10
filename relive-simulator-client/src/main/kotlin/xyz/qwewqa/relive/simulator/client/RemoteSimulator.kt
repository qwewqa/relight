package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.common.*

class RemoteSimulator(val baseUrl: URL) : Simulator {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    allowSpecialFloatingPointValues = true
                    useArrayPolymorphism = false
                    encodeDefaults = true
                }
            )
        }
    }

    override suspend fun simulate(parameters: SimulationParameters): Simulation {
        return RemoteSimulation(
                this,
                client.post(URL("/simulate", baseUrl.href).href) {
                    contentType(ContentType.Application.Json)
                    setBody(parameters)
                }.body<SimulateResponse>().token
        )
    }

    override suspend fun simulateInteractive(parameters: SimulationParameters): InteractiveSimulation {
        return RemoteInteractiveSimulation(
                this,
                client.post(URL("/simulate_interactive", baseUrl.href).href) {
                    contentType(ContentType.Application.Json)
                    setBody(parameters)
                }.body<SimulateResponse>().token
        )
    }

    override suspend fun version(): SimulatorVersion {
        return client.get(URL("/version", baseUrl.href).href).body()
    }

    override suspend fun options(): SimulationOptions {
        return client.get(URL("/options", baseUrl.href).href).body()
    }

    override suspend fun features(): SimulatorFeatures {
        return try {
            client.get(URL("/features", baseUrl.href).href).body()
        } catch (e: Throwable) {
            SimulatorFeatures()
        }
    }

    override suspend fun shutdown() {
        client.get(URL("/shutdown", baseUrl.href).href) {
            expectSuccess = false
        }
    }

    inner class RemoteSimulation(val simulator: RemoteSimulator, val token: String) : Simulation {
        override suspend fun pollResult(): SimulationResult {
            return client.get(URL("/result/$token", baseUrl.href).href).body()
        }

        override suspend fun cancel() {
            client.get(URL("/result/$token/cancel", baseUrl.href).href)
        }
    }

    inner class RemoteInteractiveSimulation(val simulator: RemoteSimulator, val token: String) : InteractiveSimulation {
        private var rev = -1

        override suspend fun getLog(): InteractiveLog {
            val log = client.get(URL("/interactive/$token", baseUrl.href).href) {
                parameter("rev", rev)
            }.body<InteractiveLog>()
            rev = log.rev
            return log
        }

        override suspend fun sendCommand(text: String) {
            client.post(URL("/interactive/$token", baseUrl.href).href) {
                contentType(ContentType.Application.Json)
                setBody(InteractiveCommand(text))
            }
        }

        override suspend fun end() {
            client.get(URL("/result/$token/end", baseUrl.href).href)
        }
    }
}
