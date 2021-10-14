package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.dom.addClass
import kotlinx.dom.removeClass
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.*
import org.w3c.dom.events.Event
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.Plotly.react
import kotlin.random.Random

suspend fun main() {
    start(RemoteSimulator(URL("${window.location.protocol}//${window.location.host}")))
}

@OptIn(DelicateCoroutinesApi::class, kotlinx.serialization.ExperimentalSerializationApi::class)
suspend fun start(simulator: Simulator) {
    var simulation: Simulation? = null
    var done = false

    val version = simulator.version()
    val options = simulator.options()

    val commonText = options.commonText.associateBy { it.id }
    val bosses = options.bosses.associateBy { it.id }
    val strategies = options.strategyTypes.associateBy { it.id }
    val songEffects = mapOf("none" to (commonText["none"] ?: SimulationOption("none",
        emptyMap()))) + options.songEffects.associateBy { it.id }
    val conditions = options.conditions.associateBy { it.id }
    val dresses = options.dresses.associateBy { it.id }
    val memoirs = options.memoirs.associateBy { it.id }

    val versionLink = document.getElementById("version-link") as HTMLAnchorElement
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

    versionLink.textContent = version.toString()

    var locale = options.locales.keys.first()

    fun localized(value: String, fallback: String) = commonText[value]?.get(locale) ?: fallback

    val toastContainer = document.getElementById("toast-container") as HTMLDivElement

    fun toastElement(name: String, value: String) = document.create.div("toast") {
        attributes["role"] = "alert"
        div("toast-header") {
            strong("me-auto") {
                +name
            }
            button(type = ButtonType.button, classes = "btn-close") {
                attributes["data-bs-dismiss"] = "toast"
            }
        }
        div("toast-body") {
            +value
        }
    }

    fun toast(name: String, value: String): bootstrap.Toast {
        val element = toastElement(name, value)
        toastContainer.appendChild(element)
        return bootstrap.Toast(element).also {
            it.show()
        }
    }

    fun addActor() {
        val actorCount = actorSettingsDiv.getElementsByClassName("actor-options").length + 1
        actorSettingsDiv.insertBefore(
            document.create.div("row actor-options") {
                div("col-12 my-2") {
                    div("border border-2 rounded") {
                        div("row m-2") {
                            div("col-12 col-md-8 my-2") {
                                val inputId = "actor-name-$actorCount"
                                label("form-label text-actor-name") {
                                    htmlFor = inputId
                                    +localized(".text-actor-name", "Name")
                                }
                                input(InputType.text, classes = "form-control actor-name") {
                                    id = inputId
                                }
                            }
                            div("col-12 col-md-4 my-2") {
                                val inputId = "actor-unit-skill-$actorCount"
                                label("form-label text-unit-skill-level") {
                                    htmlFor = inputId
                                    +localized(".text-unit-skill-level", "Unit Skill Level")
                                }
                                input(InputType.text, classes = "form-control actor-unit-skill") {
                                    id = inputId
                                    placeholder = "21"
                                }
                            }
                            div("col-12 my-2") {
                                val selectId = "actor-dress-$actorCount"
                                label("form-label text-dress") {
                                    htmlFor = selectId
                                    +localized(".text-dress", "Dress")
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
                                label("form-label text-memoir") {
                                    htmlFor = selectId
                                    +localized(".text-memoir", "Memoir")
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
                                label("form-label text-memoir-level") {
                                    htmlFor = inputId
                                    +localized(".text-memoir-level", "Memoir Level")
                                }
                                input(InputType.number, classes = "form-control actor-memoir-level") {
                                    id = inputId
                                    placeholder = "1"
                                }
                            }
                            div("col-6 col-md-3 my-2") {
                                val selectId = "actor-memoir-unbind-$actorCount"
                                label("form-label text-memoir-unbind") {
                                    htmlFor = selectId
                                    +localized(".text-memoir-unbind", "Memoir Unbind")
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
            try {
                simulator.shutdown()
                toast("Shutdown", "Successfully shut down server.")
            } catch (e: Throwable) {
                toast("Shutdown", "An error occurred when attempting shutdown.")
            }
        }
    })

    fun updateExportText() {
        try {
            if (yamlImportCheckbox.checked) {
                exportText.value = dumpYamlSerialize(getSetup())
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
        setSetup(loadYamlDeserialize(importText.value))
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
        commonText.filter { (k, _) -> k[0] == '.' }.forEach { (k, v) ->
            document.getElementsByClassName(k.drop(1)).asList().forEach { element ->
                element.textContent = v[locale]
            }
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
                    val iterationResults = result.results.sorted()
                    val resultsRow = document.getElementById("results-row") as HTMLDivElement
                    val resultsText = document.getElementById("results-text") as HTMLPreElement
                    val errorRow = document.getElementById("results-error-row") as HTMLDivElement
                    val logRow = document.getElementById("results-log-row") as HTMLDivElement
                    val errorText = document.getElementById("error-text") as HTMLPreElement
                    val logText = document.getElementById("log-text") as HTMLPreElement
                    val resultsPlot = document.getElementById("results-plot")!!

                    val currentIterationsText = result.currentIterations.toString()
                    val maxIterationsText = result.maxIterations.toString()
                    val progressText =
                        "${(result.currentIterations.toDouble() / result.maxIterations * 100).toFixed(2)}%"
                    val runtimeText = if (result.runtime != null) " [${result.runtime.toFixed(5)}s]" else ""
                    val progressDisplay =
                        "Progress: ${" ".repeat(maxIterationsText.length - currentIterationsText.length)}$currentIterationsText/$maxIterationsText ($progressText)$runtimeText"
                    val iterationResultsText = ResultEntry().apply {
                        iterationResults.forEach {
                            add(it)
                        }
                    }.format()
                    val simpleResults = iterationResults
                        .groupBy { it.result }
                        .map { (result, values) -> result to values.sumOf { it.count } }
                        .sortedByDescending { (result, _) -> result } // Plotly reverses things
                        .toMap()
                    resultsText.textContent = progressDisplay + "\n\n" + iterationResultsText
                    react(
                        graphDiv = resultsPlot,
                        data = arrayOf(
                            jsObject {
                                type = "bar"
                                x = simpleResults.values.toTypedArray()
                                y = simpleResults.keys.map { it.toString() }.toTypedArray()
                                orientation = "h"
                                marker = jsObject {
                                    color = simpleResults.keys.map { it.color }.toTypedArray()
                                }
                            } as Any
                        ),
                        layout = jsObject {
                            xaxis = jsObject {
                                range = arrayOf(0, result.currentIterations)
                            }
                            height = simpleResults.size.coerceAtLeast(1) * 30 + 60
                            margin = jsObject {
                                l = 120
                                r = 60
                                b = 40
                                t = 20
                            }
                        } as Any,
                        config = jsObject {
                            responsive = true
                            staticPlot = true
                        } as Any,
                    )
                    window.dispatchEvent(Event("resize")) // Makes plotly resize immediately
                    resultsRow.removeClass("d-none")

                    if (result.log != null) {
                        logText.textContent = result.log
                        logRow.removeClass("d-none")
                    } else {
                        logRow.addClass("d-none")
                    }
                    if (result.error != null) {
                        errorText.textContent = result.error
                        errorRow.removeClass("d-none")
                    } else {
                        errorRow.addClass("d-none")
                    }
                    done = result.done
                    if (result.done) {
                        simulateButton.disabled = false
                        cancelButton.disabled = true
                    }
                }
            }
            delay(500)
        }
    }
}

fun Double.toFixed(digits: Int) = asDynamic().toFixed(digits) as String

class ResultEntry(
    val name: String = "All",
    val parent: ResultEntry? = null,
    private val children: MutableMap<String, ResultEntry> = mutableMapOf(),
    private var totalCount: Int = 0,
    private var excludedCount: Int = 0,
) {
    private val root: ResultEntry = parent?.root ?: this
    private val includedCount: Int get() = totalCount - excludedCount

    fun add(resultValue: SimulationResultValue) {
        this[resultValue.totalTags].addToSelf(resultValue)
    }

    private fun addToSelf(resultValue: SimulationResultValue) {
        totalCount += resultValue.count
        if (resultValue.result is SimulationResultType.Excluded) {
            excludedCount += resultValue.count
        }
        parent?.addToSelf(resultValue)
    }

    fun format() = formatRecursive().joinToString("\n")

    private fun formatRecursive(): List<String> = when(children.size) {
        0 -> listOf(formatSelf())
        1 -> children.values.single().let {
            ResultEntry("$name-${it.name}", parent, it.children, totalCount, excludedCount).formatRecursive()
        }
        else -> listOf(formatSelf()) + children.values.flatMap { it.formatRecursive() }.indented()
    }

    private fun formatSelf(): String = if (parent != null) {
        val percentParent = (includedCount * 100.0 / parent.includedCount).toFixed(3)
        val percentRoot = (includedCount * 100.0 / root.includedCount).toFixed(3)
        when (excludedCount) {
            0 -> {
                if (root.excludedCount > 0) {
                    "$name: $includedCount ($percentParent% of parent, $percentRoot% of all) included"
                } else {
                    "$name: $includedCount ($percentParent% of parent, $percentRoot% of all)"
                }
            }
            totalCount -> {
                "$name: $excludedCount excluded"
            }
            else -> {
                "$name: $includedCount ($percentParent% of parent, $percentRoot% of all) included, $excludedCount excluded"
            }
        }
    } else {
        if (excludedCount == 0) {
            "$name: $totalCount"
        } else {
            val percentIncluded = (includedCount * 100.0 / totalCount).toFixed(5)
            val percentExcluded = (excludedCount * 100.0 / totalCount).toFixed(5)
            "$name: $includedCount ($percentIncluded%) included, $excludedCount ($percentExcluded%) excluded, $totalCount total"
        }
    }

    operator fun get(tags: List<String>): ResultEntry = if (tags.isEmpty()) {
        this
    } else {
        children.getOrPut(tags[0]) { ResultEntry(tags[0], this) }[tags.drop(1)]
    }
}

fun List<String>.indented() = map { "    $it" }

inline fun jsObject(init: dynamic.() -> Unit): dynamic {
    val o = js("{}")
    init(o)
    return o
}
