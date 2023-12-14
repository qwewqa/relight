package xyz.qwewqa.relive.simulator.common

const val ASSET_BASE_URL = "https://relive-assets.qwewqa.xyz/jp_ja/"

fun getSkillIconUrl(id: Int?) =
    if (id != null && id > 0) "${ASSET_BASE_URL}res/battle/skill_icon/skill_icon_$id.png"
    else "https://relight.qwewqa.xyz/img/custom/skill_icon_0.png"

fun getMusicCoverArtUrl(id: Int?) =
    if (id != null && id > 0) "${ASSET_BASE_URL}res/item_root/music_coverart/27_$id.png"
    else "https://relight.qwewqa.xyz/img/custom/cover_art_0.png"
