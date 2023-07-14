package xyz.qwewqa.relive.simulator.client.codemirror

import org.w3c.dom.HTMLElement
import xyz.qwewqa.relive.simulator.client.jsObject
import kotlin.js.RegExp
import kotlin.js.json

fun codeMirrorConfig(parent: HTMLElement) =
    json(
        "parent" to parent,
        "extensions" to
            arrayOf(
                lineNumbers(),
                highlightActiveLineGutter(),
                highlightSpecialChars(),
                history(),
                foldGutter(),
                drawSelection(),
                dropCursor(),
                EditorState.allowMultipleSelections.of(true),
                syntaxHighlighting(defaultHighlightStyle, jsObject { fallback = true }),
                rectangularSelection(),
                crosshairCursor(),
                highlightActiveLine(),
                highlightSelectionMatches(),
                keymap.of(
                    defaultKeymap +
                        searchKeymap +
                        historyKeymap +
                        foldKeymap +
                        lintKeymap +
                        arrayOf(
                            indentWithTab,
                            jsObject {
                              win = "Mod-Shift-z"
                              run = redo
                              preventDefault = true
                            })),
                movesetFoldService,
                movesetLanguage,
            ),
    )

var EditorView.value: String
  get() = state.doc.toString()
  set(value) {
    dispatch(
        jsObject {
          changes = jsObject {
            from = 0
            to = state.doc.length
            insert = value
          }
        })
  }

val movesetLanguage = run {
  fun <T> Array<T>?.isNotEmpty() = this != null && this.size > 0
  val token: (Stream, MovesetState) -> String? =
      token@{ stream, state ->
        val ch = stream.peek()
        if (ch == "#" &&
            (stream.pos == 0 || Regex("\\s").matches(stream.string[stream.pos - 1].toString()))) {
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
              return@token "variableName.definition"
            }
            stream.match(RegExp("[Tt]urn")).isNotEmpty() -> {
              state.state = "turnNumber"
              return@token "propertyName.definition"
            }
            stream.match(RegExp("assert")).isNotEmpty() -> {
              state.state = "actorThenArgs"
              return@token "operatorKeyword"
            }
            stream.match("climax") -> {
              state.state = ""
              return@token "variableName.special"
            }
            stream.match(identRe).isNotEmpty() -> {
              state.state = "actName"
              return@token "variableName.local"
            }
          }
        }

        when (state.state) {
          "movesetStart" ->
              when {
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
          "movesetWeight" ->
              when {
                stream.match(numRe).isNotEmpty() -> {
                  state.state = "colon"
                  return@token "number"
                }
              }
          "turnNumber" ->
              when {
                stream.match(numRe).isNotEmpty() -> {
                  state.state = "colon"
                  return@token "number"
                }
              }
          "actorThenArgs" ->
              when {
                stream.match(identRe).isNotEmpty() -> {
                  state.state = "args"
                  return@token "variableName.local"
                }
              }
          "args" ->
              when {
                stream.match(identRe).isNotEmpty() -> {
                  state.state = "args"
                  return@token "variableName"
                }
              }
          "actName" -> {
            val match = stream.match(identRe)
            when {
              match == null || match.isEmpty() -> {}
              match[0] in listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "cx", "cutin") -> {
                state.state = ""
                return@token "variableName.special"
              }
              else -> {
                state.state = ""
                return@token "invalid"
              }
            }
          }
          "colon" ->
              when {
                stream.match(":") -> {
                  state.state = ""
                  return@token "punctuation"
                }
              }
        }

        stream.next()
        null
      }
  val startState: () -> MovesetState = {
    @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
    jsObject { state = "" } as MovesetState
  }

  StreamLanguage.define(
      json(
          "token" to token,
          "startState" to startState,
          "languageData" to json("commentTokens" to json("line" to "#"))))
}

val movesetFoldService = run {
  val movesetRe = Regex("^\\s*[Mm]oveset([: ].*)?$")
  val turnRe = Regex("^\\s*[Tt]urn([: ].*)?$")
  fun headerLevel(state: dynamic, lineNo: Int): Int {
    val line = state.doc.line(lineNo).text as String
    return when {
      movesetRe.matches(line) -> 2
      turnRe.matches(line) -> 1
      else -> -1
    }
  }

  val service =
      service@{ state: dynamic, lineStart: dynamic, lineEnd: dynamic ->
        val startLine = state.doc.lineAt(lineStart, -1).number as Int
        val lastLine = state.doc.lines as Int

        val startLevel = headerLevel(state, startLine)

        if (startLevel < 0) return@service null

        var lastLineInFold: Int? = null
        for (i in startLine + 1..lastLine) {
          if (headerLevel(state, i) >= startLevel) {
            break
          }
          lastLineInFold = i
        }

        if (lastLineInFold != null) {
          jsObject {
            from = state.doc.line(startLine).to
            to = state.doc.line(lastLineInFold).to
          }
        } else {
          null
        }
      }

  foldService.of(service)
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
  fun match(
      pattern: String,
      consume: Boolean = definedExternally,
      caseFold: Boolean = definedExternally
  ): Boolean
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
