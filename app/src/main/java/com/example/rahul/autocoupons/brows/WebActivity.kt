package com.example.rahul.autocoupons.brows

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.rahul.autocoupons.R
import kotlinx.android.synthetic.main.activity_web.*
import com.example.rahul.autocoupons.data.Site
import kotlinx.android.synthetic.main.content_web.*
import android.webkit.*


class WebActivity : AppCompatActivity(), WebContract.View {

    private lateinit var mPresenter: WebContract.Presenter
    private lateinit var site: Site

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        setSupportActionBar(toolbar)
        site = intent.getSerializableExtra("site") as Site
        mPresenter = WebPresenter(this, this, site)
        configureWebView()
        webView.loadUrl(site.url)
        fab.setOnClickListener {
            mPresenter.fetchCoupons()
            webView.loadUrl(site.actions!!.getTotalPrice)
        }
    }

    private fun configureWebView() {
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = AutoCouponWebClient()
        webView.addJavascriptInterface(AutoCouponInterface(), "AutoCoupon")
    }


    class AutoCouponWebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView, url: String?) {
            super.onPageFinished(view, url)
        }
    }

    class AutoCouponInterface{
        @JavascriptInterface
        public fun parseData(str:String){
            Log.d("Total price",str)
        }
    }
}