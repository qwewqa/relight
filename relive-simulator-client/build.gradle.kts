val project_version: String by project
val ktor_version: String by project

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

repositories {
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
  mavenCentral()
}

kotlin {
  js {
    browser {
      distribution {
        directory =
            File("${project(":relive-simulator-server").projectDir}/src/main/resources/client")
      }

      commonWebpackConfig { cssSupport { enabled.set(true) } }
    }
    binaries.executable()
  }

  sourceSets {
    all {
      languageSettings {
        optIn("kotlin.RequiresOptIn")
        languageVersion = "2.0"
      }
    }

    val jsMain by getting {
      dependencies {
        implementation(kotlin("stdlib-js"))
        api(project(":relive-simulator-core"))
        implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.8.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
        implementation(npm("codemirror", "6.0.1"))
        implementation(npm("js-yaml", "4.1.0"))
        implementation(npm("sortablejs", "1.14.0"))
        implementation(npm("lz-string", "1.4.4"))
        implementation(npm("plotly.js-dist-min", "2.23.2"))
      }
    }
  }
}
