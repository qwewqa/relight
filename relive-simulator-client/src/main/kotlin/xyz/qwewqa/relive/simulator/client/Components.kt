package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.document
import kotlinx.dom.addClass
import kotlinx.dom.clear
import kotlinx.dom.hasClass
import kotlinx.dom.removeClass
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import kotlinx.html.option
import org.w3c.dom.*
import xyz.qwewqa.relive.simulator.common.*

fun HTMLInputElement.integerInput(default: Int) = IntegerInput(this, default)
fun HTMLInputElement.textInput() = TextInput(this)
fun HTMLSelectElement.singleSelect(selectpicker: Boolean) = SingleSelect(this, selectpicker)
fun HTMLSelectElement.multipleSelect(selectpicker: Boolean) = MultipleSelect(this, selectpicker)
fun HTMLDivElement.collapse() = Collapse(this)
fun Element?.integerInput(default: Int) = IntegerInput(this as HTMLInputElement, default)
fun Element?.shorthandIntegerInput() = ShorthandIntegerInput(this as HTMLInputElement)
fun Element?.textInput() = TextInput(this as HTMLInputElement)
fun Element?.singleSelect(selectpicker: Boolean) = SingleSelect(this as HTMLSelectElement, selectpicker)
fun Element?.multipleSelect(selectpicker: Boolean) = MultipleSelect(this as HTMLSelectElement, selectpicker)
fun Element?.collapse() = Collapse(this as HTMLDivElement)

val HTMLInputElement.valueOrPlaceholder: String get() = value.ifEmpty { placeholder }

class IntegerInput(val element: HTMLInputElement, val default: Int) {
    var value: Int
        get() = element.valueOrPlaceholder.toIntOrNull() ?: default
        set(value) {
            element.value = value.toString()
        }

    fun clear() {
        element.value = ""
    }
}

class ShorthandIntegerInput(val element: HTMLInputElement) {
    val value: Int?
        get() {
            var text = element.value.trim()
            if (text.isEmpty()) return null
            var multiplier = 1
            when {
                text.endsWith("k") || text.endsWith("K") -> {
                    multiplier = 1000
                    text = text.dropLast(1).trim()
                }
                text.endsWith("m") || text.endsWith("M") -> {
                    multiplier = 1000000
                    text = text.dropLast(1).trim()
                }
                text.endsWith("b") || text.endsWith("B") -> {
                    multiplier = 1000000000
                    text = text.dropLast(1).trim()
                }
            }
            val textValue = text.toFloatOrNull() ?: return null
            return (textValue * multiplier).toInt()
        }

    fun clear() {
        element.value = ""
    }
}

class TextInput(val element: HTMLInputElement) {
    var value: String
        get() = element.valueOrPlaceholder
        set(value) {
            element.value = value
        }
}

inline fun <reified T> HTMLCollection.single(): T = asList().filterIsInstance<T>().single()
inline fun <reified T> HTMLCollection.multiple(): List<T> = asList().filterIsInstance<T>()

fun refreshSelectPicker() {
    js("$('.selectpicker').selectpicker('refresh')")
}

class Collapse(val element: HTMLDivElement) {
    var show: Boolean
        get() = element.hasClass("show")
        set(value) {
            if (value) {
                element.addClass("show")
            } else {
                element.removeClass("show")
            }
        }
}

@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
sealed class Select(val element: HTMLSelectElement, val selectpicker: Boolean) {
    fun HTMLSelectElement.getSelected() = selectedOptions.asList().map {
        it.asDynamic().value as String
    }

    fun HTMLSelectElement.setSelected(selected: List<String>) {
        if (selectpicker) {
            js("$")(element).selectpicker("val", selected.toTypedArray())
        }
        this.options.asList().filterIsInstance<HTMLOptionElement>().forEach {
            it.selected = it.value in selected
        }
    }

    fun HTMLSelectElement.setSelected(selected: String) {
        if (selectpicker) {
            js("$")(element).selectpicker("val", selected)
        } else {
            element.value = selected
        }
    }

    fun selectedText(): List<String> = element.selectedOptions.multiple<HTMLElement>().map {
        it.textContent ?: ""
    }

    fun populate(values: Map<String, String>) {
        values.forEach {
            element.add(
                document.create.option {
                    value = it.key
                    +it.value
                } as UnionHTMLOptGroupElementOrHTMLOptionElement
            )
        }
    }

    fun populate(values: Iterable<String>) {
        values.forEach {
            element.add(
                document.create.option {
                    value = it
                    +it
                } as UnionHTMLOptGroupElementOrHTMLOptionElement
            )
        }
    }

    fun populate(mapping: Map<String, Map<String, String>>, locale: String) {
        mapping.forEach { (id, names) ->
            element.add(
                document.create.option {
                    value = id
                    +(names[locale] ?: id)
                } as UnionHTMLOptGroupElementOrHTMLOptionElement
            )
        }
    }

    fun populate(mapping: Map<String, SimulationOption>, locale: String) {
        mapping.forEach { (id, option) ->
            element.add(
                document.create.option {
                    value = id
                    attributes["data-subtext"] = option.description?.get(locale) ?: ""
                    attributes["data-tokens"] = option.tags?.get(locale)?.joinToString(" ") ?: ""
                    +option[locale]
                } as UnionHTMLOptGroupElementOrHTMLOptionElement
            )
        }
    }

    fun clear() {
        element.clear()
    }

    fun localize(mapping: Map<String, Map<String, String>>, locale: String) {
        element.options.asList().filterIsInstance<HTMLOptionElement>().forEach { option ->
            option.run {
                text = mapping[option.value]?.get(locale) ?: option.value
            }
        }
        refreshSelectPicker()
    }

    fun localize(mapping: Map<String, DataSimulationOption<*>>, locale: String) {
        element.options.asList().filterIsInstance<HTMLOptionElement>().forEach { selectOption ->
            val option = mapping[selectOption.value]
            val name = option?.get(locale) ?: selectOption.value
            val description = option?.description?.get(locale)
            selectOption.run {
                if (getAttribute("data-img") != null) {
                    setAttribute("data-img", option?.imagePath ?: "")
                }
                if (getAttribute("data-subtext") != null) {
                    setAttribute("data-subtext", description ?: "")
                }
                setAttribute("data-tokens", option?.tags?.get(locale)?.joinToString(" ") ?: "")
                text = name
            }
        }
        refreshSelectPicker()
    }

    fun refreshSelectPicker() {
        if (!selectpicker) return
        val jquery = js("$")
        jquery(element).selectpicker("refresh")
    }

    fun renderSelectPicker() {
        if (!selectpicker) return
        val jquery = js("$")
        jquery(element).selectpicker("render")
    }
}

class SingleSelect(element: HTMLSelectElement, selectpicker: Boolean) : Select(element, selectpicker) {
    var value: String
        get() = element.getSelected().single()
        set(value) {
            element.setSelected(value)
        }
}


class ButtonGroup(val element: HTMLElement) {
    private val inputs = element.children.asList().filterIsInstance<HTMLInputElement>()

    var value: String
        get() = inputs.first { it.checked }.value
        set(value) {
            inputs.forEach {
                it.checked = it.value == value
            }
        }
}


class MultipleSelect(element: HTMLSelectElement, selectpicker: Boolean) : Select(element, selectpicker) {
    var value: List<String>
        get() = element.getSelected()
        set(value) {
            element.setSelected(value)
        }
}

fun getMemoirUnbindImagePath(level: Int) = when (level) {
    4 -> "img/common/frame_large_equip_rainbow.png"
    3 -> "img/common/frame_large_equip_gold.png"
    2 -> "img/common/frame_large_equip_silver.png"
    1 -> "img/common/frame_large_equip_bronze.png"
    else -> "img/common/frame_large_equip_blue.png"
}

fun getAccessoryUnbindImagePath(level: Int) = when (level) {
    10 -> "img/common/frame_medium_accessory_rainbow.png"
    9 -> "img/common/frame_medium_accessory_gold.png"
    8 -> "img/common/frame_medium_accessory_gold.png"
    7 -> "img/common/frame_medium_accessory_gold.png"
    6 -> "img/common/frame_medium_accessory_silver.png"
    5 -> "img/common/frame_medium_accessory_silver.png"
    4 -> "img/common/frame_medium_accessory_silver.png"
    3 -> "img/common/frame_medium_accessory_bronze.png"
    2 -> "img/common/frame_medium_accessory_bronze.png"
    1 -> "img/common/frame_medium_accessory_blue.png"
    else -> "img/common/frame_medium_accessory_blue.png"
}

fun getEquipEvolutionImagePath(level: Int) = "img/common/icon_equip_evolution_$level.png"
fun getRemakeLevelVerticalImagePath(level: Int) = "img/custom/icon_remake_$level.png"
fun getRemakeLevelHorizontalImagePath(level: Int) = "img/common/icon_remake_$level.png"
fun getMemoirUnbindLevelHorizontalImagePath(level: Int) = "img/custom/icon_equip_evolution_$level.png"
fun getMemoirUnbindLevelVerticalImagePath(level: Int) = "img/common/icon_equip_evolution_$level.png"

class ActorOptions(private val options: SimulationOptions, val tabElement: Element, val optionsElement: Element) {
    constructor(options: SimulationOptions, actorId: Int) : this(
        options,
        document.getElementById("actor-tab-$actorId")!!,
        document.getElementById("actor-options-$actorId")!!,
    )

    val name = TextInput(optionsElement.getElementsByClassName("actor-name").single())
    val dress = SingleSelect(optionsElement.getElementsByClassName("actor-dress").single(), true)
    val support = ButtonGroup(optionsElement.getElementsByClassName("actor-support-toggle").single())
    val memoir = SingleSelect(optionsElement.getElementsByClassName("actor-memoir").single(), true)
    val memoirLevel = IntegerInput(optionsElement.getElementsByClassName("actor-memoir-level").single(), 1)
    val memoirUnbind = ButtonGroup(optionsElement.getElementsByClassName("actor-memoir-unbind").single())
    val accessory = SingleSelect(optionsElement.getElementsByClassName("actor-accessory").single(), true)
    val accessoryLevel = IntegerInput(optionsElement.getElementsByClassName("actor-accessory-level").single(), 1)
    val accessoryUnbind = ButtonGroup(optionsElement.getElementsByClassName("actor-accessory-unbind").single())
    val unitSkillLevel = IntegerInput(optionsElement.getElementsByClassName("actor-unit-skill").single(), 21)
    val level = IntegerInput(optionsElement.getElementsByClassName("actor-level").single(), 80)
    val rarity = SingleSelect(optionsElement.getElementsByClassName("actor-rarity").single(), false)
    val friendship = IntegerInput(optionsElement.getElementsByClassName("actor-friendship").single(), 30)
    val rank = SingleSelect(optionsElement.getElementsByClassName("actor-rank").single(), false)
    val rankPanelPattern = SingleSelect(optionsElement.getElementsByClassName("actor-rank-panel-pattern").single(), false)
    val remake = ButtonGroup(optionsElement.getElementsByClassName("actor-remake").single())
    val remakeSkill = SingleSelect(optionsElement.getElementsByClassName("actor-remake-skill").single(), true)

    val remakeIcon = optionsElement.getElementsByClassName("actor-remake-icon").single<HTMLImageElement>()
    val memoirUnbindIcon = optionsElement.getElementsByClassName("actor-memoir-unbind-icon").single<HTMLImageElement>()
    val remakeSkillText = optionsElement.getElementsByClassName("actor-remake-skill-text").single() as HTMLParagraphElement

    val tabName = tabElement.getElementsByClassName("actor-name").single<HTMLElement>()
    val tabSupportIndicator = tabElement.getElementsByClassName("actor-support-indicator").single<HTMLElement>()
    val tabLevel = tabElement.getElementsByClassName("actor-level").single<HTMLElement>()
    val tabUnitSkillLevel = tabElement.getElementsByClassName("actor-unit-skill-level").single<HTMLElement>()
    val tabRemakeLevelImage = tabElement.getElementsByClassName("actor-remake-level-image").single<HTMLImageElement>()
    val tabMemoirLevel = tabElement.getElementsByClassName("actor-memoir-level").single<HTMLElement>()
    val tabMemoirUnbindImage = tabElement.getElementsByClassName("actor-memoir-unbind-image").single<HTMLImageElement>()
    val tabDressImage = tabElement.getElementsByClassName("actor-dress-image").single<HTMLImageElement>()
    val tabMemoirImage = tabElement.getElementsByClassName("actor-memoir-image").single<HTMLImageElement>()
    val tabAccessoryImage = tabElement.getElementsByClassName("actor-accessory-image").single<HTMLImageElement>()
    val tabAccessoryUnbindImage = tabElement.getElementsByClassName("actor-accessory-unbind-image").single<HTMLImageElement>()
    val tabAccessoryLevel = tabElement.getElementsByClassName("actor-accessory-level").single<HTMLElement>()

    companion object {
        val rankPanelPatterns = mapOf(
            "All" to listOf(true, true, true, true, true, true, true, true),
            "Left 7" to listOf(true, true, true, true, false, true, true, true),
            "Upper 5" to listOf(true, true, true, true, true, false, false, false),
            "Lower 5" to listOf(true, false, false, false, true, true, true, true),
            "Upper 3" to listOf(true, true, true, false, false, false, false, false),
            "Lower 3" to listOf(true, false, false, false, false, false, true, true),
            "None" to listOf(false, false, false, false, false, false, false, false),
        )
        val rankPanelIds = rankPanelPatterns.keys.associateWith {
            "${it.lowercase().replace(" ", "-")}-rank-panels"
        }
        val inverseRankPanelPatterns = rankPanelPatterns.map { (k, v) -> v to k }.toMap()
    }

    fun reset() {
        val dressId = options.dresses.first().id
        val memoirId = options.memoirs.first().id

        parameters = PlayerLoadoutParameters(
            name = "",
            dress = dressId,
            memoir = options.memoirs.first().id,
            memoirLevel = 80,
            memoirLimitBreak = 4,
            unitSkillLevel = 21,
            level = 80,
            rarity = 6,
            friendship = 30,
            rank = 9,
            rankPanelPattern = List(8) { true },
            remake = 0,
            remakeSkill = "None",
            accessory = "None",
            accessoryLevel = 100,
            accessoryLimitBreak = 10,
            isSupport = false,
        )

        name.value = ""
        memoirLevel.element.value = ""
        accessoryLevel.element.value = ""
        unitSkillLevel.element.value = ""
        level.element.value = ""
        friendship.element.value = ""
        accessory.value = "None"
        accessoryUnbind.value = "10"
    }

    var parameters: PlayerLoadoutParameters
        get() {
            val validAccessory = options.dressesById[dress.value]!!.data.id in options.accessoriesById[accessory.value]!!.data.dressIds
            return PlayerLoadoutParameters(
                name.value,
                dress.value,
                memoir.value,
                memoirLevel.value,
                memoirUnbind.value.toInt(),
                unitSkillLevel.value,
                level.value,
                rarity.value.toInt(),
                friendship.value,
                rank.value.toInt(),
                rankPanelPatterns[rankPanelPattern.value]!!,
                remake.value.toInt(),
                remakeSkill.value,
                if (validAccessory) accessory.value else null,
                accessoryLevel.value,
                accessoryUnbind.value.toInt(),
                support.value == "true",
            )
        }
        set(param) {
            val dressData = options.dressesById[param.dress]
            val validAccessories = options.accessories
                .filter {
                    (dressData?.data?.id ?: 0) in it.data.dressIds || it.data.dressIds.isEmpty()
                }
                .map { it.id }
                .toSet()

            accessory.element.children.multiple<HTMLOptionElement>().forEach { opt ->
                opt.setAttribute("data-hidden", if (opt.value in validAccessories) "false" else "true")
            }
            accessory.refreshSelectPicker()

            if (validAccessories.size > 1) {
                accessory.element.parentElement?.parentElement?.removeClass("d-none")
                accessoryLevel.element.parentElement?.removeClass("d-none")
                accessoryUnbind.element.parentElement?.removeClass("d-none")
            } else {
                accessory.element.parentElement?.parentElement?.addClass("d-none")
                accessoryLevel.element.parentElement?.addClass("d-none")
                accessoryUnbind.element.parentElement?.addClass("d-none")
            }

            name.value = param.name
            dress.value = param.dress
            support.value = param.isSupport.toString()
            memoir.value = param.memoir
            memoirLevel.value = param.memoirLevel
            memoirUnbind.value = param.memoirLimitBreak.toString()
            if (validAccessories.size > 1) {
                accessory.value = param.accessory.takeIf { it in validAccessories } ?: "None"
                accessoryLevel.value = param.accessoryLevel
                accessoryUnbind.value = param.accessoryLimitBreak.toString()
            }
            unitSkillLevel.value = param.unitSkillLevel
            level.value = param.level
            rarity.value = param.rarity.toString()
            friendship.value = param.friendship
            rank.value = param.rank.toString()
            rankPanelPattern.value = inverseRankPanelPatterns[param.rankPanelPattern] ?: "Full"
            remake.value = param.remake.toString()
            remakeSkill.value = param.remakeSkill ?: "None"

            remakeSkill.element.asDynamic().disabled = param.remake < 4

            remakeIcon.src = getRemakeLevelHorizontalImagePath(param.remake)
            memoirUnbindIcon.src = getMemoirUnbindLevelHorizontalImagePath(param.memoirLimitBreak)

            tabName.textContent = param.name
            tabSupportIndicator.textContent = if (param.isSupport) "S" else ""
            tabLevel.textContent = param.level.toString()
            tabUnitSkillLevel.textContent = param.unitSkillLevel.toString()
            tabRemakeLevelImage.src = getRemakeLevelVerticalImagePath(param.remake)
            tabMemoirLevel.textContent = param.memoirLevel.toString()
            tabMemoirUnbindImage.src = getMemoirUnbindImagePath(param.memoirLimitBreak)
            tabDressImage.src = options.dressesById[param.dress]?.imagePath ?: ""
            tabMemoirImage.src = options.memoirsById[param.memoir]?.imagePath ?: ""
            tabAccessoryImage.src = options.accessoriesById[param.accessory]?.imagePath ?: ""
            tabAccessoryLevel.textContent = param.accessoryLevel.toString()
            tabAccessoryUnbindImage.src = getAccessoryUnbindImagePath(param.accessoryLimitBreak)

            if (validAccessories.size > 1 && accessory.value != "None") {
                tabAccessoryImage.removeClass("d-none")
                tabAccessoryLevel.parentElement?.removeClass("d-none")
                tabAccessoryUnbindImage.removeClass("d-none")
            } else {
                tabAccessoryImage.addClass("d-none")
                tabAccessoryLevel.parentElement?.addClass("d-none")
                tabAccessoryUnbindImage.addClass("d-none")
            }

            // Check for disabled change
            remakeSkill.renderSelectPicker()

            remakeSkillText.textContent = remakeSkill.element.selectedOptions.single<HTMLElement>().textContent

            remake.element.setAttribute("data-prev-value", param.remake.toString())
            memoirUnbind.element.setAttribute("data-prev-value", param.memoirLimitBreak.toString())
            accessoryUnbind.element.setAttribute("data-prev-value", param.accessoryLimitBreak.toString())
        }
}

class SongEffect(val element: Element) {
    private val type = SingleSelect(element.getElementsByClassName("song-effect-type").single(), true)
    private val value = IntegerInput(element.getElementsByClassName("song-effect-value").single(), 0)
    private val conditions = element.getElementsByClassName("song-effect-condition")
        .multiple<HTMLSelectElement>()
        .map {
        MultipleSelect(it, true)
    }
    private val description = element.getElementsByClassName("song-effect-description").single<HTMLElement>()

    fun registerListeners() {
        type.element.addEventListener("change", {
            update()
        })
        value.element.addEventListener("change", {
            update()
        })
        conditions.forEach {
            it.element.addEventListener("change", {
                update()
            })
        }
        element.getElementsByClassName("clear-select-button")
            .multiple<HTMLButtonElement>()
            .zip(conditions)
            .forEach { (button, condition) ->
                button.addEventListener("click", {
                    condition.value = emptyList()
                    update()
                })
            }
    }

    fun update() {
        description.textContent = if (type.value == "none") {
            type.selectedText().singleOrNull() ?: ""
        } else {
            "${
                type.selectedText().singleOrNull() ?: ""
            } ${
                value.value
            } ${
                conditions
                    .map { it.selectedText() }
                    .filter { it.isNotEmpty() }
                    .joinToString(" ") { conditions -> "[${conditions.joinToString(" | ")}]" }
            }"
        }
    }

    var parameters: SongEffectParameter?
        get() = SongEffectParameter(
            type.value,
            value.value,
            conditions.map { it.value }.filter { it.isNotEmpty() },
        ).takeIf { type.value != "none" }
        set(param) {
            type.value = param?.name ?: "none"
            value.value = param?.value ?: 0
            conditions.zip(param?.conditions ?: emptyList()).forEach { (a, b) ->
                a.value = b
            }
            conditions.takeLast(conditions.size - (param?.conditions?.size ?: 0)).forEach {
                it.value = emptyList()
            }
            update()
        }
}
