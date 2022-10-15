@file:JsModule("@codemirror/view")
@file:JsNonModule

package xyz.qwewqa.relive.simulator.client.codemirror

external val keymap: dynamic
external val highlightSpecialChars: dynamic
external val drawSelection: dynamic
external val highlightActiveLine: dynamic
external val dropCursor: dynamic
external val rectangularSelection: dynamic
external val crosshairCursor: dynamic
external val lineNumbers: dynamic
external val highlightActiveLineGutter: dynamic


external class EditorView(args: dynamic) {
    val state: dynamic

    fun dispatch(args: dynamic)
}
