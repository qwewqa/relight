package xyz.qwewqa.relivesim.stage.strategy

import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.act.ActData
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.log
import xyz.qwewqa.relivesim.stage.team.Team
import kotlin.reflect.KProperty

class StandardStrategy(val strategy: StandardStrategyContext.() -> Unit) : Strategy {
    lateinit var stage: Stage
    lateinit var team: Team
    lateinit var enemy: Team

    val vars = Variables()

    lateinit var actCards: Map<Pair<StageGirl, ActType>, ActCard>
    lateinit var climaxCards: Set<ActCard>

    val cardQueue = ArrayDeque<ActCard>()
    val discardPile = ArrayDeque<ActCard>()
    var heldCard: ActCard? = null
    val usedClimaxCards = mutableSetOf<ActCard>()

    fun nextCard(): ActCard {
        if (cardQueue.isEmpty()) {
            refillCardQueue()
        }
        return cardQueue.removeFirst()
    }

    private fun refillCardQueue() {
        cardQueue += discardPile.shuffled(stage.random)
        discardPile.clear()
    }

    override fun initialize(stage: Stage, team: Team, enemy: Team) {
        this.stage = stage
        this.team = team
        this.enemy = enemy
        actCards = team.stageGirls.values.flatMap { sg ->
            sg.acts.map { (actType, actData) ->
                (sg to actType) to ActCard(sg, actData)
            }
        }.toMap()
        discardPile += actCards.values.filter { it.actData.type != ActType.ClimaxAct }
        climaxCards = actCards
            .filterKeys { (_, actType) -> actType == ActType.ClimaxAct }
            .values
            .toSet()
    }

    override fun getQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        return StandardStrategyContext(this).apply(strategy).get()
    }

    override fun onStageGirlExit(sg: StageGirl) {
        sg.acts.forEach { (actType, _) ->
            val actCard = actCards.getValue(sg to actType)
            cardQueue -= actCard
            discardPile -= actCard
            if (heldCard == actCard) {
                heldCard = null
            }
        }
    }

    override fun onStageGirlRevive(sg: StageGirl) {
        TODO()
    }

    inner class ActCard(val stageGirl: StageGirl, val actData: ActData) {
        val act = actData.act
        val apCost: Int
            get() {
                var cost = actData.apCost
                if (stageGirl.apUpCounter > 0) cost += 1
                if (stageGirl.apDownCounter > 0) cost -= 1
                return cost.coerceAtLeast(1)
            }
    }
}

@Suppress("UNCHECKED_CAST")
class Variables {
    private val values = mutableMapOf<String, Any?>()

    operator fun invoke(default: () -> Any) = VariableWithDefault(default)

    operator fun <T> getValue(thisRef: Any?, property: KProperty<*>): T {
        return values.getOrElse(property.name) { error("Variable ${property.name} initialized.") } as T
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Any?) {
        values[property.name] = value
    }

    inner class VariableWithDefault(val default: () -> Any) {

        operator fun <T> getValue(thisRef: Any?, property: KProperty<*>): T {
            return values.getOrPut(property.name, default) as T
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Any?) {
            values[property.name] = value
        }
    }
}

class StandardStrategyContext(val strategy: StandardStrategy) {
    val stage = strategy.stage
    val team = strategy.team
    val enemy = strategy.enemy
    val vars = strategy.vars

    val turn get() = stage.turn
    val friend get() = team.friend ?: error("Friend not found.")

    operator fun String.unaryMinus() = team.stageGirls[this] ?: error("Stage girl not found.")
    operator fun StageGirl.get(act: ActType): StandardStrategy.ActCard {
        return strategy.actCards[this to act] ?: error("Act $act for $this not available.")
    }

    val returningCards = mutableListOf<StandardStrategy.ActCard>()

    var holdActionDone = false
        private set

    fun nextCard() = strategy.nextCard()

    var climax = false

    val inClimax get() = team.cxTurns > 0 || climax
    val canClimax get() = team.cxTurns == 0 && team.active.any { it.currentBrilliance == 100 }

    fun climax() {
        if (!canClimax) {
            error("Climax is not ready.")
        }
        if (apTotal > 0) {
            error("Cannot climax with cards already queued.")
        }
        climax = true
        strategy.usedClimaxCards.clear()
        val activeClimaxCards = strategy.climaxCards.filter {
            it.stageGirl.isAlive && it.stageGirl.currentBrilliance == 100
        }
        returningCards += internalHand.takeLast(activeClimaxCards.size)
        strategy.discardPile += internalHand.dropLast(activeClimaxCards.size)
        internalHand.clear()
        internalHand += activeClimaxCards
        repeat(5 - activeClimaxCards.size) {
            internalHand += nextCard()
        }
        stage.log("Strategy") { "Prepare Climax" }
        stage.log("Hand") {
            internalHand.map {
                "[${it.stageGirl.loadout.data.displayName} (${it.stageGirl.loadout.name})]:[${it.actData.name}]"
            }.joinToString("\n")
        }
    }

    fun tryClimax() = if (canClimax) {
        climax()
        true
    } else {
        false
    }

    val queued = mutableListOf<StandardStrategy.ActCard>()
    var apTotal = 0
    private val internalHand = mutableListOf<StandardStrategy.ActCard>()
    val hand: List<StandardStrategy.ActCard>
        get() = internalHand.toMutableList().also { cards ->
            val temp = cards[3]
            cards[3] = cards[1]
            cards[1] = temp
            cards.sortBy { it.apCost }
            cards.sortBy { it.actData.type == ActType.ClimaxAct }
        }

    fun haveAll(vararg cards: StandardStrategy.ActCard) = cards.all { it in internalHand }
    fun haveAny(vararg cards: StandardStrategy.ActCard) = cards.any { it in internalHand }
    fun haveCount(vararg cards: StandardStrategy.ActCard) = cards.count { it in internalHand }
    fun have(card: StandardStrategy.ActCard) = card in internalHand

    fun queueIs(vararg cards: StandardStrategy.ActCard): Boolean {
        return cards.size == queued.size && cards.zip(queued).all { (a, b) -> a == b }
    }

    val isHolding get() = strategy.heldCard != null
    val heldCard get() = strategy.heldCard

    val StandardStrategy.ActCard.canHold get() = !holdActionDone && this !in queued && this in internalHand && strategy.heldCard == null

    fun StandardStrategy.ActCard.hold() {
        if (holdActionDone) {
            error("Hold action was already performed.")
        }
        if (this !in internalHand) {
            error("Card $this not in hand.")
        }
        if (strategy.heldCard != null) {
            error("Already holding a card.")
        }
        if (this in queued) {
            error("Cannot hold a queued card.")
        }
        internalHand -= this
        internalHand += nextCard()
        strategy.heldCard = this
        holdActionDone = true
    }

    fun StandardStrategy.ActCard.tryHold() = if (canHold) {
        hold()
        true
    } else {
        false
    }

    val StandardStrategy.ActCard.canDiscard get() = !holdActionDone && this !in queued && this in internalHand && strategy.heldCard != null

    fun StandardStrategy.ActCard.discard() {
        if (holdActionDone) {
            error("Hold action was already performed.")
        }
        if (this !in internalHand) {
            error("Card $this not in hand.")
        }
        if (this in queued) {
            error("Cannot discard a queued card.")
        }
        returningCards += this
        internalHand -= this
        internalHand += strategy.heldCard ?: error("Not holding a card.")
        strategy.heldCard = null
        holdActionDone = true
    }

    fun StandardStrategy.ActCard.tryDiscard() = if (canDiscard) {
        discard()
        true
    } else {
        false
    }


    val StandardStrategy.ActCard.canQueue get() = this in internalHand && this !in queued && (apTotal + apCost) <= 6

    private fun StandardStrategy.ActCard.ensureCanQueue() {
        if (this !in internalHand) {
            error("Card $this not in hand.")
        }
        if (this in queued) {
            error("Card already queued.")
        }
        if ((apTotal + apCost) > 6) {
            error("Card $this exceeds ap tile limit.")
        }
    }

    fun StandardStrategy.ActCard.queue() {
        ensureCanQueue()
        apTotal += apCost
        queued += this
    }

    fun StandardStrategy.ActCard.tryQueue() = if (canQueue) {
        queue()
        true
    } else {
        false
    }

    operator fun StandardStrategy.ActCard.unaryPlus() = queue()
    operator fun StandardStrategy.ActCard.unaryMinus() = tryQueue()

    fun get(): QueueResult {
        val queue = mutableListOf<QueueTile>()
        queued.forEach { card ->
            repeat(card.apCost - 1) { queue += IdleTile }
            queue += ActionTile(card.stageGirl, card.apCost, card.actData)
        }
        strategy.usedClimaxCards += queued.filter { it.actData.type == ActType.ClimaxAct }
        strategy.discardPile += internalHand
        strategy.discardPile += returningCards
        return QueueResult(queue, climax)
    }

    init {
        if (team.active.size == 1) {
            TODO()
        }
        val activeClimaxCards = if (inClimax) {
            strategy.climaxCards.filter { it.stageGirl.inCX && it !in strategy.usedClimaxCards }
        } else {
            emptyList()
        }
        internalHand += activeClimaxCards
        repeat(5 - this.internalHand.size) {
            this.internalHand += nextCard()
        }
        stage.log("Hand") {
            this.internalHand.map {
                "[${it.stageGirl.loadout.data.displayName} (${it.stageGirl.loadout.name})]:[${it.actData.name}]"
            }.joinToString("\n")
        }
    }

}