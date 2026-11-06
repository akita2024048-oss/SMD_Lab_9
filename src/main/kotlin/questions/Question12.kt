package questions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 12. Returns at once or waits
 * Context: The team needs two helpers for greetings: one that starts a greeter
 * in the background and returns immediately, and another that greets several people
 * and returns only when all greetings are printed.
 *
 * Task: Implement the first helper as an extension on CoroutineScope and the second
 * as a suspend function with coroutineScope. In main call both and print a line after each call.
 * Show with the output which one returns at once and which one waits.
 */
fun CoroutineScope.greetInBackground(name: String): Job = launch {
    delay(100L)
    println("Greeting in background: Hello, $name!")
}

suspend fun greetAll(names: List<String>) = coroutineScope {
    for (name in names) {
        launch {
            delay(100L)
            println("Greeting in scope: Hello, $name!")
        }
    }
}

fun runQuestion12() = runBlocking {
    println("Calling greetInBackground...")
    greetInBackground("Alice")
    println("greetInBackground returned immediately!")

    println("\nCalling greetAll...")
    greetAll(listOf("Bob", "Charlie"))
    println("greetAll returned only after all finished!")
}

fun main() {
    runQuestion12()
}
