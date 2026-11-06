package extras

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Extra 4. What the compiler sees
 * Context: In an interview you are asked what the compiler generates for a suspend function
 * that loads a user by id and returns a user.
 *
 * Task: Write such a function in IntelliJ IDEA, open Tools, Kotlin, Show Kotlin Bytecode
 * and press Decompile. Copy the generated signature into the readme.
 * Name the extra parameter and the new return type, and say what the extra parameter is used for.
 */

data class User(val id: Int, val name: String)

suspend fun loadUserById(id: Int): User {
    delay(100L)
    return User(id, "TTPU Student")
}

fun runExtra4() = runBlocking {
    val user = loadUserById(42)
    println("Loaded user: $user")
}

fun main() {
    runExtra4()
}
