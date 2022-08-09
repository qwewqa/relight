val project_version: String by project
val ktor_version: String by project

plugins {
    kotlin("js")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
}

group = "xyz.qwewqa.relive.simulator"
version = project_version

repositories {
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":relive-simulator-common"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation(npm("codemirror", "5.63.1"))
    implementation(npm("js-yaml", "4.1.0"))
    implementation(npm("sortablejs", "1.14.0"))
    implementation(npm("lz-string", "1.4.4"))
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
                freeCompilerArgs += listOf("-Xir-property-lazy-initialization", "-Xir-minimized-member-names=false")
                freeCompilerArgs +=  listOf("-Xir-minimized-member-names=false")
            }
        }
        binaries.executable()
    }
    sourceSets.all {
        languageSettings {
            optIn("kotlin.RequiresOptIn")
        }
    }
}
