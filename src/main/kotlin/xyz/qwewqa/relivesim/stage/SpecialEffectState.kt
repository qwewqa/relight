package xyz.qwewqa.relivesim.stage

data class SpecialEffectState(
    var apDown: MutableSet<Any> = mutableSetOf(),
    var upUp: MutableSet<Any> = mutableSetOf(),
)
