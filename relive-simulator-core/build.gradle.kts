val project_version: String by project

plugins {
    kotlin("multiplatform")
}

group = "xyz.qwewqa.relive.simulator"
version = project_version

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser()
        compilations.all {
            kotlinOptions {
                freeCompilerArgs += "-Xir-property-lazy-initialization"
            }
        }
    }
    sourceSets.all {
        languageSettings {
            optIn("kotlin.RequiresOptIn")
        }
    }
}

dependencies {
    "commonMainApi"(project(":relive-simulator-common"))
    "commonMainImplementation"(kotlin("stdlib"))
    "commonMainImplementation"("com.github.h0tk3y.betterParse:better-parse:0.4.3")
    "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    "commonTestImplementation"(kotlin("test"))
    "commonTestImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    "commonTestImplementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}
