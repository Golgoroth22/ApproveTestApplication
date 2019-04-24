package com.falin.valentin.approvetestapplication.Callbacks

import com.appodeal.ads.InterstitialCallbacks
import com.falin.valentin.approvetestapplication.presenter.Presenter

class InterstitialCallback(
    val presenter: Presenter
) : InterstitialCallbacks {

    override fun onInterstitialLoaded(isPrecache: Boolean) {
    }

    override fun onInterstitialShown() {
    }

    override fun onInterstitialClicked() {
    }

    override fun onInterstitialFailedToLoad() {
    }

    override fun onInterstitialClosed() {
        presenter.buttonClicked(5)
    }

    override fun onInterstitialExpired() {
    }
}