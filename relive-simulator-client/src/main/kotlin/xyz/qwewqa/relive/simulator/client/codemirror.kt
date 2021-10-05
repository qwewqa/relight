package xyz.qwewqa.relive.simulator.client

import org.w3c.dom.HTMLTextAreaElement

@JsModule("codemirror")
@JsNonModule
external fun CodeMirror(textAreaElement: dynamic, config: dynamic): dynamic
