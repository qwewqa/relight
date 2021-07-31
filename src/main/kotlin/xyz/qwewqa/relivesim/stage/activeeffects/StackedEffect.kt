package xyz.qwewqa.relivesim.stage.activeeffects

enum class StackedEffect(val effectClass: EffectClass) {
    Evade(EffectClass.Positive),
    Fortitude(EffectClass.Positive),
    Revive(EffectClass.Positive),
}