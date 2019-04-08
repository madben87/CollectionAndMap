package com.kvadgroup.collectionandmap.data

import com.kvadgroup.collectionandmap.listeners.ProgressListener

interface CalculationManager {

    fun calculate(size: Int, listener: ProgressListener)
}