import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

val project_version: String by project
val api_version: String by project

plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
  id("com.peterabeles.gversion")
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

gversion {
  srcDir = "src/commonMain/kotlin"
  classPackage = "xyz.qwewqa.relive.simulator.common"
  language = "kotlin"
  indent = "  "
}

repositories { mavenCentral() }

kotlin {
  jvm { testRuns["test"].executionTask.configure { useJUnitPlatform() } }

  js { browser() }

  sourceSets {
    all {
      languageSettings {
        optIn("kotlin.RequiresOptIn")
        languageVersion = "2.0"
      }
    }

    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))
        implementation("com.github.h0tk3y.betterParse:better-parse:0.4.4")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
      }
    }

    val commonTest by getting {
      dependencies {
        implementation(kotlin("test"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
      }
    }
  }
}

task("generateApiVersionFile") {
  doLast {
    file("$projectDir/src/commonMain/kotlin/xyz/qwewqa/relive/simulator/common/ApiVersion.kt")
        .writeText(
            """
            package xyz.qwewqa.relive.simulator.common
            
            internal const val API_VERSION = $api_version
        """
                .trimIndent())
  }
}

tasks.withType<KotlinCompilationTask<*>>().configureEach {
  dependsOn("generateApiVersionFile")
  dependsOn("createVersionFile")
}
