package xyz.qwewqa.relive.simulator.client.bootstrap

@Suppress("ClassName")
@JsName("bootstrap")
external object Bootstrap {
    class Toast(element: dynamic, options: dynamic = definedExternally) {
        fun show()
        fun hide()
        fun dispose()
    }
}