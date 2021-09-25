plugins {
    kotlin("jvm")
}

group = "xyz.qwewqa.relive.simulator"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":relive-simulator-core"))
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}
