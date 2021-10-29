package xyz.qwewqa.relive.simulator.js

import org.w3c.dom.DedicatedWorkerGlobalScope
import org.w3c.dom.MessageEvent

external val self: DedicatedWorkerGlobalScope

fun main() {
    self.onmessage = { ev: MessageEvent ->

    }
}
