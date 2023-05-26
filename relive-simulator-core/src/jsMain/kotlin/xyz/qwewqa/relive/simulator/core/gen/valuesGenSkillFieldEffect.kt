package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenSkillFieldEffect: Map<Int, GenSkillFieldEffect> by lazy {
  loadJsMasterData(dataGenSkillFieldEffect) { id, data ->
    GenSkillFieldEffect(
        option1_id = data.option1_id.unsafeCast<Int>(),
        option1_target_type = data.option1_target_type.unsafeCast<Int>(),
        option1_time = data.option1_time.unsafeCast<Int>(),
        option1_value = data.option1_value.unsafeCast<Int>(),
        option2_id = data.option2_id.unsafeCast<Int>(),
        option2_target_type = data.option2_target_type.unsafeCast<Int>(),
        option2_time = data.option2_time.unsafeCast<Int>(),
        option2_value = data.option2_value.unsafeCast<Int>(),
        option3_id = data.option3_id.unsafeCast<Int>(),
        option3_target_type = data.option3_target_type.unsafeCast<Int>(),
        option3_time = data.option3_time.unsafeCast<Int>(),
        option3_value = data.option3_value.unsafeCast<Int>(),
        option4_id = data.option4_id.unsafeCast<Int>(),
        option4_target_type = data.option4_target_type.unsafeCast<Int>(),
        option4_time = data.option4_time.unsafeCast<Int>(),
        option4_value = data.option4_value.unsafeCast<Int>(),
        option5_id = data.option5_id.unsafeCast<Int>(),
        option5_target_type = data.option5_target_type.unsafeCast<Int>(),
        option5_time = data.option5_time.unsafeCast<Int>(),
        option5_value = data.option5_value.unsafeCast<Int>(),
        _id_ = id,
    )
  }
}
