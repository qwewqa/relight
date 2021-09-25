package xyz.qwewqa.relive.simulator.server.plugins

import io.ktor.server.engine.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureAdministration() {
    install(ShutDownUrl.ApplicationCallFeature) {
        shutDownUrl = "/shutdown"
        exitCodeSupplier = { 0 } // ApplicationCall.() -> Int
    }
}
