plugins {
    kotlin("jvm") version "1.5.31"
}

group = "xyz.qwewqa.relive.simulator.jvm"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":relive-simulator-core"))
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}
