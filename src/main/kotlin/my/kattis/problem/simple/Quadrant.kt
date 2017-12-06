package my.kattis.problem.simple

import java.util.*

fun findQuadrant(x: Int, y: Int): Int {
    if (x > 0){
        return if (y > 0) 1 else 4
    }else{
        return if (y > 0) 2 else 3
    }
}

fun main(args: Array<String>) {
    with(Scanner(System.`in`)){
        val x = nextInt()
        val y = nextInt()
        println(findQuadrant(x, y))
    }

}