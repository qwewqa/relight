package xyz.qwewqa.relive.simulator.core.stage

interface FeatureImplementation {
    val id: Int?
}

class MissingImplementationException(val id: Int) : Exception("No implementation for $id")

abstract class ImplementationRegistry <T : FeatureImplementation> {
    private val implementations = mutableMapOf<Int, T>()

    operator fun T.unaryPlus(): T {
        id?.let { implementations[it] = this }
        return this
    }

    fun include(other: ImplementationRegistry<T>) {
        implementations.putAll(other.implementations)
    }

    operator fun get(id: Int) = implementations[id] ?: throw MissingImplementationException(id)
}
