package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.grammar.parseToEnd
import xyz.qwewqa.relive.simulator.core.stage.strategy.complete.CompleteStrategy
import xyz.qwewqa.relive.simulator.core.stage.strategy.complete.CsParser

fun interface StrategyParser {
  fun parse(value: String): () -> Strategy
}

val strategyParsers =
    mapOf(
        "Simple" to
            StrategyParser {
              val data = SimpleStrategyGrammar.parseToEnd(it)
              return@StrategyParser { SimpleStrategy(data) }
            },
        "Complete" to
            StrategyParser {
              val script = CsParser.parseToEnd(it)
              return@StrategyParser { CompleteStrategy(script) }
            },
    )

val bossStrategyParsers =
    mapOf(
        "Simple" to
            StrategyParser {
              val strategy =
                  BossSimpleStrategy(
                      SimpleStrategyGrammar.parseToEnd(it)
                          .elementAtOrElse(0) {
                            error("Expected exactly one moveset in boss strategy.")
                          }
                          .commands)
              return@StrategyParser { strategy }
            },
    )
