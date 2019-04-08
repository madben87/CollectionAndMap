package com.kvadgroup.collectionandmap.ui.collection

import com.kvadgroup.collectionandmap.core.CalculateView
import com.kvadgroup.collectionandmap.data.CalculationManager
import com.kvadgroup.collectionandmap.data.CalculationManagerImpl
import com.kvadgroup.collectionandmap.data.CollectionOperation
import com.kvadgroup.collectionandmap.listeners.ProgressListener

object CollectionPresenterImpl : CollectionPresenter<CalculateView>, ProgressListener {

    private var view: CalculateView? = null
    private val cacheResults = mutableListOf<CollectionOperation>()
    private var manager: CalculationManager? = null

    init {
        manager = CalculationManagerImpl()
    }

    override fun attachView(v: CalculateView) {
        view = v
    }

    override fun detachView() {
        view = null
    }

    override fun calculate(size: Int) {
        manager?.calculate(size, this)
    }

    override fun postResult(operation: CollectionOperation) {
        view?.drawResult(operation) ?: cacheResults.add(operation)
    }
}