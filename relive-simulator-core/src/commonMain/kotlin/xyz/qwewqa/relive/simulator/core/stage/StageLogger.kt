package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.common.LogCategory

class StageLogger(val skip: Int) {
    private val log = mutableListOf<LogEntry>()
    private var logCount = 0

    /**
     * Call before log(). Do not call log() if this returns false.
     */
    fun prepare(): Boolean {
        logCount++
        return logCount > skip
    }

    fun log(turn: Int, tile: Int, move: Int, category: LogCategory, vararg tags: String, summary: String?, content: String) {
        log += LogEntry(turn, tile, move, category, tags.toList(), summary, content)
    }

    fun get(): List<LogEntry> = log.toList()

    fun appendEntries(entries: List<LogEntry>) {
        log += entries
    }
}
