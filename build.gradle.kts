plugins {
    kotlin("jvm") version "2.0.21"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

application {
    mainClass.set("questions.AllQuestionsRunnerKt")
}

kotlin {
    jvmToolchain(19)
}
