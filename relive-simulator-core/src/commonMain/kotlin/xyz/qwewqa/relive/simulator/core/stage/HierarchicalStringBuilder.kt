package xyz.qwewqa.relive.simulator.core.stage

class HierarchicalStringBuilder(val name: String, val indent: String) {
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
    +HierarchicalStringBuilder(this, indent).apply(block).build()
  }

  fun build() =
      if (body.isNotEmpty()) "$name:\n${body.joinToString("\n").prependIndent(indent)}" else ""
}

inline fun hierarchicalString(
    name: String,
    indent: String = "    ",
    block: HierarchicalStringBuilder.() -> Unit
) = HierarchicalStringBuilder(name, indent).apply(block).build()
