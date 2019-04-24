package com.falin.valentin.approvetestapplication.presenter

import com.falin.valentin.approvetestapplication.view.MainActivity

class Presenter(
    var coins: Int = 0
) {
    lateinit var context: MainActivity

    fun buttonClicked(reward: Int) {
        coins += reward
        context.updateCoinsCounterAndShowInfo(reward)
    }
}