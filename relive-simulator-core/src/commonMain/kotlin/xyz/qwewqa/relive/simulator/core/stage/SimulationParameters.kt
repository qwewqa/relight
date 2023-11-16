package xyz.qwewqa.relive.simulator.core.stage

import Accessories
import xyz.qwewqa.relive.simulator.common.SimulationMarginResultType
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.stage.autoskill.remakeSkills
import xyz.qwewqa.relive.simulator.core.stage.dress.Dresses
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.TeamLoadout
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoirs
import xyz.qwewqa.relive.simulator.core.stage.song.BasicSongEffects
import xyz.qwewqa.relive.simulator.core.stage.song.SongDetails
import xyz.qwewqa.relive.simulator.core.stage.song.SongEffectInstance
import xyz.qwewqa.relive.simulator.core.stage.song.ExtraSongEffects
import xyz.qwewqa.relive.simulator.core.stage.song.Songs
import xyz.qwewqa.relive.simulator.core.stage.strategy.bossStrategyParsers
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers

fun SimulationParameters.createStageLoadout(): StageLoadout {
  require(bossHp == null || bossHp > 0) { "Boss HP must be a positive integer." }
  require(maxTurns > 0) { "Max turns must be a positive integer." }
  require(maxIterations > 0) { "Max iterations must be a positive integer" }
  require(team.isNotEmpty()) { "Team must not be empty." }
  require(team.all { it.name.isNotBlank() }) { "Team members must have non-blank names." }
  require(team.map { it.name.trim() }.toSet().size == team.size) {
    "Team must not have duplicate names."
  }
  require(team.all { it.memoirLimitBreak in 0..4 }) {
    "Memoir limit break must be between 0 and 4 inclusive"
  }
  return StageLoadout(
      TeamLoadout(
          team.map {
            ActorLoadout(
                it.name.trim(),
                Dresses.aliases[it.dress]!!.create(
                    rarity = it.rarity,
                    level = it.level,
                    friendship = it.friendship,
                    rank = it.rank,
                    rankPanelPattern = it.rankPanelPattern,
                    remake = it.remake,
                    unitSkillLevel = it.unitSkillLevel,
                    remakeSkill = it.remakeSkill?.let { id -> remakeSkills[id]!! },
                    isLeader = it.isLeader,
                ),
                Memoirs.aliases[it.memoir]!!.create(it.memoirLevel, it.memoirLimitBreak),
                Accessories.aliases[it.accessory ?: "None"]!!.create(
                    it.accessoryLevel, it.accessoryLimitBreak),
                it.isSupport,
            )
          },
          guest?.let {
            ActorLoadout(
                it.name.trim(),
                Dresses.aliases[it.dress]!!.create(
                    rarity = it.rarity,
                    level = it.level,
                    friendship = it.friendship,
                    rank = it.rank,
                    rankPanelPattern = it.rankPanelPattern,
                    remake = it.remake,
                    unitSkillLevel = it.unitSkillLevel,
                    remakeSkill = null,
                    isLeader = false,
                ),
                Memoirs.aliases[it.memoir]!!.create(it.memoirLevel, it.memoirLimitBreak),
                Accessories.aliases[it.accessory ?: "None"]!!.create(
                    it.accessoryLevel, it.accessoryLimitBreak),
            )
          },
          Songs.aliases[song.id]!!.run {
            SongDetails(
                listOfNotNull(
                    song.activeEffect1?.let { (id, value) ->
                      SongEffectInstance(BasicSongEffects.aliases[id]!!, value)
                    },
                    song.activeEffect2?.let { (id, value) ->
                      SongEffectInstance(BasicSongEffects.aliases[id]!!, value)
                    },
                    awakenSkill1?.let { SongEffectInstance(it, song.awakenSkill1Value) },
                    awakenSkill2?.let { SongEffectInstance(it, song.awakenSkill2Value) },
                    awakenSkill3?.let { SongEffectInstance(it, song.awakenSkill3Value) },
                    awakenSkill4?.let { SongEffectInstance(it, song.awakenSkill4Value) },
                ) +
                    song.awakenExtraSkillSongs.mapNotNull {
                      Songs.aliases[it]!!.awakenExtraSkill?.let { effect ->
                        SongEffectInstance(effect, effect.defaultValue ?: 0)
                      }
                    },
                song.passiveEffect?.let { (id, value) ->
                  SongEffectInstance(ExtraSongEffects.aliases[id]!!, value)
                })
          },
          strategyParsers[strategy.type]!!.parse(strategy.value),
      ),
      TeamLoadout(
          listOf(
              bossLoadouts[boss]!!.loadout.let { loadout ->
                loadout.copy(
                    dress =
                        loadout.dress.let { dress ->
                          dress.copy(
                              attribute = bossAttribute ?: dress.attribute,
                              stats =
                                  dress.stats.let { stats ->
                                    stats.copy(hp = bossHp?.toI54() ?: stats.hp)
                                  })
                        })
              }),
          strategy =
              if (bossStrategy != null) {
                bossStrategyParsers[bossStrategy.type]!!.parse(bossStrategy.value)
              } else {
                { bossLoadouts[boss]!!.strategy }
              }),
      {
        player.actors.values.forEach {
          it.eventBonus += additionalEventBonus
          it.eventMultiplier = eventMultiplier
        }
      },
      RandomDamageCalculator(),
  )
}

fun StageResult.toSimulationResult() =
    when (this) {
      is ExcludedRun -> SimulationResultType.Excluded
      is OutOfTurns -> SimulationResultType.End
      is PlayError -> SimulationResultType.Error
      is TeamWipe -> SimulationResultType.Wipe(turn, tile)
      is Victory -> SimulationResultType.Victory(turn, tile)
    }

fun MarginStageResult.marginResultType() =
    when (this) {
      is OutOfTurns -> SimulationMarginResultType.End
      is TeamWipe -> SimulationMarginResultType.Wipe
    }
