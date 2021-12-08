package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory

val ArcanaOnlyCondition = NamedCondition("Arcana") {
    it.dress.category == DressCategory.Arcana
}

val StageGirlOnlyCondition = NamedCondition("Arcana") {
    it.dress.category == DressCategory.StageGirl
}
