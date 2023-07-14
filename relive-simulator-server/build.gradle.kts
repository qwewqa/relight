val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val project_version: String by project

plugins {
  application
  kotlin("jvm")
  id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

application { mainClass.set("xyz.qwewqa.relive.simulator.server.ApplicationKt") }

repositories { mavenCentral() }

kotlin { sourceSets.all { languageSettings { languageVersion = "2.0" } } }

dependencies {
  implementation(project(":relive-simulator-core"))
  implementation(kotlin("stdlib"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
  implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.8.0")
  implementation("ch.qos.logback:logback-classic:$logback_version")
  implementation("io.ktor:ktor-server-compression:$ktor_version")
  implementation("io.ktor:ktor-server-caching-headers:$ktor_version")
  implementation("io.ktor:ktor-server-cors:$ktor_version")
  implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
  implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
  implementation("io.ktor:ktor-server-html-builder-jvm:$ktor_version")
  implementation("io.ktor:ktor-server-cio-jvm:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
  implementation("com.charleskorn.kaml:kaml:0.54.0")
  testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
}

tasks { getByName("run") { dependsOn(":relive-simulator-client:jsBrowserDevelopmentWebpack") } }

tasks.withType(org.gradle.language.jvm.tasks.ProcessResources::class) {
  mustRunAfter(":relive-simulator-client:jsBrowserDevelopmentWebpack")
  mustRunAfter(":relive-simulator-client:jsBrowserProductionWebpack")
}
