package xyz.qwewqa.relive.simulator.core.stage.common

enum class DescriptionUnit(val id: Int, val format: (value: Any) -> String) {
    None(0, { value -> "$value" }),
    Percent(1, { value -> "$value%" }),
    Turns(2, { value -> "${value}t" }),
    Times(3, { value -> "${value}x" }),
    Kinds(4, { value -> "${value}#" }),
    ;

    companion object {
        private val byId = values().associateBy { it.id }

        fun fromId(id: Int) = byId[id] ?: None
    }
}
