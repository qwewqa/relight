package xyz.qwewqa.relive.simulator.core.stage.actor

enum class DamageType(val id: Int? = null) {
  Neutral,
  Normal(1),
  Special(2),
}
