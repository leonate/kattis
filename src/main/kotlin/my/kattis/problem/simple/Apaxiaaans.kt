package my.kattis.problem.simple

import java.util.*

fun main(args: Array<String>) {
    with(Scanner(System.`in`)) {
        val name = nextLine()
        println(convertToSimple(name))
    }

}

fun convertToSimple(name: String): String {
    return name.fold(Pair("", ' '), { acc, c -> if(acc.second == c) acc else Pair(acc.first + c, c) }).first
}
