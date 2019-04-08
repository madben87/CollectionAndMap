package com.kvadgroup.collectionandmap.core

import com.kvadgroup.collectionandmap.data.CollectionOperation

interface CalculateView : MVPView {

    fun calculate(size: Int)

    fun drawResult(operation: CollectionOperation)
}