package xyz.qwewqa.relive.simulator.client.sortable

import org.w3c.dom.Element

@JsModule("sortablejs")
@JsNonModule
external object Sortable {
    object Sortable {
        fun create(element: Element, config: dynamic): dynamic
    }
}
