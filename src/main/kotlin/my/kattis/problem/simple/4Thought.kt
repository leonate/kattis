package my.kattis.problem.simple

import java.util.*

enum class Op(val priority : Int) {
    PLUS(0),
    MINUS(0),
    MULT(1),
    DIVIDE(1);
    companion object {
        val items = Op.values().toList()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val caseCount = scanner.nextInt()
    for(i in 1..caseCount){
        val targetNumber = scanner.nextInt()
        val resultOps = findExpr(listOf(Op.PLUS, Op.PLUS, Op.PLUS), targetNumber)
        val result = buildResult(resultOps)
        println(result)
    }
}

fun buildResult(resultOps: List<Op>): String {
    if (resultOps.isEmpty()) return "no solution"
    return resultOps.joinToString (" 4 ", "4", "4")
}

fun findExpr(opList: List<Op>, targetNum: Int) : List<Op> {
    if( calculateResult(opList) == targetNum ) return opList
    val minOp = opList.min() ?: return emptyList()
    if (minOp == Op.DIVIDE) return emptyList()
    val nextOps = Op.items.filter { it > minOp }
    for ((index, op) in opList.withIndex()) {
        if (op == minOp) {
            for (newOp in nextOps) {
                val newOpList : List<Op> = replaceOp(opList, index, newOp)
                val expr = findExpr(newOpList, targetNum)
                if( !expr.isEmpty() ) return expr
            }
        }
    }
    return emptyList()
}

fun replaceOp(opList: List<Op>, index: Int, newOp: Op): List<Op> {
    val left = opList.subList(0, index)
    val right = opList.subList(index + 1, opList.size)
    return left + newOp + right
}

sealed class Expr
data class Const(val number: Int) : Expr()
data class Operation(val op: Op) : Expr()



fun calculateResult(ops: List<Op>): Int {
    val exprList = buildExprList(ops)
    return evalExprList(exprList)
}

fun evalExprList(exprList: List<Expr>) : Int {
    val stack = Stack<Int>()
    fun eval(expr: Expr) {
        when (expr) {
            is Const -> stack.push(expr.number)
            is Operation -> {
                val arg2: Int = stack.pop()
                val arg1: Int = stack.pop()
                val result = when (expr.op) {
                    Op.PLUS -> arg1 + arg2
                    Op.MINUS -> arg1 - arg2
                    Op.MULT -> arg1 * arg2
                    Op.DIVIDE -> arg1 / arg2
                }
                stack.push(result)
            }
        }
    }
    exprList.forEach(::eval)
    return stack.pop()
}

fun buildExprList(ops: List<Op>): List<Expr> {
    val four = Const(4)
    var result = mutableListOf<Expr>()
    result.add(four)
    TODO("Not implemented")
//    for (op in ops) {
//        when (op) {
//
//        }
//    }
//    ops.sortedByDescending { it.priority }
}

