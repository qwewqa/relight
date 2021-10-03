package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.grammar.parseToEnd
import xyz.qwewqa.relive.simulator.core.stage.strategy.conpletestrategy.CompleteStrategy
import xyz.qwewqa.relive.simulator.core.stage.strategy.conpletestrategy.CsParser

fun interface StrategyParser {
    fun parse(value: String): () -> Strategy
}

val strategyParsers = mapOf(
    "Simple" to StrategyParser {
        val strategy = SimpleStrategy(SimpleStrategyGrammar.parseToEnd(it))
        return@StrategyParser { strategy }
    },
    "Complete" to StrategyParser {
        val script = CsParser.parseToEnd(it)
        return@StrategyParser { CompleteStrategy(script) }
    },
)
