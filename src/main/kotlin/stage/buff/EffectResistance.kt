package xyz.qwewqa.relive.simulator.stage.buff

import xyz.qwewqa.relive.simulator.stage.ActionContext

object NegativeEffectResistanceBuff : BuffEffect {
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist -= value
    }
}