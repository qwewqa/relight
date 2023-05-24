package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.browser.localStorage
import kotlinx.coroutines.await
import kotlinx.dom.addClass
import kotlinx.dom.removeClass
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.get
import org.w3c.dom.set
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters
import xyz.qwewqa.relive.simulator.common.SimulationOptions
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import kotlin.js.Date

const val BASE_API_URL = "https://api.relight.qwewqa.xyz"

class RelightApi(val simulator: SimulatorClient) {
  private val client = HttpClient {
    install(ContentNegotiation) {
      json(
          Json {
            isLenient = true
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
            useArrayPolymorphism = false
            encodeDefaults = true
          })
    }
  }

  var auth0Client: Auth0Client? = null

  suspend fun getToken(): String? =
      auth0Client?.let { auth0 ->
        try {
          auth0.getTokenSilently().await()
        } catch (e: Throwable) {
          if (e.asDynamic().error == "login_required") {
            simulator.toast("Log In", "Log in required.", "red")
            simulator.logoutButton.addClass("d-none")
            simulator.loginButton.removeClass("d-none")
          }
          throw e
        }
      }

  val settingsOld = localStorage["settings"]?.let { json.decodeFromString<UserSettingsOld>(it) }

  val settings =
      json.decodeFromString<UserData>(localStorage["userdata"] ?: "{}").apply {
        if (settingsOld != null) {
          val now = Date.now().toLong()
          settingsOld.presets.forEach { (k, v) -> presets[k] = SyncData(now, v) }
          localStorage["_settings"] = json.encodeToString(this)
          localStorage.removeItem("settings")
        }
      }

  private var etag: String? = null
  private suspend fun getSyncData(): UserData? {
    val token = getToken() ?: throw IllegalStateException("Not logged in")
    val response =
        client.get("$BASE_API_URL/sync") {
          headers {
            append("Authorization", "Bearer $token")
            append("If-None-Match", etag ?: "")
          }
          expectSuccess = false
        }
    return when (response.status) {
      HttpStatusCode.OK -> {
        etag = response.etag()
        response.body<GetSyncResponse>().data
      }
      HttpStatusCode.NotModified -> null
      else ->
          throw IllegalStateException(
              "An error occurred while retrieving sync data: ${response.status}")
    }
  }

  private suspend fun putSyncData() {
    val token = getToken() ?: throw IllegalStateException("Not logged in")
    val response =
        client.put("$BASE_API_URL/sync") {
          headers {
            append("Authorization", "Bearer $token")
            if (etag != null) {
              append("If-Match", etag!!)
            }
          }
          contentType(ContentType.Application.Json)
          setBody(PutSyncRequest(settings))
        }
    etag = response.etag()
    if (response.status.value >= 300) {
      throw IllegalStateException("An error occurred while saving sync data: ${response.status}")
    }
  }

  suspend fun sync() {
    reloadSettings()
    val syncData = getSyncData()
    if (syncData != null) {
      settings.update(syncData)
      saveSettings()
      putSyncData()
    }
  }

  fun reloadSettings() {
    val incoming: UserData = json.decodeFromString(localStorage["userdata"] ?: "{}")
    settings.update(incoming)
    saveSettings()
  }

  fun saveSettings() {
    localStorage["userdata"] = json.encodeToString(settings)
  }

  suspend fun createPresets(presets: List<PlayerLoadoutParameters>): String {
    val token = getToken()
    return client
        .post("$BASE_API_URL/share/presets/create") {
          headers { token?.let { append("Authorization", "Bearer $it") } }
          contentType(ContentType.Application.Json)
          setBody(CreatePresetsRequest(presets = presets))
        }
        .body<CreatePresetsResponse>()
        .id
  }

  suspend fun getPresets(id: String): List<PlayerLoadoutParameters> {
    return client.get("$BASE_API_URL/share/presets/get/$id").body<GetPresetsResponse>().presets
  }

  suspend fun createSetups(presets: List<SetupData>): String {
    val token = getToken()
    return client
        .post("$BASE_API_URL/share/setups/create") {
          headers { token?.let { append("Authorization", "Bearer $it") } }
          contentType(ContentType.Application.Json)
          setBody(CreateSetupsRequest(setups = presets))
        }
        .body<CreatePresetsResponse>()
        .id
  }

  suspend fun getSetups(id: String): List<SetupData> {
    return client.get("$BASE_API_URL/share/setups/get/$id").body<GetSetupsResponse>().setups
  }

  suspend fun shareSetup(parameters: SimulationParameters, options: SimulationOptions): String {
    val image = TeamImage(parameters, options).drawOpenGraphImage()
    val teamImage = TeamImage(parameters, options).drawTeamImage()
    val teamImageAlt = TeamImage(parameters, options).drawTeamImageAlt()
    return client
        .post("$BASE_API_URL/share/setup/create") {
          contentType(ContentType.Application.Json)
          setBody(
              CreateSetupRequest(
                  parameters = parameters,
                  preview_image = image.base64(),
                  preview_width = image.width,
                  preview_height = image.height,
                  team_image = teamImage.base64(),
                  team_image_alt = teamImageAlt.base64()))
        }
        .body<CreateSetupResponse>()
        .url
  }

  suspend fun getSetup(id: String): SimulationParameters {
    return client.get("$BASE_API_URL/share/setup/get/$id").body<GetSetupResponse>().parameters
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

@Serializable
data class CreateSetupsRequest(
    val name: String? = null,
    val setups: List<SetupData>,
)

@Serializable
data class CreateSetupsResponse(
    val id: String,
)

@Serializable
data class GetSetupsResponse(
    val setups: List<SetupData>,
)

@Serializable
data class GetSyncResponse(
    val data: UserData,
)

@Serializable
data class PutSyncRequest(
    val data: UserData,
)

@Serializable
data class CreateSetupRequest(
    val parameters: SimulationParameters,
    val preview_image: String,
    val preview_width: Int,
    val preview_height: Int,
    val team_image: String,
    val team_image_alt: String,
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
