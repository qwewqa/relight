package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation

sealed interface BuffEffect : FeatureImplementation {
  val name: String
  val iconId: Int
  val groupId: Int
  val groupLevel: Int
  val category: BuffCategory
  val isLocked: Boolean
    get() = false
  val displayLockIcon: Boolean
    get() = isLocked
}

enum class BuffCategory {
  Positive,
  Negative,
}

// List of priorities for displaying buffs besides HP bars.
// Not meant for sort order in comprehensive lists.
// This is for highlighting the most important buffs, but not necessarily grouping them by type of
// effect.
private val buffDisplayPriorityList: List<BuffEffect> = Buffs.values.sortedBy { it.groupId }

private val buffDisplayPriorityMap: Map<BuffEffect, Int> =
    buffDisplayPriorityList
        .mapIndexed { index, buff -> buff to buffDisplayPriorityList.size - index }
        .toMap()

val BuffEffect.displayPriority: Int
  get() = buffDisplayPriorityMap[this] ?: -1
