package xyz.qwewqa.relive.simulator.core.stage.strategy.complete

import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.ignoreRun
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.strategy.*
import xyz.qwewqa.relive.simulator.core.stage.team.Team

class CompleteStrategy(val script: CsScriptNode) : Strategy {
    lateinit var stage: Stage
    lateinit var team: Team
    lateinit var enemy: Team

    private val context = CsContext()

    private val queue = mutableListOf<QueueTile>()
    private val queued = mutableListOf<CsAct>()
    private var queueSize: Int = 0
    private var climax = false

    private val discardPile = mutableListOf<CsAct>()
    private val drawPile = ArrayDeque<CsAct>()
    private val hand = mutableListOf<CsAct>()
    private val internalHand = mutableListOf<CsAct>()
    private val climaxPile = mutableListOf<CsAct>()
    private var held: CsAct? = null

    private fun formatAct(act: CsAct) = "[${act.actor.dress.name} (${act.actor.name})]:[${act.act.name}](${act.act.type.name})"

    private fun logHand() {
        stage.log("Hand") {
            hand.joinToString("\n") {
                formatAct(it)
            }
        }
    }

    override fun onRevive(actor: Actor) {
        discardPile += (actor.acts[ActType.Act1]!!.asCsAct(actor))
        discardPile += (actor.acts[ActType.Act2]!!.asCsAct(actor))
        discardPile += (actor.acts[ActType.Act3]!!.asCsAct(actor))
    }

    override fun initialize(stage: Stage, team: Team, enemy: Team) {
        this.stage = stage
        this.team = team
        this.enemy = enemy
        team.actors.forEach { (k, v) ->
            context.variables[k] = CsActor(v)
            discardPile += (v.acts[ActType.Act1]!!.asCsAct(v))
            discardPile += (v.acts[ActType.Act2]!!.asCsAct(v))
            discardPile += (v.acts[ActType.Act3]!!.asCsAct(v))
        }
        enemy.actors.forEach { (k, v) ->
            context.variables[k] = CsActor(v)
        }
        context.addFunction("ignore") {
            if (it.size != 0) csError("Expected zero arguments.")
            ignoreRun()
        }
        context.addFunction("log") {
            if (it.size == 0) csError("Expected at least one argument.")
            stage.log("Strategy Log") { it.joinToString(", ") { it.display() } }
            CsNil
        }
        context.addFunction("random") {
            if (it.size != 0) csError("Expected zero arguments.")
            stage.random.nextDouble().asCsNumber()
        }
        script.initialize?.execute(context)
        context.addFunction("canClimax") {
            if (it.size != 0) csError("Expected zero arguments.")
            canCx().asCsBoolean()
        }
        context.addFunction("climax") {
            if (it.size != 0) csError("Expected zero arguments.")
            enterClimax()
            CsNil
        }
        context.addFunction("tryClimax") {
            if (it.size != 0) csError("Expected zero arguments.")
            if (canCx()) {
                enterClimax()
                true.asCsBoolean()
            } else {
                false.asCsBoolean()
            }
        }
        context.addFunction("canQueue") {
            canQueue(it.singleAct()).asCsBoolean()
        }
        context.addFunction("queue") {
            queue(it.singleAct())
            CsNil
        }
        context.addFunction("tryQueue") {
            val act = it.singleAct()
            if (canQueue(act)) {
                queue(it.singleAct())
                true.asCsBoolean()
            } else {
                false.asCsBoolean()
            }
        }
        context.addFunction("canHold") {
            canHold(it.singleAct()).asCsBoolean()
        }
        context.addFunction("hold") {
            hold(it.singleAct())
            CsNil
        }
        context.addFunction("tryHold") {
            val act = it.singleAct()
            if (canHold(act)) {
                hold(it.singleAct())
                true.asCsBoolean()
            } else {
                false.asCsBoolean()
            }
        }
        context.addFunction("canDiscard") {
            canDiscard(it.singleAct()).asCsBoolean()
        }
        context.addFunction("discard") {
            discard(it.singleAct())
            CsNil
        }
        context.addFunction("tryDiscard") {
            val act = it.singleAct()
            if (canDiscard(act)) {
                discard(it.singleAct())
                true.asCsBoolean()
            } else {
                false.asCsBoolean()
            }
        }
        context.variables["hand"] = CsList(hand)
    }

    override fun getQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        if (team.cxTurns == 0) {
            climaxPile.clear()
        }
        climax = false
        queue.clear()
        queued.clear()
        queueSize = 0
        drawHand()
        context.variables["turn"] = stage.turn.asCsNumber()
        script.body.execute(context)
        discardHand()
        return QueueResult(queue, climax)
    }

    private fun CsObject.act() = (this as? CsAct) ?: csError("Expected an act.")
    private fun List<CsObject>.singleAct() = this.singleOrNull()?.act() ?: csError("Expected a single act.")

    private fun drawCard(): CsAct {
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
            drawPile += (actor.acts[ActType.Act1]!!.asCsAct(actor))
            drawPile += (actor.acts[ActType.Act2]!!.asCsAct(actor))
            drawPile += (actor.acts[ActType.Act3]!!.asCsAct(actor))
            drawPile += (actor.acts[ActType.Act1]!!.asCsAct(actor))
            drawPile += (actor.acts[ActType.Act1]!!.asCsAct(actor))
        }
        hand += climaxPile
        while (hand.size < 5) hand += drawCard()
        internalHand += hand
        hand.qsort()
        logHand()
    }

    private fun discardHand() {
        val discarded = mutableSetOf<CsAct>()
        internalHand.forEach {
            if (it !in discarded && it.actor.isAlive) {
                discarded += it
                discardPile += it
            }
        }
        hand.clear()
        internalHand.clear()
    }

    private fun canQueue(act: CsAct): Boolean {
        return queued.count { it == act } < hand.count { it == act } && (queueSize + act.apCost) <= 6
    }

    private fun canHold(act: CsAct) = team.active.size > 1 && act !in queued && act in hand && held == null
    private fun canDiscard(act: CsAct) = act !in queued && act in hand && held != null
    private fun canCx() = queued.isEmpty() && team.cxTurns == 0 && team.active.any { it.brilliance >= 100 } && !climax

    private fun queue(act: CsAct) {
        if (!canQueue(act)) csError("Queue ${act.actor.name} ${act.act.type.name} not available.")
        queued += act
        val apCost = act.apCost
        repeat(apCost - 1) { queue += IdleTile }
        queue += ActionTile(act.actor, apCost, act.act)
        queueSize += apCost
    }

    private fun enterClimax() {
        if (!canCx()) csError("Climax unavailable.")
        stage.log("Hand") { "Climax" }
        climax = true
        drawPile += internalHand
        hand.clear()
        internalHand.clear()
        climaxPile += team.active.filter { it.brilliance >= 100 }.map { it.acts[ActType.ClimaxAct]!!.asCsAct(it) }
        drawHand()
    }

    private fun hold(act: CsAct) {
        if (!canHold(act)) csError("Hold unavailable.")
        stage.log("Hand") { "Hold ${formatAct(act)}" }
        held = act
        val newAct = drawCard()
        internalHand -= act
        internalHand += newAct
        hand[hand.indexOf(act)] = newAct
        logHand()
    }

    private fun discard(act: CsAct) {
        if (!canDiscard(act)) csError("Discard unavailable.")
        stage.log("Hand") { "Discard ${formatAct(act)}" }
        discardPile += act
        internalHand -= act
        internalHand += held!!
        hand[hand.indexOf(act)] = held!!
        held = null
        logHand()
    }
}

private fun <T : Comparable<T>> MutableList<T>.qsort() {
    if (size <= 1) return
    auxsort(this, 0, size - 1)
}

private fun <T : Comparable<T>> auxsort(a: MutableList<T>, l: Int, u: Int) {
    if (l == u) return
    if (a[u] < a[l]) {
        a.swap(l, u)
    }
    if (u - l == 1) return
    val p = (l + u) / 2
    if (a[p] < a[l]) {
        a.swap(p, l)
    } else if (a[u] < a[p]) {
        a.swap(u, p)
    }
    if (u - l == 2) return
    a.swap(p, u - 1)
    val piv = partition(a, l, u)
    if (p - l < u - p) {
        auxsort(a, l, piv - 1)
        auxsort(a, piv + 1, u)
    } else {
        auxsort(a, piv + 1, u)
        auxsort(a, l, piv - 1)
    }
}

private fun <T> MutableList<T>.swap(a: Int, b: Int) {
    val temp = this[a]
    this[a] = this[b]
    this[b] = temp
}

private fun <T : Comparable<T>> partition(a: MutableList<T>, l: Int, u: Int): Int {
    var i = l
    var j = u - 1
    val pivot = a[u - 1]

    while (true) {
        while (true) {
            i++
            if (a[i] >= pivot) break
        }
        while (true) {
            j--
            if (a[j] <= pivot) break
        }

        if (j < i) {
            a.swap(i, u - 1)
            return i
        }

        a.swap(i, j)
    }
}

class SimpleStrategy(val commands: Map<Int, List<SimpleStrategyCommand>>) : Strategy {
    override fun getQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        val queue = mutableListOf<QueueTile>()
        var climax = false
        commands[stage.turn]?.forEach { command ->
            when (command) {
                SimpleStrategyCommand.EnterClimax -> {
                    if (team.cxTurns > 0) error("Player already in climax.")
                    if (team.active.all { it.brilliance < 100 }) error("Player climax not ready.")
                    climax = true
                }
                is SimpleStrategyCommand.QueueAct -> {
                    val actor = team.actors[command.actor] ?: error("Unknown actor ${command.actor}")
                    val act = actor.acts[command.act] ?: error("Unknown act ${command.act} for actor ${command.actor}")
                    val cost = (act.apCost + actor.apChange).coerceAtLeast(1)
                    if (command.act == ActType.ClimaxAct && !(climax || team.cxTurns > 0 || actor.brilliance < 100)) {
                        error("Climax not ready for actor [${actor.name}]")
                    }
                    repeat(cost - 1) { queue += IdleTile }
                    queue += ActionTile(actor, cost, act)
                }
            }
        }
        require(queue.size <= 6) { "Queue must be at most 6 tiles long." }
        return QueueResult(queue, climax)
    }
}
