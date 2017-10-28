package simple

import java.util.*

fun main(args: Array<String>) {
    with(Scanner(System.`in`)){
        var n = nextInt()
        while(n != -1){
            var distance = 0
            var prevTime = 0
            for(i in 1..n){
                val speed = nextInt()
                val time = nextInt()
                distance += speed * (time - prevTime)
                prevTime = time
            }
            println("$distance miles")
            n = nextInt()
        }
    }
}

