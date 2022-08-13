package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.browser.localStorage
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.get
import org.w3c.dom.set
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters
import kotlin.js.Date

const val BASE_API_URL = "https://api-legacy.relight.qwewqa.xyz"

class RelightApi {
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

    val settingsOld = localStorage["settings"]?.let {
        json.decodeFromString<UserSettingsOld>(it)
    }

    var settings = json.decodeFromString<UserData>(localStorage["userdata"] ?: "{}").apply {
        if (settingsOld != null) {
            val now = Date.now().toLong()
            settingsOld.presets.forEach { (k, v) ->
                presets[k] = SyncData(now, v)
            }
            localStorage["_settings"] = json.encodeToString(this)
            localStorage.removeItem("settings")
        }
    }

    fun reloadSettings() {
        settings = json.decodeFromString(localStorage["userdata"] ?: "{}")
    }

    fun saveSettings() {
        localStorage["userdata"] = json.encodeToString(settings)
    }

    suspend fun createPresets(presets: List<PlayerLoadoutParameters>): String {
        return client.post("$BASE_API_URL/share/presets/create") {
            contentType(ContentType.Application.Json)
            setBody(CreatePresetsRequest(presets = presets))
        }.body<CreatePresetsResponse>().id
    }

    suspend fun getPresets(id: String): List<PlayerLoadoutParameters> {
        return client.get("$BASE_API_URL/share/presets/get/$id").body<GetPresetsResponse>().presets
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
