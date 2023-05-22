package xyz.qwewqa.relive.simulator.core.stage.song

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

data class SongEffectInstance(
    val effect: SongEffect,
    val value: Int,
) {
  val name
    get() = effect.formatName(value)
  fun start(context: ActionContext) = effect.start(context, value)
  fun end(context: ActionContext) = effect.end(context, value)
}
