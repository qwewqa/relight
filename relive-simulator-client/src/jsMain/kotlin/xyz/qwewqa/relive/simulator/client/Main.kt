package xyz.qwewqa.relive.simulator.client

import Accessories
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.sessionStorage
import kotlinx.browser.window
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.dom.addClass
import kotlinx.dom.clear
import kotlinx.dom.hasClass
import kotlinx.dom.removeClass
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.InputType
import kotlinx.html.b
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import kotlinx.html.i
import kotlinx.html.id
import kotlinx.html.img
import kotlinx.html.input
import kotlinx.html.js.div
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onContextMenuFunction
import kotlinx.html.label
import kotlinx.html.option
import kotlinx.html.p
import kotlinx.html.role
import kotlinx.html.select
import kotlinx.html.style
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.CustomEvent
import org.w3c.dom.Element
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLPreElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.asList
import org.w3c.dom.clipboard.ClipboardEvent
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.get
import org.w3c.dom.set
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.ActorOptions.Companion.rankPanelIds
import xyz.qwewqa.relive.simulator.client.Plotly.addTraces
import xyz.qwewqa.relive.simulator.client.Plotly.react
import xyz.qwewqa.relive.simulator.client.codemirror.EditorView
import xyz.qwewqa.relive.simulator.client.codemirror.codeMirrorConfig
import xyz.qwewqa.relive.simulator.client.codemirror.foldAll
import xyz.qwewqa.relive.simulator.client.codemirror.loadActorFromClipboard
import xyz.qwewqa.relive.simulator.client.codemirror.saveActorToClipboard
import xyz.qwewqa.relive.simulator.client.codemirror.unfoldAll
import xyz.qwewqa.relive.simulator.client.codemirror.value
import xyz.qwewqa.relive.simulator.common.DataSimulationOption
import xyz.qwewqa.relive.simulator.common.InteractiveLog
import xyz.qwewqa.relive.simulator.common.MarginResult
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters
import xyz.qwewqa.relive.simulator.common.SimulationMarginResultType
import xyz.qwewqa.relive.simulator.common.SimulationOptions
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResult
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.common.SimulationResultValue
import xyz.qwewqa.relive.simulator.common.SimulatorVersion
import xyz.qwewqa.relive.simulator.common.StatisticsSummary
import xyz.qwewqa.relive.simulator.common.StrategyParameter
import xyz.qwewqa.relive.simulator.core.getSimulationOptions
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.dress.Dresses
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoirs
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.set
import kotlin.random.Random

fun main() {
  SimulatorClient(RemoteSimulator(URL("${window.location.protocol}//${window.location.host}")))
      .start()
}

@OptIn(DelicateCoroutinesApi::class, kotlinx.serialization.ExperimentalSerializationApi::class)
class SimulatorClient(val simulator: Simulator) {
  var simulation: Simulation? = null
  var activeSetup: SimulationParameters? = null
  var done = false

  val api = RelightApi(this)

  var interactiveSimulation: InteractiveSimulation? = null

  val versionLink = document.getElementById("version-link") as HTMLAnchorElement
  val versionText = document.getElementById("version-text") as HTMLSpanElement
  val tabNameInput = document.getElementById("tab-name-input") as HTMLInputElement
  val languageSelect = document.getElementById("language-select").singleSelect(false)
  val exportButton = document.getElementById("export-button") as HTMLButtonElement
  val doImportButton = document.getElementById("do-import-button") as HTMLButtonElement
  val yamlImportCheckbox = document.getElementById("import-yaml-checkbox") as HTMLInputElement
  val guestCheckbox = document.getElementById("guest-checkbox") as HTMLInputElement
  val importText = document.getElementById("import-text") as HTMLTextAreaElement
  val exportText = document.getElementById("export-text") as HTMLTextAreaElement
  val seedInput = document.getElementById("seed-input").integerInput(0)
  val seedRandomizeButton = document.getElementById("seed-randomize") as HTMLButtonElement
  val actorTabsDiv = document.getElementById("actor-tabs") as HTMLDivElement
  val actorSettingsDiv = document.getElementById("actor-settings") as HTMLDivElement
  val addActorButton = document.getElementById("add-actor-button") as HTMLButtonElement
  val sortByPositionButton = document.getElementById("sort-by-position-button") as HTMLButtonElement
  val autoNameButton = document.getElementById("auto-name-button") as HTMLButtonElement
  val eventBonusDisplay = document.getElementById("event-bonus-display") as HTMLSpanElement
  val costDisplay = document.getElementById("cost-display") as HTMLSpanElement
  val teamImageButton = document.getElementById("team-image-button") as HTMLButtonElement
  val teamImageModal = document.getElementById("team-image-modal") as HTMLDivElement
  val teamImageModalBs = Bootstrap.Modal(teamImageModal)
  val teamImageContainer = document.getElementById("team-image-container") as HTMLDivElement
  val actIconsButton = document.getElementById("act-icons-button") as HTMLButtonElement
  val actIconsModal = document.getElementById("act-icons-modal") as HTMLDivElement
  val actIconsModalBs = Bootstrap.Modal(actIconsModal)
  val actIconsContainer = document.getElementById("act-icons-container") as HTMLDivElement
  val bossSelect = document.getElementById("boss-select").singleSelect(true)
  val strategyTypeSelect = document.getElementById("strategy-type-select").singleSelect(true)
  val strategyContainer = document.getElementById("strategy-container") as HTMLDivElement
  val bossStrategyContainer = document.getElementById("boss-strategy-container") as HTMLDivElement
  val simulateButton = document.getElementById("simulate-button") as HTMLButtonElement
  val cancelButton = document.getElementById("cancel-button") as HTMLButtonElement
  val eventBonusInput = document.getElementById("event-bonus-input").integerInput(0)
  val eventMultiplierInput = document.getElementById("event-multiplier-input").integerInput(100)
  val bossHpInput = document.getElementById("boss-hp-input").shorthandDoubleInput()
  val bossAttributeSelect = document.getElementById("boss-attribute-select").singleSelect(false)
  val turnsInput = document.getElementById("turns-input").integerInput(3)
  val iterationsInput = document.getElementById("iterations-input").integerInput(100000)
  val strategyEditor = EditorView(codeMirrorConfig(strategyContainer))
  val strategyCollapseAllButton =
      document.getElementById("strategy-collapse-all-button") as HTMLButtonElement
  val strategyExpandAllButton =
      document.getElementById("strategy-expand-all-button") as HTMLButtonElement
  val bossStrategyTypeSelect =
      document.getElementById("boss-strategy-type-select").singleSelect(true)
  val bossStrategyCollapse = document.getElementById("boss-strategy-collapse").collapse()
  val prideCheckbox = document.getElementById("pride-checkbox") as HTMLInputElement
  val toastsCheckbox = document.getElementById("toasts-checkbox") as HTMLInputElement
  val toastContainer = document.getElementById("toast-container") as HTMLDivElement
  val bossStrategyEditor = run {
    // Will not display properly otherwise
    bossStrategyCollapse.show = true
    val value = EditorView(codeMirrorConfig(bossStrategyContainer))
    bossStrategyCollapse.show = false
    value
  }
  val interactiveContainer = document.getElementById("interactive-container") as HTMLDivElement
  val interactiveStatusContainer =
      document.getElementById("interactive-status-container") as HTMLDivElement
  val interactiveLog = document.getElementById("interactive-log") as HTMLDivElement
  val interactiveInput = document.getElementById("interactive-input").textInput()
  val interactiveSendButton =
      document.getElementById("interactive-send-button") as HTMLButtonElement

  val copyActorButton = document.getElementById("copy-actor-button") as HTMLButtonElement
  val pasteActorButton = document.getElementById("paste-actor-button") as HTMLButtonElement
  val duplicateActorButton = document.getElementById("duplicate-actor-button") as HTMLButtonElement

  val shareSetupModal = document.getElementById("share-setup-modal") as HTMLDivElement
  val shareSetupModalBs = Bootstrap.Modal(shareSetupModal)
  val shareSetupImageContainer =
      document.getElementById("share-setup-image-container") as HTMLDivElement
  val shareSetupText = document.getElementById("share-setup-text") as HTMLTextAreaElement
  val shareSetupButton = document.getElementById("share-setup-button") as HTMLButtonElement

  val optionsTab = document.getElementById("options-tab") as HTMLButtonElement
  val interactiveTab = document.getElementById("interactive-tab") as HTMLButtonElement
  val simulateTab = document.getElementById("simulate-tab") as HTMLButtonElement
  val aboutTab = document.getElementById("about-tab") as HTMLButtonElement

  val toInteractiveButtons = document.getElementsByClassName("to-interactive-button")
  val toSimulateButtons = document.getElementsByClassName("to-simulate-button")

  val interactiveLogStartButton =
      document.getElementById("interactive-log-start-button") as HTMLButtonElement
  val interactiveLogUpButton =
      document.getElementById("interactive-log-up-button") as HTMLButtonElement
  val interactiveLogDownButton =
      document.getElementById("interactive-log-down-button") as HTMLButtonElement
  val interactiveLogEndButton =
      document.getElementById("interactive-log-end-button") as HTMLButtonElement

  val interactiveRestartButton =
      document.getElementById("interactive-ui-restart-button") as HTMLButtonElement
  val interactiveSharesButton =
      document.getElementById("interactive-ui-shares-button") as HTMLButtonElement
  val interactiveExportButton =
      document.getElementById("interactive-ui-export-button") as HTMLButtonElement
  val interactiveRewindButton =
      document.getElementById("interactive-ui-rewind-button") as HTMLButtonElement
  val interactiveSeekBackButton =
      document.getElementById("interactive-ui-seek-back-button") as HTMLButtonElement
  val interactiveUndoButton =
      document.getElementById("interactive-ui-undo-button") as HTMLButtonElement
  val interactiveRedoButton =
      document.getElementById("interactive-ui-redo-button") as HTMLButtonElement
  val interactiveSeekForwardButton =
      document.getElementById("interactive-ui-seek-forward-button") as HTMLButtonElement
  val interactiveFastForwardButton =
      document.getElementById("interactive-ui-fast-forward-button") as HTMLButtonElement
  val interactiveGoButton = document.getElementById("interactive-ui-go-button") as HTMLButtonElement

  val resultsRow = document.getElementById("results-row") as HTMLDivElement
  val resultsProgressText = document.getElementById("results-progress-text") as HTMLPreElement
  val resultsText = document.getElementById("results-text") as HTMLPreElement
  val errorRow = document.getElementById("results-error-row") as HTMLDivElement
  val logFilterContainer = document.getElementById("log-filter-container") as HTMLDivElement
  val logRow = document.getElementById("results-log-row") as HTMLDivElement
  val errorText = document.getElementById("error-text") as HTMLPreElement
  val logText = document.getElementById("log-text") as HTMLDivElement
  val interactivePlotsCheckbox =
      document.getElementById("interactive-plots-checkbox") as HTMLInputElement
  val resultsPlot = document.getElementById("results-plot")!!
  val endPlotDamage = document.getElementById("end-plot-damage")!!
  val endPlotDamageBox = document.getElementById("end-plot-damage-box")!!
  val endPlotMargin = document.getElementById("end-plot-margin")!!
  val endPlotMarginBox = document.getElementById("end-plot-margin-box")!!
  val wipePlotDamage = document.getElementById("wipe-plot-damage")!!
  val wipePlotDamageBox = document.getElementById("wipe-plot-damage-box")!!
  val wipePlotMargin = document.getElementById("wipe-plot-margin")!!
  val wipePlotMarginBox = document.getElementById("wipe-plot-margin-box")!!

  val saveResultsButton = document.getElementById("save-results-button") as HTMLButtonElement
  val clearGraphsButton = document.getElementById("clear-graphs-button") as HTMLButtonElement
  val savedResultsRow = document.getElementById("saved-results-row") as HTMLDivElement

  // Ideally this wouldn't be lateinit, but it takes a while, and there are some things we want
  // to start doing before this.
  lateinit var options: SimulationOptions

  val compressor = LZString
  val baseHref = "${window.location.protocol}//${window.location.host}${window.location.pathname}"

  private val maxCost = 400

  private fun selectedActor(): ActorOptions? =
      actorTabsDiv.querySelector(".active-actor-tab")?.let {
        ActorOptions(options, (it as HTMLElement).attributes["data-actor-id"]!!.value.toInt())
      }

  private fun ActorOptions.update() {
    parameters = parameters
    teamUpdate()
  }

  private fun teamUpdate() {
    val setup = getSetup()

    val cost =
        setup.team.sumOf { params ->
          val dressCost = options.dressesById[params.dress]?.data?.cost ?: 0
          val memoirCost = options.memoirsById[params.memoir]?.data?.cost ?: 0
          dressCost + memoirCost
        }
    costDisplay.textContent = cost.toString()
    if (cost > maxCost) {
      costDisplay.addClass("text-danger")
    } else {
      costDisplay.removeClass("text-danger")
    }

    val boss = options.bossesById[setup.boss]
    val dresses = setup.team.map { options.dressesById[it.dress] }
    val eventBonus = boss?.data?.getBonuses(dresses.mapNotNull { it?.data })
    eventBonusDisplay.textContent = eventBonus?.toString() ?: "?"

    updateGuestStyling()
  }

  private fun toastElement(color: String = "grey", value: DIV.() -> Unit) =
      document.create.div("toast") {
        attributes["role"] = "alert"
        div("toast-body") { value() }
      }

  fun toast(
      name: String,
      value: String,
      color: String = "grey",
  ): Bootstrap.Toast? {
    if (!toastsCheckbox.checked) return null
    val element =
        toastElement(color) {
          div(classes = "toast-indicator") { style = "background-color: $color;" }
          div(classes = "toast-content") {
            b {
              +name
              +": "
            }
            +" "
            +value
          }
        }
    element.addEventListener("click", { element.remove() })
    toastContainer.appendChild(element)
    return Bootstrap.Toast(
            element,
            jsObject {
              this.autohide = true
              this.delay = 1500
            })
        .also { it.show() }
  }

  private suspend fun updateVersionString() {
    val serverVersion = simulator.version()
    if (version != serverVersion) {
      if (serverVersion.apiVersion != version.apiVersion) {
        toast("Error", "Client version does not match server version.", "red")
      }
      versionText.textContent = "client $version / server $serverVersion"
    } else {
      versionText.textContent = version.toString()
    }
  }

  var activeActorId: Int? = null
  fun setActiveActor(id: Int?) {
    activeActorId = id
    if (id != null) {
      document.getElementsByClassName("actor-tab-container").multiple<HTMLDivElement>().forEach {
        it.removeClass("active-actor-tab")
        it.removeClass("neutral-actor-tab")
        it.addClass("inactive-actor-tab")
      }
      document.getElementsByClassName("actor-options").multiple<HTMLDivElement>().forEach {
        it.addClass("d-none")
      }
      (document.getElementById("actor-tab-$activeActorId") as? HTMLDivElement)?.apply {
        removeClass("inactive-actor-tab")
        addClass("active-actor-tab")
      }
      (document.getElementById("actor-options-$activeActorId") as? HTMLDivElement)?.apply {
        removeClass("d-none")
      }
    } else {
      document.getElementsByClassName("actor-tab-container").multiple<HTMLDivElement>().forEach {
        it.removeClass("active-actor-tab")
        it.removeClass("inactive-actor-tab")
        it.addClass("neutral-actor-tab")
      }
      document.getElementsByClassName("actor-options").multiple<HTMLDivElement>().forEach {
        it.addClass("d-none")
      }
    }
  }

  data class CachedActorElements(
      val id: Int,
      val tab: Element,
      val options: Element,
  )

  val actorElementCache = mutableListOf<CachedActorElements>()

  var actorIdCounter = 0
  fun addActor(): Int {
    val actorId: Int
    if (actorElementCache.isEmpty()) {
      actorId = actorIdCounter++
      actorTabsDiv.appendChild(
          document.create.div("actor-tab-container") {
            id = "actor-tab-$actorId"
            attributes["data-actor-id"] = actorId.toString()
            div("d-flex flex-column") {
              div {
                style = "position: relative;"
                img(classes = "actor-dress-image") {
                  style = "width: 100%"
                  src = options.dresses.first().imagePath!!
                }
                img(classes = "actor-memoir-image") {
                  style = "position: absolute; right: 2%; bottom: 2%; width: 48%;"
                  src = options.memoirs.first().imagePath!!
                }
                img(classes = "actor-memoir-unbind-image") {
                  style = "position: absolute; right: 2%; bottom: 2%; width: 48%;"
                  src = getMemoirUnbindImagePath(4)
                }
                img(classes = "actor-accessory-image d-none") {
                  style = "position: absolute; right: 2%; top: 2%; width: 38%;"
                  src = options.accessories.first().imagePath!!
                }
                img(classes = "actor-accessory-unbind-image d-none") {
                  style = "position: absolute; right: 2%; top: 2%; width: 38%;"
                  src = getAccessoryUnbindImagePath(0)
                }
                img(classes = "actor-remake-level-image") {
                  style =
                      "position: absolute; bottom: 23%; left: 5%; width: 16%;filter: drop-shadow(0 0 2px darkred);"
                  src = getRemakeLevelVerticalImagePath(0)
                }
                div("d-flex flex-column") {
                  style =
                      "position: absolute; right: 6%; bottom: 0%;" +
                          "text-shadow: #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px;"
                  div("actor-memoir-level") {
                    style = "color: darkblue;"
                    +"80"
                  }
                }
                div("d-flex flex-column") {
                  style =
                      "position: absolute; left: 6%; bottom: 0%;" +
                          "text-shadow: #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px;"
                  div("actor-level") {
                    style = "color: darkred;"
                    +"80"
                  }
                }
                img(classes = "actor-support-indicator d-none") {
                  style = "position: absolute; left: 5%; top: 21%; width: 18%;"
                  src = actorSupportIconPath
                }
                div("d-flex flex-column") {
                  style =
                      "position: absolute; left: 6%; top: 0%;" +
                          "text-shadow: #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px;"
                  div("actor-unit-skill-level") {
                    style = "color: indigo; font-size: 0.85em;"
                    +"21"
                  }
                }
                div("d-flex flex-column d-none") {
                  style =
                      "position: absolute; right: 6%; top: 0%;" +
                          "text-shadow: #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px, #fff 0 0 4px;"
                  div("actor-accessory-level") {
                    style = "color: darkgoldenrod; font-size: 0.85em;"
                    +"50"
                  }
                }
              }
              div("pt-0 p-1 actor-name actor-tab-name") {
                style =
                    "font-weight: bold; font-size: 0.75em; min-height: 1.2em; text-align: center; word-wrap: anywhere;"
              }
            }
            onClickFunction =
                onClickFunction@{ ev ->
                  val actor = ActorOptions(options, actorId)
                  for (slot in (0..9)) {
                    if (isKeyDown("$slot")) {
                      saveActorToClipboard(actor.parameters, slot)
                      ev.preventDefault()
                      return@onClickFunction
                    }
                  }
                  when {
                    isKeyDown("c") -> {
                      saveActorToClipboard(actor.parameters)
                      ev.preventDefault()
                    }
                    isKeyDown("v") -> {
                      val parameters = loadActorFromClipboard() ?: return@onClickFunction
                      val addedActorId = addActor()
                      val addedOptions = ActorOptions(options, addedActorId)
                      addedOptions.parameters = parameters
                      addedOptions.tabElement.parentElement?.insertBefore(
                          addedOptions.tabElement,
                          actor.tabElement.nextSibling,
                      )
                      ev.preventDefault()
                    }
                    isKeyDown("d") -> {
                      val addedActorId = addActor()
                      val addedOptions = ActorOptions(options, addedActorId)
                      addedOptions.parameters = actor.parameters
                      addedOptions.tabElement.parentElement?.insertBefore(
                          addedOptions.tabElement,
                          actor.tabElement.nextSibling,
                      )
                      ev.preventDefault()
                    }
                    else -> {
                      setActiveActor(actorId.takeIf { it != activeActorId })
                    }
                  }
                }
            onContextMenuFunction =
                onContextMenuFunction@{ ev ->
                  val actor = ActorOptions(options, actorId)
                  for (slot in (0..9)) {
                    if (isKeyDown("$slot")) {
                      val parameters = loadActorFromClipboard(slot) ?: return@onContextMenuFunction
                      val addedActorId = addActor()
                      val addedOptions = ActorOptions(options, addedActorId)
                      addedOptions.parameters = parameters
                      addedOptions.tabElement.parentElement?.insertBefore(
                          addedOptions.tabElement,
                          actor.tabElement.nextSibling,
                      )
                      ev.preventDefault()
                      return@onContextMenuFunction
                    }
                  }
                }
          })
      actorSettingsDiv.appendChild(
          document.create.div("row actor-options") {
            id = "actor-options-$actorId"
            attributes["data-actor-id"] = actorId.toString()
            div("col-12 mt-1 mb-2") {
              div("border border-2 rounded") {
                div("border-2") {
                  div("row mx-2 mt-3") {
                    div("col-auto me-auto") {
                      button(type = ButtonType.button, classes = "btn btn-outline-secondary") {
                        id = "actor-left-$actorId"
                        onClickFunction = {
                          val tab = (document.getElementById("actor-tab-$actorId") as HTMLElement)
                          tab.previousSibling?.let { prev ->
                            tab.parentElement?.insertBefore(tab, prev)
                          }
                        }
                        i("bi-caret-left-fill")
                      }
                      +" "
                      button(type = ButtonType.button, classes = "btn btn-outline-secondary") {
                        id = "actor-right-$actorId"
                        onClickFunction = {
                          val tab = (document.getElementById("actor-tab-$actorId") as HTMLElement)
                          tab.nextSibling?.let { next ->
                            tab.parentElement?.insertBefore(next, tab)
                          }
                        }
                        i("bi-caret-right-fill")
                      }
                    }
                    div("col-auto") {
                      button(type = ButtonType.button, classes = "btn btn-danger") {
                        id = "actor-delete-$actorId"
                        onClickFunction = {
                          val actorIds =
                              actorTabsDiv.children.asList().map {
                                it.attributes["data-actor-id"]!!.value.toInt()
                              }
                          val tab = document.getElementById("actor-tab-$actorId") as HTMLElement
                          val options =
                              document.getElementById("actor-options-$actorId") as HTMLElement
                          tab.remove()
                          options.remove()
                          actorElementCache.add(
                              CachedActorElements(id = actorId, tab = tab, options = options))
                          teamUpdate()
                          if (actorId == activeActorId) {
                            val index = actorIds.indexOf(actorId)
                            setActiveActor(
                                actorIds.filter { it != actorId }.take(index + 1).lastOrNull())
                          }
                        }
                        i("bi-x-lg")
                      }
                    }
                  }
                  div("row mx-2 mb-2 mt-1") {
                    div("col") {
                      val inputId = "actor-name-$actorId"
                      label("form-label text-actor-name") {
                        htmlFor = inputId
                        +localized(".text-actor-name", "Name")
                      }
                      input(InputType.text, classes = "form-control actor-name") {
                        id = inputId
                        onChangeFunction = { ActorOptions(options, actorId).update() }
                      }
                    }
                    div("col-auto") {
                      label("form-label text-support-toggle") {
                        +localized(".text-support-toggle", "Support")
                      }
                      div("btn-group w-100 actor-support-toggle d-block") {
                        role = "group"
                        attributes["data-prev-value"] = "10"
                        listOf(false, true).forEach { enable ->
                          input(InputType.radio, classes = "btn-check") {
                            id = "actor-support-toggle-$actorId-radio-$enable"
                            name = "actor-support-toggle-$actorId-radio"
                            autoComplete = false
                            value = enable.toString()
                            if (!enable) {
                              attributes["checked"] = "checked"
                            }
                            onChangeFunction = { ActorOptions(options, actorId).update() }
                          }
                          label(
                              classes =
                                  "btn btn-outline-${if (enable) "success" else "secondary"}") {
                                htmlFor = "actor-support-toggle-$actorId-radio-$enable"
                                i("bi bi-${if (enable) "check" else "x"}-lg")
                              }
                        }
                      }
                    }
                  }
                  div("row mx-2 mb-2") {
                    div("col-12 col-md-8 col-lg-6 my-1") {
                      val selectId = "actor-dress-$actorId"
                      label("form-label text-dress") {
                        htmlFor = selectId
                        +localized(".text-dress", "Dress")
                      }
                      div("input-group") {
                        select(
                            "selectpicker actor-selectpicker-$actorId form-control actor-dress") {
                              id = selectId
                              attributes["data-live-search"] = "true"
                              options.dresses.forEach {
                                option {
                                  attributes["data-img"] = it.imagePath ?: ""
                                  value = it.id
                                  +it[locale]
                                  attributes["data-subtext"] = it.subtext(locale)
                                  attributes["data-tokens"] =
                                      it.tags?.get(locale)?.joinToString(" ") ?: ""
                                }
                              }
                              onChangeFunction = { ActorOptions(options, actorId).update() }
                            }
                        button(type = ButtonType.button, classes = "btn btn-outline-secondary") {
                          i("bi bi-info-circle")
                          onClickFunction =
                              ocf@{
                                val opt = ActorOptions(options, actorId)
                                val id =
                                    options.dressesById[opt.parameters.dress]?.data?.id
                                        ?: return@ocf
                                if (id <= 0) return@ocf
                                window.open("https://karth.top/dress/$id?global=1", "_blank")
                              }
                        }
                      }
                    }

                    div("col-8 col-md-4 col-lg-3 my-1") {
                      val selectId = "actor-remake-$actorId"
                      label("form-label text-actor-remake") {
                        htmlFor = selectId
                        +localized(".text-actor-remake", "Remake")
                      }
                      +" "
                      img(classes = "actor-remake-icon") {
                        id = "actor-remake-icon-$actorId"
                        style = "height: 0.8em; margin-top: -0.125em"
                        src = getRemakeLevelHorizontalImagePath(0)
                      }
                      div("btn-group w-100 actor-remake") {
                        role = "group"
                        attributes["data-prev-value"] = "0"
                        (0..4).forEach { level ->
                          input(InputType.radio, classes = "btn-check") {
                            id = "actor-remake-$actorId-radio-$level"
                            name = "actor-remake-$actorId-radio"
                            autoComplete = false
                            value = level.toString()
                            if (level == 0) {
                              attributes["checked"] = "checked"
                            }
                            onChangeFunction = {
                              val opt = ActorOptions(options, actorId)
                              val prev =
                                  opt.remake.element.attributes["data-prev-value"]?.value?.toInt()
                                      ?: 0
                              val params = opt.parameters
                              val newLevel =
                                  if (params.level == 20 + 10 * params.rarity + 5 * prev) {
                                    20 + 10 * params.rarity + 5 * params.remake
                                  } else {
                                    params.level
                                  }
                              val newFriendship =
                                  if (params.friendship == 5 * params.rarity + 5 * prev) {
                                    5 * params.rarity + 5 * params.remake
                                  } else {
                                    params.friendship
                                  }
                              opt.parameters =
                                  params.copy(level = newLevel, friendship = newFriendship)
                            }
                          }
                          label(classes = "btn btn-outline-secondary") {
                            htmlFor = "actor-remake-$actorId-radio-$level"
                            +"$level"
                          }
                        }
                      }
                    }
                    div("col-4 col-md-4 col-lg-3 my-1") {
                      val inputId = "actor-level-$actorId"
                      label("form-label text-actor-level") {
                        htmlFor = inputId
                        +localized(".text-actor-level", "Level")
                      }
                      input(InputType.number, classes = "form-control actor-level") {
                        id = inputId
                        placeholder = "80"
                        onChangeFunction = { ActorOptions(options, actorId).update() }
                      }
                    }
                    div("col-4 col-md-4 col-lg-2 my-1") {
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
                    div("col-4 col-md-4 col-lg-2 my-1") {
                      val inputId = "actor-friendship-$actorId"
                      label("form-label text-actor-friendship") {
                        htmlFor = inputId
                        +localized(".text-actor-friendship", "Bond")
                      }
                      input(InputType.number, classes = "form-control actor-friendship") {
                        id = inputId
                        placeholder = "30"
                      }
                    }
                    div("col-4 col-md-4 col-lg-2 my-1") {
                      val inputId = "actor-unit-skill-$actorId"
                      label("form-label text-unit-skill-level") {
                        htmlFor = inputId
                        +localized(".text-unit-skill-level", "US")
                      }
                      +" "
                      img {
                        style = "height: 1.2em; margin-top: -0.1em;"
                        src = "img/common/button_unitskill.webp"
                      }
                      input(InputType.number, classes = "form-control actor-unit-skill") {
                        id = inputId
                        placeholder = "21"
                        onChangeFunction = { ActorOptions(options, actorId).update() }
                      }
                    }
                    div("col-6 col-md-4 col-lg-3 my-1") {
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
                    div("col-6 col-md-4 col-lg-3 my-1") {
                      val selectId = "actor-rank-panel-pattern-$actorId"
                      label("form-label text-actor-rank-panel-pattern") {
                        htmlFor = selectId
                        +localized(".text-actor-rank-panel-pattern", "Panel Pattern")
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
                    div("col-12 my-1") {
                      val selectId = "actor-remake-skill-$actorId"
                      label("form-label text-remake-skill") {
                        htmlFor = selectId
                        +localized(".text-remake-skill", "Remake Skill")
                      }
                      select(
                          "selectpicker actor-selectpicker-$actorId form-control actor-remake-skill") {
                            id = selectId
                            attributes["data-live-search"] = "true"
                            attributes["disabled"] = "disabled"
                            options.remakeSkills.forEach {
                              option {
                                attributes["data-img"] = it.imagePath ?: ""
                                value = it.id
                                +it[locale]
                              }
                            }
                            onChangeFunction = {
                              val opt = ActorOptions(options, actorId)
                              opt.remakeSkillText.textContent =
                                  opt.remakeSkill.element.selectedOptions
                                      .single<HTMLElement>()
                                      .textContent
                            }
                          }
                      p("mt-2 mb-1 mx-1 d-md-none actor-remake-skill-text") {
                        id = "$selectId-text"
                        style = "font-size: 0.85em;"
                        +options.remakeSkills.first()[locale]
                      }
                    }
                    div("col-12 col-md-6 my-1") {
                      val selectId = "actor-memoir-$actorId"
                      label("form-label text-memoir") {
                        htmlFor = selectId
                        +localized(".text-memoir", "Memoir")
                      }
                      div("input-group") {
                        select(
                            "selectpicker actor-selectpicker-$actorId form-control actor-memoir") {
                              id = selectId
                              attributes["data-live-search"] = "true"
                              options.memoirs.forEach {
                                option {
                                  val name = it[locale]
                                  attributes["data-img"] = it.imagePath ?: ""
                                  attributes["data-subtext"] = it.subtext(locale)
                                  value = it.id
                                  +name
                                  attributes["data-tokens"] =
                                      it.tags?.get(locale)?.joinToString(" ") ?: ""
                                }
                              }
                              onChangeFunction = { ActorOptions(options, actorId).update() }
                            }
                        button(type = ButtonType.button, classes = "btn btn-outline-secondary") {
                          i("bi bi-info-circle")
                          onClickFunction =
                              ocf@{
                                val opt = ActorOptions(options, actorId)
                                val id =
                                    options.memoirsById[opt.parameters.memoir]?.data?.id
                                        ?: return@ocf
                                if (id <= 0) return@ocf
                                window.open("https://karth.top/equip/$id?global=1", "_blank")
                              }
                        }
                      }
                    }
                    div("col-8 col-md-4 col-lg-3 my-1") {
                      val selectId = "actor-memoir-unbind-$actorId"
                      label("form-label text-memoir-unbind") {
                        htmlFor = selectId
                        +localized(".text-memoir-unbind", "Unbind")
                      }
                      +" "
                      img(classes = "actor-memoir-unbind-icon") {
                        id = "actor-memoir-unbind-icon-$actorId"
                        style = "height: 0.85em; margin-top: -0.15em"
                        src = getMemoirUnbindLevelHorizontalImagePath(4)
                      }
                      div("btn-group w-100 actor-memoir-unbind") {
                        role = "group"
                        attributes["data-prev-value"] = "4"
                        (0..4).forEach { level ->
                          input(InputType.radio, classes = "btn-check") {
                            id = "actor-memoir-unbind-$actorId-radio-$level"
                            name = "actor-memoir-unbind-$actorId-radio"
                            autoComplete = false
                            value = level.toString()
                            if (level == 4) {
                              attributes["checked"] = "checked"
                            }
                            onChangeFunction = {
                              val opt = ActorOptions(options, actorId)
                              val prev =
                                  opt.memoirUnbind.element.attributes["data-prev-value"]
                                      ?.value
                                      ?.toInt()
                                      ?: 0
                              val params = opt.parameters
                              // only works for 4* memos, which is almost all of them
                              val newMemoirLevel =
                                  if (params.memoirLevel == 60 + 5 * prev) {
                                    60 + 5 * params.memoirLimitBreak
                                  } else {
                                    params.memoirLevel
                                  }
                              opt.parameters = params.copy(memoirLevel = newMemoirLevel)
                            }
                          }
                          label(classes = "btn btn-outline-secondary") {
                            htmlFor = "actor-memoir-unbind-$actorId-radio-$level"
                            +"$level"
                          }
                        }
                      }
                    }
                    div("col-4 col-md-2 col-lg-3 my-1") {
                      val inputId = "actor-memoir-level-$actorId"
                      label("form-label text-memoir-level") {
                        htmlFor = inputId
                        +localized(".text-memoir-level", "Level")
                      }
                      input(InputType.number, classes = "form-control actor-memoir-level") {
                        id = inputId
                        placeholder = "80"
                        onChangeFunction = { ActorOptions(options, actorId).update() }
                      }
                    }
                    val activeAccessories =
                        options.accessories
                            .filter { it.data.compatibleWith(options.dresses.first().data) }
                            .toSet()
                    div(
                        "col-12 col-md-6 my-1${if (activeAccessories.size <= 1) " d-none" else ""}") {
                          val selectId = "actor-accessory-$actorId"
                          label("form-label text-accessory") {
                            htmlFor = selectId
                            +localized(".text-accessory", "Accessory")
                          }
                          div("input-group") {
                            select(
                                "selectpicker actor-selectpicker-$actorId form-control actor-accessory") {
                                  id = selectId
                                  attributes["data-live-search"] = "true"
                                  options.accessories.forEach {
                                    option {
                                      val name = it[locale]
                                      attributes["data-img"] = it.imagePath ?: ""
                                      attributes["data-subtext"] = it.subtext(locale)
                                      attributes["data-hidden"] =
                                          if (it in activeAccessories) "false" else "true"
                                      value = it.id
                                      +name
                                      attributes["data-tokens"] =
                                          it.tags?.get(locale)?.joinToString(" ") ?: ""
                                    }
                                  }
                                  onChangeFunction = { ActorOptions(options, actorId).update() }
                                }
                            button(
                                type = ButtonType.button, classes = "btn btn-outline-secondary") {
                                  i("bi bi-info-circle")
                                  onClickFunction =
                                      ocf@{
                                        val opt = ActorOptions(options, actorId)
                                        val id =
                                            options.accessoriesById[opt.parameters.accessory]
                                                ?.data
                                                ?.id
                                                ?: return@ocf
                                        if (id <= 0) return@ocf
                                        window.open(
                                            "https://karth.top/accessory/$id?global=1", "_blank")
                                      }
                                }
                          }
                        }
                    div(
                        "col-8 col-md-4 col-lg-3 my-1${if (activeAccessories.size <= 1) " d-none" else ""}") {
                          val selectId = "actor-accessory-unbind-$actorId"
                          label("form-label text-accessory-unbind") {
                            htmlFor = selectId
                            +localized(".text-accessory-unbind", "Unbind")
                          }
                          select("actor-accessory-unbind form-select") {
                            id = "actor-accessory-unbind-$actorId-select"
                            attributes["data-prev-value"] = "10"
                            (0..10).forEach {
                              option {
                                value = it.toString()
                                +it.toString()
                                selected = it == 0
                              }
                            }
                            onChangeFunction = {
                              val opt = ActorOptions(options, actorId)
                              val prev =
                                  opt.accessoryUnbind.element.attributes["data-prev-value"]
                                      ?.value
                                      ?.toInt()
                                      ?: 0
                              val params = opt.parameters
                              val newAccessoryLevel =
                                  (if (params.accessoryLevel == 50 + 5 * prev) {
                                        50 + 5 * params.accessoryLimitBreak
                                      } else {
                                        params.accessoryLevel
                                      })
                                      .coerceAtMost(50 + 5 * params.accessoryLimitBreak)
                              opt.parameters = params.copy(accessoryLevel = newAccessoryLevel)
                            }
                          }
                        }
                    div(
                        "col-4 col-md-2 col-lg-3 my-1${if (activeAccessories.size <= 1) " d-none" else ""}") {
                          val inputId = "actor-accessory-level-$actorId"
                          label("form-label text-accessory-level") {
                            htmlFor = inputId
                            +localized(".text-accessory-level", "Level")
                          }
                          input(InputType.number, classes = "form-control actor-accessory-level") {
                            id = inputId
                            placeholder = "50"
                            onChangeFunction = { ActorOptions(options, actorId).update() }
                          }
                        }
                    div("col-12 mt-2 mb-1 d-flex gap-1") {
                      button(
                          type = ButtonType.button,
                          classes = "btn btn-outline-secondary text-actor-preset-min") {
                            id = "actor-preset-min-$actorId"
                            +"Min"
                            onClickFunction = {
                              val opt = ActorOptions(options, actorId)
                              opt.parameters =
                                  opt.parameters.copy(
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
                      button(
                          type = ButtonType.button,
                          classes = "btn btn-outline-secondary text-actor-preset-max me-auto") {
                            id = "actor-preset-max-$actorId"
                            +"Max"
                            onClickFunction = {
                              val opt = ActorOptions(options, actorId)
                              val param = opt.parameters
                              opt.parameters =
                                  param.copy(
                                      level = 80 + 5 * param.remake,
                                      rarity = 6,
                                      friendship = 30 + 5 * param.remake,
                                      rank = 9,
                                      rankPanelPattern = List(8) { true },
                                      memoirLevel = 60 + 5 * param.memoirLimitBreak,
                                  )
                            }
                          }
                    }
                  }
                }
              }
            }
          },
      )
      val elements = js("$")(".actor-selectpicker-$actorId").toArray() as Array<dynamic>
      for (element in elements) {
        js("$")(element).selectpicker()
      }
    } else {
      val (id, tab, settings) = actorElementCache.removeLast()
      actorId = id
      actorTabsDiv.appendChild(tab)
      actorSettingsDiv.appendChild(settings)
      ActorOptions(options, actorId).reset()
    }
    setActiveActor(actorId)
    teamUpdate()
    return actorId
  }

  fun getSetup(): SimulationParameters {
    val actors =
        actorTabsDiv.children
            .asList()
            .reversed()
            .map { tab ->
              ActorOptions(options, tab.attributes["data-actor-id"]!!.value.toInt()).parameters
            }
            .map { it.copy(name = it.name.replace(Regex("\\s"), "_")) }
    return SimulationParameters(
        maxTurns = turnsInput.value,
        maxIterations = iterationsInput.value,
        team = if (guestCheckbox.checked) actors.dropLast(1) else actors,
        guest = if (guestCheckbox.checked) actors.lastOrNull() else null,
        song = getSongParameters(),
        strategy =
            StrategyParameter(
                strategyTypeSelect.value,
                strategyEditor.value,
            ),
        bossStrategy =
            StrategyParameter(
                    bossStrategyTypeSelect.value,
                    bossStrategyEditor.value,
                )
                .takeIf { bossStrategyCollapse.show },
        boss = bossSelect.value,
        bossHp = bossHpInput.value?.takeIf { it > 0.0 },
        bossAttribute =
            bossAttributeSelect.value.takeIf { it != "None" }?.let { Attribute.valueOf(it) },
        additionalEventBonus = eventBonusInput.value,
        eventMultiplier = eventMultiplierInput.value,
        seed = seedInput.value,
    )
  }

  fun SimulationParameters.migrate() =
      copy(
          team = team.map { it.migrate() },
          guest = guest?.migrate(),
      )

  fun Iterable<String>.closestLevenshteinDistance(target: String, threshold: Int = 15): String? {
    var minDistance = Int.MAX_VALUE
    var closest: String? = null
    for (s in this) {
      val distance = s.levenshteinDistance(target)
      if (distance < minDistance) {
        minDistance = distance
        closest = s
      }
    }
    return if (minDistance <= threshold) closest else null
  }

  fun String.levenshteinDistance(target: String): Int {
    if (this == target) return 0
    val m = length
    val n = target.length
    if (m == 0) return n
    if (n == 0) return m
    var v0 = IntArray(n + 1)
    var v1 = IntArray(n + 1)
    for (i in 0..n) {
      v0[i] = i
    }
    for (i in 0 until m) {
      v1[0] = i + 1
      for (j in 0 until n) {
        val cost = if (this[i] == target[j]) 0 else 1
        v1[j + 1] = minOf(v1[j] + 1, v0[j + 1] + 1, v0[j] + cost)
      }
      val vTemp = v0
      v0 = v1
      v1 = vTemp
    }
    return v0[n]
  }

  fun <T> Map<String, T>.getFuzzy(key: String) =
      get(key) ?: keys.closestLevenshteinDistance(key)?.let { get(it) }

  fun PlayerLoadoutParameters.migrate() =
      copy(
          dress = Dresses.aliases.getFuzzy(dress)?.id?.toString() ?: dress,
          memoir = Memoirs.aliases.getFuzzy(memoir)?.id?.toString() ?: memoir,
          accessory = accessory?.let { Accessories.aliases.getFuzzy(it)?.id?.toString() ?: it },
      )

  fun setSetup(setup: SimulationParameters) =
      setup.migrate().run {
        turnsInput.value = maxTurns
        iterationsInput.value = maxIterations
        when {
          actorTabsDiv.children.length < team.size -> {
            repeat(team.size - actorTabsDiv.children.length) { addActor() }
          }
          actorTabsDiv.children.length > team.size -> {
            actorTabsDiv.children.asList().take(actorTabsDiv.children.length - team.size).forEach {
                tab ->
              val id = tab.attributes["data-actor-id"]!!.value.toInt()
              val options = ActorOptions(options, id)
              options.tabElement.remove()
              options.optionsElement.remove()
              actorElementCache.add(
                  CachedActorElements(
                      id,
                      options.tabElement,
                      options.optionsElement,
                  ))
            }
          }
        }
        val team = listOfNotNull(guest) + this.team
        guestCheckbox.checked = guest != null
        actorTabsDiv.children.asList().reversed().zip(team).forEach { (tab, parameters) ->
          ActorOptions(options, tab.attributes["data-actor-id"]!!.value.toInt()).parameters =
              parameters
        }
        setSongParameters(options, song, locale)
        strategyTypeSelect.value = strategy.type
        strategyEditor.value = strategy.value
        if (bossStrategy != null) {
          bossStrategyCollapse.show = true
          bossStrategyTypeSelect.value = bossStrategy!!.type
          bossStrategyEditor.value = bossStrategy!!.value
        } else {
          bossStrategyCollapse.show = false
        }
        bossSelect.value = boss
        if (bossHp != null) {
          bossHpInput.value = bossHp!!
        } else {
          bossHpInput.clear()
        }
        if (bossAttribute != null) {
          bossAttributeSelect.value = bossAttribute!!.name
        } else {
          bossAttributeSelect.value = "None"
        }
        eventBonusInput.value = additionalEventBonus
        eventMultiplierInput.value = eventMultiplier
        seedInput.value = seed
        teamUpdate()
      }

  fun getUrlParameter(url: String, name: String): String? {
    val regex = Regex("[?&]$name=([^&]*)")
    return regex.find(URL(url).search)?.groupValues?.get(1)
  }

  fun updateSetupFromUrl(url: String = window.location.href) =
      GlobalScope.launch(Dispatchers.Main.immediate) {
        val urlOptions = getUrlParameter(url, "options")
        val urlSetup = getUrlParameter(url, "load-setup") ?: getSetupIdFromShareLink(url)
        if (urlSetup != null) {
          toast("Setup", "Loading setup.", "gold")
          val setup = api.getSetup(urlSetup)
          finishedLoading.await()
          setSetup(setup)
          toast("Setup", "Loaded setup.", "green")
        } else if (urlOptions != null) {
          try {
            val setup =
                json.decodeFromString<SimulationParameters>(
                    compressor.decompressFromEncodedURIComponent(urlOptions))
            finishedLoading.await()
            setSetup(setup)
            updateUrlForSetup(setup)
            toast("Import", "Updated setup from url.", "green")
          } catch (e: Throwable) {
            toast("Error", "Failed to update setup from url.", "red")
          }
        }
      }

  fun getSetupIdFromShareLink(url: String): String? {
    val regex = Regex("^.*[./]to/([a-zA-Z0-9]+)$")
    return regex.find(url)?.groupValues?.get(1)
  }

  fun handleFirstLoadUrlOptions() =
      GlobalScope.launch(Dispatchers.Main.immediate) {
        val tempSetupData = sessionStorage["temp-setup"]
        if (tempSetupData != null) {
          try {
            val setup = json.decodeFromString<SimulationParameters>(tempSetupData)
            finishedLoading.await()
            setSetup(setup)
            // Can't update url since it'll override login data.
            sessionStorage.removeItem("temp-setup")
          } catch (e: Throwable) {
            sessionStorage.removeItem("temp-setup")
          }
        } else {
          updateSetupFromUrl()
        }
      }

  fun urlWithQuery(parameters: Map<String, String>): String {
    val paramString = parameters.asSequence().joinToString("&") { (key, value) -> "$key=$value" }
    return "$baseHref?$paramString"
  }

  fun updateUrlForSetup(setup: SimulationParameters) {
    val newUrl =
        urlWithQuery(
            mapOf(
                "options" to compressor.compressToEncodedURIComponent(json.encodeToString(setup))))
    if (newUrl != window.location.href) {
      if (newUrl.length <= 8192) {
        window.history.pushState(null, "", newUrl)
      } else {
        toast("Warning", "Url not updated due to length limit.", "gold")
      }
    }
  }

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

  var locale = "en"
  fun localized(value: String, fallback: String) =
      options.commonTextById[value]?.get(locale) ?: fallback

  private val finishedLoading = CompletableDeferred<Unit>()

  fun start() {
    // We want to kick this off first, since the API can take a while to respond
    handleFirstLoadUrlOptions()

    GlobalScope.launch(Dispatchers.Main.immediate) { updateVersionString() }

    initSiteInfo()

    options = getSimulationOptions()

    val commonText = options.commonText.associateBy { it.id }
    val bosses = options.bosses.associateBy { it.id }
    val strategies = options.strategyTypes.associateBy { it.id }
    val bossStrategies = options.bossStrategyTypes.associateBy { it.id }
    val dresses = options.dresses.associateBy { it.id }
    val remakeSkills = options.remakeSkills.associateBy { it.id }
    val memoirs = options.memoirs.associateBy { it.id }
    val accessories = options.accessories.associateBy { it.id }

    locale = options.locales.keys.first()

    registerKeyEventListeners()

    strategyCollapseAllButton.addEventListener("click", { foldAll(strategyEditor) })
    strategyExpandAllButton.addEventListener("click", { unfoldAll(strategyEditor) })

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

    exportButton.addEventListener(
        "click",
        {
          updateExportText()
          updateUrlForSetup(getSetup())
        })

    yamlImportCheckbox.addEventListener("click", { updateExportText() })

    guestCheckbox.addEventListener("click", { teamUpdate() })

    exportText.addEventListener(
        "click",
        {
          exportText.focus()
          exportText.select()
        })

    shareSetupText.addEventListener(
        "click",
        {
          shareSetupText.focus()
          shareSetupText.select()
        })

    doImportButton.addEventListener(
        "click",
        {
          try {
            val data = importText.value
            val trimmed = data.trim()
            if (trimmed.startsWith("http://") || trimmed.startsWith("https://")) {
              updateSetupFromUrl(trimmed)
            } else {
              val setup = loadYamlDeserialize<SimulationParameters>(importText.value)
              setSetup(setup)
              updateUrlForSetup(setup)
              toast("Import", "Import completed.", "green")
            }
          } catch (e: Throwable) {
            toast("Import", "Import failed.", "red")
          }
        })

    fun updatePrideState() {
      if (prideCheckbox.checked) {
        document.body?.addClass("pride")
      } else {
        document.body?.removeClass("pride")
      }
    }

    prideCheckbox.checked = localStorage["preference-pride"] != "false"
    prideCheckbox.addEventListener(
        "click",
        {
          localStorage["preference-pride"] = prideCheckbox.checked.toString()
          updatePrideState()
        })
    updatePrideState()

    toastsCheckbox.checked = localStorage["preference-toasts"] != "false"
    toastsCheckbox.addEventListener(
        "click", { localStorage["preference-toasts"] = toastsCheckbox.checked.toString() })

    seedRandomizeButton.addEventListener("click", { seedInput.value = Random.nextInt() })

    bossSelect.element.addEventListener("change", { teamUpdate() })

    addActorButton.addEventListener("click", { addActor() })

    copyActorButton.addEventListener(
        "click",
        {
          val parameters = selectedActor()?.parameters ?: return@addEventListener
          saveActorToClipboard(parameters)
        })

    pasteActorButton.addEventListener(
        "click",
        {
          val parameters = loadActorFromClipboard() ?: return@addEventListener
          val selectedOptions = selectedActor()
          val addedActorId = addActor()
          val addedOptions = ActorOptions(options, addedActorId)
          addedOptions.parameters = parameters
          addedOptions.tabElement.parentElement?.insertBefore(
              addedOptions.tabElement,
              selectedOptions?.tabElement?.nextSibling,
          )
        })

    duplicateActorButton.addEventListener(
        "click",
        {
          val selectedOptions = selectedActor() ?: return@addEventListener
          val parameters = selectedOptions.parameters
          val addedActorId = addActor()
          val addedOptions = ActorOptions(options, addedActorId)
          addedOptions.parameters = parameters
          addedOptions.tabElement.parentElement?.insertBefore(
              addedOptions.tabElement,
              selectedOptions.tabElement.nextSibling,
          )
        })

    sortByPositionButton.addEventListener(
        "click",
        {
          val setup = getSetup()
          actorTabsDiv.children
              .asList()
              .drop(if (guestCheckbox.checked) 1 else 0)
              .reversed()
              .zip(setup.team.map { options.dressesById[it.dress]!!.data to it.isSupport })
              .sortedWith(compareBy({ it.second.first }, { it.second.second }))
              .reversed()
              .forEach { (tab, _) -> actorTabsDiv.appendChild(tab) }
        })

    fun autoName(retainExisting: Boolean) {
      val setup = getSetup()
      val entries =
          actorTabsDiv.children
              .asList()
              .drop(if (guestCheckbox.checked) 1 else 0)
              .reversed()
              .zip(setup.team)
      val usedNames =
          if (retainExisting)
              entries
                  .mapNotNull { (_, params) -> params.name.takeIf { it.isNotBlank() } }
                  .toMutableSet()
          else {
            mutableSetOf()
          }
      val updateSupports =
          entries.groupBy { (_, params) -> params.dress }.any { (_, group) -> group.size > 1 }
      val usedDresses = mutableSetOf<Int>()
      entries.forEach { (tab, params) ->
        val data = options.dressesById[params.dress]!!.data

        val dressWasUsed = usedDresses.contains(data.id)
        usedDresses.add(data.id)

        var name = params.name

        if (!retainExisting || name.isBlank()) {
          name = data.characterName.replace(" ", "").lowercase()

          if (usedNames.contains(name)) {
            var num = 2
            while (usedNames.contains("${name}_$num")) {
              num++
            }
            name = "${name}_$num"
          }

          usedNames.add(name)
        }

        val options = ActorOptions(options, tab.attributes["data-actor-id"]!!.value.toInt())
        options.parameters =
            options.parameters.copy(
                name = name,
                isSupport =
                    if (updateSupports) {
                      dressWasUsed
                    } else {
                      params.isSupport
                    })
      }
      if (guestCheckbox.checked && (!retainExisting || setup.guest?.name?.isBlank() == true)) {
        val tab = actorTabsDiv.firstChild as HTMLDivElement?
        if (tab != null) {
          val options = ActorOptions(options, tab.attributes["data-actor-id"]!!.value.toInt())
          options.parameters = options.parameters.copy(name = "guest", isSupport = false)
        }
      }
    }

    autoNameButton.addEventListener("click", { autoName(false) })

    teamImageButton.addEventListener(
        "click",
        {
          GlobalScope.launch {
            val imageData = TeamImage(getSetup(), options).drawTeamImage()
            val altImageData = TeamImage(getSetup(), options).drawTeamImageAlt()
            teamImageContainer.clear()
            teamImageContainer.append {
              img(src = imageData.toDataURL()) { style = "max-height: 250px; max-width: 100%;" }
              img(src = altImageData.toDataURL(), classes = "mt-4") {
                style = "max-height: 250px; max-width: 100%;"
              }
            }
            teamImageModalBs.show()
          }
        })

    actIconsButton.addEventListener(
        "click",
        {
          val teamDresses =
              getSetup().team.map { it.isSupport to options.dressesById[it.dress]?.data?.id }
          actIconsContainer.clear()
          actIconsContainer.append {
            div("mx-auto") {
              listOf("A1", "A2", "A3", "CA").forEach { actName ->
                div {
                  teamDresses.map { (isSupport, dressId) ->
                    img(
                        src =
                            "img/acts/${dressId}_${actName}${if (isSupport) "_support" else ""}.webp") {
                          style = "max-height: 50px; max-width: 50px;"
                        }
                  }
                }
              }
            }
          }
          actIconsModalBs.show()
        })

    var isSharing = false
    fun shareSetup() {
      if (isSharing) return
      isSharing = true
      GlobalScope.launch {
        try {
          val flagUrl = randomFlagSmallUrl()
          shareSetupModalBs.show()
          shareSetupText.value = localized("loading...", locale)
          val setup = getSetup()
          shareSetupImageContainer.clear()
          val imageData = TeamImage(setup, options).drawOpenGraphImage(flagUrl)
          shareSetupImageContainer.append { img(src = imageData.toDataURL()) { width = "100%" } }
          val url = api.shareSetup(setup, options, flagUrl)
          shareSetupText.value = url
        } catch (e: Throwable) {
          shareSetupText.value = localized("error", locale)
        } finally {
          isSharing = false
        }
      }
    }

    shareSetupButton.addEventListener("click", { shareSetup() })

    tabNameInput.addEventListener("input", {
      val name = tabNameInput.value
      if (name.isBlank()) {
        document.title = "Relight"
      } else {
        document.title = "$name - Relight"
      }
    })

    languageSelect.populate(options.locales)
    bossSelect.populate(bosses, locale)
    strategyTypeSelect.populate(strategies, locale)
    bossStrategyTypeSelect.populate(bossStrategies, locale)
    initSongs(options, locale)

    aboutTab.addEventListener("click", { initAboutArtists() })

    simulateButton.addEventListener(
        "click",
        {
          GlobalScope.launch {
            simulateButton.disabled = true
            cancelButton.disabled = false
            try {
              val setup = getSetup()
              simulation = simulator.simulate(setup)
              activeSetup = setup
              updateUrlForSetup(setup)
            } catch (e: Throwable) {
              toast("Simulate", "Failed to start.", "red")
              simulateButton.disabled = false
              cancelButton.disabled = true
              return@launch
            }
            toast("Simulate", "Started.", "green")
            done = false
          }
        })
    cancelButton.addEventListener(
        "click",
        {
          GlobalScope.launch {
            simulation?.cancel()
            simulateButton.disabled = false
            cancelButton.disabled = true
          }
        })

    fun startNewInteractiveSimulation() {
      GlobalScope.launch {
        try {
          autoName(true)
          val setup = getSetup()
          interactiveSimulation?.end()
          interactiveSimulation = simulator.simulateInteractive(setup)
          interactiveContainer.removeClass("d-none")

          val interactiveThemeClasses =
              listOf(
                  "interactive-lesbian",
                  "interactive-bisexual",
                  "interactive-pansexual",
                  "interactive-asexual",
                  "interactive-aromantic",
                  "interactive-transgender",
                  "interactive-nonbinary",
                  "interactive-agender",
                  "interactive-genderfluid",
                  "interactive-genderqueer",
                  "interactive-newgay",
              )
          interactiveThemeClasses.forEach { interactiveContainer.removeClass(it) }
          interactiveContainer.addClass(interactiveThemeClasses.random())

          updateUrlForSetup(setup)
        } catch (e: Throwable) {
          return@launch
        }
        window.onbeforeunload = {
          it.preventDefault()
          it.returnValue = ""
          ""
        }
      }
    }

    toInteractiveButtons.multiple<HTMLButtonElement>().forEach {
      it.addEventListener(
          "click",
          {
            window.scrollTo(0.0, 0.0)
            interactiveTab.click()
          })
    }

    toSimulateButtons.multiple<HTMLButtonElement>().forEach {
      it.addEventListener(
          "click",
          {
            window.scrollTo(0.0, 0.0)
            simulateTab.click()
          })
    }

    interactiveTab.addEventListener(
        "click",
        {
          GlobalScope.launch {
            if (interactiveSimulation == null ||
                interactiveSimulation?.getLog()?.data?.error != null) {
              startNewInteractiveSimulation()
            }
          }
        })

    interactiveRestartButton.addEventListener("click", { startNewInteractiveSimulation() })

    interactiveSharesButton.addEventListener(
        "click",
        {
          if (interactiveContainer.hasClass("show-damage-shares")) {
            interactiveContainer.removeClass("show-damage-shares")
          } else {
            interactiveContainer.addClass("show-damage-shares")
          }
        })

    suspend fun sendInteractiveCommand(command: String) {
      when (command) {
        "bars" -> {
          if (interactiveStatusContainer.hasClass("d-none")) {
            interactiveStatusContainer.removeClass("d-none")
          } else {
            interactiveStatusContainer.addClass("d-none")
          }
        }
        "" -> interactiveSimulation?.sendCommand("go")
        else -> interactiveSimulation?.sendCommand(command)
      }
    }

    suspend fun sendInteractiveCommand() {
      sendInteractiveCommand(interactiveInput.value.trim())
      interactiveInput.value = ""
    }

    interactiveSendButton.addEventListener(
        "click", { GlobalScope.launch { sendInteractiveCommand() } })
    interactiveInput.element.addEventListener(
        "keypress",
        {
          if ((it as KeyboardEvent).key == "Enter") {
            GlobalScope.launch { sendInteractiveCommand() }
          }
        })
    var isProcessingInteractivePaste = false
    interactiveInput.element.addEventListener(
        "paste",
        { e ->
          val data = (e as? ClipboardEvent)?.clipboardData?.getData("Text")?.trim()
          val lineBreakRe = Regex("[\\r\\n]+")
          if (data != null && lineBreakRe.find(data) != null) {
            e.preventDefault()
            e.stopPropagation()
            if (!isProcessingInteractivePaste) {
              isProcessingInteractivePaste = true
              GlobalScope.launch {
                try {
                  data.split(lineBreakRe).forEach { sendInteractiveCommand(it) }
                } finally {
                  isProcessingInteractivePaste = false
                }
              }
            }
          }
        })
    document.addEventListener(
        "sendInteractiveCommand",
        { e ->
          GlobalScope.launch {
            interactiveSimulation?.sendCommand((e as CustomEvent).detail as String)
          }
        })
    document
        .getElementsByClassName("interactive-shortcut-button")
        .asList()
        .filterIsInstance<HTMLButtonElement>()
        .forEach { button ->
          val command =
              button.attributes["data-interactive-command"]?.value?.trim() ?: return@forEach
          button.onclick = { GlobalScope.launch { interactiveSimulation?.sendCommand(command) } }
        }

    fun updateLocaleText() {
      actorElementCache.clear()

      val rankPanelOptions =
          rankPanelIds.mapNotNull { (name, id) -> commonText[id]?.let { name to it } }.toMap()

      bossSelect.localize(bosses, locale)
      strategyTypeSelect.localize(strategies, locale)
      bossStrategyTypeSelect.localize(bossStrategies, locale)
      document
          .getElementsByClassName("actor-rank-panel-pattern")
          .asList()
          .filterIsInstance<HTMLSelectElement>()
          .forEach { select -> SingleSelect(select, false).localize(rankPanelOptions, locale) }
      document
          .getElementsByClassName("actor-dress")
          .asList()
          .filterIsInstance<HTMLSelectElement>()
          .forEach { select -> SingleSelect(select, true).localize(dresses, locale) }
      document
          .getElementsByClassName("actor-remake-skill")
          .asList()
          .filterIsInstance<HTMLSelectElement>()
          .forEach { select ->
            SingleSelect(select, true).localize(remakeSkills, locale)
            document.getElementById("${select.id}-text")!!.textContent =
                remakeSkills[select.value]?.get(locale) ?: ""
          }
      document
          .getElementsByClassName("actor-memoir")
          .asList()
          .filterIsInstance<HTMLSelectElement>()
          .forEach { select -> SingleSelect(select, true).localize(memoirs, locale) }
      document
          .getElementsByClassName("actor-accessory")
          .asList()
          .filterIsInstance<HTMLSelectElement>()
          .forEach { select -> SingleSelect(select, true).localize(accessories, locale) }
      updateSongLocale(options, locale)
      commonText
          .filter { (k, _) -> k[0] == '.' }
          .forEach { (k, v) ->
            document.getElementsByClassName(k.drop(1)).asList().forEach { element ->
              element.textContent = v[locale]
            }
          }
    }

    languageSelect.element.addEventListener(
        "change",
        {
          locale = languageSelect.value
          updateLocaleText()
        })

    data class PlotType(
        val title: String,
        val element: Element,
        val boxElement: Element,
        val type: SimulationMarginResultType,
        val accessor: MarginResult.() -> Map<Double, Double>,
        val statisticsAccessor: MarginResult.() -> StatisticsSummary?,
    )

    val plotTypes =
        listOf(
            PlotType(
                "End Damage",
                endPlotDamage,
                endPlotDamageBox,
                SimulationMarginResultType.End,
                MarginResult::damage,
                MarginResult::damageSummary),
            PlotType(
                "End Margin",
                endPlotMargin,
                endPlotMarginBox,
                SimulationMarginResultType.End,
                MarginResult::margin,
                MarginResult::marginSummary),
            PlotType(
                "Wipe Damage",
                wipePlotDamage,
                wipePlotDamageBox,
                SimulationMarginResultType.Wipe,
                MarginResult::damage,
                MarginResult::damageSummary),
            PlotType(
                "Wipe Margin",
                wipePlotMargin,
                wipePlotMarginBox,
                SimulationMarginResultType.Wipe,
                MarginResult::margin,
                MarginResult::marginSummary),
        )

    fun addToGraph(resultName: String, result: SimulationResult) {
      plotTypes.forEach { (_, element, boxElement, resultType, accessor, statisticsAccessor) ->
        val data = result.marginResults[resultType] ?: emptyMap()
        addTraces(
            graphDiv = element,
            data =
                data.entries
                    .sortedBy { (k, _) -> k }
                    .map { (groupName, result) ->
                      jsObject {
                        type = "scatter"
                        mode = "lines"
                        name = "$resultName - ${groupName ?: "All"}"
                        x = result.accessor().keys.toTypedArray()
                        y = result.accessor().values.toTypedArray()
                      }
                          as Any
                    }
                    .toTypedArray(),
        )
        addTraces(
            graphDiv = boxElement,
            data =
                data.entries
                    .sortedBy { (k, _) -> k }
                    .map { (groupName, result) ->
                      val summary = result.statisticsAccessor()
                      jsObject {
                        type = "box"
                        boxpoints = false
                        orientation = "h"
                        name = "$resultName - ${groupName ?: "All"}"
                        q1 = arrayOf(summary?.q1 ?: 0.0)
                        median = arrayOf(summary?.median ?: 0.0)
                        q3 = arrayOf(summary?.q3 ?: 0.0)
                        mean = arrayOf(summary?.mean ?: 0.0)
                        sd = arrayOf(summary?.stdDev ?: 0.0)
                        lowerfence = arrayOf(summary?.min ?: 0.0)
                        upperfence = arrayOf(summary?.max ?: 0.0)
                        y = arrayOf("$resultName - ${groupName ?: "All"}")
                      }
                          as Any
                    }
                    .toTypedArray(),
        )
        if (!data.values.all { it.accessor().isEmpty() }) {
          element.removeClass("d-none")
          boxElement.removeClass("d-none")
          element.dispatchEvent(Event("resize"))
          boxElement.dispatchEvent(Event("resize"))
        }
      }
    }

    fun resetGraph() {
      plotTypes.forEach { (plotTitle, element, boxElement, _, _, _) ->
        react(
            graphDiv = element,
            data = arrayOf(),
            layout =
                jsObject {
                  title = plotTitle
                  margin = jsObject {
                    l = 60
                    r = 60
                    b = 60
                    t = 60
                  }
                  xaxis = jsObject { fixedrange = !interactivePlotsCheckbox.checked }
                  yaxis = jsObject { fixedrange = !interactivePlotsCheckbox.checked }
                  if (!interactivePlotsCheckbox.checked) {
                    dragmode = false
                  }
                }
                    as Any,
            config =
                jsObject {
                  responsive = true
                  displayModeBar = interactivePlotsCheckbox.checked
                }
                    as Any,
        )
        react(
            graphDiv = boxElement,
            data = arrayOf(),
            layout =
                jsObject {
                  title = plotTitle
                  margin = jsObject {
                    l = 150
                    r = 120
                    b = 60
                    t = 60
                  }
                  xaxis = jsObject { fixedrange = !interactivePlotsCheckbox.checked }
                  yaxis = jsObject {
                    autorange = "reversed"
                    fixedrange = !interactivePlotsCheckbox.checked
                  }
                  if (!interactivePlotsCheckbox.checked) {
                    dragmode = false
                  }
                }
                    as Any,
            config =
                jsObject {
                  responsive = true
                  displayModeBar = interactivePlotsCheckbox.checked
                }
                    as Any,
        )
        element.addClass("d-none")
        boxElement.addClass("d-none")
      }
    }

    fun resetSavedResultButtons() {
      document
          .getElementsByClassName("saved-results-add-button")
          .multiple<HTMLButtonElement>()
          .forEach { it.disabled = false }
    }

    var savedResultCounter = 0
    saveResultsButton.addEventListener(
        "click",
        {
          GlobalScope.launch {
            val result = simulation?.pollResult() ?: return@launch
            val setup = activeSetup ?: return@launch
            if (!result.done) {
              return@launch
            }
            val resultId = savedResultCounter++
            savedResultsRow.append {
              div("m-1 p-1 border rounded") {
                style = "max-width: 180px; min-width: 180px"
                id = "saved-results-$resultId"
                input(classes = "form-control") {
                  id = "saved-results-name-$resultId"
                  type = InputType.text
                  placeholder = "Name"
                }
                div("mt-1 d-flex") {
                  button(
                      type = ButtonType.button,
                      classes = "btn btn-success flex-grow-1 saved-results-add-button") {
                        id = "saved-results-add-button-$resultId"
                        i("bi bi-plus-lg") {}
                        onClickFunction =
                            onClick@{
                              val nameInput =
                                  document.getElementById("saved-results-name-$resultId")
                                      as HTMLInputElement
                              val name =
                                  nameInput.value.takeIf { it.isNotBlank() } ?: "Result $resultId"
                              if (!done) {
                                return@onClick
                              }
                              addToGraph(name, result)
                              val btn =
                                  document.getElementById("saved-results-add-button-$resultId")
                                      as HTMLButtonElement
                              btn.disabled = true
                            }
                      }
                  button(classes = "btn btn-primary ms-1") {
                    id = "saved-results-load-setup-button-$resultId"
                    i("bi bi-upload") {}
                    onClickFunction = {
                      setSetup(setup)
                      toast("Setup", "Loaded setup", "green")
                    }
                  }
                  button(classes = "btn btn-outline-danger ms-1") {
                    id = "saved-results-cancel-button-$resultId"
                    i("bi bi-x-lg") {}
                    onClickFunction = {
                      document.getElementById("saved-results-$resultId")!!.remove()
                    }
                  }
                }
              }
            }
          }
        })
    clearGraphsButton.addEventListener(
        "click",
        {
          resetGraph()
          resetSavedResultButtons()
        })

    interactiveLogStartButton.addEventListener("click", { interactiveLog.scrollTop = 0.0 })
    interactiveLogUpButton.addEventListener(
        "click",
        {
          val logElements = interactiveLog.children.multiple<HTMLElement>()
          if (logElements.isEmpty()) {
            return@addEventListener
          }

          val indexOfFirstVisible =
              logElements
                  .indexOfFirst { it.offsetTop >= interactiveLog.scrollTop }
                  .takeIf { it >= 0 }
                  ?: logElements.lastIndex
          if (indexOfFirstVisible == 0) {
            return@addEventListener
          }

          val turn =
              logElements[indexOfFirstVisible].attributes["data-turn"]?.value
                  ?: return@addEventListener
          val turnBefore =
              logElements[indexOfFirstVisible - 1].attributes["data-turn"]?.value
                  ?: return@addEventListener
          if (turn == turnBefore) {
            // Scroll to the top of this section
            val entry = logElements.first { it.attributes["data-turn"]?.value == turn }
            interactiveLog.scrollTop = entry.offsetTop.toDouble()
          } else {
            // Scroll to the bottom of the previous section
            val entry = logElements.last { it.attributes["data-turn"]?.value == turnBefore }
            interactiveLog.scrollTop =
                (entry.offsetTop + entry.offsetHeight - interactiveLog.offsetHeight).toDouble()
          }
        })
    interactiveLogDownButton.addEventListener(
        "click",
        {
          val logElements = interactiveLog.children.multiple<HTMLElement>()
          if (logElements.isEmpty()) {
            return@addEventListener
          }

          val indexOfLastVisible =
              logElements
                  .indexOfLast {
                    it.offsetTop + it.offsetHeight <=
                        interactiveLog.scrollTop + interactiveLog.offsetHeight
                  }
                  .takeIf { it >= 0 }
                  ?: 0
          if (indexOfLastVisible == logElements.lastIndex) {
            return@addEventListener
          }

          val turn =
              logElements[indexOfLastVisible].attributes["data-turn"]?.value
                  ?: return@addEventListener
          val turnAfter =
              logElements[indexOfLastVisible + 1].attributes["data-turn"]?.value
                  ?: return@addEventListener
          if (turn == turnAfter) {
            // Scroll to the bottom of this section
            val entry = logElements.last { it.attributes["data-turn"]?.value == turn }
            interactiveLog.scrollTop =
                (entry.offsetTop + entry.offsetHeight - interactiveLog.offsetHeight).toDouble()
          } else {
            // Scroll to the top of the next section
            val entry = logElements.first { it.attributes["data-turn"]?.value == turnAfter }
            interactiveLog.scrollTop = entry.offsetTop.toDouble()
          }
        })
    interactiveLogEndButton.addEventListener(
        "click", { interactiveLog.scrollTop = interactiveLog.scrollHeight.toDouble() })

    interactiveRewindButton.addEventListener(
        "click", { GlobalScope.launch { interactiveSimulation?.sendCommand("rewind") } })
    interactiveSeekBackButton.addEventListener(
        "click", { GlobalScope.launch { interactiveSimulation?.sendCommand("seek_back") } })
    interactiveUndoButton.addEventListener(
        "click", { GlobalScope.launch { interactiveSimulation?.sendCommand("undo") } })
    interactiveRedoButton.addEventListener(
        "click", { GlobalScope.launch { interactiveSimulation?.sendCommand("redo") } })
    interactiveSeekForwardButton.addEventListener(
        "click", { GlobalScope.launch { interactiveSimulation?.sendCommand("seek_forward") } })
    interactiveFastForwardButton.addEventListener(
        "click", { GlobalScope.launch { interactiveSimulation?.sendCommand("fast_forward") } })
    interactiveExportButton.addEventListener(
        "click",
        {
          GlobalScope.launch {
            interactiveSimulation?.sendCommand("export strict")
            val export = interactiveSimulation?.getLog()?.data?.queueStatus?.lastExport
            if (export != null && export.isNotBlank()) {
              val currentStrategy = strategyEditor.value.trim()
              if (currentStrategy.isBlank()) {
                strategyEditor.value = "Moveset:\n$export"
              } else {
                strategyEditor.value = "$currentStrategy\n\nMoveset:\n$export"
              }
              foldAll(strategyEditor)
              toast("Export", "Exported moveset to strategy.", "green")
            }
          }
        })
    interactiveGoButton.addEventListener(
        "click", { GlobalScope.launch { interactiveSimulation?.sendCommand("go") } })

    // Also initializes selectpickers
    updateLocaleText()

    window.onpopstate = { updateSetupFromUrl() }

    addActor() // Start with one already here by default

    finishedLoading.complete(Unit)

    toast("Ready", "Initialization complete.", "green")

    GlobalScope.launch {
      var prev: InteractiveLog? = null
      var lastEstimateUpdateTime = 0.0
      val estimateUpdateInterval = 2000.0
      while (true) {
        try {
          delay(50)
          val time = window.performance.now()
          interactiveSimulation?.let { sim ->
            val log = sim.getLog()
            val data = log?.data
            if (data != null) {
              val isScrolledDown =
                  this@SimulatorClient.interactiveLog.let {
                    it.scrollHeight - it.offsetHeight - it.scrollTop < 1.0
                  }
              this@SimulatorClient.interactiveLog.displayLog(
                  data.entries,
                  interactive = true,
                  prev = prev?.data?.entries ?: emptyList(),
              )

              if (isScrolledDown) {
                this@SimulatorClient.interactiveLog.let {
                  it.scrollTop = it.scrollHeight.toDouble()
                }
              }
              interactiveStatusContainer.displayStatus(data)
              updateInteractiveUi(sim, data.queueStatus, data.error)
              updateDamageEstimate(log.queueInfo)
              lastEstimateUpdateTime = time
            }
            if (time - lastEstimateUpdateTime >= estimateUpdateInterval) {
              updateDamageEstimate(log?.queueInfo)
              lastEstimateUpdateTime = time
            }
            prev =
                if (data != null) {
                  log
                } else {
                  prev?.copy(queueInfo = log?.queueInfo)
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

              val currentIterationsText = result.currentIterations.toString()
              val maxIterationsText = result.maxIterations.toString()
              val progressText =
                  "${(result.currentIterations.toDouble() / result.maxIterations * 100).toFixed(2)}%"
              val runtimeText =
                  if (result.runtime != null) " [${result.runtime!!.toFixed(5)}s]" else ""
              val progressDisplay =
                  "Progress: ${" ".repeat(maxIterationsText.length - currentIterationsText.length)}$currentIterationsText/$maxIterationsText ($progressText)$runtimeText"
              var iterationResultsText =
                  ResultEntry("All").apply { iterationResults.forEach { add(it) } }.format()
              val simpleResults =
                  iterationResults
                      .groupBy { it.result }
                      .map { (result, values) -> result to values.sumOf { it.count } }
                      .sortedWith { a, b ->
                        simulationResultTypeComparator.compare(a.first, b.first)
                      }
              if (iterationResults.any { it.tags.isNotEmpty() }) {
                iterationResultsText +=
                    "\n\n" +
                        ResultEntry("All (Simple)")
                            .apply {
                              simpleResults.forEach { (type, count) ->
                                add(SimulationResultValue(emptyList(), type, count))
                              }
                            }
                            .format()
              }
              resultsProgressText.textContent = progressDisplay
              resultsText.innerHTML = iterationResultsText

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
              resultsRow.removeClass("d-none")

              // Plotly goes upwards from the y-axis, so entries have to be reversed
              val plotEntries = simpleResults.reversed().toMap()
              react(
                  graphDiv = resultsPlot,
                  data =
                      arrayOf(
                          jsObject {
                            type = "bar"
                            x = plotEntries.values.toTypedArray()
                            y = plotEntries.keys.map { it.displayName }.toTypedArray()
                            orientation = "h"
                            marker = jsObject {
                              color = plotEntries.keys.map { it.color }.toTypedArray()
                            }
                          }
                              as Any),
                  layout =
                      jsObject {
                        xaxis = jsObject { range = arrayOf(0, result.currentIterations) }
                        height = simpleResults.size.coerceAtLeast(1) * 30 + 60
                        margin = jsObject {
                          l = 120
                          r = 60
                          b = 40
                          t = 40
                        }
                      }
                          as Any,
                  config =
                      jsObject {
                        responsive = true
                        staticPlot = true
                      }
                          as Any,
              )

              plotTypes.forEach {
                  (plotTitle, element, boxElement, resultType, accessor, statisticsAccessor) ->
                val data = result.marginResults[resultType] ?: emptyMap()
                react(
                    graphDiv = element,
                    data =
                        data.entries
                            .sortedBy { (k, _) -> k }
                            .map { (groupName, result) ->
                              jsObject {
                                type = "scatter"
                                mode = "lines"
                                name = groupName ?: "All"
                                x = result.accessor().keys.toTypedArray()
                                y = result.accessor().values.toTypedArray()
                              }
                                  as Any
                            }
                            .toTypedArray(),
                    layout =
                        jsObject {
                          title = plotTitle
                          margin = jsObject {
                            l = 60
                            r = 60
                            b = 60
                            t = 60
                          }
                          xaxis = jsObject { fixedrange = !interactivePlotsCheckbox.checked }
                          yaxis = jsObject { fixedrange = !interactivePlotsCheckbox.checked }
                          if (!interactivePlotsCheckbox.checked) {
                            dragmode = false
                          }
                        }
                            as Any,
                    config =
                        jsObject {
                          responsive = true
                          displayModeBar = interactivePlotsCheckbox.checked
                        }
                            as Any,
                )
                react(
                    graphDiv = boxElement,
                    data =
                        data.entries
                            .sortedBy { (k, _) -> k }
                            .map { (groupName, result) ->
                              val summary = result.statisticsAccessor()
                              jsObject {
                                type = "box"
                                boxpoints = false
                                orientation = "h"
                                name = groupName ?: "All"
                                q1 = arrayOf(summary?.q1 ?: 0.0)
                                median = arrayOf(summary?.median ?: 0.0)
                                q3 = arrayOf(summary?.q3 ?: 0.0)
                                mean = arrayOf(summary?.mean ?: 0.0)
                                sd = arrayOf(summary?.stdDev ?: 0.0)
                                lowerfence = arrayOf(summary?.min ?: 0.0)
                                upperfence = arrayOf(summary?.max ?: 0.0)
                                y = arrayOf(groupName ?: "All")
                              }
                                  as Any
                            }
                            .toTypedArray(),
                    layout =
                        jsObject {
                          title = plotTitle
                          margin = jsObject {
                            l = 150
                            r = 120
                            b = 60
                            t = 60
                          }
                          xaxis = jsObject { fixedrange = !interactivePlotsCheckbox.checked }
                          yaxis = jsObject {
                            autorange = "reversed"
                            fixedrange = !interactivePlotsCheckbox.checked
                          }
                          if (!interactivePlotsCheckbox.checked) {
                            dragmode = false
                          }
                        }
                            as Any,
                    config =
                        jsObject {
                          responsive = true
                          displayModeBar = interactivePlotsCheckbox.checked
                        }
                            as Any,
                )
                if (data.values.all { it.accessor().isEmpty() }) {
                  element.addClass("d-none")
                  boxElement.addClass("d-none")
                } else {
                  element.removeClass("d-none")
                  boxElement.removeClass("d-none")
                  element.dispatchEvent(Event("resize"))
                  boxElement.dispatchEvent(Event("resize"))
                }
              }
              logFilterContainer.addClass("d-none")
              done = result.done
              if (result.done) {
                simulateButton.disabled = false
                cancelButton.disabled = true
                resetSavedResultButtons()
                if (result.log != null) {
                  updateLogFilter(
                      logFilterContainer,
                      logText,
                      errorRow,
                      errorText,
                      simulation!!,
                      result,
                  )
                }
                if (result.error != null) {
                  toast("Simulate", "Completed with errors.", "orange")
                } else if (result.cancelled) {
                  toast("Simulate", "Cancelled.", "gold")
                } else {
                  toast("Simulate", "Completed successfully.", "green")
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
  private val includedCount: Int
    get() = totalCount - excludedCount

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

  private fun formatRecursive(): List<String> =
      when (children.size) {
        0 -> listOf(formatSelf())
        1 ->
            children.values.single().let {
              ResultEntry("$name-${it.name}", parent, it.children, totalCount, excludedCount)
                  .formatRecursive()
            }
        else -> listOf(formatSelf()) + children.values.flatMap { it.formatRecursive() }.indented()
      }

  private fun formatSelf(): String =
      if (parent != null) {
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

  operator fun get(tags: List<String>): ResultEntry =
      if (tags.isEmpty()) {
        this
      } else {
        children.getOrPut(tags[0]) { ResultEntry(tags[0], this) }[tags.drop(1)]
      }
}

fun DataSimulationOption<*>.subtext(locale: String) =
    if (descriptionIcons?.isEmpty() != false && description == null) {
      ""
    } else {
      "${(descriptionIcons ?: emptyList()).joinToString("%%%")}%%%${description?.getLocalized(locale) ?: ""}"
    }

fun List<String>.indented() = map { "    $it" }

inline fun jsObject(init: dynamic.() -> Unit): dynamic {
  val o = js("{}")
  init(o)
  return o
}
