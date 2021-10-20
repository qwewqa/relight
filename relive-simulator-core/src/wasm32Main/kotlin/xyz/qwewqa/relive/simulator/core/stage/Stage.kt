package xyz.qwewqa.relive.simulator.core.stage

actual class IgnoreRunException : Exception()

actual fun ignoreRun(): Nothing = throw IgnoreRunException()
