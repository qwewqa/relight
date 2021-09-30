package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinData
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoir
import xyz.qwewqa.relive.simulator.core.stage.passive.BrillianceRecoveryPassive

val UnshakableFeelings = Memoir(
    name = "Unshakable Feelings",
    stats = StatData(
        hp = 2999,
        actPower = 299,
        normalDefense = 499,
        specialDefense = 499,
    ),
    autoskills = listOf(
        BrillianceRecoveryPassive.new(32)
    ),
    cutinData = CutinData(
        cooldownStart = 1,
        cooldown = 2,
        usageLimit = 2,
        target = CutinTarget.BeforeAllyAct(1),
        act = {
            targetAllyByLowest { it.hp }.act {
                heal(fixed = 25000)
            }
        }
    )
)
