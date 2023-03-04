package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.stage.character.Position

val FrontOnlyCondition = positionCondition(Position.Front)
val MiddleOnlyCondition = positionCondition(Position.Middle)
val BackOnlyCondition = positionCondition(Position.Back)

private fun positionCondition(position: Position) =
    NamedCondition(position.name) { it.dress.position == position }
