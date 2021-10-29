val project_version: String by project

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.31"
}

group = "xyz.qwewqa.relive.simulator"
version = project_version

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js(IR) {
        browser()
    }
}

dependencies {
    "commonMainImplementation"(kotlin("stdlib"))
    "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.0")
}
