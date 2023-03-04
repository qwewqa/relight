package xyz.qwewqa.relive.simulator.core.stage.condition

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun interface Condition {
  fun evaluate(actor: Actor): Boolean
}

@OptIn(ExperimentalContracts::class)
inline fun Condition.applyIfTrue(actor: Actor, block: Actor.() -> Unit) {
  contract { callsInPlace(block, InvocationKind.AT_MOST_ONCE) }
  if (evaluate(actor)) actor.block()
}

data class NamedCondition(
    val name: String,
    val condition: Condition,
) : Condition by condition {
  val displayName
    get() = "$name only"

  infix fun or(other: NamedCondition) =
      NamedCondition("$name or ${other.name}") {
        condition.evaluate(it) || other.condition.evaluate(it)
      }
}

operator fun NamedCondition?.plus(other: NamedCondition?) =
    if (this != null) {
      if (other != null) {
        NamedCondition("$name & ${other.name}") {
          condition.evaluate(it) && other.condition.evaluate(it)
        }
      } else {
        null
      }
    } else {
      other
    }
