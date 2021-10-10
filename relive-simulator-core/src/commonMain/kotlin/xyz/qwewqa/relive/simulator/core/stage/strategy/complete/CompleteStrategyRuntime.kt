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

class CsActor(val actor: Actor) : CsObject {
    override fun getAttribute(name: String): CsObject? {
        val ktVal: Any? = when (name) {
            // Acts
            "act1" -> actor.acts[ActType.Act1]
            "act2" -> actor.acts[ActType.Act2]
            "act3" -> actor.acts[ActType.Act3]
            "act4" -> actor.acts[ActType.Act4]
            "act5" -> actor.acts[ActType.Act5]
            "act6" -> actor.acts[ActType.Act6]
            "act7" -> actor.acts[ActType.Act7]
            "act8" -> actor.acts[ActType.Act8]
            "act9" -> actor.acts[ActType.Act9]
            "act10" -> actor.acts[ActType.Act10]
            "cx" -> actor.acts[ActType.ClimaxAct]
            // Basic info
            "alive" -> actor.isAlive
            "canCx" -> (actor.brilliance >= 100)
            "inCx" -> actor.inCX
            // Stats
            "hp" -> actor.hp
            "maxHp" -> actor.maxHp
            "brilliance" -> actor.brilliance
            // Buff stats
            "dex", "dexterity" -> actor.dexterity
            "hasApDown" -> (actor.apChange < 0)
            "hasNer" -> (actor.negativeEffectResist >= 100)
            "marked" -> actor.buffs.any(MarkBuff)
            else -> null
        }
        return when (ktVal) {
            null -> null // attribute not found
            is ActData -> ktVal.asCsAct(actor)
            is Boolean -> ktVal.asCsBoolean()
            is Number -> ktVal.asCsNumber()
            is String -> ktVal.asCsString()
            is CsObject -> ktVal
            else -> csError("internal error: attribute type not supported")
        }
    }
    override fun display() = actor.name
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
        "containsAll" -> CsFunction { args ->
            value.containsAll(requireActs(args)).asCsBoolean()
        }
        "containsAny" -> CsFunction { args ->
            requireActs(args).any { it in value }.asCsBoolean()
        }
        "size" -> CsNumber(value.size)
        else -> null
    }

    override fun bool() = value.isNotEmpty()
    override fun display() = value.toString()
}
