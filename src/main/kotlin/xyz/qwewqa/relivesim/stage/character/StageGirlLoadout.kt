package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.effect.AutoEffect

data class StageGirlLoadout(
    val name: String,
    val data: StageGirlData,
    val memoir: MemoirData? = null,
) {
    fun createStageGirl() = StageGirl(this).also {
        data.applyToStageGirl(it)
        memoir?.stats?.addToStageGirl(it)
    }

    val autoEffects get() = mutableListOf<AutoEffect>().apply {
        addAll(data.autoSkills)
        add(data.unitSkill)
        memoir?.let { addAll(it.autoEffects) }
    }
}
