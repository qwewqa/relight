package xyz.qwewqa.relive.simulator.client

import kotlin.js.Promise
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.dom.removeClass
import kotlinx.serialization.Serializable
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import xyz.qwewqa.relive.simulator.common.GIT_SHA

@OptIn(DelicateCoroutinesApi::class)
fun initSiteInfo() {
  val storageUseDiv = window.document.getElementById("storage-use") as HTMLDivElement
  GlobalScope.launch {
    while (true) {
      val estimate = getStorageEstimate() ?: break
      val usedMb = estimate.usage / 1_000_000.0
      val quotaMb = estimate.quota / 1_000_000.0
      val percent = usedMb / quotaMb * 100
      storageUseDiv.innerText = "${usedMb.toFixed(1)}MB (${percent.toFixed(1)}%)"
      delay(30000)
    }
  }

  val buildInfo = window.document.getElementById("build-info") as HTMLDivElement
  buildInfo.textContent = GIT_SHA.take(7)

  val versionUpdateIcon = window.document.getElementById("version-update-icon") as HTMLElement
  val versionLink = window.document.getElementById("version-link") as HTMLElement
  GlobalScope.launch {
    while (true) {
      val versionInfo = getLiveVersionInfo()
      if (versionInfo != null) {
        if (versionInfo.GIT_SHA != GIT_SHA) {
          versionUpdateIcon.removeClass("d-none")
          versionLink.style.color = "crimson"
        }
      }
      delay(30000)
    }
  }
}

suspend fun getStorageEstimate(): StorageEstimate? {
  return try {
    (window.navigator.asDynamic().storage?.estimate() as? Promise<StorageEstimate>)?.await()
  } catch (e: Throwable) {
    null
  }
}

external class StorageEstimate {
  val quota: Int
  val usage: Int
}

@Serializable
data class VersionInfo(
    val MAVEN_GROUP: String,
    val MAVEN_NAME: String,
    val VERSION: String,
    val GIT_REVISION: Int,
    val GIT_SHA: String,
    val GIT_DATE: String,
    val GIT_BRANCH: String,
    val BUILD_DATE: String,
    val BUILD_UNIX_TIME: Long,
    val DIRTY: Int,
)

suspend fun getLiveVersionInfo(): VersionInfo? {
  return try {
    val yaml = fetch("/version.yaml").await().text().await()
    loadYamlDeserialize(yaml)
  } catch (e: Throwable) {
    null
  }
}
