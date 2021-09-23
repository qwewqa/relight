@file:JvmName("StageJvmImplKt")

package xyz.qwewqa.relive.simulator.core.stage

actual class IgnoreRunException : Exception("Run ignored.", null, true, false)

actual fun ignoreRun(): Nothing = throw IgnoreRunException()
