package xyz.qwewqa.relivesim.stage

data class CharacterSetup(
    val data: CharacterData,
) {
    fun createState() = CharacterState(this).also {
        data.stats.applyToCharacterState(it)
    }
}
