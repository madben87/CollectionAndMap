package com.kvadgroup.collectionandmap.ui.collection

import com.kvadgroup.collectionandmap.core.CalculateView
import com.kvadgroup.collectionandmap.core.Presenter

interface CollectionPresenter<V: CalculateView> : Presenter<V> {

    fun calculate(size: Int)
}