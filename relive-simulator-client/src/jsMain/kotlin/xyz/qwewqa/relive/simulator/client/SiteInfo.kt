package xyz.qwewqa.relive.simulator.client

import kotlin.js.Promise
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.w3c.dom.HTMLDivElement
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
      kotlinx.coroutines.delay(10000)
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
