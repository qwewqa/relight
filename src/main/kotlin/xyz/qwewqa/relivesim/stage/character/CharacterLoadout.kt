package xyz.qwewqa.relivesim.stage.character

data class CharacterLoadout(
    val name: String,
    val data: CharacterData,
    val memoir: MemoirData? = null,
) {
    fun createState() = CharacterState(this).also {
        data.applyToCharacterState(it)
        memoir?.stats?.addToCharacterState(it)
    }
}
