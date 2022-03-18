package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory

// Note: these aren't being added to the condition list for now, since they're only being used internally

val ArcanaOnlyCondition = NamedCondition("Arcana") {
    DressCategory.Arcana in it.dress.categories
}

val StageGirlOnlyCondition = NamedCondition("Stage Girl") {
    DressCategory.StageGirl in it.dress.categories
}
