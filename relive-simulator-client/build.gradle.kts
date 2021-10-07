val ktor_version: String by project

plugins {
    kotlin("js")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.31"
}

group = "xyz.qwewqa.relive.simulator"
version = "0.0.1"

repositories {
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("net.mamoe.yamlkt:yamlkt:0.10.2")
    implementation(npm("codemirror", "5.63.1"))
}

kotlin {
    js(IR) {
        browser {
            distribution {
                directory = File("${project(":relive-simulator-server").projectDir}/src/main/resources/client")
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
            kotlinOptions {
                freeCompilerArgs += "-Xir-property-lazy-initialization"
            }
        }
        binaries.executable()
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.run {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
