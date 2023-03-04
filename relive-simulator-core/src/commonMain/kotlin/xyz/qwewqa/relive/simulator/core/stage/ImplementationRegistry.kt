package xyz.qwewqa.relive.simulator.core.stage

interface FeatureImplementation {
  val id: Int?
}

class MissingImplementationException(val id: Int) : Exception("No implementation for $id")

abstract class ImplementationRegistry<T : FeatureImplementation> : Map<Int, T> {
  private val implementations = mutableMapOf<Int, T>()

  operator fun <U : T?> U.unaryPlus(): U {
    this?.id?.let { implementations[it] = this }
    return this
  }

  fun include(other: ImplementationRegistry<out T>) {
    implementations.putAll(other.implementations)
  }

  override operator fun get(key: Int): T? {
    return implementations[key].also { if (it == null) missingImplementation(key) }
  }

  open fun missingImplementation(id: Int) {}

  override val entries: Set<Map.Entry<Int, T>>
    get() = implementations.entries
  override val keys: Set<Int>
    get() = implementations.keys
  override val size: Int
    get() = implementations.size
  override val values: Collection<T>
    get() = implementations.values

  override fun isEmpty() = implementations.isEmpty()

  override fun containsValue(value: T) = implementations.containsValue(value)

  override fun containsKey(key: Int) = implementations.containsKey(key)
}
