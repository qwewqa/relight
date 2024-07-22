package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillTarget: Map<Int, GenSkillTarget> by lazy {
  loadJsMasterData(dataGenSkillTarget) { id, data ->
    GenSkillTarget(
        attack_type = data.attack_type.unsafeCast<Int>(),
        attribute_ids = arrayFromDynamic(data.attribute_ids),
        chara_ids = arrayFromDynamic(data.chara_ids),
        description = stringMapFromDynamic(data.description),
        description_for_field_effect = stringMapFromDynamic(data.description_for_field_effect),
        roles = arrayFromDynamic(data.roles),
        school_id = data.school_id.unsafeCast<Int?>(),
        school_ids = if (data.school_ids == null) emptyArray() else arrayFromDynamic(data.school_ids),
        skill_target_filter_ids = arrayFromDynamic(data.skill_target_filter_ids),
        _id_ = id,
    )
  }
}
