package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint

val memoirs = mapOf("None" to EmptyMemoir) + (
        listOf<MemoirBlueprint>(
        ).sortedBy { it.name }.sortedBy { it.cutinData == null }
        ).associateBy { it.name }
