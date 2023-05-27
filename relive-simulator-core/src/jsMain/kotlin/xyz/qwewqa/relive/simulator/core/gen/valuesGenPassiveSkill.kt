package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenPassiveSkill: Map<Int, GenPassiveSkill> by lazy {
  loadJsMasterData(dataGenPassiveSkill) { id, data ->
    GenPassiveSkill(
        description = stringMapFromDynamic(data.description),
        icon_id = data.icon_id.unsafeCast<Int>(),
        skill_option1_id = data.skill_option1_id.unsafeCast<Int>(),
        skill_option1_target_id = data.skill_option1_target_id.unsafeCast<Int>(),
        skill_option1_values = arrayFromDynamic(data.skill_option1_values),
        skill_option2_id = data.skill_option2_id.unsafeCast<Int>(),
        skill_option2_target_id = data.skill_option2_target_id.unsafeCast<Int>(),
        skill_option2_values = arrayFromDynamic(data.skill_option2_values),
        skill_option3_id = data.skill_option3_id.unsafeCast<Int>(),
        skill_option3_target_id = data.skill_option3_target_id.unsafeCast<Int>(),
        skill_option3_values = arrayFromDynamic(data.skill_option3_values),
        skill_option4_id = data.skill_option4_id.unsafeCast<Int>(),
        skill_option4_target_id = data.skill_option4_target_id.unsafeCast<Int>(),
        skill_option4_values = arrayFromDynamic(data.skill_option4_values),
        skill_option5_id = data.skill_option5_id.unsafeCast<Int>(),
        skill_option5_target_id = data.skill_option5_target_id.unsafeCast<Int>(),
        skill_option5_values = arrayFromDynamic(data.skill_option5_values),
        _id_ = id
    )
  }
}
