package questions

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 2. Three baristas
 * Context: Three baristas make drinks at the same time on one thread:
 * espresso needs 300 ms, tea 100 ms and latte 200 ms. A teammate says it is
 * the same if you use a sleep instead of a suspension.
 *
 * Task: Launch three coroutines, each prints "start", waits with delay and prints "end".
 * Write the output. Then replace delay with Thread.sleep and write the new output.
 * Explain in one sentence what the thread does in each case.
 */
fun runBaristasWithDelay() = runBlocking {
    println("=== Running with delay (Suspension) ===")
    launch {
        println("Espresso start")
        delay(300L)
        println("Espresso end")
    }
    launch {
        println("Tea start")
        delay(100L)
        println("Tea end")
    }
    launch {
        println("Latte start")
        delay(200L)
        println("Latte end")
    }
}

fun runBaristasWithSleep() = runBlocking {
    println("\n=== Running with Thread.sleep (Blocking) ===")
    launch {
        println("Espresso start")
        Thread.sleep(300L)
        println("Espresso end")
    }
    launch {
        println("Tea start")
        Thread.sleep(100L)
        println("Tea end")
    }
    launch {
        println("Latte start")
        Thread.sleep(200L)
        println("Latte end")
    }
}

fun runQuestion2() {
    runBaristasWithDelay()
    runBaristasWithSleep()
}

fun main() {
    runQuestion2()
}
