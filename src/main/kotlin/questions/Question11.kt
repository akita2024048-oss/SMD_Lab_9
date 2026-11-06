package questions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 11. Reusable counter
 * Context: Several screens start the same kind of ticking counter, and the team
 * wants one reusable function instead of copying the launch code.
 * The function must return at once and the new coroutine must belong to the caller scope.
 *
 * Task: Write an extension function on CoroutineScope that starts a counter coroutine,
 * prints name and number every 100 ms up to a given number and returns its Job.
 * Start two counters with different limits inside coroutineScope and print "launched"
 * before the first number. Explain why the receiver is needed.
 */
fun CoroutineScope.startCounter(name: String, limit: Int): Job = launch {
    for (i in 1..limit) {
        delay(100L)
        println("$name: $i")
    }
}

fun runQuestion11() = runBlocking {
    coroutineScope {
        startCounter("Counter A", 3)
        startCounter("Counter B", 5)
        println("launched")
    }
}

fun main() {
    runQuestion11()
}
