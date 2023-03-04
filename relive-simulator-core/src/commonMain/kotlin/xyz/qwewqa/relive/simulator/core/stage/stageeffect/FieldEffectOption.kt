package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenFieldEffectOption
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.team.Team

interface FieldEffectOption : FeatureImplementation {
    val description: String
    val extraDescription: String?

    fun execute(target: Team, value: Int, time: Int)
}

@Suppress("UNCHECKED_CAST")
object FieldEffectOptions : ImplementationRegistry<FieldEffectOption>() {
    init {
        for ((id, option) in valuesGenFieldEffectOption) {
            +when (option.type) {
                1 -> {
                    val effect = StageEffects[option.param1] ?: continue
                    object : FieldEffectOption {
                        override val id = id
                        override val description = option.effect_description.getLocalizedString()
                        override val extraDescription =option.extra_description.getLocalizedString().takeIf { it.isNotBlank() }

                        override fun execute(target: Team, value: Int, time: Int) {
                            target.stageEffects.add(
                                effect = effect,
                                level = value,
                                turns = time,
                            )
                        }
                    }
                }
                2 -> {
                    object : FieldEffectOption {
                        override val id = id
                        override val description = option.effect_description.getLocalizedString()
                        override val extraDescription =option.extra_description.getLocalizedString().takeIf { it.isNotBlank() }

                        override fun execute(target: Team, value: Int, time: Int) {
                            require(time == 1) { "Time must be 1 for field effect level adjustment effects." }
                            target.stageEffects.adjustLevels(
                                category = BuffCategory.Negative,
                                count = option.param1,
                                delta = -value,
                            )
                        }
                    }
                }
                3 -> {
                    object : FieldEffectOption {
                        override val id = id
                        override val description = option.effect_description.getLocalizedString()
                        override val extraDescription =option.extra_description.getLocalizedString().takeIf { it.isNotBlank() }

                        override fun execute(target: Team, value: Int, time: Int) {
                            require(time == 1) { "Time must be 1 for field level adjustment effects." }
                            target.stageEffects.adjustLevels(
                                category = BuffCategory.Positive,
                                count = option.param1,
                                delta = -value,
                            )
                        }
                    }
                }
                4 -> {
                    object : FieldEffectOption {
                        override val id = id
                        override val description = option.effect_description.getLocalizedString()
                        override val extraDescription =option.extra_description.getLocalizedString().takeIf { it.isNotBlank() }

                        override fun execute(target: Team, value: Int, time: Int) {
                            require(time == 1) { "Time must be 1 for field effect level adjustment effects." }
                            target.stageEffects.adjustLevels(
                                category = BuffCategory.Negative,
                                count = option.param1,
                                delta = value,
                            )
                        }
                    }
                }
                5 -> {
                    object : FieldEffectOption {
                        override val id = id
                        override val description = option.effect_description.getLocalizedString()
                        override val extraDescription =option.extra_description.getLocalizedString().takeIf { it.isNotBlank() }

                        override fun execute(target: Team, value: Int, time: Int) {
                            require(time == 1) { "Time must be 1 for field level adjustment effects." }
                            target.stageEffects.adjustLevels(
                                category = BuffCategory.Positive,
                                count = option.param1,
                                delta = value,
                            )
                        }
                    }
                }
                else -> null
            }
        }
    }
}