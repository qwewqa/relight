package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.common.LogCategory

class StageLogger {
    private val log = mutableListOf<LogEntry>()

    fun log(turn: Int, tile: Int, move: Int, category: LogCategory, vararg tags: String, summary: String?, content: String) {
        log += LogEntry(turn, tile, move, category, tags.toList(), summary, content)
    }

    fun get(): List<LogEntry> = log.toList()
}
