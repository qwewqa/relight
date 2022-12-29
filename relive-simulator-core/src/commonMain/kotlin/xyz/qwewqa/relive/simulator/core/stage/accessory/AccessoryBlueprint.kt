package xyz.qwewqa.relive.simulator.core.stage.accessory

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprintContext
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

val ACCESSORY_SKILL_LEVELS = mapOf(
    0 to 1,
    1 to 1,
    2 to 2,
    3 to 2,
    4 to 3,
    5 to 3,
    6 to 3,
    7 to 4,
    8 to 4,
    9 to 4,
    10 to 5,
)

data class AccessoryBlueprint(
    val id: Int,
    val iconId: Int,
    val name: String,
    val act: (ActBlueprintContext.() -> Act)?,
    val autoskills: List<Pair<Int, List<PassiveData>>>,
    val baseHp: Int,
    val baseActPower: Int,
    val baseNormalDefense: Int,
    val baseSpecialDefense: Int,
    val baseDexterity: Int,
    val baseCritical: Int,
    val baseAgility: Int,
    val maxHp: Int,
    val maxActPower: Int,
    val maxNormalDefense: Int,
    val maxSpecialDefense: Int,
    val maxDexterity: Int,
    val maxCritical: Int,
    val maxAgility: Int,
    val growValues: List<Int>,
    val dressIds: Set<Int>,
    val attribute: Attribute? = null,
    val actData: ActBlueprint? = null,
) {
    fun create(level: Int, limitBreak: Int): Accessory {
        val actLevel = ACCESSORY_SKILL_LEVELS[limitBreak] ?: error("Accessory limit break $limitBreak is not supported.")
        require(level in 1..(50 + limitBreak * 5)) { "Accessory level must be between 1 and ${50 + limitBreak * 5}." }
        val factor = growValues[level - 1]
        return Accessory(
            id,
            iconId,
            name,
            StatData(
                hp = scaleStat(baseHp, maxHp, factor),
                actPower = scaleStat(baseActPower, maxActPower, factor),
                normalDefense = scaleStat(baseNormalDefense, maxNormalDefense, factor),
                specialDefense = scaleStat(baseSpecialDefense, maxSpecialDefense, factor),
                dexterity = scaleStat(baseDexterity, maxDexterity, factor),
                critical = scaleStat(baseCritical, maxCritical, factor),
                agility = scaleStat(baseAgility, maxAgility, factor),
            ),
            autoskills.filter { it.first <= limitBreak }.flatMap { it.second },
            actData?.create(actLevel),
        )
    }

    private fun scaleStat(base: Int, max: Int, factor: Int) = base + (max - base) * factor / 1024
}


data class PartialAccessoryBlueprint(
    val id: Int,
    val iconId: Int,
    val name: String,
    val baseHp: Int,
    val baseActPower: Int,
    val baseNormalDefense: Int,
    val baseSpecialDefense: Int,
    val baseDexterity: Int,
    val baseCritical: Int,
    val baseAgility: Int,
    val maxHp: Int,
    val maxActPower: Int,
    val maxNormalDefense: Int,
    val maxSpecialDefense: Int,
    val maxDexterity: Int,
    val maxCritical: Int,
    val maxAgility: Int,
    val growValues: List<Int>,
    val dressIds: Set<Int>,
    val attribute: Attribute? = null,
    val actData: ActBlueprint? = null,
) {
    operator fun invoke(
        name: String,
        autoskills: List<Pair<Int, List<PassiveData>>> = emptyList(),
        act: (ActBlueprintContext.() -> Act)? = null,
    ) = AccessoryBlueprint(
        id,
        iconId,
        name,
        act,
        autoskills,
        baseHp,
        baseActPower,
        baseNormalDefense,
        baseSpecialDefense,
        baseDexterity,
        baseCritical,
        baseAgility,
        maxHp,
        maxActPower,
        maxNormalDefense,
        maxSpecialDefense,
        maxDexterity,
        maxCritical,
        maxAgility,
        growValues,
        dressIds,
        attribute,
        actData,
    )
}