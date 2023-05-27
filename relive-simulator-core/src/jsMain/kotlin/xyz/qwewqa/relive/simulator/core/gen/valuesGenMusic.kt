package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenMusic: Map<Int, GenMusic> by lazy {
  loadJsMasterData(dataGenMusic) { id, data ->
    GenMusic(
        awaken_extra_skill_id = data.awaken_extra_skill_id.unsafeCast<Int>(),
        awaken_skill1_id = data.awaken_skill1_id.unsafeCast<Int>(),
        awaken_skill2_id = data.awaken_skill2_id.unsafeCast<Int>(),
        awaken_skill3_id = data.awaken_skill3_id.unsafeCast<Int>(),
        awaken_skill4_id = data.awaken_skill4_id.unsafeCast<Int>(),
        chara_ids = arrayFromDynamic(data.chara_ids),
        description = stringMapFromDynamic(data.description),
        disc_color = data.disc_color.unsafeCast<String>(),
        event_id = data.event_id.unsafeCast<Int>(),
        gain1_category = data.gain1_category.unsafeCast<Int>(),
        gain1_item_id = data.gain1_item_id.unsafeCast<Int>(),
        gain1_quantity = data.gain1_quantity.unsafeCast<Int>(),
        jacket_color = data.jacket_color.unsafeCast<String>(),
        name = stringMapFromDynamic(data.name),
        published_at = data.published_at.unsafeCast<Int>(),
        school_ids = arrayFromDynamic(data.school_ids),
        theme_color = data.theme_color.unsafeCast<String>(),
        title_color = data.title_color.unsafeCast<String>(),
        _id_ = id
    )
  }
}
