package questions

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Question 14. Job or Deferred
 * Context: A developer needs the result of a calculation (six times seven),
 * started it with launch and cannot get the value out of it.
 *
 * Task: Write the launch version and show why it cannot give a result.
 * Then write the async version that returns a Deferred and print 42 with await.
 * In the readme explain the difference between Job and Deferred.
 */
fun runQuestion14() = runBlocking {
    println("--- 1. Launch version ---")
    val job = launch {
        val result = 6 * 7
        // Notice: 'result' is local to this lambda.
        // launch returns Job, which represents only a lifecycle handle, not a result value.
    }
    println("job type: ${job::class.java.simpleName}")
    println("job has no .await() or result value accessor. Job returns Unit.\n")

    println("--- 2. Async version ---")
    val deferred = async {
        val result = 6 * 7
        result
    }
    val value = deferred.await()
    println("deferred type: ${deferred::class.java.simpleName}")
    println("deferred.await() returned: $value")
}

fun main() {
    runQuestion14()
}
