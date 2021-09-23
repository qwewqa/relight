plugins {
    kotlin("multiplatform") version "1.5.31"
}

group = "xyz.qwewqa"
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
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.run {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
