package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.StackedEffect
import xyz.qwewqa.relivesim.stage.strategy.ActionTile
import xyz.qwewqa.relivesim.stage.strategy.PrepareTile
import xyz.qwewqa.relivesim.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.math.max
import kotlin.random.Random

data class Stage(
    val player: Team,
    val opponent: Team,
    val damageCalculator: DamageCalculator = LoggingDamageCalculator(),
    val configuration: StageConfiguration = StageConfiguration(),
    val random: Random = Random.Default,
) {
    val logger = Logger()

    init {
        player.stageGirls.values.forEach {
            it.context = ActionContext(it, this, player, opponent)
        }
        player.friend?.let { it.context = ActionContext(it, this, player, opponent) }
        opponent.stageGirls.values.forEach {
            it.context = ActionContext(it, this, opponent, player)
        }
        opponent.friend?.let { it.context = ActionContext(it, this, opponent, player) }
    }

    var turn = 0
        private set

    fun run(turns: Int = 6) {
        log("Stage") { "Begin" }
        log("AutoEffect") { "Begin" }

        // TODO: sort by agility, auto effects first
        listOf(player.stageGirls.values, opponent.stageGirls.values).flatten().forEach { sg ->
            sg.loadout.autoEffects
                .filter { it.effectClass == EffectClass.Positive }
                .forEach {
                    log("AutoEffect") { "[$sg] auto effect $it activate" }
                    it.activate(sg.context)
                }
        }
        player.friend?.let {
            log("AutoEffect") { "[$it] auto effect ${it.loadout.data.unitSkill} activate" }
            it.loadout.data.unitSkill.activate(it.context)
        }
        opponent.friend?.let {
            log("AutoEffect") { "[$it] auto effect ${it.loadout.data.unitSkill} activate" }
            it.loadout.data.unitSkill.activate(it.context)
        }
        listOf(player.stageGirls.values, opponent.stageGirls.values).flatten().forEach { sg ->
            sg.loadout.autoEffects
                .filter { it.effectClass == EffectClass.Negative }
                .forEach {
                    log("AutoEffect") { "[$sg] auto effect $it activate" }
                    it.activate(sg.context)
                }
        }
        player.finalizeTurnZero()
        opponent.finalizeTurnZero()
        while (turn < turns) {
            turn++
            log("Turn") { "$turn" }
            val playerQueue = player.strategy.getQueue(this, player, opponent)
            val opponentQueue = opponent.strategy.getQueue(this, opponent, player)
            if (playerQueue.climax) player.enterCX()
            if (opponentQueue.climax) opponent.enterCX()
            val queueLength = max(playerQueue.tiles.size, opponentQueue.tiles.size)
            val playerTiles = playerQueue.tiles + List(queueLength - playerQueue.tiles.size) { PrepareTile }
            val opponentTiles = opponentQueue.tiles + List(queueLength - playerQueue.tiles.size) { PrepareTile }
            playerTiles.zip(opponentTiles).forEach { (a, b) ->
                when {
                    a is ActionTile && b is ActionTile -> {
                        val agilityA = a.stageGirl.agility.get().toInt()
                        val agilityB = b.stageGirl.agility.get().toInt()
                        when {
                            agilityA == agilityB -> {
                                if (random.nextDouble() < 0.5) {
                                    a.execute()
                                    b.execute()
                                } else {
                                    b.execute()
                                    a.execute()
                                }
                            }
                            agilityA > agilityB -> {
                                a.execute()
                                b.execute()
                            }
                            agilityB > agilityA -> {
                                b.execute()
                                a.execute()
                            }
                        }
                    }
                    a is ActionTile -> {
                        a.execute()
                    }
                    b is ActionTile -> {
                        b.execute()
                    }
                }
            }
            listOf(player.stageGirls.values, opponent.stageGirls.values).flatten().forEach { sg ->
                sg.effects.tick(EffectClass.Positive)
            }
            listOf(player.stageGirls.values, opponent.stageGirls.values).flatten().forEach { sg ->
                sg.effects.tick(EffectClass.Negative)
            }
            player.endTurn()
            opponent.endTurn()
        }
        print(logger)
    }

    fun hit(
        attacker: StageGirl,
        target: StageGirl,
        modifier: Percent,
        hitCount: Int,
        overrideAttribute: Attribute? = null,
    ) {
        log("Hit") { "[${attacker.loadout.data.displayName}] attempts to hit [${target.loadout.data.displayName}]" }
        val result = damageCalculator.calculate(this, attacker, target, modifier, hitCount, overrideAttribute)
        if (target.effects.get(StackedEffect.Evade) > 0) {
            target.effects.removeStacked(StackedEffect.Evade)
            if (!(attacker.perfectAimCounter > 0)) {
                log("Hit") { "Miss from Evade" }
            }
        }
        if (random.nextDouble() < result.hitChance) {
            val n = random.nextInt(-8, 9)
            val isCritical = random.nextDouble() < result.criticalChance
            val damage = if (isCritical) {
                (result.critical * (100.percent + n.percent)).toInt()

            } else {
                (result.base * (100.percent + n.percent)).toInt()
            }
            val reflect = when (attacker.loadout.data.damageType) {
                DamageType.Normal -> target.normalReflect.get()
                DamageType.Special -> target.specialReflect.get()
                DamageType.NeutralDamage -> 0.percent
            }
            log("Hit") { "Damage roll: $damage (critical: $isCritical, varianceRoll: $n)" }
            val reflected = (damage * reflect).toInt()
            val unreflected = damage - reflected
            if (reflected > 0) log("Hit") { "Unreflected: $unreflected, Reflected: $reflected" }
            damage(target, unreflected)
            if (reflected > 0) {
                damage(attacker, reflected)
            }
        } else {
            log("Hit") { "Miss" }
        }
    }

    fun damage(target: StageGirl, amount: Int) {
        val newHp = (target.currentHP - amount).coerceAtLeast(0)
        log("Damage") { "[$target] damaged $amount (prevHp: ${target.currentHP}, newHp: $newHp)" }
        target.currentHP = newHp
        if (newHp == 0) {
            log("Exit") { "[$target] has exited" }
        }
    }

    fun heal(target: StageGirl, amount: Int) {
        log("Heal") {
            "[$target] healed $amount (prevHp: ${target.currentHP}, newHp: ${
                (target.currentHP + amount).coerceAtMost(target.maxHp.get().toInt())
            })"
        }
        target.currentHP += amount
        target.currentHP = target.currentHP.coerceAtMost(target.maxHp.get().toInt())
    }

    fun addBrilliance(target: StageGirl, amount: Int) {
        log("Brilliance") {
            "[$target] brilliance change $amount (prevBril: ${target.currentBrilliance}, newBril: ${
                (target.currentBrilliance + amount).coerceIn(0, 100)
            })"
        }
        target.currentBrilliance += amount
        target.currentBrilliance = target.currentBrilliance.coerceIn(0, 100)
    }
}

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(tag: String = "", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(tag, value())
    }
}
