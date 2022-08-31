package xyz.qwewqa.relive.simulator.core.stage


import xyz.qwewqa.relive.simulator.common.SimulationMarginResultType
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.core.presets.accessory.accessories
import xyz.qwewqa.relive.simulator.core.presets.condition.conditions
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.presets.dress.playerDresses
import xyz.qwewqa.relive.simulator.core.presets.memoir.memoirs
import xyz.qwewqa.relive.simulator.core.presets.song.songEffects
import xyz.qwewqa.relive.simulator.core.stage.RandomDamageCalculator
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.condition.or
import xyz.qwewqa.relive.simulator.core.stage.condition.plus
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.TeamLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.remakeSkills
import xyz.qwewqa.relive.simulator.core.stage.song.Song
import xyz.qwewqa.relive.simulator.core.stage.song.SongEffectData
import xyz.qwewqa.relive.simulator.core.stage.strategy.bossStrategyParsers
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers

fun SimulationParameters.createStageLoadout(): StageLoadout {
        require(bossHp == null || bossHp!! > 0) { "Boss HP positive integer." }
        require(maxTurns > 0) { "Max turns should be a positive integer." }
        require(maxIterations > 0) { "Max iterations should be a positive integer" }
        require(team.isNotEmpty()) { "Team should not be empty." }
        require(team.map { it.name }.toSet().size == team.size) { "Team must not have duplicate names." }
        require(team.all { it.memoirLimitBreak in 0..4 }) { "Memoir limit break must be between 0 and 4 inclusive" }
        return StageLoadout(
            TeamLoadout(
                team.map {
                    ActorLoadout(
                        it.name,
                        playerDresses[it.dress]!!.create(
                            rarity = it.rarity,
                            level = it.level,
                            friendship = it.friendship,
                            rank = it.rank,
                            rankPanelPattern = it.rankPanelPattern,
                            remake = it.remake,
                            unitSkillLevel = it.unitSkillLevel,
                            remakeSkill = it.remakeSkill?.let { id -> remakeSkills[id]!! },
                        ),
                        memoirs[it.memoir]!!.create(it.memoirLevel, it.memoirLimitBreak),
                        accessories[it.accessory ?: "None"]!!.create(it.accessoryLevel, it.accessoryLimitBreak),
                    )
                },
                guest?.let {
                    ActorLoadout(
                        it.name,
                        playerDresses[it.dress]!!.create(
                            rarity = it.rarity,
                            level = it.level,
                            friendship = it.friendship,
                            rank = it.rank,
                            rankPanelPattern = it.rankPanelPattern,
                            remake = it.remake,
                            unitSkillLevel = it.unitSkillLevel,
                            remakeSkill = null,
                        ),
                        memoirs[it.memoir]!!.create(it.memoirLevel, it.memoirLimitBreak),
                        accessories[it.accessory ?: "None"]!!.create(it.accessoryLevel, it.accessoryLimitBreak),
                    )
                },
                Song(
                    song.activeEffects.map {
                        SongEffectData(
                            songEffects[it.name]!!,
                            it.value,
                            it.conditions.map { group ->
                                group.map { name -> conditions[name]!! }.reduce { acc, condition -> acc or condition }
                            }.fold<NamedCondition?, NamedCondition?>(null) { acc, condition -> acc + condition }
                        )
                    },
                    song.passiveEffect?.let {
                        SongEffectData(
                            songEffects[it.name]!!,
                            it.value,
                            it.conditions.map { group ->
                                group.map { name -> conditions[name]!! }.reduce { acc, condition -> acc or condition }
                            }.fold<NamedCondition?, NamedCondition?>(null) { acc, condition -> acc + condition }
                        )
                    }
                ),
                strategyParsers[strategy.type]!!.parse(strategy.value),
            ),
            TeamLoadout(
                listOf(
                    bossLoadouts[boss]!!.loadout.let { loadout ->
                        loadout.copy(
                            dress = loadout.dress.let { dress ->
                                dress.copy(
                                    stats = dress.stats.let { stats ->
                                        stats.copy(hp = bossHp ?: stats.hp)
                                    }
                                )
                            }
                        )
                    }
                ),
                strategy = if (bossStrategy != null) {
                    bossStrategyParsers[bossStrategy!!.type]!!.parse(bossStrategy!!.value)
                } else {
                    { bossLoadouts[boss]!!.strategy }
                }
            ),
            {
                player.actors.values.forEach {
                    it.eventBonus += additionalEventBonus
                    it.eventMultiplier = eventMultiplier
                }
            },
            RandomDamageCalculator(),
        )
    }

fun StageResult.toSimulationResult() = when (this) {
    is ExcludedRun -> SimulationResultType.Excluded
    is OutOfTurns -> SimulationResultType.End
    is PlayError -> SimulationResultType.Error
    is TeamWipe -> SimulationResultType.Wipe(turn, tile)
    is Victory -> SimulationResultType.Victory(turn, tile)
}

fun MarginStageResult.marginResultType() = when (this) {
    is OutOfTurns -> SimulationMarginResultType.End
    is TeamWipe -> SimulationMarginResultType.Wipe
}
