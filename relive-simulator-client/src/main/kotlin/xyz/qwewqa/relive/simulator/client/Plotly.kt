package xyz.qwewqa.relive.simulator.client

import org.w3c.dom.Element

external object Plotly {
    fun newPlot(
        graphDiv: Any,
        data: Array<Any>,
        layout: Any = definedExternally,
        config: Any = definedExternally,
    )

    fun react(
        graphDiv: Any,
        data: Array<Any>,
        layout: Any = definedExternally,
        config: Any = definedExternally,
    )
}
