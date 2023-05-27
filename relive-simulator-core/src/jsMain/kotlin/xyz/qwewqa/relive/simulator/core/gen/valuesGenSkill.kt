package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkill: Map<Int, GenSkill> by lazy {
  loadJsMasterData(dataGenSkill) { id, data ->
    GenSkill(
        attribute_id = data.attribute_id.unsafeCast<Int>(),
        cost = data.cost.unsafeCast<Int>(),
        description = stringMapFromDynamic(data.description),
        icon_id = data.icon_id.unsafeCast<Int>(),
        is_multiple_command_unique_skill = data.is_multiple_command_unique_skill.unsafeCast<Int>(),
        name = stringMapFromDynamic(data.name),
        optional_description = stringMapFromDynamic(data.optional_description),
        sequence_id = data.sequence_id.unsafeCast<Int>(),
        skill_field_effect_id = data.skill_field_effect_id.unsafeCast<Int>(),
        skill_options =
            (data.skill_options as Array<dynamic>).map { option ->
              GenSkillOptionInfo(
                  id = option.id.unsafeCast<Int>(),
                  hit_rate = option.hit_rate.unsafeCast<Int>(),
                  target_id = option.target_id.unsafeCast<Int>(),
                  times = arrayFromDynamic(option.times),
                  values = arrayFromDynamic(option.values),
              )
            },
        _id_ = id,
    )
  }
}
