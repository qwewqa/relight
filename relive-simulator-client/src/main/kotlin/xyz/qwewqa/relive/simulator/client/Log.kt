package xyz.qwewqa.relive.simulator.client

import xyz.qwewqa.relive.simulator.common.FormattedLogEntry
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
        LogCategory.COMMAND -> "#E0F2F1"
        else -> "#FFFFFF"
    }

fun FormattedLogEntry.toHtml() = """
<span class="log-entry" style="background-color: ${category.backgroundColor}"><b>$turn.$tile.$move [${tags.joinToString(" / ")}]</b>${
    if (contents.contains("\n")) {
        "\n<span style=\"padding-left: 2em; display: block; white-space: pre; overflow-x: auto\">$contents</span>"
    } else {
        " $contents"
    }
}</span>
""".trimIndent()

fun List<FormattedLogEntry>.toHtml() = joinToString("") { it.toHtml() }
