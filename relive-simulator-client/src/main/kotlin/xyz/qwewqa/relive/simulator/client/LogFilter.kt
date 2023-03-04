package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.dom.addClass
import kotlinx.dom.clear
import kotlinx.dom.removeClass
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.div
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import xyz.qwewqa.relive.simulator.common.FilterLogRequest
import xyz.qwewqa.relive.simulator.common.FilterLogResponse
import xyz.qwewqa.relive.simulator.common.SimulationResult

@OptIn(DelicateCoroutinesApi::class)
fun updateLogFilter(
    logFilterContainer: HTMLElement,
    logText: HTMLElement,
    errorRow: HTMLElement,
    errorText: HTMLElement,
    simulation: Simulation,
    result: SimulationResult,
) {
  val resultTypes = result.results.map { it.result }.toSet().toList()
  logFilterContainer.removeClass("d-none")
  logFilterContainer.clear()
  logFilterContainer.append {
    var lastRequest: FilterLogRequest? = null
    var lastResponse: FilterLogResponse? = null
    suspend fun updateLogDisplay(request: FilterLogRequest) {
      lastRequest = request
      val response = simulation.filterLog(request)
      lastResponse = response
      if (lastRequest == request) {
        logText.displayLog(response.log ?: emptyList(), interactive = false)
        if (response.error != null) {
          errorText.textContent = response.error
          errorRow.removeClass("d-none")
        } else {
          errorRow.addClass("d-none")
        }
        if (response.resultCount > 0) {
          document.getElementById("log-filter-nav-buttons")?.removeClass("d-none")
        } else {
          document.getElementById("log-filter-nav-buttons")?.addClass("d-none")
        }
        document
            .getElementsByClassName("log-filter-nav-button-back")
            .multiple<HTMLButtonElement>()
            .forEach { it.disabled = request.index == 0 }
        document
            .getElementsByClassName("log-filter-nav-button-forward")
            .multiple<HTMLButtonElement>()
            .forEach { it.disabled = request.index == response.resultCount - 1 }
        (document.getElementById("log-index-input") as HTMLInputElement).value =
            (request.index + 1).toString()
      }
    }
    div(classes = "row g-1") {
      div(classes = "col-4 col-md-auto") {
        label(classes = "visually-hidden") {
          htmlFor = "log-min-damage-input"
          +"Min Dmg"
        }
        input(classes = "form-control") {
          id = "log-min-damage-input"
          size = "9"
          placeholder = "Min Dmg"
        }
      }
      div(classes = "col-4 col-md-auto") {
        label(classes = "visually-hidden") {
          htmlFor = "log-max-damage-input"
          +"Max Dmg"
        }
        input(classes = "form-control") {
          id = "log-max-damage-input"
          size = "9"
          placeholder = "Max Dmg"
        }
      }
      div(classes = "col-4 col-md-auto") {
        label(classes = "visually-hidden") {
          htmlFor = "log-result-type"
          +"Type"
        }
        select(classes = "form-select") {
          id = "log-result-type"
          option {
            selected = true
            value = ""
            +"Any"
          }
          resultTypes.forEachIndexed { i, resultType ->
            option {
              value = i.toString()
              +resultType.displayName
            }
          }
        }
      }
      div(classes = "col-auto") {
        button(classes = "btn btn-primary") {
          id = "log-filter-button"
          type = ButtonType.button
          +"Filter"
          onClickFunction = {
            GlobalScope.launch {
              val minDamageInput =
                  document.getElementById("log-min-damage-input").shorthandIntegerInput()
              val maxDamageInput =
                  document.getElementById("log-max-damage-input").shorthandIntegerInput()
              val resultTypeInput = document.getElementById("log-result-type").singleSelect(false)
              val minDamage = minDamageInput.value
              val maxDamage = maxDamageInput.value
              val resultType =
                  resultTypeInput.value.toIntOrNull()?.let { resultTypes.getOrNull(it) }
              updateLogDisplay(
                  FilterLogRequest(
                      resultType,
                      minDamage,
                      maxDamage,
                      0,
                  ),
              )
            }
          }
        }
      }
    }
    div(classes = "d-flex mt-3 gap-1 justify-content-center justify-content-md-start d-none") {
      id = "log-filter-nav-buttons"
      button(classes = "btn btn-secondary log-filter-nav-button-back") {
        id = "log-back-button"
        type = ButtonType.button
        i(classes = "bi bi-caret-left-fill") {}
        onClickFunction = {
          GlobalScope.launch {
            val request = lastRequest?.let { it.copy(index = it.index - 1) }
            if (request == null || request.index < 0) {
              return@launch
            }
            updateLogDisplay(request)
          }
        }
      }
      div {
        label(classes = "visually-hidden") {
          htmlFor = "log-index-input"
          +"Index"
        }
        input(classes = "form-control text-center") {
          id = "log-index-input"
          size = "4"
          placeholder = "Index"
          attributes["inputmode"] = "numeric"
          attributes["pattern"] = "[0-9]*"
          onChangeFunction = { ev ->
            GlobalScope.launch {
              var value = (ev.target as HTMLInputElement).value.toIntOrNull() ?: return@launch
              val resultCount = lastResponse?.resultCount ?: return@launch
              when {
                value <= 0 -> {
                  value = 1
                }
                value > resultCount -> {
                  value = resultCount
                }
              }
              updateLogDisplay(lastRequest?.copy(index = value - 1) ?: return@launch)
            }
          }
        }
      }
      button(classes = "btn btn-secondary log-filter-nav-button-forward") {
        id = "log-next-button"
        type = ButtonType.button
        i(classes = "bi bi-caret-right-fill") {}
        onClickFunction = {
          GlobalScope.launch {
            val request = lastRequest?.let { it.copy(index = it.index + 1) }
            if (request == null || request.index >= (lastResponse?.resultCount ?: 0)) {
              return@launch
            }
            updateLogDisplay(request)
          }
        }
      }
    }
  }
}
