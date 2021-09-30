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
    js(IR) {
        browser()
        compilations.all {
            kotlinOptions {
                freeCompilerArgs += "-Xir-property-lazy-initialization"
            }
        }
    }
}

dependencies {
    "commonMainImplementation"(kotlin("stdlib"))
    "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    "commonMainImplementation"("com.github.h0tk3y.betterParse:better-parse:0.4.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.run {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
