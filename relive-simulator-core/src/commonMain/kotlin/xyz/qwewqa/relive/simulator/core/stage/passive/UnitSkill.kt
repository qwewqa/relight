package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.condition.plus

data class UnitSkill(
    val values: List<List<Int>>,
    val effects: List<PassiveEffect>,
    val condition: NamedCondition? = null,
) {
    fun forLevel(level: Int) = effects.mapIndexed { i, effect ->
        PassiveData(
            effect,
            values[i][level - 1],
            0,
            condition,
        )
    }

    operator fun plus(condition: NamedCondition) = UnitSkill(
        values,
        effects,
        this.condition + condition,
    )
}

val ActCritical50UnitSkill = UnitSkill(
    listOf(
        listOf(
            20,
            21,
            22,
            23,
            24,
            25,
            26,
            27,
            28,
            29,
            30,
            32,
            34,
            36,
            38,
            40,
            42,
            44,
            46,
            48,
            50
        ),
        listOf(
            20,
            21,
            22,
            23,
            24,
            25,
            26,
            27,
            28,
            29,
            30,
            32,
            34,
            36,
            38,
            40,
            42,
            44,
            46,
            48,
            50
        ),
    ),
    listOf(TeamActUpPassive, TeamCriticalUpPassive)
)
val ActCritical30UnitSkill = UnitSkill(
    listOf(
        listOf(
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            19,
            20,
            21,
            22,
            23,
            24,
            25,
            26,
            27,
            28,
            29,
            30
        ),
        listOf(
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            19,
            20,
            21,
            22,
            23,
            24,
            25,
            26,
            27,
            28,
            29,
            30
        ),
    ),
    listOf(TeamActUpPassive, TeamCriticalUpPassive)
)
