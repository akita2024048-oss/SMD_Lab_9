package questions

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Question 4. Calling suspend from normal code
 * Context: A teammate wrote a normal function that calls a suspend function to load a user,
 * and the project does not compile.
 *
 * Task: Reproduce the compile error and write its message in the readme.
 * Fix it in two different ways. Say which fix you never use on the Android UI thread and why.
 */

suspend fun fetchUserData(): String {
    delay(100L)
    return "User: John Doe"
}

// Reproduction of compile error:
// If uncommented, this causes compilation error:
// "Suspend function 'fetchUserData' should be called only from a coroutine or another suspend function"
/*
fun normalFunctionCompileError() {
    val data = fetchUserData()
    println(data)
}
*/

// Fix 1: Make the calling function a suspend function
suspend fun fix1SuspendCaller(): String {
    val data = fetchUserData()
    return data
}

// Fix 2: Wrap the call in a coroutine builder such as runBlocking (bridges non-coroutine to coroutine world)
fun fix2UsingRunBlocking(): String {
    return runBlocking {
        fetchUserData()
    }
}

fun runQuestion4() {
    println("Demonstrating Fix 2 (runBlocking from regular code):")
    val result2 = fix2UsingRunBlocking()
    println("Result: $result2")

    println("\nDemonstrating Fix 1 (calling suspend function from coroutine):")
    runBlocking {
        val result1 = fix1SuspendCaller()
        println("Result: $result1")
    }
}

fun main() {
    runQuestion4()
}
