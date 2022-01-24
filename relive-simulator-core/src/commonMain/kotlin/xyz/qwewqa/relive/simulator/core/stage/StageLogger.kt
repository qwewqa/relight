package xyz.qwewqa.relive.simulator.core.stage

class StageLogger {
    private val log = mutableListOf<LogEntry>()

    fun log(turn: Int, tile: Int, move: Int, vararg tags: String, contents: LogContents) {
        log += LogEntry(turn, tile, move, tags.toList(), contents)
    }

    fun asHtml(): String {
        return log.joinToString("\n") { entry ->
            entry.run {
                val value = contents.html
                if ("\n" in value) {
                    "$turn.$tile.$move [${tags.joinToString(" / ") { it.escapeHtml() }}]\n${value}"
                } else {
                    "$turn.$tile.$move [${tags.joinToString(" / ") { it.escapeHtml() }}] $value"
                }
            }
        }
    }
}

private fun String.escapeHtml() = this
    .replace(">", "&gt;")
    .replace("<", "&lt;")
    .replace("&", "&amp;")

class LogContentsBuilder {
    fun build(value: String) = LogContents(value)
}

data class LogContents(val value: String) {
    val html by lazy {
        fun String.imageReplace(name: String, url: (Int) -> String): String {
            return "@\\($name:(.*?)\\)".toRegex().replace(this) {
                val id = it.groups[1]!!.value.toIntOrNull()
                if (id == null || id == -1) {
                    ""
                } else {
                    """<img style="height: 1em" src="${url(id)}">"""
                }
            }
        }
        value
            .escapeHtml()
            .imageReplace("dress") { "img/large_icon/1_$it.png" }
            .imageReplace("memoir") { "img/large_icon/2_$it.png" }
            .imageReplace("act") { "img/skill_icon/skill_icon_$it.png" }
    }
}

sealed class LogSubstitution {
    abstract val name: String
    abstract fun htmlReplacement(): String
    data class Image(override val name: String, val path: String) : LogSubstitution() {
        override fun htmlReplacement() = """<img style="height: 1em" src="$path">"""
    }
}

data class LogEntry(val turn: Int, val tile: Int, val move: Int, val tags: List<String>, val contents: LogContents)
