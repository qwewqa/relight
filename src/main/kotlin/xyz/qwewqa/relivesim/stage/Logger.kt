package xyz.qwewqa.relivesim.stage

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class Logger {
    val log = mutableListOf<LogEntry>()

    fun log(tag: String = "", value: String) {
        log += LogEntry(tag, value)
    }
}

data class LogEntry(val tag: String, val value: String)