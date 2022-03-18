package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.CustomEvent
import org.w3c.dom.HTMLElement
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
