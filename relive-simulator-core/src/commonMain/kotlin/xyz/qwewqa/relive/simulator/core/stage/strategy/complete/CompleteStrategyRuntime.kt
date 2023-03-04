package xyz.qwewqa.relive.simulator.core.stage.strategy.complete

import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.BuffManager
import xyz.qwewqa.relive.simulator.core.stage.buff.MarkBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.apChange
import xyz.qwewqa.relive.simulator.core.stage.modifier.dexterity
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeEffectResistanceUp
import xyz.qwewqa.relive.simulator.core.stage.strategy.BoundCutin

data class CsContext(
    val variables: MutableMap<String, CsValue> =
        mutableMapOf(
            "true" to CsConstantDescriptor(CsBoolean.TRUE),
            "false" to CsConstantDescriptor(CsBoolean.FALSE),
            "nil" to CsConstantDescriptor(CsNil),
        ),
)

fun CsContext.addFunction(name: String, func: (List<CsObject>) -> CsObject) {
  variables[name] = CsFunction(func)
}

fun CsContext.bindValue(name: String, accessor: () -> CsObject) {
  variables[name] = CsReadOnlyDescriptor(accessor)
}

open class CsRuntimeException(message: String, cause: Throwable? = null) :
    RuntimeException(message, cause)

class AnnotatedCsRuntimeException(message: String, cause: Throwable? = null) :
    CsRuntimeException(message, cause)

fun csError(message: String, cause: Throwable? = null): Nothing {
  throw CsRuntimeException(message, cause)
}

sealed interface CsValue

fun CsValue.getValue(context: CsContext) =
    when (this) {
      is CsObject -> this
      is CsDescriptor -> getValue(context)
    }

interface CsObject : CsValue {
  fun getAttribute(name: String): CsObject? = null
  fun invoke(arguments: List<CsObject>): CsObject = csError("Invoke not supported.")
  fun bool(): Boolean = true
  fun display(): String = toString()
}

interface CsDescriptor : CsValue {
  fun getValue(context: CsContext): CsObject
  fun setValue(value: CsValue, context: CsContext) {
    csError("Value is read-only.")
  }
}

data class CsConstantDescriptor(val value: CsObject) : CsDescriptor {
  override fun getValue(context: CsContext) = value
}

class CsReadOnlyDescriptor(val accessor: () -> CsObject) : CsDescriptor {
  override fun getValue(context: CsContext) = accessor()
}

operator fun CsObject.get(name: String) =
    getAttribute(name) ?: csError("Attribute $name not found.")

object CsNil : CsObject {
  override fun bool() = false
  override fun display() = "nil"
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
  TRUE(true),
  FALSE(false);

  override fun bool() = value
  override fun display() = value.toString()
}

data class CsFunction(val value: (List<CsObject>) -> CsObject) : CsObject {
  override fun invoke(arguments: List<CsObject>) = value(arguments)
}

class CsActor(val actor: Actor) : CsObject {
  override fun getAttribute(name: String): CsObject? {
    val ktVal: Any? =
        when (name) {
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
          "cutin" -> actor.cutin?.let { CsCutin(it) }
          // Basic info
          "alive" -> actor.isAlive
          "canCx" -> (actor.brilliance >= 100)
          "inCx" -> actor.inCX
          // Stats
          "hp" -> actor.hp
          "maxHp" -> actor.maxHp
          "brilliance" -> actor.brilliance
          // Buff stats
          "dex",
          "dexterity" -> actor.mod { +dexterity }
          "hasApDown" -> (actor.mod { apChange } < 0)
          "hasNer" -> (actor.mod { +negativeEffectResistanceUp } >= 100)
          "marked" -> MarkBuff in actor.buffs
          "buffs" ->
              CsFunction { args ->
                if (args.isEmpty()) {
                  CsList(actor.buffs.effectNameMapping.keys.map { it.asCsString() })
                } else {
                  val buffName =
                      (args.singleOrNull() as? CsString)?.value
                          ?: csError("Expected a single string argument.")
                  val buffEffect = actor.buffs.effectNameMapping[buffName]
                  if (buffEffect != null) {
                    CsBuffList(actor.buffs.get(buffEffect).map { CsActiveBuff((it)) })
                  } else {
                    CsBuffList(emptyList())
                  }
                }
              }
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

data class CsCutin(val cutin: BoundCutin) : CsObject {
  override fun getAttribute(name: String) =
      when (name) {
        "cost" -> cutin.data.cost.asCsNumber()
        else -> null
      }

  override fun display() = "${cutin.actor.name} [cutin]"
}

data class CsAct(val actor: Actor, val act: ActData) : CsObject, Comparable<CsAct> {
  override fun getAttribute(name: String) =
      when (name) {
        "cost" -> apCost.asCsNumber()
        else -> null
      }

  val apCost
    get() = (act.apCost + actor.mod { apChange }).coerceAtLeast(1)

  val sortPriority
    get() = run {
      var v = apCost
      if (act.type == ActType.ClimaxAct) v += 10
      v
    }

  override fun compareTo(other: CsAct): Int {
    return sortPriority.compareTo(other.sortPriority)
  }

  override fun display(): String {
    return "[${actor.dress.name} (${actor.name})]:[${act.name}](${act.type.name})"
  }
}

data class CsQueuedAct(val act: CsAct, val tile: Int, val cost: Int) : CsObject {
  override fun getAttribute(name: String) =
      when (name) {
        "cost" -> cost.asCsNumber()
        "tile" -> tile.asCsNumber()
        "act" -> act
        else -> null
      }

  override fun display() = "${act.display()}(tile: $tile, cost: $cost)"
}

fun ActData.asCsAct(actor: Actor) = CsAct(actor, this)

open class CsList(val value: List<CsObject>) : CsObject {
  override fun invoke(arguments: List<CsObject>): CsObject {
    val arg =
        (arguments.singleOrNull() ?: csError("Expected one argument.")).number().let {
          if (it % 1.0 != 0.0) csError("Expected an integer argument.")
          it.toInt()
        }
    if (arg !in value.indices) csError("Index out of bounds.")
    return value[arg]
  }

  override fun getAttribute(name: String) =
      when (name) {
        "contains" ->
            CsFunction { args ->
              val arg = args.singleOrNull() ?: csError("Expected one argument.")
              (arg in value).asCsBoolean()
            }
        "containsAll" -> CsFunction { args -> value.containsAll(requireActs(args)).asCsBoolean() }
        "containsAny" -> CsFunction { args -> requireActs(args).any { it in value }.asCsBoolean() }
        "count" ->
            CsFunction { args ->
              val acts = requireActs(args)
              value.count { it in acts }.asCsNumber()
            }
        "size" -> CsNumber(value.size.toDouble())
        else -> null
      }

  override fun bool() = value.isNotEmpty()
  override fun display() =
      when (value.size) {
        0 -> "[]"
        1 -> "[${value.single().display()}]"
        else -> "[\n${value.joinToString(",\n") { it.display().prependIndent("    ") }}\n]"
      }

  override fun equals(other: Any?): Boolean {
    return other is CsList && value == other.value
  }

  override fun hashCode(): Int {
    return value.hashCode()
  }
}

data class CsActiveBuff(val buff: BuffManager.TimedBuff<*>) : CsObject {
  override fun getAttribute(name: String): CsObject? =
      when (name) {
        "turns" -> buff.turns.asCsNumber()
        "value" -> buff.value.asCsNumber()
        "name" -> buff.effect.name.asCsString()
        else -> null
      }

  override fun display() = buff.toString()
}

class CsBuffList(private val buffs: List<CsActiveBuff>) : CsList(buffs) {
  // Note: ephemeral buffs are currently counted the same as normal buffs.
  // It may be worth revisiting this in the future if this ends up posing a problem.

  private val values by lazy { CsList(buffs.map { it.buff.value.asCsNumber() }) }
  private val turns by lazy { CsList(buffs.map { it.buff.turns.asCsNumber() }) }
  private val totalValue by lazy { buffs.sumOf { it.buff.value }.asCsNumber() }
  private val maxTurns by lazy {
    (buffs.maxOfOrNull { it.buff.turns } ?: 0).coerceAtLeast(0).asCsNumber()
  }

  override fun getAttribute(name: String) =
      when (name) {
        "values" -> values
        "turns" -> turns
        "totalValue" -> totalValue
        "maxTurns" -> maxTurns
        else -> super.getAttribute(name)
      }
}
