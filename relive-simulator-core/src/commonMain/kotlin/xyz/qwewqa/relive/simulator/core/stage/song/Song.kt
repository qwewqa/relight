package xyz.qwewqa.relive.simulator.core.stage.song

import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.actor.Character

interface Song : FeatureImplementation {
  override val id: Int
  val names: Map<String, String>
  val awakenSkill1: SongEffect?
  val awakenSkill2: SongEffect?
  val awakenSkill3: SongEffect?
  val awakenSkill4: SongEffect?
  val awakenExtraSkill: SongEffect?
  val characters: List<Character>
}

val Song.awakenSkills
  get() = listOfNotNull(awakenSkill1, awakenSkill2, awakenSkill3, awakenSkill4)

object GenericSong : Song {
  override val id = 0
  override val names = mapOf("en" to "N/A")
  override val awakenSkill1 = null
  override val awakenSkill2 = null
  override val awakenSkill3 = null
  override val awakenSkill4 = null
  override val awakenExtraSkill = null
  override val characters = emptyList<Character>()
}
