package extras

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Extra 5. Greet everybody
 * Context: A greeting service gets a list of names and must greet them one by one
 * with growing pauses, but it must report "after" only when the last greeting is done.
 *
 * Task: Write a suspend function with coroutineScope that takes a list of names and,
 * for name number i (from 1), launches a coroutine that waits i * 100 ms and prints "Hello, name".
 * In main print "before", call it with Ada, Linus and Grace, then print "after".
 * Explain why "after" is last.
 */
suspend fun greetEverybody(names: List<String>) = coroutineScope {
    for ((index, name) in names.withIndex()) {
        val i = index + 1 // 1-based index (1, 2, 3...)
        launch {
            delay(i * 100L)
            println("Hello, $name")
        }
    }
}

fun runExtra5() = runBlocking {
    println("before")
    greetEverybody(listOf("Ada", "Linus", "Grace"))
    println("after")
}

fun main() {
    runExtra5()
}
