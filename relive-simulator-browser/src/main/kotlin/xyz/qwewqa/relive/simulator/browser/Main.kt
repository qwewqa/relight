package xyz.qwewqa.relive.simulator.browser

import xyz.qwewqa.relive.simulator.client.start

suspend fun main() {
    start(BrowserSimulator())
}
