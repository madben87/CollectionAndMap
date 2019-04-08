package com.kvadgroup.collectionandmap.ui.main

import com.kvadgroup.collectionandmap.core.Presenter

interface MainPresenter<V : MainView> : Presenter<V> {

    fun calculate(size: Int)
}