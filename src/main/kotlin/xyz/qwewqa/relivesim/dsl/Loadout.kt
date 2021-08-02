package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.character.CharacterData
import xyz.qwewqa.relivesim.stage.character.CharacterLoadout
import xyz.qwewqa.relivesim.stage.character.MemoirData

@StageDslMarker
class LoadoutBuilder {
    var name: String? = null
    var character: CharacterData? = null
    var memoir: MemoirData? = null

    fun character(init: CharacterBuilder.() -> Unit) {
        character = CharacterBuilder().apply(init).build()
    }

    fun memoir(init: MemoirBuilder.() -> Unit) {
        memoir = MemoirBuilder().apply(init).build()
    }

    fun build(): CharacterLoadout = CharacterLoadout(
        name ?: character?.displayName ?: error("No name"),
        character ?: error("Character not specified"),
        memoir,
    )
}