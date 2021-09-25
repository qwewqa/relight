plugins {
    kotlin("multiplatform")
}

group = "xyz.qwewqa.relive.simulator"
version = "0.0.1"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js().browser()
}

dependencies {
    "commonMainImplementation"(kotlin("stdlib"))
    "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.run {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
