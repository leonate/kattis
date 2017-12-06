package my.kattis.problem.simple

import java.util.*

fun main(args: Array<String>) {
    with(Scanner(System.`in`)){
        val say = nextLine()
        val hear = nextLine()
        println (if (say.length < hear.length) "no" else "go")
    }

}