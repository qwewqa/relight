val project_version: String by project
val ktor_version: String by project

plugins {
    kotlin("js")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
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
    implementation(project(":relive-simulator-core"))
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
}

kotlin {
    js(IR) {
        browser {
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
    sourceSets.all {
        languageSettings {
            optIn("kotlin.RequiresOptIn")
        }
    }
}

tasks.register<Copy>("copyIndex") {
    from("${project(":relive-simulator-client").projectDir}/src/main/resources/index.html")
    into("$projectDir/src/main/resources/")
    val imageDir = File("$projectDir/src/main/resources/img/")
    val resourcesDir = File("$projectDir/src/main/resources/")
    val imagePaths = fileTree(imageDir).filter { it.isFile }.files.map {
        "/${it.relativeTo(resourcesDir).path.replace("\\", "/")}"
    }
    val timestamp = System.currentTimeMillis()
    filter { line ->
        line
            .replace("<!DOCTYPE html>", "<!DOCTYPE html>\n<!-- DO NOT EDIT. Generated from client file. -->")
            .replace("relive-simulator-client.js", "relive-simulator-browser.js")
            .replace(
                "<!-- PWA Placeholder (Do Not Remove) -->", """
                <link rel="manifest" href="manifest.json" />
                    <script type="module">
                       import 'https://cdn.jsdelivr.net/npm/@pwabuilder/pwaupdate';
                       const el = document.createElement('pwa-update');
                       document.body.appendChild(el);
                    </script>
            """.trimIndent()
            )
    }
}

tasks.register<Copy>("copyPwabuilder") {
    from("${project(":relive-simulator-client").projectDir}/src/main/resources/pwabuilder-sw.js")
    into("$projectDir/src/main/resources/")
    val imageDir = File("$projectDir/src/main/resources/img/")
    val resourcesDir = File("$projectDir/src/main/resources/")
    val imagePaths = fileTree(imageDir).filter { it.isFile }.files.map {
        "/${it.relativeTo(resourcesDir).path.replace("\\", "/")}"
    }
    val timestamp = System.currentTimeMillis()
    filter { line ->
        line
            .replace(
                "// Generated Precache Entries (Do Not Remove)", """
                {url: '/index.html', revision: '$timestamp'},
                {url: '/relive-simulator-browser.js', revision: '$timestamp'},
                {url: '/relive-simulator-worker.js', revision: '$timestamp'},
                {url: '/options.json', revision: '$timestamp'},
                ${imagePaths.joinToString(",\n") { "{url: '$it', revision: null}" }}
            """.trimIndent()
            )
    }
}

tasks.register<Copy>("copyResources") {
    from("${project(":relive-simulator-client").projectDir}/src/main/resources/") {
        exclude("index.html", "pwabuilder-sw.js")
    }
    into("$projectDir/src/main/resources/")
}

tasks.withType(org.gradle.language.jvm.tasks.ProcessResources::class) {
    dependsOn("copyIndex")
    dependsOn("copyPwabuilder")
    dependsOn("copyResources")
    dependsOn(":relive-simulator-worker:browserProductionWebpack")
}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrLink> {
    kotlinOptions.freeCompilerArgs += "-Xir-property-lazy-initialization"
}
