package extras

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Extra 3. No scope, no launch
 * Context: A new teammate writes a plain main function and calls the launch builder directly.
 * The compiler refuses it.
 *
 * Task: Reproduce the error and write its message in the readme.
 * Fix it with the builder used in the first example of the lecture.
 * Explain what that builder does with the current thread.
 */

// Reproduction of error (commented out):
// Calling launch directly in normal main:
/*
fun plainMain() {
    launch {
        println("This will not compile!")
    }
}
// Compiler Error Message:
// "Unresolved reference: launch"
// (because launch is an extension function on CoroutineScope and requires a scope receiver)
*/

// Fix using runBlocking (the builder used in the first example of the lecture):
fun runExtra3() = runBlocking {
    launch {
        delay(100L)
        println("Fixed: Coroutine running inside runBlocking scope")
    }
    println("Main executing inside runBlocking")
}

fun main() {
    runExtra3()
}
