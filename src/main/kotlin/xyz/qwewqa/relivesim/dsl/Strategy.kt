package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.strategy.FixedStrategy
import xyz.qwewqa.relivesim.stage.strategy.FixedStrategyContext

fun fixedStrategy(strategy: FixedStrategyContext.() -> Unit) = FixedStrategy(strategy)