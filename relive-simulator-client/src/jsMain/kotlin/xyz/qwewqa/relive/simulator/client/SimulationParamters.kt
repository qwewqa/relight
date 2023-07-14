package xyz.qwewqa.relive.simulator.client

import xyz.qwewqa.relive.simulator.common.SimulationMarginResultType
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.common.SimulationResultValue

val simulationResultValueComparator =
    Comparator<SimulationResultValue> { a, b ->
      sequence {
            a.tags.zip(b.tags).forEach { (aTags, bTags) -> yield(aTags.compareTo(bTags)) }
            yield(-a.tags.size.compareTo(b.tags.size))
          }
          .firstOrNull { it != 0 }
          ?: simulationResultTypeComparator.compare(a.result, b.result)
    }

val simulationResultTypeComparator =
    Comparator<SimulationResultType> { a, b ->
      when {
        a is SimulationResultType.Victory && b is SimulationResultType.Victory -> {
          compareValuesBy(a, b, { it.turn }, { it.tile })
        }
        a is SimulationResultType.Wipe && b is SimulationResultType.Wipe -> {
          compareValuesBy(a, b, { it.turn }, { it.tile })
        }
        else -> a.order.compareTo(b.order)
      }
    }

val SimulationResultValue.totalTags
  get() =
      tags +
          result.run {
            when (this) {
              is SimulationResultType.Wipe -> listOf("Wipe", "t$turn.$tile")
              is SimulationResultType.Victory -> listOf("Victory", "t$turn.$tile")
              SimulationResultType.End -> listOf("End")
              SimulationResultType.Excluded -> listOf("Excluded")
              SimulationResultType.Error -> listOf("Error")
            }
          }

val SimulationResultType.displayName
  get() =
      when (this) {
        is SimulationResultType.Wipe -> "Wipe (t$turn.$tile)"
        is SimulationResultType.Victory -> "Victory (t$turn.$tile)"
        SimulationResultType.End -> "End"
        SimulationResultType.Excluded -> "Excluded"
        SimulationResultType.Error -> "Error"
      }

val SimulationResultType.order
  get() =
      when (this) {
        is SimulationResultType.Wipe -> 2
        is SimulationResultType.Victory -> 0
        SimulationResultType.End -> 1
        SimulationResultType.Excluded -> 4
        SimulationResultType.Error -> 3
      }

val SimulationResultType.color
  get() =
      when (this) {
        is SimulationResultType.Wipe -> "DarkMagenta"
        is SimulationResultType.Victory -> "Green"
        SimulationResultType.End -> "FireBrick"
        SimulationResultType.Excluded -> "Gray"
        SimulationResultType.Error -> "Error"
      }

val SimulationMarginResultType.color
  get() =
      when (this) {
        SimulationMarginResultType.Wipe -> "DarkMagenta"
        SimulationMarginResultType.End -> "FireBrick"
      }
