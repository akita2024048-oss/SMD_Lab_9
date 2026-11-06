package questions

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 9. Screen closed, requests cancelled
 * Context: A user closes a screen while two network requests are still running.
 * Both requests must stop at once and must print a cleanup message.
 *
 * Task: Launch a parent coroutine with two child coroutines.
 * Each child waits one second inside a try block and prints a cleanup message in finally.
 * Cancel the parent after 100 ms with cancelAndJoin and print "end".
 * Explain why the children stop although you cancelled only the parent.
 */
fun runQuestion9() = runBlocking {
    val parentJob = launch {
        launch {
            try {
                delay(1000L)
                println("Request 1 completed successfully")
            } finally {
                println("Request 1 cleanup completed")
            }
        }
        launch {
            try {
                delay(1000L)
                println("Request 2 completed successfully")
            } finally {
                println("Request 2 cleanup completed")
            }
        }
    }

    delay(100L)
    println("Closing screen: cancelling parent job...")
    parentJob.cancelAndJoin()
    println("end")
}

fun main() {
    runQuestion9()
}
