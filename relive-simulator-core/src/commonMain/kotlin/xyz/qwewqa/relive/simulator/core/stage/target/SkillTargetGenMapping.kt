package xyz.qwewqa.relive.simulator.core.stage.target

import xyz.qwewqa.relive.simulator.core.gen.GenSkillTarget
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenSkillTarget
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.ContractionBuff

data class SkillTargetData(
    val id: Int,
    val description: String,
) {
    inline fun makeAllyTarget(
        crossinline target: ActionContext.(provokeTarget: Actor?) -> List<Actor>
    ) = object : SkillTarget {
        override val id: Int = this@SkillTargetData.id
        override val isAffectedByAggro: Boolean = false
        override val description: String = this@SkillTargetData.description
        override fun getTargets(context: ActionContext, provokeTarget: Actor?) = target(context, provokeTarget)
    }

    inline fun makeAllyTargetAoe(
        crossinline condition: (actor: Actor) -> Boolean = { true },
    ) = makeAllyTarget {
        team.active.filter(condition)
    }

    inline fun <T : Comparable<T>> makeAllyTargetSingleNthHighest(
        ord: Int,
        crossinline criterion: (actor: Actor) -> T,
    ) = makeAllyTarget {
        listOfNotNull(team.active.sortedByDescending { criterion(it) }.getOrNull(ord - 1))
    }

    inline fun <T : Comparable<T>> makeAllyTargetSingleNthLowest(
        ord: Int,
        crossinline criterion: (actor: Actor) -> T,
    ) = makeAllyTarget {
        listOfNotNull(team.active.sortedBy { criterion(it) }.getOrNull(ord - 1))
    }

    inline fun <T : Comparable<T>> makeAllyTargetAllNHighest(
        n: Int,
        crossinline criterion: (actor: Actor) -> T,
    ) = makeAllyTarget {
        team.active.sortedByDescending { criterion(it) }.take(n)
    }

    inline fun <T : Comparable<T>> makeAllyTargetAllNLowest(
        n: Int,
        crossinline criterion: (actor: Actor) -> T,
    ) = makeAllyTarget {
        team.active.sortedBy { criterion(it) }.take(n)
    }

    inline fun makeEnemyTarget(
        focus: Boolean = false,
        crossinline target: ActionContext.(provokeTarget: Actor?) -> List<Actor>
    ) = object : SkillTarget {
        override val id: Int = this@SkillTargetData.id
        override val isAffectedByAggro: Boolean = !focus
        override val description: String = this@SkillTargetData.description
        override fun getTargets(context: ActionContext, provokeTarget: Actor?) = context.target(provokeTarget)
    }

    inline fun makeEnemyTargetAoe(
        focus: Boolean = false,
        crossinline condition: (actor: Actor) -> Boolean = { true },
    ) = makeEnemyTarget(focus) { _ ->
        if (ContractionBuff in self.buffs) {
            listOfNotNull(enemy.active.firstOrNull())
        } else {
            enemy.active.filter(condition)
        }
    }

    inline fun <T : Comparable<T>> makeEnemyTargetSingleNthHighest(
        ord: Int,
        focus: Boolean = false,
        crossinline filter: (actor: Actor) -> Boolean = { true },
        crossinline criterion: (actor: Actor) -> T,
    ) = makeEnemyTarget(focus) { provokeTarget ->
        provokeTarget?.takeUnless { focus }?.let {
            listOf(it)
        } ?: listOfNotNull(
            enemy.active.filter { filter(it) }.sortedByDescending { criterion(it) }.getOrNull(ord - 1)
        )
    }

    inline fun <T : Comparable<T>> makeEnemyTargetSingleNthLowest(
        ord: Int,
        focus: Boolean = false,
        crossinline filter: (actor: Actor) -> Boolean = { true },
        crossinline criterion: (actor: Actor) -> T,
    ) = makeEnemyTarget(focus) { provokeTarget ->
        provokeTarget?.takeUnless { focus }?.let {
            listOf(it)
        } ?: listOfNotNull(
            enemy.active.filter { filter(it) }.sortedBy { criterion(it) }.getOrNull(ord - 1)
        )
    }

    inline fun <T : Comparable<T>> makeEnemyTargetAllNHighest(
        n: Int,
        focus: Boolean = false,
        crossinline criterion: (actor: Actor) -> T,
    ) = makeEnemyTarget(focus) { provokeTarget ->
        provokeTarget?.takeUnless { focus }?.let {
            listOf(it)
        } ?: enemy.active.sortedByDescending { criterion(it) }.take(n)
    }

    inline fun <T : Comparable<T>> makeEnemyTargetAllNLowest(
        n: Int,
        focus: Boolean = false,
        crossinline criterion: (actor: Actor) -> T,
    ) = makeEnemyTarget(focus) { provokeTarget ->
        provokeTarget?.takeUnless { focus }?.let {
            listOf(it)
        } ?: enemy.active.sortedBy { criterion(it) }.take(n)
    }
}

fun GenSkillTarget.toSkillTargetData() = SkillTargetData(
    id = _id_,
    description.getLocalizedString(),
)

val skillTargetData = valuesGenSkillTarget.mapValues { it.value.toSkillTargetData() }

fun getSkillTargetData(id: Int) = skillTargetData[id] ?: error("No skill target with id $id")
