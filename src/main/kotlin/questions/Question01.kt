package questions

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 1. First coroutine
 * Context: A cafe app must confirm the order at once, while the coffee itself needs
 * one second to prepare. The confirmation must not wait for the coffee.
 *
 * Task: Build console app with runBlocking where a launched coroutine waits one second
 * with delay and prints "Coffee ready", while the main body prints "Order accepted"
 * right after the launch.
 */
fun runQuestion1() = runBlocking {
    launch {
        delay(1000L)
        println("Coffee ready")
    }
    println("Order accepted")
}

fun main() {
    runQuestion1()
}
