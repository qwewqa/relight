package xyz.qwewqa.relive.simulator.presets.condition

import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.condition.NamedCondition

fun characterCondition(character: Character) = NamedCondition("${character.name} Only") {
    it.dress.character == character
}