package xyz.qwewqa.relive.simulator.core.stage.common

fun substituteString(string: String, values: List<Pair<String, String>>): String {
    var result = string
    values.forEach { (key, value) ->
        result = result.replace("%$key%", value)
    }
    return result
}
