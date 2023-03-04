package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinTarget
import xyz.qwewqa.relive.simulator.core.stage.modifier.agility
import xyz.qwewqa.relive.simulator.core.stage.strategy.ActionTile
import xyz.qwewqa.relive.simulator.core.stage.strategy.BoundCutin
import xyz.qwewqa.relive.simulator.core.stage.strategy.IdleTile
import xyz.qwewqa.relive.simulator.core.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.random.Random

data class PlayInfo(
    val maxTurns: Int,
    val iterationNumber: Int?,
    val maxIterations: Int?,
)

class Stage(
    val player: Team,
    val enemy: Team,
    val damageCalculator: DamageCalculator = RandomDamageCalculator(),
    val configuration: StageConfiguration = StageConfiguration(),
    val random: Random = Random.Default,
) {
  val logger = StageLogger(configuration.skipLogging)

  var turn = 0
    private set
  var tile = 0
    private set
  var move = 0
    private set

  fun setTime(turn: Int, tile: Int, move: Int) {
    this.turn = turn
    this.tile = tile
    this.move = move
  }

  var groupName: String = "Default"
  var tags: List<String> = emptyList()
  val resultMetadata
    get() = StageResultMetadata(groupName, tags)

  var cutinTarget: Actor? = null

  private inline fun executeAct(block: () -> Unit) {
    move++
    player.stageEffects.refresh()
    enemy.stageEffects.refresh()
    block()
    player.strategy.afterAct(this, player, enemy)
  }

  fun play(playInfo: PlayInfo): StageResult {
    try {
      try {
        log("Stage") { "Begin." }

        log("AutoEffect") { "Begin." }

        arrayOf(player, enemy).forEach { team ->
          if (team.song.passive != null) {
            team.active.forEach {
              it.context.log("Song") { "Apply passive ${team.song.passive.name}." }
              team.song.passive.start(it.context)
            }
          }
        }

        // for consistent results with earlier versions which performed two rounds of shuffling
        repeat(player.actors.size + enemy.actors.size - 1) { random.nextInt() }

        val allActors =
            player.actors.values + enemy.actors.values + listOfNotNull(player.guest, enemy.guest)

        allActors
            .map { it to it.dress.unitSkill }
            .forEach { (actor, us) ->
              us.forEach {
                log("AutoEffect") { "[${actor.name}] unit skill [${it.name}] activate." }
                it.activate(actor.context)
              }
            }

        allActors.forEach { sg ->
          sg.passives
              .filter { it.effect.category == PassiveEffectCategory.Passive }
              .forEach {
                sg.context.log("AutoEffect") { "Passive auto effect [${it.name}] activate." }
                it.activate(sg.context)
              }
        }

        val autoEffectPriority =
            (player.actors.values + enemy.actors.values).shuffled(random).sortedByDescending {
              it.mod { +agility }
            }

        PassiveEffectCategory.values()
            .drop(1) // skip passive
            .forEach { category ->
              autoEffectPriority.forEach { sg ->
                sg.passives
                    .filter { it.effect.category == category }
                    .forEach {
                      sg.context.log("AutoEffect") {
                        "${category.name} auto effect [${it.name}] activate."
                      }
                      it.activate(sg.context)
                    }
              }
            }

        log("AutoEffect") { "End." }

        player.finalizeTurnZero()
        enemy.finalizeTurnZero()
        player.strategy.initialize(this, player, enemy, playInfo)
        enemy.strategy.initialize(this, enemy, player, playInfo)
        while (turn < playInfo.maxTurns) {
          turn++
          tile = 0
          log("Turn", category = LogCategory.EMPHASIS) { "Turn $turn begin." }
          player.stageEffects.refresh()
          enemy.stageEffects.refresh()
          val playerQueue = player.strategy.nextQueue(this, player, enemy)
          val enemyQueue = enemy.strategy.nextQueue(this, enemy, player)
          if (playerQueue.climax) {
            log("Climax", category = LogCategory.EMPHASIS) { "Player Climax." }
            player.enterCX()
          }
          if (enemyQueue.climax) {
            log("Climax", category = LogCategory.EMPHASIS) { "Enemy Climax." }
            enemy.enterCX()
          }
          if (player.cxTurns > 0) {
            playerQueue.tiles.filterIsInstance<ActionTile>().forEach {
              if (it.actData.type == ActType.ClimaxAct) it.actor.enterCX()
            }
          }
          if (enemy.cxTurns > 0) {
            enemyQueue.tiles.filterIsInstance<ActionTile>().forEach {
              if (it.actData.type == ActType.ClimaxAct) it.actor.enterCX()
            }
          }
          val playerTiles = playerQueue.tiles + List(6 - playerQueue.tiles.size) { IdleTile }
          val enemyTiles = enemyQueue.tiles + List(6 - enemyQueue.tiles.size) { IdleTile }
          log("Queue") {
            val player =
                listOf("Player") +
                    playerTiles.map {
                      if (it is ActionTile) {
                        "[${it.actor.dress.name} (${it.actor.name})]:[${it.actData.name}]"
                      } else {
                        "..."
                      }
                    }
            val padLength = player.maxOf { it.length } + 2
            val enemy =
                listOf("enemy") +
                    enemyTiles.map {
                      if (it is ActionTile) {
                        "[${it.actor.dress.name} (${it.actor.name})]:[${it.actData.name}]"
                      } else {
                        "..."
                      }
                    }
            player
                .zip(enemy)
                .mapIndexed { i, (p, o) ->
                  if (i > 0) {
                    "$turn.$i " + p.padEnd(padLength) + o
                  } else {
                    "    " + p.padEnd(padLength) + o
                  }
                }
                .joinToString("\n")
          }

          // Can handle enemy cutins properly later
          if (enemyQueue.cutins.isNotEmpty()) error("Enemy cutins are not supported.")
          val cutins = (playerQueue.cutins + enemyQueue.cutins).groupBy { it.data.target }
          cutins[CutinTarget.TurnStart]?.forEach { cutin ->
            cutin.execute()
            checkEnded()?.let {
              return it
            }
          }

          var playerActIndex = 0
          var enemyActIndex = 0
          player.queue = playerTiles.filterIsInstance<ActionTile>()
          enemy.queue = enemyTiles.filterIsInstance<ActionTile>()
          player.queueIndex = 0
          enemy.queueIndex = 0
          playerTiles.zip(enemyTiles).forEach { (playerTile, enemyTile) ->
            tile++
            move = 0
            val (first, second) =
                when {
                  playerTile.agility > enemyTile.agility -> {
                    playerTile to enemyTile
                  }
                  enemyTile.agility > playerTile.agility -> {
                    enemyTile to playerTile
                  }
                  else -> {
                    if (random.nextDouble() > 0.5) {
                      playerTile to enemyTile
                    } else {
                      enemyTile to playerTile
                    }
                  }
                }
            val tileCutins = mutableListOf<Pair<BoundCutin, Actor>>()
            if (playerTile is ActionTile) {
              playerActIndex++
              tileCutins +=
                  cutins[CutinTarget.BeforeAllyAct(playerActIndex)]?.map { it to playerTile.actor }
                      ?: emptyList()
            }
            if (enemyTile is ActionTile) {
              enemyActIndex++
              tileCutins +=
                  cutins[CutinTarget.BeforeEnemyAct(enemyActIndex)]?.map { it to enemyTile.actor }
                      ?: emptyList()
            }
            tileCutins.forEach { (cutin, target) ->
              cutinTarget = target
              executeAct { cutin.execute() }
              checkEnded()?.let {
                return it
              }
            }
            cutinTarget = null
            if (first is ActionTile)
                executeAct {
                  first.actor.context.team.queueIndex++
                  first.execute()
                }
            checkEnded()?.let {
              return it
            }
            if (second is ActionTile)
                executeAct {
                  second.actor.context.team.queueIndex++
                  second.execute()
                }
            checkEnded()?.let {
              return it
            }
          }

          if (enemyQueue.cutins.isNotEmpty()) error("Enemy cutins are not supported.")
          cutins[CutinTarget.TurnEnd]?.forEach { cutin ->
            cutin.execute()
            checkEnded()?.let {
              return it
            }
          }

          executeAct { // dots
            tile += 1
            move = 0
            log("Buff", category = LogCategory.BUFF) { "Turn end tick." }
            player.endTurn()
            enemy.endTurn()
          }
          log("Turn", debug = true) { "Ending strategy turns." }
          player.strategy.endTurn(this, player, enemy, playerQueue, enemyQueue)
          enemy.strategy.endTurn(this, enemy, player, enemyQueue, playerQueue)
          log("Turn", category = LogCategory.EMPHASIS) { "Turn $turn end." }
          checkEnded()?.let {
            return it
          }
        }
        player.strategy.finalize(this, player, enemy)
        enemy.strategy.finalize(this, enemy, player)
        log("Stage") { "End." }
        return OutOfTurns(
            enemy.active.sumOf { it.maxHp - it.hp }, enemy.active.sumOf { it.hp }, resultMetadata)
      } catch (e: IgnoreRunException) {
        log("Stage") { "Early run end." }
        player.strategy.finalize(this, player, enemy)
        enemy.strategy.finalize(this, enemy, player)
        log("Stage") { "End." }
        return ExcludedRun(resultMetadata)
      } catch (e: Exception) {
        log("Error") { e.stackTraceToString() }
        player.strategy.finalize(this, player, enemy)
        enemy.strategy.finalize(this, enemy, player)
        log("Stage") { "End." }
        return PlayError(e, resultMetadata)
      }
    } catch (e: IgnoreRunException) {
      log("Stage") { "Run ignored in finalizer." }
      log("Stage") { "End." }
      return ExcludedRun(resultMetadata)
    } catch (e: Exception) {
      log("Finalizer Error.") { e.stackTraceToString() }
      log("Stage") { "End." }
      return PlayError(e, resultMetadata)
    }
  }

  private fun checkEnded(): StageResult? {
    if (player.active.isEmpty()) {
      player.strategy.finalize(this, player, enemy)
      enemy.strategy.finalize(this, enemy, player)
      log("Stage") { "End." }
      return TeamWipe(
          enemy.active.sumOf { it.maxHp - it.hp },
          enemy.active.sumOf { it.hp },
          turn,
          tile,
          resultMetadata)
    }
    if (enemy.active.isEmpty()) {
      player.strategy.finalize(this, player, enemy)
      enemy.strategy.finalize(this, enemy, player)
      log("Stage") { "End." }
      return Victory(turn, tile, resultMetadata)
    }
    return null
  }

  init {
    player.actors.values.forEach { it.context = ActionContext(it, this, player, enemy) }
    player.guest?.let { it.context = ActionContext(it, this, player, enemy) }
    enemy.actors.values.forEach { it.context = ActionContext(it, this, enemy, player) }
    enemy.guest?.let { it.context = ActionContext(it, this, enemy, player) }
  }
}

expect class IgnoreRunException : Exception

expect fun ignoreRun(): Nothing

sealed class StageResult {
  abstract val metadata: StageResultMetadata
}

data class StageResultMetadata(
    val groupName: String,
    val tags: List<String>,
)

sealed class MarginStageResult : StageResult() {
  abstract val damage: Int
  abstract val margin: Int
}

data class TeamWipe(
    override val damage: Int,
    override val margin: Int,
    val turn: Int,
    val tile: Int,
    override val metadata: StageResultMetadata,
) : MarginStageResult()

data class OutOfTurns(
    override val damage: Int,
    override val margin: Int,
    override val metadata: StageResultMetadata,
) : MarginStageResult()

data class Victory(val turn: Int, val tile: Int, override val metadata: StageResultMetadata) :
    StageResult()

data class PlayError(val exception: Exception, override val metadata: StageResultMetadata) :
    StageResult()

data class ExcludedRun(override val metadata: StageResultMetadata) : StageResult()

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(
    vararg tags: String,
    category: LogCategory = LogCategory.DEFAULT,
    debug: Boolean = false,
    summary: () -> String? = { null },
    value: () -> String
) {
  contract { callsInPlace(value, InvocationKind.AT_MOST_ONCE) }

  if (configuration.logging && (!debug || configuration.debug) && logger.prepare()) {
    logger.log(turn, tile, move, category, *tags, summary = summary(), content = value())
  }
}
