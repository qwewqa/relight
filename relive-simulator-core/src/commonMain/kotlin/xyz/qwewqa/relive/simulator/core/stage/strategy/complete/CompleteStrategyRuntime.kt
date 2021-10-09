package xyz.qwewqa.relive.simulator.core.stage.strategy.complete

import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.buff.MarkBuff


data class CsContext(
    val variables: MutableMap<String, CsObject> = mutableMapOf(
        "true" to CsBoolean.TRUE,
        "false" to CsBoolean.FALSE,
    ),
)

fun CsContext.addFunction(name: String, func: (List<CsObject>) -> CsObject) {
    variables[name] = CsFunction(func)
}

open class CsRuntimeException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
class AnnotatedCsRuntimeException(message: String, cause: Throwable? = null) : CsRuntimeException(message, cause)

fun csError(message: String, cause: Throwable? = null): Nothing {
    throw CsRuntimeException(message, cause)
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
fun Boolean.asCsBoolean() = if (this) CsBoolean.TRUE else CsBoolean.FALSE
fun String.asCsString() = CsString(this)

fun CsObject.number() = (this as? CsNumber)?.value ?: csError("Expected a number.")

data class CsNumber(val value: Double) : CsObject {
    override fun bool() = value != 0.0
    override fun display() = value.toString()
}

data class CsString(val value: String) : CsObject {
    override fun bool() = value.isNotEmpty()
    override fun display() = value
}

enum class CsBoolean(val value: Boolean) : CsObject {
    TRUE(true), FALSE(false);
    override fun bool() = value
    override fun display() = value.toString()
}

data class CsFunction(val value: (List<CsObject>) -> CsObject) : CsObject {
    override fun invoke(arguments: List<CsObject>) = value(arguments)
}

class CsActor(val value: Actor) : CsObject {
    override fun getAttribute(name: String): CsObject? {
        val ktVal: Any? = when (name) {
            // Acts
            "act1" -> value.acts[ActType.Act1]
            "act2" -> value.acts[ActType.Act2]
            "act3" -> value.acts[ActType.Act3]
            "act4" -> value.acts[ActType.Act4]
            "act5" -> value.acts[ActType.Act5]
            "act6" -> value.acts[ActType.Act6]
            "act7" -> value.acts[ActType.Act7]
            "act8" -> value.acts[ActType.Act8]
            "act9" -> value.acts[ActType.Act9]
            "act10" -> value.acts[ActType.Act10]
            "cx" -> value.acts[ActType.ClimaxAct]
            // Basic info
            "alive" -> value.isAlive
            "canCx" -> (value.brilliance >= 100)
            "inCx" -> value.inCX
            // Stats
            "hp" -> value.hp
            "maxHp" -> value.maxHp
            "brilliance" -> value.brilliance
            // Buff stats
            "dex", "dexterity" -> value.dexterity
            "hasApDown" -> (value.apChange < 0)
            "hasNer" -> (value.negativeEffectResist >= 100)
            "marked" -> value.buffs.any(MarkBuff)
            else -> null
        }
        return when (ktVal) {
            null -> null // attribute not found
            is ActData -> ktVal.asCsAct(value)
            is Boolean -> ktVal.asCsBoolean()
            is Number -> ktVal.asCsNumber()
            is String -> ktVal.asCsString()
            is CsObject -> ktVal
            else -> csError("internal error: attribute type not supported")
        }
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
            if (it % 1.0 != 0.0) csError("Expected an integer argument.")
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

    override fun bool() = value.isNotEmpty()
    override fun display() = value.toString()
}
