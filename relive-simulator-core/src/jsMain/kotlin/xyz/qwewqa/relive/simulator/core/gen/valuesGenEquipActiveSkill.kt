package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenEquipActiveSkill: Map<Int, GenEquipActiveSkill> by lazy {
  loadJsMasterData(dataGenEquipActiveSkill) { id, data ->
    GenEquipActiveSkill(
        attribute_id = data.attribute_id.unsafeCast<Int>(),
        description = stringMapFromDynamic(data.description),
        execute_limit_counts = arrayFromDynamic(data.execute_limit_counts),
        first_executable_turns = arrayFromDynamic(data.first_executable_turns),
        recast_turns = arrayFromDynamic(data.recast_turns),
        skill_cost_values = arrayFromDynamic(data.skill_cost_values),
        skill_execute_timing_id = data.skill_execute_timing_id.unsafeCast<Int>(),
        skill_option1_hit_rate = data.skill_option1_hit_rate.unsafeCast<Int>(),
        skill_option1_id = data.skill_option1_id.unsafeCast<Int>(),
        skill_option1_target_id = data.skill_option1_target_id.unsafeCast<Int>(),
        skill_option1_times = arrayFromDynamic(data.skill_option1_times),
        skill_option1_values = arrayFromDynamic(data.skill_option1_values),
        skill_option2_hit_rate = data.skill_option2_hit_rate.unsafeCast<Int>(),
        skill_option2_id = data.skill_option2_id.unsafeCast<Int>(),
        skill_option2_target_id = data.skill_option2_target_id.unsafeCast<Int>(),
        skill_option2_times = arrayFromDynamic(data.skill_option2_times),
        skill_option2_values = arrayFromDynamic(data.skill_option2_values),
        skill_option3_hit_rate = data.skill_option3_hit_rate.unsafeCast<Int>(),
        skill_option3_id = data.skill_option3_id.unsafeCast<Int>(),
        skill_option3_target_id = data.skill_option3_target_id.unsafeCast<Int>(),
        skill_option3_times = arrayFromDynamic(data.skill_option3_times),
        skill_option3_values = arrayFromDynamic(data.skill_option3_values),
        skill_option4_hit_rate = data.skill_option4_hit_rate.unsafeCast<Int>(),
        skill_option4_id = data.skill_option4_id.unsafeCast<Int>(),
        skill_option4_target_id = data.skill_option4_target_id.unsafeCast<Int>(),
        skill_option4_times = arrayFromDynamic(data.skill_option4_times),
        skill_option4_values = arrayFromDynamic(data.skill_option4_values),
        skill_option5_hit_rate = data.skill_option5_hit_rate.unsafeCast<Int>(),
        skill_option5_id = data.skill_option5_id.unsafeCast<Int>(),
        skill_option5_target_id = data.skill_option5_target_id.unsafeCast<Int>(),
        skill_option5_times = arrayFromDynamic(data.skill_option5_times),
        skill_option5_values = arrayFromDynamic(data.skill_option5_values),
        _id_ = id,
    )
  }
}
