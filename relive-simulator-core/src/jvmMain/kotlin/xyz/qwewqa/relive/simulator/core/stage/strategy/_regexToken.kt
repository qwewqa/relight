package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.lexer.RegexToken
import com.github.h0tk3y.betterParse.lexer.Token

actual fun reToken(pattern: String, ignore: Boolean): Token = RegexToken(null, pattern, ignore)
