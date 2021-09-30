package xyz.qwewqa.relive.simulator.server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import xyz.qwewqa.relive.simulator.server.plugins.configureAdministration
import xyz.qwewqa.relive.simulator.server.plugins.configureHTTP
import xyz.qwewqa.relive.simulator.server.plugins.configureRouting
import xyz.qwewqa.relive.simulator.server.plugins.configureSerialization


fun main() {
    embeddedServer(CIO, port = 8080, host = "localhost") {
        install(CORS) {
            anyHost()
            header(HttpHeaders.ContentType)
        }
        configureAdministration()
        configureRouting()
        configureSerialization()
        configureHTTP()
    }.start(wait = true)
}
