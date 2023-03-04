package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.gen.GenBuff
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenBuff
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier

data class BuffData(
    val id: Int,
    val name: String,
    val iconId: Int,
    val locked: Boolean,
) {
  // change this to use an object declaration instead of SimpleTimedBuffEffect
  inline fun <T> makeTimedBuffEffect(
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> TimedBuffEffect<*>? = { null },
      related: TimedBuffEffect<Unit>? = null,
      crossinline onStart: ActionContext.(value: Int, source: Actor?) -> T,
      crossinline onEnd: ActionContext.(value: Int, source: Actor?, T) -> Unit,
  ): TimedBuffEffect<T> =
      object : TimedBuffEffect<T> {
        override val id: Int = this@BuffData.id
        override val name: String = this@BuffData.name
        override val iconId: Int = this@BuffData.iconId
        override val category: BuffCategory = category
        override val isLocked: Boolean = locked
        override val exclusive: Boolean = exclusive
        override val displayLockIcon: Boolean = this@BuffData.locked
        override val flipped
          get() = flipped()
        override val related
          get() = related

        override fun onStart(context: ActionContext, value: Int, source: Actor?): T {
          return context.onStart(value, source)
        }

        override fun onEnd(context: ActionContext, value: Int, source: Actor?, data: T) {
          context.onEnd(value, source, data)
        }
      }

  inline fun makeIdempotentTimedBuffEffect(
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> TimedBuffEffect<*>? = { null },
      related: TimedBuffEffect<Unit>? = null,
      crossinline onStart: ActionContext.() -> Unit,
      crossinline onEnd: ActionContext.() -> Unit,
  ): TimedBuffEffect<Unit> =
      object : TimedBuffEffect<Unit> {
        override val id: Int = this@BuffData.id
        override val name: String = this@BuffData.name
        override val iconId: Int = this@BuffData.iconId
        override val category: BuffCategory = category
        override val isLocked: Boolean = locked
        override val exclusive: Boolean = exclusive
        override val displayLockIcon: Boolean = this@BuffData.locked
        override val flipped
          get() = flipped()
        override val related
          get() = related

        override fun onStart(context: ActionContext, value: Int, source: Actor?) {
          if (this !in context.self.buffs) {
            context.onStart()
          }
        }

        override fun onEnd(context: ActionContext, value: Int, source: Actor?, data: Unit) {
          if (this !in context.self.buffs) {
            context.onEnd()
          }
        }
      }

  inline fun makeModifierTimedBuffEffect(
      modifier: Modifier,
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> TimedBuffEffect<*>? = { null },
      related: TimedBuffEffect<Unit>? = null,
  ): TimedBuffEffect<Unit> =
      makeTimedBuffEffect(
          category = category,
          locked = locked,
          exclusive = exclusive,
          flipped = flipped,
          related = related,
          onStart = { value, _ -> self.mod { modifier += value } },
      ) { value, _, _ ->
        self.mod { modifier -= value }
      }

  inline fun makeSimpleTimedBuffEffect(
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> TimedBuffEffect<*>? = { null },
      related: TimedBuffEffect<Unit>? = null,
      crossinline onStart: ActionContext.(value: Int) -> Unit = { _ -> },
      crossinline onEnd: ActionContext.(value: Int) -> Unit = { _ -> },
  ): TimedBuffEffect<Unit> =
      makeTimedBuffEffect(
          category = category,
          locked = locked,
          exclusive = exclusive,
          flipped = flipped,
          related = related,
          onStart = { value, _ -> onStart(value) },
          onEnd = { value, _, _ -> onEnd(value) },
      )

  fun makeLockedVariantOf(related: TimedBuffEffect<Unit>) =
      makeSimpleTimedBuffEffect(
          category = related.category,
          locked = true,
          exclusive = related.exclusive,
          related = related,
      )

  fun makeCountableBuffEffect(
      category: BuffCategory,
      isLocked: Boolean = false,
  ): CountableBuffEffect =
      SimpleCountableBuffEffect(
          id = id,
          name = name,
          iconId = iconId,
          category = category,
          isLocked = isLocked,
      )
}

fun GenBuff.toBuffData() =
    BuffData(
        id = _id_,
        name = name.getLocalizedString(),
        iconId = icon_id,
        locked = is_lock != 0,
    )

val buffData = valuesGenBuff.mapValues { it.value.toBuffData() }

fun buffData(id: Int) = buffData[id] ?: error("No buff data for $id")

fun buffDataOrNull(id: Int) = buffData[id]
