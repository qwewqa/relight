package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.effect.AutoEffect

data class CharacterLoadout(
    val name: String,
    val data: CharacterData,
    val memoir: MemoirData? = null,
) {
    fun createState() = CharacterState(this).also {
        data.applyToCharacterState(it)
        memoir?.stats?.addToCharacterState(it)
    }

    val autoEffects get() = mutableListOf<AutoEffect>().run {
        addAll(data.autoSkills)
        add(data.unitSkill)
        memoir?.let { addAll(it.autoEffects) }
    }
}
