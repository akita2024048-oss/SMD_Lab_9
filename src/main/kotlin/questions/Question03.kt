package questions

import kotlinx.coroutines.delay

/**
 * Question 3. Chain of suspend functions
 * Context: A login flow has three steps: load the user, check the password and open the profile.
 * Each step takes some time and must run strictly after the previous one.
 *
 * Task: Write three suspend functions where each one calls the next, with a delay
 * and a printed step name in each. Call the first one from a suspend main.
 * Show that suspending does not reorder your lines.
 */
suspend fun loadUser() {
    println("Step 1: Loading user...")
    delay(100L)
    checkPassword()
}

suspend fun checkPassword() {
    println("Step 2: Checking password...")
    delay(100L)
    openProfile()
}

suspend fun openProfile() {
    println("Step 3: Opening profile...")
    delay(100L)
    println("Step 3 completed: Profile is open.")
}

suspend fun runQuestion3() {
    println("--- Login flow started ---")
    loadUser()
    println("--- Login flow finished ---")
}

suspend fun main() {
    runQuestion3()
}
