package extras

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Extra 1. Delay or sleep: measure it
 * Context: A project manager claims that three waits of 300 ms always cost 900 ms,
 * no matter how they are written.
 *
 * Task: Measure with measureTimeMillis: three launched coroutines with delay,
 * then three with Thread.sleep, both inside coroutineScope.
 * Print both times rounded to hundreds.
 * Explain why the numbers differ although the thread is the same.
 */
fun runExtra1() = runBlocking {
    println("--- Measuring delay inside coroutineScope ---")
    val delayDuration = measureTimeMillis {
        coroutineScope {
            launch { delay(300L) }
            launch { delay(300L) }
            launch { delay(300L) }
        }
    }
    val roundedDelay = Math.round(delayDuration / 100.0) * 100
    println("delay time: ${delayDuration}ms (rounded: ~${roundedDelay.toLong()}ms)")

    println("\n--- Measuring Thread.sleep inside coroutineScope ---")
    val sleepDuration = measureTimeMillis {
        coroutineScope {
            launch { Thread.sleep(300L) }
            launch { Thread.sleep(300L) }
            launch { Thread.sleep(300L) }
        }
    }
    val roundedSleep = Math.round(sleepDuration / 100.0) * 100
    println("Thread.sleep time: ${sleepDuration}ms (rounded: ~${roundedSleep.toLong()}ms)")
}

fun main() {
    runExtra1()
}
