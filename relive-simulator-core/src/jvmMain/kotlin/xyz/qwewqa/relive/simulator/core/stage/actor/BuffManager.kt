@file:JvmName("BuffManagerJvmImplKt")
package xyz.qwewqa.relive.simulator.core.stage.actor

import java.util.*

actual fun countableBuffMap(): MutableMap<CountableBuff, Int> = EnumMap(CountableBuff::class.java)
