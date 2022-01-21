package xyz.qwewqa.relive.simulator.core.stage

class HierarchicalStringBuilder(val name: String) {
    private val body = mutableListOf<String>()

    operator fun String.unaryPlus() {
        if (isNotBlank()) {
            body += this
        }
    }

    fun br() {
        body += "\n"
    }

    inline operator fun String.invoke(block: HierarchicalStringBuilder.() -> Unit) {
        +HierarchicalStringBuilder(this).apply(block).build()
    }

    fun build() = if (body.isNotEmpty()) "$name:\n${body.joinToString("\n").prependIndent()}" else ""
}

inline fun hierarchicalString(name: String, block: HierarchicalStringBuilder.() -> Unit) =
    HierarchicalStringBuilder(name).apply(block).build()
