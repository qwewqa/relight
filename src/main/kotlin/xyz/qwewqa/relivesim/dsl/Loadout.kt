package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.character.StageGirlData
import xyz.qwewqa.relivesim.stage.character.StageGirlLoadout
import xyz.qwewqa.relivesim.stage.character.MemoirData

@StageDslMarker
class LoadoutBuilder {
    var name: String? = null
    var stageGirl: StageGirlData? = null
    var memoir: MemoirData? = null

    inline fun stageGirl(init: StageGirlBuilder.() -> Unit) {
        stageGirl = StageGirlBuilder().apply(init).build()
    }

    inline fun memoir(init: MemoirBuilder.() -> Unit) {
        memoir = MemoirBuilder().apply(init).build()
    }

    fun build(): StageGirlLoadout = StageGirlLoadout(
        name ?: stageGirl?.displayName ?: error("No name"),
        stageGirl ?: error("Stage girl not specified"),
        memoir,
    )
}