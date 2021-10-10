package xyz.qwewqa.relive.simulator.core.stage.strategy.complete

import com.github.h0tk3y.betterParse.lexer.Token
import com.github.h0tk3y.betterParse.lexer.TokenMatch

interface CsNode

data class CsScriptNode(
    val initialize: CsStatementNode?,
    val body: CsStatementNode,
) : CsNode

sealed interface CsStatementNode : CsNode {
    fun execute(context: CsContext)
}

sealed interface CsExpressionNode : CsStatementNode {
    override fun execute(context: CsContext) {
        evaluate(context)
    }

    fun evaluate(context: CsContext): CsObject
}

data class CsStatementContainer(val statement: CsStatementNode, val startToken: TokenMatch?) : CsStatementNode {
    override fun execute(context: CsContext) {
        try {
            statement.execute(context)
        } catch (e: CsRuntimeException) {
            if (startToken == null || e is AnnotatedCsRuntimeException) {
                throw e
            }
            throw AnnotatedCsRuntimeException(
                "Error on (row ${startToken.row}): ${e.message}",
                cause = e,
            )
        }
    }
}

data class CsSwitchClause(val expression: CsExpressionNode?, val cases: List<CsCaseClause>) : CsStatementNode {
    override fun execute(context: CsContext) {
        if (expression != null) {
            val value = expression.evaluate(context)
            cases.first { case ->
                (case is CsDefaultCase) ||
                        (case is CsExpressionCase) && case.condition.any { it.evaluate(context) == value }
            }.body.execute(context)
        } else {
            cases.first { case ->
                (case is CsDefaultCase) ||
                        (case is CsExpressionCase) && case.condition.any { it.evaluate(context).bool() }
            }.body.execute(context)
        }
    }
}

sealed interface CsCaseClause {
    val body: CsStatementNode
}

data class CsExpressionCase(val condition: List<CsExpressionNode>, override val body: CsStatementNode) : CsCaseClause
data class CsDefaultCase(override val body: CsStatementNode) : CsCaseClause

data class CsIfNode(val condition: CsExpressionNode, val tbranch: CsStatementNode, val fbranch: CsStatementNode?) :
    CsStatementNode {
    override fun execute(context: CsContext) {
        if (condition.evaluate(context).bool()) {
            tbranch.execute(context)
        } else {
            fbranch?.execute(context)
        }
    }
}

data class CsBlockNode(val statements: List<CsStatementNode>) : CsStatementNode {
    override fun execute(context: CsContext) {
        statements.forEach { it.execute(context) }
    }
}

data class CsAssignmentNode(val name: String, val value: CsExpressionNode) : CsStatementNode {
    override fun execute(context: CsContext) {
        val descriptor = context.variables[name] as? CsDescriptor
        if (descriptor != null) {
            descriptor.setValue(value.evaluate(context), context)
        } else {
            context.variables[name] = value.evaluate(context)
        }
    }
}

data class CsIdentifierNode(val name: String) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        return context.variables[name]?.getValue(context) ?: csError("Value for identifier '$name' not found.")
    }
}

data class CsLiteralNode(val value: CsObject) : CsExpressionNode {
    override fun evaluate(context: CsContext) = value
}

data class CsAttributeAccessNode(val value: CsExpressionNode, val name: String) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        return value.evaluate(context).getAttribute(name) ?: csError("Attribute '$name' not found.")
    }
}

data class CsCallNode(val value: CsExpressionNode, val args: List<CsExpressionNode>) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        return value.evaluate(context).invoke(args.map { it.evaluate(context) })
    }
}

data class CsNumericalInfixOperatorNode(
    val lhs: CsExpressionNode,
    val rhs: CsExpressionNode,
    val op: NumericalInfixOperator,
) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        val l = lhs.evaluate(context)
        val r = rhs.evaluate(context)
        return when (op) {
            NumericalInfixOperator.PLUS -> {
                if (l is CsString || r is CsString) {
                    (l.display() + r.display()).asCsString()
                } else {
                    (l.number() + r.number()).asCsNumber()
                }
            }
            NumericalInfixOperator.MINUS -> (l.number() - r.number()).asCsNumber()
            NumericalInfixOperator.DIV -> (l.number() / r.number()).asCsNumber()
            NumericalInfixOperator.TIMES -> (l.number() * r.number()).asCsNumber()
            NumericalInfixOperator.MOD -> (l.number() % r.number()).asCsNumber()
        }
    }
}

data class CsBooleanInfixOperatorNode(
    val lhs: CsExpressionNode,
    val rhs: CsExpressionNode,
    val op: BooleanInfixOperator,
) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        val l = lhs.evaluate(context).bool()
        return when (op) {
            BooleanInfixOperator.OR -> l || rhs.evaluate(context).bool()
            BooleanInfixOperator.AND -> l && rhs.evaluate(context).bool()
        }.asCsBoolean()
    }
}

data class CsComparisonOperatorNode(
    val lhs: CsExpressionNode,
    val rhs: CsExpressionNode,
    val op: ComparisonOperator,
) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        val l = lhs.evaluate(context)
        val r = rhs.evaluate(context)
        return when (op) {
            ComparisonOperator.EQUAL -> l == r
            ComparisonOperator.NOT_EQUAL -> l != r
            ComparisonOperator.LESS -> l.number() < r.number()
            ComparisonOperator.LESS_OR_EQUAL -> l.number() <= r.number()
            ComparisonOperator.GREATER -> l.number() > r.number()
            ComparisonOperator.GREATER_OR_EQUAL -> l.number() >= r.number()
        }.asCsBoolean()
    }
}

data class CsPosOperatorNode(
    val value: CsExpressionNode,
) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        return (+value.evaluate(context).number()).asCsNumber()
    }
}

data class CsNegOperatorNode(
    val value: CsExpressionNode,
) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        return (-value.evaluate(context).number()).asCsNumber()
    }
}

data class CsNotOperatorNode(
    val value: CsExpressionNode,
) : CsExpressionNode {
    override fun evaluate(context: CsContext): CsObject {
        return (!value.evaluate(context).bool()).asCsBoolean()
    }
}
