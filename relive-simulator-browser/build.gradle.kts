import java.security.MessageDigest

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
  implementation(project(":relive-simulator-client"))
  implementation("io.ktor:ktor-client-js:$ktor_version")
  implementation("io.ktor:ktor-client-serialization:$ktor_version")
  implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.8.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

kotlin {
  sourceSets.all { languageSettings { languageVersion = "1.9" } }
  js(IR) {
    browser {
      webpackTask { cssSupport { enabled.set(true) } }

      runTask { cssSupport { enabled.set(true) } }

      testTask {
        useKarma {
          useChromeHeadless()
          webpackConfig.cssSupport { enabled.set(true) }
        }
      }
    }
    binaries.executable()
  }
  sourceSets.all { languageSettings { optIn("kotlin.RequiresOptIn") } }
}

tasks.register<Copy>("copyIndex") {
  from("${project(":relive-simulator-client").projectDir}/src/main/resources/index.html")
  into("$projectDir/src/main/resources/")
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
  from("${project(":relive-simulator-client").projectDir}/src/main/resources/sw.js")
  into("$projectDir/src/main/resources/")
  val imageDir = File("${project(":relive-simulator-client").projectDir}/src/main/resources/img/")
  val resourcesDir = File("${project(":relive-simulator-client").projectDir}/src/main/resources/")
  val md = MessageDigest.getInstance("SHA-1")
  fun hash(input: ByteArray): String {
    return BigInteger(1, md.digest(input)).toString(16).padStart(32, '0')
  }
  val imageData =
      fileTree(imageDir)
          .filter { it.isFile }
          .files
          .map { file ->
            file.relativeTo(resourcesDir).path.replace("\\", "/") to hash(file.readBytes())
          }
          .filter {
            !it.first.run {
              startsWith("img/acts") ||
                  startsWith("img/large_icon/19_") ||
                  startsWith("img/large_icon/35_") ||
                  startsWith("img/flags")
            }
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
{url: 'style.css', revision: '$timestamp'},
${imageData.joinToString(",\n") { (url, revision) -> "{url: '$url', revision: '$revision'}" }}
            """
            .trimIndent())
  }
}

tasks.register<Copy>("copyResources") {
  from("${project(":relive-simulator-client").projectDir}/src/main/resources/") {
    exclude("index.html", "sw.js")
  }
  into("$projectDir/src/main/resources/")
}

tasks.withType(org.gradle.language.jvm.tasks.ProcessResources::class) {
  dependsOn("copyIndex")
  dependsOn("copyResources")
  dependsOn("copyServiceWorker")
  dependsOn(":relive-simulator-worker:browserProductionWebpack")
}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrLink> {}
