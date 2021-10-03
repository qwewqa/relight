package xyz.qwewqa.relive.simulator.core.stage.strategy.conpletestrategy

import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange


data class CsContext(
    val variables: MutableMap<String, CsObject> = mutableMapOf(
        "true" to CsBoolean(true),
        "false" to CsBoolean(false),
    ),
)

fun CsContext.addFunction(name: String, func: (List<CsObject>) -> CsObject) {
    variables[name] = CsFunction(func)
}

class CsRuntimeException(message: String) : RuntimeException(message)

fun csError(message: String): Nothing {
    throw CsRuntimeException(message)
}

interface CsObject {
    fun getAttribute(name: String): CsObject? = null
    fun invoke(arguments: List<CsObject>): CsObject = csError("Invoke not supported.")
    fun bool(): Boolean = true
    fun display(): String = toString()
}

operator fun CsObject.get(name: String) = getAttribute(name) ?: csError("Attribute $name not found.")

object CsNil : CsObject {
    override fun bool() = false
}

fun Number.asCsNumber() = CsNumber(toDouble())
fun Boolean.asCsBoolean() = CsBoolean(this)

fun CsObject.number() = (this as? CsNumber)?.value ?: csError("Expected a number.")

data class CsNumber(val value: Double) : CsObject {
    override fun bool() = value != 0.0
    override fun display() = value.toString()
}

data class CsBoolean(val value: Boolean) : CsObject {
    override fun bool() = value
    override fun display() = value.toString()
}

data class CsFunction(val value: (List<CsObject>) -> CsObject) : CsObject {
    override fun invoke(arguments: List<CsObject>) = value(arguments)
}

class CsActor(val value: Actor) : CsObject {
    override fun getAttribute(name: String) = when (name) {
        "act1" -> value.acts[ActType.Act1]?.asCsAct(value)
        "act2" -> value.acts[ActType.Act2]?.asCsAct(value)
        "act3" -> value.acts[ActType.Act3]?.asCsAct(value)
        "act4" -> value.acts[ActType.Act4]?.asCsAct(value)
        "act5" -> value.acts[ActType.Act5]?.asCsAct(value)
        "act6" -> value.acts[ActType.Act6]?.asCsAct(value)
        "act7" -> value.acts[ActType.Act7]?.asCsAct(value)
        "act8" -> value.acts[ActType.Act8]?.asCsAct(value)
        "act9" -> value.acts[ActType.Act9]?.asCsAct(value)
        "act10" -> value.acts[ActType.Act10]?.asCsAct(value)
        "cx" -> value.acts[ActType.ClimaxAct]?.asCsAct(value)
        "alive" -> value.isAlive.asCsBoolean()
        "canCx" -> (value.brilliance >= 100).asCsBoolean()
        "inCx" -> value.inCX.asCsBoolean()
        else -> null
    }
    override fun display() = value.name
}

data class CsAct(val actor: Actor, val act: ActData) : CsObject, Comparable<CsAct> {
    val apCost get() = (act.apCost + actor.apChange).coerceAtLeast(1)

    val sortPriority = run {
        var v = act.apCost
        if (act.type == ActType.ClimaxAct) v += 10
        v
    }

    override fun compareTo(other: CsAct): Int {
        return sortPriority.compareTo(other.sortPriority)
    }
}

fun ActData.asCsAct(actor: Actor) = CsAct(actor, this)

data class CsList(val value: List<CsObject>) : CsObject {
    override fun invoke(arguments: List<CsObject>): CsObject {
        val arg = (arguments.singleOrNull() ?: csError("Expected one argument.")).number().let {
            if (it % 0.0 != 0.0) csError("Expected an integer argument.")
            it.toInt()
        }
        if (arg !in value.indices) csError("Index out of bounds.")
        return value[arg]
    }

    override fun getAttribute(name: String) = when (name) {
        "contains" -> CsFunction { args ->
            val arg = args.singleOrNull() ?: csError("Expected one argument.")
            (arg in value).asCsBoolean()
        }
        else -> null
    }
    override fun display() = value.toString()
}
