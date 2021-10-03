package xyz.qwewqa.relive.simulator.core.stage.strategy.conpletestrategy

import com.github.h0tk3y.betterParse.combinators.*
import com.github.h0tk3y.betterParse.grammar.Grammar
import com.github.h0tk3y.betterParse.grammar.parser
import com.github.h0tk3y.betterParse.lexer.*
import com.github.h0tk3y.betterParse.parser.Parser

enum class NumericalInfixOperator {
    PLUS,
    MINUS,
    DIV,
    TIMES,
    MOD,
}

enum class BooleanInfixOperator {
    OR,
    AND,
}

enum class ComparisonOperator {
    EQUAL,
    NOT_EQUAL,
    LESS,
    LESS_OR_EQUAL,
    GREATER,
    GREATER_OR_EQUAL,
}

object CsParser : Grammar<CsScriptNode>() {
    val lpar by literalToken("(")
    val rpar by literalToken(")")
    val lsqr by literalToken("[")
    val rsqr by literalToken("]")
    val lcurl by literalToken("{")
    val rcurl by literalToken("}")

    val semi by literalToken(";")
    val colon by literalToken(":")
    val dot by literalToken(".")
    val comma by literalToken(",")

    val `if` by literalToken("if")
    val `else` by literalToken("else")
    val `init` by literalToken("init")
    val switch by literalToken("switch")
    val case by literalToken("case")
    val default by literalToken("default")

    val plus by literalToken("+")
    val minus by literalToken("-")
    val div by literalToken("/")
    val times by literalToken("*")
    val mod by literalToken("%")
    val or by literalToken("||")
    val and by literalToken("&&")
    val eq by literalToken("==")
    val neq by literalToken("!=")
    val leq by literalToken("<=")
    val geq by literalToken(">=")
    val gt by literalToken(">")
    val lt by literalToken("<")

    val assign by literalToken("=")

    val not by literalToken("!")
    val pos by literalToken("+")
    val neg by literalToken("-")

    val num by regexToken("[0-9]+(\\.[0-9]+)?")
    val ident by regexToken("([^\\W0-9]\\w*)|(`[^`]+`)")
    val str by regexToken("\".*\"")
    val nl by regexToken("\\r?\\n", ignore = true)
    val ws by regexToken("[^\\S\\r\\n]+", ignore = true)

    val numericalInfixOperators = mapOf(
        plus to NumericalInfixOperator.PLUS,
        minus to NumericalInfixOperator.MINUS,
        div to NumericalInfixOperator.DIV,
        times to NumericalInfixOperator.TIMES,
        mod to NumericalInfixOperator.MOD,
    )

    val comparisonOperators = mapOf(
        eq to ComparisonOperator.EQUAL,
        neq to ComparisonOperator.NOT_EQUAL,
        lt to ComparisonOperator.LESS,
        leq to ComparisonOperator.LESS_OR_EQUAL,
        gt to ComparisonOperator.GREATER,
        geq to ComparisonOperator.GREATER_OR_EQUAL,
    )

    val identifier by ident.use { if (text[0] == '`') text.substring(1 until text.length - 1) else text }

    val numLiteral by num.use { CsLiteralNode(text.toDouble().asCsNumber()) }
    val strLiteral by str.use { CsLiteralNode(text.substring(1 until text.length - 1).asCSString()) }
    val identifierExpression by identifier.map { CsIdentifierNode(it) }

    val expressionList by separatedTerms(parser { expression }, comma) or zeroOrMore(parser { expression } * -comma)

    val atomicExpression
            by numLiteral or
                    strLiteral or
                    identifierExpression or
                    (-lpar * parser { expression } * -rpar)


    val attributeAccess: Parser<CsExpressionNode> by (parser { atomicExpression } * zeroOrMore(-dot * identifier)).map { (lhs, value) ->
        value.fold(lhs) { a, v -> CsAttributeAccessNode(a, v) }
    }

    val functionCall: Parser<CsExpressionNode> by (parser { attributeAccess } * zeroOrMore(-lpar * optional(
        expressionList) * -rpar)).map { (lhs, calls) ->
        calls.fold(lhs) { a, v -> CsCallNode(a, v ?: emptyList()) }
    }

    val unaryExpression
            by (-plus * functionCall).map { CsPosOperatorNode(it) } or
                    (-minus * functionCall).map { CsNegOperatorNode(it) } or
                    (-not * functionCall).map { CsNotOperatorNode(it) } or
                    functionCall

    val multiplicationOperator by times or div or mod
    val multiplication by leftAssociative(unaryExpression, multiplicationOperator) { l, o, r ->
        CsNumericalInfixOperatorNode(l, r, numericalInfixOperators[o.type]!!)
    }

    val additionOperator by plus or minus
    val addition by leftAssociative(multiplication, additionOperator) { l, o, r ->
        CsNumericalInfixOperatorNode(l, r, numericalInfixOperators[o.type]!!)
    }

    val comparisonOperator by eq or neq or lt or leq or gt or geq
    val comparison by leftAssociative(addition, comparisonOperator) { l, o, r ->
        CsComparisonOperatorNode(l, r, comparisonOperators[o.type]!!)
    }

    private val andChain by leftAssociative(comparison, and) { l, _, r ->
        CsBooleanInfixOperatorNode(l, r, BooleanInfixOperator.AND)
    }
    private val orChain by leftAssociative(andChain, or) { l, _, r ->
        CsBooleanInfixOperatorNode(l, r, BooleanInfixOperator.OR)
    }

    val expression: Parser<CsExpressionNode> by orChain

    val statementList by (zeroOrMore(optional(parser { statement }) * -semi) * optional(parser { statement })).map { (a, b) ->
        (a + b).filterNotNull()
    }
    val block by (-lcurl * statementList * -rcurl)

    val ifStatement: Parser<CsIfNode> by (-`if` * expression * block * optional(parser { elseBlock })).map { (expr, tbranch, fbranch) ->
        CsIfNode(expr, CsBlockNode(tbranch), fbranch?.let { CsBlockNode(it) })
    }
    val elseBlock: Parser<List<CsStatementNode>> = (-`else` * (block or ifStatement.map { listOf(it) }))

    val expressionCaseClause by (-case * expressionList * -colon * statementList).map { (expressions, body) ->
        CsExpressionCase(expressions, CsBlockNode(body))
    }
    val defaultCaseClause by (-default * -colon * statementList).map { body ->
        CsDefaultCase(CsBlockNode(body))
    }
    val caseClause by expressionCaseClause or defaultCaseClause

    val switchStatement by (-switch * optional(expression) * -lcurl * zeroOrMore(caseClause) * -rcurl).map { (expression, cases) ->
        CsSwitchClause(expression, cases)
    }

    val assignmentStatement by (identifierExpression * -assign * expression).map { (i, v) ->
        CsAssignmentNode(i.name, v)
    }

    val statement: Parser<CsStatementNode>
            by ifStatement or switchStatement or assignmentStatement or expression

    val initBlock by -`init` * -lcurl * statementList * -rcurl

    override val rootParser by (optional(initBlock) * statementList).map { (initialize, body) ->
        CsScriptNode(initialize?.let { CsBlockNode(it) }, CsBlockNode(body))
    }

    private class CsTokenProducer(private val input: CharSequence) : TokenProducer {
        private val inputLength = input.length
        private var tokenIndex = 0
        private var pos = 0
        private var row = 1
        private var col = 1

        private var errorState = false

        private var lastToken: Token? = null
        private var deferredMatch: TokenMatch? = null

        private val autoSemiTokens = setOf(ident, num, rpar, rsqr, rcurl)

        override fun nextToken(): TokenMatch? {
            if (deferredMatch != null) {
                lastToken = deferredMatch!!.type
                return deferredMatch.also { deferredMatch = null }
            }

            if (pos > input.lastIndex || errorState) {
                return null
            }

            @Suppress("ReplaceManualRangeWithIndicesCalls")
            for (index in 0 until tokens.size) {
                val token = tokens[index]
                val matchLength = token.match(input, pos)
                if (matchLength == 0)
                    continue

                val autoSemi = if (token == nl && lastToken in autoSemiTokens) {
                    TokenMatch(semi, tokenIndex++, input, pos, matchLength, row, col)
                } else {
                    null
                }
                val result = TokenMatch(token, tokenIndex++, input, pos, matchLength, row, col)

                for (i in pos until pos + matchLength) {
                    if (input[i] == '\n') {
                        row++
                        col = 1
                    } else {
                        col++
                    }
                }

                pos += matchLength

                if (token != ws) {
                    lastToken = token
                }
                autoSemi?.let {
                    deferredMatch = result
                    return it
                }
                return result
            }

            errorState = true
            return TokenMatch(noneMatched, tokenIndex++, input, pos, inputLength - pos, row, col)
        }
    }

    override val tokenizer by lazy {
        object : Tokenizer {
            override val tokens = this@CsParser.tokens

            override fun tokenize(input: String): TokenMatchesSequence {
                return TokenMatchesSequence(CsTokenProducer(input))
            }
        }
    }
}