package xyz.qwewqa.relivesim.dsl

class Prototype<T, U : Builder<T>>(val factory: () -> U) {
    fun make() = factory().build()
    operator fun invoke() = make()
    inline operator fun invoke(unit: U.() -> Unit) = factory().apply(unit).build()
    operator fun plus(init: U.() -> Unit) = Prototype { factory().apply(init) }
}

val stageGirlPrototype = Prototype(::StageGirlBuilder)
val memoirPrototype = Prototype(::MemoirBuilder)
