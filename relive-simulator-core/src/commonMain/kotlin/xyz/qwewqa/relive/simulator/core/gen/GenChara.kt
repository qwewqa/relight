@file:Suppress("PropertyName")

package xyz.qwewqa.relive.simulator.core.gen

import kotlinx.serialization.Serializable

@Serializable
data class GenChara(
    val birth_day: Int,
    val birth_month: Int,
    val cv: Map<String, String>,
    val cv_first: Map<String, String>,
    val cv_last: Map<String, String>,
    val department_1: Map<String, String>,
    val department_2: Map<String, String>,
    val dislike_foods: Map<String, String>,
    val dislikes: Map<String, String>,
    val first_name: Map<String, String>,
    val introduction: Map<String, String>,
    val last_name: Map<String, String>,
    val like_foods: Map<String, String>,
    val likes: Map<String, String>,
    val name: Map<String, String>,
    val name_ruby: Map<String, String>,
    val school_id: Int,
    val _id_: Int
)

expect val valuesGenChara: Map<Int, GenChara>
