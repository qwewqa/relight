package xyz.qwewqa.relivesim.stage

class Logger {
    private val log = mutableListOf<LogEntry>()

    fun log(tag: String = "", value: String) {
        log += LogEntry(tag, value)
    }

    override fun toString(): String {
        return log.joinToString("\n") {
            if ("\n" in it.value) {
                "<${it.tag}>\n${it.value.prependIndent("    ")}"
            } else {
                "<${it.tag}> ${it.value}"
            }
        }
    }
}

data class LogEntry(val tag: String, val value: String)