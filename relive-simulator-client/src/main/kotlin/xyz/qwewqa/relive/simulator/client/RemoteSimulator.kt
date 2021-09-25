package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.w3c.dom.url.URL

class RemoteSimulator(val baseUrl: URL) : Simulator {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
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

    override suspend fun getOptions(): SimulationOptionNames {
        return client.get(URL("/options", baseUrl.href).href)
    }

    inner class RemoteSimulation(val simulator: RemoteSimulator, val token: String) : Simulation {
        override suspend fun pollResult(): SimulationResult {
            return client.get(URL("/result/$token", baseUrl.href).href)
        }

        override suspend fun cancel() {
            client.get<HttpResponse>(URL("/result/$token/cancel", baseUrl.href).href)
        }
    }
}
