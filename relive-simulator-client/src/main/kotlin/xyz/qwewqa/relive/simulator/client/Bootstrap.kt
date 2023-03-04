package xyz.qwewqa.relive.simulator.client

@JsName("bootstrap")
external object Bootstrap {
  class Toast(element: dynamic, options: dynamic = definedExternally) {
    fun show()
    fun hide()
    fun dispose()
  }

  class Collapse(element: dynamic, options: dynamic = definedExternally) {
    fun toggle()
    fun show()
    fun hide()
    fun dispose()
  }

  class Modal(element: dynamic, options: dynamic = definedExternally) {
    fun toggle()
    fun show()
    fun hide()
    fun dispose()
  }
}
