package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenPartySkill: Map<Int, GenPartySkill> by lazy {
  loadJsMasterData(dataGenPartySkill) { id, data ->
    GenPartySkill(
        description = stringMapFromDynamic(data.description),
        icon_id = data.icon_id.unsafeCast<Int>(),
        skill_option1_id = data.skill_option1_id.unsafeCast<Int>(),
        skill_option1_target_id = data.skill_option1_target_id.unsafeCast<Int>(),
        skill_option1_values = listFromDynamic(data.skill_option1_values),
        skill_option2_id = data.skill_option2_id.unsafeCast<Int>(),
        skill_option2_target_id = data.skill_option2_target_id.unsafeCast<Int>(),
        skill_option2_values = listFromDynamic(data.skill_option2_values),
        skill_option3_id = data.skill_option3_id.unsafeCast<Int>(),
        skill_option3_target_id = data.skill_option3_target_id.unsafeCast<Int>(),
        skill_option3_values = listFromDynamic(data.skill_option3_values),
        skill_option4_id = data.skill_option4_id.unsafeCast<Int>(),
        skill_option4_target_id = data.skill_option4_target_id.unsafeCast<Int>(),
        skill_option4_values = listFromDynamic(data.skill_option4_values),
        skill_option5_id = data.skill_option5_id.unsafeCast<Int>(),
        skill_option5_target_id = data.skill_option5_target_id.unsafeCast<Int>(),
        skill_option5_values = listFromDynamic(data.skill_option5_values),
        skill_option_target_id = data.skill_option_target_id.unsafeCast<Int>(),
        _id_ = id
    )
  }
}
