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
    lateinit var availableCards: MutableSet<ActCard>
    lateinit var climaxCards: Set<ActCard>

    val cardQueue = ArrayDeque<ActCard>()
    var heldCard: ActCard? = null
    val usedClimaxCards = mutableSetOf<ActCard>()

    fun nextCard(): ActCard {
        if (cardQueue.isEmpty()) {
            refillCardQueue()
        }
        return cardQueue.removeFirst()
    }

    private fun refillCardQueue() {
        cardQueue += availableCards.shuffled(stage.random)
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
        availableCards = actCards
            .filterKeys { (_, actType) -> actType != ActType.ClimaxAct }
            .values
            .toMutableSet()
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
            availableCards -= actCard
            if (heldCard == actCard) {
                heldCard = null
            }
            cardQueue.remove(actCard)
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

    val ignoredCards = mutableSetOf<StandardStrategy.ActCard>()

    var holdActionDone = false
        private set

    init {
        val held = strategy.heldCard
        if (held != null) {
            ignoredCards += held
        }
    }

    fun nextCard(): StandardStrategy.ActCard {
        val card = strategy.nextCard()
        return if (card in ignoredCards || card in hand) {
            nextCard()
        } else {
            card
        }
    }

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
        hand.clear()
        strategy.usedClimaxCards.clear()
        strategy.climaxCards.forEach { card ->
            if (card.stageGirl.isAlive && card.stageGirl.currentBrilliance == 100) {
                hand += card
            }
        }
        repeat(5 - hand.size) {
            hand += nextCard()
        }
        stage.log("Strategy") { "Prepare Climax" }
        stage.log("Hand") {
            hand.map {
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
    val hand = mutableSetOf<StandardStrategy.ActCard>()

    private val cardsToReadd = mutableListOf<StandardStrategy.ActCard>()

    fun haveAll(vararg cards: StandardStrategy.ActCard) = cards.all { it in hand }
    fun haveAny(vararg cards: StandardStrategy.ActCard) = cards.any { it in hand }
    fun haveCount(vararg cards: StandardStrategy.ActCard) = cards.count { it in hand }

    val isHolding get() = strategy.heldCard != null
    val heldCard get() = strategy.heldCard

    val StandardStrategy.ActCard.canHold get() = !holdActionDone && this in hand && strategy.heldCard == null

    fun StandardStrategy.ActCard.hold() {
        if (holdActionDone) {
            error("Hold action was already performed.")
        }
        if (this !in hand) {
            error("Card $this not in hand.")
        }
        if (strategy.heldCard != null) {
            error("Already holding a card.")
        }
        ignoredCards += this
        hand -= this
        val replacement = nextCard()
        ignoredCards += replacement
        hand += replacement
        strategy.heldCard = this
        holdActionDone = true
    }

    fun StandardStrategy.ActCard.tryHold() = if (canHold) {
        hold()
        true
    } else {
        false
    }

    val StandardStrategy.ActCard.canDiscard get() = !holdActionDone && this in hand && strategy.heldCard != null

    fun StandardStrategy.ActCard.discard() {
        if (holdActionDone) {
            error("Hold action was already performed.")
        }
        if (this !in hand) {
            error("Card $this not in hand.")
        }
        ignoredCards += this
        hand -= this
        hand += strategy.heldCard ?: error("Not holding a card.")
        strategy.heldCard = null
        holdActionDone = true
    }

    fun StandardStrategy.ActCard.tryDiscard() = if (canDiscard) {
        discard()
        true
    } else {
        false
    }


    val StandardStrategy.ActCard.canQueue get() = this in hand && (apTotal + apCost) <= 6

    private fun StandardStrategy.ActCard.ensureCanQueue() {
        if (this !in hand) {
            error("Card $this not in hand.")
        }
        if ((apTotal + apCost) > 6) {
            error("Card $this exceeds ap tile limit.")
        }
    }

    fun StandardStrategy.ActCard.queue() {
        ensureCanQueue()
        hand.remove(this)
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
        strategy.availableCards += cardsToReadd
        return QueueResult(queue, climax)
    }

    init {
        if (team.active.size == 1) {
            TODO()
        }
        if (inClimax) {
            strategy.climaxCards.forEach { card ->
                if (card.stageGirl.inCX && card !in strategy.usedClimaxCards) {
                    hand += card
                }
            }
        }
        repeat(5 - hand.size) {
            hand += nextCard()
        }
        stage.log("Hand") {
            hand.map {
                "[${it.stageGirl.loadout.data.displayName} (${it.stageGirl.loadout.name})]:[${it.actData.name}]"
            }.joinToString("\n")
        }
    }
}