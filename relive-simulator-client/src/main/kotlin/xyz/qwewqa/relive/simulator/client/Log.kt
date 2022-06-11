package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.CustomEvent
import org.w3c.dom.HTMLElement
import xyz.qwewqa.relive.simulator.common.InteractiveLogData
import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.common.LogCategory

val LogCategory.backgroundColor
    get() = when (this) {
        LogCategory.DEFAULT -> "#F5F5F5"
        LogCategory.EMPHASIS -> "#E8EAF6"
        LogCategory.WARNING -> "#FFF9C4"
        LogCategory.ERROR -> "#F8BBD0"
        LogCategory.DAMAGE -> "#FFEBEE"
        LogCategory.HEAL -> "#E8F5E9"
        LogCategory.BUFF -> "#E3F2FD"
        LogCategory.BRILLIANCE -> "#FFF8E1"
        LogCategory.USER -> "#E0F7FA"
        LogCategory.COMMAND -> "#ECEFF1"
        else -> "#FFFFFF"
    }

private var idCounter = 0


fun HTMLElement.displayStatus(data: InteractiveLogData) {
    clear()
    val bossWidth = when(data.bossStatus?.size) {
        1 -> 12
        2 -> 6
        3 -> 4
        4 -> 6
        5 -> 4
        else -> 4
    }
    val playerWidth = when(data.playerStatus?.size) {
        1 -> 12
        2 -> 6
        3 -> 4
        4 -> 6
        5 -> 4
        else -> 4
    }
    append {
        div(classes="row justify-content-evenly") {
            // Reversed since frontmost is the first in the list
            data.bossStatus?.reversed()?.forEach { status ->
                div(classes = "col-$bossWidth") {
                    p(classes = "mt-1 mb-0") {
                        style = "font-size: 0.75rem;"
                        +status.name
                    }
                    div(classes = "progress") {
                        style = "font-size: 0.7rem;height: 0.8rem;"
                        div(classes = "progress-bar bg-danger") {
                            style = "width: ${status.hp.toDouble() / status.maxHp * 100}%;font-weight: bold;"
                            +"${status.hp}/${status.maxHp}"
                        }
                    }
                }
            }
        }
        div(classes="row justify-content-evenly") {
            data.playerStatus?.reversed()?.forEach { status ->
                div(classes = "col-$playerWidth") {
                    p(classes = "mt-1 mb-0") {
                        style = "font-size: 0.75rem;"
                        +status.name
                    }
                    div(classes = "progress") {
                        style = "font-size: 0.7rem;height: 0.8rem;"
                        div(classes = "progress-bar bg-success") {
                            style = "width: ${status.hp.toDouble() / status.maxHp * 100}%;font-weight: bold;"
                            +"${status.hp}/${status.maxHp}"
                        }
                    }
                    div(classes = "progress") {
                        style = "font-size: 0.7rem;height: 0.8rem;margin-top: 0.1rem"
                        div(classes = "progress-bar bg-warning") {
                            style = "width: ${status.brilliance}%"
                            span {
                                style="color: black;font-weight: bold;"
                                +"${status.brilliance}"
                            }
                        }
                    }
                }
            }
        }
    }
}

fun HTMLElement.displayLog(log: List<LogEntry>, interactive: Boolean) {
    clear()

    val lastSummaryIndex = log.indexOfLast { it.summary != null }.takeIf { interactive }
    append {
        log.forEachIndexed { i, entry ->
            entry.run {
                div(classes = "log-entry") {
                    style = "background-color: ${category.backgroundColor};"
                    when {
                        summary != null -> {
                            val collapseId = "log-contents-${idCounter++}"
                            span {
                                b {
                                    +"$turn.$tile.$move [${tags.joinToString(" / ")}]"
                                }
                                +" $summary "
                                if (i != lastSummaryIndex) {
                                    span {
                                        +"["
                                        a {
                                            role = "button"
                                            href = "#"
                                            attributes["data-bs-toggle"] = "collapse"
                                            attributes["data-bs-target"] = "#$collapseId"
                                            +"details"
                                        }
                                        +"]"
                                    }
                                }
                            }
                            div(classes=if (i != lastSummaryIndex) "collapse" else "") {
                                id = collapseId
                                span {
                                    style = "padding-left: 1em;display: block;white-space: pre;overflow-x: auto;"
                                    processLogContent(content)
                                }
                            }
                        }
                        content.contains("\n") -> {
                            span {
                                b {
                                    +"$turn.$tile.$move [${tags.joinToString(" / ")}]"
                                }
                            }
                            span {
                                style = "padding-left: 1em;display: block;white-space: pre;overflow-x: auto;"
                                processLogContent(content)
                            }
                        }
                        else -> {
                            span {
                                b {
                                    +"$turn.$tile.$move [${tags.joinToString(" / ")}]"
                                }
                                +" "
                                processLogContent(content)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Suppress("RegExpRedundantEscape") // JS doesn't like the unescaped ]
private val replacementRegex = """@(\[(.*?)\])?\((.*?):(.*?)\)""".toRegex()

private fun FlowOrInteractiveOrPhrasingContent.processLogContent(content: String) {
    val split = content.split(replacementRegex)

    replacementRegex.findAll(content).forEachIndexed { index, match ->
        +split[index] // Add the previous split

        val disp = match.groups[2]?.value ?: ""
        val name = match.groups[3]!!.value.trim()
        val data = match.groups[4]!!.value.trim()

        fun imageReplacement(url: (Int) -> String) {
            val id = data.toIntOrNull()
            if (id != null && id != -1) {
                img {
                    style = "height: 1em;"
                    src = url(id)
                }
            }
        }

        when (name) {
            "dress" -> imageReplacement { "img/large_icon/1_$it.png" }
            "memoir" -> imageReplacement { "img/large_icon/2_$it.png" }
            "act" -> imageReplacement { "img/skill_icon/skill_icon_$it.png" }
            "command" -> a(href = "#") {
                title = data
                onClickFunction = { e ->
                    document.dispatchEvent(CustomEvent("sendInteractiveCommand", jsObject { detail = data }))
                    e.preventDefault()
                }
                +disp
            }
            else -> {}
        }
    }

    +split.last()
}
