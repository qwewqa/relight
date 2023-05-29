package xyz.qwewqa.relive.simulator.client

@JsModule("plotly.js-dist-min")
@JsNonModule
external object Plotly {
  fun newPlot(
      graphDiv: Any,
      data: Array<Any>,
      layout: Any = definedExternally,
      config: Any = definedExternally,
  )

  fun react(
      graphDiv: Any,
      data: Array<Any> = definedExternally,
      layout: Any = definedExternally,
      config: Any = definedExternally,
  )

  fun addTraces(
      graphDiv: Any,
      data: Any,
      index: Int = definedExternally,
  )

  fun deleteTraces(
      graphDiv: Any,
      index: Any,
  )
}
