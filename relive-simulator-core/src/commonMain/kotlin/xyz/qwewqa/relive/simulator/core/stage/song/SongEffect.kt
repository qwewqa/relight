package xyz.qwewqa.relive.simulator.core.stage.song

import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation

interface SongEffect : FeatureImplementation {
  /** Name for use in logs / debugging. */
  val name: String
    get() = names.getLocalizedString()

  val names: Map<String, String>
    get() = mapOf("en" to (this::class.simpleName ?: "Unknown Song Effect"))

  /** User friendly name. */
  val displayName: String
    get() = name

  val defaultValue: Int?
    get() = null

  val iconId: Int?

  fun start(context: ActionContext, value: Int)
  fun end(context: ActionContext, value: Int)

  fun formatName(value: Int): String {
    val formattedValue = if (value != 0) " $value" else ""
    return "$name$formattedValue"
  }
}

object NoneSongEffect : SongEffect {
  override val id = 0
  override val names = mapOf("en" to "None", "ja" to "なし", "zh_hant" to "無", "ko" to "없음")
  override val iconId = null
  override fun start(context: ActionContext, value: Int) {}
  override fun end(context: ActionContext, value: Int) {}
  override fun formatName(value: Int): String = name
}
