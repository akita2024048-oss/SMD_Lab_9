package questions

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 15. Three exports in a scope
 * Context: A report exports three files at the same time. Export X takes 300 ms,
 * Y takes 100 ms and Z takes 200 ms. The message "All done" must come after all three exports
 * and nothing may be joined by hand.
 *
 * Task: Under runBlocking print "Start", then use one coroutineScope with three launched
 * coroutines that print their name when finished, then print "All done".
 * The output must be Start, Y, Z, X, All done. No join and no delay in the main body.
 */
fun runQuestion15() = runBlocking {
    println("Start")
    coroutineScope {
        launch {
            delay(300L)
            println("X")
        }
        launch {
            delay(100L)
            println("Y")
        }
        launch {
            delay(200L)
            println("Z")
        }
    }
    println("All done")
}

fun main() {
    runQuestion15()
}
