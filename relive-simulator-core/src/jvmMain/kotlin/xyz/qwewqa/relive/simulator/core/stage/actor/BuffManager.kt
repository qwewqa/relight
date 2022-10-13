@file:JvmName("BuffManagerJvmImplKt")
package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect
import java.util.*


actual fun activeBuffSet(): MutableSet<ActiveBuff> = linkedSetOf()
actual fun <V> buffEffectMap(): MutableMap<TimedBuffEffect, V> = linkedMapOf()
actual fun countableBuffMap(): MutableMap<CountableBuff, Int> = EnumMap(CountableBuff::class.java)
