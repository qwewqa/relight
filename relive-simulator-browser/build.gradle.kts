val project_version: String by project
val ktor_version: String by project

plugins {
    kotlin("js")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.31"
}

group = "xyz.qwewqa.relive.simulator"
version = project_version

repositories {
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":relive-simulator-client"))
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}

kotlin {
    js(IR) {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        compilations.all {
            kotlinOptions {
                freeCompilerArgs += "-Xir-property-lazy-initialization"
            }
        }
        binaries.executable()
    }
}

tasks.register<Copy>("copyResources") {
    from("${project(":relive-simulator-client").projectDir}/src/main/resources/index.html")
    into("$projectDir/src/main/resources/")
    filter { line ->
        line
            .replace("<!DOCTYPE html>", "<!DOCTYPE html>\n<!-- DO NOT EDIT. Generated from client file. -->")
            .replace("relive-simulator-client.js", "relive-simulator-browser.js")
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class) {
    dependsOn("copyResources")
    dependsOn(":relive-simulator-worker:browserProductionWebpack")
    kotlinOptions.run {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
