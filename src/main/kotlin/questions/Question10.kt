package questions

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 10. Profile ready
 * Context: A profile screen loads avatar (200 ms) and settings (100 ms) at the same time.
 * The message "Profile ready" must appear only after both are loaded.
 *
 * Task: Use coroutineScope with two launched coroutines. Print "Profile ready" right after the scope.
 * Then launch one more coroutine after the scope and show that "end of main" is printed before it.
 * Explain the difference between the two cases.
 */
fun runQuestion10() = runBlocking {
    coroutineScope {
        launch {
            delay(200L)
            println("Avatar loaded (200 ms)")
        }
        launch {
            delay(100L)
            println("Settings loaded (100 ms)")
        }
    }
    println("Profile ready")

    launch {
        delay(50L)
        println("Background task after scope finished")
    }
    println("end of main")
}

fun main() {
    runQuestion10()
}
