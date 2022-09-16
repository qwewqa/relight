package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.combinators.*
import com.github.h0tk3y.betterParse.grammar.Grammar
import com.github.h0tk3y.betterParse.lexer.literalToken
import com.github.h0tk3y.betterParse.lexer.regexToken
import com.github.h0tk3y.betterParse.parser.Parser
import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.team.Team

sealed class SimpleStrategyLine
data class TurnStatement(val turn: Int) : SimpleStrategyLine()
sealed class SimpleStrategyCommand : SimpleStrategyLine() {
    object EnterClimax : SimpleStrategyCommand()
    data class QueueAct(val actor: String, val act: ActType) : SimpleStrategyCommand()
    data class Cutin(val actor: String) : SimpleStrategyCommand()

    data class Assert(
        val actor: String,
        val property: String,
        val operator: String?,
        val operand: String?,
    ) : SimpleStrategyCommand()
}


data class ActorProperty(
    val acceptedOperators: Set<String?>,
    val check: Actor.(operator: String?, operand: String?) -> Boolean,
)


val actorProperties = mapOf(
    "alive" to ActorProperty(
        acceptedOperators = setOf(null),
        check = { _, _ -> hp > 0 },
    ),
    "dead" to ActorProperty(
        acceptedOperators = setOf(null),
        check = { _, _ -> hp <= 0 },
    ),
    "charged" to ActorProperty(
        acceptedOperators = setOf(null),
        check = { _, _ -> brilliance >= 100 },
    ),
    "uncharged" to ActorProperty(
        acceptedOperators = setOf(null),
        check = { _, _ -> brilliance < 100 },
    ),
)


val actNameMapping = ActType.values().associateBy { it.shortName }

object SimpleStrategyGrammar : Grammar<Map<Int, List<SimpleStrategyCommand>>>() {
    val comment by regexToken("""#.*""", ignore = true)
    val num by regexToken("""\d+""")
    val turn by regexToken("[Tt]urn")
    val colon by literalToken(":")
    val climax by literalToken("climax")
    val assert by literalToken("assert")
    val ident by regexToken("""\S+""")
    val newlines by regexToken("""\s*[\r\n]+\s*""")
    val ws by regexToken("""[^\S\r\n]+""", ignore = true)

    val identifier: Parser<String> by ident use { text }
    val anyIdentifier: Parser<String> by (num or ident) use { text }
    val number: Parser<Int> by num use { text.toInt() }

    val line: Parser<SimpleStrategyLine> by (-turn * number * -colon).map { turn ->
        TurnStatement(turn)
    } or (anyIdentifier * anyIdentifier).map { (actor, act) ->
        when (act) {
            "cutin" -> SimpleStrategyCommand.Cutin(actor)
            else -> SimpleStrategyCommand.QueueAct(actor, actNameMapping.getValue(act))
        }
    } or (-assert * anyIdentifier * anyIdentifier * optional(anyIdentifier * anyIdentifier)).map { (actor, property, op) ->
        val operator = op?.t1
        val operand = op?.t2
        val propertyInfo = actorProperties[property] ?: error("Unknown property $property")
        if (operator !in propertyInfo.acceptedOperators) {
            error("Operator ${operator ?: "<no operator>"} is not supported for property $property")
        }
        SimpleStrategyCommand.Assert(actor, property, operator, operand)
    } or climax.asJust(SimpleStrategyCommand.EnterClimax)

    val lines by separatedTerms(line, oneOrMore(newlines), acceptZero = true)

    override val rootParser by (-optional(newlines) * lines * -optional(newlines)).map { lines ->
        val results = mutableMapOf<Int, List<SimpleStrategyCommand>>()
        var currentGroup: MutableList<SimpleStrategyCommand>? = null
        lines.forEach { line ->
            when (line) {
                is TurnStatement -> {
                    require(line.turn > 0) { "Turn must be positive." }
                    require(line.turn !in results) { "Turn must not be repeated." }
                    currentGroup = mutableListOf()
                    results[line.turn] = currentGroup!!
                }
                is SimpleStrategyCommand -> {
                    requireNotNull(currentGroup != null) { "Missing turn." }
                    currentGroup!!.add(line)
                }
            }
        }
        results
    }
}

class SimpleStrategy(val commands: Map<Int, List<SimpleStrategyCommand>>) : Strategy {
    override fun nextQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        val queue = mutableListOf<QueueTile>()
        val cutins = mutableListOf<BoundCutin>()
        var climax = false
        val assertionFailures = mutableListOf<String>()
        commands[stage.turn]?.forEach { command ->
            when (command) {
                SimpleStrategyCommand.EnterClimax -> {
                    if (team.cxTurns > 0) error("Player already in climax.")
                    if (team.active.all { it.brilliance < 100 }) error("Player climax not ready.")
                    climax = true
                }
                is SimpleStrategyCommand.QueueAct -> {
                    val actor = team.actors[command.actor] ?: error("Unknown actor ${command.actor}")
                    if (!actor.isAlive) {
                        error("Actor [${actor.name}] has already exited.")
                    }
                    val act = actor.acts[command.act] ?: error("Unknown act ${command.act} for actor ${command.actor}")
                    val cost = (act.apCost + actor.apChange).coerceAtLeast(1)
                    if (command.act == ActType.ClimaxAct) {
                        if (!(climax || team.cxTurns > 0)) {
                            error("Climax has not been activated and is not already active.")
                        }
                        if (actor.brilliance < 100) {
                            error("Climax not ready for actor [${actor.name}] due to insufficient brilliance.")
                        }
                    }
                    repeat(cost - 1) { queue += IdleTile }
                    queue += ActionTile(actor, cost, act)
                }
                is SimpleStrategyCommand.Cutin -> {
                    val actor = team.actors[command.actor] ?: error("Unknown actor ${command.actor}")
                    cutins += actor.cutin ?: error("Cutin for actor ${command.actor} not available.")
                }
                is SimpleStrategyCommand.Assert -> {
                    val actor = team.actors[command.actor] ?: error("Unknown actor ${command.actor}")
                    val propertyInfo = actorProperties[command.property]!!
                    if (!propertyInfo.check(actor, command.operator, command.operand)) {
                        assertionFailures += "assert ${command.actor} ${command.property}${
                            if (command.operator != null) " ${command.operator} ${command.operand}" else ""
                        }"
                        stage.log("Strategy", category = LogCategory.ERROR) {
                            "Assertion failed for actor ${command.actor} property ${command.property}."
                        }
                    }
                }
            }
        }
        if (assertionFailures.isNotEmpty()) {
            stage.tags += "t${stage.turn}"
            stage.tags += assertionFailures
            error("Assertions failed: [${assertionFailures.joinToString(", ")}]")
        }
        require(queue.size <= 6) { "Queue must be at most 6 tiles long." }
        return QueueResult(queue, climax, cutins)
    }
}

class BossSimpleStrategy(val commands: Map<Int, List<SimpleStrategyCommand>>) : Strategy {
    override fun nextQueue(stage: Stage, team: Team, enemy: Team): QueueResult {
        val queue = mutableListOf<QueueTile>()
        val cutins = mutableListOf<BoundCutin>()
        val climax = false
        val boss = team.actors.values.singleOrNull()
        commands[stage.turn]?.forEach { command ->
            when (command) {
                SimpleStrategyCommand.EnterClimax -> {
                    error("Bosses cannot enter climax and climax acts should be used without activating climax.")
                }
                is SimpleStrategyCommand.QueueAct -> {
                    val actor = (if (command.actor == "Boss") boss else team.actors[command.actor])
                        ?: error("Unknown actor ${command.actor}")
                    val act = actor.acts[command.act] ?: error("Unknown act ${command.act} for actor ${command.actor}")
                    val cost = (act.apCost + actor.apChange).coerceAtLeast(1)
                    repeat(cost - 1) { queue += IdleTile }
                    queue += ActionTile(actor, cost, act)
                }
                is SimpleStrategyCommand.Cutin -> {
                    error("Bosses cannot use cutins.")
                }
                is SimpleStrategyCommand.Assert -> {
                    error("Bosses cannot use assertions.")
                }
            }
        }
        require(queue.size <= 6) { "Queue must be at most 6 tiles long." }
        return QueueResult(queue, climax, cutins)
    }
}
