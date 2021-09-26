package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.grammar.parseToEnd

fun interface StrategyParser {
    fun parse(value: String): Strategy
}

val strategyParsers = mapOf(
    "simple" to StrategyParser {
        SimpleStrategy(SimpleStrategyGrammar.parseToEnd(it)) }
)
