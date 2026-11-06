package questions

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 6. Ten downloads, one thread
 * Context: A download manager has ten files, but the app is allowed to use only the main thread.
 * All downloads must make progress without waiting for each other.
 *
 * Task: Launch ten coroutines under runBlocking. Each prints "download i started" and the
 * thread name, waits and prints "download i finished". Show that all ten start before any finishes.
 * In the readme decide if this is concurrency or parallelism and why.
 */
fun runQuestion6() = runBlocking {
    for (i in 1..10) {
        launch {
            println("download $i started on [${Thread.currentThread().name}]")
            delay(100L)
            println("download $i finished on [${Thread.currentThread().name}]")
        }
    }
}

fun main() {
    runQuestion6()
}
