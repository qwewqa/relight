package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.gen.GenBuff
import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.gen.valuesGenBuff
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier

/*
Act Power Up : 1
Act Power Down : 2
Normal Defense Up : 3
Normal Defense Down : 4
Special Defense Up : 5
Special Defense Down : 6
Agility Up : 7
Agility Down : 8
Accuracy Up : 9
Accuracy Down : 10
Evasion Up : 11
Evasion Down : 12
Dexterity Up : 13
Dexterity Down : 14
Critical Up : 15
Critical Down : 16
Max HP Up : 17
Max HP Down : 18
Cont. Neg. Effects Resistance Up : 19
Cont. Neg. Effects Resistance Down : 20
毎ターンHP回復 : 21
毎ターンキラめき回復 : 22
Normal Barrier : 23
Special Barrier : 24
Reflect Normal Dmg : 25
Reflect Special Dmg : 26
Evasion : 27
Perfect Aim : 28
Fortitude : 29
Fixed Normal Defense Boost : 30
Fixed Special Defense Boost : 31
Effective Element Dmg Up : 32
Climax Act Power Up : 33
Critical Dmg Received Down : 34
Fixed Act Power Boost : 35
Absorb : 37
Counter Heal : 38
Bonus Flower Dmg vs. xxxx : 39
Bonus Wind Dmg vs. xxxx : 40
Bonus Snow Dmg vs. xxxx : 41
Bonus Moon Dmg vs. xxxx : 42
Bonus Space Dmg vs. xxxx : 43
Bonus Cloud Dmg vs. xxxx : 44
Bonus Dream Dmg vs. xxxx : 45
Bonus Dmg vs. Boss : 46
Poison : 47
Burn : 48
Provoke : 49
Stun : 50
Sleep : 51
Confusion : 52
Stop : 53
Freeze : 54
Blindness : 55
HP Recovery Reduction : 58
Flower Dmg Received Down : 59
Wind Dmg Received Down : 60
Snow Dmg Received Down : 61
Moon Dmg Received Down : 62
Space Dmg Received Down : 63
Cloud Dmg Received Down : 64
Dream Dmg Received Down : 65
Flower Dmg Up : 66
Wind Dmg Up : 67
Snow Dmg Up : 68
Moon Dmg Up : 69
Space Dmg Up : 70
Cloud Dmg Up : 71
Dream Dmg Up : 72
Action Restriction Resistance (Auto) : 73
Action Restriction Resistance : 74
Poison Resistance : 75
Burn Resistance : 76
Provoke Resistance : 77
Stun Resistance : 78
Sleep Resistance : 79
Confusion Resistance : 80
Stop Resistance : 81
Freeze Resistance : 82
Blindness Resistance : 83
Recovery Reduction Resistance : 84
Anti-Soldier : 85
Anti-Lancer : 86
Anti-Fencer : 87
Anti-Magician : 88
Anti-Shielder : 89
Anti-Gunner : 90
Anti-Joker : 91
Anti-Beast : 92
Anti-??? : 93
Anti-Material : 94
Dmg Dealt Up : 95
Dmg Dealt Down : 96
Dmg Received Up : 97
Dmg Received Down : 98
Marked : 99
Marked (Flip) : 100
Aggro : 101
Aggro Resistance : 102
Exit Evasion : 103
Invincible : 104
AP Down : 105
AP増加 : 106
AP Up Resistance : 107
(Unremovable) AP Up : 110
(Unremovable) Stun : 111
(Unremovable) HP Regen : 112
(Unremovable) Stop : 113
(Unremovable) Counter Heal : 114
全バフ・デバフ耐性 : 117
Marked Resistance : 118
Event Boss Dmg Reduction : 119
ACT1封印 : 120
ACT2封印 : 121
ACT3封印 : 122
ACT1封印耐性 : 123
ACT2封印耐性 : 124
ACT3封印耐性 : 125
Brilliance Recovery Reduction : 126
Brilliance Recovery Reduction Resistance : 127
(Unremovable) Poison Resistance : 128
(Unremovable) Burn Resistance : 129
(Unremovable) Stun Resistance : 130
(Unremovable) Sleep Resistance : 131
(Unremovable) Confusion Resistance : 132
(Unremovable) Stop Resistance : 133
(Unremovable) Freeze Resistance : 134
(Unremovable) Blindness Resistance : 135
Act Change (Times) : 136
Act Change (Turn) : 137
(Unremovable) Confusion : 138
Resilience : 139
(Unremovable) Apply Poison : 140
(Unremovable) Apply Burn : 141
(Unremovable) Apply Blindness : 142
(Unremovable) HP Recovery Reduction : 143
Cont. Dmg Resistance : 144
Strong Poison Resistance : 145
Heavy Burn Resistance : 146
Flower Dmg Received Up : 147
Wind Dmg Received Up : 148
Snow Dmg Received Up : 149
Moon Dmg Received Up : 150
Space Dmg Received Up : 151
Cloud Dmg Received Up : 152
Dream Dmg Received Up : 153
Flower Dmg dealt Down : 154
Wind Dmg dealt Down : 155
Snow Dmg dealt Down : 156
Moon Dmg dealt Down : 157
Space Dmg dealt Down : 158
Cloud Dmg dealt Down : 159
Dream Dmg dealt Down : 160
Climax Act Power Down : 161
Lovesickness : 162
(Unremovable) Lovesickness : 163
Lovesickness Resistance : 164
(Unremovable) Lovesickness Resistance : 165
(Unremovable) Cont. Neg. Effects Resistance : 166
Seal CA : 167
(Unremovable) Seal CA : 168
Electric Shock : 169
(Unremovable) Electric Shock : 170
Electric Shock Resistance : 171
(Unremovable) Electric Shock Resistance : 172
Revive : 173
Nightmare : 174
Cont. Pos. Effects Immunity : 175
(Unremovable) Cont. Pos. Effects Immunity : 176
Pos. Effects Immunity : 177
(Unremovable) Pos. Effects Immunity : 178
Daze : 179
Impudence : 180
Hope : 181
Weak Spot : 182
Fixed Agility Boost : 183
Fixed Max HP Boost : 184
Frostbite : 185
Dmg to Seisho Stage Girls Up : 186
Dmg to Rinmeikan Stage Girls Up : 187
Dmg to Frontier Stage Girls Up : 188
Dmg to Siegfeld Stage Girls Up : 189
Dmg to Seiran Stage Girls Up : 190
Dmg Received from Karen Aijo Up : 191
Dmg Received from Hikari Kagura Up : 192
Dmg Received from Mahiru Tsuyuzaki Up : 193
Dmg Received from Claudine Saijo Up : 194
Dmg Received from Maya Tendo Up : 195
Dmg Received from Junna Hoshimi Up : 196
Dmg Received from Nana Daiba Up : 197
Dmg Received from Futaba Isurugi Up : 198
Dmg Received from Kaoruko Hanayagi Up : 199
Dmg Received from Tamao Tomoe Up : 200
Dmg Received from Ichie Otonashi Up : 201
Dmg Received from Fumi Yumeoji Up : 202
Dmg Received from Rui Akikaze Up : 203
Dmg Received from Yuyuko Tanaka Up : 204
Dmg Received from Aruru Otsuki Up : 205
Dmg Received from Misora Kano Up : 206
Dmg Received from Lalafin Nonomiya Up : 207
Dmg Received from Tsukasa Ebisu Up : 208
Dmg Received from Shizuha Kocho Up : 209
Dmg Received from Akira Yukishiro Up : 210
Dmg Received from Michiru Otori Up : 211
Dmg Received from Liu Mei Fan Up : 212
Dmg Received from Shiori Yumeoji Up : 213
Dmg Received from Yachiyo Tsuruhime Up : 214
Dmg Received from Koharu Yanagi Up : 215
Dmg Received from Suzu Minase Up : 216
Dmg Received from Hisame Honami Up : 217
Agony : 218
(Unremovable) Aggro : 219
(Unremovable) Seal Act 1 : 220
(Unremovable) Seal Act 2 : 221
(Unremovable) Seal Act 3 : 222
(Unremovable) Normal Barrier : 223
(Unremovable) Special Barrier : 224
Possession : 225
(Unremovable) Possession : 226
(Unremovable) AP Down : 227
(Unremovable) Critical Up : 228
Curtains Closed : 229
(Unremovable) Curtains Closed : 230
Count. Neg. Effects Resistance : 231
(Unremovable) Count. Neg. Effects Resistance : 232
Brilliance Recovery Increase : 233
(Unremovable) Resilience : 234
AP Up 2 : 235
(Unremovable) AP Up 2 : 236
AP Down 2 : 237
(Unremovable) AP Down 2 : 238
Shorten Instant Skill Turn Activation : 239
Counter Heal : 240
Hold Back : 241
Seal Stage Effect : 242
(Unremovable) Seal Stage Effect : 243
Adds Acts 1 : 244
Adds Acts 2 : 245
Bulkhead : 246
Anti-Oath Revue : 247
Disaster [Brilliance Reduction] : 248
Blessing [HP Recovery] : 249
Blessing [Count. Neg. Effects Reduction] : 250
Disaster [Daze] : 251
Blessing [Dispel Cont. Neg. Effects] : 252
Daze Resistance : 253
(Unremovable) Daze Resistance : 254
Blessing [Hope] : 255
Impudence Resistance : 256
(Unremovable) Impudence Resistance : 257
Super Reflect Normal Dmg : 258
Super Reflect Special Dmg : 259
(Unremovable) Super Reflect Normal Dmg : 260
(Unremovable) Super Reflect Special Dmg : 261
Blessing [Effective Element Dmg Up] : 262
Invincible Rebirth : 263
Sacrifice : 264
Disaster [AP Up] : 265
Blessing [AP Down 2] : 266
Contraction : 267
HP Regen : 268
Seal Instant Skill : 269
(Unremovable) Seal Instant Skill : 270
Count. Pos. Effects Resistance Up : 271
(Unremovable) Count. Pos. Effects Resistance Up : 272
(Unremovable) Perfect Aim : 273
Act Power Up when Max HP : 274
Overwhelm : 275
Multiple CA-fication : 276
Brilliance Sap : 277
Effective Element Dmg Up : 278
(解除不可)毎ターンキラめき回復 : 279
毎ターン起死回生付与 : 280
(Unremovable) Invincible : 281
Seal Stage Effect Resistance Up : 282
(解除不可)舞台効果付与封印耐性アップ : 283
毎ターン継続マイナス効果解除 : 284
(解除不可)毎ターン継続マイナス効果解除 : 285
毎ターン回数マイナス効果解除 : 286
(解除不可)毎ターン回数マイナス効果解除 : 287
毎ターン継続プラス効果解除 : 288
(解除不可)毎ターン継続プラス効果解除 : 289
怪力 : 290
毎ターン怪力付与 : 292
(解除不可)毎ターン怪力付与 : 293
エール : 294
毎ターン回数マイナス効果減少 : 297
(解除不可)毎ターン回数マイナス効果減少 : 298
 */

data class BuffData(
    val name: String,
    val iconId: Int,
    val locked: Boolean,
) {
    // change this to use an object declaration instead of SimpleTimedBuffEffect
    inline fun <T> makeTimedBuffEffect(
        category: BuffCategory,
        locked: Boolean = this.locked,
        exclusive: Boolean = false,
        crossinline flipped: () -> TimedBuffEffect<*>? = { null },
        related: TimedBuffEffect<Unit>? = null,
        crossinline onStart: ActionContext.(value: Int, source: Actor?) -> T,
        crossinline onEnd: ActionContext.(value: Int, source: Actor?, T) -> Unit,
    ): TimedBuffEffect<T> = object : TimedBuffEffect<T> {
        override val name: String = this@BuffData.name
        override val iconId: Int = this@BuffData.iconId
        override val category: BuffCategory = category
        override val isLocked: Boolean = locked
        override val exclusive: Boolean = exclusive
        override val displayLockIcon: Boolean = this@BuffData.locked
        override val flipped get() = flipped()
        override val related get() = related

        override fun onStart(context: ActionContext, value: Int, source: Actor?): T {
            return context.onStart(value, source)
        }

        override fun onEnd(context: ActionContext, value: Int, source: Actor?, data: T) {
            context.onEnd(value, source, data)
        }
    }

    inline fun makeIdempotentTimedBuffEffect(
        category: BuffCategory,
        locked: Boolean = this.locked,
        exclusive: Boolean = false,
        crossinline flipped: () -> TimedBuffEffect<*>? = { null },
        related: TimedBuffEffect<Unit>? = null,
        crossinline onStart: ActionContext.() -> Unit,
        crossinline onEnd: ActionContext.() -> Unit,
    ): TimedBuffEffect<Unit> = object : TimedBuffEffect<Unit> {
        override val name: String = this@BuffData.name
        override val iconId: Int = this@BuffData.iconId
        override val category: BuffCategory = category
        override val isLocked: Boolean = locked
        override val exclusive: Boolean = exclusive
        override val displayLockIcon: Boolean = this@BuffData.locked
        override val flipped get() = flipped()
        override val related get() = related

        override fun onStart(context: ActionContext, value: Int, source: Actor?) {
            if (this !in context.self.buffs) {
                context.onStart()
            }
        }

        override fun onEnd(context: ActionContext, value: Int, source: Actor?, data: Unit) {
            if (this !in context.self.buffs) {
                context.onEnd()
            }
        }
    }

    inline fun makeModifierTimedBuffEffect(
        modifier: Modifier,
        category: BuffCategory,
        locked: Boolean = this.locked,
        exclusive: Boolean = false,
        crossinline flipped: () -> TimedBuffEffect<*>? = { null },
        related: TimedBuffEffect<Unit>? = null,
    ): TimedBuffEffect<Unit> = makeTimedBuffEffect(
        category = category,
        locked = locked,
        exclusive = exclusive,
        flipped = flipped,
        related = related,
        onStart = { value, _ ->
            self.mod { modifier += value }
        },
    ) { value, _, _ ->
        self.mod { modifier -= value }
    }

    inline fun makeSimpleTimedBuffEffect(
        category: BuffCategory,
        locked: Boolean = this.locked,
        exclusive: Boolean = false,
        crossinline flipped: () -> TimedBuffEffect<*>? = { null },
        related: TimedBuffEffect<Unit>? = null,
        crossinline onStart: ActionContext.(value: Int) -> Unit = { _ -> },
        crossinline onEnd: ActionContext.(value: Int) -> Unit = { _ -> },
    ): TimedBuffEffect<Unit> = makeTimedBuffEffect(
        category = category,
        locked = locked,
        exclusive = exclusive,
        flipped = flipped,
        related = related,
        onStart = { value, _ -> onStart(value) },
        onEnd = { value, _, _ -> onEnd(value) },
    )

    fun makeLockedVariantOf(related: TimedBuffEffect<Unit>) = makeSimpleTimedBuffEffect(
        category = related.category,
        locked = true,
        exclusive = related.exclusive,
        related = related,
    )

    fun makeCountableBuffEffect(
        category: BuffCategory,
    ): CountableBuffEffect = SimpleCountableBuffEffect(
        name = name,
        iconId = iconId,
        category = category,
    )
}

fun GenBuff.toBuffData() = BuffData(
    name = name.getLocalizedString(),
    iconId = icon_id,
    locked = is_lock != 0,
)

val buffData = valuesGenBuff.mapValues { it.value.toBuffData() }

fun buffData(id: Int) = buffData[id] ?: error("No buff data for $id")
fun buffDataOrNull(id: Int) = buffData[id]
