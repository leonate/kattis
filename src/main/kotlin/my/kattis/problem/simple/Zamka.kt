package my.kattis.problem.simple

import java.util.*

fun main(args: Array<String>) {
    with(Scanner(System.`in`)){
        val l = nextInt()
        val d = nextInt()
        val x = nextInt()
        var minResult = -1
        for(i in l..d){
            val sumDigits = calculateDigitSum(i)
            if( sumDigits == x ){
                minResult = i
                break
            }
        }
        println(minResult)
        var maxResult = -1
        for(i in d downTo l){
            val sumDigits = calculateDigitSum(i)
            if( sumDigits == x ){
                maxResult = i
                break
            }
        }
        println(maxResult)
    }

}

fun calculateDigitSum(n: Int): Int = n.toString().fold(0, { acc, c -> acc + c.toString().toInt() })