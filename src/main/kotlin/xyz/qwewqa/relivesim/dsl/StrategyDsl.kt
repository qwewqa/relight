package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.strategy.FixedStrategy
import xyz.qwewqa.relivesim.stage.strategy.FixedStrategyContext
import xyz.qwewqa.relivesim.stage.strategy.StandardStrategy
import xyz.qwewqa.relivesim.stage.strategy.StandardStrategyContext

fun fixedStrategy(strategy: FixedStrategyContext.() -> Unit) = FixedStrategy(strategy)
fun standardStrategy(strategy: StandardStrategyContext.() -> Unit) = StandardStrategy(strategy)
