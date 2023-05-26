package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.addClass
import kotlinx.dom.clear
import kotlinx.dom.removeClass
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.*
import xyz.qwewqa.relive.simulator.common.ActorStatus
import xyz.qwewqa.relive.simulator.common.InteractiveLogData
import xyz.qwewqa.relive.simulator.common.InteractiveQueueInfo
import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.common.LogEntry

val LogCategory.backgroundColor
  get() =
      when (this) {
        LogCategory.DEFAULT -> "#F5F5F5"
        LogCategory.EMPHASIS -> "#E8EAF6"
        LogCategory.WARNING -> "#FFF9C4"
        LogCategory.ERROR -> "#F8BBD0"
        LogCategory.DAMAGE -> "#FFEBEE"
        LogCategory.HEAL -> "#E8F5E9"
        LogCategory.BUFF -> "#E3F2FD"
        LogCategory.BRILLIANCE -> "#FFF8E1"
        LogCategory.USER -> "#E0F7FA"
        LogCategory.COMMAND -> "#ECEFF1"
        else -> "#FFFFFF"
      }

private var idCounter = 0

const val MAX_SIMULTANEOUS_BUFFS_DISPLAYED = 10
const val BUFF_DISPLAY_PERIOD = 4000

fun HTMLElement.displayStatus(data: InteractiveLogData) {
  var buffGroupIdCounter = 0
  data class AnimationData(
      val elementId: String,
      val keyframes: Array<dynamic>,
      val timing: dynamic
  )
  val animations = mutableListOf<AnimationData>()

  fun TagConsumer<HTMLElement>.buffElements(status: ActorStatus) {
    val buffs = status.displayBuffs
    val groups =
        if (buffs.isNotEmpty()) {
          buffs.chunked(MAX_SIMULTANEOUS_BUFFS_DISPLAYED)
        } else {
          listOf(emptyList())
        }
    div {
      style = "position: relative;"
      groups.forEachIndexed { i, group ->
        div("interactive-status-buffs-container") {
          if (groups.size > 1) {
            val keyframes =
                arrayOf(
                    jsObject { visibility = "hidden" },
                    jsObject {
                      visibility = "hidden"
                      offset = i / groups.size.toDouble()
                    },
                    jsObject {
                      visibility = "visible"
                      offset = i / groups.size.toDouble()
                    },
                    jsObject {
                      visibility = "visible"
                      offset = (i + 1) / groups.size.toDouble()
                    },
                    jsObject {
                      visibility = "hidden"
                      offset = (i + 1) / groups.size.toDouble()
                    },
                    jsObject { visibility = "hidden" },
                )
            val timing = jsObject {
              duration = groups.size * BUFF_DISPLAY_PERIOD
              iterations = js("Infinity")
            }
            val elementId = "interactive-status-buff-group-${buffGroupIdCounter++}"
            animations.add(AnimationData(elementId, keyframes, timing))
            id = elementId
            if (i > 0) {
              style = "position: absolute; bottom: 0; left: 0; width: 100%; height: 100%;"
            }
          }
          group.forEach { buffData ->
            div("interactive-status-buff") {
              div("interactive-status-buff-value") { +buffData.value.toString() }
              div("interactive-status-buff-image-container") {
                img(classes = "interactive-status-buff-img") {
                  src = "https://relight.qwewqa.xyz/img/buff_icon/buff_icon_${buffData.iconId}.png"
                }
                if (buffData.isLocked) {
                  img(classes = "interactive-status-buff-lock") {
                    src = "https://relight.qwewqa.xyz/img/buff_icon/buff_icon_lock.png"
                  }
                }
              }
            }
          }
          if (buffs.size > MAX_SIMULTANEOUS_BUFFS_DISPLAYED) {
            i("bi bi-three-dots interactive-status-more-buffs-icon") {}
          }
        }
      }
    }
  }

  val bossWidth =
      when (data.enemyStatus?.size) {
        1 -> "col-12"
        2 -> "col-12 col-md-6"
        3 -> "col-12 col-md-4"
        4 -> "col-12 col-md-6"
        5 -> "col-12 col-md-4"
        else -> "col-12 col-md-4"
      }
  val playerWidth =
      when (data.playerStatus?.size) {
        1 -> "col-12"
        2 -> "col-12 col-md-6"
        3 -> "col-12 col-md-4"
        4 -> "col-12 col-md-6"
        5 -> "col-12 col-md-4"
        else -> "col-12 col-md-4"
      }
  if (children.length == 2 &&
      children[0]?.children?.length == (data.enemyStatus?.size ?: 0) &&
      children[1]?.children?.length == (data.playerStatus?.size ?: 0)) {
    data.enemyStatus?.reversed()?.forEachIndexed { i, status ->
      val nameElement = document.getElementById("boss-name-$i") as HTMLParagraphElement
      val hpElement = document.getElementById("boss-hp-$i") as HTMLDivElement
      val hpLabelElement = document.getElementById("boss-hp-label-$i") as HTMLDivElement
      val buffsElement = document.getElementById("boss-buffs-$i") as HTMLDivElement
      nameElement.textContent = status.name
      hpElement.style.width = "${status.hp / status.maxHp * 100}%"
      if (status.hp > 0) {
        hpElement.textContent =
            "${status.hp}/${status.maxHp} (-${(status.maxHp - status.hp).formatShort()})"
        hpLabelElement.textContent =
            "${status.hp}/${status.maxHp} (-${(status.maxHp - status.hp).formatShort()})"
      } else {
        hpElement.textContent = ""
        hpLabelElement.textContent = ""
      }
      buffsElement.run {
        clear()
        append { buffElements(status) }
      }
    }
    val totalDamage = data.playerStatus?.sumOf { it.damageContribution } ?: 0.0
    data.playerStatus?.reversed()?.forEachIndexed { i, status ->
      val statusImageContainer =
          document.getElementById("player-status-image-container-$i") as HTMLDivElement
      val hpElement = document.getElementById("player-hp-$i") as HTMLDivElement
      val hpLabelElement = document.getElementById("player-hp-label-$i") as HTMLDivElement
      val brillianceElement = document.getElementById("player-brilliance-$i") as HTMLDivElement
      val brillianceLabelElement =
          document.getElementById("player-brilliance-label-$i") as HTMLDivElement
      val damageElement = document.getElementById("player-damage-$i") as HTMLDivElement
      val damageLabelElement = document.getElementById("player-damage-label-$i") as HTMLDivElement
      val buffsElement = document.getElementById("player-buffs-$i") as HTMLDivElement
      statusImageContainer.run {
        clear()
        onclick = {
          if (status.dressId > 0) {
            window.open("https://karth.top/dress/${status.dressId}?global=1", "_blank")
          }
        }
        append {
          img(classes = "interactive-status-actor-img") {
            src = "img/large_icon/1_${status.dressId}.png"
          }
          div(classes = "interactive-status-dex-counter") { +"${status.dexterity}" }
          if (status.isSupport) {
            img(classes = "interactive-status-support-indicator") {
              src = "img/common/icon_support_dress.png"
            }
          }
          if (status.inClimax) {
            i("bi bi-stars interactive-status-climaxing-icon") {}
          }
        }
      }
      hpElement.style.width = "${status.hp / status.maxHp * 100}%"
      brillianceElement.style.width = "${status.brilliance}%"
      damageElement.style.width =
          "${status.damageContribution / totalDamage.coerceAtLeast(1.0) * 100}%"
      if (status.hp > 0) {
        hpElement.textContent = "${status.hp}/${status.maxHp}"
        hpLabelElement.textContent = "${status.hp}/${status.maxHp}"
        brillianceElement.textContent = "${status.brilliance}"
        brillianceLabelElement.textContent = "${status.brilliance}"
      } else {
        hpElement.textContent = ""
        hpLabelElement.textContent = ""
        brillianceElement.textContent = ""
        brillianceLabelElement.textContent = ""
      }
      damageElement.textContent =
          if (status.damageContribution > 0) {
            "${status.damageContribution.formatShort()} (${(status.damageContribution / totalDamage * 100).toFixed(1)}%)"
          } else {
            ""
          }
      damageLabelElement.textContent =
          if (status.damageContribution > 0) {
            "${status.damageContribution.formatShort()} (${(status.damageContribution / totalDamage * 100).toFixed(1)}%)"
          } else {
            ""
          }
      buffsElement.run {
        clear()
        append { buffElements(status) }
      }
    }
  } else {
    clear()
    append {
      div(classes = "row justify-content-evenly g-1") {
        // Reversed since frontmost is the first in the list
        data.enemyStatus?.reversed()?.forEachIndexed { i, status ->
          div(classes = "$bossWidth") {
            p(classes = "mt-1 mb-0") {
              id = "boss-name-$i"
              style = "font-size: 0.75rem;"
              +status.name
            }
            div(classes = "boss-buffs") {
              id = "boss-buffs-$i"
              buffElements(status)
            }
            div(classes = "progress") {
              style = "font-size: 0.7rem;height: 0.8rem;position: relative;"
              div(classes = "progress-bar bg-danger") {
                id = "boss-hp-$i"
                style = "width: ${status.hp / status.maxHp * 100}%;font-weight: bold;z-index: 2;"
                if (status.hp > 0) {
                  +"${status.hp}/${status.maxHp} (-${(status.maxHp - status.hp).formatShort()})"
                }
              }
              div(classes = "progress-bar-label") {
                id = "boss-hp-label-$i"
                style =
                    "font-weight: bold;color: black;position: absolute;left: 0;top: 0;z-index: 1;height: 100%;display: flex;flex-direction:column;justify-content: center;align-items: center;"
                if (status.hp > 0) {
                  +"${status.hp}/${status.maxHp} (-${(status.maxHp - status.hp).formatShort()})"
                }
              }
            }
          }
        }
      }
      div(classes = "row justify-content-evenly g-1 mt-1") {
        val totalDamage = data.playerStatus?.sumOf { it.damageContribution } ?: 0.0
        data.playerStatus?.reversed()?.forEachIndexed { i, status ->
          div(classes = "$playerWidth interactive-status-container") {
            div(classes = "interactive-status-image-container") {
              onClickFunction = {
                if (status.dressId > 0) {
                  window.open("https://karth.top/dress/${status.dressId}?global=1", "_blank")
                }
              }
              id = "player-status-image-container-$i"
              img(classes = "interactive-status-actor-img") {
                src = "img/large_icon/1_${status.dressId}.png"
              }
              div(classes = "interactive-status-dex-counter") { +"${status.dexterity}" }
              if (status.isSupport) {
                img(classes = "interactive-status-support-indicator") {
                  src = "img/common/icon_support_dress.png"
                }
              }
              if (status.inClimax) {
                i("bi bi-stars interactive-status-climaxing-icon") {}
              }
            }
            div(classes = "interactive-status-bars-container") {
              div(classes = "interactive-status-buffs-container") {
                id = "player-buffs-$i"
                buffElements(status)
              }
              div(classes = "progress") {
                style = "font-size: 0.7rem;height: 0.8rem;position: relative;"
                div(classes = "progress-bar bg-success") {
                  id = "player-hp-$i"
                  style = "width: ${status.hp / status.maxHp * 100}%;font-weight: bold;z-index: 2;"
                  if (status.hp > 0) {
                    +"${status.hp}/${status.maxHp}"
                  }
                }
                div(classes = "progress-bar-label") {
                  id = "player-hp-label-$i"
                  style =
                      "font-weight: bold;color: black;position: absolute;left: 0;top: 0;z-index: 1;height: 100%;display: flex;flex-direction:column;justify-content: center;align-items: center;"
                  if (status.hp > 0) {
                    +"${status.hp}/${status.maxHp}"
                  }
                }
              }
              div(classes = "progress") {
                style = "font-size: 0.7rem;height: 0.8rem;margin-top: 0.1rem;position: relative;"
                div(classes = "progress-bar bg-warning") {
                  id = "player-brilliance-$i"
                  style = "width: ${status.brilliance}%;color: black;font-weight: bold;z-index: 2;"
                  if (status.hp > 0) {
                    +"${status.brilliance}"
                  }
                }
                div(classes = "progress-bar-label") {
                  id = "player-brilliance-label-$i"
                  style =
                      "font-weight: bold;color: black;position: absolute;left: 0;top: 0;z-index: 1;height: 100%;display: flex;flex-direction:column;justify-content: center;align-items: center;"
                  if (status.hp > 0) {
                    +"${status.brilliance}"
                  }
                }
              }
              div(classes = "progress damage-shares") {
                style = "font-size: 0.7rem;height: 0.8rem;margin-top: 0.1rem;position: relative;"
                div(classes = "progress-bar") {
                  id = "player-damage-$i"
                  style =
                      "width: ${status.damageContribution / totalDamage.coerceAtLeast(1.0) * 100}%;color: black;font-weight: bold;z-index: 2;"
                  if (status.damageContribution > 0) {
                    +if (status.damageContribution > 0) {
                      "${status.damageContribution.formatShort()} (${(status.damageContribution / totalDamage * 100).toFixed(1)}%)"
                    } else {
                      ""
                    }
                  }
                }
                div(classes = "progress-bar-label") {
                  id = "player-damage-label-$i"
                  style =
                      "font-weight: bold;color: black;position: absolute;left: 0;top: 0;z-index: 1;height: 100%;display: flex;flex-direction:column;justify-content: center;align-items: center;"
                  if (status.damageContribution > 0) {
                    +if (status.damageContribution > 0) {
                      "${status.damageContribution.formatShort()} (${(status.damageContribution / totalDamage * 100).toFixed(1)}%)"
                    } else {
                      ""
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  animations.forEach {
    document.getElementById(it.elementId)?.asDynamic().animate(it.keyframes, it.timing)
  }
}

fun updateDamageEstimate(queueInfo: InteractiveQueueInfo?) {
  val containerElement = document.getElementById("damage-estimate-container") ?: return
  val damageElement = document.getElementById("damage-estimate") ?: return

  val damage = queueInfo?.queueDamageEstimate
  if (damage == null) {
    containerElement.classList.add("d-none")
  } else {
    containerElement.classList.remove("d-none")
    damageElement.textContent = damage.formatShort()
  }

  val timelineContainer =
      document.getElementById("interactive-timeline-container") as HTMLDivElement
  timelineContainer
      .getElementsByClassName("interactive-timeline-act-damage-overlay")
      .multiple<HTMLDivElement>()
      .forEachIndexed { i, element ->
        val actDamage = queueInfo?.perActQueueDamageEstimates?.getOrNull(i)
        if (actDamage == null) {
          element.classList.add("d-none")
        } else {
          element.classList.remove("d-none")
          element.textContent = actDamage.formatShort(1)
        }
      }
}

private fun Double.formatShort(digits: Int = 2): String {
  return when {
    this >= 1_000_000_000_000_000_000_000_000.0 ->
        "${(this / 1_000_000_000_000_000_000_000_000.0).toFixed(digits)}Sx"
    this >= 1_000_000_000_000_000_000_000.0 ->
        "${(this / 1_000_000_000_000_000_000_000.0).toFixed(digits)}Qt"
    this >= 1_000_000_000_000_000 -> "${(this / 1_000_000_000_000_000).toFixed(digits)}Qd"
    this >= 1_000_000_000_000 -> "${(this / 1_000_000_000_000).toFixed(digits)}T"
    this >= 1_000_000_000 -> "${(this / 1_000_000_000).toFixed(digits)}B"
    this >= 1_000_000 -> "${(this / 1_000_000).toFixed(digits)}M"
    this >= 1_000 -> "${(this / 1_000).toFixed(digits)}K"
    else -> this.toString()
  }
}

fun HTMLElement.displayLog(
    log: List<LogEntry>,
    interactive: Boolean,
    prev: List<LogEntry> = emptyList()
) {
  fun TagConsumer<HTMLElement>.makeLogEntry(entry: LogEntry) =
      entry.run {
        div(classes = "log-entry") {
          style = "background-color: ${category.backgroundColor};"
          attributes["data-turn"] = turn.toString()
          when {
            summary != null -> {
              val collapseId = "log-contents-${idCounter++}"
              span {
                b { +"$turn.$tile.$move [${tags.joinToString(" / ")}]" }
                +" "
                processLogContent(summary!!)
                +" "
                span {
                  +"["
                  a {
                    role = "button"
                    href = "#"
                    attributes["data-bs-toggle"] = "collapse"
                    attributes["data-bs-target"] = "#$collapseId"
                    +"details"
                  }
                  +"]"
                }
              }
              div(classes = "log-collapse collapse") {
                id = collapseId
                span {
                  style = "padding-left: 1em;display: block;white-space: pre;overflow-x: auto;"
                  processLogContent(content)
                }
              }
            }
            content.contains("\n") -> {
              span { b { +"$turn.$tile.$move [${tags.joinToString(" / ")}]" } }
              span {
                style = "padding-left: 1em;display: block;white-space: pre;overflow-x: auto;"
                processLogContent(content)
              }
            }
            else -> {
              span {
                if ("@noturn" !in tags) {
                  b { +"$turn.$tile.$move [${tags.joinToString(" / ")}]" }
                  +" "
                }
                processLogContent(content)
              }
            }
          }
        }
      }

  var matchingCount = 0
  for ((old, new) in prev.zip(log)) {
    if (old == new) {
      matchingCount++
    } else {
      break
    }
  }

  repeat(children.length - matchingCount) { lastElementChild?.remove() }

  val newEntries = log.drop(matchingCount)
  append { newEntries.forEach { entry -> makeLogEntry(entry) } }

  if (interactive) {
    val logCollapses = getElementsByClassName("log-collapse").asList()
    logCollapses.forEach { it.removeClass("show") }
    logCollapses.lastOrNull()?.addClass("show")
  }
}

@Suppress("RegExpRedundantEscape") // JS doesn't like the unescaped ]
private val replacementRegex = """@(\[(.*?)\])?\((.*?)(?::(.*?))?\)""".toRegex()

private fun FlowContent.processLogContent(content: String) {
  val split = content.split(replacementRegex)

  val tags = mutableListOf<FlowContent>()

  var receiver = this

  inline fun beginSpan(block: SPAN.() -> Unit) =
      receiver.run {
        val tag = SPAN(attributesMapOf("class", ""), consumer)
        tags += tag
        receiver = tag
        tag.consumer.onTagStart(tag)
        tag.block()
      }

  fun endSpan() =
      receiver.run {
        val tag = tags.removeLastOrNull()
        if (tag != null) {
          tag.consumer.onTagEnd(tag)
          receiver = tag
        }
      }

  replacementRegex.findAll(content).forEachIndexed { index, match ->
    receiver.run {
      +split[index] // Add the previous split

      val disp = match.groups[2]?.value ?: ""
      val name = match.groups[3]!!.value.trim()
      val data = match.groups[4]?.value?.trim() ?: ""

      fun imageReplacement(url: (Int) -> String) {
        val id = data.toIntOrNull()
        if (id != null && id != -1) {
          img {
            style = "height: 1.4em;margin: -0.25em 0.05em;"
            src = url(id)
          }
        }
      }

      when (name) {
        "bg" -> beginSpan { style = "background-color: $data;" }
        "fg" -> beginSpan { style = "color: $data;" }
        "b" -> beginSpan { style = "font-weight: bold;" }
        "i" -> beginSpan { style = "font-style: italic;" }
        "u" -> beginSpan { style = "text-decoration: underline;" }
        "s" -> beginSpan { style = "text-decoration: line-through;" }
        "/" -> endSpan()
        "dress" -> imageReplacement { "img/large_icon/1_$it.png" }
        "memoir" -> imageReplacement { "img/large_icon/2_$it.png" }
        "act" -> imageReplacement { "img/skill_icon/skill_icon_$it.png" }
        "command" ->
            a(href = "#") {
              title = data
              onClickFunction = { e ->
                document.dispatchEvent(
                    CustomEvent("sendInteractiveCommand", jsObject { detail = data }))
                e.preventDefault()
              }
              +disp
            }
        else -> {}
      }
    }
  }

  +split.last()

  tags.reversed().forEach { consumer.onTagEnd(it) }
}
