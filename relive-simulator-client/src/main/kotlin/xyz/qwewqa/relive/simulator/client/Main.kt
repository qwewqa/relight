package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.dom.addClass
import kotlinx.dom.removeClass
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.*
import org.w3c.dom.events.Event
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.Plotly.react
import kotlin.random.Random

suspend fun main() {
    SimulatorClient(RemoteSimulator(URL("${window.location.protocol}//${window.location.host}"))).start()
}

@OptIn(DelicateCoroutinesApi::class, kotlinx.serialization.ExperimentalSerializationApi::class)
class SimulatorClient(val simulator: Simulator) {
    var simulation: Simulation? = null
    var done = false

    val versionLink = document.getElementById("version-link") as HTMLAnchorElement
    val languageSelect = document.getElementById("language-select").singleSelect()
    val shutdownContainer = document.getElementById("shutdown-container") as HTMLDivElement
    val shutdownButton = document.getElementById("shutdown-button") as HTMLButtonElement
    val exportButton = document.getElementById("export-button") as HTMLButtonElement
    val doImportButton = document.getElementById("do-import-button") as HTMLButtonElement
    val yamlImportCheckbox = document.getElementById("import-yaml-checkbox") as HTMLInputElement
    val guestCheckbox = document.getElementById("guest-checkbox") as HTMLInputElement
    val importText = document.getElementById("import-text") as HTMLTextAreaElement
    val exportText = document.getElementById("export-text") as HTMLTextAreaElement
    val seedInput = document.getElementById("seed-input").integerInput(0)
    val seedRandomizeButton = document.getElementById("seed-randomize") as HTMLButtonElement
    val actorSettingsDiv = document.getElementById("actor-settings") as HTMLDivElement
    val addActorButton = document.getElementById("add-actor-button") as HTMLButtonElement
    val removeActorButton = document.getElementById("remove-actor-button") as HTMLButtonElement
    val bossSelect = document.getElementById("boss-select").singleSelect()
    val strategyTypeSelect = document.getElementById("strategy-type-select").singleSelect()
    val strategyContainer = document.getElementById("strategy-container") as HTMLDivElement
    val bossStrategyContainer = document.getElementById("boss-strategy-container") as HTMLDivElement
    val simulateButton = document.getElementById("simulate-button") as HTMLButtonElement
    val cancelButton = document.getElementById("cancel-button") as HTMLButtonElement
    val eventBonusInput = document.getElementById("event-bonus-input").integerInput(0)
    val eventMultiplierInput = document.getElementById("event-multiplier-input").integerInput(100)
    val bossHpInput = document.getElementById("boss-hp-input").integerInput(-1)
    val turnsInput = document.getElementById("turns-input").integerInput(3)
    val iterationsInput = document.getElementById("iterations-input").integerInput(100000)
    val strategyEditor = CodeMirror(strategyContainer, js("{lineNumbers: true, mode: null}"))
    val bossStrategyTypeSelect = document.getElementById("boss-strategy-type-select").singleSelect()
    val bossStrategyCollapse = document.getElementById("boss-strategy-collapse").collapse()
    val toastsCheckbox = document.getElementById("toasts-checkbox") as HTMLInputElement
    val toastContainer = document.getElementById("toast-container") as HTMLDivElement
    val bossStrategyEditor = run {
        // Will not display properly otherwise
        bossStrategyCollapse.show = true
        val value = CodeMirror(bossStrategyContainer, js("{lineNumbers: true, mode: null}"))
        bossStrategyCollapse.show = false
        value
    }

    private fun toastElement(name: String, color: String = "grey", value: DIV.() -> Unit) =
        document.create.div("toast") {
            attributes["role"] = "alert"
            div("toast-header") {
                svg("rounded me-2") {
                    attributes["width"] = "20"
                    attributes["height"] = "20"
                    attributes["xmlns"] = "http://www.w3.org/2000/svg"
                    attributes["preserveAspectRatio"] = "xMidYMid slice"
                    attributes["focusable"] = "false"
                    HTMLTag("rect", consumer, mapOf(), "http://www.w3.org/2000/svg", true, false).visit {
                        attributes["width"] = "100%"
                        attributes["height"] = "100%"
                        attributes["fill"] = color
                    }
                }
                strong("me-auto") {
                    +name
                }
                button(type = ButtonType.button, classes = "btn-close") {
                    attributes["data-bs-dismiss"] = "toast"
                }
            }
            div("toast-body", value)
        }

    fun toast(name: String, value: String, color: String = "grey", autohide: Boolean = true): Bootstrap.Toast? {
        if (!toastsCheckbox.checked) return null
        val element = toastElement(name, color) { +value }
        toastContainer.appendChild(element)
        return Bootstrap.Toast(element, jsObject { this.autohide = autohide }).also {
            it.show()
        }
    }

    fun toast(name: String, color: String = "grey", autohide: Boolean = true, block: DIV.() -> Unit): Bootstrap.Toast? {
        if (!toastsCheckbox.checked) return null
        val element = toastElement(name, color, block)
        toastContainer.appendChild(element)
        return Bootstrap.Toast(element, jsObject { this.autohide = autohide }).also {
            it.show()
        }
    }

    private var hasShownVersionWarning = false
    private suspend fun warnIfServerVersionMismatched() {
        val serverVersion = simulator.version()
        if (version != serverVersion && !hasShownVersionWarning) {
            toast("Warning", "Client version does not match server version.", "yellow", autohide = false)
            versionLink.textContent = "client ${version} / server $serverVersion"
            hasShownVersionWarning = true
        } else {
            versionLink.textContent = version.toString()
        }
    }

    suspend fun start() {
        warnIfServerVersionMismatched()

        val compressor = LZString
        val baseHref = "${window.location.protocol}//${window.location.host}${window.location.pathname}"

        fun updateUrlForSetup(setup: SimulationParameters) {
            val newUrl = "$baseHref?options=${compressor.compressToEncodedURIComponent(json.encodeToString(setup))}"
            if (newUrl != window.location.href) {
                if (newUrl.length <= 8192) {
                    window.history.pushState(null, "", newUrl)
                } else {
                    toast("Warning", "Url not updated due to high configuration size.", "yellow")
                }
            }
        }

        val features = simulator.features()
        val options = simulator.options()

        val commonText = options.commonText.associateBy { it.id }
        val bosses = options.bosses.associateBy { it.id }
        val strategies = options.strategyTypes.associateBy { it.id }
        val bossStrategies = options.bossStrategyTypes.associateBy { it.id }
        val songEffects = mapOf("none" to (commonText["none"] ?: SimulationOption("none",
            emptyMap()))) + options.songEffects.associateBy { it.id }
        val conditions = options.conditions.associateBy { it.id }
        val dresses = options.dresses.associateBy { it.id }
        val memoirs = options.memoirs.associateBy { it.id }

        var locale = options.locales.keys.first()

        fun localized(value: String, fallback: String) = commonText[value]?.get(locale) ?: fallback

        fun updateGuestStyling() {
            val optionDivs = actorSettingsDiv.children.asList()
            optionDivs.forEach { options ->
                val borderDiv = options.getElementsByClassName("border")[0] as HTMLDivElement
                borderDiv.addClass("border-2")
                borderDiv.removeClass("border-4")
                borderDiv.removeClass("border-warning")
            }
            if (guestCheckbox.checked) {
                optionDivs.firstOrNull()?.let { options ->
                    val borderDiv = options.getElementsByClassName("border")[0] as HTMLDivElement
                    borderDiv.removeClass("border-2")
                    borderDiv.addClass("border-4")
                    borderDiv.addClass("border-warning")
                }
            }
        }

        var actorIdCounter = 0
        fun addActor() {
            val actorId = actorIdCounter++
            actorSettingsDiv.appendChild(
                document.create.div("row actor-options") {
                    id = "actor-options-$actorId"
                    div("col-12 my-2") {
                        div("border border-2 rounded") {
                            div("row mx-1 mt-1") {
                                div("col px-1 mb-2 actor-drag-handle") {
                                    i("bi bi-arrows-move")
                                }
                                div("col-auto px-1 pb-1") {
                                    button(type = ButtonType.button, classes = "btn-close") {
                                        id = "actor-delete-$actorId"
                                    }
                                }
                            }
                            val collapseId = "actor-details-collapse-$actorId"
                            div("row mx-2 mb-2") {
                                div("col-9 col-md-10 my-2") {
                                    val inputId = "actor-name-$actorId"
                                    label("form-label text-actor-name") {
                                        htmlFor = inputId
                                        +localized(".text-actor-name", "Name")
                                    }
                                    input(InputType.text, classes = "form-control actor-name") {
                                        id = inputId
                                    }
                                }
                                div("col-3 col-md-2 my-2 pt-3 d-grid") {
                                    button(type = ButtonType.button, classes = "btn btn-outline-secondary text-actor-details") {
                                        attributes["data-bs-toggle"] = "collapse"
                                        attributes["data-bs-target"] = "#$collapseId"
                                        +localized(".text-actor-details", "Details")
                                    }
                                }
                            }
                            div("collapse show") {
                                id = collapseId
                                div("row mx-2 mb-2") {
                                    div("col-12 my-2") {
                                        val selectId = "actor-dress-$actorId"
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
                                    div("col-6 col-md-4 my-2") {
                                        val inputId = "actor-level-$actorId"
                                        label("form-label text-actor-level") {
                                            htmlFor = inputId
                                            +localized(".text-actor-level", "Actor Level")
                                        }
                                        input(InputType.text, classes = "form-control actor-level") {
                                            id = inputId
                                            placeholder = "80"
                                        }
                                    }
                                    div("col-6 col-md-4 my-2") {
                                        val selectId = "actor-rarity-$actorId"
                                        label("form-label text-actor-rarity") {
                                            htmlFor = selectId
                                            +localized(".text-actor-rarity", "Stars")
                                        }
                                        select(classes = "form-select actor-rarity") {
                                            id = selectId
                                            option {
                                                value = "6"
                                                +"6"
                                                selected = true
                                            }
                                            option {
                                                value = "5"
                                                +"5"
                                            }
                                            option {
                                                value = "4"
                                                +"4"
                                            }
                                            option {
                                                value = "3"
                                                +"3"
                                            }
                                            option {
                                                value = "2"
                                                +"2"
                                            }
                                        }
                                    }
                                    div("col-12 col-md-4 my-2") {
                                        val selectId = "actor-remake-$actorId"
                                        label("form-label text-actor-remake") {
                                            htmlFor = selectId
                                            +localized(".text-actor-remake", "Remake Level")
                                        }
                                        select(classes = "form-select actor-remake") {
                                            id = selectId
                                            option {
                                                value = "0"
                                                +"0"
                                                selected = true
                                            }
                                            option {
                                                value = "1"
                                                +"1"
                                            }
                                            option {
                                                value = "2"
                                                +"2"
                                            }
                                            option {
                                                value = "3"
                                                +"3"
                                            }
                                            option {
                                                value = "4"
                                                +"4"
                                            }
                                        }
                                    }
                                    div("col-6 col-md-6 col-lg-3 my-2") {
                                        val inputId = "actor-unit-skill-$actorId"
                                        label("form-label text-unit-skill-level") {
                                            htmlFor = inputId
                                            +localized(".text-unit-skill-level", "Unit Skill Level")
                                        }
                                        input(InputType.text, classes = "form-control actor-unit-skill") {
                                            id = inputId
                                            placeholder = "21"
                                        }
                                    }
                                    div("col-6 col-md-6 col-lg-3 my-2") {
                                        val inputId = "actor-friendship-$actorId"
                                        label("form-label text-actor-friendship") {
                                            htmlFor = inputId
                                            +localized(".text-actor-friendship", "Bond Level")
                                        }
                                        input(InputType.text, classes = "form-control actor-friendship") {
                                            id = inputId
                                            placeholder = "30"
                                        }
                                    }
                                    div("col-6 col-md-6 col-lg-3 my-2") {
                                        val selectId = "actor-rank-$actorId"
                                        label("form-label text-actor-rank") {
                                            htmlFor = selectId
                                            +localized(".text-actor-rank", "Rank")
                                        }
                                        select(classes = "form-select actor-rank") {
                                            id = selectId
                                            option {
                                                value = "9"
                                                +"9"
                                                selected = true
                                            }
                                            option {
                                                value = "8"
                                                +"8"
                                            }
                                            option {
                                                value = "7"
                                                +"7"
                                            }
                                            option {
                                                value = "6"
                                                +"6"
                                            }
                                            option {
                                                value = "5"
                                                +"5"
                                            }
                                            option {
                                                value = "4"
                                                +"4"
                                            }
                                            option {
                                                value = "3"
                                                +"3"
                                            }
                                            option {
                                                value = "2"
                                                +"2"
                                            }
                                            option {
                                                value = "1"
                                                +"1"
                                            }
                                        }
                                    }
                                    div("col-6 col-md-6 col-lg-3 my-2") {
                                        val selectId = "actor-rank-panel-pattern-$actorId"
                                        label("form-label text-actor-rank-panel-pattern") {
                                            htmlFor = selectId
                                            +localized(".text-actor-rank-panel-pattern", "Rank Panel Pattern")
                                        }
                                        select(classes = "form-select actor-rank-panel-pattern") {
                                            id = selectId
                                            option {
                                                value = "Full"
                                                +localized("full-rank-panels", "Full")
                                                selected = true
                                            }
                                            option {
                                                value = "Upper"
                                                +localized("upper-rank-panels", "Upper")
                                            }
                                            option {
                                                value = "Lower"
                                                +localized("lower-rank-panels", "Lower")
                                            }
                                            option {
                                                value = "None"
                                                +localized("none-rank-panels", "None")
                                            }
                                        }
                                    }
                                    div("col-12 col-md-6 my-2") {
                                        val selectId = "actor-memoir-$actorId"
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
                                        val inputId = "actor-memoir-level-$actorId"
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
                                        val selectId = "actor-memoir-unbind-$actorId"
                                        label("form-label text-memoir-unbind") {
                                            htmlFor = selectId
                                            +localized(".text-memoir-unbind", "Memoir Unbind")
                                        }
                                        select(classes = "form-select actor-memoir-unbind") {
                                            id = selectId
                                            option {
                                                value = "0"
                                                +"0"
                                            }
                                            option {
                                                value = "1"
                                                +"1"
                                            }
                                            option {
                                                value = "2"
                                                +"2"
                                            }
                                            option {
                                                value = "3"
                                                +"3"
                                            }
                                            option {
                                                value = "4"
                                                +"4"
                                                selected = true
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
            )
            updateGuestStyling()
            js("$('.selectpicker').selectpicker()")
            (document.getElementById("actor-delete-$actorId") as HTMLButtonElement).addEventListener("click", {
                (document.getElementById("actor-options-$actorId") as HTMLDivElement).remove()
                updateGuestStyling()
            })
        }

        fun removeActor() {
            actorSettingsDiv.lastChild?.let { actorSettingsDiv.removeChild(it) }
        }

        fun getSetup(): SimulationParameters {
            val songSettings = document
                .getElementById("song-settings")!!
                .getElementsByClassName("song-effect-group").asList().map { options ->
                    SongEffect(options).parameters
                }
            val actors = actorSettingsDiv.getElementsByClassName("actor-options").asList().map { options ->
                ActorOptions(options).parameters
            }
            return SimulationParameters(
                maxTurns = turnsInput.value,
                maxIterations = iterationsInput.value,
                team = if (guestCheckbox.checked) actors.drop(1) else actors,
                guest = if (guestCheckbox.checked) actors.firstOrNull() else null,
                song = SongParameters(
                    songSettings.dropLast(1).filterNotNull(),
                    songSettings.last(),
                ),
                strategy = StrategyParameter(
                    strategyTypeSelect.value,
                    strategyEditor.getValue() as String,
                ),
                bossStrategy = StrategyParameter(
                    bossStrategyTypeSelect.value,
                    bossStrategyEditor.getValue() as String,
                ).takeIf { bossStrategyCollapse.show },
                boss = bossSelect.value,
                bossHp = if (bossHpInput.value > 0) bossHpInput.value else null,
                additionalEventBonus = eventBonusInput.value,
                eventMultiplier = eventMultiplierInput.value,
                seed = seedInput.value,
            )
        }

        fun setSetup(setup: SimulationParameters) = setup.run {
            turnsInput.value = maxTurns
            iterationsInput.value = maxIterations
            while (actorSettingsDiv.lastChild != null) {
                removeActor()
            }
            val team = if (guest != null) listOf(guest) + this.team else this.team
            guestCheckbox.checked = guest != null
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
            if (bossStrategy != null) {
                bossStrategyCollapse.show = true
                bossStrategyTypeSelect.value = bossStrategy.type
                bossStrategyEditor.setValue(bossStrategy.value)
            } else {
                bossStrategyCollapse.show = false
            }
            bossSelect.value = boss
            if (bossHp != null) {
                bossHpInput.value = bossHp
            } else {
                bossHpInput.clear()
            }
            eventBonusInput.value = additionalEventBonus
            eventMultiplierInput.value = eventMultiplier
            seedInput.value = seed
            updateGuestStyling()
            refreshSelectPicker()
            updateUrlForSetup(setup)
        }

        if (features.shutdown) {
            shutdownContainer.removeClass("d-none")
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
            updateUrlForSetup(getSetup())
        })

        yamlImportCheckbox.addEventListener("click", {
            updateExportText()
        })

        guestCheckbox.addEventListener("click", {
            updateGuestStyling()
        })

        exportText.addEventListener("click", {
            exportText.focus()
            exportText.select()
        })

        doImportButton.addEventListener("click", {
            try {
                setSetup(loadYamlDeserialize(importText.value))
                toast("Import", "Import completed.", "green")
            } catch (e: Throwable) {
                toast("Import", "Import failed.", "red")
            }
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
        bossStrategyTypeSelect.populate(bossStrategies, locale)
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
                warnIfServerVersionMismatched()
                try {
                    val setup = getSetup()
                    simulation = simulator.simulate(setup)
                    updateUrlForSetup(setup)
                } catch (e: Throwable) {
                    toast("Simulate", "Simulation failed to start.", "red")
                    simulateButton.disabled = false
                    cancelButton.disabled = true
                    return@launch
                }
                toast("Simulate", "Simulation started.", "green")
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
            val rankPanelOptions = listOfNotNull(
                commonText["full-rank-panels"]?.let { "Full" to it },
                commonText["upper-rank-panels"]?.let { "Upper" to it },
                commonText["lower-rank-panels"]?.let { "Lower" to it },
                commonText["none-rank-panels"]?.let { "None" to it },
            ).toMap()

            bossSelect.localize(bosses, locale)
            strategyTypeSelect.localize(strategies, locale)
            bossStrategyTypeSelect.localize(bossStrategies, locale)
            document.getElementsByClassName("actor-rank-panel-pattern")
                .asList()
                .filterIsInstance<HTMLSelectElement>()
                .forEach { select ->
                    SingleSelect(select).localize(rankPanelOptions, locale)
                }
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

        Sortable.Sortable.create(
            actorSettingsDiv,
            jsObject {
                animation = 150
                swapThreshold = 0.75
                handle = ".actor-drag-handle"
                onEnd = ::updateGuestStyling
            }
        )

        fun updateSetupFromUrl() {
            val urlOptions = window.location.search.substring(1).split("&").firstOrNull {
                it.matches("options=.*")
            }?.split("=")?.lastOrNull()
            if (urlOptions != null) {
                try {
                    setSetup(json.decodeFromString(compressor.decompressFromEncodedURIComponent(urlOptions)))
                    toast("Import", "Updated configuration from url.", "green")
                } catch (e: Throwable) {
                    toast("Error", "Failed to update configuration from url.", "red")
                }
            }
        }

        updateSetupFromUrl()

        updateLocaleText()
        refreshSelectPicker()

        window.onpopstate = {
            updateSetupFromUrl()
        }

        toast("Ready", "Initialization complete.", "green")

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
                        val endPlot = document.getElementById("end-plot")!!
                        val wipePlot = document.getElementById("wipe-plot")!!

                        val currentIterationsText = result.currentIterations.toString()
                        val maxIterationsText = result.maxIterations.toString()
                        val progressText =
                            "${(result.currentIterations.toDouble() / result.maxIterations * 100).toFixed(2)}%"
                        val runtimeText = if (result.runtime != null) " [${result.runtime.toFixed(5)}s]" else ""
                        val progressDisplay =
                            "Progress: ${" ".repeat(maxIterationsText.length - currentIterationsText.length)}$currentIterationsText/$maxIterationsText ($progressText)$runtimeText"
                        var iterationResultsText = ResultEntry("All").apply {
                            iterationResults.forEach {
                                add(it)
                            }
                        }.format()
                        val simpleResults = iterationResults
                            .groupBy { it.result }
                            .map { (result, values) -> result to values.sumOf { it.count } }
                            .sortedBy { (result, _) -> result }
                        if (iterationResults.any { it.tags.isNotEmpty() }) {
                            iterationResultsText += "\n\n" + ResultEntry("All (Simple)").apply {
                                simpleResults.forEach { (type, count) ->
                                    add(SimulationResultValue(emptyList(), type, count))
                                }
                            }.format()
                        }
                        resultsText.textContent = progressDisplay + "\n\n" + iterationResultsText

                        // Plotly goes upwards from the y-axis, so entries have to be reversed
                        val plotEntries = simpleResults.reversed().toMap()
                        react(
                            graphDiv = resultsPlot,
                            data = arrayOf(
                                jsObject {
                                    type = "bar"
                                    x = plotEntries.values.toTypedArray()
                                    y = plotEntries.keys.map { it.toString() }.toTypedArray()
                                    orientation = "h"
                                    marker = jsObject {
                                        color = plotEntries.keys.map { it.color }.toTypedArray()
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
                        listOf(
                            SimulationMarginResultType.End to endPlot,
                            SimulationMarginResultType.Wipe to wipePlot,
                        ).forEach { (resultType, element) ->
                            val data = result.marginResults[resultType] ?: emptyMap()
                            react(
                                graphDiv = element,
                                data = arrayOf(
                                    jsObject {
                                        type = "bar"
                                        x = data.keys.toTypedArray()
                                        y = data.values.toTypedArray()
                                        marker = jsObject {
                                            color = resultType.color
                                        }
                                    } as Any
                                ),
                                layout = jsObject {
                                    title = "${resultType.name} Margin"
                                    height = 400
                                    margin = jsObject {
                                        l = 60
                                        r = 60
                                    }
                                    bargap = 0
                                } as Any,
                                config = jsObject {
                                    responsive = true
                                } as Any,
                            )
                            if (data.isEmpty()) {
                                element.addClass("d-none")
                            } else {
                                element.removeClass("d-none")
                            }
                        }
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
                            if (result.error != null) {
                                toast("Simulate", "Simulation completed with errors.", "orange")
                            } else if (result.cancelled) {
                                toast("Cancel", "Simulation cancelled.", "yellow")
                            } else {
                                toast("Simulate", "Simulation completed successfully.", "green")
                            }
                        }
                    }
                }
                delay(1000)
            }
        }
    }

    companion object {
        val version = SimulatorVersion(MAVEN_GROUP, VERSION, GIT_SHA)
    }
}

fun Double.toFixed(digits: Int) = asDynamic().toFixed(digits) as String

class ResultEntry(
    val name: String,
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

    private fun formatRecursive(): List<String> = when (children.size) {
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
                "$name: $includedCount ($percentParent% of parent, $percentRoot% of all) included, $excludedCount excluded, $totalCount total"
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
