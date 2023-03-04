val project_version: String by project
val api_version: String by project

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
  id("com.peterabeles.gversion")
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

gversion {
  srcDir = "src/commonMain/kotlin"
  classPackage = "xyz.qwewqa.relive.simulator.common"
  language = "kotlin"
  indent = "    "
}

repositories { mavenCentral() }

kotlin {
  jvm()
  js(IR) {
    browser()
    compilations.all {
      kotlinOptions.freeCompilerArgs +=
          listOf("-Xir-property-lazy-initialization", "-Xir-minimized-member-names=false")
    }
  }
}

dependencies {
  "commonMainImplementation"(kotlin("stdlib"))
  "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")
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

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrLink> {
  kotlinOptions.freeCompilerArgs +=
      listOf("-Xir-property-lazy-initialization", "-Xir-minimized-member-names=false")
}

tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class) {
  dependsOn("generateApiVersionFile")
  dependsOn("createVersionFile")
}
