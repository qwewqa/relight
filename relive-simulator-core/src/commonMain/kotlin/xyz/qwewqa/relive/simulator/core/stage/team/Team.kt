package xyz.qwewqa.relive.simulator.core.stage.team

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.song.Song
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.StageEffectManager
import xyz.qwewqa.relive.simulator.core.stage.strategy.ActionTile
import xyz.qwewqa.relive.simulator.core.stage.strategy.Strategy

class Team(
    val actors: LinkedHashMap<String, Actor>,
    val guest: Actor? = null,
    val song: Song,
    val strategy: Strategy,
) {
  var cxTurns: Int = 0
    private set

  // Note that actors is sorted (or at least should be) front to back
  val active
    get() = actors.values.filter { it.isAlive }
  val anyAlive
    get() = active.isNotEmpty()

  val stageEffects = StageEffectManager(this)

  var queue: List<ActionTile> = emptyList()

  /**
   * If this is accessed in an act, it is the index of the next act that will be executed, excluding
   * the current act. This may point past the end of the queue, which means that there is no next
   * act.
   */
  var queueIndex: Int = 0

  val nextAct: ActionTile?
    get() = queue.getOrNull(queueIndex)

  fun finalizeTurnZero() {
    actors.values.forEach { it.initializeTurnZero() }
    guest?.initializeTurnZero()
  }

  fun enterCX() {
    if (cxTurns > 0) return
    cxTurns = 2
    active.filter { it.brilliance == 100 }.forEach { it.enterCX() }
  }

  fun endTurn() {
    if (cxTurns > 0) {
      cxTurns--
      if (active.none { it.inCX }) cxTurns = 0
      if (cxTurns == 0) {
        active.forEach { it.exitCX() }
      }
    }
    active.forEach { it.tick() }
    stageEffects.tick()
  }

  fun onActorExit(actor: Actor) {
    strategy.onExit(actor)
    stageEffects.invalidateTargets()
  }

  fun onActorEnter(actor: Actor) {
    strategy.onRevive(actor)
    stageEffects.invalidateTargets()
  }
}
