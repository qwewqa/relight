package xyz.qwewqa.relivesim.stage.context

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.TimedEffect
import xyz.qwewqa.relivesim.stage.log
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.team.Team

open class ActionContext(
    val self: CharacterState,
    val stage: Stage,
    val team: Team,
    val enemies: Team,
) {
    fun Team.forEach(action: (CharacterState) -> Unit) = team.active.forEach(action)
    fun CharacterState.applyTimedEffect(effect: TimedEffect, chance: Percent = 100.percent) {
        when (effect.effectClass) {
            EffectClass.Neutral -> TODO()
            EffectClass.Positive -> {
                if (positiveEffectBlockCounter > 0) {
                    stage.log("Effect") { "[$this]: Positive Effect [$effect] blocked" }
                }
                val applyChance = chance * (100.percent - positiveEffectResist.value)
                if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                    effects.add(effect, this@ActionContext)
                    stage.log("Effect") { "[$this]: Positive Effect [$effect] applied" }
                } else {
                    stage.log("Effect") { "[$this]: Positive Effect [$effect] missed" }
                }
            }
            EffectClass.Negative ->  {
                if (negativeEffectBlockCounter > 0) {
                    stage.log("Effect") { "[$this]: Negative Effect [$effect] blocked" }
                }
                val applyChance = chance * (100.percent - negativeEffectResist.value)
                if (applyChance == 100.percent || stage.random.nextDouble().percent < applyChance) {
                    effects.add(effect, this@ActionContext)
                    stage.log("Effect") { "[$this]: Negative Effect [$effect] applied" }
                } else {
                    stage.log("Effect") { "[$this]: Negative Effect [$effect] missed" }
                }
            }
        }
    }
}
