package extras

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Extra 2. Three levels of coroutines
 * Context: A scope starts two children, and one of them starts a grandchild.
 * You must predict when each message appears and when the scope is finished.
 *
 * Task: Inside coroutineScope launch child 1 (it launches a grandchild that waits 200 ms
 * and prints "grandchild done", then child 1 prints "child 1 done") and child 2 (waits 100 ms
 * and prints "child 2 done"). Print "scope done" after the scope.
 * Draw the coroutine tree in the readme and explain why "scope done" is last.
 */
fun runExtra2() = runBlocking {
    coroutineScope {
        launch { // Child 1
            launch { // Grandchild
                delay(200L)
                println("grandchild done")
            }
            println("child 1 done")
        }
        launch { // Child 2
            delay(100L)
            println("child 2 done")
        }
    }
    println("scope done")
}

fun main() {
    runExtra2()
}
