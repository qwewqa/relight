val project_version: String by project
val ktor_version: String by project

plugins {
  kotlin("js")
  id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

repositories {
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-js"))
  api(project(":relive-simulator-core"))
  implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.8.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
  implementation("io.ktor:ktor-client-js:$ktor_version")
  implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
  implementation(npm("codemirror", "6.0.1"))
  implementation(npm("js-yaml", "4.1.0"))
  implementation(npm("sortablejs", "1.14.0"))
  implementation(npm("lz-string", "1.4.4"))
}

kotlin {
  sourceSets.all {
    languageSettings {
      languageVersion = "1.9"
    }
  }
  js(IR) {
    browser {
      distribution {
        directory =
            File("${project(":relive-simulator-server").projectDir}/src/main/resources/client")
      }

      webpackTask { cssSupport { enabled.set(true) } }

      runTask { cssSupport { enabled.set(true) } }

      testTask {
        useKarma {
          useChromeHeadless()
          webpackConfig.cssSupport { enabled.set(true) }
        }
      }
    }
    compilations.all {
      kotlinOptions {
        freeCompilerArgs +=
            listOf("-Xir-property-lazy-initialization", "-Xir-minimized-member-names=false")
        freeCompilerArgs += listOf("-Xir-minimized-member-names=false")
      }
    }
    binaries.executable()
  }
  sourceSets.all { languageSettings { optIn("kotlin.RequiresOptIn") } }
}
