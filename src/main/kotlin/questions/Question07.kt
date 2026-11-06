package questions

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 7. Order of launch
 * Context: A screen prints a loading message, starts a background step and then continues with its own work.
 * The team lead is surprised that the background step does not run at the moment it is started.
 *
 * Task: Under runBlocking print "1", launch a coroutine that prints "2", waits 100 ms and prints "3",
 * then print "4", wait 50 ms and print "5". Predict the output before you run it.
 * Explain why "2" does not come right after "1".
 */
fun runQuestion7() = runBlocking {
    println("1")
    launch {
        println("2")
        delay(100L)
        println("3")
    }
    println("4")
    delay(50L)
    println("5")
}

fun main() {
    runQuestion7()
}
