package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import org.khronos.webgl.get
import org.w3c.dom.*
import org.w3c.files.Blob
import xyz.qwewqa.relive.simulator.common.PlayerLoadoutParameters
import xyz.qwewqa.relive.simulator.common.SimulationOptions
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SongEffectParameter
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

const val DRESS_WIDTH = 144.0
const val DRESS_HEIGHT = 160.0
const val PADDING_X = 6.0
const val MARGIN_TOP = 6.0
const val SUPERSCALE = 2.0
const val FONT =
    "system-ui, -apple-system, \"Segoe UI\", Roboto, \"Helvetica Neue\", \"Noto Sans\", \"Liberation Sans\", Arial, sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\", \"Noto Color Emoji\""

fun downloadDataUrl(url: String) {
    val anchor = document.createElement("a") as HTMLAnchorElement
    anchor.download = "team.png"
    anchor.href = url
    anchor.click()
}

class TeamImage(
    val parameters: SimulationParameters,
    val options: SimulationOptions,
) {
    private val team = parameters.team
    private val canvas = document.createElement("canvas") as HTMLCanvasElement
    private val ctx = canvas.getContext("2d") as CanvasRenderingContext2D

    suspend fun drawTeamImage(): HTMLCanvasElement {
        canvas.width = ((team.size * (DRESS_WIDTH + PADDING_X) + PADDING_X) * SUPERSCALE).toInt()
        canvas.height = ((DRESS_HEIGHT + 56) * SUPERSCALE).toInt()
        ctx.scale(SUPERSCALE, SUPERSCALE)

        ctx.withState {
            ctx.fillStyle = "white"
            ctx.fillRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
        }

        team.reversed().forEachIndexed { i, loadout ->
            ctx.withState {
                ctx.translate((i * (DRESS_WIDTH + PADDING_X) + PADDING_X), MARGIN_TOP)
                drawDress(loadout)
            }
        }

        return canvas
    }

    suspend fun drawOpenGraphImage(): HTMLCanvasElement {
        canvas.width = 1200
        canvas.height = 600

        ctx.withState {
            ctx.fillStyle = "white"
            ctx.fillRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
        }

        ctx.withState {
            ctx.font = "bold 36px $FONT"
            ctx.fillStyle = "black"
            ctx.textBaseline = CanvasTextBaseline.TOP
            ctx.fillText("Boss: ", 20.0, 22.0)
            withState {
                val offset = ctx.measureText("Boss: ").width
                ctx.font = "36px $FONT"
                ctx.fillText(parameters.boss, 20.0 + offset, 22.0)
            }
            ctx.fillText("Song:", 20.0, 416.0)
            withState {
                ctx.font = "32px $FONT"
                val effect1 = parameters.song.activeEffects.getOrElse(0) { null }
                val effect2 = parameters.song.activeEffects.getOrElse(1) { null }
                val effect3 = parameters.song.passiveEffect
                ctx.fillText("Effect 1: ${effect1.format()}", 20.0, 462.0)
                ctx.fillText("Effect 2: ${effect2.format()}", 20.0, 462.0 + 42.0)
                ctx.fillText("Effect 3: ${effect3.format()}", 20.0, 462.0 + 84.0)
            }
        }

        ctx.withState {
            ctx.translate(10.0, 64.0)
            val scaleFactor = (canvas.width - 20.0) / (team.size.coerceAtLeast(5) * (DRESS_WIDTH + PADDING_X) + PADDING_X)
            scale(scaleFactor, scaleFactor)
            team.reversed().forEachIndexed { i, loadout ->
                ctx.withState {
                    ctx.translate((i * (DRESS_WIDTH + PADDING_X) + PADDING_X), MARGIN_TOP)
                    drawDress(loadout)
                }
            }
        }

        return canvas
    }

    fun toDataURL(): String = canvas.toDataURL()
    fun toByteArray(): ByteArray {
        val data = ctx.getImageData(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble()).data
        return ByteArray(data.length) { i -> data[i] }
    }

    val width: Int get() = canvas.width
    val height: Int get() = canvas.height

    private fun SongEffectParameter?.format() = if (this == null) {
        "None"
    } else {
        "$name $value ${conditions.joinToString(" ") { cs -> "[${cs.joinToString(" | ")}]" }}"
    }

    private val PlayerLoadoutParameters.hasAccessory get() = accessory != null && accessory != "None"

    private suspend fun drawDress(loadout: PlayerLoadoutParameters) {
        withState {
            rect(width = DRESS_WIDTH, height = DRESS_HEIGHT).run {
                drawImage(options.dressesById[loadout.dress]?.imagePath)

                val memoirPosition = RelativePosition(right = 2.percent, bottom = 2.percent).withWidth(48.percent)
                drawImage(options.memoirsById[loadout.memoir]?.imagePath, memoirPosition)
                drawImage(getMemoirUnbindImagePath(loadout.memoirLimitBreak), memoirPosition)

                if (loadout.hasAccessory) {
                    val accessoryPosition = RelativePosition(right = 2.percent, top = 2.percent).withHeight(38.percent)
                    drawImage(options.accessoriesById[loadout.accessory]?.imagePath, accessoryPosition)
                    drawImage(getAccessoryUnbindImagePath(loadout.accessoryLimitBreak), accessoryPosition)
                }

                val remakePosition = RelativePosition(bottom = 23.percent, left = 5.percent).withWidth(16.percent)
                drawImage(getRemakeLevelVerticalImagePath(loadout.remake), remakePosition)

                withState {
                    withState {
                        val position = RelativePosition(left = 6.percent, top = 4.percent)
                        textAlign = CanvasTextAlign.START
                        textBaseline = CanvasTextBaseline.TOP
                        font = "bold 26px $FONT"
                        fillStyle = "indigo"
                        val (x, y) = resolvePointPosition(position)
                        fillGlowText(loadout.unitSkillLevel.toString(), x, y)
                    }
                    if (loadout.hasAccessory) {
                        withState {
                            val position = RelativePosition(right = 6.percent, top = 5.percent)
                            textAlign = CanvasTextAlign.END
                            textBaseline = CanvasTextBaseline.TOP
                            font = "bold 26px $FONT"
                            fillStyle = "darkgoldenrod"
                            val (x, y) = resolvePointPosition(position)
                            fillGlowText(loadout.accessoryLevel.toString(), x, y)
                        }
                    }
                    withState {
                        val position = RelativePosition(left = 5.percent, bottom = 2.percent)
                        textAlign = CanvasTextAlign.START
                        textBaseline = CanvasTextBaseline.BOTTOM
                        font = "bold 30px $FONT"
                        fillStyle = "darkred"
                        val (x, y) = resolvePointPosition(position)
                        fillGlowText(loadout.level.toString(), x, y)
                    }
                    withState {
                        val position = RelativePosition(right = 5.percent, bottom = 2.percent)
                        textAlign = CanvasTextAlign.END
                        textBaseline = CanvasTextBaseline.BOTTOM
                        font = "bold 30px $FONT"
                        fillStyle = "darkblue"
                        val (x, y) = resolvePointPosition(position)
                        fillGlowText(loadout.memoirLevel.toString(), x, y)
                    }
                }
            }
            rect(x = DRESS_WIDTH / 2, y = DRESS_HEIGHT + 20.0, width = DRESS_WIDTH, height = 0.0).run {
                withState {
                    font = "bold 20px $FONT"
                    fillStyle = "black"
                    textAlign = CanvasTextAlign.CENTER
                    drawSingleLineText(loadout.name)
                }
            }
            if (loadout.remake == 4 && loadout.remakeSkill != null && loadout.remakeSkill != "None") {
                withState {
                    font = "14px $FONT"
                    val remakeSkill = options.remakeSkillsById[loadout.remakeSkill]
                    val desc = "${remakeSkill?.data?.value?.plus(" ") ?: ""}${remakeSkill?.data?.targeting ?: ""}"
                    val totalWidth = 20.0 + measureText(desc).width
                    rect(x = (DRESS_WIDTH - totalWidth) / 2, y = DRESS_HEIGHT + 28.0, width = DRESS_WIDTH, height = 16.0).run {
                        val iconPosition = RelativePosition.TopLeft.withHeight(100.percent)
                        drawImage(remakeSkill?.imagePath, iconPosition)
                        fillText(
                            desc,
                            x + 20.0,
                            y + 12.5
                        )
                    }
                }
            }
        }
    }

    private fun fillGlowText(text: String, x: Double, y: Double) {
        withState {
            shadowColor = "white"
            shadowBlur = 8.0
            repeat(8) {
                ctx.fillText(text, x, y)
            }
        }
        ctx.fillText(text, x, y)
    }

    private inline fun withState(block: CanvasRenderingContext2D.() -> Unit) {
        ctx.save()
        ctx.block()
        ctx.restore()
    }

    fun rect(x: Double = 0.0, y: Double = 0.0, width: Double, height: Double) = Rect(ctx, x, y, width, height)

    suspend fun Rect.drawImage(url: String?, position: RelativePosition = RelativePosition.TopLeft) {
        if (url == null) {
            return
        }
        val image = getImage(url)
        drawImage(image, position)
    }
}

class Rect(
    val ctx: CanvasRenderingContext2D,
    val x: Double = 0.0,
    val y: Double = 0.0,
    val width: Double,
    val height: Double,
) {
    fun drawImage(image: Image) {
        ctx.drawImage(image, x, y, width, height)
    }

    fun drawImage(image: Image, position: RelativePosition = RelativePosition.TopLeft) {
        val finalPosition = when {
            position.hasWidth && position.hasHeight -> position
            position.hasWidth -> position.withHeight(position.width / image.width * image.height * width / height)
            position.hasHeight -> position.withWidth(position.height / image.height * image.width * height / width)
            else -> position.withWidth(1.0).withHeight(1.0)
        }
        resolvePosition(finalPosition).drawImage(image)
    }

    fun drawSingleLineText(text: String) = ctx.withState {
        val baseTextWidth = measureText(text).width
        if (baseTextWidth < width) {
            fillText(text, x, y)
        } else {
            val ellipsis = "…"
            var shortenedText = text
            while (measureText(shortenedText + ellipsis).width > width && shortenedText.length > 1) {
                shortenedText = shortenedText.dropLast(1)
            }
            fillText(shortenedText + ellipsis, x, y)
        }
    }

    fun resolvePosition(position: RelativePosition) = Rect(
        ctx,
        x + width * (position.left ?: 0.0),
        y + height * (position.top ?: 0.0),
        width * position.width,
        height * position.height,
    )

    fun resolvePointPosition(position: RelativePosition): Point {
        val pointPosition = position.withWidth(0.0).withHeight(0.0)
        val rect = resolvePosition(pointPosition)
        return Point(rect.x, rect.y)
    }
}

data class RelativePosition(
    val left: Double? = null,
    val right: Double? = null,
    val top: Double? = null,
    val bottom: Double? = null,
) {
    val width get() = 1.0 - (left ?: 0.0) - (right ?: 0.0)
    val height get() = 1.0 - (top ?: 0.0) - (bottom ?: 0.0)

    val hasWidth get() = left != null && right != null
    val hasHeight get() = top != null && bottom != null

    fun withWidth(width: Double) = when {
        left != null -> copy(left = left, right = 1.0 - width - left)
        right != null -> copy(right = right, left = 1.0 - width - right)
        else -> copy(left = 0.5 - width / 2, right = 0.5 - width / 2)
    }

    fun withHeight(height: Double) = when {
        top != null -> copy(top = top, bottom = 1.0 - height - top)
        bottom != null -> copy(bottom = bottom, top = 1.0 - height - bottom)
        else -> copy(top = 0.5 - height / 2, bottom = 0.5 - height / 2)
    }

    companion object {
        val TopLeft = RelativePosition(left = 0.0, top = 0.0)
        val TopRight = RelativePosition(right = 0.0, top = 0.0)
        val BottomLeft = RelativePosition(left = 0.0, bottom = 0.0)
        val BottomRight = RelativePosition(right = 0.0, bottom = 0.0)
    }
}

data class Point(
    val x: Double,
    val y: Double,
)

val Int.percent get() = this / 100.0

suspend fun getImage(url: String): Image = suspendCoroutine { continuation ->
    val image = Image()
    image.onload = {
        continuation.resume(image)
    }
    image.src = url
}

suspend fun HTMLCanvasElement.getBlob() = suspendCoroutine { continuation ->
    toBlob({ blob ->
        continuation.resume(blob)
    })
}

@OptIn(ExperimentalContracts::class)
private inline fun CanvasRenderingContext2D.withState(block: CanvasRenderingContext2D.() -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    save()
    block()
    restore()
}
