package xyz.qwewqa.relive.simulator.client

import kotlin.js.RegExp
import kotlin.js.json

@JsModule("codemirror/addon/fold/foldcode")
@JsNonModule
external val foldcodeDummy: Any?

@JsModule("codemirror/addon/fold/foldgutter")
@JsNonModule
external val foldgutterDummy: Any?

@JsModule("codemirror")
@JsNonModule
external fun CodeMirror(element: dynamic, config: dynamic): dynamic

@JsModule("codemirror")
@JsNonModule
external object CodeMirror {
    fun defineMode(name: String, mode: dynamic)

    fun registerHelper(type: String, name: String, helper: dynamic)

    fun Pos(line: Int, ch: Int = definedExternally, sticky: String = definedExternally): dynamic
}

@Suppress("UnsafeCastFromDynamic")
fun registerMovesetMode() {
    fun <T> Array<T>?.isNotEmpty() = this != null && this.size > 0

    CodeMirror.defineMode("moveset") {
        val token: (Stream, MovesetState) -> String? = token@{ stream, state ->
            val ch = stream.peek()
            if (ch == "#" && (stream.pos == 0 || Regex("\\s").matches(stream.string[stream.pos - 1].toString()))) {
                stream.skipToEnd()
                return@token "comment"
            }

            val numRe = RegExp("\\d+")
            val stringRe = RegExp(""""([^"\\]|\\.)*"""")
            val identRe = RegExp("[^\\s#:]+|`[^`]*`")

            if (stream.sol()) {
                state.state = ""
                stream.eatSpace()
                when {
                    stream.match("#") -> {
                        stream.skipToEnd()
                        return@token "comment"
                    }
                    stream.match(RegExp("[Mm]oveset")).isNotEmpty() -> {
                        state.state = "movesetStart"
                        return@token "keyword"
                    }
                    stream.match(RegExp("[Tt]urn")).isNotEmpty() -> {
                        state.state = "turnNumber"
                        return@token "keyword"
                    }
                    stream.match(RegExp("assert")).isNotEmpty() -> {
                        state.state = "actorThenArgs"
                        return@token "builtin"
                    }
                    stream.match("climax") -> {
                        state.state = ""
                        return@token "variable-3"
                    }
                    stream.match(identRe).isNotEmpty() -> {
                        state.state = "actName"
                        return@token "variable-2"
                    }
                }
            }

            when (state.state) {
                "movesetStart" -> when {
                    stream.match(numRe).isNotEmpty() -> {
                        state.state = ""
                        return@token "number"
                    }
                    stream.match(stringRe).isNotEmpty() -> {
                        state.state = "movesetWeight"
                        return@token "string"
                    }
                    stream.match(identRe).isNotEmpty() -> {
                        state.state = "movesetWeight"
                        return@token "string"
                    }
                }
                "movesetWeight" -> when {
                    stream.match(numRe).isNotEmpty() -> {
                        state.state = ""
                        return@token "number"
                    }
                }
                "turnNumber" -> when {
                    stream.match(numRe).isNotEmpty() -> {
                        state.state = ""
                        return@token "number"
                    }
                }
                "actorThenArgs" -> when {
                    stream.match(identRe).isNotEmpty() -> {
                        state.state = "args"
                        return@token "variable-2"
                    }
                }
                "args" -> when {
                    stream.match(identRe).isNotEmpty() -> {
                        state.state = "args"
                        return@token "variable"
                    }
                }
                "actName" -> when {
                    stream.match(identRe).isNotEmpty() -> {
                        state.state = ""
                        return@token "variable-3"
                    }
                }
            }

            stream.next()
            null
        }
        val startState: () -> MovesetState = {
            @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
            jsObject {
                state = ""
            } as MovesetState
        }

        json(
            "token" to token,
            "startState" to startState,
            "lineComment" to "#",
            "fold" to "moveset",
        )
    }

    val movesetRe = Regex("^\\s*[Mm]oveset(:| .*)?$")
    val turnRe = Regex("^\\s*[Tt]urn(:| .*)?$")
    fun headerLevel(cm: dynamic, lineNo: Int): Int {
        val line = cm.getLine(lineNo) as String
        return when {
            movesetRe.matches(line) -> 2
            turnRe.matches(line) -> 1
            else -> -1
        }
    }

    CodeMirror.registerHelper("fold", "moveset") { cm: dynamic, start: dynamic ->
        val startLine = start.line as Int
        val lastLine = cm.lastLine() as Int

        val startLevel = headerLevel(cm, startLine)

        if (startLevel < 0) return@registerHelper null

        var lastLineInFold: Int? = null
        for (i in startLine + 1..lastLine) {
            if (headerLevel(cm, i) >= startLevel) {
                break
            }
            lastLineInFold = i
        }

        if (lastLineInFold != null) {
            jsObject {
                from = CodeMirror.Pos(startLine, cm.getLine(startLine).length)
                to = CodeMirror.Pos(lastLineInFold, cm.getLine(lastLineInFold).length)
            }
        } else {
            null
        }
    }
}

external interface MovesetState {
    var state: String
}

external class Stream {
    val string: String
    val pos: Int
    val tabSize: Int
    val lastColumnPos: Int
    val lastColumnValue: Int
    val lineStart: Int
    val lineOracle: Any?

    fun eol(): Boolean
    fun sol(): Boolean
    fun peek(): String
    fun next(): String
    fun eat(match: String): String?
    fun eat(match: RegExp): String?
    fun eat(match: (char: String) -> Boolean): String?
    fun eatWhile(match: String): Boolean
    fun eatWhile(match: RegExp): Boolean
    fun eatWhile(match: (char: String) -> Boolean): Boolean
    fun eatSpace(): Boolean
    fun skipToEnd()
    fun skipTo(str: String): Boolean
    fun match(pattern: String, consume: Boolean = definedExternally, caseFold: Boolean = definedExternally): Boolean
    fun match(pattern: RegExp, consume: Boolean = definedExternally): Array<String>?
    fun backUp(n: Int)
    fun column(): Int
    fun indentation(): Int
    fun current(): String
    fun lookAhead(n: Int): String?
    fun baseToken(): BaseToken
}

external class BaseToken {
    val type: String?
    val size: Int
}
