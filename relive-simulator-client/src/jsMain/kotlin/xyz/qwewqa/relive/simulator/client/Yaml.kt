package xyz.qwewqa.relive.simulator.client

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@JsModule("js-yaml")
@JsNonModule
@JsName("load")
external object Yaml {
  fun load(document: String): dynamic
  fun dump(obj: dynamic): dynamic
}

// This is an ugly hack but
// 1. It works
// 2. Performance doesn't matter
// 3. Multiline strings are nice to have (otherwise yamlkt would be fine)

val json = Json {
  isLenient = true
  ignoreUnknownKeys = true
  allowSpecialFloatingPointValues = true
  encodeDefaults = true
}

inline fun <reified T> dumpYamlSerialize(obj: T): String {
  return Yaml.dump(Yaml.load(Json.encodeToString(obj))) as String
}

inline fun <reified T> loadYamlDeserialize(document: String): T {
  return json.decodeFromString(JSON.stringify(Yaml.load(document)))
}
