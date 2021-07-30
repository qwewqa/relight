package xyz.qwewqa.relivesim.stage

data class CharacterData(
    val name: String = "",
    val attribute: Attribute = Attribute.Neutral,
    val character: Character = Character.OtherCharacter,
    val damageType: DamageType = DamageType.Neutral,
    val position: Position = Position.NoPosition,
    val stats: StatData = StatData(),
    val positionValue: Int = 0,
    val normalActs: List<Any> = emptyList(),
    val climaxAct: Any = Any(),
    val autoSkills: List<Any> = emptyList(),
    val unitSkill: Any = Any(),
    val effectivenessTable: AttributeEffectivenessTable = standardAttributeEffectivenessTables.getValue(attribute),
) {
    fun createState() = CharacterState(this).also {
        stats.applyToCharacterState(it)
    }
}
