package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.gen.GenBuff
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenBuff
import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier

data class BuffData(
    val id: Int,
    val name: String,
    val iconId: Int,
    val locked: Boolean,
) {
  // change this to use an object declaration instead of SimpleContinuousBuffEffect
  inline fun <T> makeContinuousBuffEffect(
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> ContinuousBuffEffect<*>? = { null },
      related: ContinuousBuffEffect<Unit>? = null,
      crossinline onStart: ActionContext.(value: I54, source: Actor?) -> T,
      crossinline onEnd: ActionContext.(value: I54, source: Actor?, T) -> Unit,
  ): ContinuousBuffEffect<T> =
      object : ContinuousBuffEffect<T> {
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

        override fun onStart(context: ActionContext, value: I54, source: Actor?): T {
          return context.onStart(value, source)
        }

        override fun onEnd(context: ActionContext, value: I54, source: Actor?, data: T) {
          context.onEnd(value, source, data)
        }
      }

  inline fun makeIdempotentContinuousBuffEffect(
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> ContinuousBuffEffect<*>? = { null },
      related: ContinuousBuffEffect<Unit>? = null,
      crossinline onStart: ActionContext.() -> Unit,
      crossinline onEnd: ActionContext.() -> Unit,
  ): ContinuousBuffEffect<Unit> =
      object : ContinuousBuffEffect<Unit> {
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

        override fun onStart(context: ActionContext, value: I54, source: Actor?) {
          if (this !in context.self.buffs) {
            context.onStart()
          }
        }

        override fun onEnd(context: ActionContext, value: I54, source: Actor?, data: Unit) {
          if (this !in context.self.buffs) {
            context.onEnd()
          }
        }
      }

  inline fun makeModifierContinuousBuffEffect(
      modifier: Modifier,
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> ContinuousBuffEffect<*>? = { null },
      related: ContinuousBuffEffect<Unit>? = null,
  ): ContinuousBuffEffect<Unit> =
      makeContinuousBuffEffect(
          category = category,
          locked = locked,
          exclusive = exclusive,
          flipped = flipped,
          related = related,
          onStart = { value, _ -> self.mod { modifier += value } },
      ) { value, _, _ ->
        self.mod { modifier -= value }
      }

  inline fun makeSimpleContinuousBuffEffect(
      category: BuffCategory,
      locked: Boolean = this.locked,
      exclusive: Boolean = false,
      crossinline flipped: () -> ContinuousBuffEffect<*>? = { null },
      related: ContinuousBuffEffect<Unit>? = null,
      crossinline onStart: ActionContext.(value: I54) -> Unit = { _ -> },
      crossinline onEnd: ActionContext.(value: I54) -> Unit = { _ -> },
  ): ContinuousBuffEffect<Unit> =
      makeContinuousBuffEffect(
          category = category,
          locked = locked,
          exclusive = exclusive,
          flipped = flipped,
          related = related,
          onStart = { value, _ -> onStart(value) },
          onEnd = { value, _, _ -> onEnd(value) },
      )

  fun makeLockedVariantOf(related: ContinuousBuffEffect<Unit>) =
      makeSimpleContinuousBuffEffect(
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
