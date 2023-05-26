package xyz.qwewqa.relive.simulator.core.gen

actual val valuesGenChara: Map<Int, GenChara> by lazy {
  loadJsMasterData(dataGenChara) { id, data ->
    GenChara(
        birth_day = data.birth_day.unsafeCast<Int>(),
        birth_month = data.birth_month.unsafeCast<Int>(),
        cv = stringMapFromDynamic(data.cv),
        cv_first = stringMapFromDynamic(data.cv_first),
        cv_last = stringMapFromDynamic(data.cv_last),
        department_1 = stringMapFromDynamic(data.department_1),
        department_2 = stringMapFromDynamic(data.department_2),
        dislike_foods = stringMapFromDynamic(data.dislike_foods),
        dislikes = stringMapFromDynamic(data.dislikes),
        first_name = stringMapFromDynamic(data.first_name),
        introduction = stringMapFromDynamic(data.introduction),
        last_name = stringMapFromDynamic(data.last_name),
        like_foods = stringMapFromDynamic(data.like_foods),
        likes = stringMapFromDynamic(data.likes),
        name = stringMapFromDynamic(data.name),
        name_ruby = stringMapFromDynamic(data.name_ruby),
        school_id = data.school_id.unsafeCast<Int>(),
        _id_ = id,
    )
  }
}
