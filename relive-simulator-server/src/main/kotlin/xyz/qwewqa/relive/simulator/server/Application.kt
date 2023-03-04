package xyz.qwewqa.relive.simulator.server

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.server.plugins.cors.routing.*
import xyz.qwewqa.relive.simulator.server.plugins.configureHTTP
import xyz.qwewqa.relive.simulator.server.plugins.configureRouting
import xyz.qwewqa.relive.simulator.server.plugins.configureSerialization

fun main() {
  embeddedServer(CIO, port = 8080, host = "localhost") {
        install(CORS) {
          anyHost()
          allowHeader(HttpHeaders.ContentType)
        }
        install(CachingHeaders) { options { _, _ -> CachingOptions(CacheControl.NoCache(null)) } }
        configureRouting()
        configureSerialization()
        configureHTTP()
      }
      .start(wait = true)
}
