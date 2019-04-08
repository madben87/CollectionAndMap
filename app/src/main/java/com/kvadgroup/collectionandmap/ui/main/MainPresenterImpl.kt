package com.kvadgroup.collectionandmap.ui.main

import com.kvadgroup.collectionandmap.core.CalculateView

object MainPresenterImpl : MainPresenter<MainView> {

    private var view: MainView? = null

    override fun attachView(v: MainView) {
        view = v
    }

    override fun detachView() {
        view = null
    }

    override fun calculate(size: Int) {
        if (view?.getCurrentPage() is CalculateView) {
            (view?.getCurrentPage() as CalculateView).calculate(size)
        }
    }
}