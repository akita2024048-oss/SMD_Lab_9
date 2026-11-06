package questions

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 13. Five builders
 * Context: A new student mixes up the builders and does not know what each one returns
 * or whether it blocks the thread.
 *
 * Task: Write a small program that uses launch, async, runBlocking and coroutineScope once each
 * and prints what you get back from each one. In the readme write the cheat sheet for all
 * five builders from the lecture, including withContext: what it returns, does it block the thread,
 * does it wait for children.
 */
fun runQuestion13() {
    val runBlockingResult = runBlocking {
        val launchResult = launch {
            delay(50L)
            println("launch executed")
        }

        val asyncResult = async {
            delay(50L)
            42
        }

        val coroutineScopeResult = coroutineScope {
            delay(50L)
            "Scope finished"
        }

        println("launch returned: $launchResult")
        println("async returned: $asyncResult")
        println("async.await() returned: ${asyncResult.await()}")
        println("coroutineScope returned: $coroutineScopeResult")

        "runBlocking completed successfully"
    }

    println("runBlocking returned: $runBlockingResult")
}

fun main() {
    runQuestion13()
}
