package com.falin.valentin.approvetestapplication.view

import android.os.Bundle
import android.view.View
import com.appodeal.ads.Appodeal
import com.falin.valentin.approvetestapplication.Callbacks.InterstitialCallback
import com.falin.valentin.approvetestapplication.Callbacks.RewardCallback
import com.falin.valentin.approvetestapplication.R
import com.falin.valentin.approvetestapplication.presenter.Presenter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class MainActivity : BaseActivity(), CoroutineScope {
    companion object {
        val presenter = Presenter()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.context = this
        setSupportActionBar(toolbar)
        updateCoinsCounterAndShowInfo()
        setListeners()
        setAppodeal()
    }

    private fun setAppodeal() {
        Appodeal.setBannerViewId(R.id.activity_main_appodeal_banner)

        val appKey = "1beaba26aeebfd6a5045d37a00f1d89014d79a89c3c15cda";
        Appodeal.initialize(
            this,
            appKey,
            Appodeal.INTERSTITIAL or Appodeal.REWARDED_VIDEO or Appodeal.BANNER or Appodeal.NATIVE or Appodeal.MREC,
            true
        )

        Appodeal.show(this, Appodeal.BANNER_VIEW)

        val videoCallback = RewardCallback(presenter)
        val interstialCallback = InterstitialCallback(presenter)
        Appodeal.setRewardedVideoCallbacks(videoCallback)
        Appodeal.setInterstitialCallbacks(interstialCallback)
    }

    override fun onResume() {
        super.onResume()
        Appodeal.onResume(this, Appodeal.BANNER);
    }

    private fun setListeners() {
        activity_main_linear_button_first.setOnClickListener {
            if (Appodeal.isLoaded(Appodeal.REWARDED_VIDEO)) {
                Appodeal.show(this, Appodeal.REWARDED_VIDEO)
                it.isEnabled = false.apply { startDelay(60, it) }
            }
        }
        activity_main_linear_button_second.setOnClickListener {
            if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {
                Appodeal.show(this, Appodeal.INTERSTITIAL)
                it.isEnabled = false.apply { startDelay(30, it) }
            }
        }
        activity_main_linear_button_third.setOnClickListener {
            if (Appodeal.isLoaded(Appodeal.NON_SKIPPABLE_VIDEO)) {
                Appodeal.show(this, Appodeal.NON_SKIPPABLE_VIDEO)
                it.isEnabled = false.apply { startDelay(50, it) }
            }
        }
        activity_main_linear_button_fourth.setOnClickListener {
            presenter.buttonClicked(5)
            it.isEnabled = false.apply { startDelay(10, it) }
        }
        activity_main_coins_icon.setOnClickListener {
            activity_main_subtext.visibility = View.VISIBLE.apply {
                launch {
                    delay(5000)
                    activity_main_subtext.visibility = View.GONE
                }
            }
        }
        info_card_close_image.setOnClickListener { activity_main_info_card.visibility = View.GONE }
    }

    fun startDelay(timeDelay: Int, view: View) = launch {
        delay(1000L * timeDelay)
        view.isEnabled = true
    }

    fun updateCoinsCounterAndShowInfo(reward: Int = 0) {
        activity_main_coins_counter.text = "${presenter.coins}"
        info_card_text.text = "Ты получил $reward монет!"
        if (reward != 0) activity_main_info_card.visibility = View.VISIBLE
    }
}
