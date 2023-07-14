package xyz.qwewqa.relive.simulator.client

@JsModule("lz-string")
@JsNonModule
external object LZString {
  fun compress(string: String): String
  fun decompress(string: String): String
  fun compressToEncodedURIComponent(string: String): String
  fun decompressFromEncodedURIComponent(string: String): String
}
