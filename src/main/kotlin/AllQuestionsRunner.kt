package questions

import extras.*
import kotlinx.coroutines.runBlocking

/**
 * Convenience runner to execute all practical questions in sequence.
 */
fun main() = runBlocking {
    println("==================================================")
    println("         COROUTINES PRACTICE RUNNER")
    println("==================================================")

    println("\n>>> Question 1: First coroutine")
    runQuestion1()

    println("\n>>> Question 2: Three baristas")
    runQuestion2()

    println("\n>>> Question 3: Chain of suspend functions")
    runQuestion3()

    println("\n>>> Question 4: Calling suspend from normal code")
    runQuestion4()

    println("\n>>> Question 5: Suspend is not a thread")
    runQuestion5()

    println("\n>>> Question 6: Ten downloads, one thread")
    runQuestion6()

    println("\n>>> Question 7: Order of launch")
    runQuestion7()

    println("\n>>> Question 8: Parent waits for child")
    runQuestion8()

    println("\n>>> Question 9: Screen closed, requests cancelled")
    runQuestion9()

    println("\n>>> Question 10: Profile ready")
    runQuestion10()

    println("\n>>> Question 11: Reusable counter")
    runQuestion11()

    println("\n>>> Question 12: Returns at once or waits")
    runQuestion12()

    println("\n>>> Question 13: Five builders")
    runQuestion13()

    println("\n>>> Question 14: Job or Deferred")
    runQuestion14()

    println("\n>>> Question 15: Three exports in a scope")
    runQuestion15()

    println("\n>>> Extra 1: Delay or sleep: measure it")
    runExtra1()

    println("\n>>> Extra 2: Three levels of coroutines")
    runExtra2()

    println("\n>>> Extra 3: No scope, no launch")
    runExtra3()

    println("\n>>> Extra 4: What the compiler sees")
    runExtra4()

    println("\n>>> Extra 5: Greet everybody")
    runExtra5()

    println("\n==================================================")
    println("           ALL QUESTIONS COMPLETED")
    println("==================================================")
}
