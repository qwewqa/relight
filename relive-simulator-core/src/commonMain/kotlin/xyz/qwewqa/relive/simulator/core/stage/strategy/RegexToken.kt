package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.lexer.Language
import com.github.h0tk3y.betterParse.lexer.Token

// To address an issue in Kotlin 1.7+ with the original Kotlin/JS RegexToken implementation
expect fun _regexToken(
    @Language("RegExp", "", "") pattern: String,
    ignore: Boolean = false
): Token
