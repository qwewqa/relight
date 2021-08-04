package xyz.qwewqa.relivesim.presets.memoir

import xyz.qwewqa.relivesim.dsl.memoirPrototype
import xyz.qwewqa.relivesim.presets.DamageDealtAutoEffect
import xyz.qwewqa.relivesim.presets.DexterityAutoEffect
import xyz.qwewqa.relivesim.stage.percent

val UrashimaTaroPerformanceFlyer = memoirPrototype + {
    name = "Urashima Taro Performance Flyer"
    stats {
        actPower = 149
    }
    +DamageDealtAutoEffect(8.percent)
    +DexterityAutoEffect(16.percent)
}
val TurtleRui = UrashimaTaroPerformanceFlyer
