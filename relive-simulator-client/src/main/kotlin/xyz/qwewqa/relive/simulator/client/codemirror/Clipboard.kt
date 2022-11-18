package xyz.qwewqa.relive.simulator.client.codemirror

import kotlinx.browser.localStorage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.w3c.dom.get
import org.w3c.dom.set
import xyz.qwewqa.relive.simulator.client.json
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters

const val ACTOR_CLIPBOARD_LOCAL_STORAGE_KEY = "actor-clipboard"

fun saveActorToClipboard(data: PlayerLoadoutParameters) {
    localStorage[ACTOR_CLIPBOARD_LOCAL_STORAGE_KEY] = json.encodeToString(data)
}

fun loadActorFromClipboard(): PlayerLoadoutParameters? {
    return try {
        localStorage[ACTOR_CLIPBOARD_LOCAL_STORAGE_KEY]?.let {
            json.decodeFromString(it)
        }
    } catch (e: Throwable) {
        null
    }
}
