@file:OptIn(DelicateCoroutinesApi::class)

package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.dom.clear
import kotlinx.html.TagConsumer
import kotlinx.html.dom.append
import kotlinx.html.js.div
import kotlinx.html.js.img
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import xyz.qwewqa.relive.simulator.common.ActCardStatus
import xyz.qwewqa.relive.simulator.common.InteractiveQueueStatus

fun updateInteractiveUi(simulation: InteractiveSimulation, status: InteractiveQueueStatus?) {
    val timelineContainer = document.getElementById("interactive-timeline-container") as HTMLElement
    timelineContainer.updateTimeline(simulation, status)
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
        div("interactive-timeline-connector-bg") {  }
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
                        div("interactive-timeline-marker") {  }
                    }
                    div("interactive-timeline-item $type") {
                        div("interactive-timeline-connector-end")
                        cardImage(card)
                    }
                }
                else -> {
                    div("interactive-timeline-item $type") {
                        div("interactive-timeline-connector-start")
                        div("interactive-timeline-marker") {  }
                    }
                    repeat(card.cost - 2) {
                        div("interactive-timeline-item $type") {
                            div("interactive-timeline-connector-middle")
                            div("interactive-timeline-marker") {  }
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
                div("interactive-timeline-marker") {  }
            }
        }
    }
}
