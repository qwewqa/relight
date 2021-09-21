package xyz.qwewqa.relive.simulator.presets.memoir

import xyz.qwewqa.relive.simulator.stage.actor.StatData
import xyz.qwewqa.relive.simulator.stage.autoskill.new
import xyz.qwewqa.relive.simulator.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.stage.passive.DamageDealtPassive
import xyz.qwewqa.relive.simulator.stage.passive.DexterityPassive

val UrashimaTaroPerformanceFlyer = Memoir(
    name = "Urashima Taro Performance Flyer",
    stats = StatData(
        actPower = 149,
    ),
    autoskills = listOf(
        DamageDealtPassive.new(8),
        DexterityPassive.new(16),
    )
)
