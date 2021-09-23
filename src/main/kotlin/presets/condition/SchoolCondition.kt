package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relivesim.stage.character.School
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val SeishoOnlyCondition = schoolCondition(School.Seisho)
val RinmeikanOnlyCondition = schoolCondition(School.Rinmeikan)
val FrontierOnlyCondition = schoolCondition(School.Frontier)
val SiegfeldOnlyCondition = schoolCondition(School.Siegfeld)
val SeiranOnlyCondition = schoolCondition(School.Seiran)

private fun schoolCondition(school: School) = NamedCondition("${school.name} Only") {
    it.dress.character.school == school
}
