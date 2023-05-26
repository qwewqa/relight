package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenStartSkill: Map<Int, GenStartSkill> by lazy {
  loadJsMasterData(dataGenStartSkill) { id, data ->
    GenStartSkill(
        description = stringMapFromDynamic(data.description),
        icon_id = data.icon_id.unsafeCast<Int>(),
        rate = data.rate.unsafeCast<Int>(),
        skill_field_effect_id = data.skill_field_effect_id.unsafeCast<Int>(),
        skill_option1_hit_rate = data.skill_option1_hit_rate.unsafeCast<Int>(),
        skill_option1_id = data.skill_option1_id.unsafeCast<Int>(),
        skill_option1_target_id = data.skill_option1_target_id.unsafeCast<Int>(),
        skill_option1_times = listFromDynamic(data.skill_option1_times),
        skill_option1_values = listFromDynamic(data.skill_option1_values),
        skill_option2_hit_rate = data.skill_option2_hit_rate.unsafeCast<Int>(),
        skill_option2_id = data.skill_option2_id.unsafeCast<Int>(),
        skill_option2_target_id = data.skill_option2_target_id.unsafeCast<Int>(),
        skill_option2_times = listFromDynamic(data.skill_option2_times),
        skill_option2_values = listFromDynamic(data.skill_option2_values),
        skill_option3_hit_rate = data.skill_option3_hit_rate.unsafeCast<Int>(),
        skill_option3_id = data.skill_option3_id.unsafeCast<Int>(),
        skill_option3_target_id = data.skill_option3_target_id.unsafeCast<Int>(),
        skill_option3_times = listFromDynamic(data.skill_option3_times),
        skill_option3_values = listFromDynamic(data.skill_option3_values),
        skill_option4_hit_rate = data.skill_option4_hit_rate.unsafeCast<Int>(),
        skill_option4_id = data.skill_option4_id.unsafeCast<Int>(),
        skill_option4_target_id = data.skill_option4_target_id.unsafeCast<Int>(),
        skill_option4_times = listFromDynamic(data.skill_option4_times),
        skill_option4_values = listFromDynamic(data.skill_option4_values),
        skill_option5_hit_rate = data.skill_option5_hit_rate.unsafeCast<Int>(),
        skill_option5_id = data.skill_option5_id.unsafeCast<Int>(),
        skill_option5_target_id = data.skill_option5_target_id.unsafeCast<Int>(),
        skill_option5_times = listFromDynamic(data.skill_option5_times),
        skill_option5_values = listFromDynamic(data.skill_option5_values),
        _id_ = id
    )
  }
}
