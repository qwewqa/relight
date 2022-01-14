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
}

dependencies {
    "commonMainImplementation"(kotlin("stdlib"))
    "commonTestImplementation"(kotlin("test"))
    "commonMainApi"(project(":relive-simulator-common"))
    "commonMainImplementation"("com.github.h0tk3y.betterParse:better-parse:0.4.3")
    "commonTestImplementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.run {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
