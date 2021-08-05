package xyz.qwewqa.relivesim.presets.memoir

import xyz.qwewqa.relivesim.dsl.MemoirBuilder
import xyz.qwewqa.relivesim.dsl.Prototype
import xyz.qwewqa.relivesim.dsl.memoirPrototype
import xyz.qwewqa.relivesim.stage.character.MemoirData

class MemoirPreset(
    val min: Prototype<MemoirData, MemoirBuilder>,
    val max: Prototype<MemoirData, MemoirBuilder>,
    val lv1max: Prototype<MemoirData, MemoirBuilder>,
)

fun memoirPreset(
    min: MemoirBuilder.() -> Unit = { throw NotImplementedError() },
    max: MemoirBuilder.() -> Unit = { throw NotImplementedError() },
    lv1max: MemoirBuilder.() -> Unit = { throw NotImplementedError() },
) = MemoirPreset(
memoirPrototype + min,
memoirPrototype + max,
memoirPrototype + lv1max,
)