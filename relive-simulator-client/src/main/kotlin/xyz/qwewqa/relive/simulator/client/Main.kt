package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.dom.addClass
import kotlinx.dom.hasClass
import kotlinx.dom.removeClass
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.*
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.ActorOptions.Companion.rankPanelIds
import xyz.qwewqa.relive.simulator.client.Plotly.react
import xyz.qwewqa.relive.simulator.common.*
import kotlin.random.Random

suspend fun main() {
    SimulatorClient(RemoteSimulator(URL("${window.location.protocol}//${window.location.host}"))).start()
}

@OptIn(DelicateCoroutinesApi::class, kotlinx.serialization.ExperimentalSerializationApi::class)
class SimulatorClient(val simulator: Simulator) {
    var simulation: Simulation? = null
    var done = false

    var interactiveSimulation: InteractiveSimulation? = null

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
    val sortByPositionButton = document.getElementById("sort-by-position-button") as HTMLButtonElement
    val expandAllActorButton = document.getElementById("expand-all-actor-button") as HTMLButtonElement
    val collapseAllActorButton = document.getElementById("collapse-all-actor-button") as HTMLButtonElement
    val bossSelect = document.getElementById("boss-select").singleSelect()
    val strategyTypeSelect = document.getElementById("strategy-type-select").singleSelect()
    val strategyContainer = document.getElementById("strategy-container") as HTMLDivElement
    val bossStrategyContainer = document.getElementById("boss-strategy-container") as HTMLDivElement
    val simulateButton = document.getElementById("simulate-button") as HTMLButtonElement
    val cancelButton = document.getElementById("cancel-button") as HTMLButtonElement
    val interactiveButton = document.getElementById("interactive-button") as HTMLButtonElement
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
    val interactiveContainer = document.getElementById("interactive-container") as HTMLDivElement
    val interactiveStatusContainer = document.getElementById("interactive-status-container") as HTMLDivElement
    val interactiveLog = document.getElementById("interactive-log") as HTMLDivElement
    val interactiveInput = document.getElementById("interactive-input").textInput()
    val interactiveSendButton = document.getElementById("interactive-send-button") as HTMLButtonElement

    val loadPresetSelect = document.getElementById("load-preset-select").singleSelect()
    val loadPresetConfirmButton = document.getElementById("load-preset-button") as HTMLButtonElement
    val deletePresetButton = document.getElementById("delete-preset-button") as HTMLButtonElement
    val presetNameInput = document.getElementById("preset-name-input").textInput()
    val savePresetConfirmButton = document.getElementById("save-preset-button") as HTMLButtonElement

    val loadoutPresets = json
        .decodeFromString<Map<String, PlayerLoadoutParameters>>(localStorage.get("loadout-presets") ?: "{}")
        .toMutableMap()

    fun saveLoadoutPresets() {
        localStorage.set("loadout-presets", json.encodeToString(loadoutPresets))
    }

    var activeActorOptions: ActorOptions? = null

    private fun toastElement(color: String = "grey", dismissible: Boolean, value: DIV.() -> Unit) =
        document.create.div("toast") {
            attributes["role"] = "alert"
            div("toast-body") {
                style = "border-left: 4px solid $color;border-radius: inherit;display: flex;justify-content: space-between;"
                value()
                if (dismissible) {
                    button(type = ButtonType.button, classes = "btn-close") {
                        style = "margin-left: 0.2em;"
                        attributes["data-bs-dismiss"] = "toast"
                    }
                }
            }
        }

    fun toast(name: String, value: String, color: String = "grey", autohide: Boolean = true, dismissible: Boolean = !autohide): Bootstrap.Toast? {
        if (!toastsCheckbox.checked) return null
        val element = toastElement(color, dismissible) {
            div {
                b { +name }
                +" "
                +value
            }
        }
        toastContainer.appendChild(element)
        return Bootstrap.Toast(element, jsObject { this.autohide = autohide; this.delay = 1500 }).also {
            it.show()
        }
    }

    fun toast(name: String, color: String = "grey", autohide: Boolean = true, dismissible: Boolean = !autohide, block: DIV.() -> Unit): Bootstrap.Toast? {
        if (!toastsCheckbox.checked) return null
        val element = toastElement(color, dismissible) {
            div {
                b { +name }
                br()
                block()
            }
        }
        toastContainer.appendChild(element)
        return Bootstrap.Toast(element, jsObject { this.autohide = autohide; this.delay = 1500 }).also {
            it.show()
        }
    }

    private suspend fun updateVersionString() {
        val serverVersion = simulator.version()
        if (version != serverVersion) {
            if (serverVersion.apiVersion != version.apiVersion) {
                toast("Error", "Client version does not match server version.", "red", autohide = false)
            }
            versionLink.textContent = "client $version / server $serverVersion"
        } else {
            versionLink.textContent = version.toString()
        }
    }

    suspend fun start() {
        updateVersionString()

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
        val songEffects = mapOf(
            "none" to (commonText["none"] ?: SimulationOption(
                "none",
                emptyMap()
            ))
        ) + options.songEffects.associateBy { it.id }
        val conditions = options.conditions.associateBy { it.id }
        val dresses = options.dresses.associateBy { it.id }
        val remakeSkills = options.remakeSkills.associateBy { it.id }
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
            val collapseId = "actor-details-collapse-$actorId"
            actorSettingsDiv.appendChild(
                document.create.div("row actor-options") {
                    id = "actor-options-$actorId"
                    div("col-12 my-2") {
                        div("border border-2 rounded") {
                            div("row mx-1 mt-1") {
                                style = "margin-bottom: -1rem;"
                                div("col px-1 mb-2 actor-drag-handle") {
                                    i("bi bi-arrows-move")
                                }
                                div("col-auto px-1 pb-1") {
                                    button(type = ButtonType.button, classes = "btn-close") {
                                        id = "actor-delete-$actorId"
                                        onClickFunction = {
                                            (document.getElementById("actor-options-$actorId") as HTMLDivElement).remove()
                                            updateGuestStyling()
                                        }
                                    }
                                }
                            }
                            div("row mx-2 mb-2") {
                                div("col-8 col-md-10 my-2") {
                                    val inputId = "actor-name-$actorId"
                                    label("form-label text-actor-name") {
                                        htmlFor = inputId
                                        +localized(".text-actor-name", "Name")
                                    }
                                    input(InputType.text, classes = "form-control actor-name") {
                                        id = inputId
                                    }
                                }
                                div("col-4 col-md-2 my-2 pt-3 d-grid") {
                                    button(
                                        type = ButtonType.button,
                                        classes = "btn btn-outline-secondary text-actor-details"
                                    ) {
                                        attributes["data-bs-toggle"] = "collapse"
                                        attributes["data-bs-target"] = "#$collapseId"
                                        +localized(".text-actor-details", "Details")
                                    }
                                }
                            }
                            div("collapse actor-details-collapse") {
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
                                                    attributes["data-content"] = "${
                                                        if (it.imagePath != null) {
                                                            "<img style=\"height: 1.65em; margin-top: -0.2em\" src=\"${it.imagePath}\"> "
                                                        } else {
                                                            ""
                                                        }
                                                    }${it[locale]}"
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
                                            attributes["data-prev-value"] = "0"
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
                                            onChangeFunction = {
                                                val opt = ActorOptions(
                                                    document.getElementById("actor-options-$actorId") as Element
                                                )
                                                val prev = opt.remake.element.attributes["data-prev-value"]
                                                    ?.value?.toInt() ?: 0
                                                val params = opt.parameters
                                                val newLevel = if (params.level == 20 + 10 * params.rarity + 5 * prev) {
                                                    20 + 10 * params.rarity + 5 * params.remake
                                                } else {
                                                    params.level
                                                }
                                                val newFriendship = if (params.friendship == 5 * params.rarity + 5 * prev) {
                                                    5 * params.rarity + 5 * params.remake
                                                } else {
                                                    params.friendship
                                                }
                                                opt.parameters = params.copy(
                                                    level = newLevel,
                                                    friendship = newFriendship
                                                )
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
                                            rankPanelIds.entries.forEachIndexed { i, (name, id) ->
                                                option {
                                                    value = name
                                                    +localized(id, name)
                                                    selected = i == 0
                                                }
                                            }
                                        }
                                    }
                                    div("col-12 my-2") {
                                        val selectId = "actor-remake-skill-$actorId"
                                        label("form-label text-remake-skill") {
                                            htmlFor = selectId
                                            +localized(".text-remake-skill", "Remake Skill")
                                        }
                                        select("selectpicker form-control actor-remake-skill") {
                                            id = selectId
                                            attributes["data-live-search"] = "true"
                                            attributes["disabled"] = "disabled"
                                            options.remakeSkills.forEach {
                                                option {
                                                    attributes["data-content"] = "${
                                                        if (it.imagePath != null) {
                                                            "<img style=\"height: 1.65em; margin-top: -0.2em\" src=\"${it.imagePath}\"> "
                                                        } else {
                                                            ""
                                                        }
                                                    }${it[locale]}"
                                                    value = it.id
                                                    +it[locale]
                                                }
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
                                                    val name = it[locale]
                                                    val description = it.description?.get(locale)
                                                    attributes["data-content"] = "${
                                                        if (it.imagePath != null) {
                                                            "<img style=\"height: 1.65em; margin-top: -0.2em\" src=\"${it.imagePath}\"> "
                                                        } else {
                                                            ""
                                                        }
                                                    }$name${
                                                        if (description != null) {
                                                            "<small class=\"text-muted select-option-subtext\">$description</small>"
                                                        } else {
                                                            ""
                                                        }
                                                    }"
                                                    value = it.id
                                                    +name
                                                    attributes["data-tokens"] =
                                                        it.tags?.get(locale)?.joinToString(" ") ?: ""
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
                                            placeholder = "80"
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
                                            attributes["data-prev-value"] = "4"
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
                                        onChangeFunction = {
                                            val opt = ActorOptions(
                                                document.getElementById("actor-options-$actorId") as Element
                                            )
                                            val prev = opt.memoirUnbind.element.attributes["data-prev-value"]
                                                ?.value?.toInt() ?: 0
                                            val params = opt.parameters
                                            // only works for 4* memos, which is almost all of them
                                            val newMemoirLevel = if (params.memoirLevel == 60 + 5 * prev) {
                                                60 + 5 * params.memoirLimitBreak
                                            } else {
                                                params.memoirLevel
                                            }
                                            opt.parameters = params.copy(
                                                memoirLevel = newMemoirLevel
                                            )
                                        }
                                    }
                                    div("col-12 my-2") {
                                        button(
                                            type = ButtonType.button,
                                            classes = "btn btn-outline-secondary text-actor-preset-min"
                                        ) {
                                            id = "actor-preset-min-$actorId"
                                            +"Min"
                                            onClickFunction = {
                                                val opt = ActorOptions(
                                                    document.getElementById("actor-options-$actorId") as Element
                                                )
                                                opt.parameters = opt.parameters.copy(
                                                    level = 1,
                                                    rarity = 4,
                                                    remake = 0,
                                                    friendship = 1,
                                                    rank = 1,
                                                    rankPanelPattern = List(8) { false },
                                                    memoirLevel = 1,
                                                )
                                            }
                                        }
                                        +" "
                                        button(
                                            type = ButtonType.button,
                                            classes = "btn btn-outline-secondary text-actor-preset-max"
                                        ) {
                                            id = "actor-preset-max-$actorId"
                                            +"Max"
                                            onClickFunction = {
                                                val opt = ActorOptions(
                                                    document.getElementById("actor-options-$actorId") as Element
                                                )
                                                val param = opt.parameters
                                                opt.parameters = param.copy(
                                                    level = 80 + 5 * param.remake,
                                                    rarity = 6,
                                                    friendship = 30 + 5 * param.remake,
                                                    rank = 9,
                                                    rankPanelPattern = List(8) { true },
                                                    memoirLevel = 60 + 5 * param.memoirLimitBreak,
                                                )
                                            }
                                        }
                                        +" "
                                        button(
                                            type = ButtonType.button,
                                            classes = "btn btn-outline-secondary text-save-preset-short"
                                        ) {
                                            id = "actor-save-preset-$actorId"
                                            +localized(".text-save-preset-short", "Save")
                                            onClickFunction = {
                                                val opt = ActorOptions(
                                                    document.getElementById("actor-options-$actorId") as Element
                                                )
                                                activeActorOptions = opt
                                                Bootstrap.Modal(document.getElementById("save-preset-modal")).show()
                                            }
                                        }
                                        +" "
                                        button(
                                            type = ButtonType.button,
                                            classes = "btn btn-outline-secondary text-load-preset-short"
                                        ) {
                                            id = "actor-load-preset-$actorId"
                                            +localized(".text-load-preset-short", "Load")
                                            onClickFunction = {
                                                activeActorOptions = ActorOptions(
                                                    document.getElementById("actor-options-$actorId") as Element
                                                )
                                                val dressMapping = options.dresses.associateBy { it.id }
                                                loadPresetSelect.clear()
                                                loadPresetSelect.element.run {
                                                    loadoutPresets.keys.sorted().forEach { id ->
                                                        val split = id.split(":::", limit = 2)
                                                        val dressName = split[0]
                                                        val presetName = split[1]
                                                        add(
                                                            document.create.option {
                                                                value = id
                                                                attributes["data-content"] = "<img style=\"height: 1.65em; margin-top: -0.2em\" src=\"${dressMapping[dressName]?.imagePath}\"> $presetName"
                                                                +presetName
                                                            } as HTMLOptionElement
                                                        )
                                                    }
                                                }
                                                loadPresetSelect.refreshSelectPicker()
                                                Bootstrap.Modal(document.getElementById("load-preset-modal")).show()
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
            Bootstrap.Collapse(document.getElementById(collapseId), jsObject { toggle = true })
            js("$('.selectpicker').selectpicker()")
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
            }.map { it.copy(name = it.name.replace(Regex("\\s"), "_")) }
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
            val team = listOfNotNull(guest) + this.team
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
                bossStrategyTypeSelect.value = bossStrategy!!.type
                bossStrategyEditor.setValue(bossStrategy!!.value)
            } else {
                bossStrategyCollapse.show = false
            }
            bossSelect.value = boss
            if (bossHp != null) {
                bossHpInput.value = bossHp!!
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

        fun updateSetupFromUrl(url: String) {
            val urlOptions = URL(url).search.substring(1).split("&").firstOrNull {
                "options=.*".toRegex().matches(it)
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

        fun updateSetupFromUrl() {
            updateSetupFromUrl(window.location.href)
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
                val data = importText.value
                val trimmed = data.trim()
                if (trimmed.startsWith("http://") || trimmed.startsWith("https://")) {
                    updateSetupFromUrl(trimmed)
                } else {
                    setSetup(loadYamlDeserialize(importText.value))
                    toast("Import", "Import completed.", "green")
                }
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

        sortByPositionButton.addEventListener("click", {
            val setup = getSetup()
            val dressData = options.dresses.associate { it.id to it.data }
            setSetup(setup.copy(team = setup.team.sortedBy { dressData[it.dress]!! }))
        })

        expandAllActorButton.addEventListener("click", {
            document.getElementsByClassName("actor-details-collapse").asList().forEach {
                val collapse = js("bootstrap.Collapse.getInstance")(it)
                collapse.show()
                Unit
            }
        })

        collapseAllActorButton.addEventListener("click", {
            document.getElementsByClassName("actor-details-collapse").asList().forEach {
                val collapse = js("bootstrap.Collapse.getInstance")(it)
                collapse.hide()
                Unit
            }
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
                updateVersionString()
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
        interactiveButton.addEventListener("click", {
            interactiveContainer.removeClass("d-none")
            interactiveContainer.scrollIntoView()
            GlobalScope.launch {
                updateVersionString()
                try {
                    val setup = getSetup()
                    interactiveSimulation = simulator.simulateInteractive(setup)
                    updateUrlForSetup(setup)
                } catch (e: Throwable) {
                    toast("Simulate", "Interactive simulation failed to start.", "red")
                    return@launch
                }
                window.onbeforeunload = {
                    it.preventDefault()
                    it.returnValue = ""
                    ""
                }
                toast("Simulate", "Interactive simulation started.", "green")
            }
        })

        suspend fun sendInteractiveCommand() {
            when (interactiveInput.value.trim()) {
                "bars" -> {
                    if (interactiveStatusContainer.hasClass("d-none")) {
                        interactiveStatusContainer.removeClass("d-none")
                    } else {
                        interactiveStatusContainer.addClass("d-none")
                    }
                }
                "shares" -> {
                    document.getElementsByClassName("damage-shares").asList().forEach {
                        it.removeClass("d-none")
                    }
                }
                "" -> interactiveSimulation?.sendCommand("go")
                else -> interactiveSimulation?.sendCommand(interactiveInput.value)
            }
            interactiveInput.value = ""
        }

        interactiveSendButton.addEventListener("click", {
            GlobalScope.launch {
                sendInteractiveCommand()
            }
        })
        interactiveInput.element.addEventListener("keypress", {
            if ((it as KeyboardEvent).key == "Enter") {
                GlobalScope.launch {
                    sendInteractiveCommand()
                }
            }
        })
        document.addEventListener("sendInteractiveCommand", { e ->
            GlobalScope.launch {
                interactiveSimulation?.sendCommand((e as CustomEvent).detail as String)
            }
        })

        savePresetConfirmButton.addEventListener("click", {
            val param = activeActorOptions?.parameters ?: return@addEventListener
            val name = presetNameInput.value
            presetNameInput.value = ""
            loadoutPresets["${param.dress}:::${name}"] = param
            saveLoadoutPresets()
        })
        loadPresetConfirmButton.addEventListener("click", {
            val preset = loadoutPresets[loadPresetSelect.value] ?: return@addEventListener
            activeActorOptions?.parameters = preset.copy(name = activeActorOptions?.parameters?.name ?: "")
        })
        deletePresetButton.addEventListener("click", {
            loadoutPresets.remove(loadPresetSelect.value)
            saveLoadoutPresets()
        })

        fun updateLocaleText() {
            val rankPanelOptions = rankPanelIds.mapNotNull { (name, id) ->
                commonText[id]?.let { name to it }
            }.toMap()

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
            document.getElementsByClassName("actor-remake-skill")
                .asList()
                .filterIsInstance<HTMLSelectElement>()
                .forEach { select ->
                    SingleSelect(select).localize(remakeSkills, locale)
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

        updateSetupFromUrl()

        updateLocaleText()
        refreshSelectPicker()

        window.onpopstate = {
            updateSetupFromUrl()
        }

        toast("Ready", "Initialization complete.", "green")

        GlobalScope.launch {
            while (true) {
                try {
                    delay(50)
                    interactiveSimulation?.let { sim ->
                        val log = sim.getLog()
                        val data = log?.data
                        if (data != null) {
                            val isScrolledDown = this@SimulatorClient.interactiveLog.let {
                                it.scrollHeight - it.offsetHeight - it.scrollTop < 1.0
                            }
                            this@SimulatorClient.interactiveLog.displayLog(data.entries, interactive = true)
                            if (isScrolledDown) {
                                this@SimulatorClient.interactiveLog.let {
                                    it.scrollTop = it.scrollHeight.toDouble()
                                }
                            }
                            interactiveStatusContainer.displayStatus(data)
                        }
                    }
                } catch (e: Throwable) {
                    delay(2000)
                }
            }
        }

        GlobalScope.launch {
            while (true) {
                try {
                    if (!done) {
                        simulation?.let { sim ->
                            val result = sim.pollResult()
                            val iterationResults = result.results.sortedWith(simulationResultValueComparator)
                            val resultsRow = document.getElementById("results-row") as HTMLDivElement
                            val resultsText = document.getElementById("results-text") as HTMLPreElement
                            val errorRow = document.getElementById("results-error-row") as HTMLDivElement
                            val logRow = document.getElementById("results-log-row") as HTMLDivElement
                            val errorText = document.getElementById("error-text") as HTMLPreElement
                            val logText = document.getElementById("log-text") as HTMLDivElement
                            val resultsPlot = document.getElementById("results-plot")!!
                            val endPlot = document.getElementById("end-plot")!!
                            val wipePlot = document.getElementById("wipe-plot")!!

                            val currentIterationsText = result.currentIterations.toString()
                            val maxIterationsText = result.maxIterations.toString()
                            val progressText =
                                "${(result.currentIterations.toDouble() / result.maxIterations * 100).toFixed(2)}%"
                            val runtimeText = if (result.runtime != null) " [${result.runtime!!.toFixed(5)}s]" else ""
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
                                .sortedWith { a, b -> simulationResultTypeComparator.compare(a.first, b.first) }
                            if (iterationResults.any { it.tags.isNotEmpty() }) {
                                iterationResultsText += "\n\n" + ResultEntry("All (Simple)").apply {
                                    simpleResults.forEach { (type, count) ->
                                        add(SimulationResultValue(emptyList(), type, count))
                                    }
                                }.format()
                            }
                            resultsText.innerHTML = progressDisplay + "\n\n" + iterationResultsText

                            // Plotly goes upwards from the y-axis, so entries have to be reversed
                            val plotEntries = simpleResults.reversed().toMap()
                            react(
                                graphDiv = resultsPlot,
                                data = arrayOf(
                                    jsObject {
                                        type = "bar"
                                        x = plotEntries.values.toTypedArray()
                                        y = plotEntries.keys.map { it.displayName }.toTypedArray()
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
                                logText.displayLog(result.log ?: emptyList(), interactive = false)
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
                } catch (e: Throwable) {
                    delay(2000)
                }
            }
        }
    }

    companion object {
        val version = SimulatorVersion.CURRENT_VERSION
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
