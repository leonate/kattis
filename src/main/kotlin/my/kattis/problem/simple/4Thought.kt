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
    println(Op.PLUS < Op.MINUS)
    val ops = listOf(Op.MINUS, Op.MULT, Op.DIVIDE, Op.PLUS)
    for (op in ops) {
        println(op.ordinal)
        println(op.name)
    }
    println(Op.items[2])
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

data class Node(val op : Op, val left: Node, val right: Node){
    fun add(newOp: Op){

    }
}

fun calculateResult(ops: List<Op>): Int {
    val first = ops[0]
    val second = ops[1]
    val third = ops[2]
    val root : Node
    for (op in ops) {

    }
    TODO("Not implemented")
}

