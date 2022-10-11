@file:OptIn(DelicateCoroutinesApi::class)

package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.dom.clear
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.div
import kotlinx.html.js.img
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import xyz.qwewqa.relive.simulator.common.ActCardStatus
import xyz.qwewqa.relive.simulator.common.ActionStatus
import xyz.qwewqa.relive.simulator.common.InteractiveQueueStatus

fun updateInteractiveUi(simulation: InteractiveSimulation, status: InteractiveQueueStatus?) {
    val timelineContainer = document.getElementById("interactive-timeline-container") as HTMLElement
    timelineContainer.updateTimeline(simulation, status)
    val interactiveActsRow = document.getElementById("interactive-acts-row") as HTMLElement
    interactiveActsRow.updateActs(simulation, status)
}

private fun HTMLElement.updateTimeline(simulation: InteractiveSimulation, status: InteractiveQueueStatus?) {
    clear()

    if (status == null) {
        return
    }

    fun TagConsumer<HTMLElement>.cardImage(card: ActCardStatus) {
        div("interactive-timeline-image-container") {
            div("interactive-queue-image-container") {
                img(classes = "queue-actor-img") { src = "img/large_icon/1_${card.dressId}.png" }
                img(classes = "queue-act-img") { src = "img/skill_icon/skill_icon_${card.iconId}.png" }
                if (card.isSupport) {
                    img(classes = "queue-support-indicator") { src = "img/common/icon_support_dress.png" }
                }
                onClickFunction = {
                    GlobalScope.launch {
                        simulation.sendCommand("unqueue ${card.handIndex}")
                    }
                }
            }
        }
    }

    append {
        div("interactive-timeline-connector-bg") { }
        status.queue.forEach { card ->
            val type = when {
                card.isClimax -> "interactive-timeline-climax"
                else -> "interactive-timeline-normal"
            }
            when (card.cost) {
                1 -> {
                    div("interactive-timeline-item $type") {
                        cardImage(card)
                    }
                }

                2 -> {
                    div("interactive-timeline-item $type") {
                        div("interactive-timeline-connector-start")
                        div("interactive-timeline-marker") { }
                        onClickFunction = {
                            GlobalScope.launch {
                                simulation.sendCommand("unqueue ${card.handIndex}")
                            }
                        }
                    }
                    div("interactive-timeline-item $type") {
                        div("interactive-timeline-connector-end")
                        cardImage(card)
                    }
                }

                else -> {
                    div("interactive-timeline-item $type") {
                        div("interactive-timeline-connector-start")
                        div("interactive-timeline-marker") { }
                        onClickFunction = {
                            GlobalScope.launch {
                                simulation.sendCommand("unqueue ${card.handIndex}")
                            }
                        }
                    }
                    repeat(card.cost - 2) {
                        div("interactive-timeline-item $type") {
                            div("interactive-timeline-connector-middle")
                            div("interactive-timeline-marker") { }
                            onClickFunction = {
                                GlobalScope.launch {
                                    simulation.sendCommand("unqueue ${card.handIndex}")
                                }
                            }
                        }
                    }
                    div("interactive-timeline-item $type") {
                        div("interactive-timeline-connector-end")
                        cardImage(card)
                    }
                }
            }
        }
        repeat(6 - status.queue.sumOf { it.cost }) {
            div("interactive-timeline-item interactive-timeline-empty") {
                div("interactive-timeline-marker") { }
            }
        }
    }
}

private fun HTMLElement.updateActs(simulation: InteractiveSimulation, status: InteractiveQueueStatus?) {
    clear()

    if (status == null) {
        return
    }

    fun TagConsumer<HTMLElement>.act(card: ActCardStatus?) {
        div(
            "interactive-act ${
                when (card?.status) {
                    ActionStatus.QUEUED -> "interactive-act-queued"
                    ActionStatus.TOO_EXPENSIVE -> "interactive-act-too-expensive"
                    else -> ""
                }
            }"
        ) {
            div("interactive-queue-image-container") {
                if (card == null) {
                    img(classes = "queue-actor-img") { src = "img/common/icon_empty_large.png" }
                } else {
                    img(classes = "queue-actor-img") { src = "img/large_icon/1_${card.dressId}.png" }
                    img(classes = "queue-act-img") { src = "img/skill_icon/skill_icon_${card.iconId}.png" }
                    if (card.isSupport) {
                        img(classes = "queue-support-indicator") { src = "img/common/icon_support_dress.png" }
                    }
                    span(
                        "queue-act-cost ${
                            when {
                                card.cost > card.baseCost -> "queue-act-cost-up"
                                card.cost < card.baseCost -> "queue-act-cost-down"
                                else -> ""
                            }
                        }"
                    ) {
                        +card.cost.toString()
                    }
                    when (card.status) {
                        ActionStatus.READY -> onClickFunction = {
                            GlobalScope.launch {
                                simulation.sendCommand("queue ${card.handIndex}")
                            }
                        }

                        ActionStatus.QUEUED -> onClickFunction = {
                            GlobalScope.launch {
                                simulation.sendCommand("unqueue ${card.handIndex}")
                            }
                        }

                        else -> {}
                    }
                    if (card.status == ActionStatus.TOO_EXPENSIVE) {
                        span("queue-act-too-expensive-text") { +"C" }
                    }
                }
            }
            button(
                classes = "btn btn-sm ${
                    when {
                        card == null || card.status == ActionStatus.HELD -> "btn-secondary"
                        card.isClimax -> "btn-secondary interactive-act-button-climax"
                        status.hold != null -> "btn-warning"
                        else -> "btn-primary"
                    }
                } interactive-act-button"
            ) {
                role = "button"
                i(
                    "bi ${
                        when {
                            card == null || card.status == ActionStatus.HELD -> "bi-archive"
                            card.isClimax -> "bi-stars"
                            status.hold != null -> "bi-arrow-bar-down"
                            else -> "bi-arrow-bar-up"
                        }
                    }"
                )
                if (card == null || card.status == ActionStatus.HELD || card.status == ActionStatus.QUEUED || card.isClimax || !status.holdAction) {
                    disabled = true
                } else {
                    onClickFunction = if (status.hold != null) {
                        {
                            GlobalScope.launch {
                                simulation.sendCommand("discard ${card.handIndex}")
                            }
                        }
                    } else {
                        {
                            GlobalScope.launch {
                                simulation.sendCommand("hold ${card.handIndex}")
                            }
                        }
                    }
                }
            }
        }
    }

    append {
        button(
            classes = "btn btn-secondary ${
                when {
                    status.canClimax -> "interactive-climax-button-available"
                    status.climaxTurns > 0 -> "interactive-climax-button-activated"
                    else -> ""
                }
            }"
        ) {
            role = "button"
            id = "interactive-climax-button"
            if (status.climaxTurns > 0) {
                +"${status.climaxTurns}"
            }
            onClickFunction = {
                GlobalScope.launch {
                    simulation.sendCommand("climax")
                }
            }
            disabled = !status.canClimax
        }
        div {
            id = "interactive-hold-container"
            act(status.hold)
        }
        div {
            id = "interactive-acts-container"
            status.hand.forEach { act(it) }
        }
    }
}
