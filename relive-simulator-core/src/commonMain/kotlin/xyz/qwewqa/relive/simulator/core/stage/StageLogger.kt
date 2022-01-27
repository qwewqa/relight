package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.FormattedLogEntry
import xyz.qwewqa.relive.simulator.common.LogCategory

class StageLogger {
    private val log = mutableListOf<LogEntry>()

    fun log(turn: Int, tile: Int, move: Int, category: LogCategory, vararg tags: String, contents: LogContents) {
        log += LogEntry(turn, tile, move, category, tags.toList(), contents)
    }

    fun getFormatted(): List<FormattedLogEntry> = log.map { it.formatted() }
}

private fun String.escapeHtml() = this
    .replace("&", "&amp;")
    .replace(">", "&gt;")
    .replace("<", "&lt;")

class LogContentsBuilder {
    fun build(value: String) = LogContents(value)
}

data class LogContents(val value: String) {
    val html by lazy {
        fun String.imageReplace(name: String, url: (Int) -> String): String {
            return "@\\($name:(.*?)\\)".toRegex().replace(this) {
                val id = it.groups[1]!!.value.trim().toIntOrNull()
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

data class LogEntry(
    val turn: Int,
    val tile: Int,
    val move: Int,
    val category: LogCategory,
    val tags: List<String>,
    val contents: LogContents
) {
    fun formatted() = FormattedLogEntry(
        turn,
        tile,
        move,
        category,
        tags.map { it.escapeHtml() },
        contents.html,
    )
}
