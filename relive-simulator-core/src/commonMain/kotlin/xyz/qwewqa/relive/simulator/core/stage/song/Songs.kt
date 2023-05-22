package xyz.qwewqa.relive.simulator.core.stage.song

import xyz.qwewqa.relive.simulator.core.gen.valuesGenMusic
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Character

object Songs : ImplementationRegistry<Song>() {
  private fun getAwakenSkill(id: Int) =
      if (id > 0) {
        AwakeningSongEffects[id] ?: error("Unknown awaken skill $id.")
      } else {
        null
      }

  init {
    +GenericSong

    valuesGenMusic.values
        .filter {
          // Bandori
          it.event_id != 19
        }
        .forEach { music ->
          +object : Song {
            override val id = music._id_
            override val names = music.name
            override val awakenSkill1 = getAwakenSkill(music.awaken_skill1_id)
            override val awakenSkill2 = getAwakenSkill(music.awaken_skill2_id)
            override val awakenSkill3 = getAwakenSkill(music.awaken_skill3_id)
            override val awakenSkill4 = getAwakenSkill(music.awaken_skill4_id)
            override val awakenExtraSkill = getAwakenSkill(music.awaken_extra_skill_id)
            override val characters = music.chara_ids.map { Character.fromId(it) }
          }
        }
  }

  val aliases: Map<String, Song> =
      mutableMapOf<String, Song>().also { map ->
        Songs.values.forEach { song -> map["${song.id}"] = song }
      }
}
