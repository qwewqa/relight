package xyz.qwewqa.relive.simulator.client

@JsModule("js-base64")
@JsNonModule
external object Base64 {
    fun encode(string: String): String
    fun decode(string: String): String
    fun encodeURI(string: String): String
    fun decodeURI(string: String): String
}
