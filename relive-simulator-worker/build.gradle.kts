val project_version: String by project
val ktor_version: String by project

plugins {
    kotlin("js")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
}

group = "xyz.qwewqa.relive.simulator"
version = project_version

repositories {
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":relive-simulator-core"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}

kotlin {
    js(IR) {
        browser {
            distribution {
                directory = File("${project(":relive-simulator-browser").projectDir}/src/main/resources")
            }

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
            kotlinOptions.freeCompilerArgs += "-Xir-property-lazy-initialization"
        }
        binaries.executable()
    }
    sourceSets.all {
        languageSettings {
            optIn("kotlin.RequiresOptIn")
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrLink> {
    kotlinOptions.freeCompilerArgs += "-Xir-property-lazy-initialization"
}
