package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenEquip: Map<Int, GenEquip> by lazy {
  loadJsMasterData(dataGenEquip) { id, data ->
    GenEquip(
        active_skill_id = data.active_skill_id.unsafeCast<Int>(),
        appearance_chara_ids = arrayFromDynamic(data.appearance_chara_ids),
        auto_skill1_id = data.auto_skill1_id.unsafeCast<Int>(),
        auto_skill1_type = data.auto_skill1_type.unsafeCast<Int>(),
        base_atk = data.base_atk.unsafeCast<Int>(),
        base_hp = data.base_hp.unsafeCast<Int>(),
        base_mdef = data.base_mdef.unsafeCast<Int>(),
        base_pdef = data.base_pdef.unsafeCast<Int>(),
        can_use_limitbreak_item = data.can_use_limitbreak_item.unsafeCast<Int>(),
        cost = data.cost.unsafeCast<Int>(),
        delta_atk = data.delta_atk.unsafeCast<Int>(),
        delta_hp = data.delta_hp.unsafeCast<Int>(),
        delta_mdef = data.delta_mdef.unsafeCast<Int>(),
        delta_pdef = data.delta_pdef.unsafeCast<Int>(),
        has_alternative_image = data.has_alternative_image.unsafeCast<Int>(),
        material_exp = data.material_exp.unsafeCast<Int>(),
        name = stringMapFromDynamic(data.name),
        profile = stringMapFromDynamic(data.profile),
        published_at = data.published_at.unsafeCast<Int>(),
        rarity = data.rarity.unsafeCast<Int>(),
        type = data.type.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
