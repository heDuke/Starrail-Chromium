package com.starrail.wear.engine

import android.content.Context
import android.view.View
import android.widget.FrameLayout

data class BrowserSnapshot(
    val url: String = "",
    val loading: Boolean = false,
    val canGoBack: Boolean = false,
    val error: String? = null,
)

/** Embedder boundary. A Chromium implementation must supply the rendering view. */
interface BrowserEngine {
    fun createView(context: Context): View
    fun observe(observer: (BrowserSnapshot) -> Unit)
    fun loadUrl(url: String)
    fun goBack()
    fun reload()
    fun pause()
    fun resume()
    fun destroy()
}

/** Explicit development fallback; this does not load or render webpages. */
class UnavailableBrowserEngine : BrowserEngine {
    private var snapshot = BrowserSnapshot()
    private var observer: ((BrowserSnapshot) -> Unit)? = null
    override fun createView(context: Context): View = FrameLayout(context)
    override fun observe(observer: (BrowserSnapshot) -> Unit) {
        this.observer = observer
        observer(snapshot)
    }
    override fun loadUrl(url: String) {
        snapshot = BrowserSnapshot(url = url, error = "浏览功能尚未可用")
        observer?.invoke(snapshot)
    }
    override fun goBack() = Unit
    override fun reload() = loadUrl(snapshot.url)
    override fun pause() = Unit
    override fun resume() = Unit
    override fun destroy() { observer = null }
}
