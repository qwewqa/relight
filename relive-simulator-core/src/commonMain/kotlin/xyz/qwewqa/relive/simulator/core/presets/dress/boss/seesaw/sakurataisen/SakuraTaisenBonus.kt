package xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen

import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.ImperialCombatRevueFlowerDivisionSakura
import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.SakuraShingujiHikari
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower.NewYorkCombatRevueGemie
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon.ParisCombatRevueFlowerDivisionErika
import xyz.qwewqa.relive.simulator.core.stage.passive.EventBonusPassive
import xyz.qwewqa.relive.simulator.stage.character.Character

val sakuraTaisenBonusPassive =
    EventBonusPassive(
        dresses =
            mapOf(
                SakuraShingujiHikari.id to 500,
                NewYorkCombatRevueGemie.id to 200,
                ImperialCombatRevueFlowerDivisionSakura.id to 200,
                ParisCombatRevueFlowerDivisionErika.id to 200,
            ),
        characters =
            mapOf(
                Character.Karen to 50,
                Character.Hikari to 50,
                Character.Mahiru to 50,
            ))
