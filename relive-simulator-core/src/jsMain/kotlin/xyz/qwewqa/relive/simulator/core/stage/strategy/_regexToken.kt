package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.lexer.Token

actual fun _regexToken(pattern: String, ignore: Boolean): Token =
    JsRegexToken(null, pattern, ignore)

private class JsRegexToken : Token {
  private val pattern: String
  private val regex: Regex

  constructor(name: String?, patternString: String, ignored: Boolean) : super(name, ignored) {
    pattern = patternString
    regex = pattern.toRegex()
  }

  override fun match(input: CharSequence, fromIndex: Int): Int =
      regex.matchAt(input, fromIndex)?.range?.let {
        val length = it.last - it.first + 1
        length
      }
          ?: 0

  override fun toString(): String = "${name ?: ""} [$pattern]" + if (ignored) " [ignorable]" else ""
}
