package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillTarget: Map<Int, GenSkillTarget> by lazy {
  loadJsMasterData(dataGenSkillTarget) { id, data ->
    GenSkillTarget(
        attack_type = data.attack_type.unsafeCast<Int>(),
        attribute_ids = listFromDynamic(data.attribute_ids),
        chara_ids = listFromDynamic(data.chara_ids),
        description = stringMapFromDynamic(data.description),
        description_for_field_effect = stringMapFromDynamic(data.description_for_field_effect),
        role = data.role.unsafeCast<Int>(),
        school_id = data.school_id.unsafeCast<Int>(),
        skill_target_filter_ids = listFromDynamic(data.skill_target_filter_ids),
        _id_ = id,
    )
  }
}
