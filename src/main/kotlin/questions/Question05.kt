package questions

import kotlinx.coroutines.runBlocking

/**
 * Question 5. Suspend is not a thread
 * Context: A junior developer believes that marking a function suspend moves its work
 * to a background thread.
 *
 * Task: Write a suspend function that returns the name of the current thread.
 * Call it from runBlocking and print the thread name before the call and the returned one.
 * Prove or disprove the belief with your output.
 * Name the hidden parameter that the compiler adds to every suspend function.
 */
suspend fun retrieveCurrentThreadName(): String {
    return Thread.currentThread().name
}

fun runQuestion5() = runBlocking {
    val threadBefore = Thread.currentThread().name
    val threadFromSuspend = retrieveCurrentThreadName()

    println("Thread name before call: $threadBefore")
    println("Thread name inside suspend function: $threadFromSuspend")
    println("Did the thread change? ${threadBefore != threadFromSuspend}")
}

fun main() {
    runQuestion5()
}
