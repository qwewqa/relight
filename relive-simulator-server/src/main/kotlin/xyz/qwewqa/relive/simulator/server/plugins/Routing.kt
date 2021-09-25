package xyz.qwewqa.relive.simulator.server.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import xyz.qwewqa.relive.simulator.core.presets.condition.conditions
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.presets.dress.playerDresses
import xyz.qwewqa.relive.simulator.core.presets.memoir.memoirs
import xyz.qwewqa.relive.simulator.core.presets.song.songEffects
import xyz.qwewqa.relive.simulator.server.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        post("/simulate") {
            val parameters = call.receive<SimulationParameters>()
            val token = simulate(parameters)
            call.respond(SimulateResponse(token))
        }
        get("/result/{token}") {
            val token = call.parameters["token"]!!
            val result = simulationResults[token]
            if (result == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                call.respond(result)
            }
        }
        delete("/result/{token}") {
            val token = call.parameters["token"]!!
            simulationResults.remove(token)
            call.respond(HttpStatusCode.NoContent)
        }
        get("/options") {
            call.respond(
                SimulationOptionNames(
                    playerDresses.keys.toList(),
                    memoirs.keys.toList(),
                    songEffects.keys.toList(),
                    conditions.keys.toList(),
                    bossLoadouts.keys.toList(),
                )
            )
        }
    }
}
