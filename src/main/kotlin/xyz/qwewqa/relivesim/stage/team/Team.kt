package xyz.qwewqa.relivesim.stage.team

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.CharacterLoadout
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.percent

class Team(
    val characters: Map<String, CharacterState>,
    val friend: CharacterState?,
    val song: ClimaxSong,
    val eventBonus: Percent = 0.percent,
) {
    var cxTurns: Int = 0

    val orderedCharacters = characters.values.sortedBy { it.loadout.data.positionValue }
    val active get() = characters.values.filter { it.isAlive }
    val anyAlive get() = active.isNotEmpty()
}

class TeamData(
    val loadouts: List<CharacterLoadout>,
    val friend: CharacterLoadout? = null,
    val song: ClimaxSong,
    val eventBonus: Percent = 0.percent,
) {
    fun create() = Team(
        loadouts.associate { it.name to it.createState() },
        friend?.createState(),
        song,
        eventBonus,
    )
}
