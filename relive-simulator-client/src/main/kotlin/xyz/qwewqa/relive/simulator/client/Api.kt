package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters

const val BASE_API_URL = "https://api-legacy.relight.qwewqa.xyz"

class RelightApi {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    allowSpecialFloatingPointValues = true
                    useArrayPolymorphism = false
                    encodeDefaults = true
                }
            )
        }
    }

    suspend fun createPresets(presets: List<PlayerLoadoutParameters>): String {
        return client.post<CreatePresetsResponse>("$BASE_API_URL/share/presets/create") {
            contentType(ContentType.Application.Json)
            body = CreatePresetsRequest(presets = presets)
        }.id
    }

    suspend fun getPresets(id: String): List<PlayerLoadoutParameters> {
        return client.get<GetPresetsResponse>("$BASE_API_URL/share/presets/get/$id").presets
    }
}


@Serializable
data class CreatePresetsRequest(
    val name: String? = null,
    val presets: List<PlayerLoadoutParameters>,
)

@Serializable
data class CreatePresetsResponse(
    val id: String,
)


@Serializable
data class GetPresetsResponse(
    val presets: List<PlayerLoadoutParameters>,
)
