package my.kattis.problem.simple

import java.util.*

fun main(args: Array<String>) {
    with(Scanner(System.`in`)){
        val n = nextInt()
        for(i in 1..n){
            val r = nextInt()
            val e = nextInt()
            val c = nextInt()
            println(advertiseOrNot(r, e, c))
        }
    }

}

fun advertiseOrNot(r: Int, e: Int, c: Int): String {
    if(e == r + c) return "does not matter"
    return if(e < r + c) "do not advertise" else "advertise"
}
