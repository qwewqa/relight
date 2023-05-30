package xyz.qwewqa.relive.simulator.client

import kotlinx.coroutines.await
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.fetch.Response
import xyz.qwewqa.relive.simulator.common.SimulationOptions
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import kotlin.js.Promise

const val BASE_API_URL = "https://api.relight.qwewqa.xyz"

class RelightApi(val simulator: SimulatorClient) {
  val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
    allowSpecialFloatingPointValues = true
    useArrayPolymorphism = false
    encodeDefaults = true
  }

  suspend fun shareSetup(parameters: SimulationParameters, options: SimulationOptions): String {
    val image = TeamImage(parameters, options).drawOpenGraphImage()
    val teamImage = TeamImage(parameters, options).drawTeamImage()
    val teamImageAlt = TeamImage(parameters, options).drawTeamImageAlt()
    return json
        .decodeFromString<CreateSetupResponse>(
            fetch(
                    "$BASE_API_URL/share/setup/create",
                    jsObject {
                      method = "POST"
                      headers = jsObject { this["Content-Type"] = "application/json" }
                      body =
                          json.encodeToString(
                              CreateSetupRequest(
                                  parameters = parameters,
                                  preview_image = image.base64(),
                                  preview_width = image.width,
                                  preview_height = image.height,
                                  team_image = teamImage.base64(),
                                  team_image_alt = teamImageAlt.base64(),
                                  content_type = base64ImageContentType))
                    })
                .await()
                .text()
                .await())
        .url
  }

  suspend fun getSetup(id: String): SimulationParameters {
    return json
        .decodeFromString<GetSetupResponse>(
            fetch("$BASE_API_URL/share/setup/get/$id").await().text().await())
        .parameters
  }
}

external fun fetch(input: String, init: dynamic = definedExternally): Promise<Response>

@Serializable
data class CreateSetupRequest(
    val parameters: SimulationParameters,
    val preview_image: String,
    val preview_width: Int,
    val preview_height: Int,
    val team_image: String,
    val team_image_alt: String,
    val content_type: String,
)

@Serializable
data class CreateSetupResponse(
    val id: String,
    val url: String,
)

@Serializable
data class GetSetupResponse(
    val parameters: SimulationParameters,
)
