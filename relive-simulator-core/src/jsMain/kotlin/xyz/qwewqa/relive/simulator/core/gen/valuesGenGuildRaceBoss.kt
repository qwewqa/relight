package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenGuildRaceBoss: Map<Int, GenGuildRaceBoss> by lazy {
  loadJsMasterData(dataGenGuildRaceBoss) { id, data ->
    GenGuildRaceBoss(
        enemy_id = data.enemy_id.unsafeCast<Int>(),
        episode_id = data.episode_id.unsafeCast<Int>(),
        guild_race_id = data.guild_race_id.unsafeCast<Int>(),
        hp = data.hp.unsafeCast<Int>(),
        icon_id = data.icon_id.unsafeCast<Int>(),
        name = stringMapFromDynamic(data.name),
        number = data.number.unsafeCast<Int>(),
        phase = data.phase.unsafeCast<Int>(),
        quest_id = data.quest_id.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
