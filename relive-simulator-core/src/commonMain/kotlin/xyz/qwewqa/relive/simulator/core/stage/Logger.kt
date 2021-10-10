package xyz.qwewqa.relive.simulator.core.stage

class Logger {
    private val log = mutableListOf<LogEntry>()

    fun log(turn: Int, tile: Int, tag: String = "", value: String) {
        log += LogEntry(turn, tile, tag, value)
    }

    override fun toString(): String {
        return log.joinToString("\n") { entry ->
            entry.run {
                if ("\n" in value) {
                    "$turn.$tile <$tag>\n${value.prependIndent("    ")}"
                } else {
                    "$turn.$tile <$tag> $value"
                }
            }
        }
    }
}

data class LogEntry(val turn: Int, val tile: Int, val tag: String, val value: String)
