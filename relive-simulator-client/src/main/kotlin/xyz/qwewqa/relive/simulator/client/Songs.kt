package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import org.w3c.dom.HTMLOptionElement
import xyz.qwewqa.relive.simulator.common.SimulationOptions
import xyz.qwewqa.relive.simulator.common.SongEffectParameter
import xyz.qwewqa.relive.simulator.common.SongParameters
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString

val songSelect = document.getElementById("song-select").singleSelect(true)
val songEffect1Type = document.getElementById("song-effect-1-type").singleSelect(true)
val songEffect1Value = document.getElementById("song-effect-1-value").integerInput(0)
val songEffect2Type = document.getElementById("song-effect-2-type").singleSelect(true)
val songEffect2Value = document.getElementById("song-effect-2-value").integerInput(0)
val songPassiveEffectType = document.getElementById("song-passive-effect-type").singleSelect(true)
val songPassiveEffectValue = document.getElementById("song-passive-effect-value").integerInput(0)
val songAwakeningEffect1Type = document.getElementById("song-awakening-effect-1-type").textInput()
val songAwakeningEffect1Value =
    document.getElementById("song-awakening-effect-1-value").integerInput(0)
val songAwakeningEffect2Type = document.getElementById("song-awakening-effect-2-type").textInput()
val songAwakeningEffect2Value =
    document.getElementById("song-awakening-effect-2-value").integerInput(0)
val songAwakeningEffect3Type = document.getElementById("song-awakening-effect-3-type").textInput()
val songAwakeningEffect3Value =
    document.getElementById("song-awakening-effect-3-value").integerInput(0)
val songAwakeningEffect4Type = document.getElementById("song-awakening-effect-4-type").textInput()
val songAwakeningEffect4Value =
    document.getElementById("song-awakening-effect-4-value").integerInput(0)
val awakenedSongsSelect = document.getElementById("awakened-songs-select").multipleSelect(true)

fun initSongs(options: SimulationOptions, locale: String) {
  songSelect.populate(options.songsById, locale)
  songEffect1Type.populate(options.songEffectsById, locale)
  songEffect2Type.populate(options.songEffectsById, locale)
  songPassiveEffectType.populate(options.passiveSongEffectsById, locale)
  songSelect.element.onchange = { updateSelectedSong(options, songSelect.value, locale) }
  awakenedSongsSelect.populate(options.awakeningSongsById, locale)
  updateSelectedSong(options, "0", locale)
}

fun updateSongLocale(options: SimulationOptions, locale: String) {
  songSelect.localize(options.songsById, locale)
  songEffect1Type.localize(options.songEffectsById, locale)
  songEffect2Type.localize(options.songEffectsById, locale)
  songPassiveEffectType.localize(options.passiveSongEffectsById, locale)
  songSelect.element.onchange = { updateSelectedSong(options, songSelect.value, locale) }
  updateSelectedSong(options, songSelect.value, locale)
  awakenedSongsSelect.localize(options.awakeningSongsById, locale)
}

fun getSongParameters() =
    SongParameters(
        id = songSelect.value,
        activeEffect1 =
            SongEffectParameter(
                songEffect1Type.value,
                songEffect1Value.value,
            ),
        activeEffect2 =
            SongEffectParameter(
                songEffect2Type.value,
                songEffect2Value.value,
            ),
        passiveEffect =
            SongEffectParameter(
                songPassiveEffectType.value,
                songPassiveEffectValue.value,
            ),
        awakenSkill1Value = songAwakeningEffect1Value.value,
        awakenSkill2Value = songAwakeningEffect2Value.value,
        awakenSkill3Value = songAwakeningEffect3Value.value,
        awakenSkill4Value = songAwakeningEffect4Value.value,
        awakenExtraSkillSongs = awakenedSongsSelect.value,
    )

fun setSongParameters(options: SimulationOptions, value: SongParameters, locale: String) {
  updateSelectedSong(options, value.id, locale)
  songSelect.value = value.id
  songEffect1Type.value = value.activeEffect1?.id ?: "0"
  songEffect1Value.value = value.activeEffect1?.value ?: 0
  songEffect2Type.value = value.activeEffect2?.id ?: "0"
  songEffect2Value.value = value.activeEffect2?.value ?: 0
  songPassiveEffectType.value = value.passiveEffect?.id ?: "0"
  songPassiveEffectValue.value = value.passiveEffect?.value ?: 0
  songAwakeningEffect1Value.value = value.awakenSkill1Value
  songAwakeningEffect2Value.value = value.awakenSkill2Value
  songAwakeningEffect3Value.value = value.awakenSkill3Value
  songAwakeningEffect4Value.value = value.awakenSkill4Value
  awakenedSongsSelect.value = value.awakenExtraSkillSongs
}

fun updateSelectedSong(options: SimulationOptions, id: String, locale: String) {
  val song = options.songsById[id] ?: return
  val currentPassiveType = songPassiveEffectType.value
  val songPassives =
      buildList {
            if (song.data.id <= 0) {
              addAll(options.passiveSongEffects)
            } else {
              add(options.passiveSongEffects.first())
              options.passiveSongEffects
                  .filter { it.data.songId == song.data.id }
                  .forEach { add(it) }
            }
          }
          .map { it.id }
          .toSet()

  songSelect.value = id

  songPassiveEffectType.element.children.multiple<HTMLOptionElement>().forEach { opt ->
    opt.setAttribute("data-hidden", if (opt.value in songPassives) "false" else "true")
  }

  if (currentPassiveType !in songPassives) {
    songPassiveEffectType.value = options.passiveSongEffects.first().id
  }

  songPassiveEffectType.refreshSelectPicker()

  updateSongAwakeningEffect(options, song.data.awakenSkill1Id, songAwakeningEffect1Type, locale)
  updateSongAwakeningEffect(options, song.data.awakenSkill2Id, songAwakeningEffect2Type, locale)
  updateSongAwakeningEffect(options, song.data.awakenSkill3Id, songAwakeningEffect3Type, locale)
  updateSongAwakeningEffect(options, song.data.awakenSkill4Id, songAwakeningEffect4Type, locale)
}

private fun updateSongAwakeningEffect(
    options: SimulationOptions,
    skillId: Int?,
    input: TextInput,
    locale: String
) {
  if (skillId == null) {
    input.value = options.commonTextById["n/a"]?.get(locale) ?: ""
    return
  }
  val skill = options.awakeningSongEffectsById["$skillId"] ?: return
  input.value = skill.name.getLocalizedString(locale)
}
