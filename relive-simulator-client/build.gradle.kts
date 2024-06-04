import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

val project_version: String by project
val ktor_version: String by project

plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
  id("com.peterabeles.gversion")
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

repositories {
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
  mavenCentral()
}

gversion {
  srcDir = "src/jsMain/resources"
  classPackage = ""
  className = "version"
  language = "yaml"
}

kotlin {
  js {
    browser {
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
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0-RC")
        implementation(npm("codemirror", "6.0.1"))
        implementation(npm("js-yaml", "4.1.0"))
        implementation(npm("sortablejs", "1.14.0"))
        implementation(npm("lz-string", "1.4.4"))
        implementation(npm("plotly.js-dist-min", "2.23.2"))
      }
    }
  }
}

tasks.withType<KotlinCompilationTask<*>>().configureEach {
  dependsOn("createVersionFile")
}
