package xyz.qwewqa.relive.simulator.server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import xyz.qwewqa.relive.simulator.server.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
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
