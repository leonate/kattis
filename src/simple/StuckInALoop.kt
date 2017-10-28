package simple

import java.util.*

fun main(args: Array<String>) {
    with(Scanner(System.`in`)){
        val n = nextInt()
        (1..n).forEach{ println("$it Abracadabra") }
    }
}