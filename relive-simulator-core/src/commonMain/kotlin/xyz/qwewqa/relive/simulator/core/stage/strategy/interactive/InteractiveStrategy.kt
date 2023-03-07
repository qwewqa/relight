package xyz.qwewqa.relive.simulator.core.stage.strategy.interactive

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import xyz.qwewqa.relive.simulator.common.ActCardStatus
import xyz.qwewqa.relive.simulator.common.ActionStatus
import xyz.qwewqa.relive.simulator.common.ActorStatus
import xyz.qwewqa.relive.simulator.common.CutinCardStatus
import xyz.qwewqa.relive.simulator.common.InteractiveLog
import xyz.qwewqa.relive.simulator.common.InteractiveLogData
import xyz.qwewqa.relive.simulator.common.InteractiveQueueStatus
import xyz.qwewqa.relive.simulator.common.InteractiveRunState
import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.core.stage.PlayInfo
import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.StageConfiguration
import xyz.qwewqa.relive.simulator.core.stage.SwitchableDamageCalculator
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.countableBuffsByName
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.buff.hasMultipleCA
import xyz.qwewqa.relive.simulator.core.stage.hierarchicalString
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.modifier.accuracy
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.modifier.agility
import xyz.qwewqa.relive.simulator.core.stage.modifier.baseMaxHp
import xyz.qwewqa.relive.simulator.core.stage.modifier.critical
import xyz.qwewqa.relive.simulator.core.stage.modifier.dexterity
import xyz.qwewqa.relive.simulator.core.stage.modifier.evasion
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHp
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHpUp
import xyz.qwewqa.relive.simulator.core.stage.modifier.normalDefense
import xyz.qwewqa.relive.simulator.core.stage.modifier.specialDefense
import xyz.qwewqa.relive.simulator.core.stage.strategy.*
import xyz.qwewqa.relive.simulator.core.stage.strategy.complete.qsort
import xyz.qwewqa.relive.simulator.core.stage.team.Team
import kotlin.random.Random

private const val INDENT = "  "

class InteractiveSimulationController(val maxTurns: Int, val seed: Int, val loadout: StageLoadout) {
  private val mutex = Mutex()

  private val fullHistory = mutableListOf<String>()

  private val saves = mutableMapOf<String, CacheableStatus>()

  private class UserInput : Throwable("Awaiting user input.")

  private var rev = 0
  private var resultLog = emptyList<LogEntry>() // Has transient entries compared to status.entries
  private var status = CacheableStatus()

  private class CacheableStatus {
    var initialized = false
      private set

    private var index = -1
    private val playHistory = mutableListOf<ParsedCommand>()
    private val stageLog = mutableListOf<LogEntry>()
    private val queueStatusHistory = mutableListOf<InteractiveQueueStatus>()
    private val lengths = mutableListOf<Int>()
    private val enemyStatuses = mutableListOf<List<ActorStatus>>()
    private val playerStatuses = mutableListOf<List<ActorStatus>>()

    // First entry is just a placeholder
    val history: List<ParsedCommand>
      get() = if (index >= 1) playHistory.subList(1, index + 1) else emptyList()
    val log: List<LogEntry>
      get() = stageLog.subList(0, lengths.getOrElse(index) { 0 })

    val queueStatus: InteractiveQueueStatus?
      get() =
          queueStatusHistory
              .getOrNull(index)
              ?.copy(
                  canUndo = canUndo,
                  canRedo = canRedo,
              )

    val enemyStatus: List<ActorStatus>?
      get() = enemyStatuses.getOrNull(index)
    val playerStatus: List<ActorStatus>?
      get() = playerStatuses.getOrNull(index)

    val canUndo
      get() = index > 0
    val canRedo
      get() = index < playHistory.lastIndex

    fun update(
        command: ParsedCommand,
        entries: List<LogEntry>,
        queueStatus: InteractiveQueueStatus,
        enemyStatus: List<ActorStatus>,
        playerStatus: List<ActorStatus>,
    ) {
      if (canRedo) {
        truncate()
      }
      index++
      playHistory += command
      stageLog += entries.asSequence().drop(stageLog.size)
      lengths += entries.size
      queueStatusHistory += queueStatus
      enemyStatuses += enemyStatus
      playerStatuses += playerStatus
    }

    fun init(
        controller: InteractiveSimulationController,
        entries: List<LogEntry>,
        enemyStatus: List<ActorStatus>,
        playerStatus: List<ActorStatus>,
    ) {
      if (initialized) {
        throw IllegalStateException("Status already initialized.")
      }
      index = 0
      playHistory += ParsedCommand(InteractiveCommandType.HELP, "", "")
      stageLog.addAll(entries)
      queueStatusHistory +=
          InteractiveQueueStatus(
              0,
              0,
              controller.maxTurns,
              emptyList(),
              emptyList(),
              null,
              emptyList(),
              0,
              0,
              false,
              0,
              false,
              null,
              InteractiveRunState.SETUP,
          )
      lengths += entries.size
      enemyStatuses += enemyStatus
      playerStatuses += playerStatus
      initialized = true
    }

    fun undo() {
      index--
    }

    fun redo() {
      index++
    }

    fun seekBack(): Boolean {
      if (!canUndo) return false
      val initialTurn = queueStatusHistory[index].turn
      if (queueStatusHistory[index - 1].turn != initialTurn) {
        index--
        return true
      }
      while (index > 0 && queueStatusHistory[index - 1].turn == initialTurn) {
        index--
      }
      return true
    }

    fun seekForward(): Boolean {
      if (!canRedo) return false
      val initialTurn = queueStatusHistory[index].turn
      if (queueStatusHistory[index + 1].turn != initialTurn) {
        index++
        return true
      }
      while (index < queueStatusHistory.lastIndex &&
          queueStatusHistory[index + 1].turn == initialTurn) {
        index++
      }
      return true
    }

    fun tryUndo(): Boolean {
      if (!canUndo) return false
      undo()
      return true
    }

    fun tryRedo(): Boolean {
      if (!canRedo) return false
      redo()
      return true
    }

    fun rewind() {
      index = 0
    }

    fun fastForward() {
      index = playHistory.lastIndex
    }

    fun copy() =
        CacheableStatus().also {
          it.initialized = initialized
          it.index = index
          it.playHistory += playHistory
          it.stageLog += stageLog
          it.queueStatusHistory += queueStatusHistory
          it.lengths += lengths
          it.enemyStatuses += enemyStatuses
          it.playerStatuses += playerStatuses
        }

    fun replace(other: CacheableStatus) {
      initialized = other.initialized
      index = other.index
      playHistory.clear()
      playHistory += other.playHistory
      stageLog.clear()
      stageLog += other.stageLog
      lengths.clear()
      lengths += other.lengths
      queueStatusHistory.clear()
      queueStatusHistory += other.queueStatusHistory
      enemyStatuses.clear()
      enemyStatuses += other.enemyStatuses
      playerStatuses.clear()
      playerStatuses += other.playerStatuses
    }

    private fun truncate() {
      playHistory.truncate(index)
      stageLog.truncate(lengths[index] - 1)
      lengths.truncate(index)
      queueStatusHistory.truncate(index)
      enemyStatuses.truncate(index)
      playerStatuses.truncate(index)
    }

    private fun <T> MutableList<T>.truncate(lastIndex: Int) {
      subList(lastIndex + 1, size).clear()
    }
  }

  private inline fun playStage(command: ParsedCommand?, after: Stage.() -> Unit = {}) {
    val managedRandom = ManagedRandom(Random(Random(seed).nextInt()))
    val strategy = InteractiveStrategy(managedRandom, status.history + listOfNotNull(command))
    val stage =
        loadout
            .copy(player = loadout.player.copy(strategy = { strategy }))
            .create(
                random = managedRandom,
                configuration =
                    StageConfiguration(
                        logging = true,
                        skipLogging = if (command != null) status.log.size else 0,
                    ),
            )
    stage.logger.appendEntries(status.log)
    when {
      command != null -> {
        try {
          stage.play(PlayInfo(maxTurns = maxTurns, null, null))
        } catch (_: UserInput) {}

        status.update(
            command,
            stage.logger.get(),
            strategy.queueStatus,
            enemyStatus = strategy.enemyStatus,
            playerStatus = strategy.teamStatus,
        )
      }
      !status.initialized -> {
        try {
          stage.play(PlayInfo(maxTurns = maxTurns, null, null))
        } catch (_: UserInput) {}

        status.init(
            this,
            stage.logger.get(),
            enemyStatus = strategy.enemyStatus,
            playerStatus = strategy.teamStatus,
        )
      }
      else -> {
        status.log.lastOrNull()?.let { lastEntry ->
          stage.setTime(lastEntry.turn, lastEntry.tile, lastEntry.move)
        }
      }
    }
    stage.after()
    rev++
    resultLog = stage.logger.get()
  }

  private fun playStageTest(testActs: List<Int>): Int {
    val managedRandom = ManagedRandom(Random(Random(seed).nextInt()))
    val strategy = InteractiveStrategy(managedRandom, status.history, testActs = testActs)
    val stage =
        loadout
            .copy(
                player = loadout.player.copy(strategy = { strategy }),
                damageCalculator = SwitchableDamageCalculator())
            .create(
                random = managedRandom,
                configuration = StageConfiguration(),
            )
    try {
      stage.play(PlayInfo(maxTurns = maxTurns, null, null))
    } catch (_: UserInput) {}

    return stage.enemy.actors.values.sumOf { it.hp }
  }

  init {
    playStage(null)
  }

  suspend fun getLog(rev: Int = -1) =
      mutex.withLock {
        if (rev != this.rev) {
          InteractiveLog(
              InteractiveLogData(
                  resultLog, null, status.queueStatus, status.enemyStatus, status.playerStatus),
              this.rev)
        } else {
          InteractiveLog(null, this.rev)
        }
      }

  suspend fun sendCommand(text: String) =
      mutex.withLock {
        val command =
            parseCommand(text)
                ?: run {
                  playStage(null) {
                    log("Command", category = LogCategory.COMMAND) {
                      "Error: Unknown command '$text'. Use 'help' for information."
                    }
                  }
                  return@withLock
                }
        fullHistory += command.raw
        when (command.type) {
          InteractiveCommandType.AUTO_QUEUE -> {
            if (status.queueStatus?.runState != InteractiveRunState.QUEUE) {
              playStage(null) {
                log("Command", category = LogCategory.COMMAND) {
                  "Error: Cannot auto-queue when not in queue."
                }
              }
              return@withLock
            }
            val candidates = run {
              var candidates: Set<List<Int>>? = null
              playStage(command) {
                candidates = (player.strategy as InteractiveStrategy).queueCandidates
              }
              status.undo() // Remove the auto_queue command from the history

              candidates
            }
            if (candidates.isNullOrEmpty()) {
              playStage(null) {
                log("Command", category = LogCategory.COMMAND) { "Error: Cannot auto-queue." }
              }
              return@withLock
            }
            val bestQueue = candidates.minBy { playStageTest(it) }
            if (bestQueue.isEmpty()) {
              playStage(null) {
                log("Command", category = LogCategory.COMMAND) { "Error: Cannot auto-queue." }
              }
              return@withLock
            }
            val commandData = bestQueue.joinToString(" ") { "${it + 1}" }
            val generatedCommand =
                ParsedCommand(
                    type = InteractiveCommandType.QUEUE,
                    data = commandData,
                    raw = "queue $commandData",
                )
            playStage(generatedCommand) {
              log("Command", category = LogCategory.COMMAND) { "Auto-queued successfully." }
            }
          }
          InteractiveCommandType.SAVE -> {
            saves[command.data] = status.copy()
            playStage(null) {
              log("Command", "Save", category = LogCategory.COMMAND) {
                "Saved state as '${command.data}'."
              }
            }
          }
          InteractiveCommandType.LOAD -> {
            val saveData = saves[command.data]
            if (saveData == null) {
              playStage(null) {
                log("Command", "Load", category = LogCategory.COMMAND) {
                  "No save state with name '${command.data}' found."
                }
              }
            } else {
              status.replace(saveData)
              playStage(null) {
                log("Command", "Load", category = LogCategory.COMMAND) {
                  "Loaded save state with name '${command.data}'."
                }
              }
            }
          }
          InteractiveCommandType.UNDO -> {
            if (status.tryUndo()) {
              playStage(null) {
                log("Command", "Undo", category = LogCategory.COMMAND) {
                  "Successfully undid command."
                }
              }
            } else {
              playStage(null) {
                log("Command", "Undo", category = LogCategory.COMMAND) {
                  "Error: History is empty."
                }
              }
            }
          }
          InteractiveCommandType.REDO -> {
            if (status.tryRedo()) {
              playStage(null) {
                log("Command", "Redo", category = LogCategory.COMMAND) {
                  "Successfully redid command."
                }
              }
            } else {
              playStage(null) {
                log("Command", "Redo", category = LogCategory.COMMAND) {
                  "Error: History is empty."
                }
              }
            }
          }
          InteractiveCommandType.SEEK_BACK -> {
            if (status.seekBack()) {
              playStage(null) {
                log("Command", "Seek Back", category = LogCategory.COMMAND) {
                  "Successfully seeked back."
                }
              }
            } else {
              playStage(null) {
                log("Command", "Seek Back", category = LogCategory.COMMAND) {
                  "Error: History is empty."
                }
              }
            }
          }
          InteractiveCommandType.SEEK_FORWARD -> {
            if (status.seekForward()) {
              playStage(null) {
                log("Command", "Seek Forward", category = LogCategory.COMMAND) {
                  "Successfully seeked forward."
                }
              }
            } else {
              playStage(null) {
                log("Command", "Seek Forward", category = LogCategory.COMMAND) {
                  "Error: History is empty."
                }
              }
            }
          }
          InteractiveCommandType.RESTART -> {
            status.rewind()
            playStage(null) {
              log("Command", "Restart", category = LogCategory.COMMAND) {
                "Successfully restarted."
              }
            }
          }
          InteractiveCommandType.FAST_FORWARD -> {
            status.fastForward()
            playStage(null) {
              log("Command", "Fast Forward", category = LogCategory.COMMAND) {
                "Successfully fast forwarded."
              }
            }
          }
          InteractiveCommandType.EIGHT_BALL -> {
            playStage(null) {
              if (command.data.isNotBlank()) {
                log("Magic 8-Ball", "Question", category = LogCategory.EMPHASIS) { command.data }
              }
              val answer = EightBallAnswer.values().random()
              log(
                  "Magic 8-Ball",
                  "Answer",
                  category =
                      when (answer.answerType) {
                        EightBallAnswerType.AFFIRMATIVE -> LogCategory.HEAL
                        EightBallAnswerType.MIXED -> LogCategory.BRILLIANCE
                        EightBallAnswerType.NEGATIVE -> LogCategory.DAMAGE
                      },
              ) {
                answer.message
              }
            }
          }
          InteractiveCommandType.SEED -> {
            val seed = Random.nextInt()
            if (status.history.lastOrNull()?.type == InteractiveCommandType.SEED) {
              status.undo()
            }
            playStage(command.copy(data = "$seed", raw = "${command.raw} $seed"))
          }
          else -> {
            playStage(command)
          }
        }
      }

  // Safari doesn't support lookbehinds for the obvious escape processing,
  // so use a lookahead instead
  private fun String.splitArgs() =
      trim()
          .reversed()
          .split("""\s+(?!\\(\\\\)*)""".toRegex())
          .map { it.reversed().replace("""\ """, " ") }
          .reversed()

  private fun parseCommand(text: String): ParsedCommand? {
    val trimmed = text.trim()
    if (trimmed.isEmpty()) {
      return null
    }
    val strings = trimmed.split("\\s+".toRegex(), 2)
    val title = strings[0]
    val data = if (strings.size == 1) "" else strings[1]
    val command = interactiveCommands[title] ?: return null
    return ParsedCommand(command, data, trimmed)
  }

  private data class TurnStatus(
      val actorStatuses: List<ActorStatus>,
      val climax: Boolean,
      val held: BoundAct?,
      val discarded: BoundAct?,
  )

  private inner class InteractiveStrategy(
      val managedRandom: ManagedRandom,
      val history: List<ParsedCommand>,
      val testActs: List<Int>? =
          null, // Used to test queues for auto queue; list of hand indices to queue at the end
  ) : Strategy {
    val commands = ArrayDeque(history)

    private fun nextCommand() = commands.removeFirstOrNull() ?: throw UserInput()

    private var queuing = false // true in nextQueue, false otherwise

    var queueCandidates: Set<List<Int>>? = null
      private set

    private var ranTestQueue = false

    lateinit var stage: Stage
    lateinit var team: Team
    lateinit var enemy: Team

    private var liveMode = false

    private val allActors = mutableMapOf<String, Actor>()

    private val queue = mutableListOf<BoundAct>()
    private var queueSize: Int = 0
    private var climax = false

    private val cutinQueue = mutableListOf<BoundCutin>()
    private var cutinEnergy = 0
    private var cutinUseCounts = mutableMapOf<BoundCutin, Int>().withDefault { 0 }
    private var cutinLastUseTurns = mutableMapOf<BoundCutin, Int>().withDefault { 0 }

    private val discardPile = mutableListOf<BoundAct>()
    private val drawPile = ArrayDeque<BoundAct>()
    private val hand = mutableListOf<BoundAct>()
    private val internalHand = mutableListOf<BoundAct>()
    private val usedClimaxActs = mutableSetOf<BoundAct>()
    private var hasUsedGuestClimaxAct = false
    private var held: BoundAct? = null
    private var holdActionTarget: BoundAct? = null
    private val hasPerformedHoldAction
      get() = holdActionTarget != null

    private var incremental = false

    private val statusHistory = mutableListOf<TurnStatus>()
    private val queueHistory = mutableListOf<QueueResult>()

    private var lastExport: String? = null

    private var finished = false

    private var lastQueueStatus: List<ActCardStatus> = emptyList()
    private var lastCutinStatus: List<CutinCardStatus> = emptyList()

    val queueStatus: InteractiveQueueStatus
      get() =
          InteractiveQueueStatus(
              stage.turn,
              stage.tile,
              maxTurns,
              if (queuing) queue.map { it.status } else lastQueueStatus,
              if (queuing) hand.map { it.status } else emptyList(),
              if (!finished) held?.status else null,
              if (queuing) team.actors.values.mapNotNull { it.cutin?.status } else lastCutinStatus,
              cutinQueue.sumOf { it.data.cost },
              cutinEnergy,
              queuing && !hasPerformedHoldAction && team.active.size > 1,
              if (climax) 2 else team.cxTurns,
              queuing &&
                  team.cxTurns == 0 &&
                  team.actors.values.any { it.brilliance >= 100 } &&
                  !climax,
              lastExport,
              when {
                finished -> InteractiveRunState.FINISHED
                queuing -> InteractiveRunState.QUEUE
                stage.turn == 0 -> InteractiveRunState.SETUP
                else -> InteractiveRunState.RUN
              },
              team.stageEffects.getDisplayData(),
              enemy.stageEffects.getDisplayData(),
          )

    val BoundAct.status
      get() =
          ActCardStatus(
              actor.dress.id,
              act.icon ?: 0,
              apCost,
              act.apCost,
              act.type == ActType.ClimaxAct,
              actor.isSupport,
              when {
                this == held -> ActionStatus.HELD
                queue.count { it == this } >= hand.count { it == this } -> ActionStatus.QUEUED
                queue.sumOf { it.apCost } + apCost > 6 -> ActionStatus.TOO_EXPENSIVE
                else -> ActionStatus.READY
              },
              hand.indexOf(this) + 1, // 1-indexed
          )

    val BoundCutin.status
      get() =
          CutinCardStatus(
              actor.name,
              actor.dress.id,
              actor.memoir!!.id,
              data.cost,
              (currentCooldownValue + 1 + (cutinLastUseTurns.getValue(this) - stage.turn))
                  .coerceAtLeast(0),
              cutinUseCounts.getValue(this),
              data.usageLimit,
              when {
                this in cutinQueue -> ActionStatus.QUEUED
                !actor.isAlive -> ActionStatus.HOLDER_EXITED
                cutinUseCounts.getValue(this) >= data.usageLimit -> ActionStatus.NO_MORE_USES
                stage.turn - cutinLastUseTurns.getValue(this) <= currentCooldownValue ->
                    ActionStatus.COOLDOWN
                data.cost + cutinQueue.sumOf { it.data.cost } > cutinEnergy ->
                    ActionStatus.TOO_EXPENSIVE
                else -> ActionStatus.READY
              },
              actor.isSupport,
          )

    val teamStatus
      get() = team.actors.values.map { it.status() }
    val enemyStatus
      get() = enemy.actors.values.map { it.status() }

    fun Actor.status() = mod {
      ActorStatus(
          name,
          dress.id,
          isSupport,
          hp,
          maxHp,
          dexterity,
          brilliance,
          cxActive,
          context.actionLog.damageDealtToEnemy,
          buffs.getDisplayBuffs())
    }

    private val Actor.cxActive
      get() = inCX || (hp > 0 && brilliance == 100 && this in team.active && climax)

    private inline fun log(value: () -> String) {
      stage.log("Command", category = LogCategory.COMMAND) { value() }
    }

    private inline fun log(
        vararg tags: String,
        category: LogCategory = LogCategory.COMMAND,
        summary: () -> String? = { null },
        value: () -> String,
    ) {
      stage.log("Command", *tags, category = category, summary = { summary() }) { value() }
    }

    override fun initialize(stage: Stage, team: Team, enemy: Team) {
      this.stage = stage
      this.team = team
      this.enemy = enemy
      enemy.actors.values.forEach { actor -> allActors[actor.name] = actor }
      if (enemy.actors.size == 1) {
        allActors["boss"] = enemy.actors.values.single()
      }
      team.actors.values.forEach { actor ->
        allActors[actor.name] = actor
        discardPile += BoundAct(actor, ActType.Act1)
        discardPile += BoundAct(actor, ActType.Act2)
        discardPile += BoundAct(actor, ActType.Act3)
      }
      log { "Once ready, use 'go'." }
      log { "Use 'help' for usage details." }
      while (true) {
        val command = nextCommand()
        processCommand(command)
        if (command.type == InteractiveCommandType.GO) break
      }
    }

    override fun finalize(stage: Stage, team: Team, enemy: Team) {
      finished = true
      while (true) {
        val command = nextCommand()
        processCommand(command)
        if (command.type == InteractiveCommandType.GO) {
          log { "Already ended." }
        }
      }
    }

    override fun afterAct(stage: Stage, team: Team, enemy: Team) {
      queuing = false
      if (!incremental || testActs != null) return
      while (true) {
        val command = nextCommand()
        processCommand(command)
        if (command.type == InteractiveCommandType.GO) break
      }
    }

    private fun drawCard(count: Int): List<BoundAct> {
      if (drawPile.size < 5) {
        drawPile += discardPile.shuffled(stage.random)
        discardPile.clear()
      }
      return List(count) { drawPile.removeFirst() }
    }

    private fun drawHand() {
      if (team.active.size == 1) {
        val actor = team.active[0]
        held = null
        discardPile.clear()
        drawPile.clear()
        drawPile += BoundAct(actor, ActType.Act1)
        drawPile += BoundAct(actor, ActType.Act2)
        drawPile += BoundAct(actor, ActType.Act3)
        drawPile += BoundAct(actor, ActType.Act1)
        drawPile += BoundAct(actor, ActType.Act1)
      }
      if (climax || team.cxTurns > 0) {
        hand +=
            team.active
                .filter { it.brilliance >= 100 }
                .map { BoundAct(it, ActType.ClimaxAct) }
                .filter {
                  it !in usedClimaxActs ||
                      it.actor.hasMultipleCA
                }
      }
      if (hand.size < 5) hand += drawCard(5 - hand.size)
      if (climax || team.cxTurns > 0) {
        if (!hasUsedGuestClimaxAct) {
          team.guest?.let { hand += BoundAct(it, ActType.ClimaxAct, isGuest = true) }
        }
      }
      // should have been cleared before this function was called
      internalHand += hand
      hand.qsort()
    }

    private fun discardHand() {
      internalHand.forEach {
        if (it !in discardPile && it.actor.isAlive && it.act.type != ActType.ClimaxAct) {
          discardPile += it
        }
      }
      hand.clear()
      internalHand.clear()
    }

    private val BoundCutin.currentCooldownValue
      get() =
          if (cutinUseCounts.getValue(this) > 0) {
            data.cooldown
          } else {
            (data.startCooldown - actor.cutinInitialCooldownReduction).coerceAtLeast(0)
          }

    override fun nextQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
      if (ranTestQueue) {
        throw UserInput()
      }
      queuing = true
      if (team.cxTurns == 0) {
        usedClimaxActs.clear()
      }
      holdActionTarget = null
      climax = false
      queue.clear()
      cutinQueue.clear()
      queueSize = 0
      drawHand()
      cutinEnergy = stage.turn + 2
      stage.log("Strategy", summary = { "Turn start." }) {
        """
${
                    hierarchicalString("Status", INDENT) {
                        "Team" {
                            team.actors.values.forEach { actor ->
                                "${actor.dress.name} (${actor.name})" {
                                    +"Hp: ${actor.hp}/${actor.maxHp}"
                                    +"Brilliance: ${actor.brilliance}/100"
                                }
                            }
                        }
                        "Enemy" {
                            enemy.actors.values.forEach { actor ->
                                "${actor.dress.name} (${actor.name})" {
                                    +"Hp: ${actor.hp}/${actor.maxHp}"
                                    +"Brilliance: ${actor.brilliance}/100"
                                }
                            }
                        }
                    }
                }
                    
${formattedHand()}
                """
            .trimIndent()
      }
      while (true) {
        if (testActs != null && commands.isEmpty()) {
          queue += testActs.map { hand[it] }
          (stage.damageCalculator as SwitchableDamageCalculator).isRandom = false
          ranTestQueue = true
          stage.enemy.active.forEach {
            it.mod {
              // Reset hp to a high value to prevent early kills
              baseMaxHp setTo 1_000_000_000
              maxHpUp setTo 0
              it.adjustHp(it.maxHp)
            }
          }
          break
        }
        val command = nextCommand()
        processCommand(command)
        if (command.type == InteractiveCommandType.GO) break
      }
      discardHand()
      cutinQueue.forEach { cutin ->
        cutinLastUseTurns[cutin] = stage.turn
        cutinUseCounts[cutin] = cutinUseCounts.getValue(cutin) + 1
      }
      queue.forEach {
        if (it.act.type == ActType.ClimaxAct) {
          usedClimaxActs += it
          if (it.actor == team.guest) {
            hasUsedGuestClimaxAct = true
          }
        }
      }
      return QueueResult(
              buildList {
                queue.forEach {
                  val apCost = it.apCost
                  repeat(apCost - 1) { this += IdleTile }
                  this += ActionTile(it.actor, apCost, it.act)
                }
              },
              climax,
              cutinQueue.toList(),
          )
          .also { queueResult ->
            queueHistory += queueResult
            statusHistory +=
                TurnStatus(
                    team.actors.values.map { actor -> actor.status() },
                    team.cxTurns > 0 || queueResult.climax,
                    held = holdActionTarget.takeIf { held != null },
                    discarded = holdActionTarget.takeIf { held == null },
                )
            lastQueueStatus = queue.map { it.status }
            lastCutinStatus = team.actors.values.mapNotNull { it.cutin?.status }
          }
    }

    private fun String.parseSingleAct(): BoundAct? {
      val args = splitArgs()
      return when {
        args.size == 1 && args[0].toIntOrNull()?.minus(1) in hand.indices -> {
          hand[args[0].toInt() - 1]
        }
        args.size == 2 && args[0] in team.actors && args[1] in actNameMapping -> {
          BoundAct(team.actors[args[0]]!!, actNameMapping[args[1]]!!)
        }
        else -> null
      }
    }

    private fun String.parseQueueActs(): List<BoundAct>? {
      val args = splitArgs()
      return when {
        args.size == 1 && args[0].all { it.isDigit() } -> {
          args[0].map { (it - '0') - 1 }.map { hand[it] }
        }
        args.all { it.toIntOrNull()?.minus(1) in hand.indices } -> {
          args.map { hand[it.toInt() - 1] }
        }
        else -> {
          parseActs(args)
        }
      }
    }

    private fun String.parseActs() = parseActs(splitArgs())

    private fun parseActs(args: List<String>): List<BoundAct>? {
      var activeActor: Actor? = null
      val result = mutableListOf<BoundAct>()
      args.forEach { arg ->
        when (arg) {
          in team.actors -> activeActor = team.actors[arg]!!
          in actNameMapping -> activeActor?.let { result += BoundAct(it, actNameMapping[arg]!!) }
                  ?: return null
          else -> return null
        }
      }
      return result
    }

    private fun String.parseActorAndInteger(): Pair<Actor, Int>? {
      val args = splitArgs()
      if (args.size != 2) return null
      val actor = allActors[args[0]] ?: return null
      val value = args[1].toIntOrNull() ?: return null
      return actor to value
    }

    private fun processCommand(command: ParsedCommand) =
        command.run {
          log(category = LogCategory.USER) { raw }
          when (type) {
            InteractiveCommandType.HELP -> {
              if (data.isNotEmpty()) {
                if (data == "all") {
                  log("Help", summary = { "all" }) {
                    InteractiveCommandType.values()
                        .sortedBy { it.title }
                        .joinToString("\n\n") {
                          "${it.title}:\n\n${it.helpBody.prependIndent(INDENT)}"
                        }
                  }
                } else {
                  val targetCommand = interactiveCommands[data]
                  if (targetCommand == null) {
                    log("Help") { "Error: Unknown command." }
                  } else {
                    log("Help", summary = { targetCommand.title }) { targetCommand.helpBody }
                  }
                }
              } else {
                log("Help", summary = { "?" }) {
                  """
Use 'help all' to list information on all commands.
Use 'help <name_of_command>' to get information on a particular command.

Available Commands:
${
                                (InteractiveCommandType
                                    .values()
                                    .sortedBy { it.title }
                                    .joinToString("\n") { "@[${it.title}](command: help ${it.title})" })
                                    .prependIndent(INDENT)
                            }
"""
                      .trimIndent()
                }
              }
            }
            InteractiveCommandType.GO -> {}
            InteractiveCommandType.QUEUE -> {
              if (!queuing) {
                log("Queue") { "Error: Not in a turn." }
                return@run
              }
              try {
                val acts = data.parseQueueActs() ?: error("Invalid arguments.")
                val originalQueue = queue.toList()
                try {
                  acts.forEach { act ->
                    if (queue.count { it == act } >= hand.count { it == act }) {
                      if (hand.count { it == act } == 0) {
                        error("Act '$act' is not in hand.")
                      } else {
                        error("Act '$act' was already queued.")
                      }
                    } else if (queue.sumOf { it.apCost } + act.apCost > 6) {
                      error("Act '$act' exceeds max ap.")
                    }
                    queue += act
                  }
                  log("Queue", summary = { "Successfully queued act(s)." }) { formattedStatus() }
                } catch (e: RuntimeException) {
                  queue.clear()
                  queue += originalQueue
                  throw e
                }
              } catch (e: RuntimeException) {
                log("Queue") { "Error: ${e.message}" }
              }
            }
            InteractiveCommandType.HOLD -> {
              if (!queuing) {
                log("Hold") { "Error: Not in a turn." }
                return@run
              }
              val act = data.parseSingleAct()
              when {
                act == null -> {
                  log("Hold") { "Error: Invalid arguments." }
                }
                team.actors.values.count { it.isAlive } <= 1 -> {
                  log("Hold") { "Error: Team has too few active actors." }
                }
                held != null -> {
                  log("Hold") { "Error: Already holding an act." }
                }
                act in queue -> {
                  log("Hold") { "Error: Act already queued." }
                }
                act !in hand -> {
                  log("Hold") { "Error: Act not in hand." }
                }
                hasPerformedHoldAction -> {
                  log("Hold") { "Error: Hold action already performed this turn." }
                }
                act.type == ActType.ClimaxAct -> {
                  log("Hold") { "Error: Cannot hold a climax act" }
                }
                else -> {
                  held = act
                  val newAct = drawCard(1).single()
                  internalHand -= act
                  internalHand += newAct
                  hand[hand.indexOf(act)] = newAct
                  holdActionTarget = act
                  log("Hold", summary = { "Successfully held '${act}'." }) { formattedHand() }
                }
              }
            }
            InteractiveCommandType.DISCARD -> {
              if (!queuing) {
                log("Discard") { "Error: Not in a turn." }
                return@run
              }
              val act = data.parseSingleAct()
              when {
                act == null -> {
                  log("Discard") { "Error: Invalid arguments." }
                }
                held == null -> {
                  log("Discard") { "Error: Not holding an act." }
                }
                act in queue -> {
                  log("Discard") { "Error: Act already queued." }
                }
                act !in hand -> {
                  log("Discard") { "Error: Act not in hand." }
                }
                hasPerformedHoldAction -> {
                  log("Discard") { "Error: Hold action already performed this turn." }
                }
                act.type == ActType.ClimaxAct -> {
                  log("Discard") { "Error: Cannot discard a climax act" }
                }
                else -> {
                  discardPile += act
                  internalHand -= act
                  internalHand += held!!
                  hand[hand.indexOf(act)] = held!!
                  held = null
                  holdActionTarget = act
                  log("Discard", summary = { "Successfully discarded '${act}'." }) {
                    formattedHand()
                  }
                }
              }
            }
            InteractiveCommandType.UNQUEUE -> {
              if (!queuing) {
                log("Unqueue") { "Error: Not in a turn." }
                return@run
              }
              if (data.isEmpty()) {
                if (queue.isEmpty()) {
                  log("Unqueue") { "Error: queue is already empty." }
                } else {
                  queue.removeLast()
                }
                return@run
              }
              val act = data.parseSingleAct()
              when (act) {
                null -> {
                  if (data.isNotEmpty() && data[0] == '#') {
                    val index = data.drop(1).toIntOrNull()?.minus(1)
                    when {
                      index == null -> log("Unqueue") { "Error: Invalid arguments." }
                      index !in queue.indices -> log("Unqueue") { "Error: Invalid index." }
                      else -> {
                        queue.removeAt(index)
                        log("Unqueue", summary = { "Successfully unqueued act." }) {
                          formattedStatus()
                        }
                      }
                    }
                  } else {
                    log("Unqueue") { "Error: Invalid arguments." }
                  }
                }
                !in queue -> {
                  log("Unqueue") { "Error: Act not queued." }
                }
                else -> {
                  queue.removeAll { it == act }
                  log("Unqueue", summary = { "Successfully unqueued act." }) { formattedStatus() }
                }
              }
            }
            InteractiveCommandType.CLEAR -> {
              if (!queuing) {
                log("Clear") { "Error: Not in a turn." }
                return@run
              }
              queue.clear()
              cutinQueue.clear()
              log("Clear") { "Cleared act and cutin queue." }
            }
            InteractiveCommandType.CUTIN -> {
              if (!queuing) {
                log("Cutin") { "Error: Not in a turn." }
                return@run
              }
              if (data !in team.actors) {
                log("Cutin") { "Error: Invalid actor." }
                return@run
              }
              val cutin = team.actors[data]!!.cutin
              when {
                cutin == null -> {
                  log("Cutin") { "Error: Actor does not have cutin." }
                }
                cutin in cutinQueue -> {
                  cutinQueue -= cutin
                  log("Cutin", summary = { "Unqueued cutin." }) { formattedStatus() }
                }
                !cutin.actor.isAlive -> {
                  log("Cutin") { "Error: Actor has already exited." }
                }
                cutin.data.cost + cutinQueue.sumOf { it.data.cost } > cutinEnergy -> {
                  log("Cutin") { "Error: Not enough cutin energy." }
                }
                cutinUseCounts.getValue(cutin) >= cutin.data.usageLimit -> {
                  log("Cutin") { "Error: Cutin usage limit exceeded." }
                }
                stage.turn - cutinLastUseTurns.getValue(cutin) <= cutin.currentCooldownValue -> {
                  log("Cutin") { "Error: Cutin is on cooldown." }
                }
                else -> {
                  cutinQueue += cutin
                  log("Cutin", summary = { "Queued cutin." }) { formattedStatus() }
                }
              }
            }
            InteractiveCommandType.CLIMAX -> {
              if (!queuing) {
                log("Climax") { "Error: Not in a turn." }
                return@run
              }
              if (team.cxTurns > 0 || climax) {
                log("Climax") { "Error: Already entered climax." }
              } else if (team.active.none { it.brilliance >= 100 }) {
                log("Climax") { "Error: Climax not ready." }
              } else {
                climax = true
                drawPile += internalHand
                queue.clear()
                hand.clear()
                internalHand.clear()
                drawHand()
                log("Climax", summary = { "Entered climax." }) { formattedHand() }
              }
            }
            InteractiveCommandType.STATUS -> {
              if (!queuing) {
                log("Status") { "Error: Not in a turn." }
                return@run
              }
              log("Status") { formattedStatus() }
            }
            InteractiveCommandType.INFO -> {
              log("Info") {
                hierarchicalString("Info", INDENT) {
                  "Team" {
                    "Climax Turns: ${team.cxTurns}"
                    "Stage Effects" {
                      team.stageEffects
                          .values()
                          .map { (effect, level) -> "[${effect.name}] lv$level" }
                          .sorted()
                          .joinToString("\n")
                    }
                    team.actors.values.forEach { +it.formattedStatus() }
                  }
                  "Enemy" {
                    "Climax Turns: ${enemy.cxTurns}"
                    "Stage Effects" {
                      enemy.stageEffects
                          .values()
                          .map { (effect, level) -> "[${effect.name}] lv$level" }
                          .sorted()
                          .joinToString("\n")
                    }
                    enemy.actors.values.forEach { +it.formattedStatus() }
                  }
                }
              }
            }
            InteractiveCommandType.HISTORY -> {
              log("History") { history.joinToString("\n") { it.raw } }
            }
            InteractiveCommandType.FULL_HISTORY -> {
              log("Full History") { fullHistory.joinToString("\n") }
            }
            InteractiveCommandType.LIST_SAVES -> {
              log("List Saves") { saves.keys.joinToString("\n") }
            }
            InteractiveCommandType.SEED -> {
              try {
                val value = data.toInt()
                // This is to match behavior with the sim ui seed option
                managedRandom.base = Random(Random(value).nextInt())
                log("Seed") { "Updated seed." }
              } catch (e: NumberFormatException) {
                log("Seed") { "Error: Invalid seed." }
              }
            }
            InteractiveCommandType.EXPORT -> {
              var strict = false
              when (data) {
                "strict" -> strict = true
                "simple" -> strict = false
                "" -> {}
                else -> {
                  log("Export") { "Error: Unknown parameters." }
                  return@run
                }
              }
              log("Export") {
                queueHistory
                    .zip(statusHistory)
                    .mapIndexed { index, (queueResult, status) ->
                      val turn = index + 1
                      "Turn $turn:\n${
                                if (strict) {
                                    "${
                                        status.held?.let { held -> "# held ${held.actor.name} ${held.act.type.shortName}\n" } ?: ""
                                    }${
                                        status.discarded?.let { discarded -> "# discarded ${discarded.actor.name} ${discarded.act.type.shortName}\n" } ?: ""
                                    }${
                                        status.actorStatuses.joinToString("") { "assert ${it.name} ${if (it.hp > 0) "alive" else "dead"}\n" }
                                    }${
                                        if (status.climax) status.actorStatuses.joinToString("") { "assert ${it.name} ${if (it.brilliance >= 100) "charged" else "uncharged"}\n" }
                                        else ""
                                    }"
                                } else ""
                            }${
                                if (queueResult.climax) "climax\n" else ""
                            }${
                                queueResult.cutins
                                    .joinToString("") { "${it.actor.name} cutin\n" }
                            }${
                                queueResult.tiles
                                    .filterIsInstance<ActionTile>()
                                    .joinToString("") { "${it.actor.name} ${it.actData.type.shortName}\n" }
                            }"
                    }
                    .joinToString("\n")
                    .trimEnd()
                    .also { lastExport = it }
              }
            }
            InteractiveCommandType.INCREMENTAL -> {
              if (liveMode) {
                log("Incremental") { "Error: Live mode active." }
                return@run
              }
              incremental = !incremental
              log("Incremental") { "Incremental: $incremental." }
            }
            InteractiveCommandType.INVULNERABLE -> {
              if (liveMode) {
                log("Invulnerable") { "Error: Live mode active." }
                return@run
              }
              if (data.isEmpty()) {
                val targetValue = !(team.actors.values.all { it.forceInvulnerable })
                team.actors.values.forEach { it.forceInvulnerable = targetValue }
                log("Invulnerable") { "Team invulnerable: $targetValue." }
              } else {
                val actor = team.actors[data]
                if (actor == null) {
                  log("Invulnerable") { "Error: Invalid actor." }
                } else {
                  actor.forceInvulnerable = !actor.forceInvulnerable
                  log("Invulnerable") {
                    "[${actor.name}] invulnerable: ${actor.forceInvulnerable}."
                  }
                }
              }
            }
            InteractiveCommandType.SET_HP -> {
              val isPercent = data.endsWith("%")
              val args =
                  if (isPercent) {
                    (data.dropLast(1)).parseActorAndInteger()
                  } else {
                    data.parseActorAndInteger()
                  }
              if (args == null) {
                log("Set Hp") { "Error: Invalid arguments." }
              } else {
                val (actor, value) = args
                if (queuing && !actor.isAlive) {
                  log("Set Hp") { "Error: Cannot revive card while queuing." }
                  return@run
                }
                if (queuing && actor.isAlive && value == 0) {
                  log("Set Hp") { "Error: Cannot cause card to exit while queuing." }
                  return@run
                }
                actor.adjustHp(
                    if (isPercent) (value.toDouble() * actor.maxHp / 100).toInt() else value)
                log("Set Hp") { "Adjusted Hp." }
              }
            }
            InteractiveCommandType.SET_BRILLIANCE -> {
              val args = data.parseActorAndInteger()
              if (args == null) {
                log("Set Brilliance") { "Error: Invalid arguments." }
              } else {
                val (actor, value) = args
                actor.adjustBrilliance(value)
                log("Set Brilliance") { "Adjusted Brilliance." }
              }
            }
            InteractiveCommandType.DAMAGE -> {
              val args = data.parseActorAndInteger()
              if (args == null) {
                log("Damage") { "Error: Invalid arguments." }
              } else {
                if (queuing) {
                  log("Damage") { "Error: Cannot damage card while queuing." }
                  return@run
                }
                val (actor, value) = args
                val origInvulnState = actor.forceInvulnerable
                actor.forceInvulnerable = false
                actor.damage(value)
                actor.forceInvulnerable = origInvulnState
                log("Damage") { "Applied damage." }
              }
            }
            InteractiveCommandType.DRAW_PILE -> {
              if (!queuing) {
                log("Draw Pile") { "Error: Not in a turn." }
                return@run
              }
              log("Draw Pile") {
                drawPile
                    .sortByActor()
                    .joinToString("\n") { it.toString() }
                    .takeIf { it.isNotEmpty() }
                    ?: "Empty"
              }
            }
            InteractiveCommandType.SET_HAND -> {
              if (!queuing) {
                log("Set Hand") { "Error: Not in a turn." }
                return@run
              }
              val acts = data.parseActs()
              when {
                queue.isNotEmpty() -> log("Set Hand") { "Error: Queue is not empty." }
                acts == null -> log("Set Hand") { "Error: Invalid arguments." }
                team.active.size == 1 -> log("Set Hand") { "Error: Team is solo." }
                acts.size != 5 -> log("Set Hand") { "Error: Expected 5 acts." }
                acts.toSet().size != 5 -> log("Set Hand") { "Error: Contains duplicates." }
                acts.any { it == held } -> log("Set Hand") { "Error: Included held card." }
                else -> {
                  val climaxActs =
                      if (climax || team.cxTurns > 0) {
                        team.active
                            .filter { it.brilliance >= 100 }
                            .map { BoundAct(it, ActType.ClimaxAct) }
                            .filter {
                              it !in usedClimaxActs ||
                                  it.actor.hasMultipleCA
                            }
                      } else {
                        emptyList()
                      }
                  if (!climaxActs.all { it in acts }) {
                    log("Set Hand", category = LogCategory.WARNING) {
                      "Warning: Not all climax acts included."
                    }
                  }
                  if (acts.any { it.type == ActType.ClimaxAct && it !in climaxActs }) {
                    log("Set Hand", category = LogCategory.WARNING) {
                      "Warning: Includes ineligible climax acts."
                    }
                  }
                  if (acts.any { it in discardPile }) {
                    log("Set Hand", category = LogCategory.WARNING) {
                      "Warning: Includes discarded cards."
                    }
                  }
                  drawPile += hand.filter { it.type != ActType.ClimaxAct }
                  hand.clear()
                  internalHand.clear()
                  hand += acts.sorted() // Note that this is not quicksort
                  internalHand += hand
                  drawPile -= acts
                  discardPile -= acts
                  log("Set Hand") { "Updated hand.\n\n${formattedHand()}" }
                }
              }
            }
            InteractiveCommandType.INTERNAL_HAND -> {
              if (!queuing) {
                log("Internal Hand") { "Error: Not in a turn." }
                return@run
              }
              if (hand.any { it.type == ActType.ClimaxAct }) {
                // There is really no use case for this at the moment, so no reason to support it.
                log("Internal Hand") { "Error: Hand contains climax acts." }
                return@run
              }
              if (hasPerformedHoldAction) {
                log("Internal Hand") { "Error: Already performed hold action." }
                return@run
              }
              log("Internal Hand") {
                hand
                    .sortByActor()
                    .permute()
                    .toSet()
                    .filter { it.toMutableList().apply { qsort() } == hand }
                    .joinToString("\n\n") { it.numbered() }
              }
            }
            InteractiveCommandType.SET_COUNTABLE_BUFF -> {
              val args = data.splitArgs()
              if (args.size != 3) {
                log("Set Countable Buff") { "Error: Expected 3 arguments." }
              }
              val actor = allActors[args[0]]
              val buff = countableBuffsByName[args[1]]
              val count = args[2].toIntOrNull()
              when {
                actor == null -> log("Set Countable Buff") { "Error: Invalid actor." }
                buff == null -> log("Set Countable Buff") { "Error: Invalid buff." }
                count == null -> log("Set Countable Buff") { "Error: Invalid count." }
                count < 0 -> log("Set Countable Buff") { "Error: Negative count." }
                else -> {
                  actor.buffs.addCountable(buff, count - actor.buffs.count(buff))
                  log("Set Countable Buff") { "Updated buff count." }
                }
              }
            }
            InteractiveCommandType.LIVE_MODE -> {
              when {
                liveMode -> log("Live Mode") { "Error: Live mode already enabled." }
                stage.turn > 0 -> log("Live Mode") { "Error: Turn is not 0." }
                else -> {
                  team.actors.values.forEach { it.forceInvulnerable = true }
                  enemy.actors.values.forEach { it.forceInvulnerable = true }
                  incremental = true
                  liveMode = true
                  log("Live Mode") { "Live mode enabled." }
                }
              }
            }
            InteractiveCommandType.LIST_ACTS -> {
              log("List Acts") {
                team.actors.values
                    .flatMap { actor -> actor.acts.map { (type, _) -> BoundAct(actor, type) } }
                    .joinToString("\n") {
                      "[${it.actor.name.replace(" ", "\\ ")} ${it.act.type.shortName}] $it"
                    }
                    .takeIf { it.isNotEmpty() }
                    ?: "Empty"
              }
            }

            // These are handled by the controller
            InteractiveCommandType.SAVE -> {}
            InteractiveCommandType.LOAD -> {}
            InteractiveCommandType.UNDO -> {}
            InteractiveCommandType.REDO -> {}
            InteractiveCommandType.SEEK_BACK -> {}
            InteractiveCommandType.SEEK_FORWARD -> {}
            InteractiveCommandType.FAST_FORWARD -> {}
            InteractiveCommandType.RESTART -> {}
            InteractiveCommandType.EIGHT_BALL -> {}
            InteractiveCommandType.AUTO_QUEUE -> {
              // This is used by the controller to get candidates.
              // The auto_queue command never ends up in final history.
              queueCandidates = findQueueCandidates()
            }
          }
        }

    // Returns a set of all possible full queues as lists of indexes into the hand.
    private fun findQueueCandidates(): Set<List<Int>> {
      return hand
          .flatMapIndexed { i, act ->
            if (act.canQueue()) {
              queue += act
              findQueueCandidates().map { listOf(i) + it }.also { queue.removeLast() }
            } else {
              emptyList()
            }
          }
          .toSet()
          .takeIf { it.isNotEmpty() }
          ?: setOf(emptyList())
    }

    private fun List<BoundAct>.sortByActor() =
        sortedWith(compareBy({ it.actor.dress.id }, { it.actor.name }, { it.type }))

    private fun <T> List<T>.permute(): List<List<T>> =
        when (size) {
          0 -> listOf(emptyList())
          1 -> listOf(this)
          else ->
              this.flatMapIndexed { i: Int, element: T ->
                (subList(0, i) + subList(i + 1, size)).permute().map { it + element }
              }
        }

    override fun onExit(actor: Actor) {
      discardPile.removeAll { it.actor == actor }
      drawPile.removeAll { it.actor == actor }
      if (held?.actor == actor) {
        held = null
      }
    }

    override fun onRevive(actor: Actor) {
      discardPile += BoundAct(actor, ActType.Act1)
      discardPile += BoundAct(actor, ActType.Act2)
      discardPile += BoundAct(actor, ActType.Act3)
    }

    private fun Actor.formattedStatus() =
        hierarchicalString("${dress.name} (${name})", INDENT) {
          "Status" {
            +"Hp: $hp/$maxHp"
            +"Brilliance: $brilliance/100"
          }
          "Stats" {
            mod {
              +"Act Power: $actPower"
              +"Normal Defense: $normalDefense"
              +"Special Defense: $specialDefense"
              +"Agility: $agility"
              +"Dexterity: $dexterity"
              +"Critical: $critical"
              +"Accuracy: $accuracy"
              +"Evasion: $evasion"
            }
          }
          "Buffs" {
            "Continuous" {
              "Positive" { buffs.continuousPositive().map { it.toString() }.sorted().forEach { +it } }
              "Negative" { buffs.continuousNegative().map { it.toString() }.sorted().forEach { +it } }
            }
            "Countable" {
              "Positive" {
                buffs
                    .countablePositive()
                    .filter { (_, v) -> v.isNotEmpty() }
                    .map { (k, v) -> "[$k] x${v.size}" }
                    .sorted()
                    .forEach { +it }
              }
              "Negative" {
                buffs
                    .countableNegative()
                    .filter { (_, v) -> v.isNotEmpty() }
                    .map { (k, v) -> "[$k] x$v" }
                    .sorted()
                    .forEach { +it }
              }
            }
          }
        }

    private fun BoundAct.canQueue() =
        queue.count { it == this } < hand.count { it == this } &&
            queue.sumOf { it.apCost } + apCost <= 6

    private fun BoundCutin.fullInfo() =
        "@(memoir:${actor.memoir?.id})[${actor.name} (${actor.dress.name})]:[${actor.memoir?.name}](Cost: ${data.cost}, Cooldown: ${
                (1 + currentCooldownValue - (stage.turn - cutinLastUseTurns.getValue(this))).coerceAtLeast(0)
            }, Remaining Uses: ${data.usageLimit - cutinUseCounts.getValue(this)}/${data.usageLimit})"

    private fun List<BoundAct>.numbered() =
        mapIndexed { index, act -> "${index + 1}. $act" }.joinToString("\n")

    private fun List<BoundAct>.formattedWithActions() =
        mapIndexed { index, act ->
              "${index + 1}. ${
                if (act.canQueue()) {
                    "[@[queue](command: queue ${index + 1})]"
                } else {
                    "[queue]"
                }
            }${
                if (held == null) {
                    if (!hasPerformedHoldAction && act.type != ActType.ClimaxAct && act !in queue && team.active.size > 1) {
                        "[@[hold](command: hold ${index + 1})]"
                    } else {
                        "[hold]"
                    }
                } else {
                    if (!hasPerformedHoldAction && act.type != ActType.ClimaxAct && act !in queue && team.active.size > 1) {
                        "[@[disc](command: discard ${index + 1})]"
                    } else {
                        "[disc]"
                    }
                }
            } $act"
            }
            .joinToString("\n")

    private fun BoundCutin.canQueue() =
        actor.isAlive &&
            data.cost + cutinQueue.sumOf { it.data.cost } <= cutinEnergy &&
            cutinUseCounts.getValue(this) < data.usageLimit &&
            stage.turn - cutinLastUseTurns.getValue(this) > currentCooldownValue &&
            this !in cutinQueue

    private fun formattedHand() =
        """
Hand:
${hand.formattedWithActions().prependIndent(INDENT)}
${INDENT}Holding: ${held ?: "None"}
${INDENT}${
            if (team.cxTurns == 0 && team.active.any { it.brilliance >= 100 } && !climax) {
                "[@[climax](command: climax)]"
            } else {
                "[climax]"
            }
        }

Cutins (${cutinEnergy - cutinQueue.sumOf { it.data.cost }}/${cutinEnergy} Energy):
${
            (team.actors.values
                .filter { it.isAlive }
                .mapNotNull { it.cutin }
                .joinToString("\n") {
                    "${if (it.canQueue()) "[@[queue](command: cutin ${it.actor.name})]" else "[queue]"} ${it.fullInfo()}"
                }
                .takeIf { it.isNotEmpty() } ?: "Empty").prependIndent(INDENT)
        }
"""
            .trimIndent()

    private fun formattedStatus() =
        """
Act Queue (${queue.sumOf { it.apCost }}/6):
${
            (if (queue.isEmpty()) "Empty" else queue.mapIndexed { i, act -> "${i + 1}. [@[unqueue](command: unqueue #${i + 1})] $act" }
                .joinToString("\n")).prependIndent(INDENT)
        }

Cutin Queue:
${
            (if (cutinQueue.isEmpty()) {
                "Empty"
            } else {
                cutinQueue
                    .joinToString("\n") { "[@[unqueue](command: cutin ${it.actor.name})] $it" }
            }).prependIndent(INDENT)
        }

${formattedHand()}
"""
            .trimIndent()
  }

  private inner class ManagedRandom(var base: Random) : Random() {
    override fun nextBits(bitCount: Int) = base.nextBits(bitCount)
  }

  private data class BoundAct(val actor: Actor, val type: ActType, val isGuest: Boolean = false) :
      Comparable<BoundAct> {
    val act =
        actor.acts[type]
            ?: error("Actor '${actor.name}' does not have an act with type '${type.name}'")
    val apCost
      get() = (act.apCost + actor.mod { apChange }).coerceAtLeast(1)

    val sortPriority
      get() = run {
        var v = apCost
        if (act.type == ActType.ClimaxAct) v += 10
        if (isGuest) v += 100
        v
      }

    override fun compareTo(other: BoundAct): Int {
      return sortPriority.compareTo(other.sortPriority)
    }

    override fun toString() =
        "@(dress:${actor.dress.id})@(act:${act.icon})[${act.type.name}][${apCost}AP${apChangeSymbol}][${actor.name} (${actor.dress.name})][${act.name}]"

    private val apChangeSymbol
      get() =
          when {
            apCost > act.apCost -> "▲"
            apCost < act.apCost -> "▼"
            else -> "·"
          }
  }
}

private data class ParsedCommand(
    val type: InteractiveCommandType,
    val data: String,
    val raw: String
)

enum class InteractiveCommandType(
    val title: String,
    val aliases: List<String> = emptyList(),
    val synopsis: String,
    val description: String,
    val examples: String,
) {
  HELP(
      title = "help",
      aliases = listOf("?", "man"),
      synopsis =
          """
            help
            help name_of_command
        """
              .trimIndent(),
      description =
          """
            Get information regarding a command.
        """
              .trimIndent(),
      examples =
          """
            Provides general help:
                help
            Provides information on the "queue" command:
                help queue
        """
              .trimIndent(),
  ),
  GO(
      title = "go",
      aliases = listOf("g"),
      synopsis =
          """
            go
        """
              .trimIndent(),
      description =
          """
            Start the run or finish the current turn.
        """
              .trimIndent(),
      examples =
          """
            Starts the run or finishes the current turn:
                go
        """
              .trimIndent(),
  ),
  QUEUE(
      title = "queue",
      aliases = listOf("q"),
      synopsis =
          """
            queue name_of_actor act
            queue (name_of_actor act...)...
            queue act_card_number...
        """
              .trimIndent(),
      description =
          """
            Queue act(s).
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the locations of act cards in the hand.
        """
              .trimIndent(),
      examples =
          """
            Queues the act1 of the actor named "A":
                queue A 1
            Queues the act1 and act 2 of the actor named "A" 
            then the climax of the actor named "B", in that order:
                queue A 1 2 B cx
            Queues 2nd card in hand:
                queue 2
            Queues the 1st, 5th, and 3rd cards in hand, in that order:
                queue 1 5 3
        """
              .trimIndent(),
  ),
  AUTO_QUEUE(
      title = "auto_queue",
      aliases = listOf("autoqueue", "aq"),
      synopsis =
          """
            auto_queue
        """
              .trimIndent(),
      description =
          """
            Automatically queue act(s) for the current turn.
        """
              .trimIndent(),
      examples =
          """
            Automatically queues act(s) for the current turn:
                auto_queue
        """
              .trimIndent(),
  ),
  HOLD(
      title = "hold",
      aliases = listOf("h"),
      synopsis =
          """
            hold name_of_actor act
            hold act_card_number
        """
              .trimIndent(),
      description =
          """
            Hold an act card.
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the location of the act card in the hand.
        """
              .trimIndent(),
      examples =
          """
            Holds act1 of the actor named "A":
                hold A 1
            Holds the 2nd card in hand:
                hold 2
        """
              .trimIndent(),
  ),
  DISCARD(
      title = "discard",
      aliases = listOf("d"),
      synopsis =
          """
            discard name_of_actor act
            discard act_card_number
        """
              .trimIndent(),
      description =
          """
            Discard an act card.
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the location of the act card in the hand.
        """
              .trimIndent(),
      examples =
          """
            Discards act1 of the actor named "A":
                discard A 1
            Discards the 2nd card in hand:
                discard 2
        """
              .trimIndent(),
  ),
  UNQUEUE(
      title = "unqueue",
      aliases = listOf("unq"),
      synopsis =
          """
            unqueue name_of_actor act
            unqueue act_card_number...
            unqueue #queue_index...
            unqueue
        """
              .trimIndent(),
      description =
          """
            Unqueue act(s).
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the locations of act cards in the hand.
            If no arguments are given, unqueues the last act in the queue.
        """
              .trimIndent(),
      examples =
          """
            Unqueues the act1 of the actor named "A":
                unqueue A 1
            Unqueues 2nd card in hand:
                unqueue 2
            Unqueues the 1st, 5th, and 3rd cards in hand:
                unqueue 1 5 3
            Unqueues the last act in the queue:
                unqueue
            Unqueues the first act in the queue:
                unqueue #1
        """
              .trimIndent(),
  ),
  CLEAR(
      title = "clear",
      aliases = listOf("clr"),
      synopsis =
          """
            clear
        """
              .trimIndent(),
      description =
          """
            Clear the act and cutin queues.
        """
              .trimIndent(),
      examples =
          """
            Clears the act and cutin queues:
                clear
        """
              .trimIndent(),
  ),
  CUTIN(
      title = "cutin",
      aliases = listOf("c"),
      synopsis =
          """
            cutin name_of_actor
        """
              .trimIndent(),
      description =
          """
            Toggle the cutin of the given actor.
        """
              .trimIndent(),
      examples =
          """
            Toggles the cutin of  "A":
                cutin A
        """
              .trimIndent(),
  ),
  CLIMAX(
      title = "climax",
      aliases = listOf("cx", "ca"),
      synopsis =
          """
            climax
        """
              .trimIndent(),
      description =
          """
            Enter climax. Will also clear the queue.
        """
              .trimIndent(),
      examples =
          """
            Enters climax:
                climax
        """
              .trimIndent(),
  ),
  STATUS(
      title = "status",
      aliases = listOf("s"),
      synopsis =
          """
            status
        """
              .trimIndent(),
      description =
          """
            Display the current queue and hand.
        """
              .trimIndent(),
      examples =
          """
            Displays the current queue and hand:
                status
        """
              .trimIndent(),
  ),
  INFO(
      title = "info",
      aliases = listOf("i"),
      synopsis =
          """
            info
        """
              .trimIndent(),
      description =
          """
            Display actor info, including hp, brilliance, and buffs.
        """
              .trimIndent(),
      examples =
          """
            Displays actor info:
                status
        """
              .trimIndent(),
  ),
  HISTORY(
      title = "history",
      aliases = listOf("hist"),
      synopsis =
          """
            history
        """
              .trimIndent(),
      description =
          """
            List command history.
            This may be overwritten by the "load" or "undo" commands.
        """
              .trimIndent(),
      examples =
          """
            Lists command history.
                history
        """
              .trimIndent(),
  ),
  FULL_HISTORY(
      title = "full_history",
      aliases = listOf("fullhistory", "fullhist"),
      synopsis =
          """
            full_history
        """
              .trimIndent(),
      description =
          """
            Lists the full command history.
        """
              .trimIndent(),
      examples =
          """
            Lists the command history of the full session.
                full_history
        """
              .trimIndent(),
  ),
  SAVE(
      title = "save",
      aliases = listOf("sv"),
      synopsis =
          """
            save name
        """
              .trimIndent(),
      description =
          """
            Save the current sim state under the given name.
        """
              .trimIndent(),
      examples =
          """
            Saves the current sim state under the name "x":
                save x
        """
              .trimIndent(),
  ),
  LOAD(
      title = "load",
      aliases = listOf("ld"),
      synopsis =
          """
            load name
        """
              .trimIndent(),
      description =
          """
            Load the sim state with the given name.
            Loading a sim state will not overwrite any existing saves.
        """
              .trimIndent(),
      examples =
          """
            Loads the sim state named "x":
                load x
        """
              .trimIndent(),
  ),
  LIST_SAVES(
      title = "list_saves",
      aliases = listOf("listsaves", "lsv"),
      synopsis =
          """
            list_saves
        """
              .trimIndent(),
      description =
          """
            List the name of all saves.
        """
              .trimIndent(),
      examples =
          """
            Lists the name of all saves:
                list_saves
        """
              .trimIndent(),
  ),
  UNDO(
      title = "undo",
      aliases = listOf("ud"),
      synopsis =
          """
            undo
        """
              .trimIndent(),
      description =
          """
            Undo the previous command.
            Skips over "save", "load", and "undo" commands.
        """
              .trimIndent(),
      examples =
          """
            Undoes the previous command.
                undo
        """
              .trimIndent(),
  ),
  REDO(
      title = "redo",
      aliases = listOf("rd"),
      synopsis =
          """
            redo
        """
              .trimIndent(),
      description =
          """
            Redo a previously undid command, provided history was not overwritten.
        """
              .trimIndent(),
      examples =
          """
            Redoes a command.
                redo
        """
              .trimIndent(),
  ),
  SEEK_BACK(
      title = "seek_back",
      aliases = listOf("seekback", "seek_backwards", "seekbackwards", "sb"),
      synopsis =
          """
            seek_back
        """
              .trimIndent(),
      description =
          """
            Seek back to start of the turn, or end of the previous turn if already at the start.
        """
              .trimIndent(),
      examples =
          """
            Seeks back to the start of the turn, or end of the previous turn if already at the start.
                seek_back
        """
              .trimIndent(),
  ),
  SEEK_FORWARD(
      title = "seek_forward",
      aliases = listOf("seekforward", "seek_forwards", "seekforwards", "sf"),
      synopsis =
          """
            seek_forward
        """
              .trimIndent(),
      description =
          """
            Seek forward to the end of the turn, or start of the next turn if already at the end.
        """
              .trimIndent(),
      examples =
          """
            Seeks forward to the end of the turn, or start of the next turn if already at the end.
                seek_forward
        """
              .trimIndent(),
  ),
  FAST_FORWARD(
      title = "fast_forward",
      aliases = listOf("fastforward", "ff"),
      synopsis =
          """
            fast_forward
        """
              .trimIndent(),
      description =
          """
            Repeatedly redo commands until no more commands can be redone.
        """
              .trimIndent(),
      examples =
          """
            Repeadetly redoes commands until no more commands can be redone.
                fast_forward
        """
              .trimIndent(),
  ),
  SEED(
      title = "seed",
      aliases = listOf("sd"),
      synopsis =
          """
            seed value
            seed
        """
              .trimIndent(),
      description =
          """
            Set the rng seed to the given value.
        """
              .trimIndent(),
      examples =
          """
            Sets the seed to 123.
                seed 123
            Randomizes the seed.
                seed
        """
              .trimIndent(),
  ),
  EXPORT(
      title = "export",
      aliases = listOf("exp"),
      synopsis =
          """
            export
        """
              .trimIndent(),
      description =
          """
            Export the current run as a simple strategy.
            Note that the current turn is not recorded until using 'go'.
        """
              .trimIndent(),
      examples =
          """
            Exports the current run as a simple strategy.
                export
        """
              .trimIndent(),
  ),
  INCREMENTAL(
      title = "incremental",
      aliases = listOf("increment", "incr"),
      synopsis =
          """
            incremental
        """
              .trimIndent(),
      description =
          """
            Toggle incremental.
            If incremental is enabled, a pause will happen after every act.
        """
              .trimIndent(),
      examples =
          """
            Toggles incremental.
                incremental
        """
              .trimIndent(),
  ),
  INVULNERABLE(
      title = "invulnerable",
      aliases = listOf("invuln", "invinc", "inv"),
      synopsis =
          """
            invulnerable
            invulnerable name_of_actor
        """
              .trimIndent(),
      description =
          """
            Toggle invulnerability, preventing damage from being taken under normal circumstances.
        """
              .trimIndent(),
      examples =
          """
            Toggles invulnerability for the entire team.
                invulnerable
            Toggles invulnerability for the actor named "A".
                invulnerable A
        """
              .trimIndent(),
  ),
  SET_HP(
      title = "set_hp",
      aliases = listOf("sethp"),
      synopsis =
          """
            set_hp name_of_actor value
        """
              .trimIndent(),
      description =
          """
            Set actor hp.
            Bypasses fortitude and similar mechanics.
        """
              .trimIndent(),
      examples =
          """
            Sets the hp of the actor named "A" to 1.
                set_hp A 1
            Sets the hp of the actor named "A" to 50%.
                set_hp A 50%
            Causes actor named "A" to exit.
                set_hp A 0
        """
              .trimIndent(),
  ),
  SET_BRILLIANCE(
      title = "set_brilliance",
      aliases = listOf("setbrilliance", "setkira", "setbrill"),
      synopsis =
          """
            set_brilliance name_of_actor value
        """
              .trimIndent(),
      description =
          """
            Set actor brilliance.
            Bypasses fortitude and similar mechanics.
        """
              .trimIndent(),
      examples =
          """
            Sets the brilliance of the actor named "A" to 100.
                set_brilliance A 100
            Sets the brilliance of the actor named "A" to 0.
                set_brilliance A 0
        """
              .trimIndent(),
  ),
  DAMAGE(
      title = "damage",
      aliases = listOf("dmg"),
      synopsis =
          """
            damage name_of_actor value
        """
              .trimIndent(),
      description =
          """
            Damage an actor.
            Triggers fortitude and similar mechanics.
            Bypasses invulnerability as well as barriers, evasion, and similar effects.
        """
              .trimIndent(),
      examples =
          """
            Damages the actor named "A" by 1 Hp.
                damage A 1
        """
              .trimIndent(),
  ),
  DRAW_PILE(
      title = "draw_pile",
      aliases = listOf("drawpile", "dp"),
      synopsis =
          """
            draw_pile
        """
              .trimIndent(),
      description =
          """
            View draw pile.
        """
              .trimIndent(),
      examples =
          """
            Displays draw pile.
                draw_pile
        """
              .trimIndent(),
  ),
  SET_HAND(
      title = "set_hand",
      aliases = listOf("sethand", "seth"),
      synopsis =
          """
            set_hand (name_of_actor act...)...
        """
              .trimIndent(),
      description =
          """
            Set hand to given value.
        """
              .trimIndent(),
      examples =
          """
            Sets the hand to the act1, act2, and act3 of the actor named "A",
            and the act2 and climax of the actor named "B".
                set_hand A 1 3 4 B 2 cx
        """
              .trimIndent(),
  ),
  INTERNAL_HAND(
      title = "internal_hand",
      aliases = listOf("internalhand", "inth", "ihand"),
      synopsis =
          """
            internal_hand
        """
              .trimIndent(),
      description =
          """
            View possible internal hands.
        """
              .trimIndent(),
      examples =
          """
            Displays possible internal hands.
                internal_hand
        """
              .trimIndent(),
  ),
  SET_COUNTABLE_BUFF(
      title = "set_countable_buff",
      aliases = listOf("set_countable", "setcountable"),
      synopsis =
          """
            set_countable_buff name_of_actor buff count
        """
              .trimIndent(),
      description =
          """
            Set the count of a countable buff for a particular actor to the given count.
        """
              .trimIndent(),
      examples =
          """
            Sets the number of pride stacks on the boss to 3.
                set_countable_buff boss price 3
        """
              .trimIndent(),
  ),
  LIVE_MODE(
      title = "live_mode",
      aliases = listOf("live"),
      synopsis =
          """
            live_mode
        """
              .trimIndent(),
      description =
          """
            Enable live mode. Only allowed before turn 1.
            Forces all incremental to be on and all actors to be invulnerable.
            Enables playback exports.
        """
              .trimIndent(),
      examples =
          """
            Enables live mode.
                live_mode
        """
              .trimIndent(),
  ),
  LIST_ACTS(
      title = "list_acts",
      aliases = listOf("lsact", "acts"),
      synopsis =
          """
            list_acts
        """
              .trimIndent(),
      description =
          """
            List all acts in the team.
        """
              .trimIndent(),
      examples =
          """
            Lists all acts.
                acts
        """
              .trimIndent(),
  ),
  RESTART(
      title = "restart",
      aliases = listOf("reset", "rewind", "rw"),
      synopsis =
          """
            restart
        """
              .trimIndent(),
      description =
          """
            Restart the simulation.
        """
              .trimIndent(),
      examples =
          """
            Restarts the simulation.
                restart
        """
              .trimIndent(),
  ),
  EIGHT_BALL(
      title = "eight_ball",
      aliases = listOf("8ball", "magic_8_ball"),
      synopsis =
          """
            eight_ball question
        """
              .trimIndent(),
      description =
          """
            Ask the Magic 8-Ball a question.
        """
              .trimIndent(),
      examples =
          """
            Asks the Magic 8-Ball whether it will rain tomorrow.
                eight_ball Will it rain tomorrow?
        """
              .trimIndent(),
  ),
  ;

  val helpBody =
      listOfNotNull(
              "Aliases:\n${aliases.joinToString(", ").prependIndent(INDENT)}".takeIf {
                aliases.isNotEmpty()
              },
              "Synopsis:\n${synopsis.prependIndent(INDENT)}",
              "Description:\n${description.prependIndent(INDENT)}",
              "Examples:\n${examples.prependIndent(INDENT)}")
          .joinToString("\n\n")
}

val interactiveCommands = buildMap {
  InteractiveCommandType.values()
      .sortedBy { it.title }
      .forEach { command ->
        this[command.title] = command
        command.aliases.forEach { alias -> this[alias] = command }
      }
}

private enum class EightBallAnswerType {
  AFFIRMATIVE,
  MIXED,
  NEGATIVE,
}

private enum class EightBallAnswer(val message: String, val answerType: EightBallAnswerType) {
  CERTAIN("It is certain.", EightBallAnswerType.AFFIRMATIVE),
  DECIDEDLY("It is decidedly so.", EightBallAnswerType.AFFIRMATIVE),
  DOUBTLESSLY("Without a doubt.", EightBallAnswerType.AFFIRMATIVE),
  DEFINITELY("Yes definitely.", EightBallAnswerType.AFFIRMATIVE),
  RELIABLY("You may rely on it.", EightBallAnswerType.AFFIRMATIVE),
  SEE_IT("As I see it, yes.", EightBallAnswerType.AFFIRMATIVE),
  LIKELY("Most likely.", EightBallAnswerType.AFFIRMATIVE),
  OUTLOOK("Outlook good.", EightBallAnswerType.AFFIRMATIVE),
  YES("Yes.", EightBallAnswerType.AFFIRMATIVE),
  SIGNS("Signs point to yes.", EightBallAnswerType.AFFIRMATIVE),
  HAZY("Reply hazy, try again.", EightBallAnswerType.MIXED),
  AGAIN("Ask again later.", EightBallAnswerType.MIXED),
  LATER("Better not tell you now.", EightBallAnswerType.MIXED),
  CANNOT_PREDICT("Cannot predict now.", EightBallAnswerType.MIXED),
  CONCENTRATE("Concentrate and ask again.", EightBallAnswerType.MIXED),
  DONT("Don't count on it.", EightBallAnswerType.NEGATIVE),
  REPLY("My reply is no.", EightBallAnswerType.NEGATIVE),
  SOURCES("My sources say no.", EightBallAnswerType.NEGATIVE),
  BAD_OUTLOOK("Outlook not so good.", EightBallAnswerType.NEGATIVE),
  DOUBTFUL("Very doubtful.", EightBallAnswerType.NEGATIVE)
}
