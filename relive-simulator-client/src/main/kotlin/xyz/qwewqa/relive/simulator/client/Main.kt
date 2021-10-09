package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.mamoe.yamlkt.Yaml
import org.w3c.dom.*
import org.w3c.dom.url.URL
import kotlin.random.Random

suspend fun main() {
    start(RemoteSimulator(URL("${window.location.protocol}//${window.location.host}")))
}

val yaml = Yaml {
    encodeDefaultValues = false
}

@OptIn(DelicateCoroutinesApi::class, kotlinx.serialization.ExperimentalSerializationApi::class)
suspend fun start(simulator: Simulator) {
    var simulation: Simulation? = null
    var done = false

    val options = simulator.getOptions()

    val commonText = options.commonText.associateBy { it.id }
    val bosses = options.bosses.associateBy { it.id }
    val strategies = options.strategyTypes.associateBy { it.id }
    val songEffects = mapOf("none" to SimulationOption("none", emptyMap())) + options.songEffects.associateBy { it.id }
    val conditions = options.conditions.associateBy { it.id }
    val dresses = options.dresses.associateBy { it.id }
    val memoirs = options.memoirs.associateBy { it.id }

    val languageSelect = document.getElementById("language-select").singleSelect()
    val simulatorOptionsDiv = document.getElementById("simulator-options") as HTMLDivElement
    val shutdownButton = document.getElementById("shutdown-button") as HTMLButtonElement
    val exportButton = document.getElementById("export-button") as HTMLButtonElement
    val doImportButton = document.getElementById("do-import-button") as HTMLButtonElement
    val yamlImportCheckbox = document.getElementById("import-yaml-checkbox") as HTMLInputElement
    val importText = document.getElementById("import-text") as HTMLTextAreaElement
    val exportText = document.getElementById("export-text") as HTMLTextAreaElement
    val seedInput = document.getElementById("seed-input").integerInput(0)
    val seedRandomizeButton = document.getElementById("seed-randomize") as HTMLButtonElement
    val actorSettingsDiv = document.getElementById("actor-settings") as HTMLDivElement
    val addActorButton = document.getElementById("add-actor-button") as HTMLButtonElement
    val removeActorButton = document.getElementById("remove-actor-button") as HTMLButtonElement
    val addActorRow = document.getElementById("add-actor-row") as HTMLDivElement
    val bossSelect = document.getElementById("boss-select").singleSelect()
    val strategyTypeSelect = document.getElementById("strategy-type-select").singleSelect()
    val strategyContainer = document.getElementById("strategy-container") as HTMLDivElement
    val simulateButton = document.getElementById("simulate-button") as HTMLButtonElement
    val cancelButton = document.getElementById("cancel-button") as HTMLButtonElement
    val eventBonusInput = document.getElementById("event-bonus-input").integerInput(0)
    val turnsInput = document.getElementById("turns-input").integerInput(3)
    val iterationsInput = document.getElementById("iterations-input").integerInput(100000)
    val strategyEditor = CodeMirror(strategyContainer, js("{lineNumbers: true, mode: null}"))

    var locale = options.locales.keys.first()

    fun addActor() {
        val actorCount = actorSettingsDiv.getElementsByClassName("actor-options").length + 1
        actorSettingsDiv.insertBefore(
            document.create.div("row actor-options") {
                div("col-12 my-2") {
                    div("border border-2 rounded") {
                        div("row m-2") {
                            div("col-12 col-md-8 my-2") {
                                val inputId = "actor-name-$actorCount"
                                label("form-label") {
                                    htmlFor = inputId
                                    +"Name"
                                }
                                input(InputType.text, classes = "form-control actor-name") {
                                    id = inputId
                                }
                            }
                            div("col-12 col-md-4 my-2") {
                                val inputId = "actor-unit-skill-$actorCount"
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
                                val selectId = "actor-dress-$actorCount"
                                label("form-label") {
                                    htmlFor = selectId
                                    +"Dress"
                                }
                                select("selectpicker form-control actor-dress") {
                                    id = selectId
                                    attributes["data-live-search"] = "true"
                                    options.dresses.forEach {
                                        option {
                                            value = it.id
                                            +it[locale]
                                        }
                                    }
                                }
                            }
                            div("col-12 col-md-6 my-2") {
                                val selectId = "actor-memoir-$actorCount"
                                label("form-label") {
                                    htmlFor = selectId
                                    +"Memoir"
                                }
                                select("selectpicker form-control actor-memoir") {
                                    id = selectId
                                    attributes["data-live-search"] = "true"
                                    options.memoirs.forEach {
                                        option {
                                            value = it.id
                                            +it[locale]
                                        }
                                    }
                                }
                            }
                            div("col-6 col-md-3 my-2") {
                                val inputId = "actor-memoir-level-$actorCount"
                                label("form-label") {
                                    htmlFor = inputId
                                    +"Memoir Level"
                                }
                                input(InputType.number, classes = "form-control actor-memoir-level") {
                                    id = inputId
                                    placeholder = "1"
                                }
                            }
                            div("col-6 col-md-3 my-2") {
                                val selectId = "actor-memoir-unbind-$actorCount"
                                label("form-label") {
                                    htmlFor = selectId
                                    +"Memoir Unbind"
                                }
                                select(classes = "form-select actor-memoir-unbind") {
                                    id = selectId
                                    option {
                                        value = "0"
                                        label = "0"
                                    }
                                    option {
                                        value = "1"
                                        label = "1"
                                    }
                                    option {
                                        value = "2"
                                        label = "2"
                                    }
                                    option {
                                        value = "3"
                                        label = "3"
                                    }
                                    option {
                                        value = "4"
                                        label = "4"
                                        selected = true
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

    fun removeActor() {
        if (actorSettingsDiv.childElementCount >= 2) {
            actorSettingsDiv.removeChild(actorSettingsDiv.children[actorSettingsDiv.childElementCount - 2]!!)
        }
    }

    fun getSetup(): SimulationParameters {
        val songSettings = document
            .getElementById("song-settings")!!
            .getElementsByClassName("song-effect-group").asList().map { options ->
                SongEffect(options).parameters
            }
        return SimulationParameters(
            turnsInput.value,
            iterationsInput.value,
            actorSettingsDiv.getElementsByClassName("actor-options").asList().map { options ->
                ActorOptions(options).parameters
            },
            null,
            SongParameters(
                songSettings.dropLast(1).filterNotNull(),
                songSettings.last(),
            ),
            StrategyParameter(
                strategyTypeSelect.value,
                strategyEditor.getValue() as String,
            ),
            bossSelect.value,
            eventBonusInput.value,
            seedInput.value,
        )
    }

    fun setSetup(setup: SimulationParameters) = setup.run {
        turnsInput.value = maxTurns
        iterationsInput.value = maxIterations
        while (actorSettingsDiv.childElementCount >= 2) {
            removeActor()
        }
        repeat(team.size) {
            addActor()
        }
        actorSettingsDiv.children.asList().zip(team).forEach { (options, parameters) ->
            ActorOptions(options).parameters = parameters
        }
        val effects = song.activeEffects.take(2) +
                List((2 - song.activeEffects.size).coerceAtLeast(0)) { null } +
                listOf(song.passiveEffect)
        document
            .getElementById("song-settings")!!
            .getElementsByClassName("song-effect-group")
            .asList()
            .zip(effects).forEach { (options, parameters) ->
                SongEffect(options).parameters = parameters
            }
        strategyTypeSelect.value = strategy.type
        strategyEditor.setValue(strategy.value)
        bossSelect.value = boss
        eventBonusInput.value = eventBonus
        seedInput.value = seed
        refreshSelectPicker()
    }

    shutdownButton.addEventListener("click", {
        MainScope().launch {
            simulator.shutdown()
            simulatorOptionsDiv.remove()
        }
    })

    fun updateExportText() {
        try {
            if (yamlImportCheckbox.checked) {
                exportText.value = yaml.encodeToString(getSetup())
            } else {
                exportText.value = Json.encodeToString(getSetup())
            }
        } catch (e: Exception) {
            exportText.value = e.message ?: "Error"
        }
    }

    exportButton.addEventListener("click", {
        updateExportText()
    })

    yamlImportCheckbox.addEventListener("click", {
        updateExportText()
    })

    exportText.addEventListener("click", {
        exportText.focus()
        exportText.select()
    })

    doImportButton.addEventListener("click", {
        setSetup(yaml.decodeFromString<SimulationParameters>(importText.value))
    })

    seedRandomizeButton.addEventListener("click", {
        seedInput.value = Random.nextInt()
    })

    addActorButton.addEventListener("click", {
        addActor()
    })

    removeActorButton.addEventListener("click", {
        removeActor()
    })

    addActor() // Start with one already here by default

    languageSelect.populate(options.locales)
    bossSelect.populate(bosses, locale)
    strategyTypeSelect.populate(strategies, locale)
    document.getElementsByClassName("song-effect-type")
        .asList()
        .filterIsInstance<HTMLSelectElement>()
        .forEach { select ->
            SingleSelect(select).populate(songEffects, locale)
        }
    document.getElementsByClassName("song-effect-condition")
        .asList()
        .filterIsInstance<HTMLSelectElement>()
        .forEach { select ->
            MultipleSelect(select).populate(conditions, locale)
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

    fun updateLocaleText() {
        bossSelect.localize(bosses, locale)
        strategyTypeSelect.localize(strategies, locale)
        document.getElementsByClassName("song-effect-type")
            .asList()
            .filterIsInstance<HTMLSelectElement>()
            .forEach { select ->
                SingleSelect(select).localize(songEffects, locale)
            }
        document.getElementsByClassName("song-effect-condition")
            .asList()
            .filterIsInstance<HTMLSelectElement>()
            .forEach { select ->
                MultipleSelect(select).localize(conditions, locale)
            }
        document.getElementsByClassName("actor-dress")
            .asList()
            .filterIsInstance<HTMLSelectElement>()
            .forEach { select ->
                SingleSelect(select).localize(dresses, locale)
            }
        document.getElementsByClassName("actor-memoir")
            .asList()
            .filterIsInstance<HTMLSelectElement>()
            .forEach { select ->
                SingleSelect(select).localize(memoirs, locale)
            }
        refreshSelectPicker()
    }

    languageSelect.element.addEventListener("change", {
        locale = languageSelect.value
        updateLocaleText()
    })

    refreshSelectPicker()

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
