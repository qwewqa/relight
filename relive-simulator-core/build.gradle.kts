val project_version: String by project

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
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
                freeCompilerArgs += listOf("-Xir-property-lazy-initialization", "-Xir-minimized-member-names=false")
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
    "commonMainImplementation"("com.github.h0tk3y.betterParse:better-parse:0.4.4")
    "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    "commonTestImplementation"(kotlin("test"))
    "commonTestImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}
