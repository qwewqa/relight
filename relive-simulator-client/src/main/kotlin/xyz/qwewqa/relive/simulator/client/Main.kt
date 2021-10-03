package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.dom.hasClass
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.*
import org.w3c.dom.url.URL
import kotlin.random.Random

val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

suspend fun main() {
    start(RemoteSimulator(URL("${window.location.protocol}//${window.location.host}")))
}

val HTMLInputElement.valueOrPlaceholder: String get() = if (value.isNotEmpty()) value else placeholder

@OptIn(DelicateCoroutinesApi::class, kotlinx.serialization.ExperimentalSerializationApi::class)
suspend fun start(simulator: Simulator) {
    var simulation: Simulation? = null
    var done = false

    val options = simulator.getOptions()

    var idCounter = 0

    val simulatorOptionsDiv = document.getElementById("simulator-options") as HTMLDivElement
    val shutdownButton = document.getElementById("shutdown-button") as HTMLButtonElement
    val exportButton = document.getElementById("export-button") as HTMLButtonElement
    val importButton = document.getElementById("import-button") as HTMLButtonElement
    val doImportButton = document.getElementById("do-import-button") as HTMLButtonElement
    val importText = document.getElementById("import-text") as HTMLInputElement
    val exportText = document.getElementById("export-text") as HTMLInputElement
    val seedInput = document.getElementById("seed-input") as HTMLInputElement
    val seedRandomizeButton = document.getElementById("seed-randomize") as HTMLButtonElement
    val actorSettingsDiv = document.getElementById("actor-settings") as HTMLDivElement
    val addActorButton = document.getElementById("add-actor-button") as HTMLButtonElement
    val removeActorButton = document.getElementById("remove-actor-button") as HTMLButtonElement
    val addActorRow = document.getElementById("add-actor-row") as HTMLDivElement
    val bossSelect = document.getElementById("boss-select") as HTMLSelectElement
    val strategyTypeSelect = document.getElementById("strategy-type-select") as HTMLSelectElement
    val simulateButton = document.getElementById("simulate-button") as HTMLButtonElement
    val cancelButton = document.getElementById("cancel-button") as HTMLButtonElement


    fun HTMLSelectElement.getSelected() = selectedOptions.asList().map {
        it.asDynamic().value as String
    }

    fun HTMLSelectElement.setSelected(selected: List<String>) {
        this.options.asList().filterIsInstance<HTMLOptionElement>().forEach {
            if (it.value in selected) {
                it.selected = true
            } else {
                it.selected = false
            }
        }
    }

    fun HTMLSelectElement.setSelected(selected: String) {
        this.options.asList().filterIsInstance<HTMLOptionElement>().forEach {
            if (it.value == selected) {
                it.selected = true
            } else {
                it.selected = false
            }
        }
    }

    fun getSetup(): SimulationParameters {
        val songSettings = document
            .getElementById("song-settings")!!
            .getElementsByClassName("song-effect-group").asList().map { options ->
                SongEffectParameter(
                    options.getElementsByClassName("song-effect-type")
                        .asList()
                        .filterIsInstance<HTMLSelectElement>()
                        .single().getSelected().single(),
                    (options.getElementsByClassName("song-effect-value")[0] as HTMLInputElement).valueOrPlaceholder.trim()
                        .toInt(),
                    (options.getElementsByClassName("song-effect-condition")
                        .asList()
                        .filterIsInstance<HTMLSelectElement>())
                        .map {
                            it.getSelected()
                        }
                        .filter { it.isNotEmpty() },
                )
            }
        return SimulationParameters(
            (document.getElementById("turns-input") as HTMLInputElement).valueOrPlaceholder.trim().toInt(),
            (document.getElementById("iterations-input") as HTMLInputElement).valueOrPlaceholder.trim().toInt(),
            actorSettingsDiv.getElementsByClassName("actor-options").asList().map { options ->
                PlayerLoadoutParameters(
                    (options.getElementsByClassName("actor-name")
                        .asList()
                        .single() as HTMLInputElement).value.trim(),
                    options.getElementsByClassName("actor-dress")
                        .asList()
                        .filterIsInstance<HTMLSelectElement>()
                        .single().getSelected().single(),
                    options.getElementsByClassName("actor-memoir")
                        .asList()
                        .filterIsInstance<HTMLSelectElement>()
                        .single().getSelected().single(),
                    (options.getElementsByClassName("actor-unit-skill")
                        .asList()
                        .single() as HTMLInputElement).valueOrPlaceholder.trim().toInt(),
                )
            },
            null,
            SongParameters(
                songSettings.dropLast(1).filter { it.name != "None" },
                songSettings.last().takeIf { it.name != "None" },
            ),
            StrategyParameter(
                (document.getElementById("strategy-type-select") as HTMLSelectElement).getSelected().single(),
                (document.getElementById("strategy") as HTMLTextAreaElement).value,
            ),
            bossSelect.getSelected().single(),
            (document.getElementById("event-bonus-input") as HTMLInputElement).valueOrPlaceholder.trim().toInt(),
            seedInput.valueOrPlaceholder.trim().toInt(),
        )
    }

    fun addActor() {
        actorSettingsDiv.insertBefore(
            document.create.div("row actor-options") {
                div("col-12 my-2") {
                    div("border border-2 rounded") {
                        div("row m-2") {
                            div("col-12 col-md-8 my-2") {
                                val inputId = "actor-name-${idCounter++}"
                                label("form-label") {
                                    htmlFor = inputId
                                    +"Name"
                                }
                                input(InputType.text, classes = "form-control actor-name") {
                                    id = inputId
                                }
                            }
                            div("col-12 col-md-4 my-2") {
                                val inputId = "actor-unit-skill-${idCounter++}"
                                label("form-label") {
                                    htmlFor = inputId
                                    +"Unit Skill Level"
                                }
                                input(InputType.text, classes = "form-control actor-unit-skill") {
                                    id = inputId
                                    placeholder = "21"
                                }
                            }
                            div("col-12 my-2") {
                                val selectId = "actor-dress-${idCounter++}"
                                label("form-label") {
                                    htmlFor = selectId
                                    +"Dress"
                                }
                                select("selectpicker form-control actor-dress") {
                                    id = selectId
                                    attributes["data-live-search"] = "true"
                                    options.dresses.forEach {
                                        option {
                                            value = it
                                            +it
                                        }
                                    }
                                }
                            }
                            div("col-12 my-2") {
                                val selectId = "actor-memoir-${idCounter++}"
                                label("form-label") {
                                    htmlFor = selectId
                                    +"Memoir"
                                }
                                select("selectpicker form-control actor-memoir") {
                                    id = selectId
                                    attributes["data-live-search"] = "true"
                                    options.memoirs.forEach {
                                        option {
                                            value = it
                                            +it
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            addActorRow,
        )
        js("$('.selectpicker').selectpicker()")
    }

    shutdownButton.addEventListener("click", {
        MainScope().launch {
            simulator.shutdown()
            simulatorOptionsDiv.remove()
        }
    })
    exportButton.addEventListener("click", {
        try {
            exportText.value = Json.encodeToString(getSetup())
        } catch (e: Exception) {
            exportText.value = e.message ?: "Error"
        }
    })
    exportText.addEventListener("click", {
        exportText.focus()
        exportText.select()
    })
    doImportButton.addEventListener("click", {
        Json.decodeFromString<SimulationParameters>(importText.value).run {
            (document.getElementById("turns-input") as HTMLInputElement).value = maxTurns.toString()
            (document.getElementById("iterations-input") as HTMLInputElement).value = maxIterations.toString()
            while (actorSettingsDiv.childElementCount >= 2) {
                actorSettingsDiv.removeChild(actorSettingsDiv.firstElementChild!!)
            }
            repeat(team.size) {
                addActor()
            }
            actorSettingsDiv.children.asList().zip(team).forEach { (options, actor) ->
                (options.getElementsByClassName("actor-name")
                    .asList()
                    .single() as HTMLInputElement).value = actor.name
                options.getElementsByClassName("actor-dress")
                    .asList()
                    .filterIsInstance<HTMLSelectElement>()
                    .single().setSelected(actor.dress)
                options.getElementsByClassName("actor-memoir")
                    .asList()
                    .filterIsInstance<HTMLSelectElement>()
                    .single().setSelected(actor.memoir)
                (options.getElementsByClassName("actor-unit-skill")
                    .asList()
                    .single() as HTMLInputElement).value = actor.unitSkillLevel.toString()
            }
            val songEffects = song.activeEffects.take(2) +
                    List((2 - song.activeEffects.size).coerceAtLeast(0)) { null } +
                    listOf(song.passiveEffect)
            document
                .getElementById("song-settings")!!
                .getElementsByClassName("song-effect-group")
                .asList()
                .zip(songEffects).forEach { (options, effect) ->
                    options.getElementsByClassName("song-effect-type")
                        .asList()
                        .filterIsInstance<HTMLSelectElement>()
                        .single().setSelected(effect?.name ?: "None")
                    (options.getElementsByClassName("song-effect-value")[0] as HTMLInputElement).value =
                        effect?.value?.toString() ?: ""
                    (options.getElementsByClassName("song-effect-condition")
                        .asList()
                        .filterIsInstance<HTMLSelectElement>())
                        .forEach { it.setSelected(emptyList()) }
                    (options.getElementsByClassName("song-effect-condition")
                        .asList()
                        .filterIsInstance<HTMLSelectElement>())
                        .zip(effect?.conditions ?: emptyList())
                        .forEach { (select, values) ->
                            select.setSelected(values)
                        }
                }
            (document.getElementById("strategy-type-select") as HTMLSelectElement).setSelected(strategy.type)
            (document.getElementById("strategy") as HTMLTextAreaElement).value = strategy.value
            bossSelect.setSelected(boss)
            (document.getElementById("event-bonus-input") as HTMLInputElement).value = eventBonus.toString()
            seedInput.value = seed.toString()

            js("$('.selectpicker').selectpicker('refresh')")
        }
    })
    seedRandomizeButton.addEventListener("click", {
        seedInput.value = Random.nextInt().toString()
    })
    removeActorButton.addEventListener("click", {
        if (actorSettingsDiv.childElementCount >= 2) {
            actorSettingsDiv.removeChild(actorSettingsDiv.children[actorSettingsDiv.childElementCount - 2]!!)
        }
    })
    addActorButton.addEventListener("click", {
        addActor()
    })
    addActor() // Start with one already here by default

    options.bosses.forEach {
        bossSelect.add(
            document.create.option {
                value = it
                +it
            }.asDynamic()
        )
    }
    options.strategyTypes.forEach {
        strategyTypeSelect.add(
            document.create.option {
                value = it
                +it
            }.asDynamic()
        )
    }
    document.getElementsByClassName("song-effect-type").asList().forEach { select ->
        (listOf("None") + options.songEffects).forEach {
            (select as? HTMLSelectElement)?.add(
                document.create.option {
                    value = it
                    +it
                }.asDynamic()
            )
        }
    }
    document.getElementsByClassName("song-effect-condition").asList().forEach { select ->
        options.conditions.forEach {
            (select as? HTMLSelectElement)?.add(
                document.create.option {
                    value = it
                    +it
                }.asDynamic()
            )
        }
    }

    simulateButton.addEventListener("click", {
        GlobalScope.launch {
            simulateButton.disabled = true
            cancelButton.disabled = false
            simulation = simulator.simulate(getSetup())
            done = false
        }
    })
    cancelButton.addEventListener("click", {
        GlobalScope.launch {
            simulation?.cancel()
            simulateButton.disabled = false
            cancelButton.disabled = true
        }
    })

    js("$('.selectpicker').selectpicker('refresh')")

    GlobalScope.launch {
        while (true) {
            if (!done) {
                simulation?.let { sim ->
                    val result = sim.pollResult()
                    val iterationResults = result.results.associate { it.result to it.count }
                    val excludedCount = iterationResults[SimulationResultType.Excluded] ?: 0
                    val existingDiv = document.getElementById("results")!!
                    val newDiv = document.create.div {
                        id = "results"
                        p {
                            iterationResults.forEach { (k, v) ->
                                if (excludedCount == 0) {
                                    +"$k: $v (${v * 100.0 / result.currentIterations}%)"
                                } else {
                                    if (k == SimulationResultType.Excluded) {
                                        +"$k: $v (N/A / ${v * 100.0 / result.currentIterations}%)"
                                    } else {
                                        +"$k: $v (${v * 100.0 / (result.currentIterations - excludedCount)}% / ${v * 100.0 / result.currentIterations}%)"
                                    }
                                }
                                br { }
                            }
                            pre {
                                +(result.log ?: "")
                            }
                            pre {
                                +(result.error ?: "")
                            }
                        }
                    }
                    existingDiv.replaceWith(newDiv)
                    done = result.done
                    if (result.done) {
                        simulateButton.disabled = false
                        cancelButton.disabled = true
                    }
                }
            }
            delay(200)
        }
    }
}
