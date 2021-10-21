package xyz.qwewqa.relive.simulator.core.stage.strategy

import com.github.h0tk3y.betterParse.combinators.*
import com.github.h0tk3y.betterParse.grammar.Grammar
import com.github.h0tk3y.betterParse.lexer.literalToken
import com.github.h0tk3y.betterParse.lexer.regexToken
import com.github.h0tk3y.betterParse.parser.Parser
import xyz.qwewqa.relive.simulator.core.stage.Stage
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.team.Team

sealed class SimpleStrategyLine
data class TurnStatement(val turn: Int) : SimpleStrategyLine()
sealed class SimpleStrategyCommand : SimpleStrategyLine() {
    object EnterClimax : SimpleStrategyCommand()
    data class QueueAct(val actor: String, val act: ActType) : SimpleStrategyCommand()
    data class Cutin(val actor: String) : SimpleStrategyCommand()
}

private val actNameMapping = mapOf(
    "1" to ActType.Act1,
    "2" to ActType.Act2,
    "3" to ActType.Act3,
    "4" to ActType.Act4,
    "5" to ActType.Act5,
    "6" to ActType.Act6,
    "7" to ActType.Act7,
    "8" to ActType.Act8,
    "9" to ActType.Act9,
    "10" to ActType.Act10,
    "cx" to ActType.ClimaxAct,
)

object SimpleStrategyGrammar : Grammar<Map<Int, List<SimpleStrategyCommand>>>() {
    val num by regexToken("""\d+""")
    val turn by literalToken("Turn")
    val colon by literalToken(":")
    val climax by literalToken("climax")
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
    } or climax.asJust(SimpleStrategyCommand.EnterClimax)

    val lines by separatedTerms(line, newlines, acceptZero = true)

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
            }
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
            }
        }
        require(queue.size <= 6) { "Queue must be at most 6 tiles long." }
        return QueueResult(queue, climax, cutins)
    }
}
