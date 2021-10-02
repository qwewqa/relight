package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.grammar.parseToEnd

fun interface StrategyParser {
    fun parse(value: String): () -> Strategy
}

val strategyParsers = mapOf(
    "Simple" to StrategyParser {
        val strategy = SimpleStrategy(SimpleStrategyGrammar.parseToEnd(it))
        return@StrategyParser { strategy }
    }
)
