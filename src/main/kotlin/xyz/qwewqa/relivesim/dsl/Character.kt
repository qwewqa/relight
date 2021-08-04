package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.act.ActData
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.*
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.AutoEffect
import xyz.qwewqa.relivesim.stage.effect.BlankAutoEffect

@StageDslMarker
class StageGirlBuilder {
    var name: String = ""
    var attribute: Attribute = Attribute.NeutralAttribute
    var character: Character = Character.OtherCharacter
    var damageType: DamageType = DamageType.NeutralDamage
    var position: Position = Position.NoPosition
    var stats: StatData = StatData()
    var positionValue: Int = 0
    val normalActs: MutableList<ActData> = mutableListOf()
    var climaxAct: ActData? = null
    var autoSkills: MutableList<AutoEffect> = mutableListOf()
    var unitSkill: AutoEffect = BlankAutoEffect
    var effectivenessTable: AttributeEffectivenessTable? = null

    inline fun stats(init: StatsBuilder.() -> Unit) {
        stats = defaultStageGirlStats().apply(init).build()
    }

    operator fun ActType.invoke(name: String, apCost: Int, action: ActionContext.() -> Unit) {
        if (this == ActType.ClimaxAct) {
            climaxAct = ActData(name, this, apCost, action)
        } else {
            normalActs.add(ActData(name, this, apCost, action))
        }
    }

    operator fun AutoEffect.unaryPlus() {
        autoSkills.add(this)
    }

    fun build() = StageGirlData(
        name,
        attribute,
        character,
        damageType,
        position,
        stats,
        positionValue,
        normalActs,
        climaxAct,
        autoSkills,
        unitSkill,
        effectivenessTable ?: standardAttributeEffectivenessTables.getValue(attribute),
    )
}

inline fun stageGirl(init: StageGirlBuilder.() -> Unit) = StageGirlBuilder().apply(init).build()

fun StageGirlData.withAutoSkill(unitSkill: AutoEffect) = copy(unitSkill = unitSkill)
