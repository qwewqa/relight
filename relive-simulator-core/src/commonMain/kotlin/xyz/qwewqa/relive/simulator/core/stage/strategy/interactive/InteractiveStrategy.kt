package xyz.qwewqa.relive.simulator.core.stage.strategy.interactive

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.countableBuffsByName
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.*
import xyz.qwewqa.relive.simulator.core.stage.strategy.complete.qsort
import xyz.qwewqa.relive.simulator.core.stage.team.Team
import kotlin.random.Random

private const val INDENT = "  "

class InteractiveSimulationController(val maxTurns: Int, val seed: Int, loadout: StageLoadout) :
    CoroutineScope by CoroutineScope(Dispatchers.Default) {
    private val mutex = Mutex()

    private var strategy = InteractiveStrategy()
    private val loadout = loadout.copy(player = loadout.player.copy(strategy = ::strategy))
    private val channel get() = strategy.channel

    private var stage = newStage()

    private val history = mutableListOf<String>()
    private val fullHistory = mutableListOf<String>()
    private val saves = mutableMapOf<String, List<String>>()

    private var runningJob: Job? = null

    suspend fun getLog() = mutex.withLock {
        // Ensures that we only obtain the log when control is handed over to the strategy.
        // The strategy just ignores this, but this function will suspend until the strategy is ready.
        channel.send(null)
        stage.logger.getFormatted()
    }

    suspend fun sendCommand(text: String) = mutex.withLock {
        val command = parseCommand(text) ?: return
        fullHistory += command.raw
        when (command.type) {
            InteractiveStrategyCommand.SAVE -> {
                saves[command.data] = history.toList()
                stage.log("Command", "Save", category = LogCategory.COMMAND) { "Saved state as '${command.data}'." }
            }
            InteractiveStrategyCommand.LOAD -> {
                val save = saves[command.data]
                if (save == null) {
                    stage.log("Command", "Load", category = LogCategory.COMMAND) { "No save state with name '${command.data}' found." }
                } else {
                    loadSave(save)
                    stage.log("Command", "Load", category = LogCategory.COMMAND) { "Loaded save state with name '${command.data}'." }
                }
            }
            InteractiveStrategyCommand.UNDO -> {
                if (history.isEmpty()) {
                    stage.log("Command", "Undo", category = LogCategory.COMMAND) { "Error: History is empty." }
                } else {
                    loadSave(history.dropLast(1))
                    stage.log("Command", "Undo", category = LogCategory.COMMAND) { "Successfully undid command." }
                }
            }
            else -> {
                history += command.raw
                channel.send(command)
            }
        }
    }

    private fun newStage() = this.loadout.create(
        random = Random(Random(seed).nextInt()),
        configuration = StageConfiguration(logging = true),
    )

    private fun resetStage() {
        runningJob?.cancel()
        strategy = InteractiveStrategy()
        stage = newStage()
        runningJob = launch {
            stage.play(maxTurns)
        }
    }

    private suspend fun loadSave(lines: List<String>) {
        resetStage()
        history.clear()
        history += lines
        lines.forEach { line ->
            parseCommand(line)?.let { command -> channel.send(command) }
        }

        // This is necessary because if lines is empty, a race condition might occur (such as with logging)
        channel.send(null)
    }

    private fun parseCommand(text: String): InteractiveStrategyCommandInvocation? {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) {
            stage.log("Command") { "Error: Empty command. Use 'help' for information." }
            return null
        }
        val strings = trimmed.split("\\s+".toRegex(), 2)
        val title = strings[0]
        val data = if (strings.size == 1) "" else strings[1]
        val command = interactiveCommands[title]
        if (command == null) {
            stage.log("Command", category = LogCategory.COMMAND) { "Error: Unknown command." }
            return null
        }
        return InteractiveStrategyCommandInvocation(command, data, trimmed)
    }

    fun play() {
        runningJob = launch {
            stage.play(maxTurns)
        }
    }

    fun end() {
        cancel()
        channel.close()
    }

    private inner class InteractiveStrategy : Strategy {
        val channel = Channel<InteractiveStrategyCommandInvocation?>()

        private var queuing = false  // true in nextQueue, false otherwise

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
        private var held: BoundAct? = null
        private var hasPerformedHoldAction = true

        private var incremental = false

        private val queueHistory = mutableListOf<QueueResult>()

        private inline fun log(value: LogContentsBuilder.() -> String) {
            stage.log("Command", category = LogCategory.COMMAND) {
                value()
            }
        }

        private inline fun log(
            vararg tags: String,
            category: LogCategory = LogCategory.COMMAND,
            value: LogContentsBuilder.() -> String
        ) {
            stage.log("Command", *tags, category = category) {
                value()
            }
        }

        override suspend fun initialize(stage: Stage, team: Team, enemy: Team) {
            this.stage = stage
            this.team = team
            this.enemy = enemy
            enemy.actors.values.forEach { actor ->
                allActors[actor.name] = actor
            }
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
                val command = channel.receive()
                processCommand(command)
                if (command?.type == InteractiveStrategyCommand.GO) break
            }
        }

        override suspend fun finalize(stage: Stage, team: Team, enemy: Team) {
            queuing = false
            while (true) {
                val command = channel.receive()
                processCommand(command)
                if (command?.type == InteractiveStrategyCommand.GO) {
                    log { "Already ended." }
                }
            }
        }

        override suspend fun afterAct(stage: Stage, team: Team, enemy: Team) {
            queuing = false
            if (!incremental) return
            while (true) {
                val command = channel.receive()
                processCommand(command)
                if (command?.type == InteractiveStrategyCommand.GO) break
            }
        }

        private fun drawCard(): BoundAct {
            if (drawPile.isEmpty()) {
                drawPile += discardPile.shuffled(stage.random)
                discardPile.clear()
            }
            return drawPile.removeFirst()
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
                hand += team.active
                    .filter { it.brilliance >= 100 }
                    .map { BoundAct(it, ActType.ClimaxAct) }
                    .filter { it !in usedClimaxActs }
            }
            while (hand.size < 5) hand += drawCard()
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
            get() = if (cutinUseCounts.getValue(this) > 0) {
                data.cooldown
            } else {
                data.startCooldown
            }

        override suspend fun nextQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
            queuing = true
            if (team.cxTurns == 0) {
                usedClimaxActs.clear()
            }
            hasPerformedHoldAction = false
            climax = false
            queue.clear()
            cutinQueue.clear()
            queueSize = 0
            drawHand()
            cutinEnergy = stage.turn + 2
            stage.log("Strategy") {
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
                    
Hand:
${hand.numbered().prependIndent(INDENT)}

Cutins (${cutinEnergy} Energy):
${
                    (team.actors.values
                        .filter { it.isAlive }
                        .mapNotNull { it.cutin }
                        .joinToString("\n") { it.formatted() }
                        .takeIf { it.isNotEmpty() } ?: "Empty").prependIndent(INDENT)
                }
                """.trimIndent()
            }
            while (true) {
                val command = channel.receive()
                processCommand(command)
                if (command?.type == InteractiveStrategyCommand.GO) break
            }
            discardHand()
            cutinQueue.forEach { cutin ->
                cutinLastUseTurns[cutin] = stage.turn
                cutinUseCounts[cutin] = cutinUseCounts.getValue(cutin) + 1
            }
            queue.forEach {
                if (it.act.type == ActType.ClimaxAct) {
                    usedClimaxActs += it
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
            ).also { queueHistory += it }
        }

        private fun String.parseSingleAct(): BoundAct? {
            val args = split("\\s+".toRegex())
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
            val args = split("\\s+".toRegex())
            return if (args.all { it.toIntOrNull()?.minus(1) in hand.indices }) {
                args.map { hand[it.toInt() - 1] }
            } else {
                parseActs(args)
            }
        }

        private fun String.parseActs() = parseActs(split("\\s+".toRegex()))

        private fun parseActs(args: List<String>): List<BoundAct>? {
            var activeActor: Actor? = null
            val result = mutableListOf<BoundAct>()
            args.forEach { arg ->
                when (arg) {
                    in team.actors -> activeActor = team.actors[arg]!!
                    in actNameMapping -> activeActor?.let {
                        result += BoundAct(it, actNameMapping[arg]!!)
                    } ?: return null
                    else -> return null
                }
            }
            return result
        }

        private fun String.parseActorAndInteger(): Pair<Actor, Int>? {
            val args = split("\\s+".toRegex())
            if (args.size != 2) return null
            val actor = allActors[args[0]] ?: return null
            val value = args[1].toIntOrNull() ?: return null
            return actor to value
        }

        private fun processCommand(command: InteractiveStrategyCommandInvocation?) = command?.run {
            log(category = LogCategory.USER) { raw }
            when (type) {
                InteractiveStrategyCommand.HELP -> {
                    if (data.isNotEmpty()) {
                        if (data == "all") {
                            log("Help") {
                                InteractiveStrategyCommand.values().sortedBy { it.title }.joinToString("\n\n") {
                                    "${it.title}:\n\n${it.helpBody.prependIndent(INDENT)}"
                                }
                            }
                        } else {
                            val targetCommand = interactiveCommands[data]
                            if (targetCommand == null) {
                                log("Help") { "Error: Unknown command." }
                            } else {
                                log("Help") { targetCommand.helpText }
                            }
                        }
                    } else {
                        log("Help") {
                            """
Use 'help all' to list information on all commands.
Use 'help <name_of_command>' to get information on a particular command.

Available Commands:
${(InteractiveStrategyCommand.values().sortedBy { it.title }.joinToString("\n") { it.title }).prependIndent(INDENT)}
""".trimIndent()
                        }
                    }
                }
                InteractiveStrategyCommand.GO -> {}
                InteractiveStrategyCommand.QUEUE -> {
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
                            log("Queue") { "Successfully queued act(s)." }
                        } catch (e: RuntimeException) {
                            queue.clear()
                            queue += originalQueue
                            throw e
                        }
                    } catch (e: RuntimeException) {
                        log("Queue") { "Error: ${e.message}" }
                    }
                }
                InteractiveStrategyCommand.HOLD -> {
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
                            val newAct = drawCard()
                            internalHand -= act
                            internalHand += newAct
                            hand[hand.indexOf(act)] = newAct
                            hasPerformedHoldAction = true
                            log("Hold") {
                                "Successfully held '${act}'.\n\nHand:\n${
                                    hand.numbered().prependIndent(INDENT)
                                }\n${INDENT}Holding: $held"
                            }
                        }
                    }
                }
                InteractiveStrategyCommand.DISCARD -> {
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
                            hasPerformedHoldAction = true
                            log("Discard") {
                                "Successfully discarded '${act}'.\n\nHand:\n${
                                    hand.numbered().prependIndent(INDENT)
                                }\n${INDENT}Holding: None"
                            }
                        }
                    }
                }
                InteractiveStrategyCommand.UNQUEUE -> {
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
                            log("Unqueue") { "Error: Invalid arguments." }
                        }
                        !in queue -> {
                            log("Unqueue") { "Error: Act not queued." }
                        }
                        else -> {
                            queue.removeAll { it == act }
                            log("Unqueue") { "Successfully unqueued act." }
                        }
                    }
                }
                InteractiveStrategyCommand.CLEAR -> {
                    if (!queuing) {
                        log("Clear") { "Error: Not in a turn." }
                        return@run
                    }
                    queue.clear()
                    cutinQueue.clear()
                    log("Clear") { "Cleared act and cutin queue." }
                }
                InteractiveStrategyCommand.CUTIN -> {
                    if (!queuing) {
                        log("Cutin") { "Error: Not in a turn." }
                        return@run
                    }
                    if (data !in team.actors) {
                        log("Cutin") { "Error: Invalid actor." }
                        return@run
                    }
                    val cutin = team.actors[data]!!.cutin
                    if (cutin == null) {
                        log("Cutin") { "Error: Actor does not have cutin." }
                    } else if (!cutin.actor.isAlive) {
                        log("Cutin") { "Error: Actor has already exited." }
                    } else if (cutin.data.cost + cutinQueue.sumOf { it.data.cost } > cutinEnergy) {
                        log("Cutin") { "Error: Not enough cutin energy." }
                    } else if (cutinUseCounts.getValue(cutin) >= cutin.data.usageLimit) {
                        log("Cutin") { "Error: Cutin usage limit exceeded." }
                    } else if (stage.turn - cutinLastUseTurns.getValue(cutin) <= cutin.currentCooldownValue) {
                        log("Cutin") { "Error: Cutin is on cooldown." }
                    } else {
                        if (cutin in cutinQueue) {
                            cutinQueue -= cutin
                            log("Cutin") { "Unqueued cutin" }
                        } else {
                            cutinQueue += cutin
                            log("Cutin") { "Queued cutin" }
                        }
                    }
                }
                InteractiveStrategyCommand.CLIMAX -> {
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
                        hand.clear()
                        internalHand.clear()
                        drawHand()
                        log("Climax") {
                            "Entered climax.\n\nHand:\n${
                                hand.numbered().prependIndent(INDENT)
                            }\n${INDENT}Holding: ${held ?: "None"}"
                        }
                    }
                }
                InteractiveStrategyCommand.STATUS -> {
                    if (!queuing) {
                        log("Status") { "Error: Not in a turn." }
                        return@run
                    }
                    log("Status") {
                        """
Act Queue:
${(if (queue.isEmpty()) "Empty" else queue.joinToString("\n")).prependIndent(INDENT)}

Cutin Queue:
${(if (cutinQueue.isEmpty()) "Empty" else cutinQueue.joinToString("\n")).prependIndent(INDENT)}

Hand:
${hand.numbered().prependIndent(INDENT)}
${INDENT}Holding: ${held ?: "None"}

Cutins (${cutinEnergy} Energy):
${
                            (team.actors.values
                                .filter { it.isAlive }
                                .mapNotNull { it.cutin }
                                .joinToString("\n") { it.formatted() }
                                .takeIf { it.isNotEmpty() } ?: "Empty").prependIndent(INDENT)
                        }
""".trimIndent()
                    }
                }
                InteractiveStrategyCommand.INFO -> {
                    log("Info") {
                        hierarchicalString("Info", INDENT) {
                            "Team" {
                                "Climax Turns: ${team.cxTurns}"
                                "Stage Effects" {
                                    team.stageEffects.values()
                                        .map { (effect, level) -> "[${effect.name}] lv$level" }
                                        .sorted()
                                        .joinToString("\n")
                                }
                                team.actors.values.forEach {
                                    +it.formattedStatus()
                                }
                            }
                            "Enemy" {
                                "Climax Turns: ${enemy.cxTurns}"
                                "Stage Effects" {
                                    enemy.stageEffects.values()
                                        .map { (effect, level) -> "[${effect.name}] lv$level" }
                                        .sorted()
                                        .joinToString("\n")
                                }
                                enemy.actors.values.forEach {
                                    +it.formattedStatus()
                                }
                            }
                        }
                    }
                }
                InteractiveStrategyCommand.HISTORY -> {
                    log("History") { history.joinToString("\n") }
                }
                InteractiveStrategyCommand.FULL_HISTORY -> {
                    log("Full History") { fullHistory.joinToString("\n") }
                }

                // These are handled by the controller
                InteractiveStrategyCommand.SAVE -> {}
                InteractiveStrategyCommand.LOAD -> {}
                InteractiveStrategyCommand.UNDO -> {}

                InteractiveStrategyCommand.LIST_SAVES -> {
                    log("List Saves") { saves.keys.joinToString("\n") }
                }
                InteractiveStrategyCommand.SEED -> {
                    try {
                        val value = data.toInt()
                        // This is to match behavior with the sim ui seed option
                        stage.random = Random(Random(value).nextInt())
                        log("Seed") { "Updated seed." }
                    } catch (e: NumberFormatException) {
                        log("Seed") { "Error: Invalid seed." }
                    }
                }
                InteractiveStrategyCommand.EXPORT -> {
                    log("Export") {
                        queueHistory.mapIndexed { index, queueResult ->
                            val turn = index + 1
                            "Turn $turn:\n${
                                if (queueResult.climax) "climax\n" else ""
                            }${
                                queueResult.cutins
                                    .joinToString("") { "${it.actor.name} cutin\n" }
                            }${
                                queueResult.tiles
                                    .filterIsInstance<ActionTile>()
                                    .joinToString("") { "${it.actor.name} ${it.actData.type.shortName}\n" }
                            }"
                        }.joinToString("\n").trimEnd()
                    }
                }
                InteractiveStrategyCommand.INCREMENTAL -> {
                    if (liveMode) {
                        log("Incremental") { "Error: Live mode active." }
                        return@run
                    }
                    incremental = !incremental
                    log("Incremental") { "Incremental: $incremental." }
                }
                InteractiveStrategyCommand.INVULNERABLE -> {
                    if (liveMode) {
                        log("Invulnerable") { "Error: Live mode active." }
                        return@run
                    }
                    if (data.isEmpty()) {
                        val targetValue = !(team.actors.values.all { it.forceInvulnerable })
                        team.actors.values.forEach {
                            it.forceInvulnerable = targetValue
                        }
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
                InteractiveStrategyCommand.SET_HP -> {
                    val isPercent = data.endsWith("%")
                    val args = if (isPercent) {
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
                        actor.adjustHp(if (isPercent) (value.toLong() * actor.maxHp / 100).toInt() else value)
                        log("Set Hp") { "Adjusted Hp." }
                    }
                }
                InteractiveStrategyCommand.SET_BRILLIANCE -> {
                    val args = data.parseActorAndInteger()
                    if (args == null) {
                        log("Set Brilliance") { "Error: Invalid arguments." }
                    } else {
                        val (actor, value) = args
                        actor.adjustBrilliance(value)
                        log("Set Brilliance") { "Adjusted Brilliance." }
                    }
                }
                InteractiveStrategyCommand.DAMAGE -> {
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
                InteractiveStrategyCommand.DRAW_PILE -> {
                    if (!queuing) {
                        log("Draw Pile") { "Error: Not in a turn." }
                        return@run
                    }
                    log("Draw Pile") {
                        drawPile
                            .sortByActor()
                            .joinToString("\n") {
                                it.toString()
                            }
                            .takeIf { it.isNotEmpty() } ?: "Empty"
                    }
                }
                InteractiveStrategyCommand.SET_HAND -> {
                    if (!queuing) {
                        log("Set Hand") { "Error: Not in a turn." }
                        return@run
                    }
                    val acts = data.parseActs()
                    when {
                        acts == null -> log("Set Hand") { "Error: Invalid arguments." }
                        team.active.size == 1 -> log("Set Hand") { "Error: Team is solo." }
                        acts.size != 5 -> log("Set Hand") { "Error: Expected 5 acts." }
                        acts.toSet().size != 5 -> log("Set Hand") { "Error: Contains duplicates." }
                        acts.any { it == held } -> log("Set Hand") { "Error: Included held card." }
                        else -> {
                            val climaxActs = if (climax || team.cxTurns > 0) {
                                team.active
                                    .filter { it.brilliance >= 100 }
                                    .map { BoundAct(it, ActType.ClimaxAct) }
                                    .filter { it !in usedClimaxActs }
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
                            log("Set Hand") {
                                "Updated hand.\n\nHand:\n${
                                    hand.numbered().prependIndent(INDENT)
                                }\n${INDENT}Holding: ${held ?: "None"}"
                            }
                        }
                    }
                }
                InteractiveStrategyCommand.INTERNAL_HAND -> {
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
                        hand.sortByActor().permute().toSet().filter { it.toMutableList().apply { qsort() } == hand }
                            .joinToString("\n\n") {
                                it.numbered()
                            }
                    }
                }
                InteractiveStrategyCommand.SET_COUNTABLE_BUFF -> {
                    val args = data.split("\\s+".toRegex())
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
                InteractiveStrategyCommand.LIVE_MODE -> {
                    when {
                        liveMode -> log("Live Mode") { "Error: Live mode already enabled." }
                        stage.turn > 0 -> log("Live Mode") { "Error: Turn is not 0." }
                        else -> {
                            team.actors.values.forEach {
                                it.forceInvulnerable = true
                            }
                            enemy.actors.values.forEach {
                                it.forceInvulnerable = true
                            }
                            incremental = true
                            liveMode = true
                            log("Live Mode") { "Live mode enabled." }
                        }
                    }
                }
            }
        }

        private fun List<BoundAct>.sortByActor() =
            sortedWith(compareBy({ it.actor.dress.id }, { it.actor.name }, { it.type }))

        private fun <T> List<T>.permute(): List<List<T>> = when (size) {
            0 -> listOf(emptyList())
            1 -> listOf(this)
            else -> this.flatMapIndexed { i: Int, element: T ->
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

        private fun Actor.formattedStatus() = hierarchicalString("${dress.name} (${name})", INDENT) {
            "Status" {
                +"Hp: $hp/$maxHp"
                +"Brilliance: $brilliance/100"
            }
            "Stats" {
                +"Act Power: $actPower"
                +"Normal Defense: $normalDefense"
                +"Special Defense: $specialDefense"
                +"Agility: $agility"
                +"Dexterity: $dexterity"
                +"Critical: $critical"
                +"Accuracy: $accuracy"
                +"Evasion: $evasion"
            }
            "Buffs" {
                "Timed" {
                    "Positive" {
                        buffs.timedPositive()
                            .map { it.toString() }
                            .sorted()
                            .forEach { +it }
                    }
                    "Negative" {
                        buffs.timedNegative()
                            .map { it.toString() }
                            .sorted()
                            .forEach { +it }
                    }
                }
                "Countable" {
                    "Positive" {
                        buffs.countablePositive()
                            .filter { (_, v) -> v > 0 }
                            .map { (k, v) -> "[$k] x$v" }
                            .sorted()
                            .forEach { +it }
                    }
                    "Negative" {
                        buffs.countableNegative()
                            .filter { (_, v) -> v > 0 }
                            .map { (k, v) -> "[$k] x$v" }
                            .sorted()
                            .forEach { +it }
                    }
                }
            }
        }

        private fun BoundCutin.formatted() =
            "@(memoir:${actor.memoir?.id})[${actor.dress.name} (${actor.name})]:[${actor.memoir?.name}](Cost: ${data.cost}, Cooldown: ${
                (1 + currentCooldownValue - (stage.turn - cutinLastUseTurns.getValue(this))).coerceAtLeast(0)
            }, Remaining Uses: ${data.usageLimit - cutinUseCounts.getValue(this)}/${data.usageLimit})"

    }

    private fun List<BoundAct>.numbered() = mapIndexed { index, act -> "${index + 1}. $act" }.joinToString("\n")

    private data class BoundAct(val actor: Actor, val type: ActType) : Comparable<BoundAct> {
        val act = actor.acts[type] ?: error("Actor '${actor.name}' does not have an act with type '${type.name}'")
        val apCost get() = (act.apCost + actor.apChange).coerceAtLeast(1)

        val sortPriority = run {
            var v = act.apCost
            if (act.type == ActType.ClimaxAct) v += 10
            v
        }

        override fun compareTo(other: BoundAct): Int {
            return sortPriority.compareTo(other.sortPriority)
        }

        override fun toString() =
            "@(dress:${actor.dress.id})@(act:${act.icon})[${actor.dress.name} (${actor.name})][${act.name}](${act.type.name} / ${apCost}AP)"
    }
}


data class InteractiveStrategyCommandInvocation(
    val type: InteractiveStrategyCommand,
    val data: String,
    val raw: String
)


enum class InteractiveStrategyCommand(
    val title: String,
    val aliases: List<String> = emptyList(),
    val synopsis: String,
    val description: String,
    val examples: String,
) {
    HELP(
        title = "help",
        aliases = listOf("?", "man"),
        synopsis = """
            help
            help name_of_command
        """.trimIndent(),
        description = """
            Get information regarding a command.
        """.trimIndent(),
        examples = """
            Provides general help:
                help
            Provides information on the "queue" command:
                help queue
        """.trimIndent(),
    ),
    GO(
        title = "go",
        aliases = listOf("g"),
        synopsis = """
            go
        """.trimIndent(),
        description = """
            Start the run or finish the current turn.
        """.trimIndent(),
        examples = """
            Starts the run or finishes the current turn:
                go
        """.trimIndent(),
    ),
    QUEUE(
        title = "queue",
        aliases = listOf("q"),
        synopsis = """
            queue name_of_actor act
            queue (name_of_actor act...)...
            queue act_card_number...
        """.trimIndent(),
        description = """
            Queue act(s).
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the locations of act cards in the hand.
        """.trimIndent(),
        examples = """
            Queues the act1 of the actor named "A":
                queue A 1
            Queues the act1 and act 2 of the actor named "A" 
            then the climax of the actor named "B", in that order:
                queue A 1 2 B cx
            Queues 2nd card in hand:
                queue 2
            Queues the 1st, 5th, and 3rd cards in hand, in that order:
                queue 1 5 3
        """.trimIndent(),
    ),
    HOLD(
        title = "hold",
        aliases = listOf("h"),
        synopsis = """
            hold name_of_actor act
            hold act_card_number
        """.trimIndent(),
        description = """
            Hold an act card.
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the location of the act card in the hand.
        """.trimIndent(),
        examples = """
            Holds act1 of the actor named "A":
                hold A 1
            Holds the 2nd card in hand:
                hold 2
        """.trimIndent(),
    ),
    DISCARD(
        title = "discard",
        aliases = listOf("d"),
        synopsis = """
            discard name_of_actor act
            discard act_card_number
        """.trimIndent(),
        description = """
            Discard an act card.
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the location of the act card in the hand.
        """.trimIndent(),
        examples = """
            Discards act1 of the actor named "A":
                discard A 1
            Discards the 2nd card in hand:
                discard 2
        """.trimIndent(),
    ),
    UNQUEUE(
        title = "unqueue",
        aliases = listOf("unq"),
        synopsis = """
            unqueue name_of_actor act
            unqueue act_card_number...
            unqueue
        """.trimIndent(),
        description = """
            Unqueue act(s).
            Accepts either the name of an actor and the act (1, 2, 3, or cx),
            or the locations of act cards in the hand.
            If no arguments are given, unqueues the last act in the queue.
        """.trimIndent(),
        examples = """
            Unqueues the act1 of the actor named "A":
                unqueue A 1
            Unqueues 2nd card in hand:
                unqueue 2
            Unqueues the 1st, 5th, and 3rd cards in hand:
                unqueue 1 5 3
            Unqueues the last act in the queue:
                uniqueue
        """.trimIndent(),
    ),
    CLEAR(
        title = "clear",
        aliases = listOf("clr"),
        synopsis = """
            clear
        """.trimIndent(),
        description = """
            Clear the act and cutin queues.
        """.trimIndent(),
        examples = """
            Clears the act and cutin queues:
                clear
        """.trimIndent(),
    ),
    CUTIN(
        title = "cutin",
        aliases = listOf("c"),
        synopsis = """
            cutin name_of_actor
        """.trimIndent(),
        description = """
            Toggle the cutin of the given actor.
        """.trimIndent(),
        examples = """
            Toggles the cutin of  "A":
                cutin A
        """.trimIndent(),
    ),
    CLIMAX(
        title = "climax",
        aliases = listOf("cx"),
        synopsis = """
            climax
        """.trimIndent(),
        description = """
            Enter climax. Will also clear the queue.
        """.trimIndent(),
        examples = """
            Enters climax:
                climax
        """.trimIndent(),
    ),
    STATUS(
        title = "status",
        aliases = listOf("s"),
        synopsis = """
            status
        """.trimIndent(),
        description = """
            Display the current queue and hand.
        """.trimIndent(),
        examples = """
            Displays the current queue and hand:
                status
        """.trimIndent(),
    ),
    INFO(
        title = "info",
        aliases = listOf("i"),
        synopsis = """
            info
        """.trimIndent(),
        description = """
            Display actor info, including hp, brilliance, and buffs.
        """.trimIndent(),
        examples = """
            Displays actor info:
                status
        """.trimIndent(),
    ),
    HISTORY(
        title = "history",
        aliases = listOf("hist"),
        synopsis = """
            history
        """.trimIndent(),
        description = """
            List command history.
            This may be overwritten by the "load" or "undo" commands.
        """.trimIndent(),
        examples = """
            Lists command history.
                history
        """.trimIndent(),
    ),
    FULL_HISTORY(
        title = "full_history",
        aliases = listOf("fullhistory", "fullhist"),
        synopsis = """
            full_history
        """.trimIndent(),
        description = """
            Lists the full command history.
        """.trimIndent(),
        examples = """
            Lists the command history of the full session.
                full_history
        """.trimIndent(),
    ),
    SAVE(
        title = "save",
        aliases = listOf("sv"),
        synopsis = """
            save name
        """.trimIndent(),
        description = """
            Save the current sim state under the given name.
        """.trimIndent(),
        examples = """
            Saves the current sim state under the name "x":
                save x
        """.trimIndent(),
    ),
    LOAD(
        title = "load",
        aliases = listOf("ld"),
        synopsis = """
            load name
        """.trimIndent(),
        description = """
            Load the sim state with the given name.
            Loading a sim state will not overwrite any existing saves.
        """.trimIndent(),
        examples = """
            Loads the sim state named "x":
                load x
        """.trimIndent(),
    ),
    LIST_SAVES(
        title = "list_saves",
        aliases = listOf("listsaves", "lsv"),
        synopsis = """
            list_saves
        """.trimIndent(),
        description = """
            List the name of all saves.
        """.trimIndent(),
        examples = """
            Lists the name of all saves:
                list_saves
        """.trimIndent(),
    ),
    UNDO(
        title = "undo",
        aliases = listOf("ud"),
        synopsis = """
            undo
        """.trimIndent(),
        description = """
            Undo the previous command.
            Skips over "save", "load", and "undo" commands.
        """.trimIndent(),
        examples = """
            Undoes the previous command.
                undo
        """.trimIndent(),
    ),
    SEED(
        title = "seed",
        aliases = listOf("sd"),
        synopsis = """
            seed value
        """.trimIndent(),
        description = """
            Set the rng seed to the given value.
        """.trimIndent(),
        examples = """
            Sets the seed to 123.
                seed 123
        """.trimIndent(),
    ),
    EXPORT(
        title = "export",
        aliases = listOf("exp"),
        synopsis = """
            export
        """.trimIndent(),
        description = """
            Export the current run as a simple strategy.
            Note that the current turn is not recorded until using 'go'.
        """.trimIndent(),
        examples = """
            Exports the current run as a simple strategy.
                export
        """.trimIndent(),
    ),
    INCREMENTAL(
        title = "incremental",
        aliases = listOf("increment", "incr"),
        synopsis = """
            incremental
        """.trimIndent(),
        description = """
            Toggle incremental.
            If incremental is enabled, a pause will happen after every act.
        """.trimIndent(),
        examples = """
            Toggles incremental.
                incremental
        """.trimIndent(),
    ),
    INVULNERABLE(
        title = "invulnerable",
        aliases = listOf("invuln", "invinc", "inv"),
        synopsis = """
            invulnerable
            invulnerable name_of_actor
        """.trimIndent(),
        description = """
            Toggle invulnerability, preventing damage from being taken under normal circumstances.
        """.trimIndent(),
        examples = """
            Toggles invulnerability for the entire team.
                invulnerable
            Toggles invulnerability for the actor named "A".
                invulnerable A
        """.trimIndent(),
    ),
    SET_HP(
        title = "set_hp",
        aliases = listOf("sethp"),
        synopsis = """
            set_hp name_of_actor value
        """.trimIndent(),
        description = """
            Set actor hp.
            Bypasses fortitude and similar mechanics.
        """.trimIndent(),
        examples = """
            Sets the hp of the actor named "A" to 1.
                set_hp A 1
            Sets the hp of the actor named "A" to 50%.
                set_hp A 50%
            Causes actor named "A" to exit.
                set_hp A 0
        """.trimIndent(),
    ),
    SET_BRILLIANCE(
        title = "set_brilliance",
        aliases = listOf("setbrilliance", "setkira", "setbrill"),
        synopsis = """
            set_brilliance name_of_actor value
        """.trimIndent(),
        description = """
            Set actor brilliance.
            Bypasses fortitude and similar mechanics.
        """.trimIndent(),
        examples = """
            Sets the brilliance of the actor named "A" to 100.
                set_brilliance A 100
            Sets the brilliance of the actor named "A" to 0.
                set_brilliance A 0
        """.trimIndent(),
    ),
    DAMAGE(
        title = "damage",
        aliases = listOf("dmg"),
        synopsis = """
            damage name_of_actor value
        """.trimIndent(),
        description = """
            Damage an actor.
            Triggers fortitude and similar mechanics.
            Bypasses invulnerability as well as barriers, evasion, and similar effects.
        """.trimIndent(),
        examples = """
            Damages the actor named "A" by 1 Hp.
                damage A 1
        """.trimIndent(),
    ),
    DRAW_PILE(
        title = "draw_pile",
        aliases = listOf("drawpile", "dp"),
        synopsis = """
            draw_pile
        """.trimIndent(),
        description = """
            View draw pile.
        """.trimIndent(),
        examples = """
            Displays draw pile.
                draw_pile
        """.trimIndent(),
    ),
    SET_HAND(
        title = "set_hand",
        aliases = listOf("sethand", "seth"),
        synopsis = """
            set_hand (name_of_actor act...)...
        """.trimIndent(),
        description = """
            Set hand to given value.
        """.trimIndent(),
        examples = """
            Sets the hand to the act1, act2, and act3 of the actor named "A",
            and the act2 and climax of the actor named "B".
                set_hand A 1 3 4 B 2 cx
        """.trimIndent(),
    ),
    INTERNAL_HAND(
        title = "internal_hand",
        aliases = listOf("internalhand", "inth", "ihand"),
        synopsis = """
            internal_hand
        """.trimIndent(),
        description = """
            View possible internal hands.
        """.trimIndent(),
        examples = """
            Displays possible internal hands.
                internal_hand
        """.trimIndent(),
    ),
    SET_COUNTABLE_BUFF(
        title = "set_countable_buff",
        aliases = listOf("set_countable", "setcountable"),
        synopsis = """
            set_countable_buff name_of_actor buff count
        """.trimIndent(),
        description = """
            Set the count of a countable buff for a particular actor to the given count.
        """.trimIndent(),
        examples = """
            Sets the number of pride stacks on the boss to 3.
                set_countable_buff boss price 3
        """.trimIndent(),
    ),
    LIVE_MODE(
        title = "live_mode",
        aliases = listOf("live"),
        synopsis = """
            live_mode
        """.trimIndent(),
        description = """
            Enable live mode. Only allowed before turn 1.
            Forces all incremental to be on and all actors to be invulnerable.
            Enables playback exports.
        """.trimIndent(),
        examples = """
            Enables live mode.
                live_mode
        """.trimIndent(),
    ),
    ;

    val helpBody = listOfNotNull(
        "Aliases:\n${aliases.joinToString(", ").prependIndent(INDENT)}"
            .takeIf { aliases.isNotEmpty() },
        "Synopsis:\n${synopsis.prependIndent(INDENT)}",
        "Description:\n${description.prependIndent(INDENT)}",
        "Examples:\n${examples.prependIndent(INDENT)}"
    ).joinToString("\n\n")

    val helpText = "$title\n\n$helpBody"
}

val interactiveCommands = buildMap {
    InteractiveStrategyCommand.values().sortedBy { it.title }.forEach { command ->
        this[command.title] = command
        command.aliases.forEach { alias ->
            this[alias] = command
        }
    }
}
