package xyz.qwewqa.relive.simulator.presets.condition

import xyz.qwewqa.relivesim.stage.character.School
import xyz.qwewqa.relive.simulator.stage.condition.NamedCondition

fun schoolCondition(school: School) = NamedCondition("${school.name} Only") {
    it.dress.character.school == school
}
