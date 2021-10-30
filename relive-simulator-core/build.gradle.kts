val project_version: String by project

plugins {
    kotlin("multiplatform")
    id("java-library")
    jacoco
}

group = "xyz.qwewqa.relive.simulator"
version = project_version

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser()
        compilations.all {
            kotlinOptions {
                freeCompilerArgs += "-Xir-property-lazy-initialization"
            }
        }
    }
}

jacoco {
    toolVersion = "0.8.7"
}

tasks.jacocoTestReport {
    dependsOn("jvmTest")

    val coverageSourceDirs = arrayOf(
        "src/commonMain",
        "src/jvmMain"
    )

    sourceDirectories.setFrom(files(coverageSourceDirs))

    classDirectories.setFrom(
        fileTree("${buildDir}/classes/kotlin/jvm/") {
            exclude("**/generated/")
        }
    )

    executionData.setFrom(files("${buildDir}/jacoco/jvmTest.exec"))

    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

dependencies {
    "commonMainImplementation"(kotlin("stdlib"))
    "commonTestImplementation"(kotlin("test"))
    "commonMainApi"(project(":relive-simulator-common"))
    "commonMainImplementation"("com.github.h0tk3y.betterParse:better-parse:0.4.2")
    "commonTestImplementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.run {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
