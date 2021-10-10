package xyz.qwewqa.relive.simulator.core.stage.strategy.complete

import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.ignoreRun
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.strategy.*
import xyz.qwewqa.relive.simulator.core.stage.team.Team

/**
 * Check that a strategy arguments list consists only of acts and return the
 * list unchanged.
 */
fun requireActs(args: List<CsObject>): List<CsObject> {
    if (args.any { it !is CsAct }) csError("Expected all arguments to be acts.")
    return args
}

class CompleteStrategy(val script: CsScriptNode) : Strategy {
    lateinit var stage: Stage
    lateinit var team: Team
    lateinit var enemy: Team

    private val context = CsContext()

    private val queue = mutableListOf<QueueTile>()
    private val queued = mutableListOf<CsAct>()
    private var queueSize: Int = 0
    private var climax = false

    private val queuedCutins = mutableListOf<BoundCutin>()
    private var cutinEnergy = 2 // one is gained at the start of t1
    private var cutinUseCounts = mutableMapOf<BoundCutin, Int>().withDefault { 0 }
    private var cutinLastUseTurns = mutableMapOf<BoundCutin, Int>().withDefault { 1 }

    private val discardPile = mutableListOf<CsAct>()
    private val drawPile = ArrayDeque<CsAct>()
    private val hand = mutableListOf<CsAct>()
    private val internalHand = mutableListOf<CsAct>()
    private val climaxPile = mutableListOf<CsAct>()
    private var held: CsAct? = null

    private fun formatAct(act: CsAct) =
        "[${act.actor.dress.name} (${act.actor.name})]:[${act.act.name}](${act.act.type.name})"

    private fun logHand() {
        stage.log("Hand") {
            hand.joinToString("\n") {
                formatAct(it)
            }
        }
    }

    override fun onRevive(actor: Actor) {
        // This does not work if an actor exits and is revived the same turn
        // Nor has it been tested how that works.
        // TODO: take another look at this when revive gets implemented
        discardPile += (actor.acts[ActType.Act1]!!.asCsAct(actor))
        discardPile += (actor.acts[ActType.Act2]!!.asCsAct(actor))
        discardPile += (actor.acts[ActType.Act3]!!.asCsAct(actor))
    }

    override fun initialize(stage: Stage, team: Team, enemy: Team) {
        this.stage = stage
        this.team = team
        this.enemy = enemy
        team.actors.forEach { (name, actor) ->
            context.variables[name] = CsActor(actor)
            discardPile += (actor.acts[ActType.Act1]!!.asCsAct(actor))
            discardPile += (actor.acts[ActType.Act2]!!.asCsAct(actor))
            discardPile += (actor.acts[ActType.Act3]!!.asCsAct(actor))
        }
        enemy.actors.forEach { (k, v) ->
            context.variables[k] = CsActor(v)
        }

        context.addFunction("ignore") { args ->
            if (args.isNotEmpty()) csError("Expected zero arguments.")
            ignoreRun()
        }

        context.addFunction("log") { args ->
            if (args.isEmpty()) csError("Expected at least one argument.")
            stage.log("Strategy Log") { args.joinToString(", ") { it.display() } }
            CsNil
        }

        context.addFunction("error") { args ->
            csError(if (args.isEmpty()) {
                "error()"
            } else {
                args.joinToString(", ") { it.display() }
            })
        }

        context.addFunction("random") { args ->
            if (args.isNotEmpty()) csError("Expected zero arguments.")
            stage.random.nextDouble().asCsNumber()
        }

        context.addFunction("list") { args ->
            CsList(requireActs(args)) // Note: only allows lists of acts
        }

        script.initialize?.execute(context)

        registerCardAction("queue", ::canQueue) { act -> queue(act) }
        registerCardAction("hold", ::canHold, ::hold)
        registerCardAction("discard", ::canDiscard, ::discard)
        // climax/canClimax/tryClimax are just like queue/hold/discard, but
        // take no arguments
        context.addFunction("canClimax") { args ->
            if (args.isNotEmpty()) csError("Expected zero arguments.")
            canCx().asCsBoolean()
        }
        context.addFunction("climax") { args ->
            if (args.isNotEmpty()) csError("Expected zero arguments.")
            if (!canCx()) csError("Climax unavailable.")
            enterClimax()
            CsNil
        }
        context.addFunction("tryClimax") { args ->
            if (args.isNotEmpty()) csError("Expected zero arguments.")
            if (canCx()) {
                enterClimax()
                true.asCsBoolean()
            } else {
                false.asCsBoolean()
            }
        }

        context.addFunction("canCutin") { args ->
            val actor = args.singleActor()
            val cutin = actor.cutin ?: csError("Actor ${actor.name} does not have a cutin.")
            canActivateCutin(cutin).asCsBoolean()
        }
        context.addFunction("cutin") { args ->
            val actor = args.singleActor()
            val cutin = actor.cutin ?: csError("Actor ${actor.name} does not have a cutin.")
            if (!canActivateCutin(cutin)) csError("Cutin for actor ${actor.name} unavailable.")
            activateCutin(cutin)
            CsNil
        }
        context.addFunction("tryCutin") { args ->
            val actor = args.singleActor()
            val cutin = actor.cutin ?: csError("Actor ${actor.name} does not have a cutin.")
            if (canActivateCutin(cutin)) {
                activateCutin(cutin)
                true.asCsBoolean()
            } else {
                false.asCsBoolean()
            }
        }

        // Try queuing all the acts. If you can't, queue none.
        context.addFunction("tryQueueAll") { args ->
            val acts = args.map { it.act() }
            val canQueue = canQueueAll(acts)
            if (canQueue) {
                for (act in acts) {
                    queue(act)
                }
            }
            canQueue.asCsBoolean()
        }

        // Try queueing each of the acts, one at a time. Return nothing.
        context.addFunction("tryQueueEach") { args ->
            requireActs(args) // check eagerly in case the loop exits early
            val alreadyQueued = queued.size
            for (obj in args) {
                val act = obj as CsAct
                if (canQueue(act)) {
                    queue(act)
                }
                if (queueSize >= 6) break
            }
            CsList(queued.drop(alreadyQueued))
        }

        context.bindValue("held") { held ?: CsNil }
        context.bindValue("turn") { stage.turn.asCsNumber() }
        context.bindValue("cutinEnergy") { cutinEnergy.asCsNumber() }

        context.variables["hand"] = CsList(hand)
    }

    /**
     * Register three functions for an action performed on an act card.
     *
     * The three functions are:
     * - `{name}` accepts one act and performs the action on it.
     * - `can{Name}` uses the given filter function to determine whether the
     *   action can be performed on the given act.
     * - `try{Name}` performs the action on the first of its arguments that
    #   passes the filter, returning that act, or false if none passed.
     */
    private inline fun registerCardAction(
        name: String,
        crossinline filter: (CsAct) -> Boolean,
        crossinline action: (CsAct) -> Unit,
    ) {
        val capName = name.replaceFirstChar { it.uppercase() }
        context.addFunction(name) { args ->
            val act = args.singleAct()
            if (!filter(act)) {
                csError("Unable to ${name}: ${act.actor.name} ${act.act.type.name}")
            }
            action(act)
            CsNil
        }
        context.addFunction("can$capName") {
            filter(it.singleAct()).asCsBoolean()
        }
        context.addFunction("try$capName") { args ->
            if (args.isEmpty()) csError("Expected one or more acts.")
            val act = requireActs(args).firstOrNull { filter(it as CsAct) }
            if (act != null) {
                action(act as CsAct)
            }
            act ?: false.asCsBoolean()
        }
    }

    override fun nextQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        if (team.cxTurns == 0) {
            climaxPile.clear()
        }
        hasPerformedHoldAction = false
        climax = false
        queue.clear()
        queued.clear()
        queuedCutins.clear()
        queueSize = 0
        drawHand()
        cutinEnergy = (cutinEnergy + 1).coerceAtMost(10)
        script.body.execute(context)
        discardHand()
        return QueueResult(queue, climax, queuedCutins)
    }

    private fun CsObject.act() = (this as? CsAct) ?: csError("Expected an act.")
    private fun List<CsObject>.singleAct() = this.singleOrNull()?.act() ?: csError("Expected a single act.")
    private fun List<CsObject>.singleActor(): Actor {
        return (this.singleOrNull() as? CsActor)?.actor ?: csError("Expected a single actor.")
    }

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
        return (queueSize + act.apCost) <= 6 && queued.count { it == act } < hand.count { it == act }
    }

    private fun canQueueAll(acts: Collection<CsAct>): Boolean {
        return (queueSize + acts.sumOf { it.apCost }) <= 6 && hand.containsAll(acts)
    }

    private var hasPerformedHoldAction = true

    private fun canHold(act: CsAct) = team.active.size > 1 &&
            held == null &&
            act !in queued && act in hand &&
            !hasPerformedHoldAction

    private fun canDiscard(act: CsAct) = held != null &&
            act !in queued &&
            act in hand &&
            !hasPerformedHoldAction

    private fun canCx() = queued.isEmpty() &&
            team.cxTurns == 0 &&
            team.active.any { it.brilliance >= 100 } &&
            !climax

    private fun queue(act: CsAct) {
        queued += act
        val apCost = act.apCost
        repeat(apCost - 1) { queue += IdleTile }
        queue += ActionTile(act.actor, apCost, act.act)
        queueSize += apCost
    }

    // Note: implicitly you can't use a cutin twice in one turn since the cooldown gets reset
    // (though this would break with a zero cooldown cutin, which probably won't happen)
    private fun canActivateCutin(cutin: BoundCutin): Boolean = cutin.actor.isAlive &&
            cutin.data.cost <= cutinEnergy &&
            cutinUseCounts.getValue(cutin) < cutin.data.usageLimit &&
            stage.turn - cutinLastUseTurns.getValue(cutin) >= cutin.currentCooldown

    private val BoundCutin.currentCooldown
        get() = if (cutinUseCounts.getValue(this) > 0) {
            data.cooldown
        } else {
            data.cooldownStart
        }

    private fun activateCutin(cutin: BoundCutin) {
        stage.log("Strategy") {
            "Activating cutin for actor ${cutin.actor.name} (prevEnergy = $cutinEnergy, newEnergy = ${cutinEnergy - cutin.data.cost})"
        }
        cutinEnergy -= cutin.data.cost
        cutinLastUseTurns[cutin] = stage.turn
        cutinUseCounts[cutin] = cutinUseCounts.getValue(cutin) + 1
        queuedCutins += cutin
    }

    private fun enterClimax() {
        stage.log("Hand") { "Climax" }
        climax = true
        drawPile += internalHand
        hand.clear()
        internalHand.clear()
        climaxPile += team.active.filter { it.brilliance >= 100 }.map { it.acts[ActType.ClimaxAct]!!.asCsAct(it) }
        drawHand()
    }

    private fun hold(act: CsAct) {
        stage.log("Hand") { "Hold ${formatAct(act)}" }
        held = act
        val newAct = drawCard()
        internalHand -= act
        internalHand += newAct
        hand[hand.indexOf(act)] = newAct
        hasPerformedHoldAction = true
        logHand()
    }

    private fun discard(act: CsAct) {
        stage.log("Hand") { "Discard ${formatAct(act)}" }
        discardPile += act
        internalHand -= act
        internalHand += held!!
        hand[hand.indexOf(act)] = held!!
        held = null
        hasPerformedHoldAction = true
        logHand()
    }
}

/*
Quicksort implementation recreated from the Lua 4.4 source code:

Copyright © 1994–2021 Lua.org, PUC-Rio.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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