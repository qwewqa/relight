package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.html.dom.append
import kotlinx.html.js.img
import kotlinx.html.js.option
import kotlinx.html.js.span
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.HTMLSelectElement
import xyz.qwewqa.relive.simulator.common.AwakeningSongEffectData
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
val songAwakeningEffect1Type =
    document.getElementById("song-awakening-effect-1-type") as HTMLElement
val songAwakeningEffect1Value =
    document.getElementById("song-awakening-effect-1-value").singleSelect(false)
val songAwakeningEffect2Type =
    document.getElementById("song-awakening-effect-2-type") as HTMLElement
val songAwakeningEffect2Value =
    document.getElementById("song-awakening-effect-2-value").singleSelect(false)
val songAwakeningEffect3Type =
    document.getElementById("song-awakening-effect-3-type") as HTMLElement
val songAwakeningEffect3Value =
    document.getElementById("song-awakening-effect-3-value").singleSelect(false)
val songAwakeningEffect4Type =
    document.getElementById("song-awakening-effect-4-type") as HTMLElement
val songAwakeningEffect4Value =
    document.getElementById("song-awakening-effect-4-value").singleSelect(false)
val awakenedSongsSelect = document.getElementById("awakened-songs-select").multipleSelect(true)
val awakenedSongsClearButton =
    document.getElementById("awakened-songs-clear-button") as HTMLButtonElement

fun initSongs(options: SimulationOptions, locale: String) {
  songSelect.populate(options.songsById, locale)
  songEffect1Type.populate(options.songEffectsById, locale)
  songEffect2Type.populate(options.songEffectsById, locale)
  songPassiveEffectType.populate(options.passiveSongEffectsById, locale)
  songPassiveEffectType.element.onchange = {
    val songId = options.passiveSongEffectsById[songPassiveEffectType.value]?.data?.songId
    if (songId != null && songId > 0 && songSelect.value != "$songId") {
      updateSelectedSong(options, "$songId", locale)
    }
  }
  songSelect.element.onchange = { updateSelectedSong(options, songSelect.value, locale) }
  awakenedSongsSelect.populate(options.awakeningSongsById, locale)
  updateSelectedSong(options, "0", locale)
  awakenedSongsClearButton.onclick = { ev ->
    awakenedSongsSelect.value = emptyList()
    ev.preventDefault()
  }
}

fun updateSongLocale(options: SimulationOptions, locale: String) {
  val parameters = getSongParameters()
  songSelect.localize(options.songsById, locale)
  songEffect1Type.localize(options.songEffectsById, locale)
  songEffect2Type.localize(options.songEffectsById, locale)
  songPassiveEffectType.localize(options.passiveSongEffectsById, locale)
  songSelect.element.onchange = { updateSelectedSong(options, songSelect.value, locale) }
  updateSelectedSong(options, songSelect.value, locale)
  awakenedSongsSelect.localize(options.awakeningSongsById, locale)
  setSongParameters(options, parameters, locale)
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
        awakenSkill1Value = songAwakeningEffect1Value.value.toIntOrNull() ?: 0,
        awakenSkill2Value = songAwakeningEffect2Value.value.toIntOrNull() ?: 0,
        awakenSkill3Value = songAwakeningEffect3Value.value.toIntOrNull() ?: 0,
        awakenSkill4Value = songAwakeningEffect4Value.value.toIntOrNull() ?: 0,
        awakenExtraSkillSongs = awakenedSongsSelect.value,
    )

fun setSongParameters(options: SimulationOptions, value: SongParameters, locale: String) {
  updateSelectedSong(options, value.id, locale)
  songSelect.value = value.id

  songEffect1Type.value = value.activeEffect1?.id ?: "0"
  val effect1Value = value.activeEffect1?.value ?: 0
  if (effect1Value > 0) {
    songEffect1Value.value = effect1Value
  } else {
    songEffect1Value.clear()
  }

  songEffect2Type.value = value.activeEffect2?.id ?: "0"
  val effect2Value = value.activeEffect2?.value ?: 0
  if (effect2Value > 0) {
    songEffect2Value.value = effect2Value
  } else {
    songEffect2Value.clear()
  }

  songPassiveEffectType.value = value.passiveEffect?.id ?: "0"
  val passiveEffectValue = value.passiveEffect?.value ?: 0
  if (passiveEffectValue > 0) {
    songPassiveEffectValue.value = passiveEffectValue
  } else {
    songPassiveEffectValue.clear()
  }

  updateSelectValueOrSelectFirst(songAwakeningEffect1Value, "${value.awakenSkill1Value}")
  updateSelectValueOrSelectFirst(songAwakeningEffect2Value, "${value.awakenSkill2Value}")
  updateSelectValueOrSelectFirst(songAwakeningEffect3Value, "${value.awakenSkill3Value}")
  updateSelectValueOrSelectFirst(songAwakeningEffect4Value, "${value.awakenSkill4Value}")

  awakenedSongsSelect.value = value.awakenExtraSkillSongs
}

private fun updateSelectValueOrSelectFirst(select: SingleSelect, value: String) {
  val values = select.element.options.multiple<HTMLOptionElement>().map { it.value }
  when {
    value in values -> select.value = value
    values.isNotEmpty() -> select.value = values.first()
    else -> {}
  }
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

  if (currentPassiveType !in songPassives) {
    songPassiveEffectType.value = options.passiveSongEffects.first().id
  }

  songPassiveEffectType.refreshSelectPicker()

  updateSongAwakeningEffect(
      options,
      song.data.awakenSkill1Id,
      songAwakeningEffect1Type,
      songAwakeningEffect1Value.element,
      locale)
  updateSongAwakeningEffect(
      options,
      song.data.awakenSkill2Id,
      songAwakeningEffect2Type,
      songAwakeningEffect2Value.element,
      locale)
  updateSongAwakeningEffect(
      options,
      song.data.awakenSkill3Id,
      songAwakeningEffect3Type,
      songAwakeningEffect3Value.element,
      locale)
  updateSongAwakeningEffect(
      options,
      song.data.awakenSkill4Id,
      songAwakeningEffect4Type,
      songAwakeningEffect4Value.element,
      locale)
}

private fun updateSongAwakeningEffect(
    options: SimulationOptions,
    skillId: Int?,
    typeElement: HTMLElement,
    valueElement: HTMLSelectElement,
    locale: String,
) {
  typeElement.clear()
  val skill = options.awakeningSongEffectsById["$skillId"] ?: options.songEffectsById["0"] ?: return
  typeElement.append {
    img(classes = "select-option-img") { src = skill.imagePath!! }
    span {
      +" "
      +skill.name.getLocalizedString(locale)
    }
  }

  val skillData = skill.data
  val values =
      when (skillData) {
        is AwakeningSongEffectData -> skillData.values
        else -> emptyArray()
      }.let {
        if (0 !in it) {
          arrayOf(0) + it
        } else {
          it
        }
      }

  valueElement.clear()
  valueElement.append {
    values.forEachIndexed { i, v ->
      option {
        value = "$v"
        +v.toString()
        selected = i == 0
      }
    }
  }
}
