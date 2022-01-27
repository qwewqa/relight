package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.common.*

class RemoteSimulator(val baseUrl: URL) : Simulator {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    isLenient = false
                    ignoreUnknownKeys = false
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
            client.post<SimulateResponse>(URL("/simulate", baseUrl.href).href) {
                contentType(ContentType.Application.Json)
                body = parameters
            }.token
        )
    }

    override suspend fun simulateInteractive(parameters: SimulationParameters): InteractiveSimulation {
        return RemoteInteractiveSimulation(
            this,
            client.post<SimulateResponse>(URL("/simulate_interactive", baseUrl.href).href) {
                contentType(ContentType.Application.Json)
                body = parameters
            }.token
        )
    }

    override suspend fun version(): SimulatorVersion {
        return client.get(URL("/version", baseUrl.href).href)
    }

    override suspend fun options(): SimulationOptions {
        return client.get(URL("/options", baseUrl.href).href)
    }

    override suspend fun features(): SimulatorFeatures {
        return try {
            client.get(URL("/features", baseUrl.href).href)
        } catch (e: Throwable) {
            SimulatorFeatures()
        }
    }

    override suspend fun shutdown() {
        client.get<HttpResponse>(URL("/shutdown", baseUrl.href).href) {
            expectSuccess = false
        }
    }

    inner class RemoteSimulation(val simulator: RemoteSimulator, val token: String) : Simulation {
        override suspend fun pollResult(): SimulationResult {
            return client.get(URL("/result/$token", baseUrl.href).href)
        }

        override suspend fun cancel() {
            client.get<HttpResponse>(URL("/result/$token/cancel", baseUrl.href).href)
        }
    }

    inner class RemoteInteractiveSimulation(val simulator: RemoteSimulator, val token: String) : InteractiveSimulation {
        override suspend fun getLog(): List<FormattedLogEntry> {
            return client.get<InteractiveLog>(URL("/interactive/$token", baseUrl.href).href).contents
        }

        override suspend fun sendCommand(text: String) {
            client.post<String>(URL("/interactive/$token", baseUrl.href).href) {
                contentType(ContentType.Application.Json)
                body = InteractiveCommand(text)
            }
        }

        override suspend fun end() {
            client.get<HttpResponse>(URL("/result/$token/end", baseUrl.href).href)
        }
    }
}
