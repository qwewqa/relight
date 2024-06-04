import java.security.MessageDigest

val project_version: String by project
val ktor_version: String by project

plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

repositories {
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
  mavenCentral()
}

kotlin {
  js {
    browser { commonWebpackConfig { cssSupport { enabled.set(true) } } }
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
        implementation(project(":relive-simulator-client"))
        implementation("io.ktor:ktor-client-js:$ktor_version")
        implementation("io.ktor:ktor-client-serialization:$ktor_version")
        implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.8.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
      }
    }
  }
}

tasks.register<Copy>("copyIndex") {
  from("${project(":relive-simulator-client").projectDir}/src/jsMain/resources/index.html")
  into("$projectDir/src/jsMain/resources/")
  filter { line ->
    line
        .replace(
            "<!DOCTYPE html>", "<!DOCTYPE html>\n<!-- DO NOT EDIT. Generated from client file. -->")
        .replace("relive-simulator-client.js", "relive-simulator-browser.js")
        .replace(
            "<!-- PWA Placeholder (Do Not Remove) -->",
            """
                <link rel="manifest" href="manifest.json" />
                <script
                  type="module"
                  src="https://cdn.jsdelivr.net/npm/@pwabuilder/pwaupdate"
                ></script>
                <pwa-update swpath="sw.js"></pwa-update>
            """
                .trimIndent())
  }
}

tasks.register<Copy>("copyServiceWorker") {
  outputs.upToDateWhen { false }
  from("${project(":relive-simulator-client").projectDir}/src/jsMain/resources/sw.js")
  into("$projectDir/src/jsMain/resources/")
  val md = MessageDigest.getInstance("SHA-1")
  fun hash(input: ByteArray): String {
    return BigInteger(1, md.digest(input)).toString(16).padStart(32, '0')
  }
  val timestamp = System.currentTimeMillis()
  filter { line ->
    line.replace(
        "// Generated Precache Entries (Do Not Remove)",
        """
{url: 'index.html', revision: '$timestamp'},
{url: 'relive-simulator-browser.js', revision: '$timestamp'},
{url: 'relive-simulator-worker.js', revision: '$timestamp'},
{url: 'bootstrap-select.js', revision: '$timestamp'},
{url: 'options.json', revision: '$timestamp'},
{url: 'style.css', revision: '$timestamp'}
            """
            .trimIndent())
  }
}

tasks.register<Copy>("copyResources") {
  dependsOn(":relive-simulator-client:createVersionFile")
  from("${project(":relive-simulator-client").projectDir}/src/jsMain/resources/") {
    exclude("index.html", "sw.js")
  }
  into("$projectDir/src/jsMain/resources/")
}

tasks.register<Copy>("copyWorker") {
  dependsOn(":relive-simulator-worker:jsBrowserDistribution")
  from("${project(":relive-simulator-worker").projectDir}/build/dist/js/productionExecutable/")
  into("$projectDir/src/jsMain/resources/")
}

tasks.withType(org.gradle.language.jvm.tasks.ProcessResources::class) {
  dependsOn("copyIndex")
  dependsOn("copyResources")
  dependsOn("copyWorker")
  dependsOn("copyServiceWorker")
}
