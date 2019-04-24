package com.falin.valentin.approvetestapplication.Callbacks

import com.appodeal.ads.RewardedVideoCallbacks
import com.falin.valentin.approvetestapplication.presenter.Presenter

class RewardCallback(
    val presenter: Presenter
) : RewardedVideoCallbacks {

    override fun onRewardedVideoFinished(amount: Double, name: String?) {
        presenter.buttonClicked(amount.toInt() + 10)
    }

    override fun onRewardedVideoClosed(p0: Boolean) {
    }

    override fun onRewardedVideoExpired() {
    }

    override fun onRewardedVideoLoaded(p0: Boolean) {
    }

    override fun onRewardedVideoFailedToLoad() {
    }

    override fun onRewardedVideoShown() {
    }
}