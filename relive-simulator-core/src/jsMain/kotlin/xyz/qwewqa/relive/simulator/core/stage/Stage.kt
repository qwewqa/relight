package xyz.qwewqa.relive.simulator.core.stage

actual class IgnoreRunException : Exception("Run ignored.")
actual fun ignoreRun(): Nothing = throw IgnoreRunException()
