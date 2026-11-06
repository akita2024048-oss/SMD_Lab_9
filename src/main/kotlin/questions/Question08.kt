package questions

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 8. Parent waits for child
 * Context: A report task starts a sub task that compresses attachments for 200 ms.
 * The report must be marked completed only after the sub task is finished,
 * even if the report body itself finishes earlier.
 *
 * Task: Launch a parent coroutine that launches a child coroutine and prints "parent body done".
 * The child waits and prints "child done". In main wait for the parent with join and print "report completed".
 * Explain which rule of structured concurrency gives this order.
 */
fun runQuestion8() = runBlocking {
    val parentJob = launch {
        launch {
            delay(200L)
            println("child done")
        }
        println("parent body done")
    }

    parentJob.join()
    println("report completed")
}

fun main() {
    runQuestion8()
}
