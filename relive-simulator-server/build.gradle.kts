val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val project_version: String by project

plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.31"
    id("com.peterabeles.gversion")
}

group = "xyz.qwewqa.relive.simulator"
version = project_version
application {
    mainClass.set("xyz.qwewqa.relive.simulator.server.ApplicationKt")
}
gversion {
    srcDir = "src/main/kotlin"
    classPackage = "xyz.qwewqa.relive.simulator.server"
    language = "kotlin"
    indent = "    "
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation(project(":relive-simulator-core"))
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")
    implementation("io.ktor:ktor-html-builder:$ktor_version")
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
    implementation("com.charleskorn.kaml:kaml:0.36.0")
}

tasks {
    compileKotlin {
        dependsOn(createVersionFile)
    }
    getByName("run") {
        dependsOn(":relive-simulator-client:browserDevelopmentWebpack")
    }
    shadowJar {
        dependsOn(":relive-simulator-client:browserProductionWebpack")
    }
}
